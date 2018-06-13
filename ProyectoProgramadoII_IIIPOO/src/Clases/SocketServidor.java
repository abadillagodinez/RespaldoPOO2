/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases;

import java.net.*;
import java.io.*;



	 

public class SocketServidor {

	 
    public static boolean state = true;
    public static final int PORT = 4444;        //Puerto de conexion
    public static Socket socket;
    public static void main(String args[]) throws IOException , ClassNotFoundException{
        new SocketServidor().runServer();   //ejecuta el server
    }

    public void runServer() throws IOException,ClassNotFoundException{
        ServerSocket serverSocket = new ServerSocket(PORT); //conecta al puerto
        System.out.println("Listo para conexiones...");
        
        Platillo[] plato;
        String funcion;
        
        while (state){ 
            socket = serverSocket.accept();//acepta conexion
            System.out.println(socket);
            ObjectInputStream objectInputStream = new ObjectInputStream(socket.getInputStream());   // capta flujo de datos
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(socket.getOutputStream());   //devuelve flujo de datos
            try{
                funcion = (String) objectInputStream.readObject();
            if (funcion!= null){
                if(funcion.equals("borrar")){
                    plato = (Platillo[]) objectInputStream.readObject();//esto es solo para que lea algo, aunque realmente no hace nada
                    System.out.println("Se borro con exito");
                }
                if (funcion.equals("generarOrden")){
                    plato = (Platillo[]) objectInputStream.readObject();
                    Platillo[] pollo = plato; //Dado el flujo recibido, recibe un  objeto, en este caso es el Platillo que yo se que lo envia
                
                    probar(pollo); //pruebo si sirve                            //sino habria que captar entradas de forma mas general para castearlo.
                
                    objectOutputStream.writeObject(pollo);
                    System.out.println("se genero la orden con exito");
                }
                if(funcion.equals("cerrar")){
                    plato = (Platillo[]) objectInputStream.readObject();//esto es solo para que lea algo, aunque realmente no hace nada
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
    
    private void probar(Platillo[] p){
        p[0].setSocket(p[0].nombre);      //devuelve nombre de platillo dado por cliente
        
    }
    
    
    
}