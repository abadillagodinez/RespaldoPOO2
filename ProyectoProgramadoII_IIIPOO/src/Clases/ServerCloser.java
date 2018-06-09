/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases;
import java.io.IOException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author erick
 */
public class ServerCloser  extends Thread{
        
    public boolean myState = true;  
    public String serverState;
    
    public ServerCloser(){
        this.myState = true;
    }
    
    @Override
    public void run(){
        while (myState){
            Scanner keyboard = new Scanner(System.in);
            System.out.println("Ingrese close antes de su ultimo pedido para apagar el servidor");
            serverState = keyboard.next();
            
            if ("close".equals(serverState)){
                System.out.println("Se va a cerrar el servidor despues del proximo pedido");
                    SocketServidor.state = false;
                    this.myState = false;
            }
        }
    }
}
