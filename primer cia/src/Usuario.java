import java.util.Objects;

public class Usuario {
    private int id;

    private int edad;

    public Usuario(int id, int edad) {
        this.id = id;
        this.edad = edad;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    @Override
    public String toString() {
        return "Usuario{" +
                "id=" + id +
                ", edad=" + edad +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Usuario usuario = (Usuario) o;
        return id == usuario.id && edad == usuario.edad;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, edad);
    }
}
