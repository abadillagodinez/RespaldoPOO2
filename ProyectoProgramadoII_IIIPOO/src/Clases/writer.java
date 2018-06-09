/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package writer;


import java.io.File;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

public class writer {

	public static void main(String argv[]) {

	  try {

		DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder docBuilder = docFactory.newDocumentBuilder();
                
		// root elements
		Document doc = docBuilder.newDocument();
		Element rootElement = doc.createElement("Catalogo");
		doc.appendChild(rootElement);

		// staff elements
		

		// firstname elements
                int cont = 1;
                while(cont < 3){
                    
                Element platillo = doc.createElement("Platillo");
		rootElement.appendChild(platillo);

		// shorten way
		platillo.setAttribute("id", "BEB-"+Integer.toString(cont));
                 
                Element nombre = doc.createElement("nombre");
		nombre.appendChild(doc.createTextNode("pizza"));
		platillo.appendChild(nombre);
                
		Element descripcion = doc.createElement("descripcion");
		descripcion.appendChild(doc.createTextNode("sabor pepperoni,muy rica"));
		platillo.appendChild(descripcion);

                
		Element precio = doc.createElement("precio");
		precio.appendChild(doc.createTextNode("10000"));
		platillo.appendChild(precio);
                
                Element tipoPorcion = doc.createElement("tipoPorcion");
		tipoPorcion.appendChild(doc.createTextNode("taza"));
		platillo.appendChild(tipoPorcion);
                
                cont++;
                }
                
                
                
                

		// write the content into xml file
		TransformerFactory transformerFactory = TransformerFactory.newInstance();
		Transformer transformer = transformerFactory.newTransformer();
                transformer.setOutputProperty(OutputKeys.INDENT, "yes");
		DOMSource source = new DOMSource(doc);
		StreamResult result = new StreamResult(new File("C:\\users\\erick\\Desktop\\file.xml"));

		// Output to console for testing
		// StreamResult result = new StreamResult(System.out);

		transformer.transform(source, result);

		System.out.println("File saved!");

	  } catch (ParserConfigurationException pce) {
		pce.printStackTrace();
	  } catch (TransformerException tfe) {
		tfe.printStackTrace();
	  }
	}
}
