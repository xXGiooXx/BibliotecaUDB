/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Vista.Menu;
import Vista.UsuarioForm;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

/**
 *
 * @author JONATHAN G
 */
public class ControladorMenu implements ActionListener{
    UsuarioForm usuarioForm;
    public ControladorMenu() {
        usuarioForm = new UsuarioForm(); //SE INSTANCIA Y SE INICIALIZA EL FORMULARIO PARA MANIPULAS LOS EVENTOS Y ACCIONES
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getActionCommand().equals("Gestionar_Usuarios")){
            usuarioForm.setVisible(true); //SE MUESTRA LA VENTANA USUARIOFORM AL DAR CLICK EN GESTIONAR USUARIOS
        }
        if(e.getActionCommand().equals("Salir")){
            System.exit(0);
        }
        
        
    }
    
}
