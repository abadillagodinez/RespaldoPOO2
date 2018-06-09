/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases;

import java.io.File;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;

public class reader {
    
    
   private void XMLWriter(String platillo[]){
       try {
         File inputFile = new File("C:\\users\\erick\\Desktop\\file.xml");//archivo de donde se va a leer el xml
         DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
         DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
         Document doc = dBuilder.parse(inputFile);
         doc.getDocumentElement().normalize();
         System.out.println("Root element :" + doc.getDocumentElement().getNodeName());// se toma el nombre del root que va a ser Catalogo
         NodeList nList = doc.getElementsByTagName("Platillo");//se hace una lista de todos platillos
         System.out.println("----------------------------");
         
         for (int temp = 0; temp < nList.getLength(); temp++) {//se recorre cada platillo
            Node nNode = nList.item(temp);
            System.out.println("\nCurrent Element :" + nNode.getNodeName());
            
            if (nNode.getNodeType() == Node.ELEMENT_NODE) {
               Element eElement = (Element) nNode;
               System.out.println("Id del platillo : " 
                  + eElement.getAttribute("id"));
               System.out.println("nombre : " 
                  + eElement.getElementsByTagName("nombre").item(0).getTextContent());
               System.out.println("descripcion : " 
                  + eElement.getElementsByTagName("descripcion").item(0).getTextContent());
               System.out.println("precio : " 
                  + eElement.getElementsByTagName("precio").item(0).getTextContent());
               System.out.println("tipoPorcion : " 
                  + eElement.getElementsByTagName("tipoPorcion").item(0).getTextContent());
            }
         }
         
         
         
      } catch (Exception e) {
         e.printStackTrace();
        }
   }
   
   
//   public static void main(String[] args) {
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