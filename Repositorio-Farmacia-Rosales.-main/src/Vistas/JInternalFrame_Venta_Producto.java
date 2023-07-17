package Vistas;

import Controlador.CRUD_Venta;
import Controlador.CRUD_Venta_Producto;
import Modelo.Clase_Cliente;
import Modelo.Clase_Empleado;
import Vistas.JInternalFrame_Venta;
import java.util.List;


import Modelo.Clase_Producto;
import Modelo.Clase_Producto_Cargardatos;
import Modelo.Clase_Venta;
import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import java.math.BigDecimal;
import java.security.Timestamp;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import javax.swing.BorderFactory;
import javax.swing.DefaultListCellRenderer;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JDesktopPane;
import javax.swing.JFormattedTextField;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.SwingConstants;
import javax.swing.Timer;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

public class JInternalFrame_Venta_Producto extends javax.swing.JInternalFrame {

    private Timer timer;
    private BigDecimal totalActual = BigDecimal.ZERO;
        private BigDecimal tasaCambioNicaragua;


    public JInternalFrame_Venta_Producto() {
        initComponents();
      centrarRegistrosTabla();
        personalizarTitulosTabla();
        ajustarAlturaFilasTabla();
        jButton_guardar_venta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_guardar_venta(evt);
            }
        });
        jTextField_Pago.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                calcularCambio();
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                calcularCambio();
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                calcularCambio();
            }
        });
        jTextField_Descuento.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                calcularTotalConDescuento();
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                calcularTotalConDescuento();
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                calcularTotalConDescuento();
            }
        });
        
        jTextField_Total.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                calcularCambio();
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                calcularCambio();
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                calcularCambio();
            }
        });
        
        
        mostrarFechaHora();
        iniciarTimer();
        jTextField_Fecha_Hora.setEditable(false);
     
        llenarComboEmpleados(jComboEmpleado);
        
      
        jComboCliente.setBackground(Color.WHITE);
        jComboBox_Producto.setBackground(Color.WHITE);
       
        jTable_Producto.setBackground(Color.WHITE);
        // Configurar el aspecto del jSlider_Descuanto
        UIManager.put("Slider.background", Color.WHITE);
        UIManager.put("Slider.foreground", Color.BLUE);
        UIManager.put("Slider.track", Color.LIGHT_GRAY);
        UIManager.put("Slider.thumb", Color.DARK_GRAY);

    }
    private void calcularTotalConDescuento() {
        try {
            String descuentoStr = jTextField_Descuento.getText().trim();
            BigDecimal descuento;
            
            // Verificar si la caja de descuento está vacía.
            if (!descuentoStr.isEmpty()) {
                descuento = new BigDecimal(descuentoStr).divide(new BigDecimal("100"));
            } else {
                descuento = BigDecimal.ZERO;
            }
            
            BigDecimal totalConDescuento = totalActual.subtract(totalActual.multiply(descuento));
            jTextField_Total.setText(totalConDescuento.toString());
        } catch (NumberFormatException e) {
            // Manejar la excepción aquí. Podrías mostrar una ventana de diálogo con un mensaje de error, por ejemplo.
            JOptionPane.showMessageDialog(null, "El valor ingresado en la caja de descuento no es válido. Por favor ingrese un número.");
        }
    }
    
    private void calcularCambio() {
        try {
            BigDecimal pago = new BigDecimal(jTextField_Pago.getText().trim());
            BigDecimal total = new BigDecimal(jTextField_Total.getText().trim());
            BigDecimal cambio = pago.subtract(total);
            jTextField_Cambio.setText(cambio.toString());
        } catch (NumberFormatException e) {
            // Puedes manejar la excepción aquí. Por ejemplo, podrías limpiar el campo jTextField_Cambio.
            jTextField_Cambio.setText("");
        }
    }


    

  

    private void centrarRegistrosTabla() {
        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(SwingConstants.CENTER);
        jTable_Producto.setDefaultRenderer(Object.class, centerRenderer);
    }

    private void personalizarTitulosTabla() {
        DefaultTableCellRenderer headerRenderer = (DefaultTableCellRenderer) jTable_Producto.getTableHeader().getDefaultRenderer();
        headerRenderer.setHorizontalAlignment(SwingConstants.CENTER);
        jTable_Producto.getTableHeader().setDefaultRenderer(headerRenderer);
        jTable_Producto.getTableHeader().setBackground(new Color(0, 153, 153));
        jTable_Producto.getTableHeader().setForeground(Color.WHITE);
        jTable_Producto.getTableHeader().setFont(new Font("Segoe UI", Font.BOLD, 14));
        jTable_Producto.getTableHeader().setBorder(BorderFactory.createLineBorder(Color.BLACK));
    }

    private void ajustarAlturaFilasTabla() {
        jTable_Producto.setRowHeight(25); // Ajusta aquí la altura deseada en píxeles
    }

    public void limpiarCampos() {
      
        jComboCliente.setSelectedIndex(-1);
        jComboEmpleado.setSelectedIndex(-1);
        jTextField_BuscarCliente.setText("");
    }

    public void Limpiar() {
    jTextField_Busqueda_Combo.setText("");
    jSpinner_Cantidad_Producto.setValue(0);
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
    
    // Cambiar el color de fondo del JTextField
    jTextField_Fecha_Hora.setBackground(Color.WHITE);
}
   private boolean isValidNumber(String text) {
    try {
        int value = Integer.parseInt(text);
        return value >= 0 && value <= 100;
    } catch (NumberFormatException e) {
        return false;
    }
}

    public void llenarproducto(String busqueda) {
        CRUD_Venta_Producto gr = new CRUD_Venta_Producto();
        ArrayList<Clase_Producto_Cargardatos> listaProductos = gr.buscarProductos(busqueda);
        jComboBox_Producto.removeAllItems();
        for (Clase_Producto_Cargardatos producto : listaProductos) {
            jComboBox_Producto.addItem(producto);
        }
    }

