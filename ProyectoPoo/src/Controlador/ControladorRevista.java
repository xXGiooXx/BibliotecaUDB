/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;
import Modelo.Revista;
import Modelo.RevistaDAO;
import Vista.RevistaForm;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import javax.swing.JOptionPane;


/**
 *
 * @author Carlos Hernandez
 */
public class ControladorRevista implements ActionListener {
    
 RevistaForm revistaForm;
    RevistaDAO revistaDao = new RevistaDAO();
    Revista revista = new Revista();

    public ControladorRevista(RevistaForm revistaForm, RevistaDAO revistaDao) {
        this.revistaForm = revistaForm;
        this.revistaDao = revistaDao;
    }

    ControladorRevista() {
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == revistaForm.btn_agregarRevista) {
            if (revistaForm.txt_idCategoria.getText().isEmpty()) {
                JOptionPane.showMessageDialog(null, "El campo Categoría no puede estar vacío");
                return;
            }
            if (Integer.parseInt(revistaForm.txt_idCategoria.getText())!=2) {
                JOptionPane.showMessageDialog(null, "El campo id Categoría no puede ser distinto de 2");
                return;
            }
            if (revistaForm.txt_editorial.getText().isEmpty()) {
                JOptionPane.showMessageDialog(null, "El campo Editorial no puede estar vacío");
                return;
            }
            if (revistaForm.txt_periodicidad.getText().isEmpty()) {
                JOptionPane.showMessageDialog(null, "El campo Periocidad de Pagina no puede estar vacío");
                return;
            }
            if (revistaForm.txt_Fecha_de_publicacion.getText().isEmpty()) {
                JOptionPane.showMessageDialog(null, "El campo Fecha de Publicación no puede estar vacío");
                return;
            }
            if (revistaForm.txt_codigo.getText().isEmpty()) {
                JOptionPane.showMessageDialog(null, "El campo Código no puede estar vacío");
                return;
            }
            if (revistaForm.txt_titulo.getText().isEmpty()) {
                JOptionPane.showMessageDialog(null, "El campo Titulo no puede estar vacío");
                return;
            }
            if (revistaForm.sp_unidadesDisponibles.getValue().toString().isEmpty()) {
                JOptionPane.showMessageDialog(null, "El campo Unidades disponibles no puede estar vacío");
                return;
            }
            if ((int) revistaForm.sp_unidadesDisponibles.getValue()< 1) {
                JOptionPane.showMessageDialog(null, "El campo Unidades disponibles no puede ser menor que 1");
                return;
            }
                        
            // Valida que el campo Código tenga 5 caracteres alfanuméricos
            if (!revistaForm.txt_codigo.getText().matches("[a-zA-Z0-9]{5}")) {
                JOptionPane.showMessageDialog(null, "El campo Código debe ser de 5 caracteres alfanuméricos");
                return;
            }            
            revista.setId_categoria(Integer.parseInt(revistaForm.txt_idCategoria.getText()));
            revista.setEditorial(revistaForm.txt_editorial.getText());
            revista.setPeriodicidad(Integer.parseInt(revistaForm.txt_periodicidad.getText()));
            revista.setFecha_publicacion(revistaForm.txt_Fecha_de_publicacion.getText());
            revista.setCodigo(revistaForm.txt_codigo.getText());
            revista.setTitulo(revistaForm.txt_titulo.getText());
            revista.setUnidades_disponible((int) revistaForm.sp_unidadesDisponibles.getValue());
            if ((revistaDao.registrarMaterial(revista) >= 1) && (revistaDao.registrarRevistas(revista) >= 1)) {

                JOptionPane.showMessageDialog(null, "Registro Guardado exitosamente");
            } else {
                JOptionPane.showMessageDialog(null, "Error al Guardar ");
            }
            revistaForm.Limpiar();
            revistaForm.tabla_Revista.setModel(revistaDao.selectRevistas());

        }

