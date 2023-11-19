/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import Controlador.ControladorDevolucion;
import Modelo.DevolucionDAO;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.ParseException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import javax.swing.text.DefaultFormatterFactory;
import javax.swing.text.MaskFormatter;

/**
 *
 * @author JONATHAN G
 */
public class DevolucionForm extends javax.swing.JFrame {

    DevolucionDAO devolucionDao = new DevolucionDAO();

    /**
     * Creates new form DevolucionForm
     */
    public DevolucionForm() {
        initComponents();
        setLocationRelativeTo(null);

        ControladorDevolucion controladorDevolucion = new ControladorDevolucion(this, devolucionDao);
        btn_devolucion.addActionListener(controladorDevolucion);
        btn_modificar.addActionListener(controladorDevolucion);
        btn_limpiar.addActionListener(controladorDevolucion);
        Table_prestamo.setModel(devolucionDao.selectPrestamo());
        table_devolucion.setModel(devolucionDao.selectDevolucion());
        
        // METODO PARA CAPURAR LOS EVENTOS DEL MOUSE AL HACER CLICK
        this.Table_prestamo.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                obtenerDatosTablaPrestamo(e);

            }
        });
        this.table_devolucion.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                obtenerDatosTablaDevolucion(e);

            }

        });

        Limpiar();
        try {                  
            formatoFecha();
        } catch (ParseException ex) {

        }
    }

    public void Modificar() {

        txt_idDevolucion.setEnabled(false);
        txt_idPrestamo.setEnabled(false);

        btn_devolucion.setEnabled(false);
        btn_modificar.setEnabled(true);
        btn_limpiar.setEnabled(true);
    }

    public void Limpiar() {

        txt_idPrestamo.setEnabled(false);
        txt_idDevolucion.setEnabled(false);
        jformat_fechaPrestamo.setEnabled(false);    
        jformat_fechaDevolucion.setEnabled(false);
        txt_Cantidad.setEnabled(false);
        textArea_observacion.setText("");
     

        btn_limpiar.setEnabled(true);
        btn_modificar.setEnabled(false);
        btn_devolucion.setEnabled(true);
        
        
    }

    private void obtenerDatosTablaPrestamo(MouseEvent e) {

        int filaSeleccionada = Table_prestamo.getSelectedRow();

        if (filaSeleccionada > -1) {
            String id_prestamo = Table_prestamo.getValueAt(filaSeleccionada, 0).toString();
            String cantidad_material = Table_prestamo.getValueAt(filaSeleccionada, 4).toString();
            String fecha_prestamo = Table_prestamo.getValueAt(filaSeleccionada, 5).toString();
            String fecha_devo = Table_prestamo.getValueAt(filaSeleccionada, 6).toString();
            
            txt_idPrestamo.setEnabled(false);
            txt_idDevolucion.setEnabled(false);
            txt_idPrestamo.setText(id_prestamo);
            jformat_fechaPrestamo.setText(fecha_prestamo);
            jformat_fechaDevolucion.setText(fecha_devo);
            txt_Cantidad.setText(cantidad_material);

            btn_limpiar.setEnabled(true);
            btn_modificar.setEnabled(false);
            btn_devolucion.setEnabled(true);
        }
    }

    private void obtenerDatosTablaDevolucion(MouseEvent e) {

        int filaSeleccionada = table_devolucion.getSelectedRow();

        if (filaSeleccionada > -1) {
            String id_devolucion = table_devolucion.getValueAt(filaSeleccionada, 0).toString();
            String id_prestamo = table_devolucion.getValueAt(filaSeleccionada, 1).toString();
            String fecha_prestamo = table_devolucion.getValueAt(filaSeleccionada, 2).toString();
            String fecha_devo = table_devolucion.getValueAt(filaSeleccionada, 3).toString();
            String observaciones = table_devolucion.getValueAt(filaSeleccionada, 4).toString();
            String cantidad_material = table_devolucion.getValueAt(filaSeleccionada, 6).toString();

            txt_idDevolucion.setText(id_devolucion);
            txt_idPrestamo.setText(id_prestamo);
            jformat_fechaPrestamo.setText(fecha_prestamo);
            jformat_fechaDevolucion.setText(fecha_devo);
            textArea_observacion.setText(observaciones);
            txt_Cantidad.setText(cantidad_material);

            btn_limpiar.setEnabled(true);
            btn_modificar.setEnabled(true);
            btn_devolucion.setEnabled(false);
        }
    }

    private void formatoFecha() throws ParseException {

        MaskFormatter mascara = new MaskFormatter("##/##/####");
        mascara.setPlaceholderCharacter('_');
        jformat_fechaPrestamo.setFormatterFactory(new DefaultFormatterFactory(mascara));
        jformat_fechaDevolucion.setFormatterFactory(new DefaultFormatterFactory(mascara));

    }
    
   

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lbl_idDevolucion = new javax.swing.JLabel();
        txt_idDevolucion = new javax.swing.JTextField();
        lbl_idPrestamo = new javax.swing.JLabel();
        txt_idPrestamo = new javax.swing.JTextField();
        lbl_fechaDevolucion = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        Table_prestamo = new javax.swing.JTable();
        btn_devolucion = new javax.swing.JButton();
        btn_modificar = new javax.swing.JButton();
        btn_limpiar = new javax.swing.JButton();
        jformat_fechaDevolucion = new javax.swing.JFormattedTextField();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        textArea_observacion = new javax.swing.JTextArea();
        jScrollPane3 = new javax.swing.JScrollPane();
        table_devolucion = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        lbl_fechaPrestamo = new javax.swing.JLabel();
        jformat_fechaPrestamo = new javax.swing.JFormattedTextField();
        jLabel4 = new javax.swing.JLabel();
        txt_Cantidad = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        lbl_idDevolucion.setText("ID:");

        lbl_idPrestamo.setText("ID Prestamol:");

        lbl_fechaDevolucion.setText("Fecha Devolucion:");

        Table_prestamo.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(Table_prestamo);

        btn_devolucion.setText("Devolucion");

        btn_modificar.setText("Modificar");

        btn_limpiar.setText("Limpiar");

        jformat_fechaDevolucion.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.DateFormatter()));

        jLabel1.setText("Observacion:");

        textArea_observacion.setColumns(20);
        textArea_observacion.setRows(5);
        jScrollPane2.setViewportView(textArea_observacion);

        table_devolucion.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane3.setViewportView(table_devolucion);

        jLabel2.setFont(new java.awt.Font("Verdana", 1, 24)); // NOI18N
        jLabel2.setText("DEVOLUCIONES");

        jLabel3.setFont(new java.awt.Font("Verdana", 1, 24)); // NOI18N
        jLabel3.setText("PRESTAMOS ACTUALES");

        lbl_fechaPrestamo.setText("Fecha Prestamo:");

        jformat_fechaPrestamo.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.DateFormatter()));

        jLabel4.setText("Cantidad Material:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addComponent(jScrollPane3)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(41, 41, 41)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 512, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lbl_idDevolucion)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txt_idDevolucion, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(lbl_idPrestamo)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txt_idPrestamo, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lbl_fechaPrestamo)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jformat_fechaPrestamo, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lbl_fechaDevolucion)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jformat_fechaDevolucion, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel4)
                                .addGap(5, 5, 5)
                                .addComponent(txt_Cantidad, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(layout.createSequentialGroup()
                            .addContainerGap()
                            .addComponent(btn_devolucion)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(btn_modificar)
                            .addGap(32, 32, 32)
                            .addComponent(btn_limpiar))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(181, 181, 181)
                                .addComponent(jLabel3))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(241, 241, 241)
                                .addComponent(jLabel2)))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(56, 56, 56)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel4)
                        .addComponent(txt_Cantidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(lbl_idDevolucion)
                        .addComponent(txt_idDevolucion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(lbl_idPrestamo)
                        .addComponent(txt_idPrestamo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(lbl_fechaPrestamo)
                        .addComponent(jformat_fechaPrestamo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(lbl_fechaDevolucion)
                        .addComponent(jformat_fechaDevolucion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(37, 37, 37)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btn_modificar)
                    .addComponent(btn_devolucion)
                    .addComponent(btn_limpiar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 22, Short.MAX_VALUE)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(49, 49, 49)
                .addComponent(jLabel2)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JTable Table_prestamo;
    public javax.swing.JButton btn_devolucion;
    public javax.swing.JButton btn_limpiar;
    public javax.swing.JButton btn_modificar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    public javax.swing.JFormattedTextField jformat_fechaDevolucion;
    public javax.swing.JFormattedTextField jformat_fechaPrestamo;
    private javax.swing.JLabel lbl_fechaDevolucion;
    private javax.swing.JLabel lbl_fechaPrestamo;
    private javax.swing.JLabel lbl_idDevolucion;
    private javax.swing.JLabel lbl_idPrestamo;
    public javax.swing.JTable table_devolucion;
    public javax.swing.JTextArea textArea_observacion;
    public javax.swing.JTextField txt_Cantidad;
    public javax.swing.JTextField txt_idDevolucion;
    public javax.swing.JTextField txt_idPrestamo;
    // End of variables declaration//GEN-END:variables
}
