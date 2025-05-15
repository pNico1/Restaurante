package RestauranteClases;

import java.util.ArrayList;
import java.util.List;

public class Menu {
    private List<Categoria> categorias;

    public Menu() {
        this.categorias = new ArrayList<>();
    }

    public void agregarCategoria(Categoria categoria) {
        categorias.add(categoria);
    }

    public void eliminarCategoria(Categoria categoria) {
        categorias.remove(categoria);
    }

    public List<Plato> obtenerPlatos(Categoria categoria) {
        return categoria.getPlatos();
    }

    public List<Categoria> obtenerCategorias() {
        return categorias;
    }
}
