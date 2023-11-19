/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.Usuario;
import Modelo.UsuarioDAO;
import Modelo.Validacion_entrada;
import Vista.UsuarioForm;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;


/**
 *
 * @author Grupo 5
 */
public class ControladorUsuario implements ActionListener {

    UsuarioForm usuarioForm;
    UsuarioDAO usuarioDao = new UsuarioDAO();
    Usuario usuario = new Usuario();

    public ControladorUsuario(UsuarioForm usuarioForm, UsuarioDAO usuarioDao) {
        this.usuarioForm = usuarioForm;
        this.usuarioDao = usuarioDao;
    }

    @Override
    public void actionPerformed(ActionEvent e) {

       if (e.getSource() == usuarioForm.btn_agregar_usuario) {
             String txtRol = usuarioForm.txt_rol.getText();
        if (!txtRol.isEmpty()) {
            try {
                usuario.setId_rol(Integer.parseInt(txtRol));
            } catch (NumberFormatException ex) {  // Cambiar "e" por "ex" u otro nombre si ya se ha declarado "e" en este método
                JOptionPane.showMessageDialog(null, "Error: El campo de rol debe ser un número entero");
                return; // Evitar continuar con el proceso si hay errores
            }
        } else {
            JOptionPane.showMessageDialog(null, "Error: El campo de rol está vacío");
            return; // Evitar continuar con el proceso si hay errores
        }
            usuario.setNombres(usuarioForm.txt_nombres_usuario.getText());
            usuario.setApellidos(usuarioForm.txt_apellidos_usuario.getText());
            usuario.setUsuario(usuarioForm.txt_usuario.getText());
            usuario.setContrasena(usuarioForm.txt_contrasena.getText());

            if (usuarioDao.registrarUsuario(usuario) >= 1) {
                JOptionPane.showMessageDialog(null, "Registro Guardado exitosamente");
            } else {
                JOptionPane.showMessageDialog(null, "Error al Guardar ");
            }
            usuarioForm.Limpiar();
            usuarioForm.Tabla_usuarios.setModel(usuarioDao.selectUsuarios());

        }
        
            if (e.getSource() == usuarioForm.btn_modificar_usuario) {
                     // Valida que los campos Nombres y Apellidos no estén vacíos
    if (usuarioForm.txt_nombres_usuario.getText().isEmpty() || usuarioForm.txt_apellidos_usuario.getText().isEmpty()|| usuarioForm.txt_rol.getText().isEmpty()|| usuarioForm.txt_usuario.getText().isEmpty()|| usuarioForm.txt_contrasena.getText().isEmpty()) {
        JOptionPane.showMessageDialog(null, "Los campos no pueden estar vacíos");
        return;
    }

    // Valida que el campo Nombres solo contenga caracteres alfabéticos
    if (!Validacion_entrada.validarNombre(usuarioForm.txt_nombres_usuario.getText())||!Validacion_entrada.validarNombre(usuarioForm.txt_apellidos_usuario.getText())) {
        JOptionPane.showMessageDialog(null, "El campo Nombres y Apellidos solo puede contener caracteres alfabéticos");
        return;
    }

    // Valida que el campo Rol solo contenga números
    if (!Validacion_entrada.validarRol(usuarioForm.txt_rol.getText())) {
        JOptionPane.showMessageDialog(null, "El campo Rol solo puede contener números");
        return;
    }

                   usuario.setId_usuario(Integer.parseInt(usuarioForm.txt_id_usuario.getText()));
                   usuario.setId_rol(Integer.parseInt(usuarioForm.txt_rol.getText()));
                   usuario.setNombres(usuarioForm.txt_nombres_usuario.getText());
                   usuario.setApellidos(usuarioForm.txt_apellidos_usuario.getText());
                   usuario.setUsuario(usuarioForm.txt_usuario.getText());
                   usuario.setContrasena(usuarioForm.txt_contrasena.getText());

                   if (usuarioDao.modificarUsuario(usuario) >= 1) {
                       JOptionPane.showMessageDialog(null, "Registro Modificado exitosamente");
                   } else {
                       JOptionPane.showMessageDialog(null, "Error al Modificar ");
                   }
                   usuarioForm.Limpiar();
                   usuarioForm.Tabla_usuarios.setModel(usuarioDao.selectUsuarios());

               }
  
        
            if (e.getSource() == usuarioForm.btn_eliminar_usuario) {
                usuario.setId_usuario(Integer.parseInt(usuarioForm.txt_id_usuario.getText()));
                if (usuarioDao.eliminarUsuario(usuario) >= 1) {
                    JOptionPane.showMessageDialog(null, "Registro Eliminado exitosamente");
                } else {
                    JOptionPane.showMessageDialog(null, "Error al Eliminar ");
                }
                usuarioForm.Limpiar();
                usuarioForm.Tabla_usuarios.setModel(usuarioDao.selectUsuarios());

            }
        

        if (e.getActionCommand().equals("Limpiar_usuario")) {
            usuarioForm.Limpiar();         
        }

    }

}
