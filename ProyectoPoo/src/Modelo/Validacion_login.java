/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author JONATHAN G
 */
public class Validacion_login {

    private final String SQL_AUTENTICACION = "SELECT usuario, contrasena FROM usuarios WHERE usuario=? AND contrasena=?";
    Connection con;
    PreparedStatement stmt;
    ResultSet rs;

    public boolean autenticacion(String user, String pass) {
        try {
            con = Conexion.getConnection();
            stmt = con.prepareStatement(SQL_AUTENTICACION);
            stmt.setString(1, user);
            stmt.setString(2, pass);
            rs = stmt.executeQuery();
            while (rs.next()) {
                return true;    
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            Conexion.close(stmt);
            Conexion.close(con);
            Conexion.close(rs);
        }
         return false;
    }
}
