package controlador;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class Operaciones {

    private Guardar guardar;


    public Operaciones(Guardar guardar) {
        this.guardar = guardar;
    }
    public void calcularMedia() {
        try {
            // Parsear el documento XML
            Document doc = guardar.parseDoc();
            NodeList listaEntrenamientos = doc.getElementsByTagName("entrenamiento");

            int sumaDuracion = 0;
            int cantidadEntrenamientos = 0;

            // Inicializar índice para el bucle while
            int i = 0;

            // Bucle while para recorrer los nodos
            while (i < listaEntrenamientos.getLength()) {
                Node nodo = listaEntrenamientos.item(i);

                // Comprobar si el nodo es de tipo ELEMENT_NODE
                if (nodo.getNodeType() == Node.ELEMENT_NODE) {
                    Element elemento = (Element) nodo;

                    // Obtener la duración y acumular los valores
                    int duracion = Integer.parseInt(
                            elemento.getElementsByTagName("duracion").item(0).getTextContent()
                    );

                    sumaDuracion += duracion;
                    cantidadEntrenamientos++;
                }

                // Incrementar el índice
                i++;
            }

            // Calcular y mostrar la media si hay entrenamientos
            if (cantidadEntrenamientos > 0) {
                double media = (double) sumaDuracion / cantidadEntrenamientos;
                System.out.println("La media de la duración es: " + media);
            } else {
                System.out.println("No se encontraron entrenamientos en el archivo XML.");
            }

            // Guardar el documento (opcional en este caso, porque no se modifica)
            guardar.guardarDocumento(doc);

        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Error al calcular la media de la duración.");
        }
    }
    public void calcularEstadisticas() {
        try {
            Document doc = guardar.parseDoc();
            NodeList listaEntrenamientos = doc.getElementsByTagName("entrenamiento");

            int totalEntrenamientos = 0;
            int sumaDuracion = 0;
            int duracionMax = Integer.MIN_VALUE;
            int duracionMin = Integer.MAX_VALUE;

            String entrenamientoMax = "";
            String entrenamientoMin = "";

            // Inicializar contadores de niveles
            int[] nivelesContadores = new int[3]; // [0]: Avanzado, [1]: Intermedio, [2]: Fácil

            int i = 0;

            // Recorrer los nodos con un while
            while (i < listaEntrenamientos.getLength()) {
                Node nodo = listaEntrenamientos.item(i);

                if (nodo.getNodeType() == Node.ELEMENT_NODE) {
                    Element elemento = (Element) nodo;

                    // Leer datos del entrenamiento
                    String nombre = elemento.getElementsByTagName("nombre").item(0).getTextContent();
                    int duracion = Integer.parseInt(elemento.getElementsByTagName("duracion").item(0).getTextContent());
                    String nivel = elemento.getElementsByTagName("nivel").item(0).getTextContent();

                    // Actualizar estadísticas
                    totalEntrenamientos++;
                    sumaDuracion += duracion;

                    if (duracion > duracionMax) {
                        duracionMax = duracion;
                        entrenamientoMax = nombre;
                    }

                    if (duracion < duracionMin) {
                        duracionMin = duracion;
                        entrenamientoMin = nombre;
                    }

                    // Actualizar contadores de niveles
                    actualizarContadorPorNivel(nivel, nivelesContadores);
                }

                i++;
            }

            // Calcular estadísticas finales
            double duracionMedia = (totalEntrenamientos > 0) ? (double) sumaDuracion / totalEntrenamientos : 0;

            // Mostrar estadísticas
            System.out.println("Estadísticas del Archivo XML:");
            System.out.println("Total de Entrenamientos: " + totalEntrenamientos);
            System.out.println("Duración Promedio: " + duracionMedia);
            System.out.println("Entrenamiento con Mayor Duración: " + entrenamientoMax + " (" + duracionMax + " minutos)");
            System.out.println("Entrenamiento con Menor Duración: " + entrenamientoMin + " (" + duracionMin + " minutos)");
            System.out.println("Entrenamientos por Nivel:");
            System.out.println(" - Avanzado: " + nivelesContadores[0]);
            System.out.println(" - Intermedio: " + nivelesContadores[1]);
            System.out.println(" - Fácil: " + nivelesContadores[2]);

        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Error al calcular estadísticas.");
        }
    }

    private void actualizarContadorPorNivel(String nivel, int[] nivelesContadores) {
        // Actualizar contadores según el nivel
        if (nivel.equalsIgnoreCase("Avanzado")) {
            nivelesContadores[0]++;
        } else if (nivel.equalsIgnoreCase("Intermedio")) {
            nivelesContadores[1]++;
        } else if (nivel.equalsIgnoreCase("Fácil")) {
            nivelesContadores[2]++;
        }
    }

}

