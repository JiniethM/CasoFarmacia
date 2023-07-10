package Vistas;

import Modelo.Clase_Empleado;
import Controlador_Conexion_DB.Conexion;
import Controlador.*;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.HeadlessException;
import java.awt.event.KeyEvent;
import java.sql.Time;
import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.border.Border;
import java.sql.Connection;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import java.math.BigDecimal;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;

/**
 *
 * @author diedr
 */
public class JInternalFrame_Empleado extends javax.swing.JInternalFrame {

    private JPanel panel;
    public final Conexion con = new Conexion();
    public final Connection cn = (Connection) con.conectar();

    public JInternalFrame_Empleado() {
 
        setTitle("Empleado");
       

  

        initComponents();
         centrarRegistrosTabla();
        personalizarTitulosTabla();
        ajustarAlturaFilasTabla();

    
        jTextIdEmpleado.setEditable(false);
    }
     

    private void centrarRegistrosTabla() {
        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(SwingConstants.CENTER);
        jTable_Empleado.setDefaultRenderer(Object.class, centerRenderer);
    }

    private void personalizarTitulosTabla() {
        DefaultTableCellRenderer headerRenderer = (DefaultTableCellRenderer) jTable_Empleado.getTableHeader().getDefaultRenderer();
        headerRenderer.setHorizontalAlignment(SwingConstants.CENTER);
        jTable_Empleado.getTableHeader().setDefaultRenderer(headerRenderer);
        jTable_Empleado.getTableHeader().setBackground(new Color(0, 153, 153));
        jTable_Empleado.getTableHeader().setForeground(Color.WHITE);
        jTable_Empleado.getTableHeader().setFont(new Font("Segoe UI", Font.BOLD, 14));
        jTable_Empleado.getTableHeader().setBorder(BorderFactory.createLineBorder(Color.BLACK));
    }

    private void ajustarAlturaFilasTabla() {
        jTable_Empleado.setRowHeight(30); // Ajusta aquí la altura deseada en píxeles
    }

    public void limpiar() {
        jTextIdEmpleado.setText("");
        jText_Cedula.setText("");
        jText_Salario.setText("");
        jTextNombre1.setText("");
        jTextNombre2.setText("");
        jTextApellido1.setText("");
        jTextApellido2.setText("");
        jFormattedTextField_Telefono.setText("");
        jTextGmail.setText("");
        jTextADirecion.setText("");
        jTexthoraentra.setText("");
        jTexthorasal.setText("");
    }

    public void guardarEmpleado() {
        CRUD_Empleado cl = new CRUD_Empleado();
        String Cedula = jText_Cedula.getText();
        String Nombre1 = jTextNombre1.getText();
        String Nombre2 = jTextNombre2.getText();
        String Apellido1 = jTextApellido1.getText();
        String Apellido2 = jTextApellido2.getText();
        String salarioStr = jText_Salario.getText();
        String NumeroCelular = jFormattedTextField_Telefono.getText();
        String gmail = jTextGmail.getText();
        String direccion = jTextADirecion.getText();
        String horaEntradaStr = jTexthoraentra.getText();
        String horaSalidaStr = jTexthorasal.getText();

        // Verificar que los campos no estén vacíos
        if (Cedula.isEmpty() || Nombre1.isEmpty() || salarioStr.isEmpty() || horaEntradaStr.isEmpty() || horaSalidaStr.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Tiene datos vacíos");
            return;
        }

        try {
            // Convertir las variables String a BigDecimal y Time
            BigDecimal salarioValue = new BigDecimal(salarioStr);
            Time horaEntrada = Time.valueOf(horaEntradaStr);
            Time horaSalida = Time.valueOf(horaSalidaStr);

            // Crear objeto Clase_Empleado con los datos obtenidos
            Clase_Empleado empleado = new Clase_Empleado(salarioValue, horaEntrada, horaSalida, Cedula, Nombre1, Nombre2, Apellido1, Apellido2, NumeroCelular, gmail, direccion);

            cl.Guardar(empleado);

            mostrar();
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Error: Formato de número incorrecto");
        } catch (IllegalArgumentException e) {
            JOptionPane.showMessageDialog(null, "Error: Formato de hora incorrecto");
        }
    }

