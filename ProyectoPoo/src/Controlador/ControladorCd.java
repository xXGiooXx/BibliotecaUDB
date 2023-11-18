/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.Cd;
import Modelo.CdDAO;
import Vista.CdForm;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

/**
 *
 * @author JONATHAN G
 */
public class ControladorCd implements ActionListener {

    CdForm cdForm;
    CdDAO cdDao = new CdDAO();
    Cd cd = new Cd();

    public ControladorCd(CdForm cdForm, CdDAO cdDao) {
        this.cdForm = cdForm;
        this.cdDao = cdDao;
    }

    ControladorCd() {
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == cdForm.btn_agregarCd) {

            cd.setId_categoria(Integer.parseInt(cdForm.txt_idCategoria.getText()));
            cd.setArtista(cdForm.txt_artista.getText());
            cd.setGenero(cdForm.txt_genero.getText());
            cd.setDuracion(cdForm.txt_duracion.getText());
            cd.setNum_canciones(Integer.parseInt(cdForm.txt_numCanciones.getText()));
            cd.setCodigo(cdForm.txt_codigo.getText());
            cd.setTitulo(cdForm.txt_titulo.getText());
            cd.setUnidades_disponible((int) cdForm.sp_unidadesDisponibles.getValue());
            if ((cdDao.registrarMaterial(cd) >= 1) && (cdDao.registrarCd(cd) >= 1)) {

                JOptionPane.showMessageDialog(null, "Registro Guardado exitosamente");
            } else {
                JOptionPane.showMessageDialog(null, "Error al Guardar ");
            }
            cdForm.Limpiar();
            cdForm.tabla_cd.setModel(cdDao.selectCds());

        }

        if (e.getSource() == cdForm.btn_modificarCd) {
            cd.setId_cd(Integer.parseInt(cdForm.txt_idCd.getText()));
            cd.setId_material(Integer.parseInt(cdForm.txt_idMaterial.getText()));

            cd.setId_categoria(Integer.parseInt(cdForm.txt_idCategoria.getText()));
            cd.setArtista(cdForm.txt_artista.getText());
            cd.setGenero(cdForm.txt_genero.getText());
            cd.setDuracion(cdForm.txt_duracion.getText());
            cd.setNum_canciones(Integer.parseInt(cdForm.txt_numCanciones.getText()));
            cd.setCodigo(cdForm.txt_codigo.getText());
            cd.setTitulo(cdForm.txt_titulo.getText());
            cd.setUnidades_disponible(Integer.parseInt(cdForm.sp_unidadesDisponibles.getValue().toString()));

            if ((cdDao.modificarMaterial(cd) >= 1)) {
                if ((cdDao.modificarCd(cd) >= 1)) {
                    JOptionPane.showMessageDialog(null, "Registro Modificado exitosamente");
                } else {
                    JOptionPane.showMessageDialog(null, "Error al Modificar ");
                }
            } else {
                JOptionPane.showMessageDialog(null, "Error al Modificar ");
            }
            cdForm.Limpiar();
            cdForm.tabla_cd.setModel(cdDao.selectCds());

        }

        if (e.getSource() == cdForm.btn_eliminarCd) {
            cd.setId_material(Integer.parseInt(cdForm.txt_idMaterial.getText()));
            cd.setId_cd(Integer.parseInt(cdForm.txt_idCd.getText()));
            if ((cdDao.eliminarCd(cd) >= 1)) {
                if ((cdDao.eliminarMaterial(cd) >= 1)) {
                    JOptionPane.showMessageDialog(null, "Registro Eliminado exitosamente");
                } else {
                    JOptionPane.showMessageDialog(null, "Error al Eliminar ");
                }
            } else {
                JOptionPane.showMessageDialog(null, "Error al Eliminar ");
            }
            cdForm.Limpiar();
            cdForm.tabla_cd.setModel(cdDao.selectCds());

        }

        if (e.getActionCommand().equals("Limpiar")) {
            cdForm.Limpiar();
        }
    }

}
