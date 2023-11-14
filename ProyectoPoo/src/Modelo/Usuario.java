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
public class Usuario {
    private int id_usuario;
    private int id_rol;
    private String nombres;
    private String apellidos;
    private String usuario;
    private String contrasena;

    //CONSTRUCTOR VACIO
    public Usuario() { 
    }
    //CONSTRUCTOR PARAMETRIZADO                 
    public Usuario(int id_usuario, int id_rol, String nombres, String apellidos, String usuario, String contrasena) {
        this.id_usuario = id_usuario;
        this.id_rol = id_rol;
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.usuario = usuario;
        this.contrasena = contrasena;
    }

    public int getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(int id_usuario) {
        this.id_usuario = id_usuario;
    }

    public int getId_rol() {
        return id_rol;
    }

    public void setId_rol(int id_rol) {
        this.id_rol = id_rol;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }
    
    
    
    
}
