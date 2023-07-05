package Vistas;

import Controlador.CRUD_Producto;
import Controlador_Conexion_DB.Conexion;
import Modelo_MDI1.MDIMenu;
import static Modelo_MDI1.MDIMenu.jDesktopPane;
import java.awt.Color;
import java.awt.Component;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.sql.Connection;
import java.util.Base64;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.UIManager;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

/**
 *
 * @author Diers
 */
public class JInternalFrame_Gestionar_Producto extends javax.swing.JInternalFrame {

    private Image iconoRedimensionado;
    private ImageIcon imagenIcono;
    private ImageIcon imagenGuardada;

    Conexion conexion = new Conexion();

    public JInternalFrame_Gestionar_Producto() {
        // Aquí estamos configurando los colores de los encabezados de la tabla.
        UIManager.put("TableHeader.background", new Color(153, 255, 255));
        UIManager.put("TableHeader.foreground", Color.BLACK);

        initComponents();  // Inicializa los componentes antes de usarlos

        setLayout(new FlowLayout());

        int rowHeight = 64; // Altura deseada de la fila en píxeles
        jTable_Producto1.setRowHeight(rowHeight);

        // Mostrar los datos en la tabla
        mostrar();
    }

    private ImageIcon redimensionarImagen(ImageIcon imagenIcono, int ancho, int alto) {
        Image imagen = imagenIcono.getImage().getScaledInstance(ancho, alto, Image.SCALE_SMOOTH);
        return new ImageIcon(imagen);
    }

