/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.Prestamo;
import Modelo.PrestamoDAO;
import Vista.PrestamoForm;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

/**
 *
 * @author JONATHAN G
 */
public class ControladorPrestamo implements ActionListener {

    PrestamoForm prestamoForm;
    PrestamoDAO prestamoDao;
    Prestamo prestamo = new Prestamo();

    public ControladorPrestamo(PrestamoForm prestamoForm, PrestamoDAO prestamoDao) {
        this.prestamoForm = prestamoForm;
        this.prestamoDao = prestamoDao;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == prestamoForm.btn_crearPrestamo) {

            prestamo.setId_material(Integer.parseInt(prestamoForm.txt_idMaterial.getText()));
            prestamo.setFecha_prestamo(prestamoForm.jformat_fecha_prestamo.getText());
            prestamo.setFecha_devolucion(prestamoForm.jformat_fecha_devolucion.getText());
            prestamo.setCantidad(Integer.parseInt(prestamoForm.jsp_cantidad.getValue().toString()));
            if ((prestamoDao.registrarPrestamo(prestamo) >= 1)) {

                JOptionPane.showMessageDialog(null, "Registro Guardado exitosamente");
            } else {
                JOptionPane.showMessageDialog(null, "Error al Guardar ");
            }
            prestamoForm.Limpiar();
            prestamoForm.table_material_disponible.setModel(prestamoDao.selectMaterial());
            prestamoForm.table_prestamos.setModel(prestamoDao.selectPrestamo());
        }

        if (e.getSource() == prestamoForm.btn_modificarPrestamo) {
            prestamo.setId_prestamo(Integer.parseInt(prestamoForm.txt_idPrestamo.getText()));
            prestamo.setId_material(Integer.parseInt(prestamoForm.txt_idMaterial.getText()));
            prestamo.setFecha_prestamo(prestamoForm.jformat_fecha_prestamo.getText());
            prestamo.setFecha_devolucion(prestamoForm.jformat_fecha_devolucion.getText());
            prestamo.setCantidad(Integer.parseInt(prestamoForm.jsp_cantidad.getValue().toString()));
            if ((prestamoDao.modificarPrestamo(prestamo) >= 1)) {

                JOptionPane.showMessageDialog(null, "Registro Modificado exitosamente");

            } else {
                JOptionPane.showMessageDialog(null, "Error al Modificar ");
            }
            prestamoForm.Limpiar();
            prestamoForm.table_material_disponible.setModel(prestamoDao.selectMaterial());
            prestamoForm.table_prestamos.setModel(prestamoDao.selectPrestamo());

        }       

        if (e.getActionCommand().equals("Limpiar")) {
            prestamoForm.Limpiar();
            prestamoForm.table_material_disponible.setModel(prestamoDao.selectMaterial());
            prestamoForm.table_prestamos.setModel(prestamoDao.selectPrestamo());
        }
    }

}
