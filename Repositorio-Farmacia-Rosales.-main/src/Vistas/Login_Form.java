package Vistas;

import Controlador_Conexion_DB.Conexion;
import Modelo.Login;
import Modelo_MDI1.MDI_Farmacia1;
import Modelo_MDI1.MDI_Farmacia11;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JOptionPane;

import java.sql.Connection;


/**
 *
 * @author Diers
 */
public class Login_Form extends javax.swing.JFrame {

    private Connection cn;
     private String rol;
    
    

    public Login_Form() {
        initComponents();
        Conexion conexion = new Conexion();
        cn = conexion.conectar();
    }
    private static void centerLoginForm(Login_Form loginForm) {
        // Obtener el tamaño de la pantalla
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();

        // Obtener el tamaño del formulario de inicio de sesión
        Dimension loginFormSize = loginForm.getSize();

        // Calcular la posición para centrar el formulario
        int x = (screenSize.width - loginFormSize.width) / 2;
        int y = (screenSize.height - loginFormSize.height) / 2;

        // Establecer la posición del formulario en el centro de la pantalla
        loginForm.setLocation(x, y);
    }
    public String getRol() { // Agregar este método
        return rol;
    }

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel8 = new javax.swing.JPanel();
        jPanel9 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jCheckBox1 = new javax.swing.JCheckBox();
        jLabel5 = new javax.swing.JLabel();
        jComboBox_Rol = new javax.swing.JComboBox<>();
        jTextField_Contraseña = new javax.swing.JTextField();
        jComboBox_Usuario = new javax.swing.JComboBox<>();
        jButton_Iniciar_sesion = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));

        jPanel8.setBackground(new java.awt.Color(255, 255, 255));

        jPanel9.setBackground(new java.awt.Color(0, 153, 153));

        jLabel3.setBackground(new java.awt.Color(0, 153, 153));
        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Farmacia Rosales");
        jLabel3.setOpaque(true);

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addGap(45, 45, 45)
                .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, 338, Short.MAX_VALUE)
                .addGap(40, 40, 40))
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(15, Short.MAX_VALUE))
        );

        jLabel1.setBackground(new java.awt.Color(0, 153, 153));
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Vistas_Iconos/avatar.png"))); // NOI18N
        jLabel1.setOpaque(true);

        jLabel2.setBackground(new java.awt.Color(0, 153, 153));
        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Vistas_Iconos/cerrar-con-llave.png"))); // NOI18N
        jLabel2.setOpaque(true);

        jCheckBox1.setForeground(new java.awt.Color(0, 153, 153));
        jCheckBox1.setText("Recordar Contraseña!");

        jLabel5.setBackground(new java.awt.Color(255, 255, 255));
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Vistas_Iconos/borrar.png"))); // NOI18N
        jLabel5.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel5.setOpaque(true);

        jComboBox_Rol.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Gerente", "Vendedor" }));
        jComboBox_Rol.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Rol", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 14))); // NOI18N
        jComboBox_Rol.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox_Rol(evt);
            }
        });

        jTextField_Contraseña.setForeground(new java.awt.Color(0, 153, 153));
        jTextField_Contraseña.setText("Contraseña");
        jTextField_Contraseña.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Contraseña", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 14))); // NOI18N
        jTextField_Contraseña.setName("Usuario"); // NOI18N
        jTextField_Contraseña.setOpaque(true);
        jTextField_Contraseña.setSelectedTextColor(new java.awt.Color(0, 153, 153));
        jTextField_Contraseña.setSelectionColor(new java.awt.Color(0, 153, 153));
        jTextField_Contraseña.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField_Contraseña(evt);
            }
        });

        jComboBox_Usuario.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Gerente", "Vendedor" }));
        jComboBox_Usuario.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Usuario", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 14))); // NOI18N
        jComboBox_Usuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox_Usuario(evt);
            }
        });

        jButton_Iniciar_sesion.setBackground(new java.awt.Color(51, 51, 255));
        jButton_Iniciar_sesion.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jButton_Iniciar_sesion.setText("Iniciar Sesion");
        jButton_Iniciar_sesion.setBorder(javax.swing.BorderFactory.createCompoundBorder(javax.swing.BorderFactory.createEmptyBorder(30, 30, 30, 30), javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 255, 255))));
        jButton_Iniciar_sesion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_Iniciar_sesion(evt);
            }
        });

        jLabel6.setBackground(new java.awt.Color(0, 153, 153));
        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Vistas_Iconos/Rol.png"))); // NOI18N
        jLabel6.setOpaque(true);

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel8Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel5))
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addGap(34, 34, 34)
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jCheckBox1)
                            .addGroup(jPanel8Layout.createSequentialGroup()
                                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel1)
                                    .addComponent(jLabel6))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jComboBox_Rol, javax.swing.GroupLayout.Alignment.TRAILING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jComboBox_Usuario, 0, 236, Short.MAX_VALUE)
                                    .addComponent(jTextField_Contraseña))))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGap(106, 106, 106)
                .addComponent(jButton_Iniciar_sesion, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(3, 3, 3)
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel8Layout.createSequentialGroup()
                                .addGap(27, 27, 27)
                                .addComponent(jLabel1))
                            .addGroup(jPanel8Layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(jComboBox_Usuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(68, 68, 68)
                        .addComponent(jLabel2))
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextField_Contraseña, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jCheckBox1)
                .addGap(18, 18, 18)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jComboBox_Rol, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 50, Short.MAX_VALUE)
                .addComponent(jButton_Iniciar_sesion, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(32, 32, 32))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 435, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 500, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jComboBox_Rol(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox_Rol
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBox_Rol

    private void jTextField_Contraseña(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField_Contraseña
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField_Contraseña

    private void jComboBox_Usuario(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox_Usuario
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBox_Usuario

    private void jButton_Iniciar_sesion(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_Iniciar_sesion
      String usuario = jComboBox_Usuario.getSelectedItem().toString();
    String contraseña = jTextField_Contraseña.getText();

    if (cn != null) {
        if (Login.validarCredenciales(cn, usuario, contraseña)) {
            rol = Login.obtenerRol(cn, usuario); // Asignar el valor del rol

            if (rol.equals("Gerente")) {
                // Redirigir al MDI_Farmacia1
                MDI_Farmacia1 mdiFarmacia1 = new MDI_Farmacia1();
                mdiFarmacia1.setVisible(true);
            } else if (rol.equals("Vendedor")) {
                // Redirigir al MDI_Farmacia11
                MDI_Farmacia11 mdiFarmacia11 = new MDI_Farmacia11();
                mdiFarmacia11.setVisible(true);
            }

            // Cerrar la ventana de inicio de sesión
            dispose();
        } else {
            // Mostrar mensaje de error
            JOptionPane.showMessageDialog(this, "Credenciales inválidas. Por favor, inténtalo de nuevo.", "Error de inicio de sesión", JOptionPane.ERROR_MESSAGE);
        }
    }


    }//GEN-LAST:event_jButton_Iniciar_sesion

    public static void main(String args[]) {
    // Crear una instancia del formulario de inicio de sesión
        Login_Form loginForm = new Login_Form();

        // Mostrar el formulario de inicio de sesión primero
        loginForm.setVisible(true);

        // Esperar hasta que el formulario de inicio de sesión se cierre
        loginForm.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosed(WindowEvent e) {
                // Una vez que el formulario de inicio de sesión se cierre, mostrar el MDI o la ventana principal

            }
        });
    }



    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton_Iniciar_sesion;
    private javax.swing.JCheckBox jCheckBox1;
    private javax.swing.JComboBox<String> jComboBox_Rol;
    private javax.swing.JComboBox<String> jComboBox_Usuario;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JTextField jTextField_Contraseña;
    // End of variables declaration//GEN-END:variables
}
