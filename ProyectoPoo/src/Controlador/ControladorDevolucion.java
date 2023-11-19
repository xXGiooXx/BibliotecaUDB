/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.Devolucion;
import Modelo.DevolucionDAO;
import Vista.DevolucionForm;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import javax.swing.JOptionPane;

/**
 *
 * @author JONATHAN G
 */
public class ControladorDevolucion implements ActionListener {

    DevolucionDAO devolucionDao;
    DevolucionForm devolucionForm;
    Devolucion devolucion = new Devolucion();

    public ControladorDevolucion(DevolucionForm devolucionForm, DevolucionDAO devolucionDao) {
        this.devolucionForm = devolucionForm;
        this.devolucionDao = devolucionDao;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == devolucionForm.btn_devolucion) {

            devolucion.setId_prestamo(Integer.parseInt(devolucionForm.txt_idPrestamo.getText()));
            devolucion.setFecha_prestamo(devolucionForm.jformat_fechaPrestamo.getText());
            devolucion.setFecha_devolucion(devolucionForm.jformat_fechaDevolucion.getText());
            devolucion.setObservacion(devolucionForm.textArea_observacion.getText());
            devolucion.setCantidad_devolucion(Integer.parseInt(devolucionForm.txt_Cantidad.getText()));
            DateTimeFormatter formatoFecha = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            LocalDate fechaPrestamo = LocalDate.parse(devolucionForm.jformat_fechaPrestamo.getText(), formatoFecha);
            LocalDate fechaDevolucion = LocalDate.parse(devolucionForm.jformat_fechaDevolucion.getText(), formatoFecha);
            LocalDate fechaActual = LocalDate.now();

            // Calcular días entre fecha préstamo y fecha devolución 
            long diasPrestamoDevolucion = ChronoUnit.DAYS.between(fechaPrestamo, fechaDevolucion);

            // Calcular días entre fecha préstamo y fecha actual
            long diasPrestamoActual = ChronoUnit.DAYS.between(fechaDevolucion, fechaActual);
            if (diasPrestamoActual <= diasPrestamoDevolucion) {
                devolucion.setMora(0);
            // Si pasó fecha devolución, calcular mora  
            } else {              
                double mora = diasPrestamoActual * 0.25; //0.25 por día
                devolucion.setMora(mora);
            }

            if ((devolucionDao.registrarDevolucion(devolucion) >= 1)) {

                JOptionPane.showMessageDialog(null, "Registro Guardado exitosamente");
            } else {
                JOptionPane.showMessageDialog(null, "Error al Guardar ");
            }
            devolucionForm.Limpiar();
            devolucionForm.Table_prestamo.setModel(devolucionDao.selectPrestamo());
            devolucionForm.table_devolucion.setModel(devolucionDao.selectDevolucion());

        }

        if (e.getSource() == devolucionForm.btn_modificar) {
            devolucion.setId_devolucion(Integer.parseInt(devolucionForm.txt_idDevolucion.getText()));
            devolucion.setId_prestamo(Integer.parseInt(devolucionForm.txt_idPrestamo.getText()));
            devolucion.setFecha_prestamo(devolucionForm.jformat_fechaPrestamo.getText());
            devolucion.setFecha_devolucion(devolucionForm.jformat_fechaDevolucion.getText());
            devolucion.setObservacion(devolucionForm.textArea_observacion.getText());
            devolucion.setCantidad_devolucion(Integer.parseInt(devolucionForm.txt_Cantidad.getText()));
            if ((devolucionDao.modificarDevolucion(devolucion) >= 1)) {

                JOptionPane.showMessageDialog(null, "Registro Modificado exitosamente");

            } else {
                JOptionPane.showMessageDialog(null, "Error al Modificar ");
            }
            devolucionForm.Limpiar();
            devolucionForm.Table_prestamo.setModel(devolucionDao.selectPrestamo());
            devolucionForm.table_devolucion.setModel(devolucionDao.selectDevolucion());

        }

        if (e.getActionCommand().equals("Limpiar")) {
            devolucionForm.Limpiar();
            devolucionForm.Table_prestamo.setModel(devolucionDao.selectPrestamo());
            devolucionForm.table_devolucion.setModel(devolucionDao.selectDevolucion());
        }

    }

}
