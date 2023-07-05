package Vistas;

import Controlador.CRUD_Laboratorio;
import Controlador.CRUD_Presentacion;
import Modelo.Clase_Laboratorio;
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
public class JInternalFrame_Laboratorio extends javax.swing.JInternalFrame {

    public JInternalFrame_Laboratorio() {
        initComponents();
        jTextField_id_laboratorio.setEditable(false);
    }

    public void limpiar() {
        jTextField_id_laboratorio.setText("");
        jTextField_Nombre.setText("");
    }

    public void GuardarLaboratorio() {
        CRUD_Laboratorio cc = new CRUD_Laboratorio();
        String Nombre_Presentacion = jTextField_Nombre.getText();

        Clase_Laboratorio c1 = new Clase_Laboratorio(Nombre_Presentacion);
        cc.Guardar(c1);
    }

    public void mostrar() {
        try {
            DefaultTableModel modelo;
            CRUD_Laboratorio cli = new CRUD_Laboratorio();
            modelo = cli.mostrarDatos();
            jTable_Laboratorio.setModel(modelo);

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }

    }

    public void BuscarLaboratorio() {
        try {
            DefaultTableModel modelo;
            CRUD_Laboratorio cli = new CRUD_Laboratorio();
            modelo = cli.buscarDatos(jTextField_Buscar.getText());

            if (modelo != null) {
                jTable_Laboratorio.setModel(modelo);
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
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jTextField_Nombre = new javax.swing.JTextField();
        jTextField_id_laboratorio = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable_Laboratorio = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        jButton_Agregar = new javax.swing.JButton();
        jButton_Editar = new javax.swing.JButton();
        jButton_Actualizar = new javax.swing.JButton();
        jButton_Eliminar = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jPanel7 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

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
        jPanel1.add(jTextField_Buscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 140, 220, 30));

        jLabel2.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 153, 153));
        jLabel2.setText("Buscar");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 120, -1, -1));

        jLabel4.setBackground(new java.awt.Color(0, 153, 153));
        jLabel4.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 153, 153));
        jLabel4.setText("Id Laboratorio");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 30, -1, -1));

        jTextField_Nombre.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField_Nombre.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        jTextField_Nombre.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        jTextField_Nombre.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTextField_NombreMouseClicked(evt);
            }
        });
        jTextField_Nombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField_Nombre(evt);
            }
        });
        jTextField_Nombre.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextField_NombreKeyTyped(evt);
            }
        });
        jPanel1.add(jTextField_Nombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 50, 120, -1));

        jTextField_id_laboratorio.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField_id_laboratorio.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        jTextField_id_laboratorio.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        jTextField_id_laboratorio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField_id_laboratorio(evt);
            }
        });
        jPanel1.add(jTextField_id_laboratorio, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 50, 120, -1));

        jTable_Laboratorio.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "Id Labaratorio", "Nombre"
            }
        ));
        jTable_Laboratorio.setGridColor(new java.awt.Color(0, 153, 153));
        jTable_Laboratorio.setShowGrid(true);
        jTable_Laboratorio.addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
                jTable_Laboratorio(evt);
            }
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
            }
        });
        jScrollPane1.setViewportView(jTable_Laboratorio);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 180, 510, 130));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        jButton_Agregar.setBackground(new java.awt.Color(0, 153, 153));
        jButton_Agregar.setFont(new java.awt.Font("Dialog", 1, 11)); // NOI18N
        jButton_Agregar.setForeground(new java.awt.Color(255, 255, 255));
        jButton_Agregar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Vistas_Iconos/agregar.png"))); // NOI18N
        jButton_Agregar.setText("Agregar");
        jButton_Agregar.setBorder(javax.swing.BorderFactory.createEtchedBorder(javax.swing.border.EtchedBorder.RAISED));
        jButton_Agregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_Agregar(evt);
            }
        });

        jButton_Editar.setBackground(new java.awt.Color(0, 153, 153));
        jButton_Editar.setFont(new java.awt.Font("Dialog", 1, 11)); // NOI18N
        jButton_Editar.setForeground(new java.awt.Color(255, 255, 255));
        jButton_Editar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Vistas_Iconos/editar.png"))); // NOI18N
        jButton_Editar.setText("Editar");
        jButton_Editar.setBorder(javax.swing.BorderFactory.createEtchedBorder(javax.swing.border.EtchedBorder.RAISED));
        jButton_Editar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_Editar(evt);
            }
        });

        jButton_Actualizar.setBackground(new java.awt.Color(0, 153, 153));
        jButton_Actualizar.setFont(new java.awt.Font("Dialog", 1, 11)); // NOI18N
        jButton_Actualizar.setForeground(new java.awt.Color(255, 255, 255));
        jButton_Actualizar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Vistas_Iconos/Actualizar.png"))); // NOI18N
        jButton_Actualizar.setText("Actualizar");
        jButton_Actualizar.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jButton_Actualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_Actualizar(evt);
            }
        });

        jButton_Eliminar.setBackground(new java.awt.Color(0, 153, 153));
        jButton_Eliminar.setFont(new java.awt.Font("Dialog", 1, 11)); // NOI18N
        jButton_Eliminar.setForeground(new java.awt.Color(255, 255, 255));
        jButton_Eliminar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Vistas_Iconos/eliminar.png"))); // NOI18N
        jButton_Eliminar.setText("Eliminar");
        jButton_Eliminar.setBorder(javax.swing.BorderFactory.createEtchedBorder(javax.swing.border.EtchedBorder.RAISED));
        jButton_Eliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_Eliminar(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jButton_Agregar, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton_Editar, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton_Actualizar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton_Eliminar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(8, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButton_Agregar)
                .addGap(26, 26, 26)
                .addComponent(jButton_Editar)
                .addGap(31, 31, 31)
                .addComponent(jButton_Actualizar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 28, Short.MAX_VALUE)
                .addComponent(jButton_Eliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(16, 16, 16))
        );

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 20, 110, 260));

        jLabel3.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 153, 153));
        jLabel3.setText("Nombre");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 30, -1, -1));

        jPanel7.setBackground(new java.awt.Color(0, 153, 153));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Farmacia Rosales");

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 791, Short.MAX_VALUE)
            .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel7Layout.createSequentialGroup()
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 791, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 49, Short.MAX_VALUE)
            .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                    .addContainerGap(12, Short.MAX_VALUE)
                    .addComponent(jLabel1)
                    .addContainerGap(12, Short.MAX_VALUE)))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 347, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTextField_id_laboratorio(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField_id_laboratorio
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField_id_laboratorio

    private void jTextField_Nombre(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField_Nombre
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField_Nombre

    private void jTextField_Buscar(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField_Buscar
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField_Buscar

    private void jTable_Laboratorio(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_jTable_Laboratorio
        // TODO add your handling code here:
    }//GEN-LAST:event_jTable_Laboratorio

    private void jButton_Agregar(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_Agregar
        CRUD_Presentacion c1 = new CRUD_Presentacion();
        try {
            if (jTextField_Nombre.getText().isEmpty()) {
                JOptionPane.showMessageDialog(null, "Tiene datos vacíos");
            } else {
                if (c1.verificarDatos(jTextField_Nombre.getText())) {
                    JOptionPane.showMessageDialog(null, "Ya existe este laboratorio");
                } else {
                    int option = JOptionPane.showOptionDialog(
                            null,
                            "Desea agregar el laboratorio?",
                            "Agregar Laboratorio",
                            JOptionPane.YES_NO_OPTION,
                            JOptionPane.QUESTION_MESSAGE,
                            new ImageIcon(getClass().getResource("/Vistas_Iconos/agregar.png")),
                            new Object[]{"Sí", "No"},
                            "No"
                    );

                    if (option == JOptionPane.YES_OPTION) {
                        GuardarLaboratorio();
                        limpiar();
                        mostrar();

                        JPanel panel = new JPanel();
                        panel.setLayout(new BorderLayout());

                        JLabel messageLabel = new JLabel("Laboratorio agregado correctamente");
                        messageLabel.setFont(new Font("Arial", Font.BOLD, 14));
                        messageLabel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
                        panel.add(messageLabel, BorderLayout.CENTER);

                        ImageIcon icon = new ImageIcon(getClass().getResource("/Vistas_Iconos/agregar.png"));
                        JLabel iconLabel = new JLabel(icon);
                        iconLabel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
                        panel.add(iconLabel, BorderLayout.WEST);

                        JOptionPane.showMessageDialog(null, panel, "Guardado Exitoso", JOptionPane.PLAIN_MESSAGE);
                    }
                }
            }
        } catch (HeadlessException e) {
            JOptionPane.showMessageDialog(null, "Error: " + e);
        }

    }//GEN-LAST:event_jButton_Agregar

    private void jButton_Editar(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_Editar
        int filaSeleccionada = jTable_Laboratorio.getSelectedRow();
        if (filaSeleccionada == -1) {
            JOptionPane.showMessageDialog(this, "Seleccione una fila de la tabla para editar");
        } else {
            String id_labo = jTable_Laboratorio.getValueAt(filaSeleccionada, 0) != null ? jTable_Laboratorio.getValueAt(filaSeleccionada, 0).toString() : "";
            String nombre = jTable_Laboratorio.getValueAt(filaSeleccionada, 1) != null ? jTable_Laboratorio.getValueAt(filaSeleccionada, 1).toString() : "";

            jTextField_id_laboratorio.setText(id_labo);
            jTextField_Nombre.setText(nombre);

            jTextField_id_laboratorio.setEditable(false);
        }
    }//GEN-LAST:event_jButton_Editar

    private void jButton_Actualizar(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_Actualizar
        String idlaboText = jTextField_id_laboratorio.getText();
        int idCategoria = Integer.parseInt(idlaboText);
        String nombre = jTextField_Nombre.getText();

        Clase_Laboratorio categoria = new Clase_Laboratorio(idCategoria, nombre);

        int option = JOptionPane.showOptionDialog(
                null,
                "¿Desea actualizar este Laboratorio?",
                "Confirmar Actualización",
                JOptionPane.YES_NO_OPTION,
                JOptionPane.QUESTION_MESSAGE,
                new ImageIcon(getClass().getResource("/Vistas_Iconos/actualizar.png")),
                new Object[]{"Sí", "No"},
                "No"
        );

        if (option == JOptionPane.YES_OPTION) {
            CRUD_Laboratorio Crud_Categoria = new CRUD_Laboratorio();
            Crud_Categoria.actualizar(categoria);
            mostrar();

            JPanel panel = new JPanel();
            panel.setLayout(new BorderLayout());

            JLabel messageLabel = new JLabel("Laboratorio actualizado exitosamente.");
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

    }//GEN-LAST:event_jButton_Actualizar

    private void jButton_Eliminar(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_Eliminar
        int selectedRow = jTable_Laboratorio.getSelectedRow();
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
                String idCategoriaString = jTable_Laboratorio.getValueAt(selectedRow, 0).toString();
                int idCategoria = Integer.parseInt(idCategoriaString);

                CRUD_Laboratorio cli = new CRUD_Laboratorio();
                cli.eliminar(idCategoria);
                mostrar();

                JOptionPane.showMessageDialog(
                        null,
                        "Laboratorio eliminado correctamente",
                        "Eliminación Exitosa",
                        JOptionPane.PLAIN_MESSAGE,
                        new ImageIcon(getClass().getResource("/Vistas_Iconos/eliminar (2).png"))
                );
            } else {
                JOptionPane.showMessageDialog(null, "Debe seleccionar la fila");
            }
        }


    }//GEN-LAST:event_jButton_Eliminar

    private void jTextField_NombreKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField_NombreKeyTyped
        char car = evt.getKeyChar();
        String texto = jTextField_Nombre.getText(); // Obtener el texto actual en el campo

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
    }//GEN-LAST:event_jTextField_NombreKeyTyped

    private void jTextField_BuscarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTextField_BuscarMouseClicked
        jTextField_Buscar.setText("");
        jTextField_Buscar.setForeground(Color.black);
    }//GEN-LAST:event_jTextField_BuscarMouseClicked

    private void jTextField_NombreMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTextField_NombreMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField_NombreMouseClicked

    private void jTextField_BuscarKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField_BuscarKeyReleased
        BuscarLaboratorio();
    }//GEN-LAST:event_jTextField_BuscarKeyReleased


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton_Actualizar;
    private javax.swing.JButton jButton_Agregar;
    private javax.swing.JButton jButton_Editar;
    private javax.swing.JButton jButton_Eliminar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable_Laboratorio;
    private javax.swing.JTextField jTextField_Buscar;
    private javax.swing.JTextField jTextField_Nombre;
    private javax.swing.JTextField jTextField_id_laboratorio;
    // End of variables declaration//GEN-END:variables
}
