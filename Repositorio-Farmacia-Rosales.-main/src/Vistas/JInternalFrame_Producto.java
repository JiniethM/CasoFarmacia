package Vistas;

import Controlador.CRUD_Categoria;
import Controlador.CRUD_Producto;
import Controlador.CRUD_Producto_Proveedor;
import Controlador_Conexion_DB.Conexion;
import Modelo.Clase_Categoria;
import Modelo.Clase_Laboratorio;
import Modelo.Clase_Presentacion;
import Modelo.Clase_Producto;
import Modelo.Clase_Proveedor;
import Modelo.Class_Producto_Proveedor;
import static Modelo_MDI1.MDIMenu.jDesktopPane;
import static Vistas.JInternalFrame_Gestionar_Producto.jTable_Producto1;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.awt.image.BufferedImage;
import java.awt.Component;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Base64;
import java.util.Vector;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;
import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.table.DefaultTableCellRenderer;

/**
 * @author diedr
 */
public class JInternalFrame_Producto extends javax.swing.JInternalFrame {

    private Image iconoRedimensionado;
    private ImageIcon imagenIcono;
    private ImageIcon imagenGuardada;

    Conexion conexion = new Conexion();

    public JInternalFrame_Producto() {
        setLayout(new FlowLayout());
        initComponents();
        int rowHeight = 64; // Altura deseada de la fila en píxeles
        jTable_Producto1 = new javax.swing.JTable();
        Connection cn = (Connection) conexion.conectar();
        DefaultTableModel model = new DefaultTableModel();
        model.setColumnIdentifiers(new String[]{"Id_Producto", "Nombre", "Descripcion", "Cantidad_Producto", "Precio_Compra", "Precio_Venta", "Imagen_Producto", "Fecha_Caducidad", "Id_Categoria", "Id_Presentacion", "Id_Laboratorio"});

        jTable_Producto1.setModel(model);

        jTable_Producto1.setDefaultRenderer(Object.class, new DefaultTableCellRenderer() {
            @Override
            public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
                if (value instanceof JLabel && column == 6) {
                    JLabel label = (JLabel) value;
                    return label;
                } else {
                    return super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
                }
            }
        });

