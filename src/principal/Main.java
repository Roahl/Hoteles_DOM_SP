package principal;

import org.w3c.dom.Document;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.*;
import java.io.*;

/**
 * Created by Saul on 29/01/2017.
 */
public class Main {

    static BufferedReader lee = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws ParserConfigurationException, IOException, TransformerException, SAXException {

        byte op;
        Document doc = CargarXML.cargar();

        do {

            op = Menu.principal();
            switch (op) {
                case 1:
                    Altas.altas(doc);
                    break;
                case 2:
                    Bajas.bajas(doc);
                    break;
                case 3:
                    Modificaciones.modificar(doc);
                    break;
                case 4:
                    Visualizar.listadoHoteles(doc);
                    break;
                case 5:
                    Visualizar.listadoSuperior(doc);
                    break;
                case 6:
                    Modificaciones.añadirCadena(doc);
                    break;
                case 7:
                    Grabar.archivo(doc);
                    break;
            }
        } while (op != 7);

    }
}
