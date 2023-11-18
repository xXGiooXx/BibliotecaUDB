/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author JONATHAN G
 */
public class PrestamoDAO {

    private final String SQL_SELECT_MATERIAL_DISPONIBLE = "SELECT c.id_cd AS ID, m.id_material AS MATERIAL , m.id_categoria AS ID_CATEGORIA, m.codigo AS CODIGO, m.titulo AS TITULO, m.unidades_disponible AS UDNIDADES_DISPONIBLE\n"
            + "FROM cds c\n"
            + "INNER JOIN materiales m ON c.id_material = m.id_material\n"
            + "UNION\n"
            + "SELECT d.id_dvd, m.id_material, m.id_categoria, m.codigo, m.titulo, m.unidades_disponible\n"
            + "FROM dvds d\n"
            + "INNER JOIN materiales m ON d.id_material = m.id_material\n"
            + "UNION\n"
            + "SELECT l.id_libro, m.id_material, m.id_categoria, m.codigo, m.titulo, m.unidades_disponible\n"
            + "FROM libros l\n"
            + "INNER JOIN materiales m ON l.id_material = m.id_material\n"
            + "UNION\n"
            + "SELECT r.id_revista, m.id_material, m.id_categoria, m.codigo, m.titulo, m.unidades_disponible\n"
            + "FROM revistas r\n"
            + "INNER JOIN materiales m ON r.id_material = m.id_material;";
    private final String SQL_UPDATE_CANTIDAD_MATERIAL = "UPDATE materiales SET unidades_disponible = unidades_disponible - ? WHERE id_material = ?";
    private final String SQL_SELECT_PRESTAMO = "SELECT p.id_prestamo, m.id_material, m.codigo, m.titulo, p.cantidad, DATE_FORMAT(p.fecha_prestamo, '%d/%m/%Y') AS fecha_prestamo, DATE_FORMAT(p.fecha_devolucion, '%d/%m/%Y') AS fecha_devolucion FROM prestamo p INNER JOIN materiales m ON p.id_material = m.id_material";
    private final String SQL_INSERT_PRESTAMO = "INSERT INTO prestamo (id_material, fecha_prestamo, fecha_devolucion, cantidad) VALUES (?, STR_TO_DATE(?, '%d/%m/%Y'), STR_TO_DATE(?, '%d/%m/%Y'), ?)";
    private final String SQL_UPDATE_PRESTAMO = "UPDATE prestamo SET id_material=?, fecha_prestamo= STR_TO_DATE(?, '%d/%m/%Y'), fecha_devolucion= STR_TO_DATE(?, '%d/%m/%Y'), cantidad=? WHERE id_prestamo=?";

    public DefaultTableModel selectMaterial() {
        DefaultTableModel dtm = new DefaultTableModel();
        Connection con = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            con = Conexion.getConnection();
            stmt = con.prepareStatement(SQL_SELECT_MATERIAL_DISPONIBLE);
            rs = stmt.executeQuery();
            ResultSetMetaData meta = rs.getMetaData();
            for (int i = 1; i <= meta.getColumnCount(); i++) {
                dtm.addColumn(meta.getColumnLabel(i));
            }
            while (rs.next()) {
                Object[] fila = new Object[meta.getColumnCount()];
                for (int i = 0; i < meta.getColumnCount(); i++) {
                    fila[i] = rs.getObject(i + 1);
                }
                dtm.addRow(fila);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            Conexion.close(rs);
            Conexion.close(stmt);
            Conexion.close(con);
        }
        return dtm;
    }

    public DefaultTableModel selectPrestamo() {
        DefaultTableModel dtm = new DefaultTableModel();
        Connection con = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            con = Conexion.getConnection();
            stmt = con.prepareStatement(SQL_SELECT_PRESTAMO);
            rs = stmt.executeQuery();
            ResultSetMetaData meta = rs.getMetaData();
            for (int i = 1; i <= meta.getColumnCount(); i++) {
                dtm.addColumn(meta.getColumnLabel(i));
            }
            while (rs.next()) {
                Object[] fila = new Object[meta.getColumnCount()];
                for (int i = 0; i < meta.getColumnCount(); i++) {
                    fila[i] = rs.getObject(i + 1);
                }
                dtm.addRow(fila);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            Conexion.close(rs);
            Conexion.close(stmt);
            Conexion.close(con);
        }
        return dtm;
    }

