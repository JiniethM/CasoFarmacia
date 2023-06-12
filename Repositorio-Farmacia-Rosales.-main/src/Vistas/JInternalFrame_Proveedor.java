package Vistas;

import Controlador.CRUD_Proveedor;
import Modelo.Clase_Proveedor;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.HeadlessException;
import java.awt.event.KeyEvent;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;

/**
 * @author diedr
 */
public class JInternalFrame_Proveedor extends javax.swing.JInternalFrame {

    public JInternalFrame_Proveedor() {
        initComponents();
        jTextField_id_Proveedor.setEditable(false);
    }

    public void limpiar() {
        jTextField_id_Proveedor.setText("");
        jTextField_Nombre_1.setText("");
        jTextField_Nombre_2.setText("");
        jTextField_Apellido_1.setText("");
        jTextField_Apellido_2.setText("");
        jTextField_Gmail.setText("");
        jFormattedTextField_Telefono.setText("");
        jTextArea_Direccion.setText("");

    }

    public void guardarProveedor() {
        CRUD_Proveedor cc = new CRUD_Proveedor();
        String Nombre1 = jTextField_Nombre_1.getText();
        String Nombre2 = jTextField_Nombre_2.getText();
        String Apellido1 = jTextField_Apellido_1.getText();
        String Apellido2 = jTextField_Apellido_2.getText();
        String gmail = jTextField_Gmail.getText();
        String Telefono = jFormattedTextField_Telefono.getText();
        String Direccio = jTextArea_Direccion.getText();

        Clase_Proveedor cl = new Clase_Proveedor(Nombre1, Nombre2, Apellido1, Apellido2, gmail, Telefono, Direccio);
        cc.Guardar(cl);
    }

    public void mostrar() {
        try {
            DefaultTableModel modelo;
            CRUD_Proveedor cli = new CRUD_Proveedor();
            modelo = cli.mostrarDatos();
            jTable_Proveedor.setModel(modelo);

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }

    }

    public void editarProveedor() {

        CRUD_Proveedor cc = new CRUD_Proveedor();

        Clase_Proveedor cl = new Clase_Proveedor(jTextField_Nombre_1.getText(),
                jTextField_Nombre_2.getText(),
                jTextField_Apellido_1.getText(),
                jTextField_Apellido_2.getText(),
                jTextField_Gmail.getText(),
                jFormattedTextField_Telefono.getText(),
                jTextArea_Direccion.getText());
        cc.actualizar(cl);

    }

