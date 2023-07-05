
package Modelo_MDI1;


import Vistas.Login_Form;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import Vistas.InternalFrame_Cliente;
import Vistas.JFrame_Espera;
import Vistas.JInternalFrame_Categoria;
import Vistas.JInternalFrame_Empleado;
import Vistas.JInternalFrame_Laboratorio;
import Vistas.JInternalFrame_Presentacion;
import Vistas.JInternalFrame_Producto;
import Vistas.JInternalFrame_Proveedor;
import Vistas.JInternalFrame_Venta_Producto;

/**
 *
 * @author Usuario
 */
public class MDIMenu1 extends javax.swing.JFrame {



    public MDIMenu1() {
        initComponents();

       

       
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jDesktopPane = new javax.swing.JDesktopPane();
        jPanel1 = new javax.swing.JPanel();
        jButton_Inicio = new javax.swing.JButton();
        jButton_Producto_Proveedor = new javax.swing.JButton();
        jButton_Venta_Producto = new javax.swing.JButton();
        jButton_Compra_producto = new javax.swing.JButton();
        jButton_Presentacion = new javax.swing.JButton();
        jButton_Laboratorio = new javax.swing.JButton();
        jButton_Categoria = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jButton_Producto = new javax.swing.JButton();
        jButton_Cliente = new javax.swing.JButton();
        jButton_Proveedor = new javax.swing.JButton();
        jButton_Empleado = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(0, 153, 153));

