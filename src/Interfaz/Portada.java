/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Pabos95
 */
package Interfaz;
import SimulacionIO.*;
public class Portada extends javax.swing.JFrame {
    VentanaParametros vp;
    VentanaEjecucion ve;
    Boolean continuar;
    Boolean salir;
    /**
     * Creates new form Portada
     */
    public Portada() {
        vp = new VentanaParametros();
        ve = new VentanaEjecucion();
        continuar = false;
        salir = false;
        initComponents();
        this.setLocationRelativeTo(null);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        Continuar = new javax.swing.JButton();
        Salir = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        setPreferredSize(new java.awt.Dimension(522, 402));
        setResizable(false);
        getContentPane().setLayout(null);

        jLabel1.setFont(new java.awt.Font("AR JULIAN", 0, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(169, 140, 102));
        jLabel1.setText("Simulacion DBMS");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(140, 20, 170, 90);

        Continuar.setBackground(java.awt.SystemColor.controlHighlight);
        Continuar.setFont(new java.awt.Font("Tahoma", 3, 11)); // NOI18N
        Continuar.setForeground(new java.awt.Color(255, 153, 0));
        Continuar.setText("Continuar");
        Continuar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ContinuarMouseClicked(evt);
            }
        });
        Continuar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ContinuarActionPerformed(evt);
            }
        });
        getContentPane().add(Continuar);
        Continuar.setBounds(120, 300, 90, 23);

        Salir.setFont(new java.awt.Font("Tahoma", 3, 11)); // NOI18N
        Salir.setForeground(new java.awt.Color(255, 153, 51));
        Salir.setText("Salir");
        Salir.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                SalirMouseClicked(evt);
            }
        });
        Salir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SalirActionPerformed(evt);
            }
        });
        getContentPane().add(Salir);
        Salir.setBounds(270, 300, 80, 23);
        getContentPane().add(jLabel2);
        jLabel2.setBounds(0, 0, 520, 400);
        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/White-Abstract-background-1.jpg")));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void ContinuarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ContinuarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ContinuarActionPerformed

    private void SalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SalirActionPerformed
        // TODO add your handling code here:
     
    }//GEN-LAST:event_SalirActionPerformed

    private void ContinuarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ContinuarMouseClicked
        // TODO add your handling code here:  
        continuar = true;
       setVisible(false);
        getVP().setVisible(true);

    }//GEN-LAST:event_ContinuarMouseClicked

    private void SalirMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_SalirMouseClicked
        // TODO add your handling code here:
        System.exit(0);
    }//GEN-LAST:event_SalirMouseClicked
    public VentanaParametros getVP(){
        return this.vp;
    }
    public VentanaEjecucion  getVE(){
        return this.ve;
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Portada.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Portada.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Portada.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Portada.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>*/
       
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
           public void run() {
               
                 }
       });
       Portada p;
       Simulacion s;
                 p =new Portada();
                 p.setVisible(true); 
        while(true){
            if(p.continuar == true){
                while(true){
                    if(p.getVP().getSimulacionLlamada() == true){
                        p.getVP().setVisible(false);
                        p.getVP().dispose();
                        p.getVE().setVisible(true);
                        s = p.getVP().getSimulacion();             
                        s.setVentana(p.getVE());
                        s.procesarSimulacion();
                       p.getVP().setSimulacionLlamada(false);
                    }
                }
            }
        }
    }
     
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Continuar;
    private javax.swing.JButton Salir;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    // End of variables declaration//GEN-END:variables
}
