package Vistas;

import Controlador.CRUD_Compra_Producto;
import Modelo.Clase_Producto;
import Modelo.Clase_Proveedor;
import Modelo.Class_Compra;
import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Font;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.BorderFactory;
import javax.swing.DefaultListCellRenderer;
import javax.swing.JComboBox;
import javax.swing.JDesktopPane;
import javax.swing.JInternalFrame;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.DateFormatter;

public class JInternalFrame_Compra_Producto extends javax.swing.JInternalFrame {

    private BigDecimal totalActual = BigDecimal.ZERO;

    public JInternalFrame_Compra_Producto() {
        initComponents();
        ajustarAlturaFilasTabla();
        personalizarTitulosTabla();
        centrarRegistrosTabla();
        jButton_guardar_compra.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_guardar_compra(evt);
            }
        });
        jTextField_Fecha_Hora.setEditable(false); // Establecer el campo de texto como no editable
        mostrarFechaActual();
        llenarComboProveedor(jComboProveedor);
        jTextField_Fecha_Hora.setBackground(Color.WHITE);
        jComboBox_Producto.setBackground(Color.WHITE);
        jSpinner_Cantidad_Producto.setBackground(Color.WHITE);
        // Configurar el aspecto del jSlider_Descuanto
        UIManager.put("Slider.background", Color.WHITE);
        UIManager.put("Slider.foreground", Color.BLUE);
        UIManager.put("Slider.track", Color.LIGHT_GRAY);
        UIManager.put("Slider.thumb", Color.DARK_GRAY);

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

    private void mostrarFechaActual() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd"); // Define el formato deseado de la fecha
        String fechaActual = dateFormat.format(new Date()); // Obtiene la fecha actual formateada
        jTextField_Fecha_Hora.setText(fechaActual); // Establece el valor de la fecha en el jTextField
    }

    public void Limpiar() {
        jTextField_Busqueda_Combo.setText("");

    }

    public void llenarComboProveedor(JComboBox<Clase_Proveedor> jComboProveedor) {
        CRUD_Compra_Producto gr = new CRUD_Compra_Producto();
        ArrayList<Clase_Proveedor> proveedores = gr.obtenerProveedor();
        jComboProveedor.removeAllItems(); // Limpiar el JComboBox

        // Configurar el renderizador personalizado
        jComboProveedor.setRenderer(new DefaultListCellRenderer() {
            @Override
            public Component getListCellRendererComponent(JList<?> list, Object value, int index,
                    boolean isSelected, boolean cellHasFocus) {
                if (value instanceof Clase_Proveedor) {
                    Clase_Proveedor proveedor = (Clase_Proveedor) value;
                    String displayText = proveedor.getId_Proveedor() + " - " + proveedor.getNombre_1() + " " + proveedor.getApellido_1();
                    return super.getListCellRendererComponent(list, displayText, index, isSelected, cellHasFocus);
                } else {
                    return super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
                }
            }
        });

        for (Clase_Proveedor proveedor : proveedores) {
            jComboProveedor.addItem(proveedor);
        }

        // Establecer el color de fondo
        jComboProveedor.setBackground(Color.WHITE);
    }

    public void guardarCompraProducto() {
    CRUD_Compra_Producto compraProductoDAO = new CRUD_Compra_Producto();

    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
    LocalDate fechaCompra = LocalDate.parse(jTextField_Fecha_Hora.getText().trim(), formatter);

    Clase_Proveedor proveedorSeleccionado = (Clase_Proveedor) jComboProveedor.getSelectedItem();

    if (proveedorSeleccionado == null) {
        JOptionPane.showMessageDialog(null, "Debe seleccionar un proveedor válido.");
        return;
    }

    int idProveedor = proveedorSeleccionado.getId_Proveedor();

    for (int i = 0; i < jTable_Producto.getRowCount(); i++) {
        int idProducto = 0;
        int cantidad = 0;

        Object idProductoObj = jTable_Producto.getValueAt(i, 0);
        Object cantidadObj = jTable_Producto.getValueAt(i, 3);

        if (idProductoObj != null && cantidadObj != null) {
            idProducto = Integer.parseInt(idProductoObj.toString());
            cantidad = Integer.parseInt(cantidadObj.toString());

            Class_Compra compra = new Class_Compra(fechaCompra, idProveedor, cantidad, idProducto);
            compraProductoDAO.agregarCompraYProducto(compra);
        }
    }

    JOptionPane.showMessageDialog(null, "Se guardó correctamente la compra.");
}
        
    

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jInternalFrame1 = new javax.swing.JInternalFrame();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jButton3 = new javax.swing.JButton();
        jTextField8 = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jTextField10 = new javax.swing.JTextField();
        jTextField11 = new javax.swing.JTextField();
        jButton6 = new javax.swing.JButton();
        jButton9 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jTextField12 = new javax.swing.JTextField();
        jButton7 = new javax.swing.JButton();
        jPanel5 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jPanel7 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jTextField_Fecha_Hora = new javax.swing.JTextField();
        jComboProveedor = new javax.swing.JComboBox<>();
        jButton_guardar_compra = new javax.swing.JButton();
        jTextField_Total = new javax.swing.JTextField();
        jButton_ver_Formulario_venta = new javax.swing.JButton();
        jPanel8 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable_Producto = new javax.swing.JTable();
        jTextField_Busqueda_Combo = new javax.swing.JTextField();
        jSpinner_Cantidad_Producto = new javax.swing.JSpinner();
        jComboBox_Producto = new javax.swing.JComboBox<>();
        jButton_Agregar = new javax.swing.JButton();
        jButton_Borrar_p = new javax.swing.JButton();

        setClosable(true);
        setIconifiable(true);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 153, 153));
        jLabel2.setText("Id Compra_Producto");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 190, -1, -1));

        jLabel3.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 153, 153));
        jLabel3.setText("Id Producto");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 90, -1, -1));

        jLabel4.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 153, 153));
        jLabel4.setText("Id Compra");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 140, -1, -1));

        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Vistas_Iconos/Buscar.png"))); // NOI18N
        jButton3.setBorder(null);
        jPanel1.add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 50, 20, 20));

        jTextField8.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField8.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        jTextField8.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        jPanel1.add(jTextField8, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 140, 160, 20));

        jTable1.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Id Compra_Producto", "Id Producto", "Id Compra"
            }
        ));
        jTable1.setGridColor(new java.awt.Color(0, 153, 153));
        jTable1.setShowGrid(true);
        jScrollPane1.setViewportView(jTable1);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 270, 740, 120));

        jTextField10.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField10.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        jTextField10.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        jPanel1.add(jTextField10, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 190, 160, 20));

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
        jPanel1.add(jTextField11, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 50, 160, -1));

        jButton6.setBackground(new java.awt.Color(0, 153, 153));
        jButton6.setFont(new java.awt.Font("Dialog", 1, 11)); // NOI18N
        jButton6.setForeground(new java.awt.Color(255, 255, 255));
        jButton6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Vistas_Iconos/editar.png"))); // NOI18N
        jButton6.setText("Editar");
        jButton6.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton6, new org.netbeans.lib.awtextra.AbsoluteConstraints(770, 150, 100, 40));

        jButton9.setBackground(new java.awt.Color(0, 153, 153));
        jButton9.setFont(new java.awt.Font("Dialog", 1, 11)); // NOI18N
        jButton9.setForeground(new java.awt.Color(255, 255, 255));
        jButton9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Vistas_Iconos/Actualizar.png"))); // NOI18N
        jButton9.setText("Actualizar");
        jButton9.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jButton9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton9ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton9, new org.netbeans.lib.awtextra.AbsoluteConstraints(770, 210, 100, 40));

        jButton4.setBackground(new java.awt.Color(0, 153, 153));
        jButton4.setFont(new java.awt.Font("Dialog", 1, 11)); // NOI18N
        jButton4.setForeground(new java.awt.Color(255, 255, 255));
        jButton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Vistas_Iconos/eliminar.png"))); // NOI18N
        jButton4.setText("Eliminar");
        jButton4.setBorder(javax.swing.BorderFactory.createEtchedBorder(javax.swing.border.EtchedBorder.RAISED));
        jPanel1.add(jButton4, new org.netbeans.lib.awtextra.AbsoluteConstraints(770, 270, 100, -1));

        jLabel5.setFont(new java.awt.Font("Dialog", 1, 13)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0, 153, 153));
        jLabel5.setText("Registro");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 250, -1, -1));

        jTextField12.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField12.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        jTextField12.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        jPanel1.add(jTextField12, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 90, 160, 20));

        jButton7.setBackground(new java.awt.Color(0, 153, 153));
        jButton7.setFont(new java.awt.Font("Dialog", 1, 11)); // NOI18N
        jButton7.setForeground(new java.awt.Color(255, 255, 255));
        jButton7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Vistas_Iconos/Guardar Compra.png"))); // NOI18N
        jButton7.setText("Guardar");
        jButton7.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton7, new org.netbeans.lib.awtextra.AbsoluteConstraints(770, 90, 100, 40));

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
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 888, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 172, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addContainerGap(9, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addContainerGap())
        );

        jPanel1.add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1060, 40));

        javax.swing.GroupLayout jInternalFrame1Layout = new javax.swing.GroupLayout(jInternalFrame1.getContentPane());
        jInternalFrame1.getContentPane().setLayout(jInternalFrame1Layout);
        jInternalFrame1Layout.setHorizontalGroup(
            jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
        );
        jInternalFrame1Layout.setVerticalGroup(
            jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel7.setBackground(new java.awt.Color(0, 153, 153));

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText("Farmacia Rosales");

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, 1070, Short.MAX_VALUE)
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel6)
                .addContainerGap(9, Short.MAX_VALUE))
        );

        jPanel2.add(jPanel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1070, 40));

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        jTextField_Fecha_Hora.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField_Fecha_Hora.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Fecha ", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 12))); // NOI18N
        jTextField_Fecha_Hora.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        jTextField_Fecha_Hora.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField_Fecha_Hora(evt);
            }
        });

        jComboProveedor.setFont(new java.awt.Font("Roboto Medium", 0, 14)); // NOI18N
        jComboProveedor.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Proveedor", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 12))); // NOI18N
        jComboProveedor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboProveedorActionPerformed(evt);
            }
        });

        jButton_guardar_compra.setBackground(new java.awt.Color(153, 255, 153));
        jButton_guardar_compra.setFont(new java.awt.Font("Dialog", 1, 11)); // NOI18N
        jButton_guardar_compra.setText("Guardar");
        jButton_guardar_compra.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        jButton_guardar_compra.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_guardar_compra(evt);
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

        jButton_ver_Formulario_venta.setBackground(new java.awt.Color(255, 255, 204));
        jButton_ver_Formulario_venta.setFont(new java.awt.Font("Dialog", 1, 11)); // NOI18N
        jButton_ver_Formulario_venta.setText("Ver Compra");
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
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addGap(0, 20, Short.MAX_VALUE)
                        .addComponent(jComboProveedor, javax.swing.GroupLayout.PREFERRED_SIZE, 273, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jTextField_Fecha_Hora, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(125, 125, 125)
                        .addComponent(jTextField_Total, javax.swing.GroupLayout.PREFERRED_SIZE, 186, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(71, 71, 71)
                .addComponent(jButton_guardar_compra, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton_ver_Formulario_venta, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(116, 116, 116))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jTextField_Fecha_Hora, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboProveedor, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(41, 41, 41)
                .addComponent(jTextField_Total, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(55, 55, 55)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton_guardar_compra, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton_ver_Formulario_venta, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(251, Short.MAX_VALUE))
        );

        jPanel2.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 40, 490, 490));

        jPanel8.setBackground(new java.awt.Color(255, 255, 255));
        jPanel8.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

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
                "ID", "Nombre", "Precio Compra", "Cantidad", "total"
            }
        ));
        jTable_Producto.setGridColor(new java.awt.Color(0, 0, 0));
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
        jScrollPane2.setViewportView(jTable_Producto);

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

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addComponent(jComboBox_Producto, javax.swing.GroupLayout.PREFERRED_SIZE, 353, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 58, Short.MAX_VALUE)
                        .addComponent(jSpinner_Cantidad_Producto, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane2)
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addComponent(jTextField_Busqueda_Combo, javax.swing.GroupLayout.PREFERRED_SIZE, 291, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton_Agregar, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(40, 40, 40)
                        .addComponent(jButton_Borrar_p, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(6, 6, 6))
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap(17, Short.MAX_VALUE)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField_Busqueda_Combo, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton_Agregar, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton_Borrar_p, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jComboBox_Producto, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jSpinner_Cantidad_Producto, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 339, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jPanel2.add(jPanel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 40, 580, 490));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jInternalFrame1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jInternalFrame1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, javax.swing.GroupLayout.PREFERRED_SIZE))
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

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton7ActionPerformed

    private void jTextField_Fecha_Hora(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField_Fecha_Hora
        mostrarFechaActual();
    }//GEN-LAST:event_jTextField_Fecha_Hora

    private void jComboProveedorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboProveedorActionPerformed

    }//GEN-LAST:event_jComboProveedorActionPerformed

    private void jButton_guardar_compra(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_guardar_compra
        guardarCompraProducto();
        Container container = getParent();
        if (container instanceof JDesktopPane) {
            JDesktopPane desktopPane = (JDesktopPane) container;

            // Buscar el formulario JInternalFrame_Compra en el JDesktopPane
            JInternalFrame_Compra compraForm = null;
            JInternalFrame[] frames = desktopPane.getAllFrames();
            for (JInternalFrame frame : frames) {
                if (frame instanceof JInternalFrame_Compra) {
                    compraForm = (JInternalFrame_Compra) frame;
                    break;
                }
            }

            if (compraForm != null) {
                // Si el formulario ya está abierto, selecciónalo
                try {
                    compraForm.setSelected(true);
                } catch (java.beans.PropertyVetoException e) {
                    e.printStackTrace();
                }
            } else {
                // Si el formulario no está abierto, crea una nueva instancia y añádela al JDesktopPane
                compraForm = new JInternalFrame_Compra();
                desktopPane.add(compraForm);
                compraForm.setVisible(true);
                try {
                    compraForm.setSelected(true);
                } catch (java.beans.PropertyVetoException e) {
                    e.printStackTrace();
                }
            }
        }

    }//GEN-LAST:event_jButton_guardar_compra

    private void jTextField_Total(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField_Total
        calcularTotalTabla();
    }//GEN-LAST:event_jTextField_Total

    private void jButton_ver_Formulario_ventaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_ver_Formulario_ventaActionPerformed
        Container container = getParent();
        if (container instanceof JDesktopPane) {
            JDesktopPane desktopPane = (JDesktopPane) container;

            // Buscar el formulario JInternalFrame_Compra en el JDesktopPane
            JInternalFrame_Compra compraForm = null;
            JInternalFrame[] frames = desktopPane.getAllFrames();
            for (JInternalFrame frame : frames) {
                if (frame instanceof JInternalFrame_Compra) {
                    compraForm = (JInternalFrame_Compra) frame;
                    break;
                }
            }

            if (compraForm != null) {
                // Si el formulario ya está abierto, selecciónalo
                try {
                    compraForm.setSelected(true);
                } catch (java.beans.PropertyVetoException e) {
                    e.printStackTrace();
                }
            } else {
                // Si el formulario no está abierto, crea una nueva instancia y añádela al JDesktopPane
                compraForm = new JInternalFrame_Compra();
                desktopPane.add(compraForm);
                compraForm.setVisible(true);
                try {
                    compraForm.setSelected(true);
                } catch (java.beans.PropertyVetoException e) {
                    e.printStackTrace();
                }
            }
        }

    }//GEN-LAST:event_jButton_ver_Formulario_ventaActionPerformed

    private void jTable_Producto(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_jTable_Producto
        // TODO add your handling code here:
    }//GEN-LAST:event_jTable_Producto

    private void jTextField_Busqueda_Combo(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField_Busqueda_Combo

    }//GEN-LAST:event_jTextField_Busqueda_Combo

    private void jTextField_Busqueda_ComboKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField_Busqueda_ComboKeyReleased
        String busqueda = jTextField_Busqueda_Combo.getText(); // Obtener el texto ingresado en el campo de búsqueda

        CRUD_Compra_Producto gr = new CRUD_Compra_Producto();
        ArrayList<Clase_Producto> listaProductos = gr.mostrarDatosComboCompra(busqueda);
        jComboBox_Producto.removeAllItems();
        for (Clase_Producto producto : listaProductos) {
            jComboBox_Producto.addItem(producto);
        }
    }//GEN-LAST:event_jTextField_Busqueda_ComboKeyReleased

    private void jSpinner_Cantidad_Producto(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_jSpinner_Cantidad_Producto

    }//GEN-LAST:event_jSpinner_Cantidad_Producto

    private void jComboBox_Producto(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox_Producto

    }//GEN-LAST:event_jComboBox_Producto

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


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton9;
    private javax.swing.JButton jButton_Agregar;
    private javax.swing.JButton jButton_Borrar_p;
    public static javax.swing.JButton jButton_guardar_compra;
    public static javax.swing.JButton jButton_ver_Formulario_venta;
    public static javax.swing.JComboBox<Clase_Producto> jComboBox_Producto;
    public javax.swing.JComboBox<Clase_Proveedor> jComboProveedor;
    private javax.swing.JInternalFrame jInternalFrame1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSpinner jSpinner_Cantidad_Producto;
    private javax.swing.JTable jTable1;
    public static javax.swing.JTable jTable_Producto;
    private javax.swing.JTextField jTextField10;
    private javax.swing.JTextField jTextField11;
    private javax.swing.JTextField jTextField12;
    private javax.swing.JTextField jTextField8;
    private javax.swing.JTextField jTextField_Busqueda_Combo;
    private javax.swing.JTextField jTextField_Fecha_Hora;
    private javax.swing.JTextField jTextField_Total;
    // End of variables declaration//GEN-END:variables
}
