package Vistas;

import Controlador.CRUD_Venta;
import Controlador.CRUD_Venta_Producto;
import Modelo.Clase_Venta;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.GridBagLayout;

import java.awt.HeadlessException;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JDesktopPane;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;

import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.RowFilter;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import javax.swing.table.TableRowSorter;

public class JInternalFrame_Venta extends javax.swing.JInternalFrame {

    public JInternalFrame_Venta() {
        initComponents();
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        centrarRegistrosTabla();
        personalizarTitulosTabla();
        ajustarAlturaFilasTabla();

    }

    private void centrarRegistrosTabla() {
        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(SwingConstants.CENTER);
        jTable_GestionVenta.setDefaultRenderer(Object.class, centerRenderer);
    }

    private void personalizarTitulosTabla() {
        DefaultTableCellRenderer headerRenderer = (DefaultTableCellRenderer) jTable_GestionVenta.getTableHeader().getDefaultRenderer();
        headerRenderer.setHorizontalAlignment(SwingConstants.CENTER);
        jTable_GestionVenta.getTableHeader().setDefaultRenderer(headerRenderer);
        jTable_GestionVenta.getTableHeader().setBackground(new Color(0, 153, 153));
        jTable_GestionVenta.getTableHeader().setForeground(Color.WHITE);
        jTable_GestionVenta.getTableHeader().setFont(new Font("Segoe UI", Font.BOLD, 14));
        jTable_GestionVenta.getTableHeader().setBorder(BorderFactory.createLineBorder(Color.BLACK));
    }

    private void ajustarAlturaFilasTabla() {
        jTable_GestionVenta.setRowHeight(30); // Ajusta aquí la altura deseada en píxeles
    }

    public void mostrar() {
    try {
        DefaultTableModel modelo;
        CRUD_Venta_Producto ventaProductoDAO = new CRUD_Venta_Producto();
        modelo = ventaProductoDAO.mostrarDatosVenta();
        jTable_GestionVenta.setModel(modelo);
    } catch (Exception e) {
        JOptionPane.showMessageDialog(null, e);
    }
}



