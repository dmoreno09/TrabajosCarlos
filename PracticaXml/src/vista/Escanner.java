package vista;

import controlador.Crud;
import controlador.Guardar;
import controlador.Operaciones;
import modelo.Entrenamiento;
import java.util.Scanner;

public class Escanner {
    private Crud crud;

   private Operaciones operaciones;

    private Scanner scanner;

    public Escanner(Crud crud, Operaciones operaciones, Scanner scanner) {
        this.crud = crud;
        this.operaciones = operaciones;
        this.scanner = scanner;
    }

    public void menu(){
        int opcion = 0;

        while (opcion != 5){
            System.out.println("1 .AÑADIR :");
            System.out.println("2. BORRAR :");
            System.out.println("3. LEER :");
            System.out.println("4. ACTUALIZAR :");
            System.out.println("5. REALIZAR MEDIA DE LA DURACION DE LOS ENTRENAMIENTOS :");
            System.out.println("6. SALIR :");


            if (scanner.hasNextInt()){
                opcion = scanner.nextInt();

                switch (opcion){
                    case 1:
                        System.out.println("Añadir entrenamiento...");
                        agregarEntrenamiento();
                        break;
                    case 2:
                        System.out.println("Borrar entrenamiento...");
                        eliminar();
                        break;
                    case 3:
                        System.out.println("Mostrar entrenamiento...");
                        leerEntrenamiento();
                        break;
                    case 4:
                        System.out.println("Actualizar luchadores...");
                       actualizar();
                        break;
                    case 5:
                        System.out.println("Hacer la media");
                        media();
                        break;
                    case 6:
                        System.out.println("Hacer las demas operaciones");
                        calcularEstadisca();
                        break;
                    case 7:
                        System.out.println("Saliendo del programa");
                        break;
                        default:
                        System.out.println("Opción no válida. Por favor, intente de nuevo.");
                        break;
                }
            } else {
                System.out.println("Entrada no válida. Por favor, ingrese un número.");
                scanner.next();
            }
        }

        scanner.close();
    }

    private void agregarEntrenamiento() {
        Scanner scanner = new Scanner(System.in);

        try {
            System.out.println("Ingrese los datos del nuevo entrenamiento:");

            // Solicitar ID
            System.out.print("ID del entrenamiento: ");
            int id = Integer.parseInt(scanner.nextLine());
            scanner.nextLine();

            // Solicitar Nombre
            System.out.print("Nombre del entrenamiento: ");
            String nombre = scanner.nextLine();

            // Solicitar Duración
            System.out.print("Duración del entrenamiento (en minutos): ");
            int duracion = Integer.parseInt(scanner.nextLine());
            scanner.nextLine();

            // Solicitar Nivel
            System.out.print("Nivel del entrenamiento (Básico/Intermedio/Avanzado): ");
            String nivel = scanner.nextLine();

            // Crear el objeto modelo.Entrenamiento
          Entrenamiento entrenamiento = new Entrenamiento(id, nombre, duracion, nivel);

            // Llamar al método agregarEntrenamiento para guardar el nuevo entrenamiento
          crud.agregarEntrenamiento(entrenamiento);

            System.out.println("modelo.Entrenamiento agregado exitosamente.");
        } catch (NumberFormatException e) {
            System.out.println("Error: Entrada numérica no válida.");
        } catch (Exception e) {
            System.out.println("Error al agregar el entrenamiento.");
            e.printStackTrace();
        }
    }

    public void leerEntrenamiento(){
        crud.leerTodos();


    }
    public void actualizar() {
        Scanner scanner = new Scanner(System.in);

        try {
            System.out.println("Actualización de modelo.Entrenamiento");

            // Solicitar el ID del entrenamiento a actualizar
            System.out.print("Ingrese el ID del entrenamiento a actualizar: ");
            int id = Integer.parseInt(scanner.nextLine());

            // Solicitar los nuevos datos
            System.out.println("Ingrese los nuevos datos del entrenamiento:");
            System.out.print("Nuevo nombre: ");
            String nuevoNombre = scanner.nextLine();

            System.out.print("Nueva duración (en minutos): ");
            int nuevaDuracion = Integer.parseInt(scanner.nextLine());

            System.out.print("Nuevo nivel (Básico/Intermedio/Avanzado): ");
            String nuevoNivel = scanner.nextLine();

            // Crear un nuevo objeto modelo.Entrenamiento con los datos actualizados
            Entrenamiento entrenamiento = new Entrenamiento(id, nuevoNombre, nuevaDuracion, nuevoNivel);

            // Llamar al método actualizarEntrenamiento de controlador.Crud
            crud.actualizarEntrenamiento(entrenamiento);

            System.out.println("modelo.Entrenamiento actualizado exitosamente.");
        } catch (NumberFormatException e) {
            System.out.println("Error: Entrada numérica no válida.");
        } catch (Exception e) {
            System.out.println("Error al actualizar el entrenamiento.");
            e.printStackTrace();
        }
    }
    public void eliminar() {
        Scanner scanner = new Scanner(System.in);

        try {
            System.out.println("Eliminación de modelo.Entrenamiento");

            // Solicitar el ID del entrenamiento a eliminar
            System.out.print("Ingrese el ID del entrenamiento a eliminar: ");
            int id = Integer.parseInt(scanner.nextLine());

            // Confirmar la eliminación
            System.out.print("¿Está seguro de que desea eliminar este entrenamiento? (sí/no): ");
            String confirmacion = scanner.nextLine();

            if (confirmacion.equalsIgnoreCase("sí") || confirmacion.equalsIgnoreCase("si")) {
                // Llamar al método eliminarEntrenamiento de controlador.Crud
                crud.eliminarEntrenamiento(id);
                System.out.println("modelo.Entrenamiento eliminado exitosamente.");
            } else {
                System.out.println("Operación cancelada.");
            }
        } catch (NumberFormatException e) {
            System.out.println("Error: Entrada numérica no válida.");
        } catch (Exception e) {
            System.out.println("Error al eliminar el entrenamiento.");
            e.printStackTrace();
        }
    }
public void media(){
        operaciones.calcularMedia();

}
public void calcularEstadisca(){
        operaciones.calcularEstadisticas();
}



}

