import java.util.Objects;

public class Precios {
    private int id;

    private double precio;

    public Precios(int id, double precio) {
        this.id = id;
        this.precio = precio;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    @Override
    public String toString() {
        return "Precios{" +
                "id=" + id +
                ", precio=" + precio +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Precios precios = (Precios) o;
        return id == precios.id && Double.compare(precio, precios.precio) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, precio);
    }
}