package Vistas;

import Controlador.CRUD_Cliente;
import Modelo.Clase_Cliente;
import java.awt.Color;
import java.awt.HeadlessException;
import java.awt.event.KeyEvent;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import java.sql.CallableStatement;
import java.sql.SQLException;
import Controlador_Conexion_DB.Conexion;
import java.awt.BorderLayout;
import java.sql.Connection;
import javax.swing.JPanel;

/**
 *
 * @author Oreki
 */
public class InternalFrame_Cliente extends javax.swing.JInternalFrame {

    private JPanel panel;
    public final Conexion con = new Conexion();
    public final Connection cn = (Connection) con.conectar();

    public InternalFrame_Cliente() {
        initComponents();

    }

    public void limpiar() {
        jTextField_Id_Ciente.setText("");
        JtextFiel_Nombre_1.setText("");
        JtextFiel_Nombre_2.setText("");
        jTextFiel_Apellido_1.setText("");
        jTextField_Apellido_2.setText("");
        jFormattedTextFieldTelefono.setText("");
        jTextArea_Dirrecion.setText("");

    }

    public void guardarCliente() {
        CRUD_Cliente cc = new CRUD_Cliente();
        String Nombre_1 = JtextFiel_Nombre_1.getText();
        String Nombre_2 = JtextFiel_Nombre_2.getText();
        String Apellido_1 = jTextFiel_Apellido_1.getText();
        String Apellido_2 = jTextField_Apellido_2.getText();
        String Telefono = jFormattedTextFieldTelefono.getText();
        String Direccion = jTextArea_Dirrecion.getText();

        Clase_Cliente cl = new Clase_Cliente(Nombre_1, Nombre_2, Apellido_1, Apellido_2, Telefono, Direccion);
        cc.Guardar(cl);
    }

    public void mostrar() {
        try {
            DefaultTableModel modelo;
            CRUD_Cliente cli = new CRUD_Cliente();
            modelo = cli.mostrarDatos();
            jTable_Cliente.setModel(modelo);

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }

    }

    public void editarCliente() {

        CRUD_Cliente cc = new CRUD_Cliente();

        Clase_Cliente cl = new Clase_Cliente(JtextFiel_Nombre_1.getText(),
                JtextFiel_Nombre_2.getText(),
                jTextFiel_Apellido_1.getText(),
                jTextField_Apellido_2.getText(),
                jFormattedTextFieldTelefono.getText(),
                jTextArea_Dirrecion.getText());
        cc.actualizar(cl);

    }

