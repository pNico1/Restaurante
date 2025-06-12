package MetodosDePago;

import PedidosClases.Pedido;
import RestauranteClases.Plato;

public abstract class MetodoDePago {
    String nombre;
    Cupon cupon;

    public double aplicarCupon(double total){
        if (cupon != null) {
            if (cupon.isValido()){
                total= cupon.aplicarDescuento(total);
            }
        }
        return total;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Cupon getCupon() {
        return cupon;
    }

    public void setCupon(Cupon cupon) {
        this.cupon = cupon;
    }

    public double calcularTotal(Pedido pedido){
        double total=0;
        for (Plato p : pedido.getPlatos()) {
            total += p.getPrecio();
        }
        return total;
    }
}
