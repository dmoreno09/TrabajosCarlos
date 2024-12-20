package modelo;

import java.util.ArrayList;
import java.util.Objects;

public class ListaEntrenamiento {
    private final Entrenamiento entrenamiento;
    private ArrayList<Entrenamiento> listasEntrenamiento;

    public ListaEntrenamiento(Entrenamiento entrenamiento, ArrayList<Entrenamiento> listasEntrenamiento) {
        this.entrenamiento = entrenamiento;
        this.listasEntrenamiento = listasEntrenamiento;
    }

    public Entrenamiento getEntrenamiento() {
        return entrenamiento;
    }

    public ArrayList<Entrenamiento> getListasEntrenamiento() {
        return listasEntrenamiento;
    }

    public void setListasEntrenamiento(ArrayList<Entrenamiento> listasEntrenamiento) {
        this.listasEntrenamiento = listasEntrenamiento;
    }

    @Override
    public String toString() {
        return "modelo.ListaEntrenamiento{" +
                "entrenamiento=" + entrenamiento +
                ", listasEntrenamiento=" + listasEntrenamiento +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ListaEntrenamiento that = (ListaEntrenamiento) o;
        return Objects.equals(entrenamiento, that.entrenamiento) && Objects.equals(listasEntrenamiento, that.listasEntrenamiento);
    }

    @Override
    public int hashCode() {
        return Objects.hash(entrenamiento, listasEntrenamiento);
    }
}

