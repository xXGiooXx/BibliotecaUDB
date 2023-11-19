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
 * @author GRUPO 5
 */
public class LibroDAO {
    
    
    private final String SQL_SELECT = "SELECT l.id_libro, l.id_material, m.id_categoria, l.autor, l.num_paginas, l.editorial, l.isbn, l.anio_publicacion, m.codigo, m.titulo, m.unidades_disponible FROM libros l INNER JOIN materiales m ON l.id_material = m.id_material;";
    private final String SQL_INSERT_MATERIAL = "INSERT INTO materiales(id_categoria, codigo, titulo, unidades_disponible) VALUES(?,?,?,?)";
    private final String SQL_INSERT_LIBROS = "INSERT INTO libros(id_material, autor, num_paginas, editorial, isbn, anio_publicacion) VALUES(?,?,?,?,?,?)";
    private final String SQL_UPDATE_MATERIAL = "UPDATE materiales SET id_categoria=?, codigo=?, titulo=?, unidades_disponible=? WHERE id_material=?";
    private final String SQL_UPDATE_LIBROS = "UPDATE libros SET id_material=?, autor=?, num_paginas=?, editorial=?, isbn=?, anio_publicacion=?) WHERE id_libro=?";
    private final String SQL_DELETE_MATERIAL = "DELETE FROM materiales WHERE id_material=?";
    private final String SQL_DELETE_LIBROS = "DELETE FROM libros WHERE id_libro=?";
    private final String SQL_LAST_ID_MATERIAL = "SELECT LAST_INSERT_ID(id_material) from materiales";
    private final String SQL_LAST_ID_UPDATE_MATERIAL = "SELECT LAST_INSERT_ID(id_material) from materiales WHERE id_material = ?";
    

    public DefaultTableModel selectlibros() {
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

    public int registrarMaterial(Libros libros) {
        Connection con = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        int rows = 0;
        try {
            con = Conexion.getConnection();
            stmt = con.prepareStatement(SQL_INSERT_MATERIAL);
            stmt.setInt(1, libros.getId_categoria());
            stmt.setString(2, libros.getCodigo());
            stmt.setString(3, libros.getTitulo());
            stmt.setInt(4, libros.getUnidades_disponible());
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

    public int registrarlibros(Libros libros) {
        Connection con = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        int rows = 0;
        try {
            con = Conexion.getConnection();
            stmt = con.prepareStatement(SQL_INSERT_LIBROS);
            stmt.setInt(1, ultimoIdMaterialInsertado());
            stmt.setString(2, libros.getAutor());
            stmt.setInt(3, libros.getNum_paginas());
            stmt.setString(4, libros.getEditorial());
            stmt.setInt(5, libros.getIsbn());
            stmt.setInt(6,libros.getAnio_publicacion());
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

    public int modificarMaterial(Libros libros) {
        Connection con = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        int rows = 0;
        try {
            con = Conexion.getConnection();
            stmt = con.prepareStatement(SQL_UPDATE_MATERIAL);
            stmt.setInt(1, libros.getId_categoria());
            stmt.setString(2, libros.getCodigo());
            stmt.setString(3, libros.getTitulo());
            stmt.setInt(4, libros.getUnidades_disponible());
            stmt.setInt(5, libros.getId_material());
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
    
    public int modificarlibro(Libros libros) {
        Connection con = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        int rows = 0;
        try {
            con = Conexion.getConnection();
            stmt = con.prepareStatement(SQL_UPDATE_LIBROS);
            stmt.setInt(1, ultimoIdMaterialModificado(libros.getId_material()));
            stmt.setString(2, libros.getAutor());
            stmt.setInt(3, libros.getNum_paginas());
            stmt.setString(4, libros.getEditorial());
            stmt.setInt(5, libros.getIsbn());
            stmt.setInt(6,libros.getAnio_publicacion());
            stmt.setInt(7, libros.getId_libro());
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
    
     public int eliminarlibros(Libros libros){
        Connection con = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        int rows = 0;
         try {
            con = Conexion.getConnection();
            stmt = con.prepareStatement(SQL_DELETE_LIBROS);                 
            stmt.setInt(1, libros.getId_libro());
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
   
    public int eliminarMaterial(Libros libros){
        Connection con = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        int rows = 0;
         try {
            con = Conexion.getConnection();
            stmt = con.prepareStatement(SQL_DELETE_MATERIAL);                 
            stmt.setInt(1, libros.getId_material());
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

