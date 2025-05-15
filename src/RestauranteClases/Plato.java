package RestauranteClases;

import java.util.List;

public class Plato {

    private String nombre;
    private String descripcion;
    private int precio;
    private List<String> ingredientesAlergenicos;

    public Plato(String nombre, String descripcion, int precio, List<String> ingredientesAlergenicos) { //Construcctor
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.precio = precio;
        this.ingredientesAlergenicos = ingredientesAlergenicos;
    }

    //getters y setters
    public List<String> getIngredientesAlergenicos() {
        return ingredientesAlergenicos;
    }

    public void setIngredientesAlergenicos(List<String> ingredientesAlergenicos) {
        this.ingredientesAlergenicos = ingredientesAlergenicos;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }

    public int getPrecio() {
        return precio;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }


}