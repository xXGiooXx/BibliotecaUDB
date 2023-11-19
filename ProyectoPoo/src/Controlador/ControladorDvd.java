/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import Modelo.Dvd;
import Modelo.DvdDAO;
import Vista.DvdForm;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

/**
 *
 * @author Carlos Hernandez
 */
public class ControladorDvd implements ActionListener {

    DvdForm dvdForm;
    DvdDAO dvdDao = new DvdDAO();
    Dvd dvd = new Dvd();

    public ControladorDvd(DvdForm dvdForm, DvdDAO dvdDao) {
        this.dvdForm = dvdForm;
        this.dvdDao = dvdDao;
    }

    ControladorDvd() {
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == dvdForm.btn_agregarDvd) {
            if (dvdForm.txt_idCategoria.getText().isEmpty()) {
                JOptionPane.showMessageDialog(null, "El campo Categoría no puede estar vacío");
                return;
            }
             if (Integer.parseInt(dvdForm.txt_idCategoria.getText())!=1) {
                JOptionPane.showMessageDialog(null, "El campo id Categoría no puede ser distinto de 1");
                return;
            }
            if (dvdForm.txt_director.getText().isEmpty()) {
                JOptionPane.showMessageDialog(null, "El campo Director no puede estar vacío");
                return;
            }
            if (dvdForm.txt_genero.getText().isEmpty()) {
                JOptionPane.showMessageDialog(null, "El campo Género no puede estar vacío");
                return;
            }
            if (dvdForm.txt_duracion.getText().isEmpty()) {
                JOptionPane.showMessageDialog(null, "El campo duración no puede estar vacío");
                return;
            }
            if (dvdForm.txt_codigo.getText().isEmpty()) {
                JOptionPane.showMessageDialog(null, "El campo Código no puede estar vacío");
                return;
            }
            if (dvdForm.txt_titulo.getText().isEmpty()) {
                JOptionPane.showMessageDialog(null, "El campo Titulo no puede estar vacío");
                return;
            }
            if (dvdForm.sp_unidadesDisponibles.getValue().toString().isEmpty()) {
                JOptionPane.showMessageDialog(null, "El campo Unidades disponibles no puede estar vacío");
                return;
            }

            if ((int) dvdForm.sp_unidadesDisponibles.getValue()< 1) {
                JOptionPane.showMessageDialog(null, "El campo Unidades disponibles no puede ser menor que 1");
                return;
            }
            // Valida que el campo Código tenga 5 caracteres alfanuméricos
            if (!dvdForm.txt_codigo.getText().matches("[a-zA-Z0-9]{5}")) {
                JOptionPane.showMessageDialog(null, "El campo Código debe ser de 5 caracteres alfanuméricos");
                return;
            }
            dvd.setId_categoria(Integer.parseInt(dvdForm.txt_idCategoria.getText()));
            dvd.setDirector(dvdForm.txt_director.getText());
            dvd.setDuracion(dvdForm.txt_duracion.getText());
            dvd.setGenero(dvdForm.txt_genero.getText());
            dvd.setCodigo(dvdForm.txt_codigo.getText());
            dvd.setTitulo(dvdForm.txt_titulo.getText());
            dvd.setUnidades_disponible((int) dvdForm.sp_unidadesDisponibles.getValue());
            if ((dvdDao.registrarMaterial(dvd) >= 1) && (dvdDao.registrarDvd(dvd) >= 1)) {

                JOptionPane.showMessageDialog(null, "Registro Guardado exitosamente");
            } else {
                JOptionPane.showMessageDialog(null, "Error al Guardar ");
            }
            dvdForm.Limpiar();
            dvdForm.tabla_Dvd.setModel(dvdDao.selectdvds());

        }