        jButton_Inicio.setBackground(new java.awt.Color(0, 153, 153));
        jButton_Inicio.setFont(new java.awt.Font("Roboto", 1, 12)); // NOI18N
        jButton_Inicio.setForeground(new java.awt.Color(255, 255, 255));
        jButton_Inicio.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Vistas_Iconos/Boton_Inicio.png"))); // NOI18N
        jButton_Inicio.setText("Inicio");
        jButton_Inicio.setToolTipText("Nuevo Cliente");
        jButton_Inicio.setBorder(null);
        jButton_Inicio.setFocusable(false);
        jButton_Inicio.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton_Inicio.setPreferredSize(new java.awt.Dimension(90, 92));
        jButton_Inicio.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButton_Inicio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_Inicio(evt);
            }
        });

        jButton_Producto_Proveedor.setBackground(new java.awt.Color(0, 153, 153));
        jButton_Producto_Proveedor.setFont(new java.awt.Font("Roboto", 1, 12)); // NOI18N
        jButton_Producto_Proveedor.setForeground(new java.awt.Color(255, 255, 255));
        jButton_Producto_Proveedor.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Vistas_Iconos/Boton_Producto_Proveedor.png"))); // NOI18N
        jButton_Producto_Proveedor.setText("Productos de Proveedores");
        jButton_Producto_Proveedor.setToolTipText("Nuevo Cliente");
        jButton_Producto_Proveedor.setBorder(null);
        jButton_Producto_Proveedor.setFocusable(false);
        jButton_Producto_Proveedor.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton_Producto_Proveedor.setPreferredSize(new java.awt.Dimension(90, 92));
        jButton_Producto_Proveedor.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButton_Producto_Proveedor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_Producto_Proveedor(evt);
            }
        });

        jButton_Venta_Producto.setBackground(new java.awt.Color(0, 153, 153));
        jButton_Venta_Producto.setFont(new java.awt.Font("Roboto", 1, 12)); // NOI18N
        jButton_Venta_Producto.setForeground(new java.awt.Color(255, 255, 255));
        jButton_Venta_Producto.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Vistas_Iconos/Boton_Venta_Producto.png"))); // NOI18N
        jButton_Venta_Producto.setText("Venta de producto");
        jButton_Venta_Producto.setToolTipText("Nuevo Cliente");
        jButton_Venta_Producto.setBorder(null);
        jButton_Venta_Producto.setFocusable(false);
        jButton_Venta_Producto.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton_Venta_Producto.setPreferredSize(new java.awt.Dimension(90, 92));
        jButton_Venta_Producto.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButton_Venta_Producto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_Venta_Producto(evt);
            }
        });

        jButton_Compra_producto.setBackground(new java.awt.Color(0, 153, 153));
        jButton_Compra_producto.setFont(new java.awt.Font("Roboto", 1, 12)); // NOI18N
        jButton_Compra_producto.setForeground(new java.awt.Color(255, 255, 255));
        jButton_Compra_producto.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Vistas_Iconos/Boton_Compra_Producto.png"))); // NOI18N
        jButton_Compra_producto.setText("Compra de producto");
        jButton_Compra_producto.setToolTipText("Nuevo Cliente");
        jButton_Compra_producto.setBorder(null);
        jButton_Compra_producto.setFocusable(false);
        jButton_Compra_producto.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton_Compra_producto.setPreferredSize(new java.awt.Dimension(90, 92));
        jButton_Compra_producto.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButton_Compra_producto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_Compra_producto(evt);
            }
        });

        jButton_Presentacion.setBackground(new java.awt.Color(0, 153, 153));
        jButton_Presentacion.setFont(new java.awt.Font("Roboto", 1, 12)); // NOI18N
        jButton_Presentacion.setForeground(new java.awt.Color(255, 255, 255));
        jButton_Presentacion.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Vistas_Iconos/Boton_presentacion.png"))); // NOI18N
        jButton_Presentacion.setText("Presentacion");
        jButton_Presentacion.setToolTipText("Nuevo Cliente");
        jButton_Presentacion.setBorder(null);
        jButton_Presentacion.setFocusable(false);
        jButton_Presentacion.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton_Presentacion.setPreferredSize(new java.awt.Dimension(90, 92));
        jButton_Presentacion.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButton_Presentacion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_Presentacion(evt);
            }
        });

        jButton_Laboratorio.setBackground(new java.awt.Color(0, 153, 153));
        jButton_Laboratorio.setFont(new java.awt.Font("Roboto", 1, 12)); // NOI18N
        jButton_Laboratorio.setForeground(new java.awt.Color(255, 255, 255));
        jButton_Laboratorio.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Vistas_Iconos/Boton_laboratorio.png"))); // NOI18N
        jButton_Laboratorio.setText("Laboratorio");
        jButton_Laboratorio.setToolTipText("Nuevo Cliente");
        jButton_Laboratorio.setBorder(null);
        jButton_Laboratorio.setFocusable(false);
        jButton_Laboratorio.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton_Laboratorio.setPreferredSize(new java.awt.Dimension(90, 92));
        jButton_Laboratorio.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButton_Laboratorio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_Laboratorio(evt);
            }
        });

        jButton_Categoria.setBackground(new java.awt.Color(0, 153, 153));
        jButton_Categoria.setFont(new java.awt.Font("Roboto", 1, 12)); // NOI18N
        jButton_Categoria.setForeground(new java.awt.Color(255, 255, 255));
        jButton_Categoria.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Vistas_Iconos/Boton_Categoria.png"))); // NOI18N
        jButton_Categoria.setText("Categoria");
        jButton_Categoria.setToolTipText("Nuevo Cliente");
        jButton_Categoria.setBorder(null);
        jButton_Categoria.setFocusable(false);
        jButton_Categoria.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton_Categoria.setPreferredSize(new java.awt.Dimension(90, 92));
        jButton_Categoria.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButton_Categoria.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_Categoria(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jButton_Inicio, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton_Venta_Producto, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton_Compra_producto, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton_Producto_Proveedor, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton_Presentacion, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton_Categoria, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton_Laboratorio, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jButton_Laboratorio, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jButton_Presentacion, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 71, Short.MAX_VALUE)
                    .addComponent(jButton_Venta_Producto, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(jButton_Producto_Proveedor, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(jButton_Compra_producto, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(jButton_Inicio, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)))
            .addComponent(jButton_Categoria, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
        );

        jPanel2.setBackground(new java.awt.Color(0, 153, 153));

        jButton_Producto.setBackground(new java.awt.Color(0, 153, 153));
        jButton_Producto.setFont(new java.awt.Font("Roboto", 1, 12)); // NOI18N
        jButton_Producto.setForeground(new java.awt.Color(255, 255, 255));
        jButton_Producto.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Vistas_Iconos/Boton_medicamento.png"))); // NOI18N
        jButton_Producto.setText("Producto");
        jButton_Producto.setToolTipText("Nuevo Cliente");
        jButton_Producto.setBorder(null);
        jButton_Producto.setFocusable(false);
        jButton_Producto.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton_Producto.setPreferredSize(new java.awt.Dimension(90, 92));
        jButton_Producto.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButton_Producto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_Producto(evt);
            }
        });

        jButton_Cliente.setBackground(new java.awt.Color(0, 153, 153));
        jButton_Cliente.setFont(new java.awt.Font("Roboto", 1, 12)); // NOI18N
        jButton_Cliente.setForeground(new java.awt.Color(255, 255, 255));
        jButton_Cliente.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Vistas_Iconos/Boton_Cliente.png"))); // NOI18N
        jButton_Cliente.setText("Cliente");
        jButton_Cliente.setToolTipText("Nuevo Cliente");
        jButton_Cliente.setBorder(null);
        jButton_Cliente.setFocusable(false);
        jButton_Cliente.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton_Cliente.setPreferredSize(new java.awt.Dimension(90, 92));
        jButton_Cliente.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButton_Cliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_Cliente(evt);
            }
        });

        jButton_Proveedor.setBackground(new java.awt.Color(0, 153, 153));
        jButton_Proveedor.setFont(new java.awt.Font("Roboto", 1, 12)); // NOI18N
        jButton_Proveedor.setForeground(new java.awt.Color(255, 255, 255));
        jButton_Proveedor.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Vistas_Iconos/Boton_Proveedor.png"))); // NOI18N
        jButton_Proveedor.setText("Proveedor");
        jButton_Proveedor.setToolTipText("Nuevo Cliente");
        jButton_Proveedor.setBorder(null);
        jButton_Proveedor.setFocusable(false);
        jButton_Proveedor.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton_Proveedor.setPreferredSize(new java.awt.Dimension(90, 92));
        jButton_Proveedor.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButton_Proveedor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_Proveedor(evt);
            }
        });

        jButton_Empleado.setBackground(new java.awt.Color(0, 153, 153));
        jButton_Empleado.setFont(new java.awt.Font("Roboto", 1, 12)); // NOI18N
        jButton_Empleado.setForeground(new java.awt.Color(255, 255, 255));
        jButton_Empleado.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Vistas_Iconos/Boton_empleados.png"))); // NOI18N
        jButton_Empleado.setText("Empleado");
        jButton_Empleado.setToolTipText("Nuevo Cliente");
        jButton_Empleado.setBorder(null);
        jButton_Empleado.setFocusable(false);
        jButton_Empleado.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton_Empleado.setPreferredSize(new java.awt.Dimension(90, 92));
        jButton_Empleado.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButton_Empleado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_Empleado(evt);
            }
        });

        jButton3.setText("Cerrar Seción");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton4.setText("Salir");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jButton_Empleado, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 118, Short.MAX_VALUE))
                .addContainerGap())
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jButton_Cliente, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton_Producto, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton_Proveedor, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 118, Short.MAX_VALUE))
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(jButton4)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jButton_Producto, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton_Cliente, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton_Proveedor, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton_Empleado, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(97, 97, 97)
                .addComponent(jButton3)
                .addGap(29, 29, 29)
                .addComponent(jButton4)
                .addContainerGap(30, Short.MAX_VALUE))
        );

        jDesktopPane.setLayer(jPanel1, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane.setLayer(jPanel2, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout jDesktopPaneLayout = new javax.swing.GroupLayout(jDesktopPane);
        jDesktopPane.setLayout(jDesktopPaneLayout);
        jDesktopPaneLayout.setHorizontalGroup(
            jDesktopPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jDesktopPaneLayout.createSequentialGroup()
                .addGroup(jDesktopPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 195, Short.MAX_VALUE))
        );
        jDesktopPaneLayout.setVerticalGroup(
            jDesktopPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jDesktopPaneLayout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(48, Short.MAX_VALUE))
        );

        getContentPane().add(jDesktopPane, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1120, 650));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton_Inicio(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_Inicio

    }//GEN-LAST:event_jButton_Inicio

    private void jButton_Producto_Proveedor(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_Producto_Proveedor
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton_Producto_Proveedor

    private void jButton_Venta_Producto(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_Venta_Producto
        JInternalFrame_Venta_Producto est = new JInternalFrame_Venta_Producto();
        int x = (jDesktopPane.getWidth() / 2) - est.getWidth() / 2;
        int y = (jDesktopPane.getHeight() / 2) - est.getHeight() / 2;
        est.setLocation(x, y);
        jDesktopPane.add(est);
        est.setVisible(true);
    }//GEN-LAST:event_jButton_Venta_Producto

    private void jButton_Cliente(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_Cliente
       InternalFrame_Cliente est = new InternalFrame_Cliente();
        int x = (jDesktopPane.getWidth() - est.getWidth()) / 2;
        int y = (jDesktopPane.getHeight() - est.getHeight()) / 2;
        est.setLocation(x, y);
        est.mostrar();
        jDesktopPane.add(est);
        est.setVisible(true);
        try {
            est.setSelected(true);
        } catch (java.beans.PropertyVetoException e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_jButton_Cliente

    private void jButton_Compra_producto(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_Compra_producto
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton_Compra_producto

    private void jButton_Producto(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_Producto
        JInternalFrame_Producto est = new JInternalFrame_Producto();

        // Establecer el tamaño del JInternalFrame_Producto para que se ajuste al JDesktopPane
        est.setSize(jDesktopPane.getWidth(), jDesktopPane.getHeight());

        // Agregar el JInternalFrame_Producto al JDesktopPane
        jDesktopPane.add(est);
        est.setVisible(true);
        est.mostrar();
    }//GEN-LAST:event_jButton_Producto

    private void jButton_Proveedor(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_Proveedor
       JInternalFrame_Proveedor est = new JInternalFrame_Proveedor();
        int x = (jDesktopPane.getWidth() / 2) - est.getWidth() / 2;
        int y = (jDesktopPane.getHeight() / 2) - est.getHeight() / 2;
        est.setLocation(x, y);
        est.mostrar();
        jDesktopPane.add(est);
        est.setVisible(true);
    }//GEN-LAST:event_jButton_Proveedor

    private void jButton_Empleado(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_Empleado
        JInternalFrame_Empleado est = new JInternalFrame_Empleado();
        int x = (jDesktopPane.getWidth() / 2) - est.getWidth() / 2;
        int y = (jDesktopPane.getHeight() / 2) - est.getHeight() / 2;
        est.setLocation(x, y);
        est.mostrar();
        jDesktopPane.add(est);
        est.setVisible(true);
    }//GEN-LAST:event_jButton_Empleado

    private void jButton_Laboratorio(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_Laboratorio
      JInternalFrame_Laboratorio est = new JInternalFrame_Laboratorio();
        int x = (jDesktopPane.getWidth() / 2) - est.getWidth() / 2;
        int y = (jDesktopPane.getHeight() / 2) - est.getHeight() / 2;
        est.setLocation(x, y);
        jDesktopPane.add(est);
        est.setVisible(true);
        est.mostrar();
    }//GEN-LAST:event_jButton_Laboratorio

    private void jButton_Presentacion(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_Presentacion
       JInternalFrame_Presentacion est = new JInternalFrame_Presentacion();
        int x = (jDesktopPane.getWidth() / 2) - est.getWidth() / 2;
        int y = (jDesktopPane.getHeight() / 2) - est.getHeight() / 2;
        est.setLocation(x, y);
        jDesktopPane.add(est);
        est.setVisible(true);
        est.mostrar();
    }//GEN-LAST:event_jButton_Presentacion

    private void jButton_Categoria(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_Categoria
        JInternalFrame_Categoria est = new JInternalFrame_Categoria();
        int x = (jDesktopPane.getWidth() / 2) - est.getWidth() / 2;
        int y = (jDesktopPane.getHeight() / 2) - est.getHeight() / 2;
        est.setLocation(x, y);
        est.mostrar();
        jDesktopPane.add(est);
        est.setVisible(true);
        est.mostrar();
    }//GEN-LAST:event_jButton_Categoria

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton4ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                JFrame_Espera frameEspera = new JFrame_Espera();
                frameEspera.setVisible(true);

                // Simulación de carga del proyecto (sustituir con la lógica real de carga)
                try {
                    Thread.sleep(3000); // Espera de 3 segundos
                } catch (InterruptedException ex) {
                    ex.printStackTrace();
                }

                frameEspera.dispose();

                java.awt.EventQueue.invokeLater(new Runnable() {
                    public void run() {
                        Login_Form loginForm = new Login_Form();
                        loginForm.setLocationRelativeTo(null);
                        loginForm.setVisible(true);

                        loginForm.addWindowListener(new WindowAdapter() {
                            @Override
                            public void windowClosed(WindowEvent e) {
                                String rol = loginForm.getRol();

                                if (rol != null) {
                                    if (rol.equals("Gerente")) {
                                        mostrarMDIMenu();
                                    } else if (rol.equals("Vendedor")) {
                                        mostrarMDIMenu1();
                                    }
                                }
                            }
                        });
                    }
                });
            }
        });
    }

    private static void mostrarMDIMenu() {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                MDIMenu1 frameRosales = new MDIMenu1();
                frameRosales.setLocationRelativeTo(null);
                frameRosales.setVisible(true);
            }
        });
    }

    private static void mostrarMDIMenu1() {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                MDIMenu1 frameRosales1 = new MDIMenu1();
                frameRosales1.setLocationRelativeTo(null);
                frameRosales1.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton_Categoria;
    private javax.swing.JButton jButton_Cliente;
    private javax.swing.JButton jButton_Compra_producto;
    private javax.swing.JButton jButton_Empleado;
    private javax.swing.JButton jButton_Inicio;
    private javax.swing.JButton jButton_Laboratorio;
    private javax.swing.JButton jButton_Presentacion;
    private javax.swing.JButton jButton_Producto;
    private javax.swing.JButton jButton_Producto_Proveedor;
    private javax.swing.JButton jButton_Proveedor;
    private javax.swing.JButton jButton_Venta_Producto;
    private javax.swing.JDesktopPane jDesktopPane;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    // End of variables declaration//GEN-END:variables

   
}
