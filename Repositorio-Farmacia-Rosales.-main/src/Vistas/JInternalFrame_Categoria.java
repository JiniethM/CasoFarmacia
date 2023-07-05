package Vistas;

import Controlador.CRUD_Categoria;
import Modelo.Clase_Categoria;
import Controlador_Conexion_DB.Conexion;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.HeadlessException;
import java.awt.event.KeyEvent;
import java.sql.Connection;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author diedr
 */
public class JInternalFrame_Categoria extends javax.swing.JInternalFrame {

    public final Conexion con = new Conexion();
    public final Connection cn = (Connection) con.conectar();
    private JPanel panel;

    public JInternalFrame_Categoria() {

        initComponents();
        jTextField_Id_Categoria.setEditable(false);

    }

    public void limpiar() {
        jTextField_Id_Categoria.setText("");
        jTextField_Nombre_Categoria.setText("");
        jTextArea_Descripcion_Categoria.setText("");
    }

    public void GuardarCategoria() {
        CRUD_Categoria cc = new CRUD_Categoria();
        String Nombre_Categoria = jTextField_Nombre_Categoria.getText();
        String Descripcion = jTextArea_Descripcion_Categoria.getText();

        Clase_Categoria c1 = new Clase_Categoria(Nombre_Categoria, Descripcion);
        cc.Guardar(c1);
    }

    public void mostrar() {
        try {
            DefaultTableModel modelo;
            CRUD_Categoria cli = new CRUD_Categoria();
            modelo = cli.mostrarDatos();
            jTable_Categoria.setModel(modelo);

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }

    }

