
package Clases;

import java.net.*;

import java.io.*;



public class SocketCliente {

    public static void main(String args[])throws IOException , ClassNotFoundException,UnknownHostException {
        Socket socket = new Socket("localhost",SocketServidor.PORT);//conecta al mismo puerto del servidor
        System.out.println("Conectado");
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(socket.getOutputStream());//devuelve flujo
        ObjectInputStream objectInputStream = new ObjectInputStream(socket.getInputStream());//recibe flujo
        Platillo pollo = new Platillo("Pollo",5000,100);    //Cliente crea objeto \
        System.out.println("listo para enviar");
        objectOutputStream.writeObject(pollo);
        System.out.println("enviado");
        Platillo resultado = (Platillo)objectInputStream.readObject();//el  server me devuelve el objeto para ver si esta sano
        System.out.println("Recibido de Cliente:"+resultado.getNombre());//me imprime un string modificado en el server
        socket.close();
    }

    
}


