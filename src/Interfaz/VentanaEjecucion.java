/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaz;
import javax.swing.*;
import java.awt.*;
/**
 *
 * @author Pabos95
 */
public class VentanaEjecucion extends javax.swing.JFrame {

    /**
     * Creates new form VentanaEjecucion
     */
    public VentanaEjecucion() {
        initComponents();
      
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        TiempoEjecucion = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        LongitudModAdministracionConsultas = new javax.swing.JTextField();
        NumConexionesDescartadas = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        LongitudModAdministracionTransacciones = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        LongitudModAdministracionProcesos = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        LongitudColaEjecucionModAdmConsultas = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(640, 511));

        jPanel1.setBackground(java.awt.Color.lightGray);
        jPanel1.setPreferredSize(new java.awt.Dimension(560, 540));
        jPanel1.setLayout(null);

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Tiempo de ejecucion:");
        this.add(jLabel1);
        jPanel1.add(jLabel1);
        jLabel1.setBounds(32, 14, 370, 17);

        TiempoEjecucion.setEditable(false);
        jPanel1.add(TiempoEjecucion);
        TiempoEjecucion.setBounds(420, 20, 210, 20);

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Longitud cola modulo administracion consultas: ");
        jPanel1.add(jLabel2);
        jLabel2.setBounds(20, 50, 390, 17);

        LongitudModAdministracionConsultas.setEditable(false);
        jPanel1.add(LongitudModAdministracionConsultas);
        LongitudModAdministracionConsultas.setBounds(420, 50, 210, 20);

        NumConexionesDescartadas.setEditable(false);
        jPanel1.add(NumConexionesDescartadas);
        NumConexionesDescartadas.setBounds(410, 230, 220, 20);

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Conexiones descartadas por el servidor:");
        jPanel1.add(jLabel7);
        jLabel7.setBounds(30, 230, 380, 17);

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Longitud cola modulo administracion transacciones: ");
        jPanel1.add(jLabel5);
        jLabel5.setBounds(10, 140, 400, 17);

        LongitudModAdministracionTransacciones.setEditable(false);
        jPanel1.add(LongitudModAdministracionTransacciones);
        LongitudModAdministracionTransacciones.setBounds(418, 140, 210, 20);

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Longitud cola modulo administracion procesos: ");
        jPanel1.add(jLabel6);
        jLabel6.setBounds(20, 102, 390, 20);

        LongitudModAdministracionProcesos.setEditable(false);
        jPanel1.add(LongitudModAdministracionProcesos);
        LongitudModAdministracionProcesos.setBounds(418, 100, 210, 20);

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Longitud segunda cola modulo administracion consultas:");
        jPanel1.add(jLabel8);
        jLabel8.setBounds(10, 180, 400, 33);

        LongitudColaEjecucionModAdmConsultas.setEditable(false);
        jPanel1.add(LongitudColaEjecucionModAdmConsultas);
        LongitudColaEjecucionModAdmConsultas.setBounds(418, 180, 210, 20);

        jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/geometric-background.png")));
        jPanel1.add(jLabel9);
        jLabel9.setBounds(-33, -119, 670, 740);

        org.jdesktop.layout.GroupLayout layout = new org.jdesktop.layout.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(org.jdesktop.layout.GroupLayout.TRAILING, jPanel1, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 640, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(org.jdesktop.layout.GroupLayout.TRAILING, jPanel1, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 511, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void TiempoEjecucionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TiempoEjecucionActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TiempoEjecucionActionPerformed
    
    
    /**
     * @param args the command line arguments
     */
  public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        /*try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(VentanaEjecucion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VentanaEjecucion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VentanaEjecucion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VentanaEjecucion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VentanaEjecucion().setVisible(true);
            }
        });
    }
 
   public void actualizarLongitudModAdministracionConsultas(int nuevaLong){       
     LongitudModAdministracionConsultas.setText(String.valueOf(nuevaLong));
   }
 public void actualizarLongitudModAdministracionProcesos(int nuevaLong){
       LongitudModAdministracionProcesos.setText(String.valueOf(nuevaLong));
   }
   public void actualizarLongitudModAdministracionTransacciones(int nuevaLong){
       LongitudModAdministracionTransacciones.setText(String.valueOf(nuevaLong));
    }
   public void actualizarTiempoActual(double nuevoTiempo){
       TiempoEjecucion.setText(String.valueOf(nuevoTiempo));
    }
   public void actualizarNumConexionesDescartadas(int nuevoNum){
       NumConexionesDescartadas.setText(String.valueOf(nuevoNum));
    }
   public void actualizarLongitudColaEjecucionModAdmConsultas(int nuevoNum){
       LongitudColaEjecucionModAdmConsultas.setText(String.valueOf(nuevoNum));
   }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField LongitudColaEjecucionModAdmConsultas;
    private javax.swing.JTextField LongitudModAdministracionConsultas;
    private javax.swing.JTextField LongitudModAdministracionProcesos;
    private javax.swing.JTextField LongitudModAdministracionTransacciones;
    private javax.swing.JTextField NumConexionesDescartadas;
    private javax.swing.JTextField TiempoEjecucion;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}
