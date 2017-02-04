package principal;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;


import javax.xml.transform.TransformerException;
import java.io.IOException;

import static principal.Main.lee;

/**
 * Created by Saul on 29/01/2017.
 */
public class Bajas {
    public static void bajas(Document doc) throws IOException, TransformerException {
        Visualizar.listadoHoteles(doc);
        
        System.out.printf("\nDeme id del hotel a eliminar: ");
        String id = lee.readLine();
        
        NodeList lista = doc.getElementsByTagName("Hotel");
        Element element;

        for (int i = 0; i < lista.getLength(); i++) {
            element = (Element) lista.item(i);
            if (element.getAttribute("ID").compareTo(String.valueOf(id)) == 0){
                doc.getFirstChild().removeChild(element);
                Grabar.archivo(doc);
                break;
            }
        }
    }
}