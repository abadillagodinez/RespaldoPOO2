/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;
import Clases.Platillo;
import Clases.SocketServidor;
import Clases.TipoPlatillo;
import Vista.Servidor.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.Action;
import javax.swing.JOptionPane;

/**
 *
 * @author retr0
 */
public class ControladorServidor implements ActionListener{
    private final String admin = "admin";
    private final String contrasegna = "admin";
    private VentanaPrincipalServidor ventana;
    private VentanaCatalogo ventCatalogo;
    private CreadorBebidas creaBebidas;
    private CreadorNoBebidas creaNoBebidas;
    private VentanaLogin login;
    public static SocketServidor servidor;
    private ArrayList<Platillo> platillos = new ArrayList<Platillo>();
    
    public ControladorServidor() throws IOException{
        //cuando lo meta en el action listener
        
        //
        servidor = SocketServidor.getInstance();
        servidor.esperarAlCliente();
        servidor.start();
        login = new VentanaLogin();
        login.btnLogin.addActionListener(this);
        login.setVisible(true);
    }
    
    
    public void actionPerformed(ActionEvent e){
        switch(e.getActionCommand()){
            //caso del login
            case "Login":
                if(login.txfUsername.getText().equals(admin) && login.pwfContrasegna.getText().equals(contrasegna)){
                    caseLogin();
                    break;
                }else{
                    JOptionPane.showMessageDialog(ventana ,"Usuario y/o contraseña incorrecta",  "Error" , 1);
                }
            //metodos de la ventana principal
            case "Catálogo":
                caseCatalogo();
                break;
            case "Top 10":
                ArrayList<Platillo> top10=new ArrayList<>();
                if(platillos.size() > 0){
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
                            VentanaTop10 nuevaTop10= new VentanaTop10(top10);
                            nuevaTop10.setVisible(true);
                        }
                    }
                }
                else{
                    JOptionPane.showMessageDialog(ventana ,"La lista de platillos se encuentra vacia",  "Error" , 1);
                }
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
            
            //casos de la ventana catalogo
            case "No Bebida":
                ventCatalogo.radioBtnBebida.setSelected(false);
                ventCatalogo.radioBtnNoBebida.setSelected(true);
                break;
            case "Bebida":
                ventCatalogo.radioBtnBebida.setSelected(true);
                ventCatalogo.radioBtnNoBebida.setSelected(false);
                break;
            case "Añadir":
                if(ventCatalogo.radioBtnBebida.isSelected()){
                    caseCreaBebida();
                    break;
                }
                else{
                    caseCreaNoBebida();
                    break;
                }
            case "Crear bebida":
                boolean esNuevo=true;
                Platillo platillo;
                for(int i = 0; i < platillos.size(); i++){
                    Platillo s = platillos.get(i);
                    if(creaBebidas.txfNombre.getText().equals(s.getNombre())){
                        esNuevo=false;
                        break;
                    }
                }
                    if(esNuevo){
                        platillo= new Platillo(creaBebidas.txfNombre.getText(), creaBebidas.txfDescripcion.getText(), 
                                Double.parseDouble(creaBebidas.txfPrecio.getText()), creaBebidas.txtTipoPorcion.getText(),
                                "Bebida"+creaBebidas.txfNombre.getText(), Integer.parseInt(creaBebidas.txfCaloriasPorcion.getText()),
                    Double.valueOf(creaBebidas.txtkcalMl.getText()), Double.valueOf(creaBebidas.txtMlporcion.getText()), TipoPlatillo.BEB);
                    if(creaBebidas.bytesIMG!=null)
                        platillo.setImagen(creaBebidas.bytesIMG);
                    creaBebidas.setVoid();
                    //platillo.setImagen(bytesIMG);
                    //creaBebidas.setVoid();
                        JOptionPane.showMessageDialog(creaBebidas, "Plato Creado Correctamente");
                        creaBebidas.platoValido=true;
                    }else{
                       JOptionPane.showMessageDialog(this, "Plato Repetido, Intente de nuevo"); 
                    }
            break;
                
        }        
    }
    
    /**
     * metodo en caso de que el action event sea login
     */
    private void caseLogin(){
        ventana = new VentanaPrincipalServidor();
        ventana.btnCatalogo.addActionListener((ActionListener) this);
        ventana.btnHistorial.addActionListener((ActionListener) this);
        ventana.btnStats.addActionListener((ActionListener) this);
        ventana.btnTop0.addActionListener((ActionListener) this);
        ventana.btnTop10.addActionListener((ActionListener) this);
        ventana.btnValorExpress.addActionListener((ActionListener) this);
        ventana.btnValorPaquete.addActionListener((ActionListener) this);
        ventana.setVisible(true);
        login.dispose();
    }
    
    /**
     * metodo para los caso de catalogo
     */
    private void caseCatalogo(){
        ventCatalogo = new VentanaCatalogo(platillos);
        ventCatalogo.btnAnadir.addActionListener(this);
        ventCatalogo.btnEliminar.addActionListener(this);
        ventCatalogo.btnModificar.addActionListener(this);
        ventCatalogo.btnVolver.addActionListener(this);
        ventCatalogo.cbxFiltro.addActionListener(this);
        ventCatalogo.lstComidas.addActionListener(this);
        ventCatalogo.radioBtnBebida.addActionListener(this);
        ventCatalogo.radioBtnNoBebida.addActionListener(this);
        ventCatalogo.setVisible(true);
    }
    
    private void caseCreaBebida(){
        ArrayList<String> nombres = new ArrayList<String>();
        for(int i = 0; i < platillos.size(); i++){
            nombres.add(platillos.get(i).getNombre());
        }
        creaBebidas = new CreadorBebidas(nombres, ventCatalogo);
        creaBebidas.btnAnadirIMG.addActionListener(this);
        creaBebidas.btnCrear.addActionListener(this);/*
        creaBebidas.txfCaloriasPorcion.addActionListener(this);
        creaBebidas.txfDescripcion.addActionListener(this);
        creaBebidas.txfNombre.addActionListener(this);
        creaBebidas.txfPrecio.addActionListener(this);
        creaBebidas.txtMlporcion.addActionListener(this);
        creaBebidas.txtTipoPorcion.add*/
        creaBebidas.setVisible(true);
    }
    
    private void caseCreaNoBebida(){
        ArrayList<String> nombres = new ArrayList<String>();
        for(int i = 0; i < platillos.size(); i++){
            nombres.add(platillos.get(i).getNombre());
        }
        creaNoBebidas = new CreadorNoBebidas(nombres);
        creaNoBebidas.btnAnadirIMG.addActionListener(this);
        creaNoBebidas.btnCrear.addActionListener(this);
        /*
        creaBebidas.txfCaloriasPorcion.addActionListener(this);
        creaBebidas.txfDescripcion.addActionListener(this);
        creaBebidas.txfNombre.addActionListener(this);
        creaBebidas.txfPrecio.addActionListener(this);
        creaBebidas.txtMlporcion.addActionListener(this);
        creaBebidas.txtTipoPorcion.add*/
        creaBebidas.setVisible(true);
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
       //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    ControladorServidor cl = new ControladorServidor();
                } catch (IOException ex) {
                    Logger.getLogger(ControladorServidor.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }
}