public void agregarProductoATabla() {
    Clase_Producto_Cargardatos productoSeleccionado = (Clase_Producto_Cargardatos) jComboBox_Producto.getSelectedItem();
    int cantidad = (int) jSpinner_Cantidad_Producto.getValue();

    // Verificar si el producto ya está agregado en la tabla
    DefaultTableModel modelProducto = (DefaultTableModel) jTable_Producto.getModel();
    for (int i = 0; i < modelProducto.getRowCount(); i++) {
        Integer idProducto = (Integer) modelProducto.getValueAt(i, 0);
        if (idProducto != null && idProducto.intValue() == productoSeleccionado.getId_Producto()) {
            JOptionPane.showMessageDialog(null, "El producto ya ha sido agregado a la tabla.");
            return;
        }
    }

    if (productoSeleccionado == null || cantidad <= 0) {
        JOptionPane.showMessageDialog(null, "Debe seleccionar un producto y especificar una cantidad válida.");
        return;
    }

    // Agregamos los detalles del producto a la primera tabla
    BigDecimal precioVenta = BigDecimal.valueOf(productoSeleccionado.getPrecio_Venta());
    BigDecimal total = precioVenta.multiply(BigDecimal.valueOf(cantidad));

    modelProducto.insertRow(0, new Object[]{
        productoSeleccionado.getId_Producto(),
        productoSeleccionado.getNombre(),
        String.valueOf(precioVenta),
        cantidad,
        total
    });

    // Agregamos los detalles de la descripción, categoría, presentación y laboratorio a la segunda tabla
    DefaultTableModel modelDetalles = (DefaultTableModel) jTable_Prsmks.getModel();

    modelDetalles.insertRow(0, new Object[]{
        productoSeleccionado.getDescripcion(), // La descripción va en la primera columna (columna 0)
        productoSeleccionado.getId_Categoria(), // La categoría va en la segunda columna (columna 1)
        productoSeleccionado.getId_Presentacion(), // La presentación va en la tercera columna (columna 2)
        productoSeleccionado.getId_Laboratorio() // El laboratorio va en la cuarta columna (columna 3)
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

    public void llenarComboClientes(JComboBox<Clase_Cliente> jComboCliente, String busqueda) {
    CRUD_Venta_Producto gr = new CRUD_Venta_Producto();
    ArrayList<Clase_Cliente> clientes = gr.obtenerNombresApellidosCliente();
    jComboCliente.removeAllItems(); // Limpiar el JComboBox
    for (Clase_Cliente cliente : clientes) {
        jComboCliente.addItem(cliente);
    }

}


   public void llenarComboEmpleados(JComboBox<Clase_Empleado> jComboEmpleado) {
    CRUD_Venta_Producto gr = new CRUD_Venta_Producto();
    ArrayList<Clase_Empleado> empleados = gr.obtenerEmpleados();
    jComboEmpleado.removeAllItems(); // Limpiar el JComboBox

    // Configurar el renderizador personalizado
    jComboEmpleado.setRenderer(new DefaultListCellRenderer() {
        @Override
        public Component getListCellRendererComponent(JList<?> list, Object value, int index,
                boolean isSelected, boolean cellHasFocus) {
            if (value instanceof Clase_Empleado) {
                Clase_Empleado empleado = (Clase_Empleado) value;
                String displayText = empleado.getId_Empleado() + " - " + empleado.getNombre_1() + " " + empleado.getApellido_1();
                return super.getListCellRendererComponent(list, displayText, index, isSelected, cellHasFocus);
            } else {
                return super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
            }
        }
    });

    // Agregar los empleados al JComboBox
    for (Clase_Empleado empleado : empleados) {
        jComboEmpleado.addItem(empleado);
    }

    // Establecer el color de fondo
    jComboEmpleado.setBackground(Color.WHITE);
}

  public void guardarVentaProducto() {
    CRUD_Venta_Producto ventaProductoDAO = new CRUD_Venta_Producto();

    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.SSS");
    LocalDateTime fechaHora = LocalDateTime.parse(jTextField_Fecha_Hora.getText().trim(), formatter);

    Clase_Cliente clienteSeleccionado = (Clase_Cliente) jComboCliente.getSelectedItem();
    int idCliente = (clienteSeleccionado != null) ? clienteSeleccionado.getId_Cliente() : -1;

    Object itemEmpleado = jComboEmpleado.getSelectedItem();
    Clase_Empleado empleadoSeleccionado = null;
    try {
        empleadoSeleccionado = (Clase_Empleado) itemEmpleado;
    } catch (ClassCastException e) {
        JOptionPane.showMessageDialog(null, "El item seleccionado no es una instancia de Clase_Empleado");
        e.printStackTrace();
        return;
    }
    int idEmpleado = (empleadoSeleccionado != null) ? empleadoSeleccionado.getId_Empleado() : 0;

    String descuentoStr = jTextField_Descuento.getText().trim();
    descuentoStr = descuentoStr.replace("%", "");
    BigDecimal descuento = null;

    if (!descuentoStr.isEmpty()) {
        try {
            descuento = new BigDecimal(descuentoStr);
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Por favor, introduce un número válido para el descuento.");
            return;
        }
    }

    // Obtener el modelo de la tabla de productos
    DefaultTableModel modelo = (DefaultTableModel) jTable_Producto.getModel();

    List<Clase_Venta> ventas = new ArrayList<>();

    for (int i = 0; i < modelo.getRowCount(); i++) {
        int idProducto = 0;
        int cantidad = 0;

        Object idProductoObj = modelo.getValueAt(i, 0);
        Object cantidadObj = modelo.getValueAt(i, 3);

        if (idProductoObj != null && cantidadObj != null) {
            idProducto = Integer.parseInt(idProductoObj.toString());
            cantidad = Integer.parseInt(cantidadObj.toString());

            Clase_Venta venta = new Clase_Venta(fechaHora, idCliente, idEmpleado, cantidad, descuento, idProducto);
            ventas.add(venta);
        }
    }

    // Agregar todas las ventas y productos en la base de datos
    ventaProductoDAO.agregarVentasYProductos(ventas);
}






    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jTextField_BuscarCliente = new javax.swing.JTextField();
        jTextField_Fecha_Hora = new javax.swing.JTextField();
        jComboEmpleado = new javax.swing.JComboBox<>();
        jComboCliente = new javax.swing.JComboBox<>();
        jButton_guardar_venta = new javax.swing.JButton();
        jButton_ver_Formulario_venta = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        jTextField_Cambio = new javax.swing.JTextField();
        jTextField_Total = new javax.swing.JTextField();
        jTextField_Pago = new javax.swing.JTextField();
        jTextField_Descuento = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        jTextField_Busqueda_Combo = new javax.swing.JTextField();
        jSpinner_Cantidad_Producto = new javax.swing.JSpinner();
        jComboBox_Producto = new javax.swing.JComboBox<>();
        jButton_Agregar = new javax.swing.JButton();
        jButton_Borrar_p = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable_Prsmks = new javax.swing.JTable();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable_Producto = new javax.swing.JTable();

        setBackground(new java.awt.Color(255, 255, 255));
        setClosable(true);
        setIconifiable(true);

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
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 1119, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addContainerGap(9, Short.MAX_VALUE))
        );

        jPanel1.add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, 40));

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

        jButton_guardar_venta.setBackground(new java.awt.Color(153, 255, 153));
        jButton_guardar_venta.setFont(new java.awt.Font("Dialog", 1, 11)); // NOI18N
        jButton_guardar_venta.setText("Guardar");
        jButton_guardar_venta.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        jButton_guardar_venta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_guardar_venta(evt);
            }
        });

        jButton_ver_Formulario_venta.setBackground(new java.awt.Color(204, 204, 255));
        jButton_ver_Formulario_venta.setFont(new java.awt.Font("Dialog", 1, 11)); // NOI18N
        jButton_ver_Formulario_venta.setText("Ver Ventas");
        jButton_ver_Formulario_venta.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jButton_ver_Formulario_venta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_ver_Formulario_ventaActionPerformed(evt);
            }
        });

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));
        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Total", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 12))); // NOI18N

        jTextField_Cambio.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField_Cambio.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Vuelto", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 12))); // NOI18N
        jTextField_Cambio.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        jTextField_Cambio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField_Cambio(evt);
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

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTextField_Cambio)
                    .addComponent(jTextField_Pago)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jTextField_Total, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 3, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(jTextField_Pago, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jTextField_Cambio, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jTextField_Total, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(95, Short.MAX_VALUE))
        );

        jTextField_Descuento.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField_Descuento.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Descuento %", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 12))); // NOI18N
        jTextField_Descuento.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        jTextField_Descuento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField_Descuento(evt);
            }
        });
        jTextField_Descuento.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextField_DescuentoKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextField_DescuentoKeyTyped(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(17, 17, 17)
                        .addComponent(jTextField_BuscarCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(jTextField_Descuento, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jTextField_Fecha_Hora, javax.swing.GroupLayout.PREFERRED_SIZE, 246, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jComboCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 246, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(jComboEmpleado, javax.swing.GroupLayout.PREFERRED_SIZE, 259, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel3Layout.createSequentialGroup()
                                        .addGap(34, 34, 34)
                                        .addComponent(jButton_guardar_venta, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jButton_ver_Formulario_venta, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(38, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(49, 49, 49)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField_BuscarCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField_Descuento, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField_Fecha_Hora, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jComboEmpleado, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButton_guardar_venta, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton_ver_Formulario_venta, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(131, 131, 131))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())))
        );

        jPanel1.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 40, 490, 490));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

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

        jButton_Agregar.setBackground(new java.awt.Color(153, 255, 153));
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
        jButton_Borrar_p.setText("Eliminar");
        jButton_Borrar_p.setBorder(javax.swing.BorderFactory.createEtchedBorder(javax.swing.border.EtchedBorder.RAISED));
        jButton_Borrar_p.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_Borrar_p(evt);
            }
        });

        jTable_Prsmks.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Descripcion", "Categoria", "Presentacion", "Laboratorio"
            }
        ));
        jScrollPane2.setViewportView(jTable_Prsmks);

        jTable_Producto.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        jTable_Producto.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "ID", "Nombre", "Precio Venta", "Cantidad", "total"
            }
        ));
        jTable_Producto.setGridColor(new java.awt.Color(0, 0, 0));
        jTable_Producto.setShowGrid(true);
        jScrollPane1.setViewportView(jTable_Producto);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 581, Short.MAX_VALUE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jComboBox_Producto, javax.swing.GroupLayout.PREFERRED_SIZE, 353, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextField_Busqueda_Combo, javax.swing.GroupLayout.PREFERRED_SIZE, 291, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jButton_Agregar, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(34, 34, 34)
                                .addComponent(jButton_Borrar_p, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jSpinner_Cantidad_Producto, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jScrollPane2))
                .addContainerGap(21, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField_Busqueda_Combo, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton_Agregar, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton_Borrar_p, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jComboBox_Producto, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jSpinner_Cantidad_Producto, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(286, 286, 286))
        );

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 40, 620, 490));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton_guardar_venta(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_guardar_venta
        // Guardar la venta y los productos
        guardarVentaProducto();

        // Obtener una referencia al contenedor padre (MDIMenu)
        Container container = getParent();
        if (container instanceof JDesktopPane) {
            JDesktopPane desktopPane = (JDesktopPane) container;

            // Cerrar el formulario actual
            dispose();

            // Buscar el formulario JInternalFrame_Venta en el JDesktopPane
            JInternalFrame_Venta ventaForm = null;
            JInternalFrame[] frames = desktopPane.getAllFrames();
            for (JInternalFrame frame : frames) {
                if (frame instanceof JInternalFrame_Venta) {
                    ventaForm = (JInternalFrame_Venta) frame;
                    break;
                }
            }

            if (ventaForm != null) {
                try {
                    ventaForm.setSelected(true);
                    return; // Salir del método después de seleccionar el formulario
                } catch (java.beans.PropertyVetoException e) {
                    e.printStackTrace();
                }
            } else {
                // Mostrar el formulario JInternalFrame_Venta si no se encontró
                ventaForm = new JInternalFrame_Venta();
                desktopPane.add(ventaForm);
                ventaForm.setVisible(true);
                try {
                    ventaForm.setSelected(true);
                } catch (java.beans.PropertyVetoException e) {
                    e.printStackTrace();
                }
            }
        }


    }//GEN-LAST:event_jButton_guardar_venta

    private void jTextField_BuscarCliente(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField_BuscarCliente

    }//GEN-LAST:event_jTextField_BuscarCliente

    private void jTextField_Fecha_Hora(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField_Fecha_Hora
        mostrarFechaHora();
    }//GEN-LAST:event_jTextField_Fecha_Hora

    private void jComboBox_Producto(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox_Producto
      jComboBox_Producto.setBackground(Color.WHITE);

    }//GEN-LAST:event_jComboBox_Producto

    private void jTextField_Busqueda_Combo(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField_Busqueda_Combo

    }//GEN-LAST:event_jTextField_Busqueda_Combo

    private void jTextField_Busqueda_ComboKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField_Busqueda_ComboKeyReleased
        String busqueda = jTextField_Busqueda_Combo.getText(); // Obtener el texto ingresado en el campo de búsqueda

        CRUD_Venta_Producto gr = new CRUD_Venta_Producto();
        ArrayList<Clase_Producto_Cargardatos> listaProductos = gr.buscarProductos(busqueda);
        jComboBox_Producto.removeAllItems();
        for (Clase_Producto_Cargardatos producto : listaProductos) {
            jComboBox_Producto.addItem(producto);
        }
    }//GEN-LAST:event_jTextField_Busqueda_ComboKeyReleased

    private void jButton_Agregar(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_Agregar
        agregarProductoATabla();
        Limpiar();
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
        jSpinner_Cantidad_Producto.setBackground(new Color(204, 255, 255));
                    
                    
        JSpinner spinner = (JSpinner) evt.getSource();
        JComponent editor = spinner.getEditor();
        JFormattedTextField textField = ((JSpinner.DefaultEditor) editor).getTextField();

        textField.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                char c = e.getKeyChar();
                if (!Character.isDigit(c)) {
                    e.consume();
                }
            }
        });

    }//GEN-LAST:event_jSpinner_Cantidad_Producto

    private void jTextField_Descuento(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField_Descuento

    }//GEN-LAST:event_jTextField_Descuento

    private void jTextField_DescuentoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField_DescuentoKeyTyped
     char c = evt.getKeyChar();
    
    // Verificar si el caracter es un dígito o el carácter de retroceso (backspace)
    if (!Character.isDigit(c) && c != KeyEvent.VK_BACK_SPACE) {
        evt.consume(); // Consumir el evento para evitar que se ingrese el carácter no válido
    }
    
    // Obtener el texto actual en el JTextField
    String currentText = jTextField_Descuento.getText();
    
    // Obtener el nuevo texto agregando el carácter actual
    String newText = currentText + c;
    
    // Verificar si el nuevo texto es un número válido en el rango de 0 a 100
    if (!isValidNumber(newText)) {
        evt.consume(); // Consumir el evento para evitar que se ingrese el carácter no válido
    }
    }//GEN-LAST:event_jTextField_DescuentoKeyTyped

    private void jTextField_Total(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField_Total
        calcularTotalTabla();
    }//GEN-LAST:event_jTextField_Total

    private void jComboEmpleadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboEmpleadoActionPerformed


    }//GEN-LAST:event_jComboEmpleadoActionPerformed

    private void jComboClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboClienteActionPerformed
       
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

    private void jButton_ver_Formulario_ventaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_ver_Formulario_ventaActionPerformed
        Container container = getParent();
        if (container instanceof JDesktopPane) {
            JDesktopPane desktopPane = (JDesktopPane) container;

            // Buscar el formulario JInternalFrame_Venta en el JDesktopPane
            JInternalFrame_Venta ventaForm = null;
            JInternalFrame[] frames = desktopPane.getAllFrames();
            for (JInternalFrame frame : frames) {
                if (frame instanceof JInternalFrame_Venta) {
                    ventaForm = (JInternalFrame_Venta) frame;
                    break;
                }
            }

            if (ventaForm != null) {
                // Si el formulario ya está abierto, selecciónalo
                try {
                    ventaForm.setSelected(true);
                } catch (java.beans.PropertyVetoException e) {
                    e.printStackTrace();
                }
            } else {
                // Si el formulario no está abierto, crea una nueva instancia y añádela al JDesktopPane
                ventaForm = new JInternalFrame_Venta();
                desktopPane.add(ventaForm);
                ventaForm.setVisible(true);
                try {
                    ventaForm.setSelected(true);
                } catch (java.beans.PropertyVetoException e) {
                    e.printStackTrace();
                }
            }
        }
    }//GEN-LAST:event_jButton_ver_Formulario_ventaActionPerformed

    private void jTextField_Cambio(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField_Cambio
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField_Cambio

    private void jTextField_DescuentoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField_DescuentoKeyReleased
     
    }//GEN-LAST:event_jTextField_DescuentoKeyReleased

    private void jTextField_Pago(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField_Pago
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField_Pago


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton_Agregar;
    private javax.swing.JButton jButton_Borrar_p;
    public static javax.swing.JButton jButton_guardar_venta;
    public static javax.swing.JButton jButton_ver_Formulario_venta;
    public static javax.swing.JComboBox<Clase_Producto_Cargardatos> jComboBox_Producto;
    public static javax.swing.JComboBox<Clase_Cliente> jComboCliente;
    public javax.swing.JComboBox<Clase_Empleado> jComboEmpleado;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSpinner jSpinner_Cantidad_Producto;
    public static javax.swing.JTable jTable_Producto;
    private javax.swing.JTable jTable_Prsmks;
    private javax.swing.JTextField jTextField_BuscarCliente;
    private javax.swing.JTextField jTextField_Busqueda_Combo;
    private javax.swing.JTextField jTextField_Cambio;
    public static javax.swing.JTextField jTextField_Descuento;
    private javax.swing.JTextField jTextField_Fecha_Hora;
    private javax.swing.JTextField jTextField_Pago;
    private javax.swing.JTextField jTextField_Total;
    // End of variables declaration//GEN-END:variables
}
