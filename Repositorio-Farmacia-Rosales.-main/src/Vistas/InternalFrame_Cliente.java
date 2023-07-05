package Vistas;

import Controlador.CRUD_Cliente;
import Modelo.Clase_Cliente;
import java.awt.Color;
import java.awt.HeadlessException;
import java.awt.event.KeyEvent;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import java.sql.CallableStatement;
import java.sql.SQLException;
import Controlador_Conexion_DB.Conexion;
import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.sql.Connection;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.JREmptyDataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.view.JasperViewer;
import java.awt.event.MouseEvent;
import java.awt.event.MouseAdapter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import javax.swing.JButton;
import javax.swing.JInternalFrame;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.view.JasperViewer;

/**
 *
 * @author Oreki
 */
public class InternalFrame_Cliente extends javax.swing.JInternalFrame {

    private JPanel panel;
    public final Conexion con = new Conexion();
    public final Connection cn = (Connection) con.conectar();

    public InternalFrame_Cliente() {
        initComponents();
         jTextField_Id_Ciente.setEditable(false);
       

    }

    public void limpiar() {
        jTextField_Id_Ciente.setText("");
        JtextFiel_Cedula.setText("");
        JtextFiel_Nombre_1.setText("");
        JtextFiel_Nombre_2.setText("");
        jTextFiel_Apellido_1.setText("");
        jTextField_Apellido_2.setText("");
        jFormattedTextFieldTelefono.setText("");
        JtextFiel_gmail.setText("");
        jTextArea_Dirrecion.setText("");

    }

    public void guardarCliente() {
        CRUD_Cliente cc = new CRUD_Cliente();
        String Cedula = JtextFiel_Cedula.getText();
        String Nombre_1 = JtextFiel_Nombre_1.getText();
        String Nombre_2 = JtextFiel_Nombre_2.getText();
        String Apellido_1 = jTextFiel_Apellido_1.getText();
        String Apellido_2 = jTextField_Apellido_2.getText();
        String gmail = JtextFiel_gmail.getText();
        String Telefono = jFormattedTextFieldTelefono.getText();
        String Direccion = jTextArea_Dirrecion.getText();

        Clase_Cliente cl = new Clase_Cliente(Cedula, Nombre_1, Nombre_2, Apellido_1, Apellido_2, Telefono, gmail, Direccion);
        cc.Guardar(cl);
    }

    public void mostrar() {
        try {
            DefaultTableModel modelo;
            CRUD_Cliente cli = new CRUD_Cliente();
            modelo = cli.mostrarDatos();
            jTable_Cliente.setModel(modelo);

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }

    }

    public void editarCliente() {

        CRUD_Cliente cc = new CRUD_Cliente();

        Clase_Cliente cl = new Clase_Cliente(JtextFiel_Cedula.getText(),
                JtextFiel_Nombre_1.getText(),
                JtextFiel_Nombre_2.getText(),
                jTextFiel_Apellido_1.getText(),
                jTextField_Apellido_2.getText(),
                jFormattedTextFieldTelefono.getText(),
                JtextFiel_gmail.getText(),
                jTextArea_Dirrecion.getText());
        cc.actualizar(cl);

    }

