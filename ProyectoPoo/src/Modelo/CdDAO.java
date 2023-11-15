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
public class CdDAO {

    private final String SQL_SELECT = "SELECT c.id_cd, c.id_material, m.id_usuario, m.id_categoria, c.artista, c.genero, c.duracion, c.num_canciones, m.codigo, m.titulo, m.unidades_disponible  FROM cds c INNER JOIN materiales m WHERE c.id_material = m.id_material";
    private final String SQL_INSERT_MATERIAL = "INSERT INTO materiales(id_usuario, id_categoria, codigo, titulo, unidades_disponible) VALUES(?,?,?,?,?)";
    private final String SQL_INSERT_CD = "INSERT INTO cds(id_material, artista, genero, duracion, num_canciones) VALUES(?,?,?,?,?)";
    private final String SQL_UPDATE_MATERIAL = "UPDATE materiales SET id_usuario=?, id_categoria=?, codigo=?, titulo=?, unidades_disponible=? WHERE id_material=?";
    private final String SQL_UPDATE_CD = "UPDATE cds SET id_material=?, artista=?, genero=?, duracion=?, num_canciones=? WHERE id_cd=?";
    private final String SQL_DELETE_MATERIAL = "DELETE FROM materiales WHERE id_material=?";
    private final String SQL_DELETE_CD = "DELETE FROM cds WHERE id_cd=?";
    private final String SQL_LAST_ID_MATERIAL = "SELECT LAST_INSERT_ID() from materiales";

    public DefaultTableModel selectCds() {
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

    public int registrarMaterial(Cd cd) {
        Connection con = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        int rows = 0;
        try {
            con = Conexion.getConnection();
            stmt = con.prepareStatement(SQL_INSERT_MATERIAL);
            stmt.setInt(1, cd.getId_usuario());
            stmt.setInt(2, cd.getId_categoria());
            stmt.setString(3, cd.getCodigo());
            stmt.setString(4, cd.getTitulo());
            stmt.setInt(5, cd.getUnidades_disponible());
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

    public int registrarCd(Cd cd) {
        Connection con = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        int rows = 0;
        try {
            con = Conexion.getConnection();
            stmt = con.prepareStatement(SQL_INSERT_CD);
            stmt.setInt(1, idMaterial());
            stmt.setString(2, cd.getArtista());
            stmt.setString(3, cd.getGenero());
            stmt.setString(4, cd.getDuracion());
            stmt.setInt(5, cd.getNum_canciones());
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

    public int modificarMaterial(Cd cd) {
        Connection con = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        int rows = 0;
        try {
            con = Conexion.getConnection();
            stmt = con.prepareStatement(SQL_UPDATE_MATERIAL);
            stmt.setInt(1, cd.getId_usuario());
            stmt.setInt(2, cd.getId_categoria());
            stmt.setString(3, cd.getCodigo());
            stmt.setString(4, cd.getTitulo());
            stmt.setInt(5, cd.getUnidades_disponible());
            stmt.setInt(6, cd.getId_material());
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
    
    public int modificarCd(Cd cd) {
        Connection con = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        int rows = 0;
        try {
            con = Conexion.getConnection();
            stmt = con.prepareStatement(SQL_UPDATE_CD);
            stmt.setInt(1, cd.getId_usuario());
            stmt.setInt(2, cd.getId_categoria());
            stmt.setString(3, cd.getCodigo());
            stmt.setString(4, cd.getTitulo());
            stmt.setInt(5, cd.getUnidades_disponible());
            stmt.setInt(6, cd.getId_cd());
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
    
    public int eliminarMaterial(Cd cd){
        Connection con = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        int rows = 0;
         try {
            con = Conexion.getConnection();
            stmt = con.prepareStatement(SQL_DELETE_MATERIAL);                 
            stmt.setInt(1, cd.getId_material());
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
    
    public int eliminarCd(Cd cd){
        Connection con = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        int rows = 0;
         try {
            con = Conexion.getConnection();
            stmt = con.prepareStatement(SQL_DELETE_CD);                 
            stmt.setInt(1, cd.getId_cd());
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

    public int idMaterial() {
        Connection con = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        int id = 0;
        try {
            con = Conexion.getConnection();
            stmt = con.prepareStatement(SQL_LAST_ID_MATERIAL);
            rs = stmt.executeQuery();
            id = rs.getRow();
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
