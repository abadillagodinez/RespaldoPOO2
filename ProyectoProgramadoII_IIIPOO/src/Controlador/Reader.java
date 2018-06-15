/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import java.io.File;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;
import Clases.Platillo;
import java.util.Arrays;

public class Reader {
    
   
   public Platillo[] XMLReader(){
       Platillo[] listaPlatillos = new Platillo[2];//ACA ESTA LA LISTA 
       try {
         
         Platillo platillo = new Platillo();
         File inputFile = new File("platillos.xml");//archivo de donde se va a leer el xml
         DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
         DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
         Document doc = dBuilder.parse(inputFile);
         doc.getDocumentElement().normalize();
         //System.out.println("Root element :" + doc.getDocumentElement().getNodeName());// se toma el nombre del root que va a ser Catalogo
         NodeList nList = doc.getElementsByTagName("Platillo");//se hace una lista de todos platillos
         //.out.println("----------------------------");
         
         int cont = nList.getLength()-1;
         for (int temp = 0; temp < nList.getLength(); temp++) {//se recorre cada platillo
            Node nNode = nList.item(temp);
            //System.out.println("\nCurrent Element :" + nNode.getNodeName());
            
            if (nNode.getNodeType() == Node.ELEMENT_NODE) {
               Element eElement = (Element) nNode;
               //System.out.println("Id del platillo : " 
               //   + eElement.getAttribute("id")); 
               //System.out.println("nombre : " 
               //   + eElement.getElementsByTagName("nombre").item(0).getTextContent());
               platillo.setNombre(eElement.getElementsByTagName("nombre").item(0).getTextContent());
               //System.out.println("descripcion : " 
               //   + eElement.getElementsByTagName("descripcion").item(0).getTextContent());
               platillo.setDescripcion(eElement.getElementsByTagName("descripcion").item(0).getTextContent());
               //System.out.println("precio : " 
               //   + eElement.getElementsByTagName("precio").item(0).getTextContent());
               platillo.setPrecio(Double.parseDouble(eElement.getElementsByTagName("precio").item(0).getTextContent()));
               //System.out.println("tipoPorcion : " 
               //   + eElement.getElementsByTagName("tipoPorcion").item(0).getTextContent());
               platillo.setTipoPorcion(eElement.getElementsByTagName("tipoPorcion").item(0).getTextContent());
               //System.out.println("habilitado : " 
               //   + eElement.getElementsByTagName("Habilitado").item(0).getTextContent());
               platillo.setHabilitado(Boolean.parseBoolean(eElement.getElementsByTagName("Habilitado").item(0).getTextContent()));
               //System.out.println("cantPedidos : " 
               //   + eElement.getElementsByTagName("CantPedidos").item(0).getTextContent());
               platillo.setCantPedidos(Integer.parseInt(eElement.getElementsByTagName("CantPedidos").item(0).getTextContent()));
               //System.out.println("codClave : " 
               //   + eElement.getElementsByTagName("codClave").item(0).getTextContent());
               platillo.setCodClave(eElement.getElementsByTagName("codClave").item(0).getTextContent());
               //System.out.println("cantidadPlatos : " 
               //   + eElement.getElementsByTagName("CantPlatos").item(0).getTextContent());
               platillo.setCantidadPlatos(Integer.parseInt(eElement.getElementsByTagName("CantPlatos").item(0).getTextContent()));
               //System.out.println("calorias : " 
               //   + eElement.getElementsByTagName("calorias").item(0).getTextContent());
               platillo.setCalorias(Integer.parseInt(eElement.getElementsByTagName("calorias").item(0).getTextContent()));
               
               
               platillo.setKilokcalPorGramo(Double.parseDouble(eElement.getElementsByTagName("kilokcalPorGramo").item(0).getTextContent()));
               
               
               platillo.setGramosPorPorcion(Double.parseDouble(eElement.getElementsByTagName("gramosPorPorcion").item(0).getTextContent()));
               
               String[] byteValues = (eElement.getElementsByTagName("imagen").item(0).getTextContent()).substring(1, eElement.getElementsByTagName("imagen").item(0).getTextContent().length() - 1).split(",");
               byte[] bytes = new byte[byteValues.length];
               for (int i=0, len=bytes.length; i<len; i++) {
                    bytes[i] = Byte.parseByte(byteValues[i].trim());     
                }
               platillo.setImagen(bytes);
               listaPlatillos[temp] = platillo;
               
               
               
            }
         }
         
      
         
         
      } catch (Exception e) {
         e.printStackTrace();
        
        
   }
       return listaPlatillos;
   }
   
   public static void main(String[] args) {
       Reader xml = new Reader();
       Platillo[] lplatillo = new Platillo[100];
       lplatillo = xml.XMLReader();
       
   }
   
//
//      try {
//         File inputFile = new File("C:\\users\\erick\\Desktop\\file.xml");
//         DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
//         DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
//         Document doc = dBuilder.parse(inputFile);
//         doc.getDocumentElement().normalize();
//         System.out.println("Root element :" + doc.getDocumentElement().getNodeName());
//         NodeList nList = doc.getElementsByTagName("Platillo");
//         System.out.println("----------------------------");
//         
//         for (int temp = 0; temp < nList.getLength(); temp++) {
//            Node nNode = nList.item(temp);
//            System.out.println("\nCurrent Element :" + nNode.getNodeName());
//            
//            if (nNode.getNodeType() == Node.ELEMENT_NODE) {
//               Element eElement = (Element) nNode;
//               System.out.println("Id del platillo : " 
//                  + eElement.getAttribute("id"));
//               System.out.println("nombre : " 
//                  + eElement.getElementsByTagName("nombre").item(0).getTextContent());
//               System.out.println("descripcion : " 
//                  + eElement.getElementsByTagName("descripcion").item(0).getTextContent());
//               System.out.println("precio : " 
//                  + eElement.getElementsByTagName("precio").item(0).getTextContent());
//               System.out.println("tipoPorcion : " 
//                  + eElement.getElementsByTagName("tipoPorcion").item(0).getTextContent());
//            }
//         }
//         
//         
//         
//      } catch (Exception e) {
//         e.printStackTrace();
//      }
//   }
}
