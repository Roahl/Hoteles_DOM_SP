package principal;

import org.w3c.dom.*;

import javax.xml.transform.*;
import java.io.IOException;

import static principal.Main.lee;

/**
 * Created by Saul on 29/01/2017.
 */
public class Altas {

    public static void altas(Document doc) throws IOException, TransformerException {
        byte op;
        String categoria;
        System.out.printf("Deme ID del hotel: ");
        int id = Integer.parseInt(lee.readLine());
        if (!comprobarID(id, doc)) {
            //ID
            Element hotel = doc.createElement("Hotel");
            hotel.setAttribute("ID", String.valueOf(id));

            //NOMBRE
            System.out.printf("Dame nombre del hotel: ");
            String nom = lee.readLine();
            Element nombre = doc.createElement("Nombre");
            Text txtNom = doc.createTextNode(nom);
            nombre.appendChild(txtNom);
            hotel.appendChild(nombre);

            //IDIOMAS
            System.out.printf("Deme idiomas del hotel(Español/Varios): ");
            String idiomas = lee.readLine();
            nombre.setAttribute("Idiomas", idiomas);

            //CATEGORIA
            do {
                System.out.printf("Deme categoria del hotel(1->Turista/2->Superior): ");
                op = Byte.parseByte(lee.readLine());
            } while (op != 1 && op != 2);
            categoria = op == 1 ? "Turista" : "Superior";

            hotel.setAttribute("Categoria", categoria);

            //POBLACIÓN
            System.out.printf("Deme población del hotel: ");
            String pob = lee.readLine();
            Element poblacion = doc.createElement("Poblacion");
            Text txtPob = doc.createTextNode(pob);
            poblacion.appendChild(txtPob);
            hotel.appendChild(poblacion);

            //PRECIO
            System.out.printf("Deme precio estandar: ");
            int precio = Integer.parseInt(lee.readLine());
            Element precioEst = doc.createElement("PrecioEstandar");
            Text txtPrecio = doc.createTextNode(String.valueOf(precio));
            precioEst.appendChild(txtPrecio);
            hotel.appendChild(precioEst);

            doc.getFirstChild().appendChild(hotel);
            Grabar.archivo(doc);
        } else {
            System.out.printf("\nID ya presente en la base de datos\n");
            altas(doc);
        }

    }

    private static boolean comprobarID(int id, Document doc) {
        Element element;
        NodeList lista = doc.getElementsByTagName("Hotel");

        for (int i = 0; i < lista.getLength(); i++) {
            element = (Element) lista.item(i);
            if (element.getAttribute("ID").compareTo(String.valueOf(id)) == 0) {
                return true;
            }
        }

        return false;
    }
}
