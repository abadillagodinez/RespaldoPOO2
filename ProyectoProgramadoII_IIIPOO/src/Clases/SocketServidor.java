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
        
        Platillo plato;
        ((ServerCloser) new ServerCloser()).start();
        
        while (state){ 
            socket = serverSocket.accept();//acepta conexion
            System.out.println(socket);
            ObjectInputStream objectInputStream = new ObjectInputStream(socket.getInputStream());   // capta flujo de datos
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(socket.getOutputStream());   //devuelve flujo de datos
            try{
                plato = (Platillo) objectInputStream.readObject();
            if (plato!= null){
                System.out.println("holaaa");
                Platillo pollo = plato; //Dado el flujo recibido, recibe un  objeto, en este caso es el Platillo que yo se que lo envia
                System.out.println("1");
                probar(pollo); //pruebo si sirve                            //sino habria que captar entradas de forma mas general para castearlo.
                System.out.println("2");
                objectOutputStream.writeObject(pollo);
                System.out.println("3");
                socket.close();
            }          
            }
            catch(Exception e){
    
            }
        }
             

    }
    
    private void probar(Platillo p){
        p.setSocket(p.nombre);      //devuelve nombre de platillo dado por cliente
        
    }
    
    
    
}