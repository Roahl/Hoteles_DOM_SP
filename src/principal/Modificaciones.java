package principal;

import org.w3c.dom.*;


import javax.xml.transform.TransformerException;
import java.io.IOException;

import static principal.Main.lee;

/**
 * Created by a15carlosspb on 30/01/2017.
 */
public class Modificaciones {
    public static void modificar(Document doc) throws IOException, TransformerException {
        Visualizar.listadoHoteles(doc);
        System.out.printf("\nDeme id del hotel a modificar: ");
        String id = lee.readLine();
        NodeList lista = doc.getElementsByTagName("Hotel");
        Element element;
        Element elementNuevo;
        for (int i = 0; i < lista.getLength(); i++) {
            element = (Element) lista.item(i);
            if (element.getAttribute("ID").compareTo(String.valueOf(id)) == 0) {
                elementNuevo = nuevosDatos(doc, element);
                System.out.println("¿Desea aplicar los cambios?\n1->Si\n2->No\n");
                if (Byte.parseByte(lee.readLine()) == 1) {
                    doc.getFirstChild().replaceChild(elementNuevo, element);
                }
                Grabar.archivo(doc);
                break;
            }
        }
    }

    private static Element nuevosDatos(Document doc, Element element) throws IOException {
        Element elemNuevosDatos = (Element) element.cloneNode(true);
        byte op;
        do {
            System.out.printf("\n¿Que desea cambiar?" +
                    "\n1->Categoria" +
                    "\n2->Precio" +
                    "\n3->Salir\n");
            op = Byte.parseByte(lee.readLine());
            switch (op) {
                case 1:
                    System.out.printf("\nNueva categoria(1->Turista/2->Superior): ");
                    op = Byte.parseByte(lee.readLine());
                    if(op==1){
                        elemNuevosDatos.setAttribute("Categoria","Turista");
                    }else if(op==2){
                        elemNuevosDatos.setAttribute("Categoria","Superior");
                    }
                    break;
                case 2:
                    System.out.printf("\nNuevo precio: ");
                    elemNuevosDatos.getElementsByTagName("PrecioEstandar").item(0).getFirstChild().setTextContent(lee.readLine());
                    break;
            }
        } while (op != 3);
        return elemNuevosDatos;
    }

    public static void añadirCadena(Document doc) throws IOException, TransformerException {
        Visualizar.listadoHoteles(doc);
        System.out.printf("\nDeme id del hotel a modificar: ");
        String id = lee.readLine();
        NodeList lista = doc.getElementsByTagName("Hotel");
        Element element;
        for (int i = 0; i < lista.getLength(); i++) {
            element = (Element) lista.item(i);
            if (element.getAttribute("ID").compareTo(String.valueOf(id)) == 0) {
                System.out.printf("\nDeme cadena a la que pertenece el hotel: ");
                
                Element cadena = doc.createElement("Cadena");
                Text txtCadena = doc.createTextNode(lee.readLine());
                cadena.appendChild(txtCadena);
                element.appendChild(cadena);
                
                Grabar.archivo(doc);
                break;
            }
        }
    }
}
