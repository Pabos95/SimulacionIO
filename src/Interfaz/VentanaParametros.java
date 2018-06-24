/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaz;
import java.text.NumberFormat;
import javax.swing.*;
import SimulacionIO.*;
import java.util.concurrent.TimeUnit;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Toolkit;
import java.awt.Image;
/**
 *
 * @author Pabos95
 */
public class VentanaParametros extends javax.swing.JFrame {
    Boolean modLento;
    Boolean simulacionLlamada;
    Simulacion s;
    Image icon;
    Image img;
    VentanaEjecucion ve;
    ParametrosSimulacion p;
    /**
     * Creates new form VentanaParametros
     */
    public VentanaParametros() {
        ve = new VentanaEjecucion();
        p = new ParametrosSimulacion();
        simulacionLlamada = false;
        modLento = false;
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

        jDialog1 = new javax.swing.JDialog();
        jLabel7 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jDialog2 = new javax.swing.JDialog();
        jPanel1 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        numMaxConexionesConcurrentes = new javax.swing.JTextField();
        numCorridas = new javax.swing.JTextField();
        numProcesosConsultasConcurrentes = new javax.swing.JTextField();
        duracion = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        checkbox1 = new java.awt.Checkbox();
        jLabel8 = new javax.swing.JLabel();
        numProcesosEjecucionTransacciones = new javax.swing.JTextField();
        numProcesosEjecucionConsultas = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        segundosTimeOut = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();

        jDialog1.setSize(new java.awt.Dimension(500, 500));
        jDialog1.setType(java.awt.Window.Type.POPUP);
        jDialog1.getContentPane().setLayout(null);

        jLabel7.setText("Por favor inserte datos validos.");
        jDialog1.getContentPane().add(jLabel7);
        jLabel7.setBounds(10, 70, 360, 50);

        jButton2.setText("OK");
        jButton2.setPreferredSize(new java.awt.Dimension(50, 50));
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jDialog1.getContentPane().add(jButton2);
        jButton2.setBounds(150, 130, 50, 30);

        jDialog2.setTitle("Error al ingresar datos");
        jDialog2.setIconImage(null);

        javax.swing.GroupLayout jDialog2Layout = new javax.swing.GroupLayout(jDialog2.getContentPane());
        jDialog2.getContentPane().setLayout(jDialog2Layout);
        jDialog2Layout.setHorizontalGroup(
            jDialog2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        jDialog2Layout.setVerticalGroup(
            jDialog2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        jDialog2.getAccessibleContext().setAccessibleName("Error");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("SimulacionDBMS");
        setBackground(new java.awt.Color(204, 255, 153));
        setForeground(javax.swing.UIManager.getDefaults().getColor("menu"));
        setPreferredSize(new java.awt.Dimension(1000, 563));

        jPanel1.setBackground(new java.awt.Color(204, 255, 153));
        jPanel1.setDebugGraphicsOptions(javax.swing.DebugGraphics.LOG_OPTION);
        jPanel1.setOpaque(false);
        jPanel1.setPreferredSize(new java.awt.Dimension(1010, 540));
        jPanel1.setLayout(null);

        jLabel4.setBackground(javax.swing.UIManager.getDefaults().getColor("InternalFrame.borderLight"));
        jLabel4.setText("k");
        jPanel1.add(jLabel4);
        jLabel4.setBounds(22, 169, 20, 20);

        jLabel6.setText("d");
        jPanel1.add(jLabel6);
        jLabel6.setBounds(21, 143, 30, 20);

        jLabel5.setText("    n");
        jLabel5.setPreferredSize(new java.awt.Dimension(25, 25));
        jPanel1.add(jLabel5);
        jLabel5.setBounds(10, 77, 27, 25);

        numMaxConexionesConcurrentes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                numMaxConexionesConcurrentesActionPerformed(evt);
            }
        });
        jPanel1.add(numMaxConexionesConcurrentes);
        numMaxConexionesConcurrentes.setBounds(50, 170, 73, 22);