    public void configurarTabla() {
        JTableHeader header = jTable_Producto1.getTableHeader();
        header.setBackground(new Color(153, 255, 255)); // Configura el color de fondo del encabezado

        // Configura el color del texto del encabezado
        DefaultTableCellRenderer headerRenderer = new DefaultTableCellRenderer();
        headerRenderer.setForeground(Color.BLACK); // Configura el color de texto deseado
        headerRenderer.setHorizontalAlignment(JLabel.CENTER); // Configura la alineación del texto

        for (int i = 0; i < jTable_Producto1.getModel().getColumnCount(); i++) {
            jTable_Producto1.getColumnModel().getColumn(i).setHeaderRenderer(headerRenderer);
        }

        // Centra los datos en las celdas y maneja la presentación de las imágenes
        jTable_Producto1.setDefaultRenderer(Object.class, new DefaultTableCellRenderer() {
            @Override
            public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
                if (value instanceof JLabel && column == 6) { // Columna de la imagen
                    JLabel label = (JLabel) value;
                    label.setHorizontalAlignment(JLabel.CENTER); // Centra la imagen
                    return label;
                } else { // Para cualquier otra columna
                    super.setHorizontalAlignment(JLabel.CENTER); // Centra el texto
                    return super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
                }
            }
        });
    }

    private byte[] obtenerBytesDesdeImagen(ImageIcon imagenIcono, String formato) {
        BufferedImage bufferedImage = new BufferedImage(imagenIcono.getIconWidth(), imagenIcono.getIconHeight(), BufferedImage.TYPE_INT_RGB);
        Graphics g = bufferedImage.createGraphics();
        imagenIcono.paintIcon(null, g, 0, 0);
        g.dispose();

        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        try {
            ImageIO.write(bufferedImage, formato, baos);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return baos.toByteArray();
    }

    public void mostrar() {
        try {
            DefaultTableModel modelo;
            CRUD_Producto crudProducto = new CRUD_Producto();
            crudProducto.mostrarProductoConProveedor();

            // Obtener los datos del modelo de la tabla
            String[] columnas = {"ID Producto", "Nombre", "Descripción", "Cantidad", "Precio Compra", "Precio Venta", "Imagen", "Fecha Caducidad", "Categoría", "Presentación", "Laboratorio", "Proveedor"};
            Object[][] datos = obtenerDatosTabla(jTable_Producto1);

            if (datos != null && datos.length > 0) {
                modelo = new DefaultTableModel(datos, columnas) {
                    @Override
                    public boolean isCellEditable(int row, int column) {
                        return false; // Desactivar la edición de celdas
                    }
                };
            } else {
                modelo = new DefaultTableModel(columnas, 0) {
                    @Override
                    public boolean isCellEditable(int row, int column) {
                        return false; // Desactivar la edición de celdas
                    }
                };
            }

            // Agregar un CellRenderer personalizado para la columna de la imagen
            jTable_Producto1.setDefaultRenderer(Object.class, new DefaultTableCellRenderer() {
                @Override
                public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
                    if (value instanceof ImageIcon && column == 6) {
                        JLabel label = new JLabel();
                        ImageIcon imagenIcono = (ImageIcon) value;
                        ImageIcon imagenRedimensionada = redimensionarImagen(imagenIcono, 64, 64);
                        label.setIcon(imagenRedimensionada);
                        return label;
                    } else {
                        return super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
                    }
                }
            });

            jTable_Producto1.setModel(modelo);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al mostrar los datos: " + e.getMessage());
        }
    }

    private Object[][] obtenerDatosTabla(JTable tabla) {
        DefaultTableModel modelo = (DefaultTableModel) tabla.getModel();
        int filas = modelo.getRowCount();
        int columnas = modelo.getColumnCount();
        Object[][] datos = new Object[filas][columnas];

        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                datos[i][j] = modelo.getValueAt(i, j);
            }
        }

        return datos;
    }

    public JInternalFrame_Producto obtenerFormularioProducto() {
        Component[] components = getParent().getComponents();

        // Buscar si el formulario JInternalFrame_Producto ya está abierto
        for (Component component : components) {
            if (component instanceof JInternalFrame_Producto) {
                return (JInternalFrame_Producto) component;
            }
        }

        // Si el formulario no está abierto, crear una nueva instancia
        JInternalFrame_Producto formularioProducto = new JInternalFrame_Producto();

        // Agregar el formulario al contenedor MDIParent (jdpane)
        getParent().add(formularioProducto);

        // Ubicar el formulario en el centro del contenedor
        int x = (getParent().getWidth() - formularioProducto.getWidth()) / 2;
        int y = (getParent().getHeight() - formularioProducto.getHeight()) / 2;
        formularioProducto.setLocation(x, y);

        return formularioProducto;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        jTable_Producto1 = new javax.swing.JTable();
        jButton_Editar = new javax.swing.JButton();
        jButton_Eliminar = new javax.swing.JButton();
        jTextField_Buscar = new javax.swing.JTextField();
        jButton_Agregar = new javax.swing.JButton();

        setPreferredSize(new java.awt.Dimension(1200, 579));

        jTable_Producto1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Id_Producto", "Nombre", "Descripción", "Cantidad de producto", "Precio compra", "Precio_Venta", "Imagen", "Fecha_Caducidad", "Id_Categoria", "Id_Presentacion", "Id_Laboratorio"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Float.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jTable_Producto1.setGridColor(new java.awt.Color(0, 153, 153));
        jTable_Producto1.setShowGrid(true);
        jTable_Producto1.addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
                jTable_Producto1(evt);
            }
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
            }
        });
        jScrollPane4.setViewportView(jTable_Producto1);

        jButton_Editar.setBackground(new java.awt.Color(204, 255, 255));
        jButton_Editar.setFont(new java.awt.Font("Dialog", 1, 11)); // NOI18N
        jButton_Editar.setText("Editar");
        jButton_Editar.setBorder(javax.swing.BorderFactory.createEtchedBorder(javax.swing.border.EtchedBorder.RAISED));
        jButton_Editar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_Editar(evt);
            }
        });

        jButton_Eliminar.setBackground(new java.awt.Color(255, 102, 102));
        jButton_Eliminar.setFont(new java.awt.Font("Dialog", 1, 11)); // NOI18N
        jButton_Eliminar.setText("Eliminar");
        jButton_Eliminar.setBorder(javax.swing.BorderFactory.createEtchedBorder(javax.swing.border.EtchedBorder.RAISED));
        jButton_Eliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_Eliminar(evt);
            }
        });

        jTextField_Buscar.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        jTextField_Buscar.setForeground(new java.awt.Color(153, 153, 153));
        jTextField_Buscar.setText("Buscar");
        jTextField_Buscar.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Buscar", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 12), new java.awt.Color(0, 153, 153))); // NOI18N
        jTextField_Buscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField_Buscar(evt);
            }
        });

        jButton_Agregar.setBackground(new java.awt.Color(204, 255, 255));
        jButton_Agregar.setFont(new java.awt.Font("Dialog", 1, 11)); // NOI18N
        jButton_Agregar.setText("Agregar");
        jButton_Agregar.setBorder(javax.swing.BorderFactory.createEtchedBorder(javax.swing.border.EtchedBorder.RAISED));
        jButton_Agregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_Agregar(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane4)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTextField_Buscar, javax.swing.GroupLayout.PREFERRED_SIZE, 417, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 300, Short.MAX_VALUE)
                .addComponent(jButton_Agregar, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(67, 67, 67)
                .addComponent(jButton_Editar, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(59, 59, 59)
                .addComponent(jButton_Eliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(99, 99, 99))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(64, 64, 64)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jButton_Agregar, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jButton_Editar, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jButton_Eliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jTextField_Buscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 426, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTable_Producto1(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_jTable_Producto1

    }//GEN-LAST:event_jTable_Producto1

    private void jButton_Editar(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_Editar


    }//GEN-LAST:event_jButton_Editar

    private void jButton_Eliminar(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_Eliminar

    }//GEN-LAST:event_jButton_Eliminar

    private void jTextField_Buscar(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField_Buscar
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField_Buscar

    private void jButton_Agregar(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_Agregar
        // Cierra este JInternalFrame_Gestionar_Producto
        this.dispose();

        // Abre el JInternalFrame_Producto
        JInternalFrame_Producto producto = new JInternalFrame_Producto();
        producto.setSize(1200, 666);
        producto.setLocation(0, 0);
        producto.setVisible(true);
        producto.mostrar();

        // Aquí necesitarías agregar el nuevo JInternalFrame a tu JDesktopPane
        jDesktopPane.removeAll();
        jDesktopPane.add(producto);
        try {
            producto.setSelected(true);
        } catch (java.beans.PropertyVetoException e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_jButton_Agregar


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton_Agregar;
    private javax.swing.JButton jButton_Editar;
    private javax.swing.JButton jButton_Eliminar;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane4;
    public static javax.swing.JTable jTable_Producto1;
    private javax.swing.JTextField jTextField_Buscar;
    // End of variables declaration//GEN-END:variables
}
