
package Clases;

import java.net.*;

import java.io.*;



public class SocketCliente {
    
    public void generarOrden(Platillo[] listaPlatillos)throws IOException , ClassNotFoundException,UnknownHostException{
        Socket socket = new Socket("localhost",SocketServidor.PORT);//conecta al mismo puerto del servidor
        System.out.println("Conectado");
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(socket.getOutputStream());//devuelve flujo
        ObjectInputStream objectInputStream = new ObjectInputStream(socket.getInputStream());//recibe flujo
        System.out.println("listo para enviar");
        objectOutputStream.writeObject("generarOrden");
        System.out.println("enviado");
        objectOutputStream.writeObject(listaPlatillos);
        System.out.println("enviado");
        Platillo[] resultado = (Platillo[])objectInputStream.readObject();//el  server me devuelve el objeto para ver si esta sano
        System.out.println("Recibido de Cliente:"+resultado[0].getNombre());//me imprime un string modificado en el server
        socket.close();
    }
    
    public void funcionalidades(String funcionalidad)throws IOException , ClassNotFoundException,UnknownHostException{
        Socket socket = new Socket("localhost",SocketServidor.PORT);//conecta al mismo puerto del servidor
        System.out.println("Conectado");
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(socket.getOutputStream());//devuelve flujo
        ObjectInputStream objectInputStream = new ObjectInputStream(socket.getInputStream());//recibe flujo
        Platillo pollo = new Platillo("Pollo",5000,100);    //Cliente crea objeto \
        System.out.println("listo para enviar");
        objectOutputStream.writeObject(funcionalidad);
        System.out.println("enviado");
        Platillo[] lista = new Platillo[100];//creo una lista que tiene un platillo para que el servidor no de problemas, pero no se usa para nada
        lista[0] = pollo;
        objectOutputStream.writeObject(lista);
        System.out.println("enviado");
        //Platillo[] resultado = (Platillo[])objectInputStream.readObject();//el  server me devuelve el objeto para ver si esta sano
        //System.out.println("Recibido de Cliente:"+resultado[0].getNombre());//me imprime un string modificado en el server
        socket.close();
    }
        

    public static void main(String args[])throws IOException , ClassNotFoundException,UnknownHostException {
        SocketCliente nuevaConexion = new SocketCliente();
        Platillo[] listaPlatillos = new Platillo[100];
        Platillo p1 = new Platillo("pollo",1000,200);
        Platillo p2 = new Platillo("Bistec",1500,400);
        listaPlatillos[0]= p1;
        listaPlatillos[1]= p2;
        nuevaConexion.funcionalidades("borrar");
    }

    
}


