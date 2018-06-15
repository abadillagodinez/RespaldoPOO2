/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases;

import java.net.*;
import java.io.*;
import Controlador.ControladorServidor;

import Controlador.Reader;
import java.util.logging.Level;
import java.util.logging.Logger;
//me estaba tirando errores



	 

public class SocketServidor extends Thread{
    private static SocketServidor sk;
    private ControladorServidor controlador;
    public static boolean state = true;
    public static final int PORT = 4444;        //Puerto de conexion
    public static Socket socket;
    public  static ServerSocket serverSocket;
    private SocketServidor(){}
    
    
    
    public static SocketServidor getInstance(){
        if(sk == null){
            sk = new SocketServidor();
        }
        return sk;
    }
    
    public void enviarCatalogo() throws IOException{
        Reader xml = new Reader();
        Platillo[] lplatillo;
        lplatillo = xml.XMLReader();//lee el archivo XML
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(socket.getOutputStream());   //devuelve flujo de datos
        objectOutputStream.writeObject(lplatillo);//aqui manda el catalogo por el socket
    }
    
    public Pedido recibirPedido() throws IOException, ClassNotFoundException{
        ObjectInputStream objectInputStream = new ObjectInputStream(socket.getInputStream());   // capta flujo de datos
        Pedido pedido = (Pedido) objectInputStream.readObject();
        return pedido;
    }

    public void esperarAlCliente() throws IOException{
        serverSocket = new ServerSocket(PORT); //abre el puerto para conexiones
        System.out.println("Listo para conexiones...");
    }
    
    
    public void runServer() throws IOException,ClassNotFoundException{
        while (state){ 
            socket = serverSocket.accept();//acepta conexion
            System.out.println(socket);
            Pedido nuevo = recibirPedido();
        }
             

    }
    
//    private void probar(Pedido p){
//        p.setSocket(p.getNombreCliente());      //devuelve nombre de platillo dado por cliente
//        
//    }
    
    public void setControlador(ControladorServidor controlador){
        this.controlador = controlador;
    }
    
    @Override
    public void run(){
        try {
            runServer();
        } catch (IOException ex) {
            Logger.getLogger(SocketServidor.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(SocketServidor.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}