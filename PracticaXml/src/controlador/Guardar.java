package controlador;

import org.w3c.dom.Document;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;

public class Guardar {


    private String ruta;


    public Guardar(String ruta) {
        this.ruta = ruta;
    }


    public static void main(String[] args) {
        Guardar guardar = new Guardar("xml/entrenamiento.xml");
        try {
            Document doc = guardar.parseDoc();
            guardar.guardarDocumento(doc);
            System.out.println("Se ha guardado correctamente");
        } catch (Exception e) {
            System.out.println("No se ha guardado correctamente");
            e.printStackTrace();
        }
    }


    public DocumentBuilder obtenerDocumentBuilder() throws Exception {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        return factory.newDocumentBuilder();
    }


    public Document parseDoc() throws Exception {
        DocumentBuilder builder = obtenerDocumentBuilder();
        return builder.parse(new File(ruta));
    }


    public void guardarDocumento(Document doc) {
        try {
            DOMSource source = new DOMSource(doc);
            StreamResult result = new StreamResult(new File(ruta));
            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            transformer.transform(source, result);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}