    public void BuscarProveedor() {
        try {
            DefaultTableModel modelo;
            CRUD_Proveedor cli = new CRUD_Proveedor();
            modelo = cli.buscarDatos(jTextField_Buscar.getText());

            if (modelo != null) {
                jTable_Proveedor.setModel(modelo);
            } else {
                JOptionPane.showMessageDialog(null, "No se encontraron resultados.");
            }
        } catch (HeadlessException e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jTextField_id_Proveedor = new javax.swing.JTextField();
        jTextField_Buscar = new javax.swing.JTextField();
        jPanel5 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jTextField_Nombre_1 = new javax.swing.JTextField();
        jTextField_Nombre_2 = new javax.swing.JTextField();
        jTextField_Apellido_1 = new javax.swing.JTextField();
        jTextField_Apellido_2 = new javax.swing.JTextField();
        jPanel6 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jTextField_Gmail = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea_Direccion = new javax.swing.JTextArea();
        jFormattedTextField_Telefono = new javax.swing.JFormattedTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable_Proveedor = new javax.swing.JTable();
        jButton3 = new javax.swing.JButton();
        jButton_Agregar = new javax.swing.JButton();
        jButton_Actualizar = new javax.swing.JButton();
        jButton_Editar = new javax.swing.JButton();
        jButton_Eliminar = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setForeground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 153, 153));
        jLabel2.setText("Id Proveedor");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 60, -1, -1));

        jTextField_id_Proveedor.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField_id_Proveedor.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        jTextField_id_Proveedor.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        jTextField_id_Proveedor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField_id_Proveedor(evt);
            }
        });
        jPanel1.add(jTextField_id_Proveedor, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 60, 130, 20));

        jTextField_Buscar.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        jTextField_Buscar.setForeground(new java.awt.Color(153, 153, 153));
        jTextField_Buscar.setText("Buscar");
        jTextField_Buscar.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        jTextField_Buscar.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        jTextField_Buscar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTextField_BuscarMouseClicked(evt);
            }
        });
        jTextField_Buscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField_Buscar(evt);
            }
        });
        jTextField_Buscar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextField_BuscarKeyReleased(evt);
            }
        });
        jPanel1.add(jTextField_Buscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 60, 160, 20));

        jPanel5.setBackground(new java.awt.Color(255, 255, 255));
        jPanel5.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        jPanel5.setOpaque(false);

        jLabel3.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 153, 153));
        jLabel3.setText("Nombre 1");

        jLabel9.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(0, 153, 153));
        jLabel9.setText("Nombre 2");

        jLabel7.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(0, 153, 153));
        jLabel7.setText("Apellido 1");

        jLabel5.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0, 153, 153));
        jLabel5.setText("Apellido 2");

        jTextField_Nombre_1.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField_Nombre_1.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        jTextField_Nombre_1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField_Nombre_1(evt);
            }
        });
        jTextField_Nombre_1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextField_Nombre_1KeyTyped(evt);
            }
        });

        jTextField_Nombre_2.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField_Nombre_2.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        jTextField_Nombre_2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField_Nombre_2(evt);
            }
        });
        jTextField_Nombre_2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextField_Nombre_2KeyTyped(evt);
            }
        });

        jTextField_Apellido_1.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField_Apellido_1.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        jTextField_Apellido_1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField_Apellido_1(evt);
            }
        });
        jTextField_Apellido_1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextField_Apellido_1KeyTyped(evt);
            }
        });

        jTextField_Apellido_2.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField_Apellido_2.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        jTextField_Apellido_2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField_Apellido_2(evt);
            }
        });
        jTextField_Apellido_2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextField_Apellido_2KeyTyped(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(jTextField_Nombre_1, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(44, 44, 44)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel9)
                    .addComponent(jTextField_Nombre_2, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(44, 44, 44)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel7)
                    .addComponent(jTextField_Apellido_1, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 44, Short.MAX_VALUE)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTextField_Apellido_2, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addGap(80, 80, 80))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jLabel9)
                    .addComponent(jLabel7)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField_Nombre_1, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField_Nombre_2, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField_Apellido_1, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField_Apellido_2, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(16, Short.MAX_VALUE))
        );

        jPanel1.add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 120, -1, -1));

        jPanel6.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        jPanel6.setOpaque(false);

        jLabel8.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(0, 153, 153));
        jLabel8.setText("Teléfono");

        jLabel11.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(0, 153, 153));
        jLabel11.setText("Gmail");

        jLabel6.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(0, 153, 153));
        jLabel6.setText("Dirección");

        jTextField_Gmail.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField_Gmail.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        jTextField_Gmail.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField_Gmail(evt);
            }
        });
        jTextField_Gmail.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextField_GmailKeyTyped(evt);
            }
        });

        jTextArea_Direccion.setColumns(20);
        jTextArea_Direccion.setRows(5);
        jTextArea_Direccion.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        jTextArea_Direccion.addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
                jTextArea_Direccion(evt);
            }
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
            }
        });
        jTextArea_Direccion.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextArea_DireccionKeyTyped(evt);
            }
        });
        jScrollPane1.setViewportView(jTextArea_Direccion);

        try {
            jFormattedTextField_Telefono.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("####-####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        jFormattedTextField_Telefono.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jFormattedTextField_Telefono.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jFormattedTextField_Telefono(evt);
            }
        });

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel8)
                    .addComponent(jFormattedTextField_Telefono, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 59, Short.MAX_VALUE)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTextField_Gmail, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel11))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 93, Short.MAX_VALUE)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 284, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(19, 19, 19))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(jLabel11)
                    .addComponent(jLabel6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 9, Short.MAX_VALUE)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jTextField_Gmail, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jFormattedTextField_Telefono, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(44, Short.MAX_VALUE))
        );

        jPanel1.add(jPanel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 220, 740, -1));

        jTable_Proveedor.setForeground(new java.awt.Color(0, 153, 153));
        jTable_Proveedor.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null}
            },
            new String [] {
                "ID Proveedor", "Nombre 1", "Nombre 2", "Apellido 1", "Apellido 2", "Gmail", "Numero Celular", "Direccion"
            }
        ));
        jTable_Proveedor.setGridColor(new java.awt.Color(0, 153, 153));
        jTable_Proveedor.setShowGrid(true);
        jTable_Proveedor.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable_ProveedorMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jTable_ProveedorMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jTable_ProveedorMouseExited(evt);
            }
        });
        jScrollPane2.setViewportView(jTable_Proveedor);

        jPanel1.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 388, 870, 110));

        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Vistas_Iconos/Buscar.png"))); // NOI18N
        jButton3.setBorder(null);
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 60, 20, 20));

        jButton_Agregar.setBackground(new java.awt.Color(0, 153, 153));
        jButton_Agregar.setFont(new java.awt.Font("Dialog", 1, 11)); // NOI18N
        jButton_Agregar.setForeground(new java.awt.Color(255, 255, 255));
        jButton_Agregar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Vistas_Iconos/agregar-usuario.png"))); // NOI18N
        jButton_Agregar.setText("Agregar");
        jButton_Agregar.setBorder(javax.swing.BorderFactory.createEtchedBorder(javax.swing.border.EtchedBorder.RAISED));
        jButton_Agregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_Agregar(evt);
            }
        });
        jPanel1.add(jButton_Agregar, new org.netbeans.lib.awtextra.AbsoluteConstraints(790, 90, 93, -1));

        jButton_Actualizar.setBackground(new java.awt.Color(0, 153, 153));
        jButton_Actualizar.setFont(new java.awt.Font("Dialog", 1, 11)); // NOI18N
        jButton_Actualizar.setForeground(new java.awt.Color(255, 255, 255));
        jButton_Actualizar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Vistas_Iconos/Actualizar uduario.png"))); // NOI18N
        jButton_Actualizar.setText("Actualizar");
        jButton_Actualizar.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jButton_Actualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_Actualizar(evt);
            }
        });
        jPanel1.add(jButton_Actualizar, new org.netbeans.lib.awtextra.AbsoluteConstraints(790, 210, -1, 44));

        jButton_Editar.setBackground(new java.awt.Color(0, 153, 153));
        jButton_Editar.setFont(new java.awt.Font("Dialog", 1, 11)); // NOI18N
        jButton_Editar.setForeground(new java.awt.Color(255, 255, 255));
        jButton_Editar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Vistas_Iconos/Editar Usuario.png"))); // NOI18N
        jButton_Editar.setText("Editar");
        jButton_Editar.setBorder(javax.swing.BorderFactory.createEtchedBorder(javax.swing.border.EtchedBorder.RAISED));
        jButton_Editar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_Editar(evt);
            }
        });
        jPanel1.add(jButton_Editar, new org.netbeans.lib.awtextra.AbsoluteConstraints(790, 150, 93, -1));

        jButton_Eliminar.setBackground(new java.awt.Color(0, 153, 153));
        jButton_Eliminar.setFont(new java.awt.Font("Dialog", 1, 11)); // NOI18N
        jButton_Eliminar.setForeground(new java.awt.Color(255, 255, 255));
        jButton_Eliminar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Vistas_Iconos/Eliminar usuario.png"))); // NOI18N
        jButton_Eliminar.setText("Eliminar");
        jButton_Eliminar.setBorder(javax.swing.BorderFactory.createEtchedBorder(javax.swing.border.EtchedBorder.RAISED));
        jButton_Eliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_Eliminar(evt);
            }
        });
        jPanel1.add(jButton_Eliminar, new org.netbeans.lib.awtextra.AbsoluteConstraints(790, 280, 90, 40));

        jPanel4.setBackground(new java.awt.Color(0, 153, 153));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Farmacia Rosales");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
            .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel4Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 909, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 40, Short.MAX_VALUE)
            .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                    .addContainerGap(7, Short.MAX_VALUE)
                    .addComponent(jLabel1)
                    .addContainerGap(8, Short.MAX_VALUE)))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 916, Short.MAX_VALUE)
            .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, 916, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 512, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTextField_Buscar(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField_Buscar
        jTextField_Buscar.setText("");
        jTextField_Buscar.setForeground(Color.black);
        BuscarProveedor();
    }//GEN-LAST:event_jTextField_Buscar

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton_Editar(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_Editar
        int filaSeleccionada = jTable_Proveedor.getSelectedRow();
        if (filaSeleccionada == -1) {
            JOptionPane.showMessageDialog(this, "Seleccione una fila de la tabla para editar");
        } else {
            String Id_provee = jTable_Proveedor.getValueAt(filaSeleccionada, 0) != null ? jTable_Proveedor.getValueAt(filaSeleccionada, 0).toString() : "";

            String nombre1 = jTable_Proveedor.getValueAt(filaSeleccionada, 1) != null ? jTable_Proveedor.getValueAt(filaSeleccionada, 1).toString() : "";
            String nombre2 = jTable_Proveedor.getValueAt(filaSeleccionada, 2) != null ? jTable_Proveedor.getValueAt(filaSeleccionada, 2).toString() : "";
            String apellido1 = jTable_Proveedor.getValueAt(filaSeleccionada, 3) != null ? jTable_Proveedor.getValueAt(filaSeleccionada, 3).toString() : "";
            String apellido2 = jTable_Proveedor.getValueAt(filaSeleccionada, 4) != null ? jTable_Proveedor.getValueAt(filaSeleccionada, 4).toString() : "";
            String gmail = jTable_Proveedor.getValueAt(filaSeleccionada, 5) != null ? jTable_Proveedor.getValueAt(filaSeleccionada, 5).toString() : "";
            String telefono = jTable_Proveedor.getValueAt(filaSeleccionada, 6) != null ? jTable_Proveedor.getValueAt(filaSeleccionada, 6).toString() : "";
            String direccion = jTable_Proveedor.getValueAt(filaSeleccionada, 7) != null ? jTable_Proveedor.getValueAt(filaSeleccionada, 7).toString() : "";

            jTextField_id_Proveedor.setText(Id_provee);
            jTextField_Nombre_1.setText(nombre1);
            jTextField_Nombre_2.setText(nombre2);
            jTextField_Apellido_1.setText(apellido1);
            jTextField_Apellido_2.setText(apellido2);
            jTextField_Gmail.setText(gmail);
            jFormattedTextField_Telefono.setText(telefono);
            jTextArea_Direccion.setText(direccion);

            
        }
    }//GEN-LAST:event_jButton_Editar

    private void jTextArea_Direccion(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_jTextArea_Direccion
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextArea_Direccion

    private void jTextField_id_Proveedor(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField_id_Proveedor
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField_id_Proveedor

    private void jTextField_Nombre_1(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField_Nombre_1
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField_Nombre_1

    private void jTextField_Nombre_2(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField_Nombre_2
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField_Nombre_2

    private void jTextField_Apellido_1(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField_Apellido_1
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField_Apellido_1

    private void jTextField_Apellido_2(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField_Apellido_2
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField_Apellido_2

    private void jFormattedTextField_Telefono(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jFormattedTextField_Telefono
        // TODO add your handling code here:
    }//GEN-LAST:event_jFormattedTextField_Telefono

    private void jTextField_Gmail(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField_Gmail
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField_Gmail

    private void jButton_Agregar(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_Agregar
        CRUD_Proveedor cl = new CRUD_Proveedor();
        try {
            if (jTextField_Nombre_1.getText().isEmpty()
                    || jTextField_Apellido_1.getText().isEmpty()
                    || jFormattedTextField_Telefono.getText().equals("    -    ")) {
                JOptionPane.showMessageDialog(null, "Tiene datos vacíos");
            } else {
                int option = JOptionPane.showOptionDialog(
                        null,
                        "¿Desea guardar el Proveedor?",
                        "Confirmar Guardado",
                        JOptionPane.YES_NO_OPTION,
                        JOptionPane.QUESTION_MESSAGE,
                        new ImageIcon(getClass().getResource("/Vistas_Iconos/Guardar.png")),
                        new Object[]{"Sí", "No"},
                        "No"
                );

                if (option == JOptionPane.YES_OPTION) {
                    guardarProveedor();
                    limpiar();

                    JPanel panel = new JPanel();
                    panel.setLayout(new BorderLayout());

                    JLabel messageLabel = new JLabel("Datos Guardados Correctamente");
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
    }//GEN-LAST:event_jButton_Agregar

    private void jButton_Actualizar(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_Actualizar
        String idProveeText = jTextField_id_Proveedor.getText();
        int idProveedor = Integer.parseInt(idProveeText);
        String nombre1 = jTextField_Nombre_1.getText();
        String nombre2 = jTextField_Nombre_2.getText();
        String apellido1 = jTextField_Apellido_1.getText();
        String apellido2 = jTextField_Apellido_2.getText();
        String gmail = jTextField_Gmail.getText();
        String telefono = jFormattedTextField_Telefono.getText();
        String direccion = jTextArea_Direccion.getText();

        if (jTextField_id_Proveedor.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Tiene datos vacíos");
        } else {
            int option = JOptionPane.showOptionDialog(
                    null,
                    "¿Desea actualizar el Proveedor?",
                    "Confirmar Actualización",
                    JOptionPane.YES_NO_OPTION,
                    JOptionPane.QUESTION_MESSAGE,
                    new ImageIcon(getClass().getResource("/Vistas_Iconos/Actualizar.png")),
                    new Object[]{"Sí", "No"},
                    "No"
            );

            if (option == JOptionPane.YES_OPTION) {
                // Crear objeto Clase_Proveedor con los datos obtenidos
                Clase_Proveedor Proveedor = new Clase_Proveedor(idProveedor, nombre1, nombre2, apellido1, apellido2, gmail, telefono, direccion);

                // Llamar al método "actualizar" de CRUD_Proveedor
                CRUD_Proveedor clienteCRUD = new CRUD_Proveedor();
                clienteCRUD.actualizar(Proveedor);

                JPanel panel = new JPanel();
                panel.setLayout(new BorderLayout());

                JLabel messageLabel = new JLabel("Cliente actualizado exitosamente.");
                messageLabel.setFont(new Font("Arial", Font.BOLD, 14));
                messageLabel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
                panel.add(messageLabel, BorderLayout.CENTER);

                ImageIcon icon = new ImageIcon(getClass().getResource("/Vistas_Iconos/Actualizar.png"));
                JLabel iconLabel = new JLabel(icon);
                iconLabel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
                panel.add(iconLabel, BorderLayout.WEST);

                JOptionPane.showMessageDialog(null, panel, "Actualización Exitosa", JOptionPane.PLAIN_MESSAGE);
            }
        }

        CRUD_Proveedor ProveedorCRUD = new CRUD_Proveedor();
        ProveedorCRUD.mostrarDatos();
        limpiar();
        mostrar();


    }//GEN-LAST:event_jButton_Actualizar

    private void jButton_Eliminar(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_Eliminar
        int selectedRow = jTable_Proveedor.getSelectedRow();
        if (selectedRow != -1) {
            int option = JOptionPane.showOptionDialog(
                    rootPane,
                    "Se eliminará el registro, ¿desea continuar?",
                    "Eliminar Registro",
                    JOptionPane.YES_NO_OPTION,
                    JOptionPane.WARNING_MESSAGE,
                    new ImageIcon(getClass().getResource("/Vistas_Iconos/Eliminar.png")),
                    new Object[]{"Sí", "No"},
                    "No"
            );

            if (option == JOptionPane.YES_OPTION) {
                String idClienteString = jTable_Proveedor.getValueAt(selectedRow, 0).toString();
                int idProveedor = Integer.parseInt(idClienteString);

                CRUD_Proveedor cli = new CRUD_Proveedor();
                cli.eliminar(idProveedor);

                mostrar();

                JPanel panel = new JPanel();
                panel.setLayout(new BorderLayout());

                JLabel messageLabel = new JLabel("Proveedor eliminado correctamente");
                messageLabel.setFont(new Font("Arial", Font.BOLD, 14));
                messageLabel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
                panel.add(messageLabel, BorderLayout.CENTER);

                ImageIcon icon = new ImageIcon(getClass().getResource("/Vistas_Iconos/Eliminar.png"));
                JLabel iconLabel = new JLabel(icon);
                iconLabel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
                panel.add(iconLabel, BorderLayout.WEST);

                JOptionPane.showMessageDialog(null, panel, "Eliminación Exitosa", JOptionPane.PLAIN_MESSAGE);
            }
        } else {
            JPanel panel = new JPanel();
            panel.setLayout(new BorderLayout());

            JLabel messageLabel = new JLabel("Debe seleccionar la fila");
            messageLabel.setFont(new Font("Arial", Font.BOLD, 14));
            messageLabel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
            panel.add(messageLabel, BorderLayout.CENTER);

            ImageIcon icon = new ImageIcon(getClass().getResource("/Vistas_Iconos/Advertencia.png"));
            JLabel iconLabel = new JLabel(icon);
            iconLabel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
            panel.add(iconLabel, BorderLayout.WEST);

            JOptionPane.showMessageDialog(null, panel, "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_jButton_Eliminar

    private void jTextField_BuscarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTextField_BuscarMouseClicked
        jTextField_Buscar.setText("");
        jTextField_Buscar.setForeground(Color.black);
        BuscarProveedor();
    }//GEN-LAST:event_jTextField_BuscarMouseClicked

    private void jTable_ProveedorMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable_ProveedorMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jTable_ProveedorMouseClicked

    private void jTable_ProveedorMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable_ProveedorMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_jTable_ProveedorMouseEntered

    private void jTable_ProveedorMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable_ProveedorMouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_jTable_ProveedorMouseExited

    private void jTextField_BuscarKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField_BuscarKeyReleased
        BuscarProveedor();
    }//GEN-LAST:event_jTextField_BuscarKeyReleased

    private void jTextArea_DireccionKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextArea_DireccionKeyTyped
         String texto = jTextArea_Direccion.getText();

        if (texto.length() >= 200) {
            evt.consume();
        }
    }//GEN-LAST:event_jTextArea_DireccionKeyTyped

    private void jTextField_GmailKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField_GmailKeyTyped
        String texto = jTextField_Gmail.getText();

        if (texto.length() >= 50) {
            evt.consume();
        }
    }//GEN-LAST:event_jTextField_GmailKeyTyped

    private void jTextField_Nombre_1KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField_Nombre_1KeyTyped
        char car = evt.getKeyChar();
        String texto = jTextField_Nombre_1.getText(); // Obtener el texto actual en el campo

        if (((car < 'a' || car > 'z') && (car < 'A' || car > 'Z')
                && car != 'á' // Minúsculas
                && car != 'é'
                && car != 'í'
                && car != 'ó'
                && car != 'ú'
                && car != 'Á' // Mayúsculas
                && car != 'É'
                && car != 'Í'
                && car != 'Ó'
                && car != 'Ú'
                && car != 'Ü'
                && car != 'ü'
                && car != 'Ñ'
                && car != 'ñ'
                && (car != (char) KeyEvent.VK_SPACE))
                || texto.length() >= 32) {
            evt.consume();
        }
    }//GEN-LAST:event_jTextField_Nombre_1KeyTyped

    private void jTextField_Nombre_2KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField_Nombre_2KeyTyped
         char car = evt.getKeyChar();
        String texto = jTextField_Nombre_2.getText(); // Obtener el texto actual en el campo

        if (((car < 'a' || car > 'z') && (car < 'A' || car > 'Z')
                && car != 'á' // Minúsculas
                && car != 'é'
                && car != 'í'
                && car != 'ó'
                && car != 'ú'
                && car != 'Á' // Mayúsculas
                && car != 'É'
                && car != 'Í'
                && car != 'Ó'
                && car != 'Ú'
                && car != 'Ü'
                && car != 'ü'
                && car != 'Ñ'
                && car != 'ñ'
                && (car != (char) KeyEvent.VK_SPACE))
                || texto.length() >= 32) {
            evt.consume();
        }
    }//GEN-LAST:event_jTextField_Nombre_2KeyTyped

    private void jTextField_Apellido_1KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField_Apellido_1KeyTyped
        char car = evt.getKeyChar();
        String texto = jTextField_Apellido_1.getText(); // Obtener el texto actual en el campo

        if (((car < 'a' || car > 'z') && (car < 'A' || car > 'Z')
                && car != 'á' // Minúsculas
                && car != 'é'
                && car != 'í'
                && car != 'ó'
                && car != 'ú'
                && car != 'Á' // Mayúsculas
                && car != 'É'
                && car != 'Í'
                && car != 'Ó'
                && car != 'Ú'
                && car != 'Ü'
                && car != 'ü'
                && car != 'Ñ'
                && car != 'ñ'
                && (car != (char) KeyEvent.VK_SPACE))
                || texto.length() >= 32) {
            evt.consume();
        }
    }//GEN-LAST:event_jTextField_Apellido_1KeyTyped

    private void jTextField_Apellido_2KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField_Apellido_2KeyTyped
         char car = evt.getKeyChar();
        String texto = jTextField_Apellido_2.getText(); // Obtener el texto actual en el campo

        if (((car < 'a' || car > 'z') && (car < 'A' || car > 'Z')
                && car != 'á' // Minúsculas
                && car != 'é'
                && car != 'í'
                && car != 'ó'
                && car != 'ú'
                && car != 'Á' // Mayúsculas
                && car != 'É'
                && car != 'Í'
                && car != 'Ó'
                && car != 'Ú'
                && car != 'Ü'
                && car != 'ü'
                && car != 'Ñ'
                && car != 'ñ'
                && (car != (char) KeyEvent.VK_SPACE))
                || texto.length() >= 32) {
            evt.consume();
        }
    }//GEN-LAST:event_jTextField_Apellido_2KeyTyped


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton_Actualizar;
    private javax.swing.JButton jButton_Agregar;
    private javax.swing.JButton jButton_Editar;
    private javax.swing.JButton jButton_Eliminar;
    private javax.swing.JFormattedTextField jFormattedTextField_Telefono;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable_Proveedor;
    private javax.swing.JTextArea jTextArea_Direccion;
    private javax.swing.JTextField jTextField_Apellido_1;
    private javax.swing.JTextField jTextField_Apellido_2;
    private javax.swing.JTextField jTextField_Buscar;
    private javax.swing.JTextField jTextField_Gmail;
    private javax.swing.JTextField jTextField_Nombre_1;
    private javax.swing.JTextField jTextField_Nombre_2;
    private javax.swing.JTextField jTextField_id_Proveedor;
    // End of variables declaration//GEN-END:variables
}
