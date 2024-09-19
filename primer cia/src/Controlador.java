import java.util.Scanner;

public class Controlador {
    private Scanner scanner;

    public Controlador() {
        // Inicializamos el Scanner en el constructor
        scanner = new Scanner(System.in);
    }


    public String leerZona() {
        System.out.println("Introduce la zona : ");
        return scanner.nextLine();  // Lee una línea de texto
    }


    public int leerEdad() {
        System.out.println("Introduce la edad: ");
        return scanner.nextInt();   // Lee un entero
    }


    public void cerrarScanner() {
        scanner.close();
    }
}