        if (e.getSource() == dvdForm.btn_modificarDvd) {
            if (dvdForm.txt_idCategoria.getText().isEmpty()) {
                JOptionPane.showMessageDialog(null, "El campo Categoría no puede estar vacío");
                return;
            }
             if (Integer.parseInt(dvdForm.txt_idCategoria.getText())!=1) {
                JOptionPane.showMessageDialog(null, "El campo id Categoría no puede ser distinto de 1");
                return;
            }
            if (dvdForm.txt_director.getText().isEmpty()) {
                JOptionPane.showMessageDialog(null, "El campo Director no puede estar vacío");
                return;
            }
            if (dvdForm.txt_genero.getText().isEmpty()) {
                JOptionPane.showMessageDialog(null, "El campo Género no puede estar vacío");
                return;
            }
            if (dvdForm.txt_duracion.getText().isEmpty()) {
                JOptionPane.showMessageDialog(null, "El campo duración no puede estar vacío");
                return;
            }
            if (dvdForm.txt_codigo.getText().isEmpty()) {
                JOptionPane.showMessageDialog(null, "El campo Código no puede estar vacío");
                return;
            }
            if (dvdForm.txt_titulo.getText().isEmpty()) {
                JOptionPane.showMessageDialog(null, "El campo Titulo no puede estar vacío");
                return;
            }
            if (dvdForm.sp_unidadesDisponibles.getValue().toString().isEmpty()) {
                JOptionPane.showMessageDialog(null, "El campo Unidades disponibles no puede estar vacío");
                return;
            }

            if ((int) dvdForm.sp_unidadesDisponibles.getValue()< 1) {
                JOptionPane.showMessageDialog(null, "El campo Unidades disponibles no puede ser menor que 1");
                return;
            }
            // Valida que el campo Código tenga 5 caracteres alfanuméricos
            if (!dvdForm.txt_codigo.getText().matches("[a-zA-Z0-9]{5}")) {
                JOptionPane.showMessageDialog(null, "El campo Código debe ser de 5 caracteres alfanuméricos");
                return;
            }
            
            dvd.setId_dvd(Integer.parseInt(dvdForm.txt_idDvd.getText()));
            dvd.setId_material(Integer.parseInt(dvdForm.txt_idMaterial.getText()));

            dvd.setId_categoria(Integer.parseInt(dvdForm.txt_idCategoria.getText()));
            dvd.setDirector(dvdForm.txt_director.getText());
            dvd.setGenero(dvdForm.txt_genero.getText());
            dvd.setDuracion(dvdForm.txt_duracion.getText());
            dvd.setCodigo(dvdForm.txt_codigo.getText());
            dvd.setTitulo(dvdForm.txt_titulo.getText());
            dvd.setUnidades_disponible(Integer.parseInt(dvdForm.sp_unidadesDisponibles.getValue().toString()));

            if ((dvdDao.modificarMaterial(dvd) >= 1)) {
                if ((dvdDao.modificarDvd(dvd) >= 1)) {
                    JOptionPane.showMessageDialog(null, "Registro Modificado exitosamente");
                } else {
                    JOptionPane.showMessageDialog(null, "Error al Modificar ");
                }
            } else {
                JOptionPane.showMessageDialog(null, "Error al Modificar ");
            }
            dvdForm.Limpiar();
            dvdForm.tabla_Dvd.setModel(dvdDao.selectdvds());

        }

        if (e.getSource() == dvdForm.btn_eliminarDvd) {
            dvd.setId_material(Integer.parseInt(dvdForm.txt_idMaterial.getText()));
            dvd.setId_dvd(Integer.parseInt(dvdForm.txt_idDvd.getText()));
            if ((dvdDao.eliminarDvd(dvd) >= 1)) {
                if ((dvdDao.eliminarMaterial(dvd) >= 1)) {
                    JOptionPane.showMessageDialog(null, "Registro Eliminado exitosamente");
                } else {
                    JOptionPane.showMessageDialog(null, "Error al Eliminar ");
                }
            } else {
                JOptionPane.showMessageDialog(null, "Error al Eliminar ");
            }
            dvdForm.Limpiar();
            dvdForm.tabla_Dvd.setModel(dvdDao.selectdvds());

        }

        if (e.getActionCommand().equals("Limpiar")) {
            dvdForm.Limpiar();
        }
    }

}