    public void BuscarCliente() {
        try {
            DefaultTableModel modelo;
            CRUD_Cliente cli = new CRUD_Cliente();
            modelo = cli.BuscarCliente(jTextBuscar.getText());

            if (modelo != null) {
                jTable_Cliente.setModel(modelo);
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
        jPanel5 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea_Dirrecion = new javax.swing.JTextArea();
        JtextFiel_Cedula = new javax.swing.JTextField();
        JtextFiel_gmail = new javax.swing.JTextField();
        jFormattedTextFieldTelefono = new javax.swing.JFormattedTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable_Cliente = new javax.swing.JTable();
        jTextBuscar = new javax.swing.JTextField();
        jButton6 = new javax.swing.JButton();
        jButton_Editar = new javax.swing.JButton();
        jButton_Borrar = new javax.swing.JButton();
        jButton_Actualizar1 = new javax.swing.JButton();
        jButton_Report = new javax.swing.JButton();
        jTextField_Id_Ciente = new javax.swing.JTextField();
        JtextFiel_Nombre_1 = new javax.swing.JTextField();
        JtextFiel_Nombre_2 = new javax.swing.JTextField();
        jTextFiel_Apellido_1 = new javax.swing.JTextField();
        jTextField_Apellido_2 = new javax.swing.JTextField();
        jPanel6 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();

        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel5.setBackground(new java.awt.Color(255, 255, 255));
        jPanel5.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        jPanel5.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jPanel5.setOpaque(false);

        jTextArea_Dirrecion.setColumns(20);
        jTextArea_Dirrecion.setRows(5);
        jTextArea_Dirrecion.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Dirrecion", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 12), new java.awt.Color(0, 153, 153))); // NOI18N
        jTextArea_Dirrecion.addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
                jTextArea_Dirrecion(evt);
            }
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
            }
        });
        jTextArea_Dirrecion.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextArea_DirrecionKeyTyped(evt);
            }
        });
        jScrollPane1.setViewportView(jTextArea_Dirrecion);

        JtextFiel_Cedula.setForeground(new java.awt.Color(0, 153, 153));
        JtextFiel_Cedula.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        JtextFiel_Cedula.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Cedula", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 12), new java.awt.Color(0, 153, 153))); // NOI18N
        JtextFiel_Cedula.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JtextFiel_Cedula(evt);
            }
        });
        JtextFiel_Cedula.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                JtextFiel_CedulaKeyTyped(evt);
            }
        });

        JtextFiel_gmail.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        JtextFiel_gmail.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Gmail", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 12), new java.awt.Color(0, 153, 153))); // NOI18N
        JtextFiel_gmail.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JtextFiel_gmail(evt);
            }
        });
        JtextFiel_gmail.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                JtextFiel_gmailKeyTyped(evt);
            }
        });

        jFormattedTextFieldTelefono.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Numero Celular", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 12), new java.awt.Color(0, 153, 153))); // NOI18N
        try {
            jFormattedTextFieldTelefono.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("####-####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        jFormattedTextFieldTelefono.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jFormattedTextFieldTelefono.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jFormattedTextFieldTelefono(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addComponent(JtextFiel_Cedula, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(JtextFiel_gmail, javax.swing.GroupLayout.PREFERRED_SIZE, 258, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 34, Short.MAX_VALUE)
                .addComponent(jFormattedTextFieldTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(35, 35, 35)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 251, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(JtextFiel_Cedula, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(JtextFiel_gmail, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jFormattedTextFieldTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 25, Short.MAX_VALUE)))
                .addContainerGap())
        );

        jPanel1.add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 70, 980, -1));

        jTable_Cliente.setForeground(new java.awt.Color(0, 153, 153));
        jTable_Cliente.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Id cliente", "Cedula", "Nombre 1", "Nombre 2", "Apellido 1", "Apellido 2", "Telefono", "Dirección"
            }
        ));
        jTable_Cliente.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jTable_Cliente.setGridColor(new java.awt.Color(0, 153, 153));
        jTable_Cliente.setShowGrid(false);
        jTable_Cliente.setShowHorizontalLines(true);
        jTable_Cliente.setShowVerticalLines(true);
        jTable_Cliente.addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
                jTable_Cliente(evt);
            }
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
            }
        });
        jTable_Cliente.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jTable_ClienteMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jTable_ClienteMouseExited(evt);
            }
        });
        jScrollPane2.setViewportView(jTable_Cliente);

        jPanel1.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 240, 980, 250));

        jTextBuscar.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        jTextBuscar.setForeground(new java.awt.Color(153, 153, 153));
        jTextBuscar.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Buscar", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 12), new java.awt.Color(0, 153, 153))); // NOI18N
        jTextBuscar.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        jTextBuscar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTextBuscarMouseClicked(evt);
            }
        });
        jTextBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextBuscar(evt);
            }
        });
        jTextBuscar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextBuscarKeyReleased(evt);
            }
        });
        jPanel1.add(jTextBuscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 180, 270, 40));

        jButton6.setBackground(new java.awt.Color(0, 153, 153));
        jButton6.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        jButton6.setForeground(new java.awt.Color(255, 255, 255));
        jButton6.setText("Agregar");
        jButton6.setBorder(javax.swing.BorderFactory.createEtchedBorder(javax.swing.border.EtchedBorder.RAISED));
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Guardar_Cliente(evt);
            }
        });
        jPanel1.add(jButton6, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 190, 80, 30));

        jButton_Editar.setBackground(new java.awt.Color(255, 255, 102));
        jButton_Editar.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        jButton_Editar.setText("Editar");
        jButton_Editar.setBorder(javax.swing.BorderFactory.createEtchedBorder(javax.swing.border.EtchedBorder.RAISED));
        jButton_Editar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_Editar(evt);
            }
        });
        jPanel1.add(jButton_Editar, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 190, 80, 30));

        jButton_Borrar.setBackground(new java.awt.Color(255, 102, 102));
        jButton_Borrar.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        jButton_Borrar.setForeground(new java.awt.Color(255, 255, 255));
        jButton_Borrar.setText("Eliminar");
        jButton_Borrar.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jButton_Borrar.setMaximumSize(new java.awt.Dimension(80, 30));
        jButton_Borrar.setMinimumSize(new java.awt.Dimension(80, 30));
        jButton_Borrar.setPreferredSize(new java.awt.Dimension(80, 30));
        jButton_Borrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_Borrar(evt);
            }
        });
        jPanel1.add(jButton_Borrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 190, 80, 30));

        jButton_Actualizar1.setBackground(new java.awt.Color(102, 204, 255));
        jButton_Actualizar1.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        jButton_Actualizar1.setForeground(new java.awt.Color(255, 255, 255));
        jButton_Actualizar1.setText("Actualizar");
        jButton_Actualizar1.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jButton_Actualizar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_Actualizar1(evt);
            }
        });
        jPanel1.add(jButton_Actualizar1, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 190, 80, 30));

        jButton_Report.setText("Reporte");
        jButton_Report.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton_ReportMouseClicked(evt);
            }
        });
        jButton_Report.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_ReportActionPerformed(evt);
            }
        });
        jPanel1.add(jButton_Report, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 190, -1, -1));

        jTextField_Id_Ciente.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jTextField_Id_Ciente.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField_Id_Ciente.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "ID Cliente", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 12), new java.awt.Color(0, 153, 153))); // NOI18N
        jTextField_Id_Ciente.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        jTextField_Id_Ciente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField_Id_Ciente(evt);
            }
        });
        jPanel1.add(jTextField_Id_Ciente, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 20, 130, 45));

        JtextFiel_Nombre_1.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        JtextFiel_Nombre_1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Primer Nombre", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 12), new java.awt.Color(0, 153, 153))); // NOI18N
        JtextFiel_Nombre_1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JtextFiel_nombre1(evt);
            }
        });
        JtextFiel_Nombre_1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                JtextFiel_Nombre_1KeyTyped(evt);
            }
        });
        jPanel1.add(JtextFiel_Nombre_1, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 20, 160, 45));

        JtextFiel_Nombre_2.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        JtextFiel_Nombre_2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Segundo Nombre", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 12), new java.awt.Color(0, 153, 153))); // NOI18N
        JtextFiel_Nombre_2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JtextFiel_Nombre_2(evt);
            }
        });
        JtextFiel_Nombre_2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                JtextFiel_Nombre_2KeyTyped(evt);
            }
        });
        jPanel1.add(JtextFiel_Nombre_2, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 20, 160, 40));

        jTextFiel_Apellido_1.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextFiel_Apellido_1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Primer Apellido", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 12), new java.awt.Color(0, 153, 153))); // NOI18N
        jTextFiel_Apellido_1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFiel_Apellido_1(evt);
            }
        });
        jTextFiel_Apellido_1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextFiel_Apellido_1KeyTyped(evt);
            }
        });
        jPanel1.add(jTextFiel_Apellido_1, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 20, 160, 40));

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
        jPanel1.add(jTextField_Apellido_2, new org.netbeans.lib.awtextra.AbsoluteConstraints(840, 20, 160, 40));

        jPanel6.setBackground(new java.awt.Color(0, 153, 153));

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("Farmacia Rosales");

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 875, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel4)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(0, 0, 0))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 507, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTable_Cliente(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_jTable_Cliente

    }//GEN-LAST:event_jTable_Cliente

    private void jTable_ClienteMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable_ClienteMouseEntered

    }//GEN-LAST:event_jTable_ClienteMouseEntered

    private void jTable_ClienteMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable_ClienteMouseExited

    }//GEN-LAST:event_jTable_ClienteMouseExited

    private void jTextArea_Dirrecion(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_jTextArea_Dirrecion

    }//GEN-LAST:event_jTextArea_Dirrecion

    private void Guardar_Cliente(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Guardar_Cliente
        CRUD_Cliente cl = new CRUD_Cliente();
        try {
            if (JtextFiel_Nombre_1.getText().isEmpty()) {
                JOptionPane.showMessageDialog(null, "Tiene datos vacíos");
            } else {
                int option = JOptionPane.showOptionDialog(
                        null,
                        "¿Desea guardar el cliente?",
                        "Confirmar Guardado",
                        JOptionPane.YES_NO_OPTION,
                        JOptionPane.QUESTION_MESSAGE,
                        new ImageIcon(getClass().getResource("/Vistas_Iconos/agregar.png")),
                        new Object[]{"Sí", "No"},
                        "No"
                );

                if (option == JOptionPane.YES_OPTION) {
                    guardarCliente();
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

    }//GEN-LAST:event_Guardar_Cliente

    private void jButton_Editar(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_Editar
        int filaSeleccionada = jTable_Cliente.getSelectedRow();
        if (filaSeleccionada == -1) {
            JOptionPane.showMessageDialog(this, "Seleccione una fila de la tabla para editar");
        } else {
            String id = jTable_Cliente.getValueAt(filaSeleccionada, 0) != null ? jTable_Cliente.getValueAt(filaSeleccionada, 0).toString() : "";
            String Cedula = jTable_Cliente.getValueAt(filaSeleccionada, 1) != null ? jTable_Cliente.getValueAt(filaSeleccionada, 1).toString() : "";
            String nombre1 = jTable_Cliente.getValueAt(filaSeleccionada, 2) != null ? jTable_Cliente.getValueAt(filaSeleccionada, 2).toString() : "";
            String nombre2 = jTable_Cliente.getValueAt(filaSeleccionada, 3) != null ? jTable_Cliente.getValueAt(filaSeleccionada, 3).toString() : "";
            String apellido1 = jTable_Cliente.getValueAt(filaSeleccionada, 4) != null ? jTable_Cliente.getValueAt(filaSeleccionada, 4).toString() : "";
            String apellido2 = jTable_Cliente.getValueAt(filaSeleccionada, 5) != null ? jTable_Cliente.getValueAt(filaSeleccionada, 5).toString() : "";
            String telefono = jTable_Cliente.getValueAt(filaSeleccionada, 6) != null ? jTable_Cliente.getValueAt(filaSeleccionada, 6).toString() : "";
            String Gmail = jTable_Cliente.getValueAt(filaSeleccionada, 7) != null ? jTable_Cliente.getValueAt(filaSeleccionada, 7).toString() : "";
            String direccion = jTable_Cliente.getValueAt(filaSeleccionada, 8) != null ? jTable_Cliente.getValueAt(filaSeleccionada, 8).toString() : "";

            jTextField_Id_Ciente.setText(id);
            JtextFiel_Cedula.setText(Cedula);
            JtextFiel_Nombre_1.setText(nombre1);
            JtextFiel_Nombre_2.setText(nombre2);
            jTextFiel_Apellido_1.setText(apellido1);
            jTextField_Apellido_2.setText(apellido2);
            jFormattedTextFieldTelefono.setText(telefono);
            JtextFiel_gmail.setText(Gmail);
            jTextArea_Dirrecion.setText(direccion);

            // Desactivar la edición del campo de texto para el ID del cliente
            jTextField_Id_Ciente.setEditable(false);
        }


    }//GEN-LAST:event_jButton_Editar

    private void jTextBuscar(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextBuscar
        jTextBuscar.setText("");
        jTextBuscar.setForeground(Color.black);
        BuscarCliente();
    }//GEN-LAST:event_jTextBuscar

    private void JtextFiel_nombre1(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JtextFiel_nombre1

    }//GEN-LAST:event_JtextFiel_nombre1

    private void JtextFiel_Nombre_2(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JtextFiel_Nombre_2
        // TODO add your handling code here:
    }//GEN-LAST:event_JtextFiel_Nombre_2

    private void jTextFiel_Apellido_1(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFiel_Apellido_1
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFiel_Apellido_1

    private void jTextField_Apellido_2(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField_Apellido_2
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField_Apellido_2

    private void jButton_Borrar(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_Borrar
        int selectedRow = jTable_Cliente.getSelectedRow();
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
                String idClienteString = jTable_Cliente.getValueAt(selectedRow, 0).toString();
                int idCliente = Integer.parseInt(idClienteString);

                CRUD_Cliente cli = new CRUD_Cliente();
                cli.eliminar(idCliente);

                mostrar();

                JPanel panel = new JPanel();
                panel.setLayout(new BorderLayout());

                JLabel messageLabel = new JLabel("Cliente eliminado correctamente");
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

            JLabel messageLabel = new JLabel("Debe seleccionar un cliente");
            messageLabel.setFont(new Font("Arial", Font.BOLD, 14));
            messageLabel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
            panel.add(messageLabel, BorderLayout.CENTER);

            ImageIcon icon = new ImageIcon(getClass().getResource("/Vistas_Iconos/abvertencia.png"));
            JLabel iconLabel = new JLabel(icon);
            iconLabel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
            panel.add(iconLabel, BorderLayout.WEST);

            JOptionPane.showMessageDialog(null, panel, "Error", JOptionPane.ERROR_MESSAGE);
        }


    }//GEN-LAST:event_jButton_Borrar

    private void jTextBuscarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTextBuscarMouseClicked
        jTextBuscar.setText("");
        jTextBuscar.setForeground(Color.black);
    }//GEN-LAST:event_jTextBuscarMouseClicked

    private void jButton_Actualizar1(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_Actualizar1
        String idClienteText = jTextField_Id_Ciente.getText();
        int idCliente = Integer.parseInt(idClienteText);
        String cedula = JtextFiel_Cedula.getText();
        String nombre1 = JtextFiel_Nombre_1.getText();
        String nombre2 = JtextFiel_Nombre_2.getText();
        String apellido1 = jTextFiel_Apellido_1.getText();
        String apellido2 = jTextField_Apellido_2.getText();
        String celular = jFormattedTextFieldTelefono.getText();
        String Gmail = JtextFiel_gmail.getText();
        String direccion = jTextArea_Dirrecion.getText();

        if (jTextField_Id_Ciente.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Tiene datos vacíos");
        } else {
            int option = JOptionPane.showOptionDialog(
                    null,
                    "¿Desea actualizar el cliente?",
                    "Confirmar Actualización",
                    JOptionPane.YES_NO_OPTION,
                    JOptionPane.QUESTION_MESSAGE,
                    new ImageIcon(getClass().getResource("/Vistas_Iconos/actualizar.png")),
                    new Object[]{"Sí", "No"},
                    "No"
            );

            if (option == JOptionPane.YES_OPTION) {
                // Crear objeto Clase_Cliente con los datos obtenidos
                Clase_Cliente cliente = new Clase_Cliente(idCliente, cedula, nombre1, nombre2, apellido1, apellido2, celular, Gmail, direccion);

                // Llamar al método "actualizar" de CRUD_Cliente
                CRUD_Cliente clienteCRUD = new CRUD_Cliente();
                clienteCRUD.actualizar(cliente);

                JPanel panel = new JPanel();
                panel.setLayout(new BorderLayout());

                JLabel messageLabel = new JLabel("Cliente actualizado exitosamente.");
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
        CRUD_Cliente clienteCRUD = new CRUD_Cliente();
        clienteCRUD.mostrarDatos();
        limpiar();
        mostrar();


    }//GEN-LAST:event_jButton_Actualizar1

    private void jTextBuscarKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextBuscarKeyReleased
        BuscarCliente();
    }//GEN-LAST:event_jTextBuscarKeyReleased

    private void jFormattedTextFieldTelefono(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jFormattedTextFieldTelefono
        // TODO add your handling code here:
    }//GEN-LAST:event_jFormattedTextFieldTelefono

    private void JtextFiel_Nombre_1KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_JtextFiel_Nombre_1KeyTyped
        char car = evt.getKeyChar();
        String texto = JtextFiel_Nombre_1.getText(); // Obtener el texto actual en el campo

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
    }//GEN-LAST:event_JtextFiel_Nombre_1KeyTyped

    private void JtextFiel_Nombre_2KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_JtextFiel_Nombre_2KeyTyped
        char car = evt.getKeyChar();
        String texto = JtextFiel_Nombre_2.getText(); // Obtener el texto actual en el campo

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
    }//GEN-LAST:event_JtextFiel_Nombre_2KeyTyped

    private void jTextFiel_Apellido_1KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFiel_Apellido_1KeyTyped
        char car = evt.getKeyChar();
        String texto = jTextFiel_Apellido_1.getText(); // Obtener el texto actual en el campo

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
    }//GEN-LAST:event_jTextFiel_Apellido_1KeyTyped

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

    private void jTextArea_DirrecionKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextArea_DirrecionKeyTyped
        String texto = jTextArea_Dirrecion.getText();

        if (texto.length() >= 200) {
            evt.consume();
        }
    }//GEN-LAST:event_jTextArea_DirrecionKeyTyped

    private void jButton_ReportMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton_ReportMouseClicked
         Conexion con = new Conexion();
        Connection cn = (Connection) con.conectar();

 
        String path = "C:\\Users\\Diers\\OneDrive\\Escritorio\\CasoFarmacia\\Repositorio-Farmacia-Rosales.-main\\src\\Vistas_Reportes\\report1.jrxml";
        JasperReport jr;
        try {
            jr = JasperCompileManager.compileReport(path);
            JasperPrint mostrarReporte = JasperFillManager.fillReport(jr, null, cn);
            JasperViewer.viewReport(mostrarReporte,false);

        } catch (JRException e) {
            JOptionPane.showMessageDialog(null, e);
        }

    }//GEN-LAST:event_jButton_ReportMouseClicked

    private void JtextFiel_Cedula(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JtextFiel_Cedula
        // TODO add your handling code here:
    }//GEN-LAST:event_JtextFiel_Cedula

    private void JtextFiel_CedulaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_JtextFiel_CedulaKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_JtextFiel_CedulaKeyTyped

    private void JtextFiel_gmail(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JtextFiel_gmail
        // TODO add your handling code here:
    }//GEN-LAST:event_JtextFiel_gmail

    private void JtextFiel_gmailKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_JtextFiel_gmailKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_JtextFiel_gmailKeyTyped

    private void jTextField_Id_Ciente(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField_Id_Ciente
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField_Id_Ciente

    private void jButton_ReportActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_ReportActionPerformed
      
    }//GEN-LAST:event_jButton_ReportActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField JtextFiel_Cedula;
    private javax.swing.JTextField JtextFiel_Nombre_1;
    private javax.swing.JTextField JtextFiel_Nombre_2;
    private javax.swing.JTextField JtextFiel_gmail;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton_Actualizar1;
    private javax.swing.JButton jButton_Borrar;
    private javax.swing.JButton jButton_Editar;
    private javax.swing.JButton jButton_Report;
    private javax.swing.JFormattedTextField jFormattedTextFieldTelefono;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable_Cliente;
    private javax.swing.JTextArea jTextArea_Dirrecion;
    private javax.swing.JTextField jTextBuscar;
    private javax.swing.JTextField jTextFiel_Apellido_1;
    private javax.swing.JTextField jTextField_Apellido_2;
    private javax.swing.JTextField jTextField_Id_Ciente;
    // End of variables declaration//GEN-END:variables
}
