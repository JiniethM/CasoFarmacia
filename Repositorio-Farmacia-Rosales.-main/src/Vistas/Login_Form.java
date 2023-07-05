package Vistas;

import Controlador_Conexion_DB.Conexion;
import Modelo.Login;
import Modelo_MDI1.MDIMenu;
import Modelo_MDI1.MDIMenu1;
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
         centerLoginForm(this);
         setVisible(true);
        
    }

    private static void centerLoginForm(Login_Form loginForm) {
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();

        Dimension loginFormSize = loginForm.getSize();

        int x = (screenSize.width - loginFormSize.width) / 2;
        int y = (screenSize.height - loginFormSize.height) / 2;

        loginForm.setLocation(x, y);
    }

    public String getRol() {
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

        jComboBox_Rol.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Gerente", "Vendedor" }));
        jComboBox_Rol.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Rol", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 14))); // NOI18N
        jComboBox_Rol.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox_Rol(evt);
            }
        });

        jTextField_Contraseña.setForeground(new java.awt.Color(0, 153, 153));
        jTextField_Contraseña.setText("Contraseña1");
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

        jButton_Iniciar_sesion.setBackground(new java.awt.Color(0, 153, 153));
        jButton_Iniciar_sesion.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jButton_Iniciar_sesion.setForeground(new java.awt.Color(255, 255, 255));
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
                .addContainerGap(109, Short.MAX_VALUE))
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGap(106, 106, 106)
                .addComponent(jButton_Iniciar_sesion, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(54, 54, 54)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel8Layout.createSequentialGroup()
                                .addGap(9, 9, 9)
                                .addComponent(jLabel1))
                            .addComponent(jComboBox_Usuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(68, 68, 68)
                        .addComponent(jLabel2))
                    .addComponent(jTextField_Contraseña, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
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
                MDIMenu farmacia = new MDIMenu();
                farmacia.setVisible(true);
            } else if (rol.equals("Vendedor")) {
                MDIMenu1 farmacia1 = new MDIMenu1();
                farmacia1.setVisible(true);
            }

            dispose(); // Cerrar el formulario de inicio de sesión
        } else {
            JOptionPane.showMessageDialog(this, "Contraseña incorrecta. Por favor, inténtalo de nuevo.", "Error de inicio de sesión", JOptionPane.ERROR_MESSAGE);
        }
    }


    }//GEN-LAST:event_jButton_Iniciar_sesion

    public static void main(String args[]) {
        Login_Form loginForm = new Login_Form();
        loginForm.setVisible(true);

        loginForm.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosed(WindowEvent e) {
         

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
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JTextField jTextField_Contraseña;
    // End of variables declaration//GEN-END:variables
}
