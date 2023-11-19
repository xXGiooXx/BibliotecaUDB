/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Vista;
import Controlador.ControladorRevista;
import Modelo.RevistaDAO;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.ParseException;
import javax.swing.text.DefaultFormatterFactory;
import javax.swing.text.MaskFormatter;

/**
 *
 * @author Carlos Hernandez
 */
public class RevistaForm extends javax.swing.JFrame {
      RevistaDAO RevistaDAO = new RevistaDAO();

    /**
     * Creates new form RevistaForm1
     */
    public RevistaForm() {
     initComponents();
        setLocationRelativeTo(null);

        ControladorRevista controladorRevista = new ControladorRevista(this, RevistaDAO);
        btn_agregarRevista.addActionListener(controladorRevista);
        btn_modificarRevista.addActionListener(controladorRevista);
        btn_eliminarRevista.addActionListener(controladorRevista);
        btn_limpiarRevista.addActionListener(controladorRevista);
        tabla_Revista.setModel(RevistaDAO.selectRevistas());

        // METODO PARA CAPURAR LOS EVENTOS DEL MOUSE AL HACER CLICK
        this.tabla_Revista.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                obtenerDatosTabla(e);
                ModificarEliminarBtn();
            }
        });
        
        Limpiar();
          try {
            formatoFecha();
        } catch (ParseException ex) {

        }
    }
    
        public void ModificarEliminarBtn() {

        txt_idRevista.setEnabled(false);
        txt_idMaterial.setEnabled(false);
        txt_idCategoria.setEnabled(false);

        btn_agregarRevista.setEnabled(false);
        btn_modificarRevista.setEnabled(true);
        btn_eliminarRevista.setEnabled(true);
    }

    public void Limpiar() {
        txt_idRevista.setEnabled(false);
        txt_idMaterial.setEnabled(false);
        txt_idCategoria.setEnabled(true);
        txt_idRevista.setText("");
        txt_idMaterial.setText("");
        txt_idCategoria.setText("");
        txt_editorial.setText("");
        txt_periodicidad.setText("");
        txt_Fecha_de_publicacion.setText("");
        txt_codigo.setText("");
        txt_titulo.setText("");
        sp_unidadesDisponibles.setValue(0);

        btn_agregarRevista.setEnabled(true);
        btn_modificarRevista.setEnabled(false);
        btn_eliminarRevista.setEnabled(false);
    }
