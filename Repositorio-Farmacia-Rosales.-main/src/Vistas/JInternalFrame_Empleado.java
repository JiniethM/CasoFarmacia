
package Vistas;
import Controlador_Conexion_DB.Conexion;
import Controlador.*;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.HeadlessException;
import java.sql.CallableStatement;
import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.border.Border;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;


/**
 *
 * @author diedr
 */
public class JInternalFrame_Empleado extends javax.swing.JInternalFrame {
        private JPanel panel;
     public final Conexion con = new Conexion();
    public  final Connection cn = (Connection) con.conectar();
    
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
    }
    public void limpiar (){
    jTextNombre1.setText("");
    jTextNombre2.setText("");
    jTextApellido1.setText("");
    jTextApellido2.setText("");
    jTexTelefono.setText("");
    jTextGmail.setText("");
    jTextADirecion.setText("");
    jTexthoraentra.setText("");
    jTexthorasal.setText("");
}
    public void guardarEmple(){
        CRUD_Empleado bl = new CRUD_Empleado();
   String Nombre_1 = jTextNombre1.getText();
   String Nombre_2 = jTextNombre2.getText();
   String Apellido_1 = jTextApellido1.getText();
   String Apellido_2 = jTextApellido2.getText();
   String Numero_Celular = jTexTelefono.getText();
   String Gmail = jTextGmail.getText();
   String Direccion = jTextADirecion.getText();
   String horaEntradaStr = jTexthoraentra.getText();
java.sql.Time horaEntrada = java.sql.Time.valueOf(horaEntradaStr);
   String horaSalidaStr = jTexthorasal.getText();
java.sql.Time horaSalida = java.sql.Time.valueOf(horaSalidaStr);

Clase_Empleado bla = new Clase_Empleado (Nombre_1, Nombre_2, Apellido_1, Apellido_2, Numero_Celular, Gmail, Direccion, horaEntrada, horaSalida);
    bl.Guardar(bla);
    }
  
    public void mostrar() {
        try {
            DefaultTableModel modelo;
            CRUD_Empleado blas = new CRUD_Empleado();
            modelo = blas.mostrarDatos();
            jTableEmpleado.setModel(modelo);
            
        } catch (Exception e) {
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
        jTexTelefono = new javax.swing.JTextField();
        jTextGmail = new javax.swing.JTextField();
        jPanel3 = new javax.swing.JPanel();
        jLabel12 = new javax.swing.JLabel();
        jTexthoraentra = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jTexthorasal = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTableEmpleado = new javax.swing.JTable();
        Buscar = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        Editar = new javax.swing.JButton();
        Actualizar = new javax.swing.JButton();
        Borrar = new javax.swing.JButton();
        jPanel7 = new javax.swing.JPanel();
        jButton5 = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();
        jButton11 = new javax.swing.JButton();
        jButton12 = new javax.swing.JButton();
        jButton10 = new javax.swing.JButton();
        jButton13 = new javax.swing.JButton();

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
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 60, -1, -1));

        jTextIdEmpleado.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextIdEmpleado.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        jTextIdEmpleado.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        jTextIdEmpleado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField_id_empleado(evt);
            }
        });
        jPanel1.add(jTextIdEmpleado, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 60, 190, -1));

        jTextBuscar.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        jTextBuscar.setForeground(new java.awt.Color(153, 153, 153));
        jTextBuscar.setText("Buscar");
        jTextBuscar.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        jTextBuscar.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        jPanel1.add(jTextBuscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 60, 170, -1));

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

        jTextNombre2.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextNombre2.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        jTextNombre2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nombre_2TextField(evt);
            }
        });

        jTextApellido1.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextApellido1.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        jTextApellido1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                apellido_1TextField(evt);
            }
        });

        jTextApellido2.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextApellido2.setText("DiedrinzonFargas");
        jTextApellido2.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        jTextApellido2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                apellido_2TextField(evt);
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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 27, Short.MAX_VALUE)
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

        jPanel1.add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 100, -1, 70));

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
        jScrollPane1.setViewportView(jTextADirecion);

        jTexTelefono.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTexTelefono.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        jTexTelefono.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTexTelefononombre_2TextField(evt);
            }
        });

        jTextGmail.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextGmail.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        jTextGmail.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextGmailnombre_2TextField(evt);
            }
        });

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jTexTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGap(28, 28, 28)
                        .addComponent(jLabel8)))
                .addGap(46, 46, 46)
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
                        .addComponent(jTexTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jTextGmail, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel1.add(jPanel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 180, 660, 90));

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

        jLabel10.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(0, 153, 153));
        jLabel10.setText("Hora de Salida");

        jTexthorasal.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jTexthorasal.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTexthorasal.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createTitledBorder(null, "", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Dialog", 1, 14)), "", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Dialog", 1, 14))); // NOI18N
        jTexthorasal.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        jTexthorasal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                hora_Salida_TextField(evt);
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

        jPanel1.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 280, 280, 60));

        jTableEmpleado.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "ID Empleado", "Nombre 1", "Nombre 2", "Apellido 1", "Apellido 2", "Direccion", "Gmail", "Numero Telefono", "Foto", "Hora Entrada", "Hora Salida"
            }
        ));
        jTableEmpleado.setGridColor(new java.awt.Color(0, 153, 153));
        jTableEmpleado.setSelectionBackground(new java.awt.Color(204, 204, 204));
        jTableEmpleado.setSelectionForeground(new java.awt.Color(204, 204, 204));
        jTableEmpleado.setShowGrid(true);
        jScrollPane2.setViewportView(jTableEmpleado);

        jPanel1.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 360, 870, 130));

        Buscar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Vistas_Iconos/Buscar.png"))); // NOI18N
        Buscar.setBorder(null);
        Buscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BuscarActionPerformed(evt);
            }
        });
        jPanel1.add(Buscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 60, 20, 20));

        jButton6.setBackground(new java.awt.Color(0, 153, 153));
        jButton6.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jButton6.setForeground(new java.awt.Color(255, 255, 255));
        jButton6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Vistas_Iconos/agregar-usuario.png"))); // NOI18N
        jButton6.setText("Agregar");
        jButton6.setBorder(javax.swing.BorderFactory.createEtchedBorder(javax.swing.border.EtchedBorder.RAISED));
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                guardar_empleado(evt);
            }
        });
        jPanel1.add(jButton6, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 90, 100, -1));

        Editar.setBackground(new java.awt.Color(0, 153, 153));
        Editar.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        Editar.setForeground(new java.awt.Color(255, 255, 255));
        Editar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Vistas_Iconos/Editar Usuario.png"))); // NOI18N
        Editar.setText("Editar");
        Editar.setBorder(javax.swing.BorderFactory.createEtchedBorder(javax.swing.border.EtchedBorder.RAISED));
        Editar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EditarActionPerformed(evt);
            }
        });
        jPanel1.add(Editar, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 150, 100, -1));

        Actualizar.setBackground(new java.awt.Color(0, 153, 153));
        Actualizar.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        Actualizar.setForeground(new java.awt.Color(255, 255, 255));
        Actualizar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Vistas_Iconos/Actualizar uduario.png"))); // NOI18N
        Actualizar.setText("Actualizar");
        Actualizar.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        Actualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ActualizarActionPerformed(evt);
            }
        });
        jPanel1.add(Actualizar, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 210, 100, -1));

        Borrar.setBackground(new java.awt.Color(0, 153, 153));
        Borrar.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        Borrar.setForeground(new java.awt.Color(255, 255, 255));
        Borrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Vistas_Iconos/Eliminar usuario.png"))); // NOI18N
        Borrar.setText("Eliminar");
        Borrar.setBorder(javax.swing.BorderFactory.createEtchedBorder(javax.swing.border.EtchedBorder.RAISED));
        Borrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BorrarActionPerformed(evt);
            }
        });
        jPanel1.add(Borrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 280, 100, 40));

        jPanel7.setBackground(new java.awt.Color(0, 153, 153));

        jButton5.setBackground(new java.awt.Color(0, 153, 153));
        jButton5.setFont(new java.awt.Font("Dialog", 1, 13)); // NOI18N
        jButton5.setForeground(new java.awt.Color(255, 255, 255));
        jButton5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Vistas_Iconos/casa.png"))); // NOI18N
        jButton5.setText("Inicio");
        jButton5.setBorder(javax.swing.BorderFactory.createEtchedBorder(javax.swing.border.EtchedBorder.RAISED));
        jButton5.setBorderPainted(false);
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jButton7.setBackground(new java.awt.Color(0, 153, 153));
        jButton7.setFont(new java.awt.Font("Dialog", 1, 13)); // NOI18N
        jButton7.setForeground(new java.awt.Color(255, 255, 255));
        jButton7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Vistas_Iconos/anadir.png"))); // NOI18N
        jButton7.setText("Cliente");
        jButton7.setBorder(javax.swing.BorderFactory.createEtchedBorder(javax.swing.border.EtchedBorder.RAISED));
        jButton7.setBorderPainted(false);
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });

        jButton11.setBackground(new java.awt.Color(0, 153, 153));
        jButton11.setFont(new java.awt.Font("Dialog", 1, 13)); // NOI18N
        jButton11.setForeground(new java.awt.Color(255, 255, 255));
        jButton11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Vistas_Iconos/anadir-al-carrito.png"))); // NOI18N
        jButton11.setText("Venta");
        jButton11.setBorder(javax.swing.BorderFactory.createEtchedBorder(javax.swing.border.EtchedBorder.RAISED));
        jButton11.setBorderPainted(false);

        jButton12.setBackground(new java.awt.Color(0, 153, 153));
        jButton12.setFont(new java.awt.Font("Dialog", 1, 13)); // NOI18N
        jButton12.setForeground(new java.awt.Color(255, 255, 255));
        jButton12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Vistas_Iconos/frasco-de-pastillas.png"))); // NOI18N
        jButton12.setText("Producto");
        jButton12.setBorder(javax.swing.BorderFactory.createEtchedBorder(javax.swing.border.EtchedBorder.RAISED));
        jButton12.setBorderPainted(false);

        jButton10.setBackground(new java.awt.Color(0, 153, 153));
        jButton10.setFont(new java.awt.Font("Dialog", 1, 13)); // NOI18N
        jButton10.setForeground(new java.awt.Color(255, 255, 255));
        jButton10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Vistas_Iconos/repartidor.png"))); // NOI18N
        jButton10.setText("Proveedor");
        jButton10.setBorder(javax.swing.BorderFactory.createEtchedBorder(javax.swing.border.EtchedBorder.RAISED));
        jButton10.setBorderPainted(false);

        jButton13.setBackground(new java.awt.Color(0, 153, 153));
        jButton13.setFont(new java.awt.Font("Dialog", 1, 13)); // NOI18N
        jButton13.setForeground(new java.awt.Color(255, 255, 255));
        jButton13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Vistas_Iconos/lista-de-la-compra.png"))); // NOI18N
        jButton13.setText("Compra");
        jButton13.setBorder(javax.swing.BorderFactory.createEtchedBorder(javax.swing.border.EtchedBorder.RAISED));
        jButton13.setBorderPainted(false);

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(jButton5)
                .addGap(56, 56, 56)
                .addComponent(jButton7)
                .addGap(57, 57, 57)
                .addComponent(jButton11)
                .addGap(58, 58, 58)
                .addComponent(jButton12)
                .addGap(70, 70, 70)
                .addComponent(jButton10)
                .addGap(70, 70, 70)
                .addComponent(jButton13)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton5)
                    .addComponent(jButton7)
                    .addComponent(jButton11)
                    .addComponent(jButton12)
                    .addComponent(jButton10)
                    .addComponent(jButton13))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel1.add(jPanel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1060, 40));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 1000, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 513, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
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
  CRUD_Empleado gr = new CRUD_Empleado();
  try{
      if((jTextNombre1.getText().equals(""))
              || (jTextNombre2.getText().equals(""))
              || (jTextApellido1.getText().equals(""))
              || (jTextApellido2.getText().equals(""))
              || (jTexTelefono.getText().endsWith(""))
              || (jTextGmail.getText().equals(""))
              || (jTextADirecion.getText().equals(""))
              || (jTexthoraentra.getText().equals(""))
              || (jTexthorasal.getText().equals(""))){
          JOptionPane.showMessageDialog(null, "Tiene datos vacíos");
      } else {
                    guardarEmple();
                    limpiar();
                    JOptionPane.showMessageDialog(null, "Datos Guardados Correctamente");
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

    private void jTexTelefononombre_2TextField(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTexTelefononombre_2TextField
        // TODO add your handling code here:
    }//GEN-LAST:event_jTexTelefononombre_2TextField

    private void jTextGmailnombre_2TextField(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextGmailnombre_2TextField
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextGmailnombre_2TextField

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton7ActionPerformed

    private void BuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BuscarActionPerformed
        try {
         DefaultTableModel modelo;
        CRUD_Empleado br = new CRUD_Empleado();
        modelo = br.buscarDatos(jTextBuscar.getText());
        if (jTextBuscar.getText().equals("Escribe el Id, nombres o apellidos")
       || jTextBuscar.getText().equals("")) {
        JOptionPane.showMessageDialog(null, "Escriba el dato a buscar");
        jTextBuscar.setText("Escribe el Id, nombres o apellidos");
        jTextBuscar.setForeground(Color.GRAY);
        mostrar();
    } else {
           jTableEmpleado.setModel(modelo);
        }
}     catch (Exception e) {
    JOptionPane.showMessageDialog(null, e);
}
    }//GEN-LAST:event_BuscarActionPerformed

    private void ActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ActualizarActionPerformed
    String Nombre_1 = jTextNombre1.getText();
   String Nombre_2 = jTextNombre2.getText();
   String Apellido_1 = jTextApellido1.getText();
   String Apellido_2 = jTextApellido2.getText();
   String Numero_Celular = jTexTelefono.getText();
   String Gmail = jTextGmail.getText();
   String Direccion = jTextADirecion.getText();
   String horaEntradaStr = jTexthoraentra.getText();
    java.sql.Time horaEntrada = java.sql.Time.valueOf(horaEntradaStr);
   String horaSalidaStr = jTexthorasal.getText();
    java.sql.Time horaSalida = java.sql.Time.valueOf(horaSalidaStr);
        
    }//GEN-LAST:event_ActualizarActionPerformed

    private void BorrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BorrarActionPerformed
  int fila = this.jTableEmpleado.getSelectedRow();
    if (fila == -1) {
        JOptionPane.showMessageDialog(null, "Seleccione el registro de la tabla");
    }else {
        int cod = Integer.parseInt(this.jTableEmpleado.getValueAt(fila, 0).toString());
        try {
           CallableStatement cbst = cn.prepareCall("{call EliminarCliente(?)}");
            cbst.setInt(1, cod);
            cbst.executeUpdate();
            
            DefaultTableModel modelo = (DefaultTableModel) jTableEmpleado.getModel();
            modelo.removeRow(fila);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
            }
    
        }
    }//GEN-LAST:event_BorrarActionPerformed

    private void EditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EditarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_EditarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Actualizar;
    private javax.swing.JButton Borrar;
    private javax.swing.JButton Buscar;
    private javax.swing.JButton Editar;
    private javax.swing.JButton jButton10;
    private javax.swing.JButton jButton11;
    private javax.swing.JButton jButton12;
    private javax.swing.JButton jButton13;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
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
    private javax.swing.JPanel jPanel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTableEmpleado;
    private javax.swing.JTextField jTexTelefono;
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