    public void BuscarCliente() {
        try {
            DefaultTableModel modelo;
            CRUD_Categoria cli = new CRUD_Categoria();
            modelo = cli.buscarDatos(jTextField_Buscar.getText());

            if (modelo != null) {
                jTable_Categoria.setModel(modelo);
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
        jPanel3 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable_Categoria = new javax.swing.JTable();
        jPanel4 = new javax.swing.JPanel();
        jButton_Agregar_Categoria = new javax.swing.JButton();
        jButton_Editar_categoria = new javax.swing.JButton();
        jButton_Actualizar_Categoria = new javax.swing.JButton();
        jButton_Eliminar_Categoria = new javax.swing.JButton();
        jTextField_Id_Categoria = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        jTextField_Nombre_Categoria = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea_Descripcion_Categoria = new javax.swing.JTextArea();
        jTextField_Buscar = new javax.swing.JTextField();
        jPanel5 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();

        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));

        jTable_Categoria.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Id Categoria", "Nombre de categoria", "Descripción"
            }
        ));
        jTable_Categoria.setGridColor(new java.awt.Color(0, 153, 153));
        jTable_Categoria.setShowGrid(true);
        jTable_Categoria.addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
                jTable_Categoria(evt);
            }
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
            }
        });
        jScrollPane2.setViewportView(jTable_Categoria);

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));
        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        jButton_Agregar_Categoria.setBackground(new java.awt.Color(0, 153, 153));
        jButton_Agregar_Categoria.setFont(new java.awt.Font("Dialog", 1, 11)); // NOI18N
        jButton_Agregar_Categoria.setForeground(new java.awt.Color(255, 255, 255));
        jButton_Agregar_Categoria.setText("Agregar");
        jButton_Agregar_Categoria.setBorder(javax.swing.BorderFactory.createEtchedBorder(javax.swing.border.EtchedBorder.RAISED));
        jButton_Agregar_Categoria.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_Agregar_Categoria(evt);
            }
        });

        jButton_Editar_categoria.setBackground(new java.awt.Color(255, 255, 51));
        jButton_Editar_categoria.setFont(new java.awt.Font("Dialog", 1, 11)); // NOI18N
        jButton_Editar_categoria.setText("Editar");
        jButton_Editar_categoria.setBorder(javax.swing.BorderFactory.createEtchedBorder(javax.swing.border.EtchedBorder.RAISED));
        jButton_Editar_categoria.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_Editar_categoria(evt);
            }
        });

        jButton_Actualizar_Categoria.setBackground(new java.awt.Color(51, 204, 255));
        jButton_Actualizar_Categoria.setFont(new java.awt.Font("Dialog", 1, 11)); // NOI18N
        jButton_Actualizar_Categoria.setForeground(new java.awt.Color(255, 255, 255));
        jButton_Actualizar_Categoria.setText("Actualizar");
        jButton_Actualizar_Categoria.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jButton_Actualizar_Categoria.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_Actualizar_Categoria(evt);
            }
        });

        jButton_Eliminar_Categoria.setBackground(new java.awt.Color(255, 102, 102));
        jButton_Eliminar_Categoria.setFont(new java.awt.Font("Dialog", 1, 11)); // NOI18N
        jButton_Eliminar_Categoria.setForeground(new java.awt.Color(255, 255, 255));
        jButton_Eliminar_Categoria.setText("Eliminar");
        jButton_Eliminar_Categoria.setBorder(javax.swing.BorderFactory.createEtchedBorder(javax.swing.border.EtchedBorder.RAISED));
        jButton_Eliminar_Categoria.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_Eliminar_Categoria(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jButton_Actualizar_Categoria, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButton_Eliminar_Categoria, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton_Agregar_Categoria, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton_Editar_categoria, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButton_Agregar_Categoria, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(44, 44, 44)
                .addComponent(jButton_Editar_categoria, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(41, 41, 41)
                .addComponent(jButton_Actualizar_Categoria, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
                .addGap(44, 44, 44)
                .addComponent(jButton_Eliminar_Categoria, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
                .addGap(31, 31, 31))
        );

        jTextField_Id_Categoria.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField_Id_Categoria.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "ID", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 12), new java.awt.Color(0, 153, 153))); // NOI18N
        jTextField_Id_Categoria.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        jTextField_Id_Categoria.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField_Id_Categoria(evt);
            }
        });

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        jTextField_Nombre_Categoria.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField_Nombre_Categoria.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Nombre de Categoria", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 12), new java.awt.Color(0, 153, 153))); // NOI18N
        jTextField_Nombre_Categoria.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        jTextField_Nombre_Categoria.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField_Nombre_Categoria(evt);
            }
        });
        jTextField_Nombre_Categoria.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextField_Nombre_CategoriaKeyTyped(evt);
            }
        });

        jTextArea_Descripcion_Categoria.setColumns(20);
        jTextArea_Descripcion_Categoria.setRows(5);
        jTextArea_Descripcion_Categoria.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Descripcion", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 12), new java.awt.Color(0, 153, 153))); // NOI18N
        jTextArea_Descripcion_Categoria.setMinimumSize(new java.awt.Dimension(11, 45));
        jTextArea_Descripcion_Categoria.addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
                jTextArea_Descripcion_Categoria(evt);
            }
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
            }
        });
        jTextArea_Descripcion_Categoria.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextArea_Descripcion_CategoriaKeyTyped(evt);
            }
        });
        jScrollPane1.setViewportView(jTextArea_Descripcion_Categoria);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTextField_Nombre_Categoria, javax.swing.GroupLayout.PREFERRED_SIZE, 186, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(40, 40, 40)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 268, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(26, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(22, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jTextField_Nombre_Categoria, javax.swing.GroupLayout.DEFAULT_SIZE, 45, Short.MAX_VALUE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addGap(20, 20, 20))
        );

        jTextField_Buscar.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        jTextField_Buscar.setForeground(new java.awt.Color(153, 153, 153));
        jTextField_Buscar.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Buscar", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 12), new java.awt.Color(0, 153, 153))); // NOI18N
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

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jTextField_Id_Categoria, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTextField_Buscar, javax.swing.GroupLayout.PREFERRED_SIZE, 301, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 528, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 104, Short.MAX_VALUE)
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(51, 51, 51))))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(jTextField_Id_Categoria, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(33, 33, 33)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 15, Short.MAX_VALUE)
                .addComponent(jTextField_Buscar, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(19, 19, 19))
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(75, 75, 75)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel1.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 44, 800, 440));

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
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 802, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addContainerGap(9, Short.MAX_VALUE))
        );

        jPanel1.add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 800, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTextField_Buscar(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField_Buscar
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField_Buscar

    private void jTextField_Id_Categoria(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField_Id_Categoria
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField_Id_Categoria

    private void jTextField_Nombre_Categoria(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField_Nombre_Categoria
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField_Nombre_Categoria

    private void jTextArea_Descripcion_Categoria(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_jTextArea_Descripcion_Categoria
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextArea_Descripcion_Categoria

    private void jTable_Categoria(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_jTable_Categoria
        // TODO add your handling code here:
    }//GEN-LAST:event_jTable_Categoria

    private void jButton_Agregar_Categoria(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_Agregar_Categoria
        CRUD_Categoria c1 = new CRUD_Categoria();
        try {
            if (jTextField_Nombre_Categoria.getText().isEmpty() || jTextArea_Descripcion_Categoria.getText().isEmpty()) {
                JOptionPane.showMessageDialog(null, "Tiene datos vacíos");
            } else {
                int option = JOptionPane.showOptionDialog(
                        null,
                        "¿Desea guardar la Categoría?",
                        "Confirmar Guardado",
                        JOptionPane.YES_NO_OPTION,
                        JOptionPane.QUESTION_MESSAGE,
                        new ImageIcon(getClass().getResource("/Vistas_Iconos/agregar.png")),
                        new Object[]{"Sí", "No"},
                        "No"
                );

                if (c1.verificarDatos(jTextField_Nombre_Categoria.getText())) {
                    JOptionPane.showMessageDialog(null, "Ya existe esta categoría");
                }

                if (option == JOptionPane.YES_OPTION) {
                    GuardarCategoria();
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


    }//GEN-LAST:event_jButton_Agregar_Categoria

    private void jButton_Editar_categoria(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_Editar_categoria
        int filaSeleccionada = jTable_Categoria.getSelectedRow();
        if (filaSeleccionada == -1) {
            JOptionPane.showMessageDialog(this, "Seleccione una fila de la tabla para editar");
        } else {
            String id_Cate = jTable_Categoria.getValueAt(filaSeleccionada, 0) != null ? jTable_Categoria.getValueAt(filaSeleccionada, 0).toString() : "";
            String nombre = jTable_Categoria.getValueAt(filaSeleccionada, 1) != null ? jTable_Categoria.getValueAt(filaSeleccionada, 1).toString() : "";
            String Descrip = jTable_Categoria.getValueAt(filaSeleccionada, 2) != null ? jTable_Categoria.getValueAt(filaSeleccionada, 2).toString() : "";

            jTextField_Id_Categoria.setText(id_Cate);
            jTextField_Nombre_Categoria.setText(nombre);
            jTextArea_Descripcion_Categoria.setText(Descrip);

            jTextField_Id_Categoria.setEditable(false);
        }
    }//GEN-LAST:event_jButton_Editar_categoria

    private void jButton_Actualizar_Categoria(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_Actualizar_Categoria
        String idCategoriaText = jTextField_Id_Categoria.getText();
        int idCategoria = Integer.parseInt(idCategoriaText);
        String nombre = jTextField_Nombre_Categoria.getText();
        String descripcion = jTextArea_Descripcion_Categoria.getText();

        Clase_Categoria categoria = new Clase_Categoria(idCategoria, nombre, descripcion);

        int option = JOptionPane.showOptionDialog(
                null,
                "¿Desea actualizar la categoría?",
                "Confirmar Actualización",
                JOptionPane.YES_NO_OPTION,
                JOptionPane.QUESTION_MESSAGE,
                new ImageIcon(getClass().getResource("/Vistas_Iconos/actualizar.png")),
                new Object[]{"Sí", "No"},
                "No"
        );

        if (option == JOptionPane.YES_OPTION) {
            CRUD_Categoria crudCategoria = new CRUD_Categoria();
            crudCategoria.actualizar(categoria);
            mostrar();

            JPanel panel = new JPanel();
            panel.setLayout(new BorderLayout());

            JLabel messageLabel = new JLabel("Categoría actualizada exitosamente.");
            messageLabel.setFont(new Font("Arial", Font.BOLD, 14));
            messageLabel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
            panel.add(messageLabel, BorderLayout.CENTER);

            ImageIcon icon = new ImageIcon(getClass().getResource("/Vistas_Iconos/actualizar.png"));
            JLabel iconLabel = new JLabel(icon);
            iconLabel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
            panel.add(iconLabel, BorderLayout.WEST);

            JOptionPane.showMessageDialog(null, panel, "Actualización Exitosa", JOptionPane.PLAIN_MESSAGE);
            limpiar();
        }


    }//GEN-LAST:event_jButton_Actualizar_Categoria

    private void jButton_Eliminar_Categoria(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_Eliminar_Categoria
        int selectedRow = jTable_Categoria.getSelectedRow();
        if (selectedRow != -1) {
            JPanel panel = new JPanel();
            panel.setLayout(new GridBagLayout());

            JLabel messageLabel = new JLabel("Se eliminará el registro, ¿desea continuar?");
            messageLabel.setFont(new Font("Arial", Font.BOLD, 14));
            messageLabel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

            ImageIcon icon = new ImageIcon(getClass().getResource("/Vistas_Iconos/eliminar (2).png"));
            JLabel iconLabel = new JLabel(icon);
            iconLabel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

            panel.add(iconLabel);
            panel.add(messageLabel);

            int option = JOptionPane.showOptionDialog(
                    null,
                    panel,
                    "Eliminar Registro",
                    JOptionPane.YES_NO_OPTION,
                    JOptionPane.WARNING_MESSAGE,
                    null,
                    new Object[]{"Sí", "No"},
                    "No"
            );

            if (option == JOptionPane.YES_OPTION) {
                String idCategoriaString = jTable_Categoria.getValueAt(selectedRow, 0).toString();
                int idCategoria = Integer.parseInt(idCategoriaString);

                CRUD_Categoria cli = new CRUD_Categoria();
                cli.eliminar(idCategoria);
                mostrar();

                JPanel successPanel = new JPanel();
                successPanel.setLayout(new BorderLayout());

                JLabel successMessageLabel = new JLabel("Categoría eliminada correctamente");
                successMessageLabel.setFont(new Font("Arial", Font.BOLD, 14));
                successMessageLabel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
                successPanel.add(successMessageLabel, BorderLayout.CENTER);

                ImageIcon successIcon = new ImageIcon(getClass().getResource("/Vistas_Iconos/eliminar (2).png"));
                JLabel successIconLabel = new JLabel(successIcon);
                successIconLabel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
                successPanel.add(successIconLabel, BorderLayout.WEST);

                JOptionPane.showMessageDialog(null, successPanel, "Eliminación Exitosa", JOptionPane.PLAIN_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(null, "Debe seleccionar la categoría");
            }
        } else {
            JOptionPane.showMessageDialog(null, "Debe seleccionar la fila");
        }


    }//GEN-LAST:event_jButton_Eliminar_Categoria

    private void jTextField_BuscarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTextField_BuscarMouseClicked
        jTextField_Buscar.setText("");
        jTextField_Buscar.setForeground(Color.black);
    }//GEN-LAST:event_jTextField_BuscarMouseClicked

    private void jTextField_Nombre_CategoriaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField_Nombre_CategoriaKeyTyped
        char car = evt.getKeyChar();
        String texto = jTextField_Nombre_Categoria.getText(); // Obtener el texto actual en el campo

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
                || texto.length() >= 50) {
            evt.consume();
        }
    }//GEN-LAST:event_jTextField_Nombre_CategoriaKeyTyped

    private void jTextArea_Descripcion_CategoriaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextArea_Descripcion_CategoriaKeyTyped
        String texto = jTextArea_Descripcion_Categoria.getText();

        if (texto.length() >= 100) {
            evt.consume();
        }
    }//GEN-LAST:event_jTextArea_Descripcion_CategoriaKeyTyped

    private void jTextField_BuscarKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField_BuscarKeyReleased
        BuscarCliente();
    }//GEN-LAST:event_jTextField_BuscarKeyReleased


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton_Actualizar_Categoria;
    private javax.swing.JButton jButton_Agregar_Categoria;
    private javax.swing.JButton jButton_Editar_categoria;
    private javax.swing.JButton jButton_Eliminar_Categoria;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable_Categoria;
    private javax.swing.JTextArea jTextArea_Descripcion_Categoria;
    private javax.swing.JTextField jTextField_Buscar;
    private javax.swing.JTextField jTextField_Id_Categoria;
    private javax.swing.JTextField jTextField_Nombre_Categoria;
    // End of variables declaration//GEN-END:variables
}
