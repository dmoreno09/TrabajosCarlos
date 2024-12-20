package controlador;


import modelo.Entrenamiento;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import java.util.ArrayList;

public class Crud {

    private Guardar guardar;

    public Crud(Guardar guardar) {
        this.guardar = guardar;
    }

    public void agregarEntrenamiento(Entrenamiento entrenamiento) {
        try{

            Document doc = guardar.parseDoc();



            Element root = doc.getDocumentElement();


            Element nuevoEntrenamiento = doc.createElement("entrenamiento");
            nuevoEntrenamiento.setAttribute("id", String.valueOf(entrenamiento.getId()));


            Element nombre = doc.createElement("nombre");
            nombre.setTextContent(entrenamiento.getNombre());
            nuevoEntrenamiento.appendChild(nombre);

            Element duracion = doc.createElement("duracion");
            duracion.setTextContent(String.valueOf(entrenamiento.getDuracion()));
            nuevoEntrenamiento.appendChild(duracion);

            Element nivel = doc.createElement("nivel");
            nivel.setTextContent(entrenamiento.getNivel());
            nuevoEntrenamiento.appendChild(nivel);



            // Añadir el nuevo elemento "entrenamiento" al documento XML
            root.appendChild(nuevoEntrenamiento);

            // controlador.Guardar los cambios en el archivo XML
            guardar.guardarDocumento(doc);

            System.out.println("modelo.Entrenamiento agregado y guardado exitosamente.");
        } catch (Exception e) {
            System.out.println("Error al agregar el entrenamiento.");
            e.printStackTrace();
        }
    }



    public ArrayList<Entrenamiento> leerTodos() {
        ArrayList<Entrenamiento> listaEntrenamiento = new ArrayList<>();

        try {
            Document doc = guardar.parseDoc();
            NodeList listaEntrenos = doc.getElementsByTagName("entrenamiento");

            System.out.println("Contenido del documento");


            int i = 0;


            while (i < listaEntrenos.getLength()) {
                Node nodo = listaEntrenos.item(i);


                if (nodo.getNodeType() == Node.ELEMENT_NODE) {
                    Element element = (Element) nodo;


                    int id = Integer.parseInt(element.getAttribute("id"));
                    String nombre = element.getElementsByTagName("nombre").item(0).getTextContent();
                    int duracion = Integer.parseInt(element.getElementsByTagName("duracion").item(0).getTextContent());
                    String nivel = element.getElementsByTagName("nivel").item(0).getTextContent();

                    // Mostrar información del entrenamiento
                    System.out.println("ID : " + id);
                    System.out.println("NOMBRE : " + nombre);
                    System.out.println("DURACION : " + duracion);
                    System.out.println("NIVEL : " + nivel);

                    // Crear un objeto Entrenamiento con los datos obtenidos
                    Entrenamiento entrenamiento = new Entrenamiento(id, nombre, duracion, nivel);

                    // Añadir el entrenamiento a la lista
                    listaEntrenamiento.add(entrenamiento);
                }


                i++;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        // Devolver la lista de entrenamientos
        return listaEntrenamiento;
    }




    public void actualizarEntrenamiento(Entrenamiento entrenamiento) {
        try {

            Document doc = guardar.parseDoc();
            NodeList listaEntrenos = doc.getElementsByTagName("entrenamiento");


            int i = 0;


            while (i < listaEntrenos.getLength()) {
                Node nodoEntrenamiento = listaEntrenos.item(i);


                if (nodoEntrenamiento.getNodeType() == Node.ELEMENT_NODE) {
                    Element elemento = (Element) nodoEntrenamiento;


                    if (Integer.parseInt(elemento.getAttribute("id")) == entrenamiento.getId()) {
                        // Actualizar los atributos y valores del nodo
                        elemento.setAttribute("id", String.valueOf(entrenamiento.getId()));
                        elemento.getElementsByTagName("nombre").item(0).setTextContent(entrenamiento.getNombre());
                        elemento.getElementsByTagName("duracion").item(0).setTextContent(String.valueOf(entrenamiento.getDuracion()));
                        elemento.getElementsByTagName("nivel").item(0).setTextContent(entrenamiento.getNivel());

                        System.out.println("Entrenamiento actualizado con éxito.");


                        guardar.guardarDocumento(doc);
                        return;
                    }
                } i++;
            }


            System.out.println("Entrenamiento con ID " + entrenamiento.getId() + " no encontrado.");
            guardar.guardarDocumento(doc);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void eliminarEntrenamiento(int id) {
        try {

            Document doc = guardar.parseDoc();
            NodeList listaEntrenos = doc.getElementsByTagName("entrenamiento");


            int i = 0;


            while (i < listaEntrenos.getLength()) {
                Node nodo = listaEntrenos.item(i);


                if (nodo.getNodeType() == Node.ELEMENT_NODE) {
                    Element elemento = (Element) nodo;


                    if (Integer.parseInt(elemento.getAttribute("id")) == id) {
                        elemento.getParentNode().removeChild(elemento);

                        System.out.println("Entrenamiento con ID " + id + " eliminado con éxito.");


                        guardar.guardarDocumento(doc);
                        return;
                    }
                } i++;
            }
            System.out.println("Entrenamiento con ID " + id + " no encontrado.");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}