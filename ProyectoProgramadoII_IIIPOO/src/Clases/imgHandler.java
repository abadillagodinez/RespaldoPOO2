/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases;
import java.io.*;
import java.util.Arrays;

/**
 *
 * @author Sir Than II
 */
public class imgHandler {
    public FileInputStream entrada;
    public FileOutputStream salida;
    public File archivo;
    
    public imgHandler(){
        
    }
    
    public byte[] AbrirIMG(File arch){
        Long i = arch.length();
        Integer i2= i.intValue(); 
        byte[] bytesImg= new byte[i2];
        try{
            entrada= new FileInputStream(arch);
            entrada.read(bytesImg);
            String s=Arrays.toString(bytesImg);
            salida = new FileOutputStream("txtCopia.txt");
            salida.write(s.getBytes());
        }catch(IOException e){
            
        }
        return bytesImg;
    }
    
    public String GuardarIMG(File arch, byte[] bytesImg){
        String respuesta=null;
        try{
            salida= new FileOutputStream(arch);
            salida.write(bytesImg);
            respuesta= "Imagen Guardada";
        }catch(IOException e){
            
        }
        
        return respuesta;
        
    }
}
