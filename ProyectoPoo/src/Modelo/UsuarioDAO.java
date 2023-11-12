/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import Modelo.Conexion;
import Modelo.Usuario;
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
public class UsuarioDAO {

    private final String SQL_SELECT = "SELECT u.id_usuario, r.id_rol, u.nombres, u.apellidos, u.usuario, u.contrasena FROM usuarios u INNER JOIN rol r WHERE u.id_rol = r.id_rol";
    private final String SQL_INSERT = "INSERT INTO usuarios(id_rol, nombres, apellidos, usuario, contrasena) VALUES(?,?,?,?,?)";
    private final String SQL_UPDATE = "UPDATE usuarios SET id_rol=?, nombres=?, apellidos=?, usuario=?, contrasena=? WHERE id_usuario=?";
    private final String SQL_DELETE = "DELETE FROM usuarios WHERE id_usuario=?";
    
    

    public DefaultTableModel selectUsuarios() {
        DefaultTableModel dtm = new DefaultTableModel();
        Connection con = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            con = Conexion.getConnection();
            stmt = con.prepareStatement(SQL_SELECT);
            rs = stmt.executeQuery();
            ResultSetMetaData meta = rs.getMetaData();

//Obteniendo los nombres de encabezado
            for (int i = 1; i <= meta.getColumnCount(); i++) {
                dtm.addColumn(meta.getColumnLabel(i));
            }
//Creando las filas para el JTable
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
    
    public int registrarUsuario(Usuario usuario){
        Connection con = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        int rows = 0;
         try {
            con = Conexion.getConnection();
            stmt = con.prepareStatement(SQL_INSERT);            
            stmt.setInt(1, usuario.getId_rol());
            stmt.setString(2, usuario.getNombres());
            stmt.setString(3, usuario.getApellidos());
            stmt.setString(4, usuario.getUsuario());
            stmt.setString(5, usuario.getContrasena());
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
    
    public int modificarUsuario(Usuario usuario){
        Connection con = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        int rows = 0;
         try {
            con = Conexion.getConnection();
            stmt = con.prepareStatement(SQL_UPDATE);         
            stmt.setInt(1, usuario.getId_rol());
            stmt.setString(2, usuario.getNombres());
            stmt.setString(3, usuario.getApellidos());
            stmt.setString(4, usuario.getUsuario());
            stmt.setString(5, usuario.getContrasena());
            stmt.setInt(6, usuario.getId_usuario());
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
    
    public int eliminarUsuario(Usuario usuario){
        Connection con = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        int rows = 0;
         try {
            con = Conexion.getConnection();
            stmt = con.prepareStatement(SQL_DELETE);                 
            stmt.setInt(1, usuario.getId_usuario());
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
    

}
