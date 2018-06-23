/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaz;
import javax.swing.*;
import SimulacionIO.*;
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
        getContentPane().setLayout(new BorderLayout());
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
        TiempoActual = new javax.swing.JTextField();
        LongitudModAdministracionConsultas = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        LongitudModAdministracionClientes = new javax.swing.JTextField();
        LongitudModAdministracionTransacciones = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        LongitudModAdministracionProcesos = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        NumConexionesDescartadas = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("EjecucionSimulacion");
        setBackground(java.awt.Color.lightGray);
        setMaximizedBounds(new java.awt.Rectangle(200, 200, 450, 450));
        setSize(new java.awt.Dimension(450, 450));

        jLabel1.setText("TiempoActual :");

        TiempoActual.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TiempoActualActionPerformed(evt);
            }
        });

        LongitudModAdministracionConsultas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LongitudModAdministracionConsultasActionPerformed(evt);
            }
        });

        jLabel2.setText("Longitud cola modulo administracion consultas");

        jLabel3.setText("Longitud cola modulo administracion clientes");

        LongitudModAdministracionClientes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LongitudModAdministracionClientesActionPerformed(evt);
            }
        });

        LongitudModAdministracionTransacciones.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LongitudModAdministracionTransaccionesActionPerformed(evt);
            }
        });

        jLabel4.setText("Longitud cola modulo administracion transacciones");

        LongitudModAdministracionProcesos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LongitudModAdministracionProcesosActionPerformed(evt);
            }
        });

        jLabel5.setText("Longitud cola modulo administracion procesos");

        jLabel6.setText("Numero de conexiones descartadas");

        NumConexionesDescartadas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NumConexionesDescartadasActionPerformed(evt);
            }
        });

        org.jdesktop.layout.GroupLayout layout = new org.jdesktop.layout.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(jLabel3)
                    .add(layout.createSequentialGroup()
                        .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                            .add(jLabel2)
                            .add(layout.createSequentialGroup()
                                .add(58, 58, 58)
                                .add(jLabel1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 104, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)))
                        .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                            .add(TiempoActual, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 96, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                            .add(LongitudModAdministracionClientes, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 96, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                            .add(layout.createSequentialGroup()
                                .add(18, 18, 18)
                                .add(LongitudModAdministracionConsultas, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 96, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .add(org.jdesktop.layout.GroupLayout.TRAILING, layout.createSequentialGroup()
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(org.jdesktop.layout.GroupLayout.TRAILING, layout.createSequentialGroup()
                        .add(jLabel4)
                        .add(1, 1, 1))
                    .add(org.jdesktop.layout.GroupLayout.TRAILING, layout.createSequentialGroup()
                        .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.TRAILING, false)
                            .add(jLabel5, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .add(jLabel6, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)))
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING, false)
                    .add(LongitudModAdministracionTransacciones, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 96, Short.MAX_VALUE)
                    .add(LongitudModAdministracionProcesos, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 96, Short.MAX_VALUE)
                    .add(NumConexionesDescartadas))
                .add(63, 63, 63))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .addContainerGap()
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(jLabel1)
                    .add(TiempoActual, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(jLabel3)
                    .add(LongitudModAdministracionClientes, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .add(27, 27, 27)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(jLabel2)
                    .add(LongitudModAdministracionConsultas, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .add(18, 18, 18)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(LongitudModAdministracionTransacciones, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(jLabel4))
                .add(18, 18, 18)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(LongitudModAdministracionProcesos, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(jLabel5))
                .add(18, 18, 18)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(jLabel6)
                    .add(NumConexionesDescartadas, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(22, Short.MAX_VALUE))
        );

        getAccessibleContext().setAccessibleParent(this);

        setBounds(0, 0, 416, 279);
    }// </editor-fold>//GEN-END:initComponents

    private void TiempoActualActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TiempoActualActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TiempoActualActionPerformed

    private void LongitudModAdministracionConsultasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LongitudModAdministracionConsultasActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_LongitudModAdministracionConsultasActionPerformed

    private void LongitudModAdministracionClientesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LongitudModAdministracionClientesActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_LongitudModAdministracionClientesActionPerformed

    private void LongitudModAdministracionTransaccionesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LongitudModAdministracionTransaccionesActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_LongitudModAdministracionTransaccionesActionPerformed

    private void LongitudModAdministracionProcesosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LongitudModAdministracionProcesosActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_LongitudModAdministracionProcesosActionPerformed

    private void NumConexionesDescartadasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NumConexionesDescartadasActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_NumConexionesDescartadasActionPerformed
    public void actualizarLongitudModAdministracionClientes(int nuevaLong){
        LongitudModAdministracionClientes.setText(String.valueOf(nuevaLong));
    }
   /* public void actualizarLongitudModAdministracionConexiones(int nuevaLong){
        LongitudModAdministracionConexiones.setText(String.valueOf(nuevaLong));
    }*/
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
        TiempoActual.setText(String.valueOf(nuevoTiempo));
    }
    public void actualizarNumConexionesDescartadas(int nuevoNum){
       NumConexionesDescartadas.setText(String.valueOf(nuevoNum));
    }
    /**
     * @param args the command line arguments
     */
 public static void main(String args[]) {
        /*Set the Nimbus look and feel */
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
               
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField LongitudModAdministracionClientes;
    private javax.swing.JTextField LongitudModAdministracionConsultas;
    private javax.swing.JTextField LongitudModAdministracionProcesos;
    private javax.swing.JTextField LongitudModAdministracionTransacciones;
    private javax.swing.JTextField NumConexionesDescartadas;
    private javax.swing.JTextField TiempoActual;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    // End of variables declaration//GEN-END:variables
}
