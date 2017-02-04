package principal;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

/**
 * Created by a15carlosspb on 30/01/2017.
 */
public class Visualizar {
    public static void listadoHoteles(Document doc) {
        NodeList nlHoteles = doc.getElementsByTagName("Hotel");
        Element elemento;

        System.out.printf("\n+------------------------------------------------------------------------------------------+" +
                          "\n|                                         Hoteles                                          |" +
                          "\n+------------------------------------------------------------------------------------------+" +
                          "\n|  ID  |      Nombre      |  Idioma  |  Categoria  |  Población  |  Precio  |    Cadena    |" +
                          "\n+------------------------------------------------------------------------------------------+");
        for(int i=0;i<nlHoteles.getLength();i++){
            elemento = (Element) nlHoteles.item(i);
            if(elemento.getElementsByTagName("Cadena").item(0)==null)
                System.out.printf("\n|%6s|%18s|%10s|%13s|%13s|%10s|    ------    |",
                    elemento.getAttribute("ID"),
                    elemento.getElementsByTagName("Nombre").item(0).getTextContent(),
                    ((Element)elemento.getElementsByTagName("Nombre").item(0)).getAttribute("Idiomas"),
                    elemento.getAttribute("Categoria"),
                    elemento.getElementsByTagName("Poblacion").item(0).getTextContent(),
                    elemento.getElementsByTagName("PrecioEstandar").item(0).getTextContent()
                    );
            else
                System.out.printf("\n|%6s|%18s|%10s|%13s|%13s|%10s|%14s|",
                        elemento.getAttribute("ID"),
                        elemento.getElementsByTagName("Nombre").item(0).getTextContent(),
                        ((Element)elemento.getElementsByTagName("Nombre").item(0)).getAttribute("Idiomas"),
                        elemento.getAttribute("Categoria"),
                        elemento.getElementsByTagName("Poblacion").item(0).getTextContent(),
                        elemento.getElementsByTagName("PrecioEstandar").item(0).getTextContent(),
                        elemento.getElementsByTagName("Cadena").item(0).getTextContent()
                );

        }
        System.out.printf("\n+------------------------------------------------------------------------------------------+\n");
    }

    public static void listadoSuperior(Document doc) {
        NodeList nlHoteles = doc.getElementsByTagName("Hotel");
        Element elemento;

        System.out.printf("\n+------------------------------------------------------------------------------------------+" +
                          "\n|                                         Hoteles                                          |" +
                          "\n+------------------------------------------------------------------------------------------+" +
                          "\n|  ID  |      Nombre      |  Idioma  |  Categoria  |  Población  |  Precio  |    Cadena    |" +
                          "\n+------------------------------------------------------------------------------------------+");
        for(int i=0;i<nlHoteles.getLength();i++){
            elemento = (Element) nlHoteles.item(i);
            if(elemento.getAttribute("Categoria").compareToIgnoreCase("Superior")==0){
                if(elemento.getElementsByTagName("Cadena").item(0)==null)
                    System.out.printf("\n|%6s|%18s|%10s|%13s|%13s|%10s|    ------    |",
                            elemento.getAttribute("ID"),
                            elemento.getElementsByTagName("Nombre").item(0).getTextContent(),
                            ((Element)elemento.getElementsByTagName("Nombre").item(0)).getAttribute("Idiomas"),
                            elemento.getAttribute("Categoria"),
                            elemento.getElementsByTagName("Poblacion").item(0).getTextContent(),
                            elemento.getElementsByTagName("PrecioEstandar").item(0).getTextContent()
                    );
                else
                    System.out.printf("\n|%6s|%18s|%10s|%13s|%13s|%10s|%14s|",
                            elemento.getAttribute("ID"),
                            elemento.getElementsByTagName("Nombre").item(0).getTextContent(),
                            ((Element)elemento.getElementsByTagName("Nombre").item(0)).getAttribute("Idiomas"),
                            elemento.getAttribute("Categoria"),
                            elemento.getElementsByTagName("Poblacion").item(0).getTextContent(),
                            elemento.getElementsByTagName("PrecioEstandar").item(0).getTextContent(),
                            elemento.getElementsByTagName("Cadena").item(0).getTextContent()
                    );
            }
        }
        System.out.printf("\n+------------------------------------------------------------------------------------------+\n");
    }
}
