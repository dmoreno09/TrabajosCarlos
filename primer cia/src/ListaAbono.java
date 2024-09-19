import java.util.ArrayList;

public class ListaAbono {
    private ArrayList<Abono> abono = new ArrayList<Abono>();// IMPORTANTE HACERLO ASI

    public ListaAbono() {

        abono.add(new Abono("A", 0, 18, 5));   // 0 a 18 años en zona A, precio 5$
        abono.add(new Abono("A", 18, 40, 10)); // 18 a 40 años en zona A, precio 10$
        abono.add(new Abono("A", 40, 80, 8));  // 40 a 80 años en zona A, precio 8$

        abono.add(new Abono("B", 0, 18, 6));   // 0 a 18 años en zona B, precio 6$
        abono.add(new Abono("B", 18, 40, 12)); // 18 a 40 años en zona B, precio 12$
        abono.add(new Abono("B", 40, 80, 9));  // 40 a 80 años en zona B, precio 9$

        abono.add(new Abono("C", 0, 18, 4));   // 0 a 18 años en zona C, precio 4$
        abono.add(new Abono("C", 18, 40, 11)); // 18 a 40 años en zona C, precio 11$
        abono.add(new Abono("C", 40, 80, 7));  // 40 a 80 años en zona C, precio 7$
    }

    public double calcularPrecio(String zona, int edad) {

        for (Abono abono1 : abono) {
            if (abono1.getZona().equals(zona) && edad >= abono1.getEdadinicial() && edad < abono1.getEdadfinal()) {
                return abono1.getPrecio();
            }
        }
        return 0;
    }

    public static void main(String[] args) {

        Controlador controlador = new Controlador();


        String zona = controlador.leerZona();
        int edad = controlador.leerEdad();

        ListaAbono listaAbonos = new ListaAbono();


        double precio = listaAbonos.calcularPrecio(zona, edad);


        if (precio != 0) {
            System.out.println("El precio para la zona " + zona + " y la edad " + edad + " es: $" + precio);
        } else {
            System.out.println("No se encontró un abono para esa zona y edad.");
        }


        controlador.cerrarScanner();
    }
}
