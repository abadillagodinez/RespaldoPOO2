
package Clases;

import static Clases.FuncionalidadesServer.listaPlatillos;
import java.net.*;

import java.io.*;



public class SocketCliente {

    public Platillo[] recibirCatalogo()throws IOException , ClassNotFoundException,UnknownHostException{
        Socket socket1 = new Socket("localhost",SocketServidor.PORT);//conecta al mismo puerto del servidor
        System.out.println("Conectado");
        ObjectInputStream objectInputStream = new ObjectInputStream(socket1.getInputStream());//recibe flujo
        Platillo[] catalogo = (Platillo[]) objectInputStream.readObject();
        System.out.println("se recibio el catalogo");
        socket1.close();
        return catalogo;
        
    }
    public void generarOrden(Pedido nuevoPedido)throws IOException , ClassNotFoundException,UnknownHostException{
        Socket socket = new Socket("localhost",SocketServidor.PORT);//conecta al mismo puerto del servidor
        System.out.println("Conectado");
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(socket.getOutputStream());//devuelve flujo
        //ObjectInputStream objectInputStream = new ObjectInputStream(socket.getInputStream());//recibe flujo
        System.out.println("listo para enviar");
        objectOutputStream.writeObject("generarOrden");
        System.out.println("se envio el comando");
        objectOutputStream.writeObject(nuevoPedido);
        System.out.println("se envio el objeto");
        //Pedido resultado = (Pedido)objectInputStream.readObject();//el  server me devuelve el objeto para ver si esta sano
        //System.out.println("Recibido de Cliente:"+resultado.getNombreCliente());//me imprime un string modificado en el server
        socket.close();
    }
    
//    public void funcionalidades(String funcionalidad)throws IOException , ClassNotFoundException,UnknownHostException{
//        Socket socket = new Socket("localhost",SocketServidor.PORT);//conecta al mismo puerto del servidor
//        System.out.println("Conectado");
//        ObjectOutputStream objectOutputStream = new ObjectOutputStream(socket.getOutputStream());//devuelve flujo
//        ObjectInputStream objectInputStream = new ObjectInputStream(socket.getInputStream());//recibe flujo
//        Platillo pollo = new Platillo("Pollo",5000,100);    //Cliente crea objeto \
//        System.out.println("listo para enviar");
//        objectOutputStream.writeObject(funcionalidad);
//        System.out.println("enviado");
//        Platillo[] lista = new Platillo[100];//creo una lista que tiene un platillo para que el servidor no de problemas, pero no se usa para nada
//        lista[0] = pollo;
//        objectOutputStream.writeObject(lista);
//        System.out.println("enviado");
//        //Platillo[] resultado = (Platillo[])objectInputStream.readObject();//el  server me devuelve el objeto para ver si esta sano
//        //System.out.println("Recibido de Cliente:"+resultado[0].getNombre());//me imprime un string modificado en el server
//        socket.close();
//    }
        

    public static void main(String args[])throws IOException , ClassNotFoundException,UnknownHostException {
        SocketCliente nuevaConexion = new SocketCliente();
        Platillo[] catalogo = nuevaConexion.recibirCatalogo();
        System.out.println("ya asigno a catalogo lo que mando el server");
        Platillo[] listaPlatillos = new Platillo[111];
        Platillo p1 = new Platillo("pollo",1000,200);
        Platillo p2 = new Platillo("Bistec",1500,400);
        Platillo p3 = new Platillo("ensalada",1800,75);
        Platillo p4 = new Platillo("Crema de Hongos",2300,300);
        Platillo p5 = new Platillo("Casado Completo",3000,1000);
        listaPlatillos[0]= p1;
        listaPlatillos[1]= p2;
        listaPlatillos[2]= p3;
        listaPlatillos[3]= p4;
        listaPlatillos[4]= p5;
        
        
        //Orden de cliente*****************
        
        Platillo platillo1 = new Platillo("pollo",1000,200);    //nombre precio y calorias
        OrdenCliente orden1 = new OrdenCliente(platillo1,4);//platillo y cantidad
        
        Platillo platillo2 = new Platillo("Crema de Hongos",1000,200);
        OrdenCliente orden2 = new OrdenCliente(platillo2,1);//platillo y cantidad
        
        Platillo platillo3 = new Platillo("Casado Completo",3000,200);
        OrdenCliente orden3 = new OrdenCliente(platillo3,1);//platillo y cantidad
        
        OrdenCliente[] ordenes = new OrdenCliente[100];
        ordenes[0] = orden1;    //crea un array de ordenes
        ordenes[1] = orden2;
        ordenes[2] = orden3;
      
        
        
        
        Pedido pedidoTotal= new Pedido("Marco","Moravia","direccion",1300,100,"EXPRESS",ordenes);   //crea un pedido general
        
        nuevaConexion.generarOrden(pedidoTotal);
        System.out.println("ya paso de generarOrden");
        
        
    }

    
}


