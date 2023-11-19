/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

import Controlador.ControladorLogin;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import javax.swing.table.DefaultTableModel;


/**
 *
 * @author Carlos Hernandez
 */
public class RevistaDAO {
    
  

    private final String SQL_SELECT = "SELECT r.id_revista, r.id_material, m.id_categoria, r.editorial, r.periodicidad,DATE_FORMAT(r.fecha_publicacion, '%d/%m/%Y'), m.codigo , m.titulo, m.unidades_disponible  FROM revistas r INNER JOIN materiales m WHERE r.id_material = m.id_material";
    private final String SQL_INSERT_MATERIAL = "INSERT INTO materiales(id_categoria, codigo, titulo, unidades_disponible) VALUES(?,?,?,?)";
    private final String SQL_INSERT_REVISTAS = "INSERT INTO revistas(id_material, editorial, periodicidad, fecha_publicacion) VALUES(?,?,?,STR_TO_DATE(?, '%d/%m/%Y'))";
    private final String SQL_UPDATE_MATERIAL = "UPDATE materiales SET id_categoria=?, codigo=?, titulo=?, unidades_disponible=? WHERE id_material=?";
    private final String SQL_UPDATE_REVISTAS = "UPDATE revistas SET id_material=?, editorial=?, periodicidad=?, fecha_publicacion=STR_TO_DATE(?, '%d/%m/%Y') WHERE id_revista=?";
    private final String SQL_DELETE_MATERIAL = "DELETE FROM materiales WHERE id_material=?";
    private final String SQL_DELETE_REVISTAS = "DELETE FROM revistas WHERE id_revista=?";
    private final String SQL_LAST_ID_MATERIAL = "SELECT LAST_INSERT_ID(id_material) from materiales";
    private final String SQL_LAST_ID_UPDATE_MATERIAL = "SELECT LAST_INSERT_ID(id_material) from materiales WHERE id_material = ?";
    

    public DefaultTableModel selectRevistas() {
        DefaultTableModel dtm = new DefaultTableModel();
        Connection con = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            con = Conexion.getConnection();
            stmt = con.prepareStatement(SQL_SELECT);
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

    public int registrarMaterial(Revista revista) {
        Connection con = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        int rows = 0;
        try {
            con = Conexion.getConnection();
            stmt = con.prepareStatement(SQL_INSERT_MATERIAL);
            stmt.setInt(1, revista.getId_categoria());
            stmt.setString(2, revista.getCodigo());
            stmt.setString(3, revista.getTitulo());
            stmt.setInt(4, revista.getUnidades_disponible());
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

    public int registrarRevistas(Revista revista) {
        Connection con = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        int rows = 0;
        try {
            con = Conexion.getConnection();
            stmt = con.prepareStatement(SQL_INSERT_REVISTAS);
            stmt.setInt(1, ultimoIdMaterialInsertado());
            stmt.setString(2, revista.getEditorial());
            stmt.setInt(3, revista.getPeriodicidad());
            stmt.setString(4, revista.getFecha_publicacion());
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

    public int modificarMaterial(Revista revista) {
        Connection con = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        int rows = 0;
        try {
            con = Conexion.getConnection();
            stmt = con.prepareStatement(SQL_UPDATE_MATERIAL);
            stmt.setInt(1, revista.getId_categoria());
            stmt.setString(2, revista.getCodigo());
            stmt.setString(3, revista.getTitulo());
            stmt.setInt(4, revista.getUnidades_disponible());
            stmt.setInt(5, revista.getId_material());
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
    
    public int modificarRevistas(Revista revista) {
        Connection con = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        int rows = 0;
        try {
            con = Conexion.getConnection();
            stmt = con.prepareStatement(SQL_UPDATE_REVISTAS);
            stmt.setInt(1, ultimoIdMaterialModificado(revista.getId_material()));
            stmt.setString(2, revista.getEditorial());
            stmt.setInt(3, revista.getPeriodicidad());
            stmt.setString(4, revista.getFecha_publicacion());
            stmt.setInt(5, revista.getId_revista());
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
    
     public int eliminarRevistas(Revista revista){
        Connection con = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        int rows = 0;
         try {
            con = Conexion.getConnection();
            stmt = con.prepareStatement(SQL_DELETE_REVISTAS);                 
            stmt.setInt(1, revista.getId_revista());
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
   
    public int eliminarMaterial(Revista revista){
        Connection con = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        int rows = 0;
         try {
            con = Conexion.getConnection();
            stmt = con.prepareStatement(SQL_DELETE_MATERIAL);                 
            stmt.setInt(1, revista.getId_material());
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
    

    public int ultimoIdMaterialInsertado() {
        Connection con = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        int id = 0;
        try {
            con = Conexion.getConnection();
            stmt = con.prepareStatement(SQL_LAST_ID_MATERIAL);
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
    
     public int ultimoIdMaterialModificado(int idmodificado) {
        Connection con = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        int id = 0;
        try {
            con = Conexion.getConnection();
            stmt = con.prepareStatement(SQL_LAST_ID_UPDATE_MATERIAL);
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


