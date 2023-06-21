package Vistas;

import Controlador.CRUD_Producto;
import Controlador_Conexion_DB.Conexion;
import Modelo.Clase_Categoria;
import Modelo.Clase_Laboratorio;
import Modelo.Clase_Presentacion;
import java.sql.Connection;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JDesktopPane;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;

/**
 * @author diedr
 */
public class JInternalFrame_Producto extends javax.swing.JInternalFrame {

    private Image iconoRedimensionado;

    Conexion conexion = new Conexion();

    public JInternalFrame_Producto() {
        initComponents();
        Connection cn = (Connection) conexion.conectar();

    }

    public void mostrar() {
        try {
            DefaultTableModel modelo;
            CRUD_Producto cli = new CRUD_Producto();
            modelo = cli.mostrarDatos();
            jTable_Producto.setModel(modelo);

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTextArea2 = new javax.swing.JTextArea();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTextArea_descripcion = new javax.swing.JTextArea();
        jLabel7 = new javax.swing.JLabel();
        jTextField_cantidad = new javax.swing.JTextField();
        jTextField_nombre = new javax.swing.JTextField();
        jTextField_Id_producto = new javax.swing.JTextField();
        jTextField_Buscar = new javax.swing.JTextField();
        jPanel6 = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        jTextField_precio_compra = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        jTextField_precio_venta = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jFormattedTextField_fecha_de_caducidad = new javax.swing.JFormattedTextField();
        jLabel12 = new javax.swing.JLabel();
        jPanel7 = new javax.swing.JPanel();
        jLabel14 = new javax.swing.JLabel();
        jScrollPane5 = new javax.swing.JScrollPane();
        jTable_Categoria = new javax.swing.JTable();
        jComboBox_Categoria = new javax.swing.JComboBox<>();
        jPanel3 = new javax.swing.JPanel();
        jButton_Eliminar = new javax.swing.JButton();
        jButton_Guardar = new javax.swing.JButton();
        jButton_Actualizar = new javax.swing.JButton();
        jButton_Editar = new javax.swing.JButton();
        jScrollPane4 = new javax.swing.JScrollPane();
        jTable_Producto = new javax.swing.JTable();
        jButton_buscar_imagen = new javax.swing.JButton();
        jLabel_Mostrar_Imagen = new javax.swing.JLabel();
        jTextField_id_categoria = new javax.swing.JTextField();
        jTextField_id_presentacion = new javax.swing.JTextField();
        jTextField_id_laboratorio = new javax.swing.JTextField();
        jPanel9 = new javax.swing.JPanel();
        jLabel17 = new javax.swing.JLabel();
        jScrollPane6 = new javax.swing.JScrollPane();
        jTablePresentacion = new javax.swing.JTable();
        jComboBox_Presentacion = new javax.swing.JComboBox<>();
        jPanel10 = new javax.swing.JPanel();
        jLabel18 = new javax.swing.JLabel();
        jScrollPane7 = new javax.swing.JScrollPane();
        jTable_Laboratorio = new javax.swing.JTable();
        jComboBox_Laboratorio = new javax.swing.JComboBox<>();
        jPanel8 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jTextArea1.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        jScrollPane1.setViewportView(jTextArea1);

        jTextArea2.setColumns(20);
        jTextArea2.setRows(5);
        jTextArea2.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        jScrollPane2.setViewportView(jTextArea2);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jLabel2.setBackground(new java.awt.Color(0, 153, 153));
        jLabel2.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 153, 153));
        jLabel2.setText("Foto");

        jPanel5.setBackground(new java.awt.Color(255, 255, 255));
        jPanel5.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        jPanel5.setOpaque(false);

