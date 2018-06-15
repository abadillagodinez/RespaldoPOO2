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


	 

public class SocketServidor {

    private ControladorServidor controlador;
    public static boolean state = true;
    public static final int PORT = 4444;        //Puerto de conexion
    public static Socket socket;
    public static void main(String args[]) throws IOException , ClassNotFoundException{
        new SocketServidor().runServer();   //ejecuta el server
    }

    public void runServer() throws IOException,ClassNotFoundException{
        
        ServerSocket serverSocket = new ServerSocket(PORT); //conecta al puerto
        System.out.println("Listo para conexiones...");
        socket = serverSocket.accept();//acepta conexion
        ObjectOutputStream objectOutputStream1 = new ObjectOutputStream(socket.getOutputStream());
        Reader xml = new Reader();
        Platillo[] lplatillo;
        lplatillo = xml.XMLReader();//lee el archivo XML
        objectOutputStream1.writeObject(lplatillo);//aqui manda el catalogo por el socket
        System.out.println("el catalogo fue enviado al cliente");
        Pedido pedido;
        String funcion;
        FuncionalidadesServer fun = new FuncionalidadesServer();
        
        while (state){ 
            socket = serverSocket.accept();//acepta conexion
            System.out.println(socket);
            ObjectInputStream objectInputStream = new ObjectInputStream(socket.getInputStream());   // capta flujo de datos
            //ObjectOutputStream objectOutputStream = new ObjectOutputStream(socket.getOutputStream());   //devuelve flujo de datos
            try{
                funcion = (String) objectInputStream.readObject();
            if (funcion!= null){
                if (funcion.equals("generarOrden")){
                    
                    pedido = (Pedido) objectInputStream.readObject();
                    //probar(pedido); //pruebo si sirve                            //sino habria que captar entradas de forma mas general para castearlo.
                    
                    
                    //objectOutputStream.writeObject(pedido);
                    System.out.println("se genero la orden con exito");
                    
                }
                if(funcion.equals("cerrar")){
                    pedido = (Pedido) objectInputStream.readObject();//esto es solo para que lea algo, aunque realmente no hace nada
                    SocketServidor.state = false;
                    System.out.println("se cerro el servidor");
                }
                
                
                socket.close();
            }          
            }
            catch(Exception e){
    
            }
        }
             

    }
    
    private void probar(Pedido p){
        p.setSocket(p.getNombreCliente());      //devuelve nombre de platillo dado por cliente
        
    }
    
    public void setControlador(ControladorServidor controlador){
        this.controlador = controlador;
    }
    
    
    
}