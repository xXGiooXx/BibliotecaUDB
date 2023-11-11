/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.Usuario;
import Modelo.UsuarioDAO;
import Vista.Menu;
import Vista.UsuarioPanel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author JONATHAN G
 */
public class ControladorUsuario implements ActionListener{
    Usuario usuario = new Usuario();
    UsuarioDAO usuarioDao = new UsuarioDAO();
    UsuarioPanel panel = new UsuarioPanel();
    Menu menu = new Menu();

    public ControladorUsuario(Usuario usuario, UsuarioDAO usuarioDAO, UsuarioPanel panel, Menu menu) {
        this.usuario = usuario;
        this.usuarioDao = usuarioDAO;
        this.panel = panel;
        this.menu = menu;
        
        this.menu.menu_usuario_gestionar.addActionListener(this);
    }
    
    
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == menu.menu_usuario_gestionar){
            panel.setVisible(true);
        }
    }
    
}
