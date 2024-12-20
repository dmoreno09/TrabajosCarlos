
import controlador.Crud;
import controlador.Guardar;
import controlador.Operaciones;
import vista.Escanner;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        String ruta = "xml/entrenamiento.txt";
        Guardar guardar = new Guardar(ruta);

        Operaciones operaciones = new Operaciones(guardar);
        Crud crud = new Crud(guardar);

        Scanner scanner = new Scanner(System.in);

        Escanner escanner = new Escanner(crud, operaciones, scanner);
        escanner.menu();
    }
}
