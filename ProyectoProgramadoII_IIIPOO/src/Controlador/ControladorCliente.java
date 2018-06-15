/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Clases.Platillo;
import Clases.SocketCliente;
import Vista.Cliente.VentanaExpress;
import Vista.Cliente.VentanaLLevar;
import Vista.Cliente.VentanaPrincipalCliente;
import Vista.Cliente.VentanaVerCarrito;
import Vista.Servidor.VentanaCatalogo;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author retr0
 */
public class ControladorCliente implements ActionListener{
    private VentanaPrincipalCliente ventana;
    private SocketCliente cliente;
    private ArrayList<Platillo> platillos = new ArrayList<Platillo>();
    private ArrayList<Platillo> carrito = new ArrayList<Platillo>(); //posive lista para el carrito
    
    public ControladorCliente(VentanaPrincipalCliente ventana){
        this.ventana = ventana;
        this.ventana.btnAñadir.addActionListener((ActionListener)this);
        this.ventana.btnMostrarCalorias.addActionListener((ActionListener)this);
        this.ventana.btnPedir.addActionListener((ActionListener)this);
        this.ventana.cbxFiltro.addActionListener((ActionListener)this);
        this.ventana.verCarrito.addActionListener((ActionListener)this);
        this.ventana.setVisible(true);
    }
    
    @Override
    public void actionPerformed(ActionEvent ae) {
        switch(ae.getActionCommand()){
            case "Pedir":
                if(!ventana.rbtAca.isSelected() && !ventana.rbtExpress.isSelected() && !ventana.rbtLlevar.isSelected()){
                    JOptionPane.showMessageDialog(ventana, "Debe seleccionar solo una forma de pedido", "Error", 0);
                }
                else if(ventana.rbtAca.isSelected()){
                    //codigo para pedir
                }
                else if(ventana.rbtExpress.isSelected()){
                    VentanaExpress nuevo = new VentanaExpress();
                    nuevo.setVisible(true);
                }          
                else if(ventana.rbtLlevar.isSelected()){
                    VentanaLLevar nuevo = new VentanaLLevar();
                    nuevo.setVisible(true);
                }
                break;
            case "Añadir al carrito":
                //codigo de agnadir al carrito
                if(ventana.lstComidas.getSelectedIndex() == -1){
                    JOptionPane.showMessageDialog(ventana, "Debe seleccionar un producto del la lista", "Error", 0);
                }
                else{
                    carrito.add(platillos.get(ventana.lstComidas.getSelectedIndex()));
                    //agrega al carrito
                        //lo que haya en los platillos
                            //en la posicion del indice
                }
                break;
            case "Ver carrito":
                //codigo para ver el carrito
                VentanaVerCarrito verCar = new VentanaVerCarrito(carrito, this);
                verCar.setVisible(true);
                break;
            case "Calorias totales":
                //codigo de las calorias totalse
                break;
        }
    }
    
    
    public VentanaPrincipalCliente getPrincipal(){
        return ventana;
    }
    
    
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
       //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                VentanaPrincipalCliente vcl = new VentanaPrincipalCliente();
                ControladorCliente cl = new ControladorCliente(vcl);
            }
        });
    }
}
