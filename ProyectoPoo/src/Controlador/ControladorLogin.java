/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.Validacion_login;
import Modelo.Usuario;
import Vista.Login;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

/**
 *
 * @author JONATHAN G
 */
public class ControladorLogin implements ActionListener{
    Usuario usuario = new Usuario();
    Validacion_login modeloLogin = new Validacion_login();
    Login vistaLogin = new Login();

    public ControladorLogin(Usuario usuario, Validacion_login modeloLogin, Login vistaLogin) {
        this.usuario = usuario;
        this.modeloLogin = modeloLogin;
        this.vistaLogin = vistaLogin;
        
        this.vistaLogin.btn_iniciar_sesion.addActionListener(this);
    }
    
    public void iniciarSesion(){
        String user = vistaLogin.txt_usuario.getText();
        String pass = vistaLogin.txt_contrasena.getText();
        
        if(modeloLogin.autenticacion(user, pass)){
            JOptionPane.showMessageDialog(null, "Inicio sesion exitosamente");
        }
        else{
            JOptionPane.showMessageDialog(null, "Error al iniciar sesion");
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
       if(e.getSource()== vistaLogin.btn_iniciar_sesion){
           iniciarSesion();
       }
    }
    
    
}
