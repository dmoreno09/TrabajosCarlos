import java.util.Objects;

public class Zona {
    private int id;

    private String zona;

    public Zona(int id, String zona) {
        this.id = id;
        this.zona = zona;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getZona() {
        return zona;
    }

    public void setZona(String zona) {
        this.zona = zona;
    }

    @Override
    public String toString() {
        return "Zona{" +
                "id=" + id +
                ", zona='" + zona + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Zona zona1 = (Zona) o;
        return id == zona1.id && Objects.equals(zona, zona1.zona);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, zona);
    }
}
