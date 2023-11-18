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

    private final String SQL_AUTENTICACION = "SELECT  id_usuario, id_rol, usuario, contrasena FROM usuarios WHERE usuario=? AND contrasena=?";
    Connection con;
    PreparedStatement stmt;
    ResultSet rs;

    public boolean autenticacion(DatosSesion datos ) {
     
        try {
            con = Conexion.getConnection();
            stmt = con.prepareStatement(SQL_AUTENTICACION);
            stmt.setString(1, datos.getUsuario_sesion());
            stmt.setString(2, datos.getContrasena_sesion());
            rs = stmt.executeQuery();
            while (rs.next()) {
                datos.setId_usuario_sesion(rs.getString(1));
                datos.setId_rol_usuario_sesion(rs.getString(2));
                datos.setUsuario_sesion(rs.getString(3));
                datos.setContrasena_sesion(rs.getString(4));                           
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