        numCorridas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                numCorridasActionPerformed(evt);
            }
        });
        jPanel1.add(numCorridas);
        numCorridas.setBounds(50, 110, 73, 22);

        numProcesosConsultasConcurrentes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                numProcesosConsultasConcurrentesActionPerformed(evt);
            }
        });
        jPanel1.add(numProcesosConsultasConcurrentes);
        numProcesosConsultasConcurrentes.setBounds(50, 80, 73, 22);

        duracion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                duracionActionPerformed(evt);
            }
        });
        jPanel1.add(duracion);
        duracion.setBounds(50, 140, 73, 22);

        jButton1.setText("Listo");
        jButton1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton1MouseClicked(evt);
            }
        });
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1);
        jButton1.setBounds(320, 490, 59, 25);

        jLabel2.setText("c");
        jPanel1.add(jLabel2);
        jLabel2.setBounds(21, 114, 20, 20);

        jTextArea1.setEditable(false);
        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jTextArea1.setText("n = numeroMaximo de conexiones por minuto\nc = numero de corridas a realizar\nd = tiempo maximo de una corrida \nk = numero de conexiones concurrentes que puede manejar el sistema\np = numero de procesos para la ejecucion de transacciones\nm = numero de procesos disponibles para ejecutar consultas\nt = numero de segundos para el timeOut de una conexion\n");
        jScrollPane1.setViewportView(jTextArea1);

        jPanel1.add(jScrollPane1);
        jScrollPane1.setBounds(40, 340, 688, 113);

        checkbox1.setBackground(new java.awt.Color(204, 255, 153));
        checkbox1.setLabel("ModoLento");
        jPanel1.add(checkbox1);
        checkbox1.setBounds(30, 300, 87, 20);

        jLabel8.setBackground(javax.swing.UIManager.getDefaults().getColor("InternalFrame.borderLight"));
        jLabel8.setText("p");
        jPanel1.add(jLabel8);
        jLabel8.setBounds(22, 201, 20, 20);

        numProcesosEjecucionTransacciones.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                numProcesosEjecucionTransaccionesActionPerformed(evt);
            }
        });
        jPanel1.add(numProcesosEjecucionTransacciones);
        numProcesosEjecucionTransacciones.setBounds(50, 200, 73, 22);

        numProcesosEjecucionConsultas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                numProcesosEjecucionConsultasActionPerformed(evt);
            }
        });
        jPanel1.add(numProcesosEjecucionConsultas);
        numProcesosEjecucionConsultas.setBounds(50, 230, 73, 22);

        jLabel9.setBackground(javax.swing.UIManager.getDefaults().getColor("InternalFrame.borderLight"));
        jLabel9.setText("m");
        jPanel1.add(jLabel9);
        jLabel9.setBounds(22, 230, 20, 20);

        jLabel10.setBackground(javax.swing.UIManager.getDefaults().getColor("InternalFrame.borderLight"));
        jLabel10.setText("t");
        jPanel1.add(jLabel10);
        jLabel10.setBounds(22, 262, 20, 16);

        segundosTimeOut.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                segundosTimeOutActionPerformed(evt);
            }
        });
        jPanel1.add(segundosTimeOut);
        segundosTimeOut.setBounds(50, 260, 73, 22);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/abstract-background-wallpaper.jpg")));
        jPanel1.add(jLabel1);
        jLabel1.setBounds(0, -30, 1060, 560);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 970, Short.MAX_VALUE)
                .addGap(0, 0, 0))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 563, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton2ActionPerformed

    private void segundosTimeOutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_segundosTimeOutActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_segundosTimeOutActionPerformed

    private void numProcesosEjecucionConsultasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_numProcesosEjecucionConsultasActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_numProcesosEjecucionConsultasActionPerformed

    private void numProcesosEjecucionTransaccionesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_numProcesosEjecucionTransaccionesActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_numProcesosEjecucionTransaccionesActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton1MouseClicked
        String text1 = numCorridas.getText();
        String text2 = duracion.getText();
        String text3 = numProcesosConsultasConcurrentes.getText();
        String text4 = numMaxConexionesConcurrentes.getText();
        String text5 = numProcesosEjecucionTransacciones.getText();
        String text6 = segundosTimeOut.getText();
        String text7 = numProcesosEjecucionConsultas.getText();

        try {
            int corridas = Integer.parseInt(text1);
            double tiempoSimulacion = Double.parseDouble(text2);
            int maxConexionesConcurrentes = Integer.parseInt(text4);
            int procesosEjecucionConsultasConcurrentes = Integer.parseInt(text3);
            int procesosEjecucionTransacciones = Integer.parseInt(text5);
            int procesosEjecucionConsultas = Integer.parseInt(text7);
            int segundostimeOut = Integer.parseInt(text6);
            // or Integer.parseInt(text), etc.
            // OK, valid number.

        } catch (NumberFormatException nfe) {
            // Muestra un mensaje de error y reinicia el programa
            this.setVisible(false);
            jDialog1.setVisible(true);
            numCorridas.setText(null);
            numMaxConexionesConcurrentes.setText(null);
            numProcesosEjecucionConsultas.setText(null);
            numProcesosConsultasConcurrentes.setText(null);
            numProcesosEjecucionTransacciones.setText(null);
            segundosTimeOut.setText(null);
            this.setVisible(true);
        }
        int cantidadCorridas = Integer.parseInt(text1);
        double tiempoSimulacion = Double.parseDouble(text2);
        int maxConexionesConcurrentes = Integer.parseInt(text4);
        int procesosConsultasConcurrentes = Integer.parseInt(text7);
        int procesosEjecucionTransacciones = Integer.parseInt(text5);
        int segundostimeOut = Integer.parseInt(text6);
        int procesosEjecucionConsultas= Integer.parseInt(text3);
        this.setVisible(false);
        this.setSimulacionLlamada(true);
        p.setDuracion(tiempoSimulacion);
        p.setCorridas(cantidadCorridas);
        p.setParamK(maxConexionesConcurrentes);
        p.setParamN(procesosConsultasConcurrentes);
        p.setParamM(procesosEjecucionConsultas);
        p.setParamT(segundostimeOut);
        p.setSlow(this.modLento);
        p.setParamP(procesosEjecucionTransacciones);
        this.setVisible(false);
        this.dispose();
        ve.setVisible(true)  ;
    }//GEN-LAST:event_jButton1MouseClicked
    public Simulacion getSimulacion(){
        return p.getSimulacion();
    }
    public VentanaEjecucion getVe(){
        return ve;
    }
    private void duracionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_duracionActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_duracionActionPerformed

    private void numProcesosConsultasConcurrentesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_numProcesosConsultasConcurrentesActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_numProcesosConsultasConcurrentesActionPerformed

    private void numCorridasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_numCorridasActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_numCorridasActionPerformed

    private void numMaxConexionesConcurrentesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_numMaxConexionesConcurrentesActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_numMaxConexionesConcurrentesActionPerformed
    public boolean getSimulacionLlamada(){
        return this.simulacionLlamada;
    }
    public void setSimulacionLlamada(Boolean estado){
        simulacionLlamada = estado;
    }
    /**
     * @param args the command line arguments
     */
   public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
        
        /*try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(VentanaParametros.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VentanaParametros.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VentanaParametros.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VentanaParametros.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
       java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VentanaParametros().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private java.awt.Checkbox checkbox1;
    private javax.swing.JTextField duracion;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JDialog jDialog1;
    private javax.swing.JDialog jDialog2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JTextField numCorridas;
    private javax.swing.JTextField numMaxConexionesConcurrentes;
    private javax.swing.JTextField numProcesosConsultasConcurrentes;
    private javax.swing.JTextField numProcesosEjecucionConsultas;
    private javax.swing.JTextField numProcesosEjecucionTransacciones;
    private javax.swing.JTextField segundosTimeOut;
    // End of variables declaration//GEN-END:variables
}
