/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

/**
 *
 * @author JONATHAN G
 */
public class DatosSesion {
    private String id_usuario_sesion;
    private String id_rol_usuario_sesion;
    private String usuario_sesion;
    private String contrasena_sesion;

    public DatosSesion() {
    }

    public DatosSesion(String id_usuario_sesion, String id_rol_usuario_sesion, String usuario_sesion, String contrasena_sesion) {
        this.id_usuario_sesion = id_usuario_sesion;
        this.id_rol_usuario_sesion = id_rol_usuario_sesion;
        this.usuario_sesion = usuario_sesion;
        this.contrasena_sesion = contrasena_sesion;
    }

    public String getId_usuario_sesion() {
        return id_usuario_sesion;
    }

    public void setId_usuario_sesion(String id_usuario_sesion) {
        this.id_usuario_sesion = id_usuario_sesion;
    }

    public String getId_rol_usuario_sesion() {
        return id_rol_usuario_sesion;
    }

    public void setId_rol_usuario_sesion(String id_rol_usuario_sesion) {
        this.id_rol_usuario_sesion = id_rol_usuario_sesion;
    }

    public String getUsuario_sesion() {
        return usuario_sesion;
    }

    public void setUsuario_sesion(String usuario_sesion) {
        this.usuario_sesion = usuario_sesion;
    }

    public String getContrasena_sesion() {
        return contrasena_sesion;
    }

    public void setContrasena_sesion(String contrasena_sesion) {
        this.contrasena_sesion = contrasena_sesion;
    }

   

    
    
}
