/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import Modelo.Libros;
import Modelo.LibroDAO;
import Vista.LibrosForm;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

/**
 *
 * @author Carlos Hernandez
 */
public class ControladorLibros implements ActionListener {

    LibrosForm librosForm;
    LibroDAO libroDao = new LibroDAO();
    Libros libro = new Libros();

    public ControladorLibros(LibrosForm librosForm, LibroDAO libroDao) {
        this.librosForm = librosForm;
        this.libroDao = libroDao;
    }

    ControladorLibros() {
    }

    @Override
    
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == librosForm.btn_agregarLibros) {
            if (librosForm.txt_idCategoria.getText().isEmpty()) {
                JOptionPane.showMessageDialog(null, "El campo Categoría no puede estar vacío");
                return;
            }
            if (Integer.parseInt(librosForm.txt_idCategoria.getText())!=2) {
                JOptionPane.showMessageDialog(null, "El campo id Categoría no puede ser distinto de 2");
                return;
            }
            if (librosForm.txt_autor.getText().isEmpty()) {
                JOptionPane.showMessageDialog(null, "El campo Autor no puede estar vacío");
                return;
            }
            if (librosForm.txt_Numero_de_pagina.getText().isEmpty()) {
                JOptionPane.showMessageDialog(null, "El campo Número de Pagina no puede estar vacío");
                return;
            }
            if (librosForm.txt_Isbn.getText().isEmpty()) {
                JOptionPane.showMessageDialog(null, "El campo ISBN no puede estar vacío");
                return;
            }
            if (librosForm.txt_anio_publicacion.getText().isEmpty()) {
                JOptionPane.showMessageDialog(null, "El campo Año de publicación no puede estar vacío");
                return;
            }
            if (librosForm.txt_titulo.getText().isEmpty()) {
                JOptionPane.showMessageDialog(null, "El campo Titulo no puede estar vacío");
                return;
            }
            if (librosForm.sp_unidadesDisponibles.getValue().toString().isEmpty()) {
                JOptionPane.showMessageDialog(null, "El campo Unidades disponibles no puede estar vacío");
                return;
            }
             if (librosForm.txt_codigo.getText().isEmpty()) {
                JOptionPane.showMessageDialog(null, "El campo Código no puede estar vacío");
                return;
            }
            // Valida que el campo Número de Paginas sea un número entero
            if (!librosForm.txt_Numero_de_pagina.getText().matches("\\d+")||!librosForm.txt_Isbn.getText().matches("\\d+")) {
                JOptionPane.showMessageDialog(null, "El campo Número de Paginas y Isbn debe ser un número entero");
                return;
            }
            if ((int) librosForm.sp_unidadesDisponibles.getValue()< 1) {
                JOptionPane.showMessageDialog(null, "El campo Unidades disponibles no puede ser menor que 1");
                return;
            }
            
            // Valida que el campo Código tenga 5 caracteres alfanuméricos
            if (!librosForm.txt_codigo.getText().matches("[a-zA-Z0-9]{5}")) {
                JOptionPane.showMessageDialog(null, "El campo Código debe ser de 5 caracteres alfanuméricos");
                return;
            }
            libro.setId_categoria(Integer.parseInt(librosForm.txt_idCategoria.getText()));
            libro.setAutor(librosForm.txt_autor.getText());
            libro.setNum_paginas(Integer.parseInt(librosForm.txt_Numero_de_pagina.getText()));
            libro.setEditorial(librosForm.txt_Editorial.getText());
            libro.setIsbn(Integer.parseInt(librosForm.txt_Isbn.getText()));
            libro.setAnio_publicacion(Integer.parseInt(librosForm.txt_anio_publicacion.getText()));
            libro.setCodigo(librosForm.txt_codigo.getText());
            libro.setTitulo(librosForm.txt_titulo.getText());
            libro.setUnidades_disponible((int) librosForm.sp_unidadesDisponibles.getValue());
            if ((libroDao.registrarMaterial(libro) >= 1) && (libroDao.registrarlibros(libro) >= 1)) {

                JOptionPane.showMessageDialog(null, "Registro Guardado exitosamente");
            } else {
                JOptionPane.showMessageDialog(null, "Error al Guardar ");
            }
            librosForm.Limpiar();
            librosForm.tabla_Libros.setModel(libroDao.selectlibros());

        }

        if (e.getSource() == librosForm.btn_modificarLibros) {
            if (librosForm.txt_idCategoria.getText().isEmpty()) {
                JOptionPane.showMessageDialog(null, "El campo Categoría no puede estar vacío");
                return;
            }
            if (Integer.parseInt(librosForm.txt_idCategoria.getText())!=2) {
                JOptionPane.showMessageDialog(null, "El campo id Categoría no puede ser distinto de 2");
                return;
            }
            if (librosForm.txt_autor.getText().isEmpty()) {
                JOptionPane.showMessageDialog(null, "El campo Autor no puede estar vacío");
                return;
            }
            if (librosForm.txt_Numero_de_pagina.getText().isEmpty()) {
                JOptionPane.showMessageDialog(null, "El campo Número de Pagina no puede estar vacío");
                return;
            }
            if (librosForm.txt_Isbn.getText().isEmpty()) {
                JOptionPane.showMessageDialog(null, "El campo ISBN no puede estar vacío");
                return;
            }
            if (librosForm.txt_anio_publicacion.getText().isEmpty()) {
                JOptionPane.showMessageDialog(null, "El campo Año de publicación no puede estar vacío");
                return;
            }
            if (librosForm.txt_titulo.getText().isEmpty()) {
                JOptionPane.showMessageDialog(null, "El campo Titulo no puede estar vacío");
                return;
            }
            if (librosForm.sp_unidadesDisponibles.getValue().toString().isEmpty()) {
                JOptionPane.showMessageDialog(null, "El campo Unidades disponibles no puede estar vacío");
                return;
            }
             if (librosForm.txt_codigo.getText().isEmpty()) {
                JOptionPane.showMessageDialog(null, "El campo Código no puede estar vacío");
                return;
            }
            // Valida que el campo Número de Paginas sea un número entero
            if (!librosForm.txt_Numero_de_pagina.getText().matches("\\d+")||!librosForm.txt_Isbn.getText().matches("\\d+")) {
                JOptionPane.showMessageDialog(null, "El campo Número de Paginas y Isbn debe ser un número entero");
                return;
            }
            if ((int) librosForm.sp_unidadesDisponibles.getValue()< 1) {
                JOptionPane.showMessageDialog(null, "El campo Unidades disponibles no puede ser menor que 1");
                return;
            }
            // Valida que el campo Código tenga 5 caracteres alfanuméricos
            if (!librosForm.txt_codigo.getText().matches("[a-zA-Z0-9]{5}")) {
                JOptionPane.showMessageDialog(null, "El campo Código debe ser de 5 caracteres alfanuméricos");
                return;
            }
            
            libro.setId_libro(Integer.parseInt(librosForm.txt_idLibros.getText()));
            libro.setId_material(Integer.parseInt(librosForm.txt_idMaterial.getText()));
            libro.setId_categoria(Integer.parseInt(librosForm.txt_idCategoria.getText()));
            libro.setAutor(librosForm.txt_autor.getText());
            libro.setEditorial(librosForm.txt_Editorial.getText());
            libro.setNum_paginas(Integer.parseInt(librosForm.txt_Numero_de_pagina.getText()));
            libro.setIsbn(Integer.parseInt(librosForm.txt_Isbn.getText()));
            libro.setAnio_publicacion(Integer.parseInt(librosForm.txt_anio_publicacion.getText()));
            libro.setCodigo(librosForm.txt_codigo.getText());
            libro.setTitulo(librosForm.txt_titulo.getText());
            libro.setUnidades_disponible(Integer.parseInt(librosForm.sp_unidadesDisponibles.getValue().toString()));

            if ((libroDao.modificarMaterial(libro) >= 1)) {
                if ((libroDao.modificarlibro(libro) >= 1)) {
                    JOptionPane.showMessageDialog(null, "Registro Modificado exitosamente");
                } else {
                    JOptionPane.showMessageDialog(null, "Error al Modificar ");
                }
            } else {
                JOptionPane.showMessageDialog(null, "Error al Modificar ");
            }
            librosForm.Limpiar();
            librosForm.tabla_Libros.setModel(libroDao.selectlibros());

        }

        if (e.getSource() == librosForm.btn_eliminarLibros) {
            libro.setId_material(Integer.parseInt(librosForm.txt_idMaterial.getText()));
            libro.setId_libro(Integer.parseInt(librosForm.txt_idLibros.getText()));
            if ((libroDao.eliminarlibros(libro) >= 1)) {
                if ((libroDao.eliminarMaterial(libro) >= 1)) {
                    JOptionPane.showMessageDialog(null, "Registro Eliminado exitosamente");
                } else {
                    JOptionPane.showMessageDialog(null, "Error al Eliminar ");
                }
            } else {
                JOptionPane.showMessageDialog(null, "Error al Eliminar ");
            }
            librosForm.Limpiar();
            librosForm.tabla_Libros.setModel(libroDao.selectlibros());

        }

        if (e.getActionCommand().equals("Limpiar")) {
            librosForm.Limpiar();
        }
    }

}
