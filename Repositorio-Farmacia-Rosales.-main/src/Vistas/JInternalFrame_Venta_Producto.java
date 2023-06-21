package Vistas;

import Controlador.CRUD_Venta;
import Controlador.CRUD_Venta_Producto;
import Modelo.Clase_Producto;
import Modelo.Clase_Venta;
import Modelo.Class_Venta_Producto;
import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.Timer;
import javax.swing.SwingUtilities;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.DefaultTableModel;

public class JInternalFrame_Venta_Producto extends javax.swing.JInternalFrame {

    private Timer timer;
    private BigDecimal totalActual = BigDecimal.ZERO;

    public JInternalFrame_Venta_Producto() {
        initComponents();
        mostrarFechaHora();
        iniciarTimer();
        jTextField_Fecha_Hora.setEditable(false);
        jSlider_Descuanto.setMinimum(0);
        jSlider_Descuanto.setMaximum(100);

    }

    public void limpiarCampos() {
        jTextField_Venta.setText("");
        jTextField_Id_Empleado.setText("");
        jTextField_Id_Cliente.setText("");
    }

    public void mostrar() {
        try {
            DefaultTableModel modelo;
            CRUD_Venta cli = new CRUD_Venta();
            modelo = cli.mostrarDatosVenta();
            jTable_Venta.setModel(modelo);

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }

    }

    private void iniciarTimer() {
        int intervaloActualizacion = 1000;
        timer = new Timer(intervaloActualizacion, e -> {
            mostrarFechaHora();
        });
        timer.start();
    }

    private void mostrarFechaHora() {
        LocalDateTime currentDateTime = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.SSS");
        String formattedDateTime = currentDateTime.format(formatter);
        jTextField_Fecha_Hora.setText(formattedDateTime);
    }

    public void llenarproducto(String busqueda) {
        CRUD_Venta_Producto gr = new CRUD_Venta_Producto();
        ArrayList<Clase_Producto> listaProductos = gr.mostrarDatosCombo(busqueda);
        jComboBox_Producto.removeAllItems();
        for (Clase_Producto producto : listaProductos) {
            jComboBox_Producto.addItem(producto);
        }
    }

    public void agregarProductoATabla() {
        Clase_Producto productoSeleccionado = (Clase_Producto) jComboBox_Producto.getSelectedItem();
        int cantidad = (int) jSpinner_Cantidad_Producto.getValue();
        if (productoSeleccionado == null || cantidad <= 0) {
            JOptionPane.showMessageDialog(null, "Debe seleccionar un producto y especificar una cantidad válida.");
            return;
        }

        DefaultTableModel model = (DefaultTableModel) jTable_Producto.getModel();
        BigDecimal precioVenta = BigDecimal.valueOf(productoSeleccionado.getPrecio_Venta());
        BigDecimal total = precioVenta.multiply(BigDecimal.valueOf(cantidad));

        model.insertRow(0, new Object[]{
            productoSeleccionado.getId_Producto(),
            productoSeleccionado.getNombre(),
            String.valueOf(precioVenta),
            cantidad,
            total
        });

        totalActual = totalActual.add(total);
        jTextField_Total.setText(totalActual.toString());

        jComboBox_Producto.setSelectedIndex(-1);
        jSpinner_Cantidad_Producto.setValue(0);
    }

    private void calcularTotalTabla() {
        DefaultTableModel model = (DefaultTableModel) jTable_Producto.getModel();
        BigDecimal total = BigDecimal.ZERO;
        for (int i = 0; i < model.getRowCount(); i++) {
            BigDecimal filaTotal = (BigDecimal) model.getValueAt(i, 4);
            total = total.add(filaTotal);
        }
        totalActual = total;
        jTextField_Total.setText(totalActual.toString());
    }