        if (e.getSource() == revistaForm.btn_modificarRevista) {
            if (revistaForm.txt_idCategoria.getText().isEmpty()) {
                JOptionPane.showMessageDialog(null, "El campo Categoría no puede estar vacío");
                return;
            }
            if (Integer.parseInt(revistaForm.txt_idCategoria.getText())!=2) {
                JOptionPane.showMessageDialog(null, "El campo id Categoría no puede ser distinto de 2");
                return;
            }
            if (revistaForm.txt_editorial.getText().isEmpty()) {
                JOptionPane.showMessageDialog(null, "El campo Editorial no puede estar vacío");
                return;
            }
            if (revistaForm.txt_periodicidad.getText().isEmpty()) {
                JOptionPane.showMessageDialog(null, "El campo Periocidad de Pagina no puede estar vacío");
                return;
            }
            if (revistaForm.txt_Fecha_de_publicacion.getText().isEmpty()) {
                JOptionPane.showMessageDialog(null, "El campo Fecha de Publicación no puede estar vacío");
                return;
            }
            if (revistaForm.txt_codigo.getText().isEmpty()) {
                JOptionPane.showMessageDialog(null, "El campo Código no puede estar vacío");
                return;
            }
            if (revistaForm.txt_titulo.getText().isEmpty()) {
                JOptionPane.showMessageDialog(null, "El campo Titulo no puede estar vacío");
                return;
            }
            if (revistaForm.sp_unidadesDisponibles.getValue().toString().isEmpty()) {
                JOptionPane.showMessageDialog(null, "El campo Unidades disponibles no puede estar vacío");
                return;
            }
             if ((int) revistaForm.sp_unidadesDisponibles.getValue()< 1) {
                JOptionPane.showMessageDialog(null, "El campo Unidades disponibles no puede ser menor que 1");
                return;
            }
                        
            // Valida que el campo Código tenga 5 caracteres alfanuméricos
            if (!revistaForm.txt_codigo.getText().matches("[a-zA-Z0-9]{5}")) {
                JOptionPane.showMessageDialog(null, "El campo Código debe ser de 5 caracteres alfanuméricos");
                return;
            }
            revista.setId_revista(Integer.parseInt(revistaForm.txt_idRevista.getText()));
            revista.setId_material(Integer.parseInt(revistaForm.txt_idMaterial.getText()));
            revista.setId_categoria(Integer.parseInt(revistaForm.txt_idCategoria.getText()));
            revista.setEditorial(revistaForm.txt_editorial.getText());
            revista.setPeriodicidad(Integer.parseInt(revistaForm.txt_periodicidad.getText()));
            revista.setFecha_publicacion(revistaForm.txt_Fecha_de_publicacion.getText());
            revista.setCodigo(revistaForm.txt_codigo.getText());
            revista.setTitulo(revistaForm.txt_titulo.getText());
            revista.setUnidades_disponible(Integer.parseInt(revistaForm.sp_unidadesDisponibles.getValue().toString()));

            if ((revistaDao.modificarMaterial(revista) >= 1)) {
                if ((revistaDao.modificarRevistas(revista) >= 1)) {
                    JOptionPane.showMessageDialog(null, "Registro Modificado exitosamente");
                } else {
                    JOptionPane.showMessageDialog(null, "Error al Modificar ");
                }
            } else {
                JOptionPane.showMessageDialog(null, "Error al Modificar ");
            }
            revistaForm.Limpiar();
            revistaForm.tabla_Revista.setModel(revistaDao.selectRevistas());

        }

        if (e.getSource() == revistaForm.btn_eliminarRevista) {
            revista.setId_material(Integer.parseInt(revistaForm.txt_idMaterial.getText()));
            revista.setId_revista(Integer.parseInt(revistaForm.txt_idRevista.getText()));
            if ((revistaDao.eliminarRevistas(revista) >= 1)) {
                if ((revistaDao.eliminarMaterial(revista) >= 1)) {
                    JOptionPane.showMessageDialog(null, "Registro Eliminado exitosamente");
                } else {
                    JOptionPane.showMessageDialog(null, "Error al Eliminar ");
                }
            } else {
                JOptionPane.showMessageDialog(null, "Error al Eliminar ");
            }
            revistaForm.Limpiar();
            revistaForm.tabla_Revista.setModel(revistaDao.selectRevistas());

        }

        if (e.getActionCommand().equals("Limpiar")) {
            revistaForm.Limpiar();
        }
    }

}
