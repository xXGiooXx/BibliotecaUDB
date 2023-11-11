/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.Validacion_login;
import Modelo.Usuario;
import Vista.Login;
import Vista.Menu;
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
    Menu menu = new Menu();

    public ControladorLogin(Usuario usuario, Validacion_login modeloLogin, Login vistaLogin) {
        this.usuario = usuario;
        this.modeloLogin = modeloLogin;
        this.vistaLogin = vistaLogin;
        
        this.vistaLogin.btn_iniciar_sesion.addActionListener(this);
    }
    
    public void iniciarSesion(){
        String user = vistaLogin.txt_usuario.getText();
        String pass = vistaLogin.txt_contrasena.getText();
        
        if(modeloLogin.autenticacion(user, pass) > -1){ //SI EL METODO modeloLogin trae un id_rol Mostrar el menu que le corresponda
            JOptionPane.showMessageDialog(null, "Inicio sesion exitosamente");
            if(modeloLogin.autenticacion(user, pass) == 1){ // SI IGUAL A 1 MOSTRARA MENU ADMINISTRATIVO 
                vistaLogin.dispose();
                menu.setVisible(true);
                
            }
            else if(modeloLogin.autenticacion(user, pass)== 2){// SI IGUAL A 2 MOSTRARA MENU PARA ALUMNOS 
                vistaLogin.dispose();
                menu.setVisible(true);
                menu.menu_gestionar_material.setVisible(false);
                menu.menu_usuarios.setVisible(false);
                
            }
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
