package Vistas;

import Modelo.Clase_Empleado;
import Controlador_Conexion_DB.Conexion;
import Controlador.*;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.HeadlessException;
import java.awt.event.KeyEvent;
import java.sql.CallableStatement;
import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.border.Border;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author diedr
 */
public class JInternalFrame_Empleado extends javax.swing.JInternalFrame {

    private JPanel panel;
    public final Conexion con = new Conexion();
    public final Connection cn = (Connection) con.conectar();

    public JInternalFrame_Empleado() {
        // Configuración del JInternalFrame
        setClosable(true);
        setResizable(true);
        setMaximizable(true);
        setIconifiable(true);
        setTitle("Internal Frame Empleado");
        setSize(100, 600);

        // Crear el panel
        panel = new JPanel();
        // Configurar el panel con los componentes y diseño deseado

        // Configurar el BorderLayout para el contenido del JInternalFrame
        setLayout(new BorderLayout());
        add(panel, BorderLayout.CENTER);

        initComponents();
        jTextIdEmpleado.setEditable(false);
    }

    public void limpiar() {
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
        String Nombre1 = jTextNombre1.getText();
        String Nombre2 = jTextNombre2.getText();
        String Apellido1 = jTextApellido1.getText();
        String Apellido2 = jTextApellido2.getText();
        String NumeroCelular = jFormattedTextField_Telefono.getText();
        String gmail = jTextGmail.getText();
        String direccion = jTextADirecion.getText();
        String horaEntradaStr = jTexthoraentra.getText();
        String horaSalidaStr = jTexthorasal.getText();

        Clase_Empleado Empleado = new Clase_Empleado(Nombre1, Nombre2, Apellido1, Apellido2, NumeroCelular, gmail, direccion, horaEntradaStr, horaSalidaStr);
        cl.Guardar(Empleado);
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

        Clase_Empleado cl = new Clase_Empleado(jTextNombre1.getText(),
                jTextNombre2.getText(),
                jTextApellido1.getText(),
                jTextApellido2.getText(),
                jFormattedTextField_Telefono.getText(),
                jTextGmail.getText(),
                jTextADirecion.getText(),
                jTexthoraentra.getText(),
                jTexthorasal.getText());
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

        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jTextIdEmpleado = new javax.swing.JTextField();
        jTextBuscar = new javax.swing.JTextField();
        jPanel5 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jTextNombre1 = new javax.swing.JTextField();
        jTextNombre2 = new javax.swing.JTextField();
        jTextApellido1 = new javax.swing.JTextField();
        jTextApellido2 = new javax.swing.JTextField();
        jPanel6 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextADirecion = new javax.swing.JTextArea();
        jTextGmail = new javax.swing.JTextField();
        jFormattedTextField_Telefono = new javax.swing.JFormattedTextField();
        jPanel3 = new javax.swing.JPanel();
        jLabel12 = new javax.swing.JLabel();
        jTexthoraentra = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jTexthorasal = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable_Empleado = new javax.swing.JTable();
        jButton6 = new javax.swing.JButton();
        Editar = new javax.swing.JButton();
        Actualizar = new javax.swing.JButton();
        Borrar = new javax.swing.JButton();
        jLabel14 = new javax.swing.JLabel();
        jPanel9 = new javax.swing.JPanel();
        jLabel13 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));
        setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        setForeground(new java.awt.Color(255, 255, 255));
        setIconifiable(true);
        setMaximizable(true);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 153, 153));
        jLabel2.setText("Id Empleado");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 40, -1, -1));

        jTextIdEmpleado.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextIdEmpleado.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        jTextIdEmpleado.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        jTextIdEmpleado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField_id_empleado(evt);
            }
        });
        jPanel1.add(jTextIdEmpleado, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 40, 100, -1));

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
        jTextBuscar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextBuscarKeyReleased(evt);
            }
        });
        jPanel1.add(jTextBuscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 280, 250, 30));

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

        jTextNombre1.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextNombre1.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
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
        jTextNombre2.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
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
        jTextApellido1.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
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
        jTextApellido2.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
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
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(jTextNombre1, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(44, 44, 44)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel9)
                    .addComponent(jTextNombre2, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(44, 44, 44)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel7)
                    .addComponent(jTextApellido1, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 25, Short.MAX_VALUE)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addGap(80, 80, 80))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                        .addComponent(jTextApellido2, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jLabel9)
                    .addComponent(jLabel7)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextNombre1, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextNombre2, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextApellido1, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextApellido2, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel1.add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 80, 660, 70));

        jPanel6.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        jPanel6.setOpaque(false);

        jLabel8.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(0, 153, 153));
        jLabel8.setText("Teléfono");

        jLabel11.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(0, 153, 153));
        jLabel11.setText("Gmail");

        jLabel6.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(0, 153, 153));
        jLabel6.setText("Dirección");

        jTextADirecion.setColumns(20);
        jTextADirecion.setRows(5);
        jTextADirecion.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
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
        jTextGmail.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
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
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel8)
                    .addComponent(jFormattedTextField_Telefono, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(48, 48, 48)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel11)
                    .addComponent(jTextGmail, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(38, 38, 38)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 284, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(24, Short.MAX_VALUE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(jLabel11)
                    .addComponent(jLabel6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jTextGmail, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jFormattedTextField_Telefono, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel1.add(jPanel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 150, 660, 90));

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        jPanel3.setOpaque(false);

        jLabel12.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(0, 153, 153));
        jLabel12.setText("Hora de Entrada");

        jTexthoraentra.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTexthoraentra.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
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

        jLabel10.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(0, 153, 153));
        jLabel10.setText("Hora de Salida");

        jTexthorasal.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTexthorasal.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createTitledBorder(null, "", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Dialog", 1, 14)), "", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Dialog", 1, 14))); // NOI18N
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
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jTexthoraentra)
                    .addComponent(jLabel12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(40, 40, 40)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel10)
                    .addComponent(jTexthorasal, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12)
                    .addComponent(jLabel10))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTexthorasal, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTexthoraentra))
                .addContainerGap())
        );

        jPanel1.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 240, 280, 60));

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

        jPanel1.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 330, 870, 110));

        jButton6.setBackground(new java.awt.Color(0, 153, 153));
        jButton6.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jButton6.setForeground(new java.awt.Color(255, 255, 255));
        jButton6.setText("Agregar");
        jButton6.setBorder(javax.swing.BorderFactory.createEtchedBorder(javax.swing.border.EtchedBorder.RAISED));
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                guardar_empleado(evt);
            }
        });
        jPanel1.add(jButton6, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 50, 80, 30));

        Editar.setBackground(new java.awt.Color(0, 153, 153));
        Editar.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        Editar.setForeground(new java.awt.Color(255, 255, 255));
        Editar.setText("Editar");
        Editar.setBorder(javax.swing.BorderFactory.createEtchedBorder(javax.swing.border.EtchedBorder.RAISED));
        Editar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EditarActionPerformed(evt);
            }
        });
        jPanel1.add(Editar, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 110, 80, 30));

        Actualizar.setBackground(new java.awt.Color(0, 153, 153));
        Actualizar.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        Actualizar.setForeground(new java.awt.Color(255, 255, 255));
        Actualizar.setText("Actualizar");
        Actualizar.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        Actualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ActualizarActionPerformed(evt);
            }
        });
        jPanel1.add(Actualizar, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 180, 80, 30));

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
        jPanel1.add(Borrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 240, 80, 30));

        jLabel14.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(0, 153, 153));
        jLabel14.setText("Buscar");
        jPanel1.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 260, -1, -1));

        jPanel9.setBackground(new java.awt.Color(0, 153, 153));

        jLabel13.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel13.setText("Farmacia Rosales");

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel13, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel13)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 934, Short.MAX_VALUE)
            .addComponent(jPanel9, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 469, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0))
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
        CRUD_Empleado cl = new CRUD_Empleado();
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
                        new ImageIcon(getClass().getResource("/Vistas_Iconos/Guardar.png")),
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

                    ImageIcon icon = new ImageIcon(getClass().getResource("/Vistas_Iconos/Guardar.png"));
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
        String Nombre1 = jTextNombre1.getText();
        String Nombre2 = jTextNombre2.getText();
        String Apellido1 = jTextApellido1.getText();
        String Apellido2 = jTextApellido2.getText();
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
                    new ImageIcon(getClass().getResource("/Vistas_Iconos/Actualizar.png")),
                    new Object[]{"Sí", "No"},
                    "No"
            );

            if (option == JOptionPane.YES_OPTION) {
                // Crear objeto Clase_Empleado con los datos obtenidos
                Clase_Empleado empleado = new Clase_Empleado(idempleado, Nombre1, Nombre2, Apellido1, Apellido2, NumeroCelular, gmail, direccion, horaEntradaStr, horaSalidaStr);

                // Llamar al método "actualizar" de CRUD_Empleado
                CRUD_Empleado EmpleadoCRUD = new CRUD_Empleado();
                EmpleadoCRUD.actualizar(empleado);

                JPanel panel = new JPanel();
                panel.setLayout(new BorderLayout());

                JLabel messageLabel = new JLabel("Cliente actualizado exitosamente.");
                messageLabel.setFont(new Font("Arial", Font.BOLD, 14));
                messageLabel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
                panel.add(messageLabel, BorderLayout.CENTER);

                ImageIcon icon = new ImageIcon(getClass().getResource("/Vistas_Iconos/Actualizar.png"));
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

    private void BorrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BorrarActionPerformed
        int selectedRow = jTable_Empleado.getSelectedRow();
        if (selectedRow != -1) {
            int option = JOptionPane.showOptionDialog(
                    rootPane,
                    "Se eliminará el registro, ¿desea continuar?",
                    "Eliminar Registro",
                    JOptionPane.YES_NO_OPTION,
                    JOptionPane.WARNING_MESSAGE,
                    new ImageIcon(getClass().getResource("/Vistas_Iconos/Eliminar.png")),
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

                ImageIcon icon = new ImageIcon(getClass().getResource("/Vistas_Iconos/Eliminar.png"));
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

            ImageIcon icon = new ImageIcon(getClass().getResource("/Vistas_Iconos/Advertencia.png"));
            JLabel iconLabel = new JLabel(icon);
            iconLabel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
            panel.add(iconLabel, BorderLayout.WEST);

            JOptionPane.showMessageDialog(null, panel, "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_BorrarActionPerformed

    private void EditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EditarActionPerformed
        int filaSelecion = jTable_Empleado.getSelectedRow();
        if (filaSelecion == -1) {
            JOptionPane.showMessageDialog(this, "Seleccione una fila de la tabla para editar");
        } else {
            String Id_Empleado = jTable_Empleado.getValueAt(filaSelecion, 0) != null ? jTable_Empleado.getValueAt(filaSelecion, 0).toString() : "";

            String Nombre_1 = jTable_Empleado.getValueAt(filaSelecion, 1) != null ? jTable_Empleado.getValueAt(filaSelecion, 1).toString() : "";
            String Nombre_2 = jTable_Empleado.getValueAt(filaSelecion, 2) != null ? jTable_Empleado.getValueAt(filaSelecion, 2).toString() : "";
            String Apellido_1 = jTable_Empleado.getValueAt(filaSelecion, 3) != null ? jTable_Empleado.getValueAt(filaSelecion, 3).toString() : "";
            String Apellido_2 = jTable_Empleado.getValueAt(filaSelecion, 4) != null ? jTable_Empleado.getValueAt(filaSelecion, 4).toString() : "";
            String Numero_Celular = jTable_Empleado.getValueAt(filaSelecion, 5) != null ? jTable_Empleado.getValueAt(filaSelecion, 5).toString() : "";
            String Gmail = jTable_Empleado.getValueAt(filaSelecion, 6) != null ? jTable_Empleado.getValueAt(filaSelecion, 6).toString() : "";
            String Direccion = jTable_Empleado.getValueAt(filaSelecion, 7) != null ? jTable_Empleado.getValueAt(filaSelecion, 7).toString() : "";
            String horaEntradaStr = jTable_Empleado.getValueAt(filaSelecion, 8) != null ? jTable_Empleado.getValueAt(filaSelecion, 8).toString() : "";
            String horaSalidaStr = jTable_Empleado.getValueAt(filaSelecion, 9) != null ? jTable_Empleado.getValueAt(filaSelecion, 9).toString() : "";

            jTextIdEmpleado.setText(Id_Empleado);
            jTextNombre1.setText(Nombre_1);
            jTextNombre2.setText(Nombre_2);
            jTextApellido1.setText(Apellido_1);
            jTextApellido2.setText(Apellido_2);
            jFormattedTextField_Telefono.setText(Numero_Celular);
            jTextGmail.setText(Gmail);
            jTextADirecion.setText(Direccion);
            jTexthoraentra.setText(horaEntradaStr);
            jTexthorasal.setText(horaSalidaStr);

            jTextIdEmpleado.setEditable(true);

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


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Actualizar;
    private javax.swing.JButton Borrar;
    private javax.swing.JButton Editar;
    private javax.swing.JButton jButton6;
    private javax.swing.JFormattedTextField jFormattedTextField_Telefono;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
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
    private javax.swing.JTextField jTexthoraentra;
    private javax.swing.JTextField jTexthorasal;
    // End of variables declaration//GEN-END:variables
}
