package Vistas;

import Controlador.CRUD_Venta;
import Controlador.CRUD_Venta_Producto;
import Modelo.Clase_Cliente;
import Modelo.Clase_Empleado;
import Vistas.JInternalFrame_Venta;

import Modelo.Clase_Producto;
import Modelo.Clase_Venta;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.math.BigDecimal;
import java.security.Timestamp;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JDesktopPane;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
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
        jButton_guardar_venta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_guardar_venta(evt);
            }
        });

        mostrarFechaHora();
        iniciarTimer();
        jTextField_Fecha_Hora.setEditable(false);
        jSlider_Descuanto.setMinimum(0);
        jSlider_Descuanto.setMaximum(100);
        llenarComboEmpleados(jComboEmpleado);

    }

    public void limpiarCampos() {
        jTextField_Venta.setText("");
        jComboCliente.setSelectedIndex(-1);
        jComboEmpleado.setSelectedIndex(-1);
        jTextField_BuscarCliente.setText("");
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

    public void llenarComboEmpleados(JComboBox<Clase_Empleado> jComboEmpleado) {
        CRUD_Venta_Producto gr = new CRUD_Venta_Producto();
        ArrayList<Clase_Empleado> empleados = gr.obtenerEmpleados();
        jComboEmpleado.removeAllItems(); // Limpiar el JComboBox
        for (Clase_Empleado empleado : empleados) {
            jComboEmpleado.addItem(empleado);
        }
    }

    public void llenarComboClientes(JComboBox<Clase_Cliente> jComboCliente, String busqueda) {
        CRUD_Venta_Producto gr = new CRUD_Venta_Producto();
        ArrayList<Clase_Cliente> clientes = gr.obtenerNombresApellidosCliente();
        jComboCliente.removeAllItems(); // Limpiar el JComboBox
        for (Clase_Cliente cliente : clientes) {
            jComboCliente.addItem(cliente);
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

    public void guardarVentaProducto() {
        CRUD_Venta_Producto ventaProductoDAO = new CRUD_Venta_Producto();

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.SSS");
        LocalDateTime fechaHora = LocalDateTime.parse(jTextField_Fecha_Hora.getText().trim(), formatter);

        Clase_Cliente clienteSeleccionado = (Clase_Cliente) jComboCliente.getSelectedItem();
        if (clienteSeleccionado == null) {
            JOptionPane.showMessageDialog(null, "Debe seleccionar un cliente válido.");
            return;
        }
        int idCliente = clienteSeleccionado.getId_Cliente();

        Clase_Empleado empleadoSeleccionado = (Clase_Empleado) jComboEmpleado.getSelectedItem();
        if (empleadoSeleccionado == null) {
            JOptionPane.showMessageDialog(null, "Debe seleccionar un empleado válido.");
            return;
        }
        int idEmpleado = empleadoSeleccionado.getId_Empleado();
        System.out.println(idEmpleado);

        String descuentoStr = jTextField_Descuento.getText().trim();
        descuentoStr = descuentoStr.replace("%", "");
        BigDecimal descuento;

        try {
            descuento = new BigDecimal(descuentoStr);
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Por favor, introduce un número válido para el descuento.");
            return;
        }

        for (int i = 0; i < jTable_Producto.getRowCount(); i++) {
            int idProducto = 0;
            int cantidad = 0;

            Object idProductoObj = jTable_Producto.getValueAt(i, 0);
            Object cantidadObj = jTable_Producto.getValueAt(i, 3);

            if (idProductoObj != null && cantidadObj != null) {
                idProducto = Integer.parseInt(idProductoObj.toString());
                cantidad = Integer.parseInt(cantidadObj.toString());

                Clase_Venta venta = new Clase_Venta(fechaHora, idCliente, idEmpleado, cantidad, descuento, idProducto);
                ventaProductoDAO.agregarVentaYProducto(venta);
            }
        }

        this.dispose();
        Container container = getParent();
        if (container instanceof JDesktopPane) {
            JDesktopPane desktopPane = (JDesktopPane) container;

            JInternalFrame_Venta ventaForm = new JInternalFrame_Venta();
            desktopPane.add(ventaForm);
            ventaForm.setVisible(true);

            try {

                ventaForm.setSelected(true);
            } catch (java.beans.PropertyVetoException e) {
                e.printStackTrace();
            }
        }

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jTextField_BuscarCliente = new javax.swing.JTextField();
        jTextField_Venta = new javax.swing.JTextField();
        jTextField_Fecha_Hora = new javax.swing.JTextField();
        jComboEmpleado = new javax.swing.JComboBox<>();
        jComboCliente = new javax.swing.JComboBox<>();
        jButton_Aplicar_Descuento = new javax.swing.JButton();
        jButton_guardar_venta = new javax.swing.JButton();
        jButton9 = new javax.swing.JButton();
        jSlider_Descuanto = new javax.swing.JSlider();
        jTextField_Descuento = new javax.swing.JTextField();
        jTextField_Total = new javax.swing.JTextField();
        jTextField_Pago = new javax.swing.JTextField();
        jButton_ver_Formulario_venta = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable_Producto = new javax.swing.JTable();
        jTextField_Busqueda_Combo = new javax.swing.JTextField();
        jSpinner_Cantidad_Producto = new javax.swing.JSpinner();
        jComboBox_Producto = new javax.swing.JComboBox<>();
        jButton_Agregar = new javax.swing.JButton();
        jButton_Borrar_p = new javax.swing.JButton();

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

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
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 951, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 109, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addContainerGap(9, Short.MAX_VALUE))
        );

        jPanel1.add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1060, 40));

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        jTextField_BuscarCliente.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField_BuscarCliente.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Buscar Cliente", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 12))); // NOI18N
        jTextField_BuscarCliente.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        jTextField_BuscarCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField_BuscarCliente(evt);
            }
        });
        jTextField_BuscarCliente.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextField_BuscarClienteKeyReleased(evt);
            }
        });

        jTextField_Venta.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField_Venta.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "ID de Venta", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 12))); // NOI18N
        jTextField_Venta.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        jTextField_Venta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField_Venta(evt);
            }
        });

        jTextField_Fecha_Hora.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField_Fecha_Hora.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Fecha y Hora", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 12))); // NOI18N
        jTextField_Fecha_Hora.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        jTextField_Fecha_Hora.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField_Fecha_Hora(evt);
            }
        });

        jComboEmpleado.setFont(new java.awt.Font("Roboto Medium", 0, 14)); // NOI18N
        jComboEmpleado.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Empleado", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 12))); // NOI18N
        jComboEmpleado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboEmpleadoActionPerformed(evt);
            }
        });

        jComboCliente.setFont(new java.awt.Font("Roboto Medium", 0, 14)); // NOI18N
        jComboCliente.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Cliente", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 12))); // NOI18N
        jComboCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboClienteActionPerformed(evt);
            }
        });

        jButton_Aplicar_Descuento.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Vistas_Iconos/mas (1).png"))); // NOI18N
        jButton_Aplicar_Descuento.setBorder(null);
        jButton_Aplicar_Descuento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_Aplicar_Descuento(evt);
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

        jSlider_Descuanto.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Descuento", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 12))); // NOI18N
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

        jTextField_Descuento.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField_Descuento.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "%", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 12))); // NOI18N
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

        jTextField_Total.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField_Total.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Total", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 12))); // NOI18N
        jTextField_Total.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        jTextField_Total.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField_Total(evt);
            }
        });

        jTextField_Pago.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField_Pago.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Pago", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 12))); // NOI18N
        jTextField_Pago.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        jTextField_Pago.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField_Pago(evt);
            }
        });

        jButton_ver_Formulario_venta.setBackground(new java.awt.Color(255, 255, 204));
        jButton_ver_Formulario_venta.setFont(new java.awt.Font("Dialog", 1, 11)); // NOI18N
        jButton_ver_Formulario_venta.setText("Ver Productos");
        jButton_ver_Formulario_venta.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jButton_ver_Formulario_venta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_ver_Formulario_ventaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(jSlider_Descuanto, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jTextField_Descuento, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jButton_Aplicar_Descuento))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(jButton_guardar_venta, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jButton9, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jButton_ver_Formulario_venta, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTextField_Pago, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextField_Total, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTextField_Venta, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextField_BuscarCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(29, 29, 29)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jTextField_Fecha_Hora)
                            .addComponent(jComboCliente, 0, 246, Short.MAX_VALUE))))
                .addContainerGap(17, Short.MAX_VALUE))
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(88, 88, 88)
                .addComponent(jComboEmpleado, javax.swing.GroupLayout.PREFERRED_SIZE, 252, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField_Venta, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField_Fecha_Hora, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(25, 25, 25)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField_BuscarCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jComboEmpleado, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(49, 49, 49)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jSlider_Descuanto, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jTextField_Descuento, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jButton_Aplicar_Descuento)
                    .addComponent(jTextField_Pago, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(53, 53, 53)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButton_guardar_venta, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton9, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton_ver_Formulario_venta, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jTextField_Total, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(45, Short.MAX_VALUE))
        );

        jPanel1.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 40, 490, 420));

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

        jTextField_Busqueda_Combo.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField_Busqueda_Combo.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Buscar", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 12))); // NOI18N
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

        jSpinner_Cantidad_Producto.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Cantidad", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 12))); // NOI18N
        jSpinner_Cantidad_Producto.addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
                jSpinner_Cantidad_Producto(evt);
            }
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
            }
        });

        jComboBox_Producto.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Producto", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 12))); // NOI18N
        jComboBox_Producto.setMinimumSize(new java.awt.Dimension(72, 45));
        jComboBox_Producto.setPreferredSize(new java.awt.Dimension(72, 4));
        jComboBox_Producto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox_Producto(evt);
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

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(16, 16, 16)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jTextField_Busqueda_Combo, javax.swing.GroupLayout.PREFERRED_SIZE, 291, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jButton_Agregar, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jButton_Borrar_p, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 19, Short.MAX_VALUE))))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addComponent(jComboBox_Producto, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jSpinner_Cantidad_Producto, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField_Busqueda_Combo, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton_Agregar, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton_Borrar_p, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jComboBox_Producto, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jSpinner_Cantidad_Producto, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 288, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(57, 57, 57))
        );

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 40, 530, 420));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 1026, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton_guardar_venta(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_guardar_venta
        guardarVentaProducto();

        JInternalFrame_Venta ventaForm = new JInternalFrame_Venta();

        JDesktopPane desktopPane = getDesktopPane();

        desktopPane.add(ventaForm);
        ventaForm.setVisible(true);

        try {
            ventaForm.setSelected(true);
        } catch (java.beans.PropertyVetoException e) {
            e.printStackTrace();
        }


    }//GEN-LAST:event_jButton_guardar_venta

    private void jButton9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton9ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton9ActionPerformed

    private void jTextField_BuscarCliente(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField_BuscarCliente

    }//GEN-LAST:event_jTextField_BuscarCliente

    private void jTextField_Venta(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField_Venta
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField_Venta

    private void jTextField_Fecha_Hora(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField_Fecha_Hora
        mostrarFechaHora();
    }//GEN-LAST:event_jTextField_Fecha_Hora

    private void jTable_Producto(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_jTable_Producto
        // TODO add your handling code here:
    }//GEN-LAST:event_jTable_Producto

    private void jComboBox_Producto(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox_Producto

    }//GEN-LAST:event_jComboBox_Producto

    private void jTextField_Busqueda_Combo(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField_Busqueda_Combo

    }//GEN-LAST:event_jTextField_Busqueda_Combo

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

    private void jSpinner_Cantidad_Producto(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_jSpinner_Cantidad_Producto
        // TODO add your handling code here:
    }//GEN-LAST:event_jSpinner_Cantidad_Producto

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

    private void jSlider_DescuantoStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_jSlider_DescuantoStateChanged
        jSlider_Descuanto.addChangeListener(e -> {
            int descuento = jSlider_Descuanto.getValue();
            SwingUtilities.invokeLater(() -> {
                jTextField_Descuento.setText(descuento + "%");
            });
        });
    }//GEN-LAST:event_jSlider_DescuantoStateChanged

    private void jSlider_DescuantoMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jSlider_DescuantoMouseReleased

    }//GEN-LAST:event_jSlider_DescuantoMouseReleased

    private void jTextField_Descuento(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField_Descuento

    }//GEN-LAST:event_jTextField_Descuento

    private void jTextField_DescuentoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField_DescuentoKeyTyped

    }//GEN-LAST:event_jTextField_DescuentoKeyTyped

    private void jTextField_Total(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField_Total
        calcularTotalTabla();
    }//GEN-LAST:event_jTextField_Total

    private void jComboEmpleadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboEmpleadoActionPerformed


    }//GEN-LAST:event_jComboEmpleadoActionPerformed

    private void jComboClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboClienteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboClienteActionPerformed

    private void jTextField_BuscarClienteKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField_BuscarClienteKeyReleased
        String busqueda = jTextField_BuscarCliente.getText();

        CRUD_Venta_Producto gr = new CRUD_Venta_Producto();
        ArrayList<Clase_Cliente> listaClientes = gr.buscarClientes(busqueda);
        jComboCliente.removeAllItems();
        for (Clase_Cliente cliente : listaClientes) {
            jComboCliente.addItem(cliente);
        }
    }//GEN-LAST:event_jTextField_BuscarClienteKeyReleased

    private void jTextField_Pago(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField_Pago
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField_Pago

    private void jButton_ver_Formulario_ventaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_ver_Formulario_ventaActionPerformed
        JInternalFrame_Venta ventaForm = new JInternalFrame_Venta();
        JDesktopPane desktopPane = getDesktopPane();

        // Centrar el formulario en el JDesktopPane
        int x = (desktopPane.getWidth() - ventaForm.getWidth()) / 2;
        int y = (desktopPane.getHeight() - ventaForm.getHeight()) / 2;
        ventaForm.setLocation(x, y);

        desktopPane.add(ventaForm);
        ventaForm.setVisible(true);

        JInternalFrame_Venta_Producto.this.dispose();
    }//GEN-LAST:event_jButton_ver_Formulario_ventaActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton9;
    private javax.swing.JButton jButton_Agregar;
    private javax.swing.JButton jButton_Aplicar_Descuento;
    private javax.swing.JButton jButton_Borrar_p;
    public static javax.swing.JButton jButton_guardar_venta;
    public static javax.swing.JButton jButton_ver_Formulario_venta;
    public static javax.swing.JComboBox<Clase_Producto> jComboBox_Producto;
    public static javax.swing.JComboBox<Clase_Cliente> jComboCliente;
    public javax.swing.JComboBox<Clase_Empleado> jComboEmpleado;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSlider jSlider_Descuanto;
    private javax.swing.JSpinner jSpinner_Cantidad_Producto;
    public static javax.swing.JTable jTable_Producto;
    private javax.swing.JTextField jTextField_BuscarCliente;
    private javax.swing.JTextField jTextField_Busqueda_Combo;
    public static javax.swing.JTextField jTextField_Descuento;
    private javax.swing.JTextField jTextField_Fecha_Hora;
    private javax.swing.JTextField jTextField_Pago;
    private javax.swing.JTextField jTextField_Total;
    private javax.swing.JTextField jTextField_Venta;
    // End of variables declaration//GEN-END:variables
}