    public int registrarPrestamo(Prestamo prestamo) {
        Connection con = null;
        PreparedStatement stmtInsert = null;
        PreparedStatement stmtUpdate = null;
        ResultSet rs = null;
        int rowsInsert = 0;
        int rowsUpdate = 0;

        try {
            con = Conexion.getConnection();
            con.setAutoCommit(false); // Desactivar el modo de autocommit

            // 1. Insertar el préstamo en la tabla `prestamo`
            stmtInsert = con.prepareStatement(SQL_INSERT_PRESTAMO);
            stmtInsert.setInt(1, prestamo.getId_material());
            stmtInsert.setString(2, prestamo.getFecha_prestamo());
            stmtInsert.setString(3, prestamo.getFecha_devolucion());
            stmtInsert.setInt(4, prestamo.getCantidad());
            rowsInsert = stmtInsert.executeUpdate();

            // 2. Actualizar las unidades disponibles en la tabla `materiales`
            if (rowsInsert > 0) {
                stmtUpdate = con.prepareStatement(SQL_UPDATE_CANTIDAD_MATERIAL);
                stmtUpdate.setInt(1, prestamo.getCantidad());
                stmtUpdate.setInt(2, prestamo.getId_material());
                rowsUpdate = stmtUpdate.executeUpdate();
            }
            // Si ambos pasos fueron exitosos, confirmar la transacción
            if (rowsInsert > 0 && rowsUpdate > 0) {
                con.commit();
            } else {
                // Si algo falla, hacer rollback
                con.rollback();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            Conexion.close(rs);
            Conexion.close(stmtInsert);
            Conexion.close(stmtUpdate);
            Conexion.close(con);
        }

        return rowsInsert; // Devolver el número de filas insertadas en prestamo
    }

    public int modificarPrestamo(Prestamo prestamo) {
        Connection con = null;
        PreparedStatement stmtUpdatePrestamo = null;
        PreparedStatement stmtUpdateCantidadMaterial = null;
        ResultSet rs = null;
        int rowsUpdatePrestamo = 0;
        int rowsUpdateCantidadMaterial = 0;

        try {
            con = Conexion.getConnection();
            con.setAutoCommit(false);

            // 1. Obtener la cantidad original del préstamo antes de la actualización
            int cantidadOriginal = CantidadDisponibleMaterial(prestamo.getId_prestamo());

            // 2. Calcular la diferencia entre la cantidad original y la nueva cantidad
            int diferenciaCantidad = prestamo.getCantidad() - cantidadOriginal;

            // 3. Actualizar el préstamo en la tabla `prestamo`
            stmtUpdatePrestamo = con.prepareStatement(SQL_UPDATE_PRESTAMO);
            stmtUpdatePrestamo.setInt(1, prestamo.getId_material());
            stmtUpdatePrestamo.setString(2, prestamo.getFecha_prestamo());
            stmtUpdatePrestamo.setString(3, prestamo.getFecha_devolucion());
            stmtUpdatePrestamo.setInt(4, prestamo.getCantidad());
            stmtUpdatePrestamo.setInt(5, prestamo.getId_prestamo());
            rowsUpdatePrestamo = stmtUpdatePrestamo.executeUpdate();

            // 4. Actualizar las unidades disponibles en la tabla `materiales`
            if (rowsUpdatePrestamo > 0) {
                stmtUpdateCantidadMaterial = con.prepareStatement(SQL_UPDATE_CANTIDAD_MATERIAL);

                // Si la cantidad de préstamo aumenta
                if (diferenciaCantidad > 0) {
                    stmtUpdateCantidadMaterial.setInt(1, diferenciaCantidad);
                } else { // Si la cantidad de préstamo disminuye
                    // Asegurarse de no decrementar la cantidad disponible
                    int nuevaCantidadDisponible = CantidadDisponibleMaterial(prestamo.getId_material()) + Math.abs(diferenciaCantidad);
                    stmtUpdateCantidadMaterial.setInt(1, nuevaCantidadDisponible);
                }

                stmtUpdateCantidadMaterial.setInt(2, prestamo.getId_material());
                rowsUpdateCantidadMaterial = stmtUpdateCantidadMaterial.executeUpdate();
            }

            // Si ambas operaciones fueron exitosas, confirmar la transacción
            if (rowsUpdatePrestamo > 0 && rowsUpdateCantidadMaterial > 0) {
                con.commit();
            } else {
                // Si algo falla, hacer rollback
                con.rollback();
            }
        } catch (SQLException e) {
            e.printStackTrace();
            // Puedes manejar la excepción de manera específica o relanzarla
        } finally {
            Conexion.close(rs);
            Conexion.close(stmtUpdatePrestamo);
            Conexion.close(stmtUpdateCantidadMaterial);
            Conexion.close(con);
        }

        return rowsUpdatePrestamo; // Devolver el número de filas actualizadas en prestamo
    }

    private int CantidadDisponibleMaterial(int idMaterial) {
        Connection con = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        // Método auxiliar para obtener la cantidad disponible de un material
        String sql = "SELECT unidades_disponible FROM materiales WHERE id_material = ?";
        try {
            con = Conexion.getConnection();
            stmt = con.prepareStatement(sql);
            stmt.setInt(1, idMaterial);
            rs = stmt.executeQuery();
            if (rs.next()) {
                return rs.getInt("unidades_disponible");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            Conexion.close(rs);
            Conexion.close(stmt);
            Conexion.close(con);
        }
        return 0; // Devolver 0 si no se encuentra el material
    }

}
