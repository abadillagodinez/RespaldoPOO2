/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;
import Clases.SocketServidor;
import Vista.Servidor.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

/**
 *
 * @author retr0
 */
public class ControladorServidor implements ActionListener{
    private VentanaPrincipalServidor ventana;
    private SocketServidor servidor;
    
    public ControladorServidor(VentanaPrincipalServidor ventana){
        this.ventana = ventana;
        this.ventana.btnCatalogo.addActionListener((ActionListener) this);
        this.ventana.btnHistorial.addActionListener((ActionListener) this);
        this.ventana.btnStats.addActionListener((ActionListener) this);
        this.ventana.btnTop0.addActionListener((ActionListener) this);
        this.ventana.btnTop10.addActionListener((ActionListener) this);
        this.ventana.btnValorExpress.addActionListener((ActionListener) this);
        this.ventana.btnValorPaquete.addActionListener((ActionListener) this);
        servidor = new SocketServidor();
    }
    
    public void actionPerformed(ActionEvent e){
        switch(e.getActionCommand()){
            case "Catálogo":
                VentanaCatalogo venCatalogo = new VentanaCatalogo();
                venCatalogo.setVisible(true);
            case "Top 10":
                VentanaTop10 nuevaTop10 = new VentanaTop10();
                nuevaTop10.setVisible(true);
        }        
    }
    
    public VentanaPrincipalServidor getPrincipal(){
        return ventana;
    }
    
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
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                ControladorServidor cont = new ControladorServidor(new VentanaPrincipalServidor());
                cont.getPrincipal().setVisible(true);
            }
        });
    }
}