    public void BuscarCliente() {
        try {
            DefaultTableModel modelo;
            CRUD_Cliente cli = new CRUD_Cliente();
            modelo = cli.BuscarCliente(jTextBuscar.getText());

            if (modelo != null) {
                jTable_Cliente.setModel(modelo);
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
        jPanel5 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea_Dirrecion = new javax.swing.JTextArea();
        jSeparator1 = new javax.swing.JSeparator();
        JtextFiel_Nombre_2 = new javax.swing.JTextField();
        JtextFiel_Nombre_1 = new javax.swing.JTextField();
        jTextField_Apellido_2 = new javax.swing.JTextField();
        jTextFiel_Apellido_1 = new javax.swing.JTextField();
        jFormattedTextFieldTelefono = new javax.swing.JFormattedTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable_Cliente = new javax.swing.JTable();
        jTextBuscar = new javax.swing.JTextField();
        jTextField_Id_Ciente = new javax.swing.JTextField();
        jButton6 = new javax.swing.JButton();
        jButton_Editar = new javax.swing.JButton();
        jButton_Borrar = new javax.swing.JButton();
        jButton_Actualizar1 = new javax.swing.JButton();
        jLabel10 = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();

        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 153, 153));
        jLabel2.setText("Id Cliente");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 30, -1, -1));

        jPanel5.setBackground(new java.awt.Color(255, 255, 255));
        jPanel5.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        jPanel5.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
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

        jLabel8.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(0, 153, 153));
        jLabel8.setText("Teléfono");

        jLabel6.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(0, 153, 153));
        jLabel6.setText("Dirección");

        jTextArea_Dirrecion.setColumns(20);
        jTextArea_Dirrecion.setRows(5);
        jTextArea_Dirrecion.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jTextArea_Dirrecion.addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
                jTextArea_Dirrecion(evt);
            }
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
            }
        });
        jTextArea_Dirrecion.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextArea_DirrecionKeyTyped(evt);
            }
        });
        jScrollPane1.setViewportView(jTextArea_Dirrecion);

        JtextFiel_Nombre_2.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        JtextFiel_Nombre_2.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        JtextFiel_Nombre_2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JtextFiel_Nombre_2(evt);
            }
        });
        JtextFiel_Nombre_2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                JtextFiel_Nombre_2KeyTyped(evt);
            }
        });

        JtextFiel_Nombre_1.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        JtextFiel_Nombre_1.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        JtextFiel_Nombre_1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JtextFiel_nombre1(evt);
            }
        });
        JtextFiel_Nombre_1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                JtextFiel_Nombre_1KeyTyped(evt);
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

        jTextFiel_Apellido_1.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextFiel_Apellido_1.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        jTextFiel_Apellido_1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFiel_Apellido_1(evt);
            }
        });
        jTextFiel_Apellido_1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextFiel_Apellido_1KeyTyped(evt);
            }
        });

        try {
            jFormattedTextFieldTelefono.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("####-####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        jFormattedTextFieldTelefono.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jFormattedTextFieldTelefono.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jFormattedTextFieldTelefono(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel8)
                            .addComponent(JtextFiel_Nombre_1, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(5, 5, 5)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                                .addComponent(jLabel6)
                                .addGap(217, 217, 217))
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addGap(39, 39, 39)
                                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(JtextFiel_Nombre_2, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel9))
                                .addGap(36, 36, 36)
                                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jTextFiel_Apellido_1, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel7))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 35, Short.MAX_VALUE)
                                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jTextField_Apellido_2, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel5))
                                .addGap(61, 61, 61))))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                        .addComponent(jFormattedTextFieldTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 284, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
            .addComponent(jSeparator1)
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel3)
                        .addComponent(jLabel9)
                        .addComponent(jLabel5)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 18, Short.MAX_VALUE)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(JtextFiel_Nombre_2, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextFiel_Apellido_1, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField_Apellido_2, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(JtextFiel_Nombre_1, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(jLabel6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jFormattedTextFieldTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(19, 19, 19))
        );

        jPanel1.add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 70, 710, -1));

        jTable_Cliente.setForeground(new java.awt.Color(0, 153, 153));
        jTable_Cliente.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "Id cliente", "Nombre 1", "Nombre 2", "Apellido 1", "Apellido 2", "Telefono", "Dirección"
            }
        ));
        jTable_Cliente.setGridColor(new java.awt.Color(0, 153, 153));
        jTable_Cliente.setShowGrid(false);
        jTable_Cliente.setShowHorizontalLines(true);
        jTable_Cliente.setShowVerticalLines(true);
        jTable_Cliente.addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
                jTable_Cliente(evt);
            }
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
            }
        });
        jTable_Cliente.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jTable_ClienteMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jTable_ClienteMouseExited(evt);
            }
        });
        jScrollPane2.setViewportView(jTable_Cliente);

        jPanel1.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 360, 680, 130));

        jTextBuscar.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        jTextBuscar.setForeground(new java.awt.Color(153, 153, 153));
        jTextBuscar.setText("Buscar");
        jTextBuscar.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        jTextBuscar.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        jTextBuscar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTextBuscarMouseClicked(evt);
            }
        });
        jTextBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextBuscar(evt);
            }
        });
        jTextBuscar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextBuscarKeyReleased(evt);
            }
        });
        jPanel1.add(jTextBuscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 320, 270, 30));

        jTextField_Id_Ciente.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField_Id_Ciente.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        jTextField_Id_Ciente.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        jTextField_Id_Ciente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField_Id_Ciente(evt);
            }
        });
        jPanel1.add(jTextField_Id_Ciente, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 30, 130, 20));

        jButton6.setBackground(new java.awt.Color(0, 153, 153));
        jButton6.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        jButton6.setForeground(new java.awt.Color(255, 255, 255));
        jButton6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Vistas_Iconos/agregar-usuario.png"))); // NOI18N
        jButton6.setText("Agregar");
        jButton6.setBorder(javax.swing.BorderFactory.createEtchedBorder(javax.swing.border.EtchedBorder.RAISED));
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Guardar_Cliente(evt);
            }
        });
        jPanel1.add(jButton6, new org.netbeans.lib.awtextra.AbsoluteConstraints(770, 90, 93, -1));

        jButton_Editar.setBackground(new java.awt.Color(0, 153, 153));
        jButton_Editar.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        jButton_Editar.setForeground(new java.awt.Color(255, 255, 255));
        jButton_Editar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Vistas_Iconos/Editar Usuario.png"))); // NOI18N
        jButton_Editar.setText("Editar");
        jButton_Editar.setBorder(javax.swing.BorderFactory.createEtchedBorder(javax.swing.border.EtchedBorder.RAISED));
        jButton_Editar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_Editar(evt);
            }
        });
        jPanel1.add(jButton_Editar, new org.netbeans.lib.awtextra.AbsoluteConstraints(770, 160, 93, -1));

        jButton_Borrar.setBackground(new java.awt.Color(0, 153, 153));
        jButton_Borrar.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        jButton_Borrar.setForeground(new java.awt.Color(255, 255, 255));
        jButton_Borrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Vistas_Iconos/Eliminar usuario.png"))); // NOI18N
        jButton_Borrar.setText("Eliminar");
        jButton_Borrar.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jButton_Borrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_Borrar(evt);
            }
        });
        jPanel1.add(jButton_Borrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(770, 290, 100, 40));

        jButton_Actualizar1.setBackground(new java.awt.Color(0, 153, 153));
        jButton_Actualizar1.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        jButton_Actualizar1.setForeground(new java.awt.Color(255, 255, 255));
        jButton_Actualizar1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Vistas_Iconos/Actualizar uduario.png"))); // NOI18N
        jButton_Actualizar1.setText("Actualizar");
        jButton_Actualizar1.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jButton_Actualizar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_Actualizar1(evt);
            }
        });
        jPanel1.add(jButton_Actualizar1, new org.netbeans.lib.awtextra.AbsoluteConstraints(770, 230, -1, -1));

        jLabel10.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(0, 153, 153));
        jLabel10.setText("Buscar");
        jPanel1.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 300, -1, -1));

        jPanel6.setBackground(new java.awt.Color(0, 153, 153));

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("Farmacia Rosales");

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                .addGap(0, 18, Short.MAX_VALUE)
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 875, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel4)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(0, 0, 0))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 507, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTable_Cliente(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_jTable_Cliente

    }//GEN-LAST:event_jTable_Cliente

    private void jTable_ClienteMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable_ClienteMouseEntered

    }//GEN-LAST:event_jTable_ClienteMouseEntered

    private void jTable_ClienteMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable_ClienteMouseExited

    }//GEN-LAST:event_jTable_ClienteMouseExited

    private void jTextArea_Dirrecion(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_jTextArea_Dirrecion

    }//GEN-LAST:event_jTextArea_Dirrecion

    private void Guardar_Cliente(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Guardar_Cliente
        CRUD_Cliente cl = new CRUD_Cliente();
        try {
            if ((JtextFiel_Nombre_1.getText().equals(""))
                    || (JtextFiel_Nombre_2.getText().equals(""))
                    || (jTextFiel_Apellido_1.getText().equals(""))
                    || (jTextField_Apellido_2.getText().equals(""))
                    || (jFormattedTextFieldTelefono.getText().equals("    -    "))
                    || (jTextArea_Dirrecion.getText().equals(""))) {
                JOptionPane.showMessageDialog(null, "Tiene datos vacíos");
            } else {
                guardarCliente();
                limpiar();
                JOptionPane.showMessageDialog(null, "Datos Guardados Correctamente");
                mostrar();
            }

        } catch (HeadlessException e) {
            JOptionPane.showMessageDialog(null, "Error: " + e);
        }
    }//GEN-LAST:event_Guardar_Cliente

    private void jButton_Editar(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_Editar
        int filaSeleccionada = jTable_Cliente.getSelectedRow();
        if (filaSeleccionada == -1) {
            JOptionPane.showMessageDialog(this, "Seleccione una fila de la tabla para editar");
        } else {
            String Id_Cliente = jTable_Cliente.getValueAt(filaSeleccionada, 0) != null ? jTable_Cliente.getValueAt(filaSeleccionada, 0).toString() : "";

            String nombre1 = jTable_Cliente.getValueAt(filaSeleccionada, 1) != null ? jTable_Cliente.getValueAt(filaSeleccionada, 1).toString() : "";
            String nombre2 = jTable_Cliente.getValueAt(filaSeleccionada, 2) != null ? jTable_Cliente.getValueAt(filaSeleccionada, 2).toString() : "";
            String apellido1 = jTable_Cliente.getValueAt(filaSeleccionada, 3) != null ? jTable_Cliente.getValueAt(filaSeleccionada, 3).toString() : "";
            String apellido2 = jTable_Cliente.getValueAt(filaSeleccionada, 4) != null ? jTable_Cliente.getValueAt(filaSeleccionada, 4).toString() : "";
            String telefono = jTable_Cliente.getValueAt(filaSeleccionada, 5) != null ? jTable_Cliente.getValueAt(filaSeleccionada, 5).toString() : "";
            String direccion = jTable_Cliente.getValueAt(filaSeleccionada, 6) != null ? jTable_Cliente.getValueAt(filaSeleccionada, 6).toString() : "";

            jTextField_Id_Ciente.setText(Id_Cliente);
            JtextFiel_Nombre_1.setText(nombre1);
            JtextFiel_Nombre_2.setText(nombre2);
            jTextFiel_Apellido_1.setText(apellido1);
            jTextField_Apellido_2.setText(apellido2);
            jFormattedTextFieldTelefono.setText(telefono);
            jTextArea_Dirrecion.setText(direccion);

            // Desactivar la edición del campo de texto para el ID del cliente
            jTextField_Id_Ciente.setEditable(false);
        }


    }//GEN-LAST:event_jButton_Editar

    private void jTextBuscar(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextBuscar
        jTextBuscar.setText("");
        jTextBuscar.setForeground(Color.black);
        BuscarCliente();
    }//GEN-LAST:event_jTextBuscar

    private void JtextFiel_nombre1(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JtextFiel_nombre1

    }//GEN-LAST:event_JtextFiel_nombre1

    private void JtextFiel_Nombre_2(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JtextFiel_Nombre_2
        // TODO add your handling code here:
    }//GEN-LAST:event_JtextFiel_Nombre_2

    private void jTextFiel_Apellido_1(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFiel_Apellido_1
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFiel_Apellido_1

    private void jTextField_Id_Ciente(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField_Id_Ciente
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField_Id_Ciente

    private void jTextField_Apellido_2(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField_Apellido_2
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField_Apellido_2

    private void jButton_Borrar(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_Borrar
        int selectedRow = jTable_Cliente.getSelectedRow();
        if (selectedRow != -1) {
            if (JOptionPane.showConfirmDialog(rootPane,
                    "Se eliminará el registro, ¿desea continuar?",
                    "Eliminar Registro",
                    JOptionPane.WARNING_MESSAGE,
                    JOptionPane.YES_NO_OPTION)
                    == JOptionPane.YES_OPTION) {
                String idClienteString = jTable_Cliente.getValueAt(selectedRow, 0).toString();
                int idCliente = Integer.parseInt(idClienteString);

                CRUD_Cliente cli = new CRUD_Cliente();
                cli.eliminar(idCliente);

                mostrar();
                JOptionPane.showMessageDialog(null, "Cliente eliminado correctamente");
            }
        } else {
            JOptionPane.showMessageDialog(null, "Debe seleccionar un cliente");
        }


    }//GEN-LAST:event_jButton_Borrar

    private void jTextBuscarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTextBuscarMouseClicked
        jTextBuscar.setText("");
        jTextBuscar.setForeground(Color.black);
    }//GEN-LAST:event_jTextBuscarMouseClicked

    private void jButton_Actualizar1(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_Actualizar1
        String idCLienteText = jTextField_Id_Ciente.getText();
        int idCliente = Integer.parseInt(idCLienteText);
        String nombre1 = JtextFiel_Nombre_1.getText();
        String nombre2 = JtextFiel_Nombre_2.getText();
        String apellido1 = jTextFiel_Apellido_1.getText();
        String apellido2 = jTextField_Apellido_2.getText();
        String celular = jFormattedTextFieldTelefono.getText();
        String direccion = jTextArea_Dirrecion.getText();

        if ((jTextField_Id_Ciente.getText().equals(""))
                || (JtextFiel_Nombre_1.getText().equals(""))
                || (JtextFiel_Nombre_2.getText().equals(""))
                || (JtextFiel_Nombre_2.getText().equals(""))
                || (jTextField_Apellido_2.getText().equals(""))
                || (jFormattedTextFieldTelefono.getText().equals("    -    "))
                || (jTextArea_Dirrecion.getText().equals(""))) {
            JOptionPane.showMessageDialog(null, "Tiene datos vacíos");
        } else {
            JOptionPane.showMessageDialog(null, "Datos Actualizados Correctamente");

        }
        // Crear objeto Clase_Cliente con los datos obtenidos
        Clase_Cliente cliente = new Clase_Cliente(idCliente, nombre1, nombre2, apellido1, apellido2, celular, direccion);

        // Llamar al método "actualizar" de CRUD_Cliente
        CRUD_Cliente clienteCRUD = new CRUD_Cliente();
        clienteCRUD.actualizar(cliente);
        mostrar();

        // Refrescar la tabla mostrando los datos actualizados
        clienteCRUD.mostrarDatos();
        limpiar();

        // Mostrar mensaje de éxito o cualquier otra notificación
        JOptionPane.showMessageDialog(null, "Cliente actualizado exitosamente.");


    }//GEN-LAST:event_jButton_Actualizar1

    private void jTextBuscarKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextBuscarKeyReleased
        BuscarCliente();
    }//GEN-LAST:event_jTextBuscarKeyReleased

    private void jFormattedTextFieldTelefono(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jFormattedTextFieldTelefono
        // TODO add your handling code here:
    }//GEN-LAST:event_jFormattedTextFieldTelefono

    private void JtextFiel_Nombre_1KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_JtextFiel_Nombre_1KeyTyped
        char car = evt.getKeyChar();
        String texto = JtextFiel_Nombre_1.getText(); // Obtener el texto actual en el campo

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
    }//GEN-LAST:event_JtextFiel_Nombre_1KeyTyped

    private void JtextFiel_Nombre_2KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_JtextFiel_Nombre_2KeyTyped
        char car = evt.getKeyChar();
        String texto = JtextFiel_Nombre_2.getText(); // Obtener el texto actual en el campo

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
    }//GEN-LAST:event_JtextFiel_Nombre_2KeyTyped

    private void jTextFiel_Apellido_1KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFiel_Apellido_1KeyTyped
        char car = evt.getKeyChar();
        String texto = jTextFiel_Apellido_1.getText(); // Obtener el texto actual en el campo

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
    }//GEN-LAST:event_jTextFiel_Apellido_1KeyTyped

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

    private void jTextArea_DirrecionKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextArea_DirrecionKeyTyped
        String texto = jTextArea_Dirrecion.getText(); 

        if (texto.length() >= 200) {
            evt.consume();
        }
    }//GEN-LAST:event_jTextArea_DirrecionKeyTyped


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField JtextFiel_Nombre_1;
    private javax.swing.JTextField JtextFiel_Nombre_2;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton_Actualizar1;
    private javax.swing.JButton jButton_Borrar;
    private javax.swing.JButton jButton_Editar;
    private javax.swing.JFormattedTextField jFormattedTextFieldTelefono;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTable jTable_Cliente;
    private javax.swing.JTextArea jTextArea_Dirrecion;
    private javax.swing.JTextField jTextBuscar;
    private javax.swing.JTextField jTextFiel_Apellido_1;
    private javax.swing.JTextField jTextField_Apellido_2;
    private javax.swing.JTextField jTextField_Id_Ciente;
    // End of variables declaration//GEN-END:variables
}