    public void buscarVentaYProducto() {
        try {
            String busqueda = jTextField_Buscar_GetionVenta.getText();

            DefaultTableModel modelo = (DefaultTableModel) jTable_GestionVenta.getModel();
            TableRowSorter<DefaultTableModel> sorter = new TableRowSorter<>(modelo);
            jTable_GestionVenta.setRowSorter(sorter);

            if (busqueda.trim().length() == 0) {
                sorter.setRowFilter(null);
            } else {
                RowFilter<DefaultTableModel, Object> rf = RowFilter.regexFilter("(?i)" + busqueda);
                sorter.setRowFilter(rf);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel9 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable_GestionVenta = new javax.swing.JTable();
        jTextField_Buscar_GetionVenta = new javax.swing.JTextField();
        jButton_Agregar = new javax.swing.JButton();
        jButton_Eliminar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setClosable(true);
        setIconifiable(true);

        jPanel9.setBackground(new java.awt.Color(0, 153, 153));

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setForeground(new java.awt.Color(255, 255, 255));

        jTable_GestionVenta.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Id Producto", "Descripción", "Cantidad", "Precio", "Descuento", "Total"
            }
        ));
        jTable_GestionVenta.setGridColor(new java.awt.Color(0, 153, 153));
        jTable_GestionVenta.setShowGrid(true);
        jTable_GestionVenta.addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
                jTable_GestionVenta(evt);
            }
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
            }
        });
        jScrollPane2.setViewportView(jTable_GestionVenta);

        jTextField_Buscar_GetionVenta.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        jTextField_Buscar_GetionVenta.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Buscar", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 12))); // NOI18N
        jTextField_Buscar_GetionVenta.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        jTextField_Buscar_GetionVenta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField_Buscar_GetionVenta(evt);
            }
        });
        jTextField_Buscar_GetionVenta.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextField_Buscar_GetionVentaKeyReleased(evt);
            }
        });

        jButton_Agregar.setBackground(new java.awt.Color(0, 153, 153));
        jButton_Agregar.setFont(new java.awt.Font("Dialog", 1, 11)); // NOI18N
        jButton_Agregar.setForeground(new java.awt.Color(255, 255, 255));
        jButton_Agregar.setText("Agregar");
        jButton_Agregar.setBorder(javax.swing.BorderFactory.createEtchedBorder(javax.swing.border.EtchedBorder.RAISED));
        jButton_Agregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_AgregarActionPerformed(evt);
            }
        });

        jButton_Eliminar.setBackground(new java.awt.Color(255, 102, 102));
        jButton_Eliminar.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        jButton_Eliminar.setForeground(new java.awt.Color(255, 255, 255));
        jButton_Eliminar.setText("Eliminar");
        jButton_Eliminar.setBorder(javax.swing.BorderFactory.createEtchedBorder(javax.swing.border.EtchedBorder.RAISED));
        jButton_Eliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_EliminarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 1214, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jTextField_Buscar_GetionVenta, javax.swing.GroupLayout.PREFERRED_SIZE, 545, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(26, 26, 26)
                        .addComponent(jButton_Agregar, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(183, 183, 183)
                        .addComponent(jButton_Eliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(21, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField_Buscar_GetionVenta, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton_Agregar, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton_Eliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 459, Short.MAX_VALUE)
                .addGap(25, 25, 25))
        );

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Farmacia Rosales");

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addGap(11, 11, 11)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTable_GestionVenta(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_jTable_GestionVenta
        mostrar();
    }//GEN-LAST:event_jTable_GestionVenta

    private void jTextField_Buscar_GetionVenta(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField_Buscar_GetionVenta


    }//GEN-LAST:event_jTextField_Buscar_GetionVenta

    private void jButton_EliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_EliminarActionPerformed

        int selectedRow = jTable_GestionVenta.getSelectedRow();
        if (selectedRow != -1) {
            JPanel panel = new JPanel();
            panel.setLayout(new GridBagLayout());

            JLabel messageLabel = new JLabel("Se eliminará la venta, ¿desea continuar?");
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
                    "Eliminar Venta",
                    JOptionPane.YES_NO_OPTION,
                    JOptionPane.WARNING_MESSAGE,
                    null,
                    new Object[]{"Sí", "No"},
                    "No"
            );

            if (option == JOptionPane.YES_OPTION) {
                String idVentaString = jTable_GestionVenta.getValueAt(selectedRow, 0).toString();
                int idVenta = Integer.parseInt(idVentaString);

                CRUD_Venta_Producto ventaProductoDAO = new CRUD_Venta_Producto();
                ventaProductoDAO.eliminarVentaYProducto(idVenta);
                mostrar();

                JPanel successPanel = new JPanel();
                successPanel.setLayout(new BorderLayout());

                JLabel successMessageLabel = new JLabel("Venta eliminada correctamente");
                successMessageLabel.setFont(new Font("Arial", Font.BOLD, 14));
                successMessageLabel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
                successPanel.add(successMessageLabel, BorderLayout.CENTER);

                ImageIcon successIcon = new ImageIcon(getClass().getResource("/Vistas_Iconos/eliminar (2).png"));
                JLabel successIconLabel = new JLabel(successIcon);
                successIconLabel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
                successPanel.add(successIconLabel, BorderLayout.WEST);

                JOptionPane.showMessageDialog(null, successPanel, "Eliminación Exitosa", JOptionPane.PLAIN_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(null, "Debe seleccionar una venta");
        }


    }//GEN-LAST:event_jButton_EliminarActionPerformed

    private void jButton_AgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_AgregarActionPerformed
        Container container = getParent();
        if (container instanceof JDesktopPane) {
            JDesktopPane desktopPane = (JDesktopPane) container;

            // Buscar el formulario JInternalFrame_Venta_Producto en el JDesktopPane
            JInternalFrame_Venta_Producto ventaProductoForm = null;
            JInternalFrame[] frames = desktopPane.getAllFrames();
            for (JInternalFrame frame : frames) {
                if (frame instanceof JInternalFrame_Venta_Producto) {
                    ventaProductoForm = (JInternalFrame_Venta_Producto) frame;
                    break;
                }
            }

            if (ventaProductoForm != null) {
                // Si el formulario ya está abierto, selecciónalo
                try {
                    ventaProductoForm.setSelected(true);
                } catch (java.beans.PropertyVetoException e) {
                    e.printStackTrace();
                }
            } else {
                // Si el formulario no está abierto, crea una nueva instancia y añádela al JDesktopPane
                ventaProductoForm = new JInternalFrame_Venta_Producto();
                desktopPane.add(ventaProductoForm);
                ventaProductoForm.setVisible(true);
                try {
                    ventaProductoForm.setSelected(true);
                } catch (java.beans.PropertyVetoException e) {
                    e.printStackTrace();
                }
            }
        }
    }//GEN-LAST:event_jButton_AgregarActionPerformed

    private void jTextField_Buscar_GetionVentaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField_Buscar_GetionVentaKeyReleased
        buscarVentaYProducto();
    }//GEN-LAST:event_jTextField_Buscar_GetionVentaKeyReleased


    // Variables declaration - do not modify//GEN-BEGIN:variables
    public static javax.swing.JButton jButton_Agregar;
    private javax.swing.JButton jButton_Eliminar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane2;
    public static javax.swing.JTable jTable_GestionVenta;
    public static javax.swing.JTextField jTextField_Buscar_GetionVenta;
    // End of variables declaration//GEN-END:variables
}
