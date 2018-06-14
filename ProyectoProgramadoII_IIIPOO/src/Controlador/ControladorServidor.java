/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;
import Clases.Platillo;
import Clases.SocketServidor;
import Vista.Servidor.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author retr0
 */
public class ControladorServidor implements ActionListener{
    private VentanaPrincipalServidor ventana;
    private SocketServidor servidor;
    private ArrayList<Platillo> platillos;
    
    public ControladorServidor(VentanaPrincipalServidor ventana) throws IOException{
        this.ventana = ventana;
        this.ventana.btnCatalogo.addActionListener((ActionListener) this);
        this.ventana.btnHistorial.addActionListener((ActionListener) this);
        this.ventana.btnStats.addActionListener((ActionListener) this);
        this.ventana.btnTop0.addActionListener((ActionListener) this);
        this.ventana.btnTop10.addActionListener((ActionListener) this);
        this.ventana.btnValorExpress.addActionListener((ActionListener) this);
        this.ventana.btnValorPaquete.addActionListener((ActionListener) this);
        this.ventana.setVisible(true);
        servidor = SocketServidor.getInstance();
        servidor.start();
       
    }
    
    public void actionPerformed(ActionEvent e){
        switch(e.getActionCommand()){
            case "Catálogo":
                VentanaCatalogo venCatalogo = new VentanaCatalogo(platillos);
                venCatalogo.setVisible(true);
                break;
            case "Top 10":
                ArrayList<Platillo> top10=new ArrayList<>();
                for(Platillo platillo:platillos){
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
                    }
                }
                VentanaTop10 nuevaTop10= new VentanaTop10(top10);
                nuevaTop10.setVisible(true);
                break;
            case "Top 0":
                ArrayList<Platillo> top0=new ArrayList<>();
                for(Platillo platillo:platillos){
                    if(platillo.getCantPedidos()==0){
                        top0.add(platillo);
                    }
                }
                VentanaTop10 nuevaTop0= new VentanaTop10(top0);
                nuevaTop0.setVisible(true);
                break;
            case "Historial":
                VentanaHistorial nuevaHis = new VentanaHistorial();
                nuevaHis.setVisible(true);
                break;
            case "Valor paquete":
                //cambia el valor del paquete
                System.out.println("digamos que lo cambio");
                break;
            case "Valor express":
                //cambia el valor del express
                System.out.println("digamos que lo cambioX2");
                break;
            case "Estadísticas":
                VentanaEstadisticas nuevaEstadisticas = new VentanaEstadisticas();
                nuevaEstadisticas.setVisible(true);
                break;
                
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
                ControladorServidor cont;
                try {
                    cont = new ControladorServidor(new VentanaPrincipalServidor());
                    cont.getPrincipal().setVisible(true);
                } catch (IOException ex) {
                    Logger.getLogger(ControladorServidor.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }
}


