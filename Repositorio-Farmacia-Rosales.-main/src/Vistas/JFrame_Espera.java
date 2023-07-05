
package Vistas;


import javax.swing.JFrame;

/**
 *
 * @author Diers
 */
public class JFrame_Espera extends javax.swing.JFrame {

    
    public JFrame_Espera() {
        
        initComponents();
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setVisible(true);
        cargarProyecto();
        
        
    
    }
    private void cargarProyecto() {
        // Crear un hilo separado para la simulación de carga del proyecto
        Thread cargaThread = new Thread(new Runnable() {
            public void run() {
                // Simulación de carga del proyecto (sustituir con la lógica real de carga)
                try {
                    Thread.sleep(3000); // Espera de 3 segundos
                } catch (InterruptedException ex) {
                    ex.printStackTrace();
                }

                // Después de la carga, mostrar el formulario de inicio de sesión y cerrar el formulario de espera
                java.awt.EventQueue.invokeLater(new Runnable() {
                    public void run() {
                        Login_Form loginForm = new Login_Form();
                        loginForm.setLocationRelativeTo(null);
                        loginForm.setVisible(true);
                        dispose(); // Cerrar el formulario de espera
                    }
                });
            }
        });

        cargaThread.start(); // Iniciar el hilo de carga
    }

    

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Vistas_Imagenes/Fondo logo.png"))); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    
    public static void main(String args[]) {        
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                JFrame_Espera frameEspera = new JFrame_Espera();
                frameEspera.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    // End of variables declaration//GEN-END:variables
}
