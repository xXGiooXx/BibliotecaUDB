/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author JONATHAN G
 */
public class DevolucionDAO {

    private final String SQL_SELECT_PRESTAMO = "SELECT p.id_prestamo, m.id_material, m.codigo, m.titulo, p.cantidad, DATE_FORMAT(p.fecha_prestamo, '%d/%m/%Y') AS fecha_prestamo, DATE_FORMAT(p.fecha_devolucion, '%d/%m/%Y') AS fecha_devolucion FROM prestamo p INNER JOIN materiales m ON p.id_material = m.id_material";
    private final String SQL_SELECT_DEVOLUCION = "SELECT id_devolucion, id_prestamo, DATE_FORMAT(fecha_prestamo, '%d/%m/%Y')AS fecha_prestamo, DATE_FORMAT(fecha_devolucion, '%d/%m/%Y') AS fecha_devolucion, observaciones, mora, cantidad FROM devoluciones ";
    private final String SQL_INSERT_DEVOLUCION = "INSERT INTO devoluciones(id_prestamo, fecha_prestamo, fecha_devolucion, observaciones, mora, cantidad) VALUES(?,STR_TO_DATE(?, '%d/%m/%Y'),STR_TO_DATE(?, '%d/%m/%Y'),?,?,?)";
    private final String SQL_UPDATE_DEVOLUCION = "UPDATE devoluciones SET id_prestamo=?, fecha_prestamo= STR_TO_DATE(?, '%d/%m/%Y'), fecha_devolucion= STR_TO_DATE(?, '%d/%m/%Y'), observaciones=? WHERE id_devolucion=?";
    private final String SQL_DELETE_PRESTAMO = "DELETE FROM prestamo WHERE id_prestamo=?";
    private final String SQL_UPDATE_MATERIAL = "UPDATE materiales SET unidades_disponible = unidades_disponible + ? WHERE id_material = ?";
   
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

    public DefaultTableModel selectDevolucion() {
        DefaultTableModel dtm = new DefaultTableModel();
        Connection con = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            con = Conexion.getConnection();
            stmt = con.prepareStatement(SQL_SELECT_DEVOLUCION);
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

    public int registrarDevolucion(Devolucion devolucion) {
        Connection con = null;
        PreparedStatement stmtInsert = null;
        PreparedStatement stmtDelete = null;
        PreparedStatement stmtUpdate = null;
        ResultSet rs = null;
        int rowsInsert = 0;
        int rowsDelete = 0;

        try {
            con = Conexion.getConnection();
            con.setAutoCommit(false); // Desactivar el modo de autocommit

            // 1. Insertar devolucion 
            stmtInsert = con.prepareStatement(SQL_INSERT_DEVOLUCION);
            stmtInsert.setInt(1, devolucion.getId_prestamo());
            stmtInsert.setString(2, devolucion.getFecha_prestamo());
            stmtInsert.setString(3, devolucion.getFecha_devolucion());
            stmtInsert.setString(4, devolucion.getObservacion());
            stmtInsert.setDouble(5, devolucion.getMora());
            stmtInsert.setInt(6, devolucion.getCantidad_devolucion());            
            rowsInsert = stmtInsert.executeUpdate();

            // 2. Se reintegra la cantidad a material disponible
            if (rowsInsert > 0) {
                stmtUpdate = con.prepareStatement(SQL_UPDATE_MATERIAL);          
                stmtUpdate.setInt(1, devolucion.getCantidad_devolucion());
                stmtUpdate.setInt(2, obtenerIdMaterial(devolucion.getId_prestamo()));
                stmtUpdate.executeUpdate();

            }
            // 3. Eliminar el prestamo
            if (rowsInsert > 0) {
                stmtDelete = con.prepareStatement(SQL_DELETE_PRESTAMO);
                stmtDelete.setInt(1, devolucion.getId_prestamo());
                rowsDelete = stmtDelete.executeUpdate();
            }

            // Si ambos pasos fueron exitosos, confirmar la transacción
            if (rowsInsert > 0 && rowsDelete > 0) {
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
            Conexion.close(stmtDelete);            
            Conexion.close(con);
        }

        return rowsInsert; // Devolver el número de filas insertadas en prestamo
    }

    public int modificarDevolucion(Devolucion devolucion) {
        Connection con = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        int rows = 0;
        try {
            con = Conexion.getConnection();
            stmt = con.prepareStatement(SQL_UPDATE_DEVOLUCION);
            stmt.setInt(1, devolucion.getId_prestamo());
            stmt.setString(2, devolucion.getFecha_prestamo());
            stmt.setString(3, devolucion.getFecha_devolucion());
            stmt.setString(4, devolucion.getObservacion());
            stmt.setInt(5, devolucion.getId_devolucion());
            rows = stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            Conexion.close(rs);
            Conexion.close(stmt);
            Conexion.close(con);
        }
        return rows;
    }
    
    public int obtenerIdMaterial(int idmodificado) {
        Connection con = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        String SQL_ID_MATERIAL = "SELECT id_material FROM prestamo WHERE id_prestamo = ?";
        int id = 0;
        try {
            con = Conexion.getConnection();
            stmt = con.prepareStatement(SQL_ID_MATERIAL);
            stmt.setInt(1, idmodificado);
            rs = stmt.executeQuery();
            if(rs.last()){
                id = rs.getInt(1);
            }         
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            Conexion.close(rs);
            Conexion.close(stmt);
            Conexion.close(con);
        }
        return id;
    }
}
