/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package principal;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;
import org.w3c.dom.Document;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

/**
 * Created by Saul on 29/01/2017.
 */
class CargarXML {

    static Document cargar() throws FileNotFoundException, TransformerException, ParserConfigurationException, SAXException, IOException {
        Document doc;
        FileOutputStream fos;
        File fichero = new File("hoteles.xml");

        if (!fichero.exists()) {
            fos = new FileOutputStream("hoteles.xml");

            doc = DocumentBuilderFactory.newInstance().newDocumentBuilder().newDocument();
            if (doc.getFirstChild() == null) {
                Grabar.nuevo(doc);
            }
        }

        doc = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(new InputSource(new FileInputStream(fichero)));
        return doc;
    }
    
}
