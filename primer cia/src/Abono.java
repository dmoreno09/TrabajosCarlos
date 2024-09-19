public class Abono {
    private String zona;
    private int edadinicial;

    private int edadfinal;

    private int precio;

    public Abono(String zona, int edadinicial, int edadfinal, int precio) {
        this.zona = zona;
        this.edadinicial = edadinicial;
        this.edadfinal = edadfinal;
        this.precio = precio;
    }

    public String getZona() {
        return zona;
    }

    public void setZona(String zona) {
        this.zona = zona;
    }

    public int getEdadinicial() {
        return edadinicial;
    }

    public void setEdadinicial(int edadinicial) {
        this.edadinicial = edadinicial;
    }

    public int getEdadfinal() {
        return edadfinal;
    }

    public void setEdadfinal(int edadfinal) {
        this.edadfinal = edadfinal;
    }

    public int getPrecio() {
        return precio;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }

    @Override
    public String toString() {
        return "Abono{" +
                "zona='" + zona + '\'' +
                ", edadinicial=" + edadinicial +
                ", edadfinal=" + edadfinal +
                ", precio=" + precio +
                '}';
    }


}