        jTextField_Buscar_Categoria.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                llenarCategoria(jTextField_Buscar_Categoria.getText());
            }
        });
        jTextField_Buscar_Presentacion.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                llenarComboBoxPresentacion(jTextField_Buscar_Presentacion.getText());
            }

        });
        jTextField_Buscar_Laboratorio.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                llenarComboBoxLaboratorio(jTextField_Buscar_Laboratorio.getText());
            }
        });
        jTextField_Buscar_Id_Proveedor.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                llenarComboBoxProveedor(jTextField_Buscar_Id_Proveedor.getText());
            }
        });
        
        jComboBox_Categoria.setBackground(Color.WHITE);
        jComboBox_Id_Proveedor.setBackground(Color.WHITE);
        jComboBox_Presentacion.setBackground(Color.WHITE);
        jComboBox_Laboratorio.setBackground(Color.WHITE);
        jSpinner_Cantidad.setBackground(Color.WHITE);
        jButton_buscar_imagen.setBackground(Color.WHITE);
        jButton_Eliminar_imagen.setBackground(Color.WHITE);
        jButton_Agregar_tabla_Categoria.setBackground(Color.WHITE);
        jButton_Eliminar_tabla_Categoria.setBackground(Color.WHITE);
        jButton_Agregar_tabla_laboratorio.setBackground(Color.WHITE);
        jButton_Eliminar_tabla_laboratorio.setBackground(Color.WHITE);
        jButton_Agregar_tabla_Proveedor.setBackground(Color.WHITE);
        jButton_Eliminar_tabla_Proveedor.setBackground(Color.WHITE);
        jButton_Agregar_tabla_Presentacion.setBackground(Color.WHITE);
        jButton_Eliminar_tabla_Presentacion.setBackground(Color.WHITE);
        // Configurar el aspecto del jSlider_Descuanto
        UIManager.put("Slider.background", Color.WHITE);
        UIManager.put("Slider.foreground", Color.BLUE);
        UIManager.put("Slider.track", Color.LIGHT_GRAY);
        UIManager.put("Slider.thumb", Color.DARK_GRAY);
        ajustarAlturaFilasTabla(jTable_Categoria);
        centrarRegistrosTabla(jTable_Categoria);
        personalizarTitulosTabla(jTable_Categoria);

        ajustarAlturaFilasTabla(jTable_Laboratorio);
        centrarRegistrosTabla(jTable_Laboratorio);
        personalizarTitulosTabla(jTable_Laboratorio);

        ajustarAlturaFilasTabla(jTable_Proveedor);
        centrarRegistrosTabla(jTable_Proveedor);
        personalizarTitulosTabla(jTable_Proveedor);

        ajustarAlturaFilasTabla(jTable_Presentacion);
        centrarRegistrosTabla(jTable_Presentacion);
        personalizarTitulosTabla(jTable_Presentacion);

    }

    public ImageIcon redimensionarImagen(ImageIcon imagen, int ancho, int alto) {
        Image img = imagen.getImage();
        Image imgRedimensionada = img.getScaledInstance(ancho, alto, Image.SCALE_SMOOTH);
        return new ImageIcon(imgRedimensionada);
    }

    public void llenarComboBoxProveedor(String busqueda) {
        CRUD_Producto gr = new CRUD_Producto();
        ArrayList<Clase_Proveedor> listaProveedores = gr.buscarProveedor(busqueda);
        jComboBox_Id_Proveedor.removeAllItems();
        for (Clase_Proveedor proveedor : listaProveedores) {
            jComboBox_Id_Proveedor.addItem(proveedor);
        }
    }

    public void agregarProveedorATabla() {
        Clase_Proveedor proveedorSeleccionado = (Clase_Proveedor) jComboBox_Id_Proveedor.getSelectedItem();
        if (proveedorSeleccionado == null) {
            JOptionPane.showMessageDialog(null, "Debe seleccionar un proveedor.");
            return;
        }

        DefaultTableModel model = (DefaultTableModel) jTable_Proveedor.getModel();
        DefaultTableModel newModel = new DefaultTableModel();

        // Obtener los nombres de las columnas
        int columnCount = model.getColumnCount();
        Object[] columnNames = new Object[columnCount];
        for (int i = 0; i < columnCount; i++) {
            columnNames[i] = model.getColumnName(i);
        }
        newModel.setColumnIdentifiers(columnNames);

        newModel.addRow(new Object[]{
            proveedorSeleccionado.getId_Proveedor(),
            proveedorSeleccionado.getNombre_1(),
            proveedorSeleccionado.getApellido_1()
        });

        // Copiando las filas existentes del modelo original al nuevo modelo
        for (int i = 0; i < model.getRowCount(); i++) {
            newModel.addRow((Vector) model.getDataVector().get(i));
        }

        jTable_Proveedor.setModel(newModel);
        jComboBox_Id_Proveedor.setSelectedIndex(-1);
        jTextField_Buscar_Id_Proveedor.setText("");
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

    public void llenarComboBoxLaboratorio(String busqueda) {
        CRUD_Producto gr = new CRUD_Producto();
        ArrayList<Clase_Laboratorio> listaLaboratorio = gr.buscarLaboratorios(busqueda);
        jComboBox_Laboratorio.removeAllItems();
        for (Clase_Laboratorio laboratorio : listaLaboratorio) {
            jComboBox_Laboratorio.addItem(laboratorio);
        }
    }

    public void agregarLaboratorioATabla() {
        Clase_Laboratorio laboratorioSeleccionado = (Clase_Laboratorio) jComboBox_Laboratorio.getSelectedItem();
        if (laboratorioSeleccionado == null) {
            JOptionPane.showMessageDialog(null, "Debe seleccionar un laboratorio.");
            return;
        }

        DefaultTableModel model = (DefaultTableModel) jTable_Laboratorio.getModel();

        model.insertRow(0, new Object[]{
            laboratorioSeleccionado.getId_Laboratorio(),
            laboratorioSeleccionado.getNombre()
        });

        jComboBox_Laboratorio.setSelectedIndex(-1);
        jTextField_Buscar_Laboratorio.setText("");
    }

    public void llenarCategoria(String busqueda) {
        CRUD_Producto gr = new CRUD_Producto();
        ArrayList<Clase_Categoria> listaCategorias = gr.mostrarDatosCombo(busqueda);
        jComboBox_Categoria.removeAllItems();
        for (Clase_Categoria categoria : listaCategorias) {
            jComboBox_Categoria.addItem(categoria);
        }
    }

    public void llenarComboBoxPresentacion(String busqueda) {
        CRUD_Producto gr = new CRUD_Producto();
        ArrayList<Clase_Presentacion> listaPresentaciones = gr.buscarPresentaciones(busqueda);
        jComboBox_Presentacion.removeAllItems();
        for (Clase_Presentacion presentacion : listaPresentaciones) {
            jComboBox_Presentacion.addItem(presentacion);
        }
    }

    public void agregarPresentacionATabla() {
        Clase_Presentacion presentacionSeleccionada = (Clase_Presentacion) jComboBox_Presentacion.getSelectedItem();
        if (presentacionSeleccionada == null) {
            JOptionPane.showMessageDialog(null, "Debe seleccionar una presentación.");
            return;
        }

        DefaultTableModel model = (DefaultTableModel) jTable_Presentacion.getModel();

        model.addRow(new Object[]{
            presentacionSeleccionada.getId_Presentacion(),
            presentacionSeleccionada.getNombre_Presentacion()
        });

        // Limpia el JComboBox y el JTextField después de agregar una presentación a la tabla
        jComboBox_Presentacion.setSelectedIndex(-1);
        jTextField_Buscar_Presentacion.setText("");
    }

    public void agregarProductoATabla() {
        Clase_Categoria productoSeleccionado = (Clase_Categoria) jComboBox_Categoria.getSelectedItem();
        if (productoSeleccionado == null) {
            JOptionPane.showMessageDialog(null, "Debe seleccionar un producto.");
            return;
        }

        DefaultTableModel model = (DefaultTableModel) jTable_Producto1.getModel();

        model.addRow(new Object[]{
            productoSeleccionado.getId_Categoria(),
            productoSeleccionado.getNombre_Categoria()
        });

        // Limpia el JComboBox y el JTextField después de agregar una categoría a la tabla
        jComboBox_Categoria.setSelectedIndex(-1);
        jTextField_Buscar_Categoria.setText("");
    }

    public void agregarCategoriaAlComboBox() {
        String busqueda = jTextField_Buscar_Categoria.getText();
        if (busqueda.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Debe ingresar un texto de búsqueda válido.");
            return;
        }

        CRUD_Producto gr = new CRUD_Producto();
        ArrayList<Clase_Categoria> listaCategorias = gr.mostrarDatosCombo(busqueda);
        jComboBox_Categoria.removeAllItems();
        for (Clase_Categoria categoria : listaCategorias) {
            jComboBox_Categoria.addItem(categoria);
        }
    }

    public byte[] obtenerBytesDesdeImagen(ImageIcon imagenIcono, String formato) {
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

    private int obtenerIdProveedorSeleccionado() {
        DefaultTableModel modelProveedor = (DefaultTableModel) jTable_Proveedor.getModel();
        int rowIndex = jTable_Proveedor.getSelectedRow();
        if (rowIndex != -1) {
            int idProveedor = Integer.parseInt(modelProveedor.getValueAt(rowIndex, 0).toString());
            return idProveedor;
        } else {
            return -1;

        }
    }

    private JInternalFrame_Gestionar_Producto obtenerFormularioGestionarProducto() {
        // Obtener la instancia del formulario JInternalFrame_Gestionar_Producto si ya está abierto
        for (Component component : getParent().getComponents()) {
            if (component instanceof JInternalFrame_Gestionar_Producto) {
                return (JInternalFrame_Gestionar_Producto) component;
            }
        }

        // Si el formulario no está abierto, crear una nueva instancia
        JInternalFrame_Gestionar_Producto formularioGestionarProducto = new JInternalFrame_Gestionar_Producto();

        // Agregar el formulario al contenedor MDIParent (jdpane)
        getParent().add(formularioGestionarProducto);

        // Ubicar el formulario en el centro del contenedor
        int x = (getParent().getWidth() - formularioGestionarProducto.getWidth()) / 2;
        int y = (getParent().getHeight() - formularioGestionarProducto.getHeight()) / 2;
        formularioGestionarProducto.setLocation(x, y);

        return formularioGestionarProducto;
    }

    private Clase_Proveedor obtenerProveedorSeleccionado() {
        int filaSeleccionada = jTable_Proveedor.getSelectedRow();
        if (filaSeleccionada == -1) {
            JOptionPane.showMessageDialog(null, "No se ha seleccionado ningún proveedor.", "Error", JOptionPane.ERROR_MESSAGE);
            return null;
        }

        int idProveedor = Integer.parseInt(jTable_Proveedor.getValueAt(filaSeleccionada, 0).toString());

        Clase_Proveedor proveedor = new Clase_Proveedor();
        proveedor.setId_Proveedor(idProveedor);

        return proveedor;
    }

    private byte[] obtenerBytesDesdeImagen() {
        // Aquí debes implementar la lógica para obtener los bytes de la imagen
        // y retornarlos como un arreglo de bytes (byte[])

        // Por ejemplo:
        File imagenFile = new File("ruta/de/la/imagen.jpg");
        try {
            BufferedImage imagen = ImageIO.read(imagenFile);
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            ImageIO.write(imagen, "jpg", baos);
            return baos.toByteArray();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    private java.sql.Date obtenerFechaCaducidad() {
        // Aquí debes implementar la lógica para obtener la fecha de caducidad
        // y retornarla como un objeto java.sql.Date

        // Por ejemplo:
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String fechaString = "2023-12-31";
        try {
            java.util.Date fechaUtil = dateFormat.parse(fechaString);
            return new java.sql.Date(fechaUtil.getTime());
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;
    }

    private void ajustarAlturaFilasTabla(JTable jTable) {
        jTable.setRowHeight(25); // Ajusta aquí la altura deseada en píxeles
    }

    private void centrarRegistrosTabla(JTable jTable) {
        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(SwingConstants.CENTER);
        jTable.setDefaultRenderer(Object.class, centerRenderer);
    }

    private void personalizarTitulosTabla(JTable jTable) {
        DefaultTableCellRenderer headerRenderer = (DefaultTableCellRenderer) jTable.getTableHeader().getDefaultRenderer();
        headerRenderer.setHorizontalAlignment(SwingConstants.CENTER);
        jTable.getTableHeader().setDefaultRenderer(headerRenderer);
        jTable.getTableHeader().setBackground(new Color(0, 153, 153));
        jTable.getTableHeader().setForeground(Color.WHITE);
        jTable.getTableHeader().setFont(new Font("Segoe UI", Font.BOLD, 14));
        jTable.getTableHeader().setBorder(BorderFactory.createLineBorder(Color.BLACK));
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTextArea2 = new javax.swing.JTextArea();
        jPasswordField1 = new javax.swing.JPasswordField();
        jPanel1 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTextArea_descripcion = new javax.swing.JTextArea();
        jTextField_nombre = new javax.swing.JTextField();
        jSpinner_Cantidad = new javax.swing.JSpinner();
        jTextField_precio_compra = new javax.swing.JTextField();
        jTextField_precio_venta = new javax.swing.JTextField();
        jFormattedTextField_fecha_de_caducidad = new javax.swing.JFormattedTextField();
        jPanel7 = new javax.swing.JPanel();
        jScrollPane5 = new javax.swing.JScrollPane();
        jTable_Categoria = new javax.swing.JTable();
        jComboBox_Categoria = new javax.swing.JComboBox<>();
        jTextField_Buscar_Categoria = new javax.swing.JTextField();
        jButton_Agregar_tabla_Categoria = new javax.swing.JButton();
        jButton_Eliminar_tabla_Categoria = new javax.swing.JButton();
        jButton_Agregar_Categoria = new javax.swing.JButton();
        jPanel9 = new javax.swing.JPanel();
        jScrollPane6 = new javax.swing.JScrollPane();
        jTable_Presentacion = new javax.swing.JTable();
        jComboBox_Presentacion = new javax.swing.JComboBox<>();
        jTextField_Buscar_Presentacion = new javax.swing.JTextField();
        jButton_Agregar_tabla_Presentacion = new javax.swing.JButton();
        jButton_Eliminar_tabla_Presentacion = new javax.swing.JButton();
        jButton_Agregar_Presentacion = new javax.swing.JButton();
        jPanel10 = new javax.swing.JPanel();
        jScrollPane7 = new javax.swing.JScrollPane();
        jTable_Laboratorio = new javax.swing.JTable();
        jComboBox_Laboratorio = new javax.swing.JComboBox<>();
        jTextField_Buscar_Laboratorio = new javax.swing.JTextField();
        jButton_Agregar_tabla_laboratorio = new javax.swing.JButton();
        jButton_Eliminar_tabla_laboratorio = new javax.swing.JButton();
        jButton_Agregar_Laboratorio = new javax.swing.JButton();
        jPanel11 = new javax.swing.JPanel();
        jScrollPane8 = new javax.swing.JScrollPane();
        jTable_Proveedor = new javax.swing.JTable();
        jComboBox_Id_Proveedor = new javax.swing.JComboBox<>();
        jTextField_Buscar_Id_Proveedor = new javax.swing.JTextField();
        jButton_Agregar_tabla_Proveedor = new javax.swing.JButton();
        jButton_Eliminar_tabla_Proveedor = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jButton_buscar_imagen = new javax.swing.JButton();
        jButton_Eliminar_imagen = new javax.swing.JButton();
        jLabel_Mostrar_Imagen = new javax.swing.JLabel();
        jButton_Guardar = new javax.swing.JButton();
        jButton_Ver_Producto = new javax.swing.JButton();
        jButton_Actualizar = new javax.swing.JButton();

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jTextArea1.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        jScrollPane1.setViewportView(jTextArea1);

        jTextArea2.setColumns(20);
        jTextArea2.setRows(5);
        jTextArea2.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        jScrollPane2.setViewportView(jTextArea2);

        jPasswordField1.setText("jPasswordField1");

        setBackground(new java.awt.Color(255, 255, 255));
        setClosable(true);
        setMaximizable(true);
        setResizable(true);
        setName("Producto"); // NOI18N
        setOpaque(true);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jPanel5.setBackground(new java.awt.Color(255, 255, 255));
        jPanel5.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        jPanel5.setOpaque(false);

        jTextArea_descripcion.setColumns(20);
        jTextArea_descripcion.setRows(5);
        jTextArea_descripcion.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Descripción", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 12), new java.awt.Color(0, 153, 153))); // NOI18N
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

        jTextField_nombre.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField_nombre.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Nombre", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 12), new java.awt.Color(0, 153, 153))); // NOI18N
        jTextField_nombre.setPreferredSize(new java.awt.Dimension(64, 45));
        jTextField_nombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField_nombre(evt);
            }
        });

        jSpinner_Cantidad.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Cantidad", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 12), new java.awt.Color(0, 153, 153))); // NOI18N
        jSpinner_Cantidad.addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
                jSpinner_Cantidad(evt);
            }
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
            }
        });

        jTextField_precio_compra.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField_precio_compra.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Precio Compra", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 12), new java.awt.Color(0, 153, 153))); // NOI18N
        jTextField_precio_compra.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField_precio_compra(evt);
            }
        });

        jTextField_precio_venta.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField_precio_venta.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Precio Venta", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 12), new java.awt.Color(0, 153, 153))); // NOI18N
        jTextField_precio_venta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField_precio_venta(evt);
            }
        });

        jFormattedTextField_fecha_de_caducidad.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Fecha Caducidad", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 12), new java.awt.Color(0, 153, 153))); // NOI18N
        jFormattedTextField_fecha_de_caducidad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jFormattedTextField_fecha_de_caducidad(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(0, 15, Short.MAX_VALUE)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTextField_nombre, javax.swing.GroupLayout.PREFERRED_SIZE, 213, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField_precio_compra, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 54, Short.MAX_VALUE)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jSpinner_Cantidad, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField_precio_venta, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(79, 79, 79)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jFormattedTextField_fecha_de_caducidad, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 307, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(91, 91, 91))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jFormattedTextField_fecha_de_caducidad, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextField_precio_venta, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextField_precio_compra, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jSpinner_Cantidad, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jTextField_nombre, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(33, Short.MAX_VALUE))
        );

        jPanel7.setBackground(new java.awt.Color(255, 255, 255));
        jPanel7.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Categoria", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 12))); // NOI18N
        jPanel7.setOpaque(false);

        jTable_Categoria.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jTable_Categoria.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        jTable_Categoria.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "Id_Categoria", "Nombre Categoria"
            }
        ));
        jTable_Categoria.setOpaque(false);
        jTable_Categoria.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable_CategoriaMouseClicked(evt);
            }
        });
        jScrollPane5.setViewportView(jTable_Categoria);

        jComboBox_Categoria.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Categoria", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 12), new java.awt.Color(0, 153, 153))); // NOI18N
        jComboBox_Categoria.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox_Categoria(evt);
            }
        });
        jComboBox_Categoria.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jComboBox_CategoriaKeyReleased(evt);
            }
        });

        jTextField_Buscar_Categoria.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField_Buscar_Categoria.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Buscar", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 12), new java.awt.Color(0, 153, 153))); // NOI18N
        jTextField_Buscar_Categoria.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField_Buscar_Categoria(evt);
            }
        });
        jTextField_Buscar_Categoria.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextField_Buscar_CategoriaKeyPressed(evt);
            }
        });

        jButton_Agregar_tabla_Categoria.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Vistas_Iconos/Mas..png"))); // NOI18N
        jButton_Agregar_tabla_Categoria.setBorderPainted(false);
        jButton_Agregar_tabla_Categoria.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_Agregar_tabla_CategoriaActionPerformed(evt);
            }
        });

        jButton_Eliminar_tabla_Categoria.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Vistas_Iconos/menos.png"))); // NOI18N
        jButton_Eliminar_tabla_Categoria.setBorderPainted(false);
        jButton_Eliminar_tabla_Categoria.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_Eliminar_tabla_CategoriaActionPerformed(evt);
            }
        });

        jButton_Agregar_Categoria.setBackground(new java.awt.Color(0, 153, 153));
        jButton_Agregar_Categoria.setFont(new java.awt.Font("Dialog", 1, 11)); // NOI18N
        jButton_Agregar_Categoria.setForeground(new java.awt.Color(255, 255, 255));
        jButton_Agregar_Categoria.setText("Nueva Categoria");
        jButton_Agregar_Categoria.setBorder(javax.swing.BorderFactory.createEtchedBorder(javax.swing.border.EtchedBorder.RAISED));
        jButton_Agregar_Categoria.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_Agregar_Categoria(evt);
            }
        });

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addComponent(jTextField_Buscar_Categoria)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jComboBox_Categoria, javax.swing.GroupLayout.PREFERRED_SIZE, 231, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 288, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel7Layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(jButton_Agregar_tabla_Categoria, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jButton_Eliminar_tabla_Categoria))
                            .addGroup(jPanel7Layout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addComponent(jButton_Agregar_Categoria, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 16, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField_Buscar_Categoria, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboBox_Categoria, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButton_Agregar_tabla_Categoria)
                            .addComponent(jButton_Eliminar_tabla_Categoria))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton_Agregar_Categoria, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(35, 35, 35))
        );

        jPanel9.setBackground(new java.awt.Color(255, 255, 255));
        jPanel9.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Presentacion", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 12))); // NOI18N
        jPanel9.setOpaque(false);

        jTable_Presentacion.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        jTable_Presentacion.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "Id_Presentacion", "Nombre Presentacion"
            }
        ));
        jTable_Presentacion.addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
                jTable_Presentacion(evt);
            }
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
            }
        });
        jTable_Presentacion.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable_PresentacionMouseClicked(evt);
            }
        });
        jScrollPane6.setViewportView(jTable_Presentacion);

        jComboBox_Presentacion.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Presentacion", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 12), new java.awt.Color(0, 153, 153))); // NOI18N
        jComboBox_Presentacion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox_Presentacion(evt);
            }
        });

        jTextField_Buscar_Presentacion.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField_Buscar_Presentacion.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Buscar", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 12), new java.awt.Color(0, 153, 153))); // NOI18N
        jTextField_Buscar_Presentacion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField_Buscar_Presentacion(evt);
            }
        });

        jButton_Agregar_tabla_Presentacion.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Vistas_Iconos/Mas..png"))); // NOI18N
        jButton_Agregar_tabla_Presentacion.setBorderPainted(false);
        jButton_Agregar_tabla_Presentacion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_Agregar_tabla_PresentacionActionPerformed(evt);
            }
        });

        jButton_Eliminar_tabla_Presentacion.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Vistas_Iconos/menos.png"))); // NOI18N
        jButton_Eliminar_tabla_Presentacion.setBorderPainted(false);
        jButton_Eliminar_tabla_Presentacion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_Eliminar_tabla_PresentacionActionPerformed(evt);
            }
        });

        jButton_Agregar_Presentacion.setBackground(new java.awt.Color(0, 153, 153));
        jButton_Agregar_Presentacion.setFont(new java.awt.Font("Dialog", 1, 11)); // NOI18N
        jButton_Agregar_Presentacion.setForeground(new java.awt.Color(255, 255, 255));
        jButton_Agregar_Presentacion.setText("Nueva");
        jButton_Agregar_Presentacion.setBorder(javax.swing.BorderFactory.createEtchedBorder(javax.swing.border.EtchedBorder.RAISED));
        jButton_Agregar_Presentacion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_Agregar_Presentacion(evt);
            }
        });

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addComponent(jTextField_Buscar_Presentacion, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(39, 39, 39)
                        .addComponent(jComboBox_Presentacion, javax.swing.GroupLayout.PREFERRED_SIZE, 183, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel9Layout.createSequentialGroup()
                                .addComponent(jButton_Agregar_tabla_Presentacion)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jButton_Eliminar_tabla_Presentacion)
                                .addGap(27, 27, 27))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel9Layout.createSequentialGroup()
                                .addComponent(jButton_Agregar_Presentacion, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap())))))
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jComboBox_Presentacion, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField_Buscar_Presentacion, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButton_Agregar_tabla_Presentacion)
                            .addComponent(jButton_Eliminar_tabla_Presentacion))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton_Agregar_Presentacion, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))))
        );

        jPanel10.setBackground(new java.awt.Color(255, 255, 255));
        jPanel10.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Laboratorio", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 12))); // NOI18N
        jPanel10.setOpaque(false);

        jTable_Laboratorio.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        jTable_Laboratorio.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "Id_Laboratorio", "Nombre Laboratorio"
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

        jComboBox_Laboratorio.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Laboratorio", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 12), new java.awt.Color(0, 153, 153))); // NOI18N
        jComboBox_Laboratorio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox_Laboratorio(evt);
            }
        });

        jTextField_Buscar_Laboratorio.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField_Buscar_Laboratorio.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Buscar", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 12), new java.awt.Color(0, 153, 153))); // NOI18N
        jTextField_Buscar_Laboratorio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField_Buscar_Laboratorio(evt);
            }
        });

        jButton_Agregar_tabla_laboratorio.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Vistas_Iconos/Mas..png"))); // NOI18N
        jButton_Agregar_tabla_laboratorio.setBorderPainted(false);
        jButton_Agregar_tabla_laboratorio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_Agregar_tabla_laboratorioActionPerformed(evt);
            }
        });

        jButton_Eliminar_tabla_laboratorio.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Vistas_Iconos/menos.png"))); // NOI18N
        jButton_Eliminar_tabla_laboratorio.setBorderPainted(false);
        jButton_Eliminar_tabla_laboratorio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_Eliminar_tabla_laboratorioActionPerformed(evt);
            }
        });

        jButton_Agregar_Laboratorio.setBackground(new java.awt.Color(0, 153, 153));
        jButton_Agregar_Laboratorio.setFont(new java.awt.Font("Dialog", 1, 11)); // NOI18N
        jButton_Agregar_Laboratorio.setForeground(new java.awt.Color(255, 255, 255));
        jButton_Agregar_Laboratorio.setText("Nuevo");
        jButton_Agregar_Laboratorio.setBorder(javax.swing.BorderFactory.createEtchedBorder(javax.swing.border.EtchedBorder.RAISED));
        jButton_Agregar_Laboratorio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_Agregar_Laboratorio(evt);
            }
        });

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel10Layout.createSequentialGroup()
                        .addComponent(jTextField_Buscar_Laboratorio)
                        .addGap(18, 18, 18)
                        .addComponent(jComboBox_Laboratorio, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10))
                    .addGroup(jPanel10Layout.createSequentialGroup()
                        .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 265, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel10Layout.createSequentialGroup()
                                .addGap(0, 39, Short.MAX_VALUE)
                                .addComponent(jButton_Agregar_Laboratorio, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel10Layout.createSequentialGroup()
                                .addComponent(jButton_Agregar_tabla_laboratorio)
                                .addGap(28, 28, 28)
                                .addComponent(jButton_Eliminar_tabla_laboratorio)
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addGap(6, 6, 6))))
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jComboBox_Laboratorio, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField_Buscar_Laboratorio, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addGroup(jPanel10Layout.createSequentialGroup()
                        .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButton_Agregar_tabla_laboratorio)
                            .addComponent(jButton_Eliminar_tabla_laboratorio))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton_Agregar_Laboratorio, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );

        jPanel11.setBackground(new java.awt.Color(255, 255, 255));
        jPanel11.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Proveedor", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 12))); // NOI18N
        jPanel11.setForeground(new java.awt.Color(0, 153, 153));
        jPanel11.setOpaque(false);

        jTable_Proveedor.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        jTable_Proveedor.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Id_Proveedor", "Nombre_1", "Apellido_1"
            }
        ));
        jTable_Proveedor.addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
                jTable_Proveedor(evt);
            }
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
            }
        });
        jTable_Proveedor.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable_ProveedorMouseClicked(evt);
            }
        });
        jScrollPane8.setViewportView(jTable_Proveedor);

        jComboBox_Id_Proveedor.setForeground(new java.awt.Color(0, 153, 153));
        jComboBox_Id_Proveedor.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Proveedor", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 12), new java.awt.Color(0, 153, 153))); // NOI18N
        jComboBox_Id_Proveedor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox_Id_Proveedor(evt);
            }
        });

        jTextField_Buscar_Id_Proveedor.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField_Buscar_Id_Proveedor.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Buscar", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 12), new java.awt.Color(0, 153, 153))); // NOI18N
        jTextField_Buscar_Id_Proveedor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField_Buscar_Id_Proveedor(evt);
            }
        });

        jButton_Agregar_tabla_Proveedor.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Vistas_Iconos/Mas..png"))); // NOI18N
        jButton_Agregar_tabla_Proveedor.setBorderPainted(false);
        jButton_Agregar_tabla_Proveedor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_Agregar_tabla_ProveedorActionPerformed(evt);
            }
        });

        jButton_Eliminar_tabla_Proveedor.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Vistas_Iconos/menos.png"))); // NOI18N
        jButton_Eliminar_tabla_Proveedor.setBorderPainted(false);
        jButton_Eliminar_tabla_Proveedor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_Eliminar_tabla_ProveedorActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel11Layout = new javax.swing.GroupLayout(jPanel11);
        jPanel11.setLayout(jPanel11Layout);
        jPanel11Layout.setHorizontalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel11Layout.createSequentialGroup()
                        .addComponent(jTextField_Buscar_Id_Proveedor, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jComboBox_Id_Proveedor, 0, 266, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(jPanel11Layout.createSequentialGroup()
                        .addComponent(jScrollPane8, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                        .addGap(18, 18, 18)
                        .addComponent(jButton_Agregar_tabla_Proveedor)
                        .addGap(37, 37, 37)
                        .addComponent(jButton_Eliminar_tabla_Proveedor)
                        .addGap(42, 42, 42))))
        );
        jPanel11Layout.setVerticalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField_Buscar_Id_Proveedor, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboBox_Id_Proveedor, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel11Layout.createSequentialGroup()
                        .addGap(32, 32, 32)
                        .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jButton_Eliminar_tabla_Proveedor)
                            .addComponent(jButton_Agregar_tabla_Proveedor))
                        .addContainerGap(44, Short.MAX_VALUE))
                    .addGroup(jPanel11Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane8, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                        .addContainerGap())))
        );

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        jButton_buscar_imagen.setText("Agregar");
        jButton_buscar_imagen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_buscar_imagen(evt);
            }
        });

        jButton_Eliminar_imagen.setText("Eliminar");
        jButton_Eliminar_imagen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_Eliminar_imagen(evt);
            }
        });

        jLabel_Mostrar_Imagen.setForeground(new java.awt.Color(0, 153, 153));
        jLabel_Mostrar_Imagen.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Foto", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 12))); // NOI18N
        jLabel_Mostrar_Imagen.addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
                jLabel_Mostrar_Imagen(evt);
            }
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jButton_buscar_imagen)
                .addGap(51, 51, 51)
                .addComponent(jButton_Eliminar_imagen)
                .addContainerGap(19, Short.MAX_VALUE))
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel_Mostrar_Imagen, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addComponent(jLabel_Mostrar_Imagen, javax.swing.GroupLayout.DEFAULT_SIZE, 185, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton_buscar_imagen)
                    .addComponent(jButton_Eliminar_imagen))
                .addContainerGap())
        );

        jButton_Guardar.setBackground(new java.awt.Color(0, 204, 204));
        jButton_Guardar.setFont(new java.awt.Font("Dialog", 1, 11)); // NOI18N
        jButton_Guardar.setText("Agregar");
        jButton_Guardar.setBorder(javax.swing.BorderFactory.createEtchedBorder(javax.swing.border.EtchedBorder.RAISED));
        jButton_Guardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_Guardar(evt);
            }
        });

        jButton_Ver_Producto.setBackground(new java.awt.Color(153, 153, 255));
        jButton_Ver_Producto.setFont(new java.awt.Font("Dialog", 1, 11)); // NOI18N
        jButton_Ver_Producto.setText("Ver Productos ");
        jButton_Ver_Producto.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jButton_Ver_Producto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_Ver_Producto(evt);
            }
        });

        jButton_Actualizar.setBackground(new java.awt.Color(153, 153, 255));
        jButton_Actualizar.setFont(new java.awt.Font("Dialog", 1, 11)); // NOI18N
        jButton_Actualizar.setText("Actualizar");
        jButton_Actualizar.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jButton_Actualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_Actualizar(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addComponent(jButton_Guardar, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(26, 26, 26)
                        .addComponent(jButton_Actualizar, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(68, 68, 68)
                        .addComponent(jButton_Ver_Producto)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 20, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel5, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jPanel11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jPanel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap(20, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(10, 10, 10))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(32, 32, 32)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton_Guardar, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton_Actualizar, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jButton_Ver_Producto, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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

    private void jButton_buscar_imagen(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_buscar_imagen
        JFileChooser j = new JFileChooser();
        FileNameExtensionFilter fil = new FileNameExtensionFilter("JPG, PNG & GIF", "jpg", "png", "gif");
        j.setFileFilter(fil);

        int s = j.showOpenDialog(this);
        if (s == JFileChooser.APPROVE_OPTION) {
            String ruta = j.getSelectedFile().getAbsolutePath();

            ImageIcon imagenIcono = new ImageIcon(ruta);

            ImageIcon imagenRedimensionada = redimensionarImagen(imagenIcono, 200, 200);
            jLabel_Mostrar_Imagen.setIcon(imagenRedimensionada);

            imagenGuardada = redimensionarImagen(imagenIcono, 64, 64);
        }


    }//GEN-LAST:event_jButton_buscar_imagen

    private void jTextField_nombre(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField_nombre
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField_nombre

    private void jTextArea_descripcion(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_jTextArea_descripcion
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextArea_descripcion

    private void jTextField_precio_compra(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField_precio_compra

        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField_precio_compra

    private void jTextField_precio_venta(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField_precio_venta

        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField_precio_venta

    private void jButton_Guardar(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_Guardar
        // Obtener los índices seleccionados de las tablas
        int selectedCategoriaIndex = jTable_Categoria.getSelectedRow();
        int selectedLaboratorioIndex = jTable_Laboratorio.getSelectedRow();
        int selectedPresentacionIndex = jTable_Presentacion.getSelectedRow();
        int selectedProveedorIndex = jTable_Proveedor.getSelectedRow();

        // Verificar que se haya seleccionado una fila en cada tabla
        if (selectedCategoriaIndex == -1 || selectedLaboratorioIndex == -1
                || selectedPresentacionIndex == -1 || selectedProveedorIndex == -1) {
            JOptionPane.showMessageDialog(this, "Debe seleccionar un valor de cada tabla.",
                    "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        // Obtener los valores seleccionados de las tablas
        int idCategoria = (int) jTable_Categoria.getValueAt(selectedCategoriaIndex, 0);
        int idLaboratorio = (int) jTable_Laboratorio.getValueAt(selectedLaboratorioIndex, 0);
        int idPresentacion = (int) jTable_Presentacion.getValueAt(selectedPresentacionIndex, 0);
        int idProveedor = (int) jTable_Proveedor.getValueAt(selectedProveedorIndex, 0);

        // Crear el objeto Clase_Producto con los datos del formulario y las selecciones de las tablas
        Clase_Producto producto = new Clase_Producto();
        producto.setNombre(jTextField_nombre.getText());
        producto.setDescripcion(jTextArea_descripcion.getText());
        producto.setCantidad_Producto((int) jSpinner_Cantidad.getValue());
        producto.setPrecio_Compra(Float.parseFloat(jTextField_precio_compra.getText()));
        producto.setPrecio_Venta(Float.parseFloat(jTextField_precio_venta.getText()));
        producto.setImagen_Producto(obtenerBytesDesdeImagen()); // Obtener bytes de la imagen
        producto.setFecha_Caducidad(obtenerFechaCaducidad()); // Obtener fecha de caducidad
        producto.setId_Categoria(idCategoria);
        producto.setId_Presentacion(idPresentacion);
        producto.setId_Laboratorio(idLaboratorio);
        producto.setId_Proveedor(idProveedor);

        // Llamar al método insertarProductoConProveedor para guardar el producto
        CRUD_Producto crudProducto = new CRUD_Producto();
        crudProducto.insertarProductoConProveedor(producto);

        // Mostrar mensaje de éxito
        JOptionPane.showMessageDialog(this, "Producto insertado correctamente.",
                "Éxito", JOptionPane.INFORMATION_MESSAGE);

        this.dispose();

        // Mostrar el formulario JInternalFrame_Gestionar_Producto
        JInternalFrame_Gestionar_Producto gestionarProducto = new JInternalFrame_Gestionar_Producto();
        gestionarProducto.setVisible(true);
        getParent().add(gestionarProducto);
        try {
            gestionarProducto.setSelected(true);
        } catch (java.beans.PropertyVetoException e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_jButton_Guardar

    private void jButton_Actualizar(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_Actualizar
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton_Actualizar

    private void jLabel_Mostrar_Imagen(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_jLabel_Mostrar_Imagen
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel_Mostrar_Imagen

    private void jTable_CategoriaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable_CategoriaMouseClicked

    }//GEN-LAST:event_jTable_CategoriaMouseClicked

    private void jTable_PresentacionMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable_PresentacionMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jTable_PresentacionMouseClicked

    private void jTable_LaboratorioMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable_LaboratorioMouseClicked

    }//GEN-LAST:event_jTable_LaboratorioMouseClicked

    private void jTable_Presentacion(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_jTable_Presentacion

    }//GEN-LAST:event_jTable_Presentacion

    private void jComboBox_Presentacion(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox_Presentacion

    }//GEN-LAST:event_jComboBox_Presentacion

    private void jComboBox_Laboratorio(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox_Laboratorio

    }//GEN-LAST:event_jComboBox_Laboratorio

    private void jTable_Laboratorio(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_jTable_Laboratorio
        // TODO add your handling code here:
    }//GEN-LAST:event_jTable_Laboratorio

    private void jSpinner_Cantidad(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_jSpinner_Cantidad
        // TODO add your handling code here:
    }//GEN-LAST:event_jSpinner_Cantidad

    private void jTextField_Buscar_Presentacion(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField_Buscar_Presentacion
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField_Buscar_Presentacion

    private void jTextField_Buscar_Categoria(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField_Buscar_Categoria


    }//GEN-LAST:event_jTextField_Buscar_Categoria

    private void jTextField_Buscar_Laboratorio(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField_Buscar_Laboratorio
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField_Buscar_Laboratorio

    private void jButton_Eliminar_imagen(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_Eliminar_imagen

        jLabel_Mostrar_Imagen.setIcon(null);
        imagenIcono = null;
        iconoRedimensionado = null;
    }//GEN-LAST:event_jButton_Eliminar_imagen

    private void jTable_Proveedor(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_jTable_Proveedor
        // TODO add your handling code here:
    }//GEN-LAST:event_jTable_Proveedor

    private void jTable_ProveedorMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable_ProveedorMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jTable_ProveedorMouseClicked

    private void jComboBox_Id_Proveedor(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox_Id_Proveedor
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBox_Id_Proveedor

    private void jTextField_Buscar_Id_Proveedor(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField_Buscar_Id_Proveedor

    }//GEN-LAST:event_jTextField_Buscar_Id_Proveedor

    private void jButton_Eliminar_tabla_CategoriaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_Eliminar_tabla_CategoriaActionPerformed
        jButton_Agregar_tabla_Categoria.setEnabled(true);
        DefaultTableModel model = (DefaultTableModel) jTable_Categoria.getModel();
        if (model.getRowCount() > 0) {
            model.removeRow(0);
        }
    }//GEN-LAST:event_jButton_Eliminar_tabla_CategoriaActionPerformed

    private void jButton_Eliminar_tabla_PresentacionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_Eliminar_tabla_PresentacionActionPerformed

    }//GEN-LAST:event_jButton_Eliminar_tabla_PresentacionActionPerformed

    private void jButton_Eliminar_tabla_ProveedorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_Eliminar_tabla_ProveedorActionPerformed

    }//GEN-LAST:event_jButton_Eliminar_tabla_ProveedorActionPerformed

    private void jButton_Eliminar_tabla_laboratorioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_Eliminar_tabla_laboratorioActionPerformed

    }//GEN-LAST:event_jButton_Eliminar_tabla_laboratorioActionPerformed

    private void jComboBox_Categoria(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox_Categoria

    }//GEN-LAST:event_jComboBox_Categoria

    private void jButton_Agregar_tabla_CategoriaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_Agregar_tabla_CategoriaActionPerformed
        Clase_Categoria productoSeleccionado = (Clase_Categoria) jComboBox_Categoria.getSelectedItem();
        if (productoSeleccionado == null) {
            JOptionPane.showMessageDialog(null, "Debe seleccionar un producto.");
            return;
        }

        DefaultTableModel model = (DefaultTableModel) jTable_Categoria.getModel();

        model.insertRow(0, new Object[]{
            productoSeleccionado.getId_Categoria(),
            productoSeleccionado.getNombre_Categoria()
        });

        jComboBox_Categoria.setSelectedIndex(-1);
    }//GEN-LAST:event_jButton_Agregar_tabla_CategoriaActionPerformed

    private void jTextField_Buscar_CategoriaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField_Buscar_CategoriaKeyPressed

    }//GEN-LAST:event_jTextField_Buscar_CategoriaKeyPressed

    private void jComboBox_CategoriaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jComboBox_CategoriaKeyReleased
        String busqueda = jTextField_Buscar_Categoria.getText();
        CRUD_Producto gr = new CRUD_Producto();
        ArrayList<Clase_Categoria> listaProductos = gr.mostrarDatosCombo(busqueda);
        jComboBox_Categoria.removeAllItems();
        for (Clase_Categoria producto : listaProductos) {
            jComboBox_Categoria.addItem(producto);
        }
    }//GEN-LAST:event_jComboBox_CategoriaKeyReleased

    private void jButton_Agregar_tabla_laboratorioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_Agregar_tabla_laboratorioActionPerformed
        Clase_Laboratorio laboratorioSeleccionado = (Clase_Laboratorio) jComboBox_Laboratorio.getSelectedItem();
        if (laboratorioSeleccionado == null) {
            JOptionPane.showMessageDialog(null, "Debe seleccionar un laboratorio.");
            return;
        }

        DefaultTableModel model = (DefaultTableModel) jTable_Laboratorio.getModel();

        model.insertRow(0, new Object[]{
            laboratorioSeleccionado.getId_Laboratorio(),
            laboratorioSeleccionado.getNombre()
        });

        jComboBox_Laboratorio.setSelectedIndex(-1);
    }//GEN-LAST:event_jButton_Agregar_tabla_laboratorioActionPerformed

    private void jButton_Agregar_tabla_PresentacionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_Agregar_tabla_PresentacionActionPerformed
        Clase_Presentacion presentacionSeleccionada = (Clase_Presentacion) jComboBox_Presentacion.getSelectedItem();
        if (presentacionSeleccionada == null) {
            JOptionPane.showMessageDialog(null, "Debe seleccionar una presentación.");
            return;
        }

        DefaultTableModel model = (DefaultTableModel) jTable_Presentacion.getModel();

        model.insertRow(0, new Object[]{
            presentacionSeleccionada.getId_Presentacion(),
            presentacionSeleccionada.getNombre_Presentacion()
        });

        jComboBox_Presentacion.setSelectedIndex(-1);
    }//GEN-LAST:event_jButton_Agregar_tabla_PresentacionActionPerformed

    private void jButton_Agregar_tabla_ProveedorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_Agregar_tabla_ProveedorActionPerformed
        agregarProveedorATabla();

    }//GEN-LAST:event_jButton_Agregar_tabla_ProveedorActionPerformed

    private void jButton_Ver_Producto(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_Ver_Producto
        // Cierra este JInternalFrame_Producto
        this.dispose();

        // Abre el JInternalFrame_Gestionar_Producto
        JInternalFrame_Gestionar_Producto gestionarProducto = new JInternalFrame_Gestionar_Producto();
        gestionarProducto.setSize(1200, 666);
        gestionarProducto.setLocation(0, 0);
        gestionarProducto.setVisible(true);

        // Aquí necesitarías agregar el nuevo JInternalFrame a tu JDesktopPane
        jDesktopPane.removeAll();
        jDesktopPane.add(gestionarProducto);
        try {
            gestionarProducto.setSelected(true);
        } catch (java.beans.PropertyVetoException e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_jButton_Ver_Producto

    private void jFormattedTextField_fecha_de_caducidad(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jFormattedTextField_fecha_de_caducidad

        // TODO add your handling code here:
    }//GEN-LAST:event_jFormattedTextField_fecha_de_caducidad

    private void jButton_Agregar_Laboratorio(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_Agregar_Laboratorio
        // Crear una nueva instancia de JInternalFrame_Laboratorio
        JInternalFrame_Laboratorio internalFrame_Laboratorio = new JInternalFrame_Laboratorio();

        // Calcular las coordenadas para centrar el JInternalFrame
        int x = (jDesktopPane.getWidth() - internalFrame_Laboratorio.getWidth()) / 2;
        int y = (jDesktopPane.getHeight() - internalFrame_Laboratorio.getHeight()) / 2;

        // Configurar la posición del JInternalFrame
        internalFrame_Laboratorio.setLocation(x, y);

        // Agregar la instancia al jDesktopPane
        jDesktopPane.add(internalFrame_Laboratorio);

        // Hacer la instancia visible
        internalFrame_Laboratorio.setVisible(true);

        try {
            // Traer al frente en el jDesktopPane
            internalFrame_Laboratorio.setSelected(true);
        } catch (java.beans.PropertyVetoException e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_jButton_Agregar_Laboratorio

    private void jButton_Agregar_Categoria(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_Agregar_Categoria
        JInternalFrame_Categoria internalFrame_categoria = new JInternalFrame_Categoria();

        // Calcular las coordenadas para centrar el JInternalFrame
        int x = (jDesktopPane.getWidth() - internalFrame_categoria.getWidth()) / 2;
        int y = (jDesktopPane.getHeight() - internalFrame_categoria.getHeight()) / 2;

        // Configurar la posición del JInternalFrame
        internalFrame_categoria.setLocation(x, y);

        // Agregar la instancia al jDesktopPane
        jDesktopPane.add(internalFrame_categoria);

        // Hacer la instancia visible
        internalFrame_categoria.setVisible(true);

        try {
            // Traer al frente en el jDesktopPane
            internalFrame_categoria.setSelected(true);
        } catch (java.beans.PropertyVetoException e) {
            e.printStackTrace();
        }

    }//GEN-LAST:event_jButton_Agregar_Categoria

    private void jButton_Agregar_Presentacion(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_Agregar_Presentacion
        JInternalFrame_Presentacion internalFrame_presentacion = new JInternalFrame_Presentacion();

        // Calcular las coordenadas para centrar el JInternalFrame
        int x = (jDesktopPane.getWidth() - internalFrame_presentacion.getWidth()) / 2;
        int y = (jDesktopPane.getHeight() - internalFrame_presentacion.getHeight()) / 2;

        // Configurar la posición del JInternalFrame
        internalFrame_presentacion.setLocation(x, y);

        // Agregar la instancia al jDesktopPane
        jDesktopPane.add(internalFrame_presentacion);

        // Hacer la instancia visible
        internalFrame_presentacion.setVisible(true);

        try {
            // Traer al frente en el jDesktopPane
            internalFrame_presentacion.setSelected(true);
        } catch (java.beans.PropertyVetoException e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_jButton_Agregar_Presentacion


    // Variables declaration - do not modify//GEN-BEGIN:variables
    public static javax.swing.JButton jButton_Actualizar;
    private javax.swing.JButton jButton_Agregar_Categoria;
    private javax.swing.JButton jButton_Agregar_Laboratorio;
    private javax.swing.JButton jButton_Agregar_Presentacion;
    private javax.swing.JButton jButton_Agregar_tabla_Categoria;
    private javax.swing.JButton jButton_Agregar_tabla_Presentacion;
    private javax.swing.JButton jButton_Agregar_tabla_Proveedor;
    private javax.swing.JButton jButton_Agregar_tabla_laboratorio;
    private javax.swing.JButton jButton_Eliminar_imagen;
    private javax.swing.JButton jButton_Eliminar_tabla_Categoria;
    private javax.swing.JButton jButton_Eliminar_tabla_Presentacion;
    private javax.swing.JButton jButton_Eliminar_tabla_Proveedor;
    private javax.swing.JButton jButton_Eliminar_tabla_laboratorio;
    public static javax.swing.JButton jButton_Guardar;
    public static javax.swing.JButton jButton_Ver_Producto;
    private javax.swing.JButton jButton_buscar_imagen;
    private javax.swing.JComboBox<Clase_Categoria> jComboBox_Categoria;
    private javax.swing.JComboBox<Clase_Proveedor> jComboBox_Id_Proveedor;
    private javax.swing.JComboBox<Clase_Laboratorio> jComboBox_Laboratorio;
    private javax.swing.JComboBox<Clase_Presentacion> jComboBox_Presentacion;
    private javax.swing.JFormattedTextField jFormattedTextField_fecha_de_caducidad;
    private javax.swing.JLabel jLabel_Mostrar_Imagen;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JPasswordField jPasswordField1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JScrollPane jScrollPane8;
    private javax.swing.JSpinner jSpinner_Cantidad;
    private javax.swing.JTable jTable_Categoria;
    private javax.swing.JTable jTable_Laboratorio;
    private javax.swing.JTable jTable_Presentacion;
    private javax.swing.JTable jTable_Proveedor;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JTextArea jTextArea2;
    private javax.swing.JTextArea jTextArea_descripcion;
    private javax.swing.JTextField jTextField_Buscar_Categoria;
    private javax.swing.JTextField jTextField_Buscar_Id_Proveedor;
    private javax.swing.JTextField jTextField_Buscar_Laboratorio;
    private javax.swing.JTextField jTextField_Buscar_Presentacion;
    private javax.swing.JTextField jTextField_nombre;
    private javax.swing.JTextField jTextField_precio_compra;
    private javax.swing.JTextField jTextField_precio_venta;
    // End of variables declaration//GEN-END:variables

}
