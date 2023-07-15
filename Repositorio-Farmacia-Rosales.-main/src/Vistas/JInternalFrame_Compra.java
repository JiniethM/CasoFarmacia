
package Vistas;

import Controlador.CRUD_Compra_Producto;
import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridBagLayout;
import java.awt.RenderingHints;
import java.awt.Shape;
import java.awt.geom.RoundRectangle2D;
import javax.swing.AbstractButton;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.RowFilter;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.plaf.basic.BasicButtonUI;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

/**
 *
 * @author diedr
 */
public class JInternalFrame_Compra extends javax.swing.JInternalFrame {


    public JInternalFrame_Compra() {
        initComponents();
   this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        centrarRegistrosTabla();
        personalizarTitulosTabla();
        ajustarAlturaFilasTabla();

    }

    private void centrarRegistrosTabla() {
        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(SwingConstants.CENTER);
        jTable_Compra.setDefaultRenderer(Object.class, centerRenderer);
    }

    private void personalizarTitulosTabla() {
        DefaultTableCellRenderer headerRenderer = (DefaultTableCellRenderer) jTable_Compra.getTableHeader().getDefaultRenderer();
        headerRenderer.setHorizontalAlignment(SwingConstants.CENTER);
        jTable_Compra.getTableHeader().setDefaultRenderer(headerRenderer);
        jTable_Compra.getTableHeader().setBackground(new Color(0, 153, 153));
        jTable_Compra.getTableHeader().setForeground(Color.WHITE);
        jTable_Compra.getTableHeader().setFont(new Font("Segoe UI", Font.BOLD, 14));
        jTable_Compra.getTableHeader().setBorder(BorderFactory.createLineBorder(Color.BLACK));
    }

    private void ajustarAlturaFilasTabla() {
        jTable_Compra.setRowHeight(30); // Ajusta aquí la altura deseada en píxeles
    }
     public void mostrar() {
    try {
        DefaultTableModel modelo;
        CRUD_Compra_Producto ventaProductoDAO = new CRUD_Compra_Producto();
        modelo = ventaProductoDAO.mostrarDatosCompra();
        jTable_Compra.setModel(modelo);
    } catch (Exception e) {
        JOptionPane.showMessageDialog(null, e);
    }
}
     public void buscarCompraYProducto() {
        try {
            String busqueda = jTextField_Buscar.getText();

            DefaultTableModel modelo = (DefaultTableModel) jTable_Compra.getModel();
            TableRowSorter<DefaultTableModel> sorter = new TableRowSorter<>(modelo);
            jTable_Compra.setRowSorter(sorter);

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
    

    // Método para aplicar el borde doblado a un botón
   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable_Compra = new javax.swing.JTable();
        jTextField_Buscar = new javax.swing.JTextField();
        jButton_Borrar = new javax.swing.JButton();
        jButton_Agregar = new javax.swing.JButton();
        jPanel8 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();

        setClosable(true);
        setIconifiable(true);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTable_Compra.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        jTable_Compra.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Id Compra", "Id Proveedor", "Fecha", "Total"
            }
        ));
        jTable_Compra.setGridColor(new java.awt.Color(0, 153, 153));
        jTable_Compra.setShowGrid(true);
        jTable_Compra.addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
                jTable_Compra(evt);
            }
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
            }
        });
        jScrollPane1.setViewportView(jTable_Compra);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 100, 970, 330));

        jTextField_Buscar.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        jTextField_Buscar.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Buscar", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 12), new java.awt.Color(0, 153, 153))); // NOI18N
        jTextField_Buscar.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        jTextField_Buscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField_BuscarActionPerformed(evt);
            }
        });
        jTextField_Buscar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextField_BuscarKeyReleased(evt);
            }
        });
        jPanel1.add(jTextField_Buscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 30, 330, 45));

        jButton_Borrar.setBackground(new java.awt.Color(255, 102, 102));
        jButton_Borrar.setFont(new java.awt.Font("Dialog", 1, 11)); // NOI18N
        jButton_Borrar.setText("Eliminar");
        jButton_Borrar.setBorder(javax.swing.BorderFactory.createEtchedBorder(javax.swing.border.EtchedBorder.RAISED));
        jButton_Borrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_BorrarActionPerformed(evt);
            }
        });
        jPanel1.add(jButton_Borrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 40, 80, 30));

        jButton_Agregar.setBackground(new java.awt.Color(153, 255, 153));
        jButton_Agregar.setFont(new java.awt.Font("Dialog", 1, 11)); // NOI18N
        jButton_Agregar.setText("Agregar");
        jButton_Agregar.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        jButton_Agregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_AgregarActionPerformed(evt);
            }
        });
        jPanel1.add(jButton_Agregar, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 40, 80, 30));

        jPanel8.setBackground(new java.awt.Color(0, 153, 153));

        jLabel9.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel9.setText("Farmacia Rosales");

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel9, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel9)
                .addContainerGap(9, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 1016, Short.MAX_VALUE)
            .addComponent(jPanel8, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 435, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTextField_BuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField_BuscarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField_BuscarActionPerformed

    private void jButton_AgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_AgregarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton_AgregarActionPerformed

    private void jTable_Compra(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_jTable_Compra
        mostrar();
    }//GEN-LAST:event_jTable_Compra

    private void jButton_BorrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_BorrarActionPerformed
      
        int selectedRow = jTable_Compra.getSelectedRow();
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
                String idVentaString = jTable_Compra.getValueAt(selectedRow, 0).toString();
                int idVenta = Integer.parseInt(idVentaString);

                CRUD_Compra_Producto compraProductoDAO = new CRUD_Compra_Producto();
                compraProductoDAO.eliminarCompraYProducto(idVenta);
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
    }//GEN-LAST:event_jButton_BorrarActionPerformed

    private void jTextField_BuscarKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField_BuscarKeyReleased
        buscarCompraYProducto();
    }//GEN-LAST:event_jTextField_BuscarKeyReleased


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton_Agregar;
    private javax.swing.JButton jButton_Borrar;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JScrollPane jScrollPane1;
    public static javax.swing.JTable jTable_Compra;
    private javax.swing.JTextField jTextField_Buscar;
    // End of variables declaration//GEN-END:variables
}
