/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.DatosSesion;
import Vista.CdForm;
import Vista.DevolucionForm;
import Vista.PrestamoForm;
import Vista.UsuarioForm;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;


/**
 *
 * @author JONATHAN G
 */
public class ControladorMenu implements ActionListener {

    UsuarioForm usuarioForm;
    CdForm cdForm;
    PrestamoForm prestamoForm;
    DevolucionForm devolucionForm;

    public ControladorMenu() {
        usuarioForm = new UsuarioForm(); //SE INSTANCIA Y SE INICIALIZA EL FORMULARIO PARA MANIPULAS LOS EVENTOS Y ACCIONES
        cdForm = new CdForm();
        prestamoForm = new PrestamoForm();
        devolucionForm = new DevolucionForm();
    }

    

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("Gestionar_Usuarios")) {           
            usuarioForm.setVisible(true); //SE MUESTRA LA VENTANA USUARIOFORM AL DAR CLICK EN GESTIONAR USUARIOS

        }
        if (e.getActionCommand().equals("CDS")) {
            cdForm.setVisible(true); //SE MUESTRA LA VENTANA CD FORM AL DAR CLICK EN CDS

        }     
        if (e.getActionCommand().equals("Prestamos")) {
            prestamoForm.setVisible(true);
        }
        if(e.getActionCommand().equals("Devoluciones")){           
            devolucionForm.setVisible(true);          
        }
        if (e.getActionCommand().equals("Salir")) {
            System.exit(0);
        }
        

    }

}
