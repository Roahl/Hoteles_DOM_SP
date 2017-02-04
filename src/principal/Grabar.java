package principal;

import com.sun.org.apache.xml.internal.serializer.OutputPropertiesFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

import javax.xml.transform.*;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

/**
 * Created by Saul on 29/01/2017.
 */
public class Grabar {
    public static void nuevo(Document doc) throws TransformerException {
        Element raiz = doc.createElement("Hoteles");
        doc.appendChild(raiz);
        Transformer t = TransformerFactory.newInstance().newTransformer();
        t.setOutputProperty(OutputKeys.INDENT, "yes");
        t.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "3");
        Source fuente = new DOMSource(doc);
        Result destino = new StreamResult("hoteles.xml");
        t.transform(fuente,destino);
    }

    public static void archivo(Document doc) throws TransformerException{
        Transformer t = TransformerFactory.newInstance().newTransformer();
        t.setOutputProperty(OutputKeys.INDENT, "yes");
        t.setOutputProperty(OutputPropertiesFactory.S_KEY_INDENT_AMOUNT, "3");
        Source fuente = new DOMSource(doc);
        Result destino = new StreamResult("hoteles.xml");
        t.transform(fuente,destino);
    }
}
