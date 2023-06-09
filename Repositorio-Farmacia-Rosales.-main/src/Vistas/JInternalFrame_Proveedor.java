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
         jTextField_id_Proveedor1.setEditable(false);

    }

    public void limpiar() {
        jTextField_id_Proveedor1.setText("");
        jFormattedTextField_Cedula.setText("");
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
        String Cedula = jFormattedTextField_Cedula.getText();
        String Nombre1 = jTextField_Nombre_1.getText();
        String Nombre2 = jTextField_Nombre_2.getText();
        String Apellido1 = jTextField_Apellido_1.getText();
        String Apellido2 = jTextField_Apellido_2.getText();
        String gmail = jTextField_Gmail.getText();
        String Telefono = jFormattedTextField_Telefono.getText();
        String Direccio = jTextArea_Direccion.getText();

        Clase_Proveedor cl = new Clase_Proveedor(Cedula, Nombre1, Nombre2, Apellido1, Apellido2, Telefono, gmail, Direccio);
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

        Clase_Proveedor cl = new Clase_Proveedor(jFormattedTextField_Cedula.getText(),
                jTextField_Nombre_1.getText(),
                jTextField_Nombre_2.getText(),
                jTextField_Apellido_1.getText(),
                jTextField_Apellido_2.getText(),
                jFormattedTextField_Telefono.getText(),
                jTextField_Gmail.getText(),
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
        jTextField_Buscar = new javax.swing.JTextField();
        jPanel5 = new javax.swing.JPanel();
        jTextField_Nombre_1 = new javax.swing.JTextField();
        jTextField_Nombre_2 = new javax.swing.JTextField();
        jTextField_Apellido_1 = new javax.swing.JTextField();
        jTextField_Apellido_2 = new javax.swing.JTextField();
        jPanel6 = new javax.swing.JPanel();
        jTextField_Gmail = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea_Direccion = new javax.swing.JTextArea();
        jFormattedTextField_Telefono = new javax.swing.JFormattedTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable_Proveedor = new javax.swing.JTable();
        jButton_Agregar = new javax.swing.JButton();
        jButton_Actualizar = new javax.swing.JButton();
        jButton_Editar = new javax.swing.JButton();
        jButton_Eliminar = new javax.swing.JButton();
        jTextField_id_Proveedor1 = new javax.swing.JTextField();
        jFormattedTextField_Cedula = new javax.swing.JFormattedTextField();
        jPanel4 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setForeground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTextField_Buscar.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        jTextField_Buscar.setForeground(new java.awt.Color(153, 153, 153));
        jTextField_Buscar.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Buscar", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 12))); // NOI18N
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
        jPanel1.add(jTextField_Buscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 270, 280, 45));

        jPanel5.setBackground(new java.awt.Color(255, 255, 255));
        jPanel5.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        jPanel5.setOpaque(false);

        jTextField_Nombre_1.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField_Nombre_1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Primer Nombre", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 12), new java.awt.Color(0, 153, 153))); // NOI18N
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
        jTextField_Nombre_2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Segundo Apellido", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 12), new java.awt.Color(0, 153, 153))); // NOI18N
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
        jTextField_Apellido_1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Primer Apellido", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 12), new java.awt.Color(0, 153, 153))); // NOI18N
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
        jTextField_Apellido_2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Segundo Apellido", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 12), new java.awt.Color(0, 153, 153))); // NOI18N
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
                .addComponent(jTextField_Nombre_1, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jTextField_Nombre_2, javax.swing.GroupLayout.DEFAULT_SIZE, 171, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(jTextField_Apellido_1, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jTextField_Apellido_2, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField_Nombre_1, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField_Nombre_2, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField_Apellido_1, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField_Apellido_2, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(41, Short.MAX_VALUE))
        );

        jPanel1.add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 80, -1, -1));

        jPanel6.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        jPanel6.setOpaque(false);

        jTextField_Gmail.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField_Gmail.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Gmail", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 12), new java.awt.Color(0, 153, 153))); // NOI18N
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
        jTextArea_Direccion.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Dirrecion", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 12), new java.awt.Color(0, 153, 153))); // NOI18N
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

        jFormattedTextField_Telefono.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Telefono", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 12), new java.awt.Color(0, 153, 153))); // NOI18N
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
                .addComponent(jFormattedTextField_Telefono, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(46, 46, 46)
                .addComponent(jTextField_Gmail, javax.swing.GroupLayout.PREFERRED_SIZE, 223, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 32, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 284, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(19, 19, 19))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jTextField_Gmail, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jFormattedTextField_Telefono, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(19, Short.MAX_VALUE))
        );

        jPanel1.add(jPanel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 170, 740, 80));

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

        jPanel1.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 320, 880, 150));

        jButton_Agregar.setBackground(new java.awt.Color(153, 255, 153));
        jButton_Agregar.setFont(new java.awt.Font("Dialog", 1, 11)); // NOI18N
        jButton_Agregar.setText("Agregar");
        jButton_Agregar.setBorder(javax.swing.BorderFactory.createEtchedBorder(javax.swing.border.EtchedBorder.RAISED));
        jButton_Agregar.setPreferredSize(new java.awt.Dimension(80, 30));
        jButton_Agregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_Agregar(evt);
            }
        });
        jPanel1.add(jButton_Agregar, new org.netbeans.lib.awtextra.AbsoluteConstraints(790, 90, 93, -1));

        jButton_Actualizar.setBackground(new java.awt.Color(51, 204, 255));
        jButton_Actualizar.setFont(new java.awt.Font("Dialog", 1, 11)); // NOI18N
        jButton_Actualizar.setText("Actualizar");
        jButton_Actualizar.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jButton_Actualizar.setPreferredSize(new java.awt.Dimension(80, 30));
        jButton_Actualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_Actualizar(evt);
            }
        });
        jPanel1.add(jButton_Actualizar, new org.netbeans.lib.awtextra.AbsoluteConstraints(790, 200, 90, 30));

        jButton_Editar.setBackground(new java.awt.Color(255, 255, 51));
        jButton_Editar.setFont(new java.awt.Font("Dialog", 1, 11)); // NOI18N
        jButton_Editar.setText("Editar");
        jButton_Editar.setBorder(javax.swing.BorderFactory.createEtchedBorder(javax.swing.border.EtchedBorder.RAISED));
        jButton_Editar.setPreferredSize(new java.awt.Dimension(80, 30));
        jButton_Editar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_Editar(evt);
            }
        });
        jPanel1.add(jButton_Editar, new org.netbeans.lib.awtextra.AbsoluteConstraints(790, 150, 93, -1));

        jButton_Eliminar.setBackground(new java.awt.Color(0, 153, 153));
        jButton_Eliminar.setFont(new java.awt.Font("Dialog", 1, 11)); // NOI18N
        jButton_Eliminar.setForeground(new java.awt.Color(255, 255, 255));
        jButton_Eliminar.setText("Eliminar");
        jButton_Eliminar.setBorder(javax.swing.BorderFactory.createEtchedBorder(javax.swing.border.EtchedBorder.RAISED));
        jButton_Eliminar.setPreferredSize(new java.awt.Dimension(80, 30));
        jButton_Eliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_Eliminar(evt);
            }
        });
        jPanel1.add(jButton_Eliminar, new org.netbeans.lib.awtextra.AbsoluteConstraints(790, 250, 90, 30));

        jTextField_id_Proveedor1.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField_id_Proveedor1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "ID", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 12), new java.awt.Color(0, 153, 153))); // NOI18N
        jTextField_id_Proveedor1.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        jTextField_id_Proveedor1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField_id_Proveedor1(evt);
            }
        });
        jPanel1.add(jTextField_id_Proveedor1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, 150, 45));

        jFormattedTextField_Cedula.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Cedula", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 12), new java.awt.Color(0, 153, 153))); // NOI18N
        try {
            jFormattedTextField_Cedula.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("###-######-####U")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        jFormattedTextField_Cedula.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jPanel1.add(jFormattedTextField_Cedula, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 20, 260, 45));

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
                .addGap(0, 0, Short.MAX_VALUE)
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

    private void jButton_Editar(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_Editar
        int filaSeleccionada = jTable_Proveedor.getSelectedRow();
        if (filaSeleccionada == -1) {
            JOptionPane.showMessageDialog(this, "Seleccione una fila de la tabla para editar");
        } else {
            String Id_provee = jTable_Proveedor.getValueAt(filaSeleccionada, 0) != null ? jTable_Proveedor.getValueAt(filaSeleccionada, 0).toString() : "";
            String cedula = jTable_Proveedor.getValueAt(filaSeleccionada, 1) != null ? jTable_Proveedor.getValueAt(filaSeleccionada, 1).toString() : "";
            String nombre1 = jTable_Proveedor.getValueAt(filaSeleccionada, 2) != null ? jTable_Proveedor.getValueAt(filaSeleccionada, 2).toString() : "";
            String nombre2 = jTable_Proveedor.getValueAt(filaSeleccionada, 3) != null ? jTable_Proveedor.getValueAt(filaSeleccionada, 3).toString() : "";
            String apellido1 = jTable_Proveedor.getValueAt(filaSeleccionada, 4) != null ? jTable_Proveedor.getValueAt(filaSeleccionada, 4).toString() : "";
            String apellido2 = jTable_Proveedor.getValueAt(filaSeleccionada, 5) != null ? jTable_Proveedor.getValueAt(filaSeleccionada, 5).toString() : "";
            String gmail = jTable_Proveedor.getValueAt(filaSeleccionada, 6) != null ? jTable_Proveedor.getValueAt(filaSeleccionada, 6).toString() : "";
            String telefono = jTable_Proveedor.getValueAt(filaSeleccionada, 7) != null ? jTable_Proveedor.getValueAt(filaSeleccionada, 7).toString() : "";
            String direccion = jTable_Proveedor.getValueAt(filaSeleccionada, 8) != null ? jTable_Proveedor.getValueAt(filaSeleccionada, 8).toString() : "";

            
            jTextField_id_Proveedor1.setText(Id_provee);
            jFormattedTextField_Cedula.setText(cedula);
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
                        new ImageIcon(getClass().getResource("/Vistas_Iconos/agregar.png")),
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

                    ImageIcon icon = new ImageIcon(getClass().getResource("/Vistas_Iconos/agregar.png"));
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
        int filaSeleccionada = jTable_Proveedor.getSelectedRow();
    if (filaSeleccionada == -1) {
        JOptionPane.showMessageDialog(this, "Seleccione una fila de la tabla para editar");
    } else {
        String idProveedorText = jTable_Proveedor.getValueAt(filaSeleccionada, 0).toString();
        int idProveedor = Integer.parseInt(idProveedorText);
        String cedula = jFormattedTextField_Cedula.getText();
        String nombre1 = jTextField_Nombre_1.getText();
        String nombre2 = jTextField_Nombre_2.getText();
        String apellido1 = jTextField_Apellido_1.getText();
        String apellido2 = jTextField_Apellido_2.getText();
        String gmail = jTextField_Gmail.getText();
        String telefono = jFormattedTextField_Telefono.getText();
        String direccion = jTextArea_Direccion.getText();

        if (cedula.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Tiene datos vacíos");
        } else {
            int option = JOptionPane.showOptionDialog(
                    null,
                    "¿Desea actualizar el Proveedor?",
                    "Confirmar Actualización",
                    JOptionPane.YES_NO_OPTION,
                    JOptionPane.QUESTION_MESSAGE,
                    new ImageIcon(getClass().getResource("/Vistas_Iconos/actualizar.png")),
                    new Object[]{"Sí", "No"},
                    "No"
            );

            if (option == JOptionPane.YES_OPTION) {
                // Crear objeto Clase_Proveedor con los datos obtenidos
                Clase_Proveedor proveedor = new Clase_Proveedor(idProveedor, cedula, nombre1, nombre2, apellido1, apellido2, gmail, telefono, direccion);

                // Llamar al método "actualizar" de CRUD_Proveedor
                CRUD_Proveedor proveedorCRUD = new CRUD_Proveedor();
                proveedorCRUD.actualizar(proveedor);

                JPanel panel = new JPanel();
                panel.setLayout(new BorderLayout());

                JLabel messageLabel = new JLabel("Proveedor actualizado exitosamente.");
                messageLabel.setFont(new Font("Arial", Font.BOLD, 14));
                messageLabel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
                panel.add(messageLabel, BorderLayout.CENTER);

                ImageIcon icon = new ImageIcon(getClass().getResource("/Vistas_Iconos/actualizar.png"));
                JLabel iconLabel = new JLabel(icon);
                iconLabel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
                panel.add(iconLabel, BorderLayout.WEST);

                JOptionPane.showMessageDialog(null, panel, "Actualización Exitosa", JOptionPane.PLAIN_MESSAGE);
            }
        }

        CRUD_Proveedor proveedorCRUD = new CRUD_Proveedor();
        proveedorCRUD.mostrarDatos();
        limpiar();
        mostrar();
    }


    }//GEN-LAST:event_jButton_Actualizar

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

    private void jTextField_id_Proveedor1(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField_id_Proveedor1
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField_id_Proveedor1

    private void jButton_Eliminar(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_Eliminar
        int selectedRow = jTable_Proveedor.getSelectedRow();
        if (selectedRow != -1) {
            int option = JOptionPane.showOptionDialog(
                rootPane,
                "Se eliminará el registro, ¿desea continuar?",
                "Eliminar Registro",
                JOptionPane.YES_NO_OPTION,
                JOptionPane.WARNING_MESSAGE,
                new ImageIcon(getClass().getResource("/Vistas_Iconos/eliminar (2).png")),
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

                ImageIcon icon = new ImageIcon(getClass().getResource("/Vistas_Iconos/eliminar (2).png"));
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

            ImageIcon icon = new ImageIcon(getClass().getResource("/Vistas_Iconos/abvertencia.png"));
            JLabel iconLabel = new JLabel(icon);
            iconLabel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
            panel.add(iconLabel, BorderLayout.WEST);

            JOptionPane.showMessageDialog(null, panel, "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_jButton_Eliminar


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton_Actualizar;
    private javax.swing.JButton jButton_Agregar;
    private javax.swing.JButton jButton_Editar;
    private javax.swing.JButton jButton_Eliminar;
    private javax.swing.JFormattedTextField jFormattedTextField_Cedula;
    private javax.swing.JFormattedTextField jFormattedTextField_Telefono;
    private javax.swing.JLabel jLabel1;
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
    private javax.swing.JTextField jTextField_id_Proveedor1;
    // End of variables declaration//GEN-END:variables
}
