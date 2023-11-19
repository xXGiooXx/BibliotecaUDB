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

// * @author Grupo 5

public class DvdDAO {
    
  

    private final String SQL_SELECT = "SELECT d.id_dvd, d.id_material, m.id_categoria,d.director, d.duracion, d.genero, m.codigo, m.titulo, m.unidades_disponible  FROM dvds d INNER JOIN materiales m WHERE d.id_material = m.id_material";
    private final String SQL_INSERT_MATERIAL = "INSERT INTO materiales(id_categoria, codigo, titulo, unidades_disponible) VALUES(?,?,?,?)";
    private final String SQL_INSERT_DVD = "INSERT INTO dvds(id_material, director, duracion, genero) VALUES(?,?,?,?)";
    private final String SQL_UPDATE_MATERIAL = "UPDATE materiales SET id_categoria=?, codigo=?, titulo=?, unidades_disponible=? WHERE id_material=?";
    private final String SQL_UPDATE_DVD = "UPDATE dvds SET id_material=?, director=?, duracion=?, genero=? WHERE id_dvd=?";
    private final String SQL_DELETE_MATERIAL = "DELETE FROM materiales WHERE id_material=?";
    private final String SQL_DELETE_DVD = "DELETE FROM dvds WHERE id_dvd=?";
    private final String SQL_LAST_ID_MATERIAL = "SELECT LAST_INSERT_ID(id_material) from materiales";
    private final String SQL_LAST_ID_UPDATE_MATERIAL = "SELECT LAST_INSERT_ID(id_material) from materiales WHERE id_material = ?";
    

    public DefaultTableModel selectdvds() {
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

    public int registrarMaterial(Dvd dvd) {
        Connection con = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        int rows = 0;
        try {
            con = Conexion.getConnection();
            stmt = con.prepareStatement(SQL_INSERT_MATERIAL);
            stmt.setInt(1, dvd.getId_categoria());
            stmt.setString(2, dvd.getCodigo());
            stmt.setString(3, dvd.getTitulo());
            stmt.setInt(4, dvd.getUnidades_disponible());
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

    public int registrarDvd(Dvd dvd) {
        Connection con = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        int rows = 0;
        try {
            con = Conexion.getConnection();
            stmt = con.prepareStatement(SQL_INSERT_DVD);
            stmt.setInt(1, ultimoIdMaterialInsertado());
            stmt.setString(2, dvd.getDirector());
            stmt.setString(3, dvd.getDuracion());
             stmt.setString(4, dvd.getGenero());
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

    public int modificarMaterial(Dvd dvd) {
        Connection con = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        int rows = 0;
        try {
            con = Conexion.getConnection();
            stmt = con.prepareStatement(SQL_UPDATE_MATERIAL);
            stmt.setInt(1, dvd.getId_categoria());
            stmt.setString(2, dvd.getCodigo());
            stmt.setString(3, dvd.getTitulo());
            stmt.setInt(4, dvd.getUnidades_disponible());
            stmt.setInt(5, dvd.getId_material());
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
    
    public int modificarDvd(Dvd dvd) {
        Connection con = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        int rows = 0;
        try {
            con = Conexion.getConnection();
            stmt = con.prepareStatement(SQL_UPDATE_DVD);
            stmt.setInt(1, ultimoIdMaterialModificado(dvd.getId_material()));
            stmt.setString(2, dvd.getDirector());
            stmt.setString(3, dvd.getDuracion());
            stmt.setString(4, dvd.getGenero());
            stmt.setInt(5, dvd.getId_dvd());
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
    
     public int eliminarDvd(Dvd dvd){
        Connection con = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        int rows = 0;
         try {
            con = Conexion.getConnection();
            stmt = con.prepareStatement(SQL_DELETE_DVD);                 
            stmt.setInt(1, dvd.getId_dvd());
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
   
    public int eliminarMaterial(Dvd dvd){
        Connection con = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        int rows = 0;
         try {
            con = Conexion.getConnection();
            stmt = con.prepareStatement(SQL_DELETE_MATERIAL);                 
            stmt.setInt(1, dvd.getId_material());
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