    public void mostrar() {
        try {
            DefaultTableModel modelo;
            CRUD_Empleado Empleado = new CRUD_Empleado();
            modelo = Empleado.mostrarDatos();
            jTable_Empleado.setModel(modelo);

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }

    public void editarCliente() {
    CRUD_Empleado cc = new CRUD_Empleado();

    String salarioStr = jText_Salario.getText().replace(',', '.'); // Reemplazar coma por punto para formato decimal

    if (salarioStr.isEmpty()) {
        JOptionPane.showMessageDialog(null, "El campo de salario está vacío.");
        return; // Salir del método si el campo está vacío
    }

    BigDecimal salario;

    try {
        salario = new BigDecimal(salarioStr);
    } catch (NumberFormatException e) {
        JOptionPane.showMessageDialog(null, "El campo de salario contiene un valor inválido.");
        return; // Salir del método si el valor no es numérico
    }

    String horaEntradaStr = jTexthoraentra.getText();
    String horaSalidaStr = jTexthorasal.getText();

    // Verificar que los campos de hora no estén vacíos
    if (horaEntradaStr.isEmpty() || horaSalidaStr.isEmpty()) {
        JOptionPane.showMessageDialog(null, "Los campos de hora están vacíos.");
        return; // Salir del método si alguno de los campos de hora está vacío
    }

    Time horaEntrada;
    Time horaSalida;

    try {
        horaEntrada = Time.valueOf(horaEntradaStr);
        horaSalida = Time.valueOf(horaSalidaStr);
    } catch (IllegalArgumentException e) {
        JOptionPane.showMessageDialog(null, "Formato de hora incorrecto.");
        return; // Salir del método si el formato de hora es incorrecto
    }

    Clase_Empleado cl = new Clase_Empleado(
            salario,
            horaEntrada,
            horaSalida,
            jText_Cedula.getText(),
            jTextNombre1.getText(),
            jTextNombre2.getText(),
            jTextApellido1.getText(),
            jTextApellido2.getText(),
            jFormattedTextField_Telefono.getText(),
            jTextGmail.getText(),
            jTextADirecion.getText()
    );

    cc.actualizar(cl);
}


    public void BuscarEmpleado() {
        try {
            DefaultTableModel modelo;
            CRUD_Empleado cli = new CRUD_Empleado();
            modelo = cli.buscarDatos(jTextBuscar.getText());

            if (modelo != null) {
                jTable_Empleado.setModel(modelo);
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

        jPanel9 = new javax.swing.JPanel();
        jLabel13 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jTextIdEmpleado = new javax.swing.JTextField();
        jTextBuscar = new javax.swing.JTextField();
        jPanel5 = new javax.swing.JPanel();
        jTextNombre1 = new javax.swing.JTextField();
        jTextNombre2 = new javax.swing.JTextField();
        jTextApellido1 = new javax.swing.JTextField();
        jTextApellido2 = new javax.swing.JTextField();
        jPanel6 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextADirecion = new javax.swing.JTextArea();
        jTextGmail = new javax.swing.JTextField();
        jFormattedTextField_Telefono = new javax.swing.JFormattedTextField();
        jPanel3 = new javax.swing.JPanel();
        jTexthoraentra = new javax.swing.JTextField();
        jTexthorasal = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable_Empleado = new javax.swing.JTable();
        jButton6 = new javax.swing.JButton();
        Editar = new javax.swing.JButton();
        Actualizar = new javax.swing.JButton();
        Borrar = new javax.swing.JButton();
        jText_Cedula = new javax.swing.JTextField();
        jText_Salario = new javax.swing.JTextField();

        setBackground(new java.awt.Color(255, 255, 255));
        setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        setForeground(new java.awt.Color(255, 255, 255));
        setIconifiable(true);
        setMaximizable(true);

        jPanel9.setBackground(new java.awt.Color(0, 153, 153));

        jLabel13.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel13.setText("Farmacia Rosales");

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTextIdEmpleado.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextIdEmpleado.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "ID", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 12), new java.awt.Color(0, 153, 153))); // NOI18N
        jTextIdEmpleado.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        jTextIdEmpleado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField_id_empleado(evt);
            }
        });
        jPanel1.add(jTextIdEmpleado, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, 100, 45));

        jTextBuscar.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        jTextBuscar.setForeground(new java.awt.Color(153, 153, 153));
        jTextBuscar.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Buscar", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 12), new java.awt.Color(0, 153, 153))); // NOI18N
        jTextBuscar.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        jTextBuscar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTextBuscarMouseClicked(evt);
            }
        });
        jTextBuscar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextBuscarKeyReleased(evt);
            }
        });
        jPanel1.add(jTextBuscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 250, 340, 45));

        jPanel5.setBackground(new java.awt.Color(255, 255, 255));
        jPanel5.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        jPanel5.addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
                jPanel5(evt);
            }
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
            }
        });

        jTextNombre1.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextNombre1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Primer Nombre", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 12), new java.awt.Color(0, 153, 153))); // NOI18N
        jTextNombre1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nombre_1TextField(evt);
            }
        });
        jTextNombre1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextNombre1KeyTyped(evt);
            }
        });

        jTextNombre2.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextNombre2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Segundo Nombre", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 12), new java.awt.Color(0, 153, 153))); // NOI18N
        jTextNombre2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nombre_2TextField(evt);
            }
        });
        jTextNombre2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextNombre2KeyTyped(evt);
            }
        });

        jTextApellido1.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextApellido1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Primer Apellido", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 12), new java.awt.Color(0, 153, 153))); // NOI18N
        jTextApellido1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                apellido_1TextField(evt);
            }
        });
        jTextApellido1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextApellido1KeyTyped(evt);
            }
        });

        jTextApellido2.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextApellido2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Segundo Apellido", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 12), new java.awt.Color(0, 153, 153))); // NOI18N
        jTextApellido2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                apellido_2TextField(evt);
            }
        });
        jTextApellido2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextApellido2KeyTyped(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(jTextNombre1, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jTextNombre2, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jTextApellido1, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jTextApellido2, javax.swing.GroupLayout.DEFAULT_SIZE, 223, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextApellido1, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextApellido2, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextNombre2, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextNombre1, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(7, Short.MAX_VALUE))
        );

        jPanel1.add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 80, 930, 70));

        jPanel6.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        jPanel6.setOpaque(false);

        jTextADirecion.setColumns(20);
        jTextADirecion.setRows(5);
        jTextADirecion.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Dirrecion", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 12), new java.awt.Color(0, 153, 153))); // NOI18N
        jTextADirecion.addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
                direccion_TextField(evt);
            }
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
            }
        });
        jTextADirecion.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextADirecionKeyTyped(evt);
            }
        });
        jScrollPane1.setViewportView(jTextADirecion);

        jTextGmail.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextGmail.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Gmail", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 12), new java.awt.Color(0, 153, 153))); // NOI18N
        jTextGmail.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextGmailnombre_2TextField(evt);
            }
        });
        jTextGmail.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextGmailKeyTyped(evt);
            }
        });

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
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jFormattedTextField_Telefono, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 89, Short.MAX_VALUE)
                .addComponent(jTextGmail, javax.swing.GroupLayout.PREFERRED_SIZE, 265, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(89, 89, 89)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 284, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(14, 14, 14))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jTextGmail, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jFormattedTextField_Telefono, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(17, Short.MAX_VALUE))
        );

        jPanel1.add(jPanel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 150, 930, 90));

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        jPanel3.setOpaque(false);

        jTexthoraentra.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTexthoraentra.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Hora de Entrada", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 12), new java.awt.Color(0, 153, 153))); // NOI18N
        jTexthoraentra.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        jTexthoraentra.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                hora_Entrada_TextField(evt);
            }
        });
        jTexthoraentra.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTexthoraentraKeyTyped(evt);
            }
        });

        jTexthorasal.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTexthorasal.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createTitledBorder(null, "", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Dialog", 1, 14)), "Hora de Salida", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Dialog", 1, 12), new java.awt.Color(0, 153, 153))); // NOI18N
        jTexthorasal.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        jTexthorasal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                hora_Salida_TextField(evt);
            }
        });
        jTexthorasal.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTexthorasalKeyTyped(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jTexthoraentra, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jTexthorasal, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(22, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTexthoraentra, javax.swing.GroupLayout.DEFAULT_SIZE, 45, Short.MAX_VALUE)
                    .addComponent(jTexthorasal, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27))
        );

        jPanel1.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 240, 400, 60));

        jTable_Empleado.setForeground(new java.awt.Color(0, 153, 153));
        jTable_Empleado.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "ID Empleado", "Nombre 1", "Nombre 2", "Apellido 1", "Apellido 2", "Numero Celular", "Gmail", "Direccion", "Hora Entrada", "Hora Salida"
            }
        ));
        jTable_Empleado.setGridColor(new java.awt.Color(0, 153, 153));
        jTable_Empleado.setShowGrid(true);
        jTable_Empleado.addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
                jTable_Empleado(evt);
            }
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
            }
        });
        jScrollPane2.setViewportView(jTable_Empleado);

        jPanel1.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 310, 1060, 150));

        jButton6.setBackground(new java.awt.Color(153, 255, 153));
        jButton6.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jButton6.setText("Agregar");
        jButton6.setBorder(javax.swing.BorderFactory.createEtchedBorder(javax.swing.border.EtchedBorder.RAISED));
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                guardar_empleado(evt);
            }
        });
        jPanel1.add(jButton6, new org.netbeans.lib.awtextra.AbsoluteConstraints(990, 100, 80, 30));

        Editar.setBackground(new java.awt.Color(255, 255, 51));
        Editar.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        Editar.setText("Editar");
        Editar.setBorder(javax.swing.BorderFactory.createEtchedBorder(javax.swing.border.EtchedBorder.RAISED));
        Editar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EditarActionPerformed(evt);
            }
        });
        jPanel1.add(Editar, new org.netbeans.lib.awtextra.AbsoluteConstraints(990, 150, 80, 30));

        Actualizar.setBackground(new java.awt.Color(51, 204, 255));
        Actualizar.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        Actualizar.setText("Actualizar");
        Actualizar.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        Actualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ActualizarActionPerformed(evt);
            }
        });
        jPanel1.add(Actualizar, new org.netbeans.lib.awtextra.AbsoluteConstraints(990, 200, 80, 30));

        Borrar.setBackground(new java.awt.Color(0, 153, 153));
        Borrar.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        Borrar.setForeground(new java.awt.Color(255, 255, 255));
        Borrar.setText("Eliminar");
        Borrar.setBorder(javax.swing.BorderFactory.createEtchedBorder(javax.swing.border.EtchedBorder.RAISED));
        Borrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BorrarActionPerformed(evt);
            }
        });
        jPanel1.add(Borrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(990, 250, 80, 30));

        jText_Cedula.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jText_Cedula.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Cedula", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 12), new java.awt.Color(0, 153, 153))); // NOI18N
        jText_Cedula.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jText_Cedulanombre_1TextField(evt);
            }
        });
        jText_Cedula.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jText_CedulaKeyTyped(evt);
            }
        });
        jPanel1.add(jText_Cedula, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 20, 330, 45));

        jText_Salario.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jText_Salario.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Salario", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 12), new java.awt.Color(0, 153, 153))); // NOI18N
        jText_Salario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jText_Salarionombre_1TextField(evt);
            }
        });
        jText_Salario.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jText_SalarioKeyTyped(evt);
            }
        });
        jPanel1.add(jText_Salario, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 20, 130, 45));

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel13, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 1090, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel13)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 469, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel9, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTextField_id_empleado(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField_id_empleado
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField_id_empleado

    private void nombre_1TextField(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nombre_1TextField
        // TODO add your handling code here:
    }//GEN-LAST:event_nombre_1TextField

    private void nombre_2TextField(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nombre_2TextField
        // TODO add your handling code here:
    }//GEN-LAST:event_nombre_2TextField

    private void apellido_1TextField(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_apellido_1TextField
        // TODO add your handling code here:
    }//GEN-LAST:event_apellido_1TextField

    private void apellido_2TextField(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_apellido_2TextField
        // TODO add your handling code here:
    }//GEN-LAST:event_apellido_2TextField

    private void direccion_TextField(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_direccion_TextField
        // TODO add your handling code here:
    }//GEN-LAST:event_direccion_TextField

    private void hora_Entrada_TextField(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_hora_Entrada_TextField
        // TODO add your handling code here:
    }//GEN-LAST:event_hora_Entrada_TextField

    private void hora_Salida_TextField(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_hora_Salida_TextField

        // TODO add your handling code here:
    }//GEN-LAST:event_hora_Salida_TextField

    private void guardar_empleado(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_guardar_empleado
        try {
            if (jTextNombre1.getText().isEmpty()) {
                JOptionPane.showMessageDialog(null, "Tiene datos vacíos");
            } else {
                int option = JOptionPane.showOptionDialog(
                        null,
                        "¿Desea guardar el Empleado?",
                        "Confirmar Guardado",
                        JOptionPane.YES_NO_OPTION,
                        JOptionPane.QUESTION_MESSAGE,
                        new ImageIcon(getClass().getResource("/Vistas_Iconos/agregar.png")),
                        new Object[]{"Sí", "No"},
                        "No"
                );

                if (option == JOptionPane.YES_OPTION) {
                    guardarEmpleado();
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
    }//GEN-LAST:event_guardar_empleado

    private void jPanel5(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_jPanel5
        Border borde = BorderFactory.createLineBorder(Color.BLACK, 2);

        // Crear un JPanel
        JPanel panel = new JPanel();

// Aplicar el borde al JPanel
        panel.setBorder(borde);
    }//GEN-LAST:event_jPanel5

    private void jTextGmailnombre_2TextField(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextGmailnombre_2TextField
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextGmailnombre_2TextField

    private void ActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ActualizarActionPerformed
        String idempleadoText = jTextIdEmpleado.getText();
    int idempleado = Integer.parseInt(idempleadoText);
    String Cedula = jText_Cedula.getText();
    String Nombre1 = jTextNombre1.getText();
    String Nombre2 = jTextNombre2.getText();
    String Apellido1 = jTextApellido1.getText();
    String Apellido2 = jTextApellido2.getText();
    String salario = jText_Salario.getText();
    String NumeroCelular = jFormattedTextField_Telefono.getText();
    String gmail = jTextGmail.getText();
    String direccion = jTextADirecion.getText();
    String horaEntradaStr = jTexthoraentra.getText();
    String horaSalidaStr = jTexthorasal.getText();

    if (jTextIdEmpleado.getText().isEmpty()) {
        JOptionPane.showMessageDialog(null, "Tiene datos vacíos");
    } else {
        int option = JOptionPane.showOptionDialog(
                null,
                "¿Desea actualizar el Empleado?",
                "Confirmar Actualización",
                JOptionPane.YES_NO_OPTION,
                JOptionPane.QUESTION_MESSAGE,
                new ImageIcon(getClass().getResource("/Vistas_Iconos/actualizar.png")),
                new Object[]{"Sí", "No"},
                "No"
        );

        if (option == JOptionPane.YES_OPTION) {
            // Crear objeto Clase_Empleado con los datos obtenidos
            BigDecimal salarioValue;
            try {
                salarioValue = new BigDecimal(salario);
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "El campo de salario contiene un valor inválido.");
                return;
            }

            Time horaEntrada;
            Time horaSalida;
            try {
                horaEntrada = Time.valueOf(horaEntradaStr);
                horaSalida = Time.valueOf(horaSalidaStr);
            } catch (IllegalArgumentException e) {
                JOptionPane.showMessageDialog(null, "Formato de hora incorrecto.");
                return;
            }

            Clase_Empleado empleado = new Clase_Empleado(salarioValue, horaEntrada, horaSalida, idempleado,
                    Cedula, Nombre1, Nombre2, Apellido1, Apellido2, NumeroCelular, gmail, direccion);

            // Llamar al método "actualizar" de CRUD_Empleado
            CRUD_Empleado EmpleadoCRUD = new CRUD_Empleado();
            EmpleadoCRUD.actualizar(empleado);

            JPanel panel = new JPanel();
            panel.setLayout(new BorderLayout());

            JLabel messageLabel = new JLabel("Empleado actualizado exitosamente.");
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

    CRUD_Empleado empleadoCRUD = new CRUD_Empleado();
    empleadoCRUD.mostrarDatos();
    limpiar();
    mostrar();

    }//GEN-LAST:event_ActualizarActionPerformed

    private void EditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EditarActionPerformed
        int filaSeleccionada = jTable_Empleado.getSelectedRow();
        if (filaSeleccionada == -1) {
            JOptionPane.showMessageDialog(this, "Seleccione una fila de la tabla para editar");
        } else {
            String Id_Empleado = jTable_Empleado.getValueAt(filaSeleccionada, 0) != null ? jTable_Empleado.getValueAt(filaSeleccionada, 0).toString() : "";
            String Cedula = jTable_Empleado.getValueAt(filaSeleccionada, 1) != null ? jTable_Empleado.getValueAt(filaSeleccionada, 1).toString() : "";

            String Nombre_1 = jTable_Empleado.getValueAt(filaSeleccionada, 2) != null ? jTable_Empleado.getValueAt(filaSeleccionada, 2).toString() : "";
            String Nombre_2 = jTable_Empleado.getValueAt(filaSeleccionada, 3) != null ? jTable_Empleado.getValueAt(filaSeleccionada, 3).toString() : "";
            String Apellido_1 = jTable_Empleado.getValueAt(filaSeleccionada, 4) != null ? jTable_Empleado.getValueAt(filaSeleccionada, 4).toString() : "";
            String Apellido_2 = jTable_Empleado.getValueAt(filaSeleccionada, 5) != null ? jTable_Empleado.getValueAt(filaSeleccionada, 5).toString() : "";
            String salario = jTable_Empleado.getValueAt(filaSeleccionada, 6) != null ? jTable_Empleado.getValueAt(filaSeleccionada, 6).toString() : "";
             String horaEntradaStr = jTable_Empleado.getValueAt(filaSeleccionada, 7) != null ? jTable_Empleado.getValueAt(filaSeleccionada, 7).toString() : "";
            String horaSalidaStr = jTable_Empleado.getValueAt(filaSeleccionada, 8) != null ? jTable_Empleado.getValueAt(filaSeleccionada, 8).toString() : "";

            String Numero_Celular = jTable_Empleado.getValueAt(filaSeleccionada, 9) != null ? jTable_Empleado.getValueAt(filaSeleccionada, 9).toString() : "";
            String Gmail = jTable_Empleado.getValueAt(filaSeleccionada, 10) != null ? jTable_Empleado.getValueAt(filaSeleccionada, 10).toString() : "";
            String Direccion = jTable_Empleado.getValueAt(filaSeleccionada, 11) != null ? jTable_Empleado.getValueAt(filaSeleccionada, 11).toString() : "";
           
            jTextIdEmpleado.setText(Id_Empleado);
            jText_Cedula.setText(Cedula);
            jTextNombre1.setText(Nombre_1);
            jTextNombre2.setText(Nombre_2);
            jTextApellido1.setText(Apellido_1);
            jTextApellido2.setText(Apellido_2);
            jText_Salario.setText(salario);
            jFormattedTextField_Telefono.setText(Numero_Celular);
            jTextGmail.setText(Gmail);
            jTextADirecion.setText(Direccion);
            jTexthoraentra.setText(horaEntradaStr);
            jTexthorasal.setText(horaSalidaStr);

            jTextIdEmpleado.setEditable(false); // Deshabilitar la edición del ID
        }

    }//GEN-LAST:event_EditarActionPerformed

    private void jTable_Empleado(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_jTable_Empleado
        // TODO add your handling code here:
    }//GEN-LAST:event_jTable_Empleado

    private void jFormattedTextField_Telefono(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jFormattedTextField_Telefono
        // TODO add your handling code here:
    }//GEN-LAST:event_jFormattedTextField_Telefono

    private void jTextNombre1KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextNombre1KeyTyped
        char car = evt.getKeyChar();
        String texto = jTextNombre1.getText(); // Obtener el texto actual en el campo

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
    }//GEN-LAST:event_jTextNombre1KeyTyped

    private void jTextNombre2KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextNombre2KeyTyped
        char car = evt.getKeyChar();
        String texto = jTextNombre2.getText(); // Obtener el texto actual en el campo

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
    }//GEN-LAST:event_jTextNombre2KeyTyped

    private void jTextApellido1KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextApellido1KeyTyped
        char car = evt.getKeyChar();
        String texto = jTextApellido1.getText(); // Obtener el texto actual en el campo

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
    }//GEN-LAST:event_jTextApellido1KeyTyped

    private void jTextApellido2KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextApellido2KeyTyped
        char car = evt.getKeyChar();
        String texto = jTextApellido2.getText(); // Obtener el texto actual en el campo

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
    }//GEN-LAST:event_jTextApellido2KeyTyped

    private void jTextADirecionKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextADirecionKeyTyped
        String texto = jTextADirecion.getText();

        if (texto.length() >= 200) {
            evt.consume();
        }
    }//GEN-LAST:event_jTextADirecionKeyTyped

    private void jTextGmailKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextGmailKeyTyped
        String texto = jTextGmail.getText();

        if (texto.length() >= 50) {
            evt.consume();
        }
    }//GEN-LAST:event_jTextGmailKeyTyped

    private void jTexthoraentraKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTexthoraentraKeyTyped
        char c = evt.getKeyChar();

        if (!(Character.isDigit(c) || c == '-' || c == ':') || jTexthoraentra.getText().length() >= 8) {
            evt.consume();
        }
    }//GEN-LAST:event_jTexthoraentraKeyTyped

    private void jTexthorasalKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTexthorasalKeyTyped
        char c = evt.getKeyChar();

        if (!(Character.isDigit(c) || c == '-' || c == ':') || jTexthorasal.getText().length() >= 8) {
            evt.consume();
        }

    }//GEN-LAST:event_jTexthorasalKeyTyped

    private void jTextBuscarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTextBuscarMouseClicked
        jTextBuscar.setText("");
        jTextBuscar.setForeground(Color.black);
    }//GEN-LAST:event_jTextBuscarMouseClicked

    private void jTextBuscarKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextBuscarKeyReleased
        BuscarEmpleado();
    }//GEN-LAST:event_jTextBuscarKeyReleased

    private void jText_Cedulanombre_1TextField(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jText_Cedulanombre_1TextField
        // TODO add your handling code here:
    }//GEN-LAST:event_jText_Cedulanombre_1TextField

    private void jText_CedulaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jText_CedulaKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_jText_CedulaKeyTyped

    private void jText_Salarionombre_1TextField(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jText_Salarionombre_1TextField
        // TODO add your handling code here:
    }//GEN-LAST:event_jText_Salarionombre_1TextField

    private void jText_SalarioKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jText_SalarioKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_jText_SalarioKeyTyped

    private void BorrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BorrarActionPerformed
        int selectedRow = jTable_Empleado.getSelectedRow();
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
                String idempleadoString = jTable_Empleado.getValueAt(selectedRow, 0).toString();
                int idempleado = Integer.parseInt(idempleadoString);

                CRUD_Empleado cli = new CRUD_Empleado();
                cli.eliminar(idempleado);

                mostrar();

                JPanel panel = new JPanel();
                panel.setLayout(new BorderLayout());

                JLabel messageLabel = new JLabel("Empleado eliminado correctamente");
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

            JLabel messageLabel = new JLabel("Debe seleccionar un Empleado");
            messageLabel.setFont(new Font("Arial", Font.BOLD, 14));
            messageLabel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
            panel.add(messageLabel, BorderLayout.CENTER);

            ImageIcon icon = new ImageIcon(getClass().getResource("/Vistas_Iconos/abvertencia.png"));
            JLabel iconLabel = new JLabel(icon);
            iconLabel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
            panel.add(iconLabel, BorderLayout.WEST);

            JOptionPane.showMessageDialog(null, panel, "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_BorrarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Actualizar;
    private javax.swing.JButton Borrar;
    private javax.swing.JButton Editar;
    private javax.swing.JButton jButton6;
    private javax.swing.JFormattedTextField jFormattedTextField_Telefono;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable_Empleado;
    private javax.swing.JTextArea jTextADirecion;
    private javax.swing.JTextField jTextApellido1;
    private javax.swing.JTextField jTextApellido2;
    private javax.swing.JTextField jTextBuscar;
    private javax.swing.JTextField jTextGmail;
    private javax.swing.JTextField jTextIdEmpleado;
    private javax.swing.JTextField jTextNombre1;
    private javax.swing.JTextField jTextNombre2;
    private javax.swing.JTextField jText_Cedula;
    private javax.swing.JTextField jText_Salario;
    private javax.swing.JTextField jTexthoraentra;
    private javax.swing.JTextField jTexthorasal;
    // End of variables declaration//GEN-END:variables
}