        jLabel6.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(0, 153, 153));
        jLabel6.setText("Nombre");

        jLabel9.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(0, 153, 153));
        jLabel9.setText("Descripción");

        jTextArea_descripcion.setColumns(20);
        jTextArea_descripcion.setRows(5);
        jTextArea_descripcion.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        jTextArea_descripcion.addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
                jTextArea_descripcion(evt);
            }
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
            }
        });
        jScrollPane3.setViewportView(jTextArea_descripcion);

        jLabel7.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(0, 153, 153));
        jLabel7.setText("Cantidad");

        jTextField_cantidad.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField_cantidad.setText("                                 +    -");
        jTextField_cantidad.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        jTextField_cantidad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField_cantidad(evt);
            }
        });

        jTextField_nombre.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField_nombre.setText("Acetominofen");
        jTextField_nombre.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        jTextField_nombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField_nombre(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6)
                    .addComponent(jTextField_nombre, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(39, 39, 39)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel7)
                    .addComponent(jTextField_cantidad, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 111, Short.MAX_VALUE)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 254, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9))
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(jLabel9)
                    .addComponent(jLabel7))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jTextField_cantidad, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jTextField_nombre, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(43, Short.MAX_VALUE))
        );

        jTextField_Id_producto.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        jTextField_Id_producto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField_Id_producto(evt);
            }
        });

        jTextField_Buscar.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        jTextField_Buscar.setForeground(new java.awt.Color(153, 153, 153));
        jTextField_Buscar.setText("Buscar");
        jTextField_Buscar.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        jTextField_Buscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField_Buscar(evt);
            }
        });

        jPanel6.setBackground(new java.awt.Color(255, 255, 255));
        jPanel6.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        jPanel6.setOpaque(false);

        jLabel11.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(0, 153, 153));
        jLabel11.setText("Precio de compra");

        jTextField_precio_compra.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField_precio_compra.setText("12.45");
        jTextField_precio_compra.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        jTextField_precio_compra.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField_precio_compra(evt);
            }
        });

        jLabel13.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(0, 153, 153));
        jLabel13.setText("Precio de venta");

        jTextField_precio_venta.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField_precio_venta.setText("15.15");
        jTextField_precio_venta.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        jTextField_precio_venta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField_precio_venta(evt);
            }
        });

        jLabel1.setBackground(new java.awt.Color(0, 0, 0));
        jLabel1.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 153, 153));
        jLabel1.setText("Fecha de caducidad");

        jFormattedTextField_fecha_de_caducidad.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        jFormattedTextField_fecha_de_caducidad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jFormattedTextField_fecha_de_caducidad(evt);
            }
        });

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel11)
                    .addComponent(jTextField_precio_compra, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 158, Short.MAX_VALUE)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTextField_precio_venta, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel13))
                .addGap(70, 70, 70)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jFormattedTextField_fecha_de_caducidad, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addContainerGap())
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(jLabel13)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField_precio_compra, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField_precio_venta, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jFormattedTextField_fecha_de_caducidad, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(9, Short.MAX_VALUE))
        );

        jLabel12.setBackground(new java.awt.Color(0, 0, 0));
        jLabel12.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(0, 153, 153));
        jLabel12.setText("Id Producto");

        jPanel7.setBackground(new java.awt.Color(255, 255, 255));
        jPanel7.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        jPanel7.setOpaque(false);

        jLabel14.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(0, 153, 153));
        jLabel14.setText("Categoria");

        jTable_Categoria.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        jTable_Categoria.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Id Categoria", "Nombre Categoria", "Descripcion"
            }
        ));
        jTable_Categoria.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable_CategoriaMouseClicked(evt);
            }
        });
        jScrollPane5.setViewportView(jTable_Categoria);

        jComboBox_Categoria.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox_Categoria(evt);
            }
        });

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel14)
                            .addComponent(jComboBox_Categoria, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 152, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel14)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jComboBox_Categoria, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(11, 11, 11)
                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(69, Short.MAX_VALUE))
        );

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        jButton_Eliminar.setBackground(new java.awt.Color(0, 153, 153));
        jButton_Eliminar.setFont(new java.awt.Font("Dialog", 1, 11)); // NOI18N
        jButton_Eliminar.setForeground(new java.awt.Color(255, 255, 255));
        jButton_Eliminar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Vistas_Iconos/eliminar-producto.png"))); // NOI18N
        jButton_Eliminar.setText("Eliminar");
        jButton_Eliminar.setBorder(javax.swing.BorderFactory.createEtchedBorder(javax.swing.border.EtchedBorder.RAISED));
        jButton_Eliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_Eliminar(evt);
            }
        });

        jButton_Guardar.setBackground(new java.awt.Color(0, 153, 153));
        jButton_Guardar.setFont(new java.awt.Font("Dialog", 1, 11)); // NOI18N
        jButton_Guardar.setForeground(new java.awt.Color(255, 255, 255));
        jButton_Guardar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Vistas_Iconos/agregar-producto.png"))); // NOI18N
        jButton_Guardar.setText("Agregar");
        jButton_Guardar.setBorder(javax.swing.BorderFactory.createEtchedBorder(javax.swing.border.EtchedBorder.RAISED));
        jButton_Guardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_Guardar(evt);
            }
        });

        jButton_Actualizar.setBackground(new java.awt.Color(0, 153, 153));
        jButton_Actualizar.setFont(new java.awt.Font("Dialog", 1, 11)); // NOI18N
        jButton_Actualizar.setForeground(new java.awt.Color(255, 255, 255));
        jButton_Actualizar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Vistas_Iconos/Actualizar producto.png"))); // NOI18N
        jButton_Actualizar.setText("Actualizar");
        jButton_Actualizar.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jButton_Actualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_Actualizar(evt);
            }
        });

        jButton_Editar.setBackground(new java.awt.Color(0, 153, 153));
        jButton_Editar.setFont(new java.awt.Font("Dialog", 1, 11)); // NOI18N
        jButton_Editar.setForeground(new java.awt.Color(255, 255, 255));
        jButton_Editar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Vistas_Iconos/Editar producto.png"))); // NOI18N
        jButton_Editar.setText("Editar");
        jButton_Editar.setBorder(javax.swing.BorderFactory.createEtchedBorder(javax.swing.border.EtchedBorder.RAISED));
        jButton_Editar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_Editar(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButton_Guardar, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 37, Short.MAX_VALUE)
                .addComponent(jButton_Editar, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(35, 35, 35)
                .addComponent(jButton_Actualizar)
                .addGap(22, 22, 22)
                .addComponent(jButton_Eliminar)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton_Guardar)
                    .addComponent(jButton_Editar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton_Actualizar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton_Eliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(26, Short.MAX_VALUE))
        );

        jTable_Producto.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Id Proveedor", "Nombre", "Descripción", "Cantidad de producto", "Precio compra", "Precio venta", "Imagen", "Fecha de caducidad", "Id categoria", "Id proveedor", "Id laboratorio"
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
        jScrollPane4.setViewportView(jTable_Producto);

        jButton_buscar_imagen.setText("Foto");
        jButton_buscar_imagen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_buscar_imagen(evt);
            }
        });

        jLabel_Mostrar_Imagen.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jLabel_Mostrar_Imagen.addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
                jLabel_Mostrar_Imagen(evt);
            }
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
            }
        });

        jTextField_id_categoria.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField_id_categoria.setText("12.45");
        jTextField_id_categoria.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        jTextField_id_categoria.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField_id_categoria(evt);
            }
        });

        jTextField_id_presentacion.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField_id_presentacion.setText("15.15");
        jTextField_id_presentacion.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        jTextField_id_presentacion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField_id_presentacion(evt);
            }
        });

        jTextField_id_laboratorio.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField_id_laboratorio.setText("Acetominofen");
        jTextField_id_laboratorio.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        jTextField_id_laboratorio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField_id_laboratorio(evt);
            }
        });

        jPanel9.setBackground(new java.awt.Color(255, 255, 255));
        jPanel9.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        jPanel9.setOpaque(false);

        jLabel17.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(0, 153, 153));
        jLabel17.setText("Presentacion");

        jTablePresentacion.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        jTablePresentacion.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Id Presentacion", "Nombre Presentacion", "Detalle"
            }
        ));
        jTablePresentacion.addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
                jTablePresentacion(evt);
            }
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
            }
        });
        jTablePresentacion.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTablePresentacionMouseClicked(evt);
            }
        });
        jScrollPane6.setViewportView(jTablePresentacion);

        jComboBox_Presentacion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox_Presentacion(evt);
            }
        });

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane6, javax.swing.GroupLayout.DEFAULT_SIZE, 326, Short.MAX_VALUE)
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel17)
                            .addComponent(jComboBox_Presentacion, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel17)
                .addGap(5, 5, 5)
                .addComponent(jComboBox_Presentacion, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(69, Short.MAX_VALUE))
        );

        jPanel10.setBackground(new java.awt.Color(255, 255, 255));
        jPanel10.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        jPanel10.setOpaque(false);

        jLabel18.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(0, 153, 153));
        jLabel18.setText("Laboratorio");

        jTable_Laboratorio.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        jTable_Laboratorio.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "Id Laboratorio", "Nombre Laboratorio"
            }
        ));
        jTable_Laboratorio.addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
                jTable_Laboratorio(evt);
            }
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
            }
        });
        jTable_Laboratorio.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable_LaboratorioMouseClicked(evt);
            }
        });
        jScrollPane7.setViewportView(jTable_Laboratorio);

        jComboBox_Laboratorio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox_Laboratorio(evt);
            }
        });

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel18)
                    .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 280, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboBox_Laboratorio, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(38, Short.MAX_VALUE))
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel18)
                .addGap(5, 5, 5)
                .addComponent(jComboBox_Laboratorio, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(69, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel_Mostrar_Imagen, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(53, 53, 53)
                                .addComponent(jButton_buscar_imagen)))
                        .addGap(18, 144, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel12)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jTextField_Id_producto, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(30, 30, 30))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 912, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jTextField_Buscar, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(163, 163, 163)
                                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jTextField_id_presentacion, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jTextField_id_categoria, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jTextField_id_laboratorio, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel12)
                        .addComponent(jLabel2))
                    .addComponent(jTextField_Id_producto, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel_Mostrar_Imagen, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton_buscar_imagen)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel9, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel7, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(4, 4, 4)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField_id_presentacion, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField_id_categoria, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField_id_laboratorio, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTextField_Buscar, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0))
        );

        jPanel8.setBackground(new java.awt.Color(0, 153, 153));

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("Farmacia Rosales");

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
            .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, 977, Short.MAX_VALUE))
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 40, Short.MAX_VALUE)
            .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel8Layout.createSequentialGroup()
                    .addContainerGap(7, Short.MAX_VALUE)
                    .addComponent(jLabel4)
                    .addContainerGap(8, Short.MAX_VALUE)))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton_buscar_imagen(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_buscar_imagen
        JFileChooser j = new JFileChooser();
        FileNameExtensionFilter fil = new FileNameExtensionFilter("JPG, PNG & GIF", "jpg", "png", "gif");
        j.setFileFilter(fil);

        int s = j.showOpenDialog(this);
        if (s == JFileChooser.APPROVE_OPTION) {
            String ruta = j.getSelectedFile().getAbsolutePath();

            // Guardar el icono seleccionado en una variable
            ImageIcon imagenIcono = new ImageIcon(ruta);

            // Redimensionar el icono al tamaño deseado
            Image imagen = imagenIcono.getImage().getScaledInstance(200, 200, Image.SCALE_DEFAULT);

            // Guardar el icono redimensionado en el jLabel_Mostrar_Imagen
            jLabel_Mostrar_Imagen.setIcon(new ImageIcon(imagen));

            // Guardar el icono redimensionado en una variable para su posterior uso
            Image iconoRedimensionado = imagen;
            iconoRedimensionado = imagen;

            // Aquí puedes hacer lo que necesites con el icono redimensionado, como guardarlo en la base de datos
        }


    }//GEN-LAST:event_jButton_buscar_imagen

    private void jTextField_Buscar(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField_Buscar
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField_Buscar

    private void jTextField_Id_producto(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField_Id_producto
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField_Id_producto

    private void jTextField_nombre(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField_nombre
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField_nombre

    private void jTextField_cantidad(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField_cantidad
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField_cantidad

    private void jTextArea_descripcion(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_jTextArea_descripcion
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextArea_descripcion

    private void jTextField_precio_compra(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField_precio_compra

        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField_precio_compra

    private void jTextField_precio_venta(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField_precio_venta

        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField_precio_venta

    private void jFormattedTextField_fecha_de_caducidad(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jFormattedTextField_fecha_de_caducidad

        // TODO add your handling code here:
    }//GEN-LAST:event_jFormattedTextField_fecha_de_caducidad

    private void jTextField_id_categoria(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField_id_categoria
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField_id_categoria

    private void jTextField_id_presentacion(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField_id_presentacion
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField_id_presentacion

    private void jTextField_id_laboratorio(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField_id_laboratorio
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField_id_laboratorio

    private void jButton_Guardar(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_Guardar
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton_Guardar

    private void jButton_Eliminar(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_Eliminar
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton_Eliminar

    private void jButton_Editar(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_Editar
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton_Editar

    private void jButton_Actualizar(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_Actualizar
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton_Actualizar

    private void jTable_Producto(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_jTable_Producto
        // TODO add your handling code here:
    }//GEN-LAST:event_jTable_Producto

    private void jLabel_Mostrar_Imagen(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_jLabel_Mostrar_Imagen
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel_Mostrar_Imagen

    private void jTable_CategoriaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable_CategoriaMouseClicked

    }//GEN-LAST:event_jTable_CategoriaMouseClicked

    private void jTablePresentacionMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTablePresentacionMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jTablePresentacionMouseClicked

    private void jTable_LaboratorioMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable_LaboratorioMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jTable_LaboratorioMouseClicked

    private void jTablePresentacion(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_jTablePresentacion
        // TODO add your handling code here:
    }//GEN-LAST:event_jTablePresentacion

    private void jComboBox_Categoria(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox_Categoria
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBox_Categoria

    private void jComboBox_Presentacion(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox_Presentacion
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBox_Presentacion

    private void jComboBox_Laboratorio(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox_Laboratorio
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBox_Laboratorio

    private void jTable_Laboratorio(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_jTable_Laboratorio
        // TODO add your handling code here:
    }//GEN-LAST:event_jTable_Laboratorio


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton_Actualizar;
    private javax.swing.JButton jButton_Editar;
    private javax.swing.JButton jButton_Eliminar;
    private javax.swing.JButton jButton_Guardar;
    private javax.swing.JButton jButton_buscar_imagen;
    private javax.swing.JComboBox<Clase_Categoria> jComboBox_Categoria;
    private javax.swing.JComboBox<Clase_Laboratorio> jComboBox_Laboratorio;
    private javax.swing.JComboBox<Clase_Presentacion> jComboBox_Presentacion;
    private javax.swing.JFormattedTextField jFormattedTextField_fecha_de_caducidad;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel jLabel_Mostrar_Imagen;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JTable jTablePresentacion;
    private javax.swing.JTable jTable_Categoria;
    private javax.swing.JTable jTable_Laboratorio;
    private javax.swing.JTable jTable_Producto;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JTextArea jTextArea2;
    private javax.swing.JTextArea jTextArea_descripcion;
    private javax.swing.JTextField jTextField_Buscar;
    private javax.swing.JTextField jTextField_Id_producto;
    private javax.swing.JTextField jTextField_cantidad;
    private javax.swing.JTextField jTextField_id_categoria;
    private javax.swing.JTextField jTextField_id_laboratorio;
    private javax.swing.JTextField jTextField_id_presentacion;
    private javax.swing.JTextField jTextField_nombre;
    private javax.swing.JTextField jTextField_precio_compra;
    private javax.swing.JTextField jTextField_precio_venta;
    // End of variables declaration//GEN-END:variables

}
