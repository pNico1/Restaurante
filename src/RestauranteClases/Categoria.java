package RestauranteClases;

import java.util.ArrayList;
import java.util.List;

public class Categoria {
    private String nombre;
    private List<Plato> platos;

    public Categoria(String nombre) {
        this.nombre = nombre;
        this.platos = new ArrayList<>();
    }

    public void agregarPlato(Plato plato) {
        platos.add(plato);
    }

    public void eliminarPlato(Plato plato) {
        platos.remove(plato);
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public List<Plato> getPlatos() {
        return platos;
    }
}
