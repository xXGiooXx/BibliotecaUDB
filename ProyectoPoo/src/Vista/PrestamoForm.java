/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import Controlador.ControladorPrestamo;
import Modelo.PrestamoDAO;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.ParseException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFormattedTextField;
import javax.swing.text.DefaultFormatterFactory;
import javax.swing.text.MaskFormatter;

/**
 *
 * @author JONATHAN G
 */
public class PrestamoForm extends javax.swing.JFrame {

    PrestamoDAO prestamoDao = new PrestamoDAO();

    /**
     * Creates new form PrestamoForm
     */
    public PrestamoForm() {
        initComponents();
        setLocationRelativeTo(null);
        
        ControladorPrestamo controladorPrestamo = new ControladorPrestamo(this, prestamoDao);
        btn_crearPrestamo.addActionListener(controladorPrestamo);
        btn_modificarPrestamo.addActionListener(controladorPrestamo);
        btn_limpiar.addActionListener(controladorPrestamo);
        table_material_disponible.setModel(prestamoDao.selectMaterial());
        table_prestamos.setModel(prestamoDao.selectPrestamo());
        // METODO PARA CAPURAR LOS EVENTOS DEL MOUSE AL HACER CLICK
        this.table_material_disponible.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                obtenerDatosTablaMaterial(e);

            }
        });
        this.table_prestamos.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                obtenerDatosTablaPrestamo(e);

            }

        });
        Limpiar();
        try {
            formatoFecha();
        } catch (ParseException ex) {
            
        }

    }

    public void Modificar() {

        txt_idMaterial.setEnabled(false);
        txt_idPrestamo.setEnabled(false);

        btn_crearPrestamo.setEnabled(false);
        btn_modificarPrestamo.setEnabled(true);
        btn_limpiar.setEnabled(true);
    }

    public void Limpiar() {

        txt_idPrestamo.setEnabled(false);
        txt_idMaterial.setEnabled(false);
        txt_codigo.setEnabled(false);
        txt_titulo.setEnabled(false);
        txt_idMaterial.setText("");
        txt_codigo.setText("");
        txt_titulo.setText("");
        jsp_cantidad.setValue(0);
        jformat_fecha_prestamo.setText("");
        jformat_fecha_devolucion.setText("");

        btn_limpiar.setEnabled(true);
        btn_modificarPrestamo.setEnabled(false);
        btn_crearPrestamo.setEnabled(true);
    }

    private void obtenerDatosTablaMaterial(MouseEvent e) {

        int filaSeleccionada = table_material_disponible.getSelectedRow();

        if (filaSeleccionada > -1) {
            String id_material = table_material_disponible.getValueAt(filaSeleccionada, 1).toString();
            String codigo = table_material_disponible.getValueAt(filaSeleccionada, 3).toString();
            String titulo = table_material_disponible.getValueAt(filaSeleccionada, 4).toString();

            txt_idPrestamo.setEnabled(false);
            txt_idMaterial.setEnabled(false);
            txt_codigo.setEnabled(false);
            txt_titulo.setEnabled(false);
            txt_idMaterial.setText(id_material);
            txt_codigo.setText(codigo);
            txt_titulo.setText(titulo);

            btn_limpiar.setEnabled(true);
            btn_modificarPrestamo.setEnabled(false);
            btn_crearPrestamo.setEnabled(true);
        }
    }

    private void obtenerDatosTablaPrestamo(MouseEvent e) {

        int filaSeleccionada = table_prestamos.getSelectedRow();

        if (filaSeleccionada > -1) {
            String id_prestamo = table_prestamos.getValueAt(filaSeleccionada, 0).toString();
            String id_material = table_prestamos.getValueAt(filaSeleccionada, 1).toString();
            String codigo = table_prestamos.getValueAt(filaSeleccionada, 2).toString();
            String titulo = table_prestamos.getValueAt(filaSeleccionada, 3).toString();
            String cantidad = table_prestamos.getValueAt(filaSeleccionada, 4).toString();
            String fecha_prestamo = table_prestamos.getValueAt(filaSeleccionada, 5).toString();
            String fecha_devolucion = table_prestamos.getValueAt(filaSeleccionada, 6).toString();

            txt_idPrestamo.setText(id_prestamo);
            txt_idMaterial.setText(id_material);
            txt_codigo.setText(codigo);
            txt_titulo.setText(titulo);
            jsp_cantidad.setValue(Integer.parseInt(cantidad));
            jformat_fecha_prestamo.setText(fecha_prestamo);
            jformat_fecha_devolucion.setText(fecha_devolucion);

            btn_limpiar.setEnabled(true);
            btn_modificarPrestamo.setEnabled(true);
            btn_crearPrestamo.setEnabled(false);
        }
    }

    private void formatoFecha() throws ParseException {

        MaskFormatter mascara = new MaskFormatter("##/##/####");
        mascara.setPlaceholderCharacter('_');

        jformat_fecha_prestamo.setFormatterFactory(new DefaultFormatterFactory(mascara));
        jformat_fecha_devolucion.setFormatterFactory(new DefaultFormatterFactory(mascara));

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lbl_idPrestamo = new javax.swing.JLabel();
        txt_idPrestamo = new javax.swing.JTextField();
        lbl_idMaterial = new javax.swing.JLabel();
        txt_idMaterial = new javax.swing.JTextField();
        lbl_codigo = new javax.swing.JLabel();
        txt_codigo = new javax.swing.JTextField();
        lbl_titulo = new javax.swing.JLabel();
        txt_titulo = new javax.swing.JTextField();
        lbl_cantidad = new javax.swing.JLabel();
        jsp_cantidad = new javax.swing.JSpinner();
        lbl_fecha_prestamo = new javax.swing.JLabel();
        jformat_fecha_prestamo = new javax.swing.JFormattedTextField();
        lbl_fecha_devolucion = new javax.swing.JLabel();
        jformat_fecha_devolucion = new javax.swing.JFormattedTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        table_material_disponible = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        table_prestamos = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        btn_crearPrestamo = new javax.swing.JButton();
        btn_modificarPrestamo = new javax.swing.JButton();
        btn_limpiar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        lbl_idPrestamo.setText("ID:");

        lbl_idMaterial.setText("ID Material");

        lbl_codigo.setText("Codigo:");

        lbl_titulo.setText("Titulo:");

        lbl_cantidad.setText("Cantidad:");

        lbl_fecha_prestamo.setText("Fecha Prestamo:");

        jformat_fecha_prestamo.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.DateFormatter()));

        lbl_fecha_devolucion.setText("Fecha Devolucion:");

        jformat_fecha_devolucion.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.DateFormatter()));

        table_material_disponible.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(table_material_disponible);

        table_prestamos.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane2.setViewportView(table_prestamos);

        jLabel1.setFont(new java.awt.Font("Verdana", 1, 24)); // NOI18N
        jLabel1.setText("PRESTAMOS ACTUALES");

        jLabel2.setFont(new java.awt.Font("Verdana", 1, 24)); // NOI18N
        jLabel2.setText("MATERIAL DISPONIBLE ");

        btn_crearPrestamo.setText("Crear Prestamo");

        btn_modificarPrestamo.setText("Modificar Prestamol");

        btn_limpiar.setText("Limpiar");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(98, 98, 98)
                        .addComponent(lbl_cantidad)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jsp_cantidad, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(48, 48, 48)
                        .addComponent(lbl_fecha_prestamo)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jformat_fecha_prestamo, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(49, 49, 49)
                        .addComponent(lbl_fecha_devolucion)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jformat_fecha_devolucion, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(237, 237, 237)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(88, 88, 88)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btn_crearPrestamo)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btn_modificarPrestamo)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btn_limpiar))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lbl_idPrestamo)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txt_idPrestamo, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(66, 66, 66)
                                .addComponent(lbl_idMaterial)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txt_idMaterial, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(74, 74, 74)
                                .addComponent(lbl_codigo)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txt_codigo, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(66, 66, 66)
                                .addComponent(lbl_titulo)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txt_titulo, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 686, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 686, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(65, Short.MAX_VALUE))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(238, 238, 238)
                    .addComponent(jLabel2)
                    .addContainerGap(275, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(76, 76, 76)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbl_idPrestamo)
                    .addComponent(txt_idPrestamo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbl_idMaterial)
                    .addComponent(txt_idMaterial, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbl_codigo)
                    .addComponent(txt_codigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbl_titulo)
                    .addComponent(txt_titulo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(34, 34, 34)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbl_cantidad)
                    .addComponent(jsp_cantidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbl_fecha_prestamo)
                    .addComponent(jformat_fecha_prestamo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbl_fecha_devolucion)
                    .addComponent(jformat_fecha_devolucion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(28, 28, 28)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_limpiar)
                    .addComponent(btn_modificarPrestamo)
                    .addComponent(btn_crearPrestamo))
                .addGap(65, 65, 65)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel1)
                .addGap(15, 15, 15)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(22, Short.MAX_VALUE))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(228, 228, 228)
                    .addComponent(jLabel2)
                    .addContainerGap(331, Short.MAX_VALUE)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton btn_crearPrestamo;
    public javax.swing.JButton btn_limpiar;
    public javax.swing.JButton btn_modificarPrestamo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    public javax.swing.JFormattedTextField jformat_fecha_devolucion;
    public javax.swing.JFormattedTextField jformat_fecha_prestamo;
    public javax.swing.JSpinner jsp_cantidad;
    private javax.swing.JLabel lbl_cantidad;
    private javax.swing.JLabel lbl_codigo;
    private javax.swing.JLabel lbl_fecha_devolucion;
    private javax.swing.JLabel lbl_fecha_prestamo;
    private javax.swing.JLabel lbl_idMaterial;
    private javax.swing.JLabel lbl_idPrestamo;
    private javax.swing.JLabel lbl_titulo;
    public javax.swing.JTable table_material_disponible;
    public javax.swing.JTable table_prestamos;
    public javax.swing.JTextField txt_codigo;
    public javax.swing.JTextField txt_idMaterial;
    public javax.swing.JTextField txt_idPrestamo;
    public javax.swing.JTextField txt_titulo;
    // End of variables declaration//GEN-END:variables
}