    public void guardarventa() {
        CRUD_Venta cc = new CRUD_Venta();
        int idemplead = Integer.parseInt(jTextField_Id_Empleado.getText());
        int idcliente = Integer.parseInt(jTextField_Id_Cliente.getText());

        String fechahoraString = jTextField_Fecha_Hora.getText().trim();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.SSS");
        LocalDateTime fechahora = LocalDateTime.parse(fechahoraString, formatter);

        Clase_Venta cl = new Clase_Venta(idemplead, idcliente, fechahora);
        cc.insertarVenta(cl);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jTextField11 = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        jPanel3 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jTextField_Id_Empleado = new javax.swing.JTextField();
        jButton_guardar_venta = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jButton9 = new javax.swing.JButton();
        jTextField_Id_Cliente = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jTextField_Venta = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jTextField_Fecha_Hora = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable_Producto = new javax.swing.JTable();
        jComboBox_Producto = new javax.swing.JComboBox<>();
        jTextField_Busqueda_Combo = new javax.swing.JTextField();
        jButton_Agregar = new javax.swing.JButton();
        jButton_Borrar_p = new javax.swing.JButton();
        jSpinner_Cantidad_Producto = new javax.swing.JSpinner();
        jButton_Aplicar_Descuento = new javax.swing.JButton();
        jSlider_Descuanto = new javax.swing.JSlider();
        jTextField_Descuento = new javax.swing.JTextField();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTable_Venta = new javax.swing.JTable();
        jTextField_Total = new javax.swing.JTextField();

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTextField11.setForeground(new java.awt.Color(102, 102, 102));
        jTextField11.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        jTextField11.setText("Buscar");
        jTextField11.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        jTextField11.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        jTextField11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField11ActionPerformed(evt);
            }
        });
        jPanel1.add(jTextField11, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 340, 250, 30));

        jLabel5.setFont(new java.awt.Font("Dialog", 1, 13)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0, 153, 153));
        jLabel5.setText("Buscar");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 310, -1, -1));

        jPanel5.setBackground(new java.awt.Color(0, 153, 153));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Farmacia Rosales");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 887, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 173, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addContainerGap(9, Short.MAX_VALUE))
        );

        jPanel1.add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1060, 40));

        jTable2.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Id Producto", "Depcripcion", "Cantidad ", "Precio Venta", "Id Cliente", "Empleado", "Fecha y hora", "Descuento", "Total"
            }
        ));
        jTable2.setGridColor(new java.awt.Color(0, 153, 153));
        jTable2.setShowGrid(true);
        jScrollPane2.setViewportView(jTable2);

        jPanel1.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 380, 550, 120));

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        jLabel9.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(0, 153, 153));
        jLabel9.setText("Id Empleado");

        jLabel10.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(0, 153, 153));
        jLabel10.setText("Id Cliente");

        jTextField_Id_Empleado.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField_Id_Empleado.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        jTextField_Id_Empleado.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        jTextField_Id_Empleado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField_Id_EmpleadoActionPerformed(evt);
            }
        });

        jButton_guardar_venta.setBackground(new java.awt.Color(0, 153, 153));
        jButton_guardar_venta.setFont(new java.awt.Font("Dialog", 1, 11)); // NOI18N
        jButton_guardar_venta.setForeground(new java.awt.Color(51, 51, 51));
        jButton_guardar_venta.setText("Guardar");
        jButton_guardar_venta.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        jButton_guardar_venta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_guardar_venta(evt);
            }
        });

        jButton4.setBackground(new java.awt.Color(255, 102, 102));
        jButton4.setFont(new java.awt.Font("Dialog", 1, 11)); // NOI18N
        jButton4.setForeground(new java.awt.Color(255, 255, 255));
        jButton4.setText("Eliminar");
        jButton4.setBorder(javax.swing.BorderFactory.createEtchedBorder(javax.swing.border.EtchedBorder.RAISED));

        jButton6.setBackground(new java.awt.Color(255, 255, 102));
        jButton6.setFont(new java.awt.Font("Dialog", 1, 11)); // NOI18N
        jButton6.setText("Editar");
        jButton6.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        jButton9.setBackground(new java.awt.Color(102, 204, 255));
        jButton9.setFont(new java.awt.Font("Dialog", 1, 11)); // NOI18N
        jButton9.setForeground(new java.awt.Color(255, 255, 255));
        jButton9.setText("Actualizar");
        jButton9.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jButton9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton9ActionPerformed(evt);
            }
        });

        jTextField_Id_Cliente.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField_Id_Cliente.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        jTextField_Id_Cliente.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        jTextField_Id_Cliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField_Id_Cliente(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 153, 153));
        jLabel2.setText("Id Venta");

        jTextField_Venta.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField_Venta.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        jTextField_Venta.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        jTextField_Venta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField_Venta(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(0, 153, 153));
        jLabel6.setText("Fecha y hora");

        jTextField_Fecha_Hora.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField_Fecha_Hora.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        jTextField_Fecha_Hora.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        jTextField_Fecha_Hora.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField_Fecha_Hora(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(16, 16, 16)
                        .addComponent(jButton_guardar_venta, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(37, 37, 37)
                        .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(41, 41, 41)
                        .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(44, 44, 44)
                        .addComponent(jButton9, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(jLabel10)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jTextField_Id_Cliente, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jTextField_Venta, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(jLabel9)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jTextField_Id_Empleado, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(jLabel6)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jTextField_Fecha_Hora, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(25, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField_Id_Empleado, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(jTextField_Venta, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(39, 39, 39)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField_Id_Cliente, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField_Fecha_Hora, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(87, 87, 87)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton_guardar_venta, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton9, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(36, Short.MAX_VALUE))
        );

        jPanel1.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 40, 520, 260));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        jTable_Producto.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        jTable_Producto.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Id Producto", "Nombre", "Precio Venta", "Cantidad", "total"
            }
        ));
        jTable_Producto.setGridColor(new java.awt.Color(0, 153, 153));
        jTable_Producto.setShowGrid(true);
        jTable_Producto.addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
                jTable_Producto(evt);
            }
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
            }
        });
        jScrollPane1.setViewportView(jTable_Producto);

        jComboBox_Producto.setBorder(javax.swing.BorderFactory.createTitledBorder("Producto"));
        jComboBox_Producto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox_Producto(evt);
            }
        });

        jTextField_Busqueda_Combo.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField_Busqueda_Combo.setBorder(javax.swing.BorderFactory.createTitledBorder("Buscar"));
        jTextField_Busqueda_Combo.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        jTextField_Busqueda_Combo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField_Busqueda_Combo(evt);
            }
        });
        jTextField_Busqueda_Combo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextField_Busqueda_ComboKeyReleased(evt);
            }
        });

        jButton_Agregar.setBackground(new java.awt.Color(0, 153, 153));
        jButton_Agregar.setFont(new java.awt.Font("Dialog", 1, 11)); // NOI18N
        jButton_Agregar.setForeground(new java.awt.Color(51, 51, 51));
        jButton_Agregar.setText("Agregar");
        jButton_Agregar.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        jButton_Agregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_Agregar(evt);
            }
        });

        jButton_Borrar_p.setBackground(new java.awt.Color(255, 102, 102));
        jButton_Borrar_p.setFont(new java.awt.Font("Dialog", 1, 11)); // NOI18N
        jButton_Borrar_p.setForeground(new java.awt.Color(255, 255, 255));
        jButton_Borrar_p.setText("Eliminar");
        jButton_Borrar_p.setBorder(javax.swing.BorderFactory.createEtchedBorder(javax.swing.border.EtchedBorder.RAISED));
        jButton_Borrar_p.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_Borrar_p(evt);
            }
        });

        jSpinner_Cantidad_Producto.setBorder(javax.swing.BorderFactory.createTitledBorder("Cantidad"));
        jSpinner_Cantidad_Producto.addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
                jSpinner_Cantidad_Producto(evt);
            }
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jComboBox_Producto, javax.swing.GroupLayout.PREFERRED_SIZE, 233, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jSpinner_Cantidad_Producto, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jTextField_Busqueda_Combo, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(36, 36, 36)
                        .addComponent(jButton_Agregar, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jButton_Borrar_p, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addContainerGap(16, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(11, 11, 11)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jSpinner_Cantidad_Producto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboBox_Producto))
                .addGap(20, 20, 20)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField_Busqueda_Combo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton_Agregar, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton_Borrar_p, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29))
        );

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 40, 430, 260));

        jButton_Aplicar_Descuento.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Vistas_Iconos/mas (1).png"))); // NOI18N
        jButton_Aplicar_Descuento.setBorder(null);
        jButton_Aplicar_Descuento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_Aplicar_Descuento(evt);
            }
        });
        jPanel1.add(jButton_Aplicar_Descuento, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 320, -1, -1));

        jSlider_Descuanto.setBorder(javax.swing.BorderFactory.createTitledBorder("Descuento"));
        jSlider_Descuanto.addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
                jSlider_Descuanto(evt);
            }
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
            }
        });
        jSlider_Descuanto.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                jSlider_DescuantoStateChanged(evt);
            }
        });
        jSlider_Descuanto.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jSlider_DescuantoMouseReleased(evt);
            }
        });
        jPanel1.add(jSlider_Descuanto, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 310, 142, -1));

        jTextField_Descuento.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField_Descuento.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        jTextField_Descuento.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        jTextField_Descuento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField_Descuento(evt);
            }
        });
        jTextField_Descuento.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextField_DescuentoKeyTyped(evt);
            }
        });
        jPanel1.add(jTextField_Descuento, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 320, 50, 30));

        jTable_Venta.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        jTable_Venta.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Id Venta", "Fecha y Hora", "Id Cliente", "Id Empleado"
            }
        ));
        jTable_Venta.setGridColor(new java.awt.Color(0, 153, 153));
        jTable_Venta.setShowGrid(true);
        jTable_Venta.addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
                jTable_Venta(evt);
            }
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
            }
        });
        jScrollPane3.setViewportView(jTable_Venta);

        jPanel1.add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(606, 380, 320, 96));

        jTextField_Total.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField_Total.setBorder(javax.swing.BorderFactory.createTitledBorder("Total"));
        jTextField_Total.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        jTextField_Total.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField_Total(evt);
            }
        });
        jPanel1.add(jTextField_Total, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 320, 153, 40));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 953, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 519, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTextField11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField11ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField11ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jButton9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton9ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton9ActionPerformed

    private void jButton_guardar_venta(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_guardar_venta
        CRUD_Venta cl = new CRUD_Venta();
        try {
            if (jTextField_Id_Empleado.getText().isEmpty() || jTextField_Fecha_Hora.getText().isEmpty()) {
                JOptionPane.showMessageDialog(null, "Tiene datos vacíos");

            } else {
                int option = JOptionPane.showOptionDialog(
                        null,
                        "¿Desea guardar esta venta?",
                        "Confirmar Guardado",
                        JOptionPane.YES_NO_OPTION,
                        JOptionPane.QUESTION_MESSAGE,
                        new ImageIcon(getClass().getResource("/Vistas_Iconos/Guardar.png")),
                        new Object[]{"Sí", "No"},
                        "No"
                );

                if (option == JOptionPane.YES_OPTION) {
                    guardarventa();
                    limpiarCampos();

                    JPanel panel = new JPanel();
                    panel.setLayout(new BorderLayout());

                    JLabel messageLabel = new JLabel("Venta Guardada Correctamente");
                    messageLabel.setFont(new Font("Arial", Font.BOLD, 14));
                    messageLabel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
                    panel.add(messageLabel, BorderLayout.CENTER);

                    ImageIcon icon = new ImageIcon(getClass().getResource("/Vistas_Iconos/Guardar.png"));
                    JLabel iconLabel = new JLabel(icon);
                    iconLabel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
                    panel.add(iconLabel, BorderLayout.WEST);

                    JOptionPane.showMessageDialog(null, panel, "Guardado Exitoso", JOptionPane.PLAIN_MESSAGE);

                    mostrar();
                }
            }
        } catch (HeadlessException e) {
            JOptionPane.showMessageDialog(null, "Error: " + e);
        }
    }//GEN-LAST:event_jButton_guardar_venta

    private void jComboBox_Producto(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox_Producto

    }//GEN-LAST:event_jComboBox_Producto

    private void jTextField_Venta(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField_Venta
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField_Venta

    private void jTextField_Fecha_Hora(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField_Fecha_Hora
        mostrarFechaHora();
    }//GEN-LAST:event_jTextField_Fecha_Hora

    private void jTextField_Id_EmpleadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField_Id_EmpleadoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField_Id_EmpleadoActionPerformed

    private void jTextField_Total(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField_Total
        calcularTotalTabla();
    }//GEN-LAST:event_jTextField_Total

    private void jTextField_Descuento(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField_Descuento


    }//GEN-LAST:event_jTextField_Descuento

    private void jTextField_Busqueda_Combo(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField_Busqueda_Combo

    }//GEN-LAST:event_jTextField_Busqueda_Combo

    private void jTextField_Id_Cliente(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField_Id_Cliente
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField_Id_Cliente

    private void jSlider_Descuanto(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_jSlider_Descuanto
        jTextField_Descuento.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                actualizarSlider();
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                actualizarSlider();
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                actualizarSlider();
            }

            private void actualizarSlider() {
                String descuentoText = jTextField_Descuento.getText().trim();
                if (descuentoText.isEmpty()) {
                    return;
                }

                if (descuentoText.matches("^\\d+%$")) {
                    int descuento = Integer.parseInt(descuentoText.replace("%", ""));
                    if (descuento >= 0 && descuento <= 100) {
                        jSlider_Descuanto.setValue(descuento);
                    } else {
                        // El descuento está fuera del rango válido (0-100)
                        JOptionPane.showMessageDialog(null, "El descuento debe estar entre 0 y 100.", "Error", JOptionPane.ERROR_MESSAGE);
                    }
                } else {
                    // El formato del descuento es inválido
                    JOptionPane.showMessageDialog(null, "El formato del descuento es inválido. Debe ser un número seguido del símbolo '%'.", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });


    }//GEN-LAST:event_jSlider_Descuanto

    private void jSpinner_Cantidad_Producto(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_jSpinner_Cantidad_Producto
        // TODO add your handling code here:
    }//GEN-LAST:event_jSpinner_Cantidad_Producto

    private void jSlider_DescuantoMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jSlider_DescuantoMouseReleased

    }//GEN-LAST:event_jSlider_DescuantoMouseReleased

    private void jSlider_DescuantoStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_jSlider_DescuantoStateChanged
        jSlider_Descuanto.addChangeListener(e -> {
            int descuento = jSlider_Descuanto.getValue();
            SwingUtilities.invokeLater(() -> {
                jTextField_Descuento.setText(descuento + "%");
            });
        });

    }//GEN-LAST:event_jSlider_DescuantoStateChanged

    private void jTextField_DescuentoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField_DescuentoKeyTyped

    }//GEN-LAST:event_jTextField_DescuentoKeyTyped

    private void jTable_Producto(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_jTable_Producto
        // TODO add your handling code here:
    }//GEN-LAST:event_jTable_Producto

    private void jTextField_Busqueda_ComboKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField_Busqueda_ComboKeyReleased
        String busqueda = jTextField_Busqueda_Combo.getText(); // Obtener el texto ingresado en el campo de búsqueda

        CRUD_Venta_Producto gr = new CRUD_Venta_Producto();
        ArrayList<Clase_Producto> listaProductos = gr.mostrarDatosCombo(busqueda);
        jComboBox_Producto.removeAllItems();
        for (Clase_Producto producto : listaProductos) {
            jComboBox_Producto.addItem(producto);
        }
    }//GEN-LAST:event_jTextField_Busqueda_ComboKeyReleased

    private void jButton_Agregar(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_Agregar
        agregarProductoATabla();
    }//GEN-LAST:event_jButton_Agregar

    private void jButton_Borrar_p(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_Borrar_p
        int filaSeleccionada = jTable_Producto.getSelectedRow();
        if (filaSeleccionada == -1) {

            JOptionPane.showMessageDialog(null, "Por favor, seleccione una fila para borrar.");
            return;
        }

        DefaultTableModel modelo = (DefaultTableModel) jTable_Producto.getModel();

        modelo.removeRow(filaSeleccionada);

        jTable_Producto.setModel(modelo);

    }//GEN-LAST:event_jButton_Borrar_p

    private void jTable_Venta(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_jTable_Venta
        // TODO add your handling code here:
    }//GEN-LAST:event_jTable_Venta

    private void jButton_Aplicar_Descuento(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_Aplicar_Descuento
        try {
            double total = Double.parseDouble(jTextField_Total.getText());
            int descuento = jSlider_Descuanto.getValue();
            double descuentoPorcentaje = descuento / 100.0;
            double totalConDescuento = total - (total * descuentoPorcentaje);
            jTextField_Total.setText(String.valueOf(totalConDescuento));
        } catch (NumberFormatException ex) {
            // Manejar el caso en el que se ingrese un valor no válido en el total
            // Puedes mostrar un mensaje de error o realizar una acción adecuada
            System.out.println("El valor ingresado en el total es inválido.");
        }


    }//GEN-LAST:event_jButton_Aplicar_Descuento


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton9;
    private javax.swing.JButton jButton_Agregar;
    private javax.swing.JButton jButton_Aplicar_Descuento;
    private javax.swing.JButton jButton_Borrar_p;
    private javax.swing.JButton jButton_guardar_venta;
    private javax.swing.JComboBox<Clase_Producto> jComboBox_Producto;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JSlider jSlider_Descuanto;
    private javax.swing.JSpinner jSpinner_Cantidad_Producto;
    private javax.swing.JTable jTable2;
    private javax.swing.JTable jTable_Producto;
    private javax.swing.JTable jTable_Venta;
    private javax.swing.JTextField jTextField11;
    private javax.swing.JTextField jTextField_Busqueda_Combo;
    private javax.swing.JTextField jTextField_Descuento;
    private javax.swing.JTextField jTextField_Fecha_Hora;
    private javax.swing.JTextField jTextField_Id_Cliente;
    private javax.swing.JTextField jTextField_Id_Empleado;
    private javax.swing.JTextField jTextField_Total;
    private javax.swing.JTextField jTextField_Venta;
    // End of variables declaration//GEN-END:variables
}
