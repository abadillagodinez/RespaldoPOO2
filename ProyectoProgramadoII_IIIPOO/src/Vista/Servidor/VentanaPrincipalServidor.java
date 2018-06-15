/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista.Servidor;

import Clases.Pedido;
import Clases.Platillo;
import Clases.SocketServidor;
import Controlador.ControladorServidor;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
//import sun.text.normalizer.CharTrie;

/**
 *
 * @author retr0
 */
public class VentanaPrincipalServidor extends javax.swing.JFrame {
    ControladorServidor controlador;
    VentanaCatalogo miCatalogo;
    SocketServidor ss=SocketServidor.getInstance();
    /**
     * Creates new form VentanaPrincipalServidor
     */
    public VentanaPrincipalServidor(VentanaCatalogo mc) {
        miCatalogo=mc;
        initComponents();
    }
    
    public void setControlador(ControladorServidor controlador){
        this.controlador = controlador;
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
            java.util.logging.Logger.getLogger(VentanaCatalogo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VentanaCatalogo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VentanaCatalogo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VentanaCatalogo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                new VentanaPrincipalServidor().setVisible(true);
//            }
//        });
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnTop10 = new javax.swing.JButton();
        btnTop0 = new javax.swing.JButton();
        btnHistorial = new javax.swing.JButton();
        btnCatalogo = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        txfNuevoValor = new javax.swing.JTextField();
        btnValorPaquete = new javax.swing.JButton();
        btnValorExpress = new javax.swing.JButton();
        btnStats = new javax.swing.JButton();
        btnEnviarCatalogo = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Ventanita administrador");
        setResizable(false);

        btnTop10.setText("Top 10");
        btnTop10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTop10ActionPerformed(evt);
            }
        });

        btnTop0.setText("Top 0");
        btnTop0.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTop0ActionPerformed(evt);
            }
        });

        btnHistorial.setText("Historial");
        btnHistorial.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHistorialActionPerformed(evt);
            }
        });

        btnCatalogo.setText("Catálogo");
        btnCatalogo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCatalogoActionPerformed(evt);
            }
        });

        jLabel1.setText("₡:");

        btnValorPaquete.setText("Valor paquete");
        btnValorPaquete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnValorPaqueteActionPerformed(evt);
            }
        });

        btnValorExpress.setText("Valor express");
        btnValorExpress.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnValorExpressActionPerformed(evt);
            }
        });

        btnStats.setText("Estadísticas");
        btnStats.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnStatsActionPerformed(evt);
            }
        });

        btnEnviarCatalogo.setText("Enviar catálogo");
        btnEnviarCatalogo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEnviarCatalogoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btnCatalogo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnHistorial, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnTop0, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnTop10, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(53, 53, 53)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btnStats, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnValorExpress, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnValorPaquete, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txfNuevoValor, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(btnEnviarCatalogo, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnTop10)
                    .addComponent(jLabel1)
                    .addComponent(txfNuevoValor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnTop0)
                    .addComponent(btnValorPaquete))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnHistorial)
                    .addComponent(btnValorExpress))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCatalogo)
                    .addComponent(btnStats))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnEnviarCatalogo)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCatalogoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCatalogoActionPerformed
        // TODO add your handling code here:
        //VentanaCatalogo nueva = new VentanaCatalogo();
        //nueva.setVisible(true);
    }//GEN-LAST:event_btnCatalogoActionPerformed

    private void btnTop10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTop10ActionPerformed
        ArrayList<Platillo> top10=new ArrayList<>();
                if(miCatalogo.platillos.size() > 0){
                    for(Platillo platillo:miCatalogo.platillos){
                        if(top10.size()<10){
                            top10.add(platillo);
                        }else{
                            for(Platillo platillo2:top10){
                                if(platillo.getCantPedidos()>platillo2.getCantPedidos()){
                                    top10.remove(platillo2);
                                    top10.add(platillo);
                                    break;
                                }
                            }
                            VentanaTop10 nuevaTop10= new VentanaTop10(top10);
                            nuevaTop10.setVisible(true);
                        }
                    }
                }
                else{
                    JOptionPane.showMessageDialog(this ,"La lista de platillos se encuentra vacia",  "Error" , 1);
                }
    }//GEN-LAST:event_btnTop10ActionPerformed

    private void btnValorPaqueteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnValorPaqueteActionPerformed
        Pedido.valorEmpaque=Double.valueOf(txfNuevoValor.getText());
        txfNuevoValor.setText("");
    }//GEN-LAST:event_btnValorPaqueteActionPerformed

    private void btnStatsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnStatsActionPerformed
        
    }//GEN-LAST:event_btnStatsActionPerformed

    private void btnTop0ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTop0ActionPerformed
        ArrayList<Platillo> top10=new ArrayList<>();
        if(miCatalogo.platillos.size() > 0){
            for(Platillo platillo:miCatalogo.platillos){
                if(platillo.getCantPedidos()==0){
                    top10.add(platillo);
                }
            }
        }
        else{
            JOptionPane.showMessageDialog(this ,"La lista de platillos se encuentra vacia",  "Error" , 1);
        }
    }//GEN-LAST:event_btnTop0ActionPerformed

    private void btnEnviarCatalogoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEnviarCatalogoActionPerformed
       try {
            ss.enviarCatalogo();
        } catch (IOException ex) {
            Logger.getLogger(VentanaPrincipalServidor.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnEnviarCatalogoActionPerformed

    private void btnValorExpressActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnValorExpressActionPerformed
        Pedido.valorExpress=Double.valueOf(txfNuevoValor.getText());
        txfNuevoValor.setText("");
    }//GEN-LAST:event_btnValorExpressActionPerformed

    private void btnHistorialActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHistorialActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnHistorialActionPerformed

    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton btnCatalogo;
    private javax.swing.JButton btnEnviarCatalogo;
    public javax.swing.JButton btnHistorial;
    public javax.swing.JButton btnStats;
    public javax.swing.JButton btnTop0;
    public javax.swing.JButton btnTop10;
    public javax.swing.JButton btnValorExpress;
    public javax.swing.JButton btnValorPaquete;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JTextField txfNuevoValor;
    // End of variables declaration//GEN-END:variables
}