private void obtenerDatosTabla(MouseEvent e) {

        int filaSeleccionada = tabla_Revista.getSelectedRow();

        if (filaSeleccionada > -1) {
            String id_revista = tabla_Revista.getValueAt(filaSeleccionada, 0).toString();
            String id_material = tabla_Revista.getValueAt(filaSeleccionada, 1).toString();
            String id_categoria = tabla_Revista.getValueAt(filaSeleccionada, 2).toString();
            String editorial = tabla_Revista.getValueAt(filaSeleccionada, 3).toString();
            String periodicidad = tabla_Revista.getValueAt(filaSeleccionada, 4).toString();
            String fecha_de_publicacion = tabla_Revista.getValueAt(filaSeleccionada, 5).toString();
            String codigo = tabla_Revista.getValueAt(filaSeleccionada, 6).toString();
            String titulo = tabla_Revista.getValueAt(filaSeleccionada, 7).toString();
            String unidadesDisponibles = tabla_Revista.getValueAt(filaSeleccionada, 8).toString();

            txt_idRevista.setText(id_revista);
            txt_idMaterial.setText(id_material);
            txt_idCategoria.setText(id_categoria);
            txt_editorial.setText(editorial);
            txt_periodicidad.setText(periodicidad);
            txt_Fecha_de_publicacion.setText(fecha_de_publicacion);
            txt_codigo.setText(codigo);
            txt_titulo.setText(titulo);
            sp_unidadesDisponibles.setValue(Integer.parseInt(unidadesDisponibles));
        }
    }
 private void formatoFecha() throws ParseException {

        MaskFormatter mascara = new MaskFormatter("##/##/####");
        mascara.setPlaceholderCharacter('_');
       txt_Fecha_de_publicacion.setFormatterFactory(new DefaultFormatterFactory(mascara));
       }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        sp_unidadesDisponibles = new javax.swing.JSpinner();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabla_Revista = new javax.swing.JTable();
        lbl_codigo = new javax.swing.JLabel();
        lbl_idRevista = new javax.swing.JLabel();
        btn_agregarRevista = new javax.swing.JButton();
        lbl_titulo = new javax.swing.JLabel();
        btn_modificarRevista = new javax.swing.JButton();
        lbl_idmaterial = new javax.swing.JLabel();
        lbl_idcategoria = new javax.swing.JLabel();
        btn_eliminarRevista = new javax.swing.JButton();
        txt_idMaterial = new javax.swing.JTextField();
        txt_idRevista = new javax.swing.JTextField();
        btn_limpiarRevista = new javax.swing.JButton();
        lbl_editorial = new javax.swing.JLabel();
        lbl_unidadesdisponibles = new javax.swing.JLabel();
        lbl_periodicidad = new javax.swing.JLabel();
        txt_idCategoria = new javax.swing.JTextField();
        lbl_Fecha_de_publicacion = new javax.swing.JLabel();
        txt_codigo = new javax.swing.JTextField();
        txt_editorial = new javax.swing.JTextField();
        txt_titulo = new javax.swing.JTextField();
        txt_periodicidad = new javax.swing.JTextField();
        txt_Fecha_de_publicacion = new javax.swing.JFormattedTextField();

        tabla_Revista.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(tabla_Revista);

        lbl_codigo.setText("Codigo:");

        lbl_idRevista.setText("ID:");

        btn_agregarRevista.setText("Agregar");
        btn_agregarRevista.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_agregarRevistaActionPerformed(evt);
            }
        });

        lbl_titulo.setText("Titulo:");

        btn_modificarRevista.setText("Modificar ");

        lbl_idmaterial.setText("ID Meterial");

        lbl_idcategoria.setText("ID Categoria");

        btn_eliminarRevista.setText("Eliminar");

        txt_idMaterial.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_idMaterialActionPerformed(evt);
            }
        });

        txt_idRevista.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_idRevistaActionPerformed(evt);
            }
        });

        btn_limpiarRevista.setText("Limpiar");

        lbl_editorial.setText("Editorial");

        lbl_unidadesdisponibles.setText("Unidades Disponibles:");

        lbl_periodicidad.setText("Periodicidad");

        txt_idCategoria.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_idCategoriaActionPerformed(evt);
            }
        });

        lbl_Fecha_de_publicacion.setText("Fecha de publicacion");

        txt_titulo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_tituloActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 581, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(69, 69, 69)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(lbl_codigo)
                            .addComponent(lbl_editorial))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(0, 0, Short.MAX_VALUE)
                                        .addComponent(lbl_idRevista)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(txt_idRevista, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(lbl_idmaterial))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(txt_editorial, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(0, 0, Short.MAX_VALUE))
                                            .addComponent(txt_codigo))
                                        .addGap(18, 18, 18)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(lbl_titulo)
                                            .addComponent(lbl_periodicidad))))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(layout.createSequentialGroup()
                                                .addGap(11, 11, 11)
                                                .addComponent(txt_periodicidad, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addComponent(txt_idMaterial))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(lbl_idcategoria)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(txt_idCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGroup(layout.createSequentialGroup()
                                                .addGap(12, 12, 12)
                                                .addComponent(lbl_Fecha_de_publicacion)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(txt_Fecha_de_publicacion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                        .addGap(44, 44, 44))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(txt_titulo, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(lbl_unidadesdisponibles)
                                        .addGap(18, 18, 18)
                                        .addComponent(sp_unidadesDisponibles, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(0, 0, Short.MAX_VALUE))))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(btn_agregarRevista)
                                .addGap(18, 18, 18)
                                .addComponent(btn_modificarRevista)
                                .addGap(18, 18, 18)
                                .addComponent(btn_eliminarRevista)
                                .addGap(26, 26, 26)
                                .addComponent(btn_limpiarRevista)
                                .addGap(117, 117, 117)))))
                .addGap(30, 30, 30))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(53, 53, 53)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(lbl_idcategoria)
                        .addComponent(txt_idCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(lbl_idRevista)
                        .addComponent(txt_idRevista, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(lbl_idmaterial)
                        .addComponent(txt_idMaterial, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(48, 48, 48)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbl_editorial)
                    .addComponent(lbl_periodicidad)
                    .addComponent(lbl_Fecha_de_publicacion)
                    .addComponent(txt_editorial, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_periodicidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_Fecha_de_publicacion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(39, 39, 39)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbl_unidadesdisponibles)
                    .addComponent(lbl_titulo)
                    .addComponent(lbl_codigo)
                    .addComponent(txt_codigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_titulo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(sp_unidadesDisponibles, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_agregarRevista)
                    .addComponent(btn_modificarRevista)
                    .addComponent(btn_eliminarRevista)
                    .addComponent(btn_limpiarRevista))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 218, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(14, 14, 14))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_agregarRevistaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_agregarRevistaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_agregarRevistaActionPerformed

    private void txt_idMaterialActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_idMaterialActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_idMaterialActionPerformed

    private void txt_idRevistaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_idRevistaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_idRevistaActionPerformed

    private void txt_idCategoriaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_idCategoriaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_idCategoriaActionPerformed

    private void txt_tituloActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_tituloActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_tituloActionPerformed

    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton btn_agregarRevista;
    public javax.swing.JButton btn_eliminarRevista;
    public javax.swing.JButton btn_limpiarRevista;
    public javax.swing.JButton btn_modificarRevista;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lbl_Fecha_de_publicacion;
    private javax.swing.JLabel lbl_codigo;
    private javax.swing.JLabel lbl_editorial;
    private javax.swing.JLabel lbl_idRevista;
    private javax.swing.JLabel lbl_idcategoria;
    private javax.swing.JLabel lbl_idmaterial;
    private javax.swing.JLabel lbl_periodicidad;
    private javax.swing.JLabel lbl_titulo;
    private javax.swing.JLabel lbl_unidadesdisponibles;
    public javax.swing.JSpinner sp_unidadesDisponibles;
    public javax.swing.JTable tabla_Revista;
    public javax.swing.JFormattedTextField txt_Fecha_de_publicacion;
    public javax.swing.JTextField txt_codigo;
    public javax.swing.JTextField txt_editorial;
    public javax.swing.JTextField txt_idCategoria;
    public javax.swing.JTextField txt_idMaterial;
    public javax.swing.JTextField txt_idRevista;
    public javax.swing.JTextField txt_periodicidad;
    public javax.swing.JTextField txt_titulo;
    // End of variables declaration//GEN-END:variables
}
