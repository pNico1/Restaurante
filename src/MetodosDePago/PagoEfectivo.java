package MetodosDePago;

import PedidosClases.Pedido;
import RestauranteClases.Plato;

public class PagoEfectivo extends MetodoDePago{
    private int pagaCon;

    public PagoEfectivo(int pagaCon) {
        this.pagaCon = pagaCon;
        this.nombre = "Efectivo";
    }

    public PagoEfectivo(int pagaCon,Cupon cupon) {
        this.pagaCon = pagaCon;
        this.nombre = "Efectivo";
        this.cupon = cupon;
    }

    @Override
    public double calcularTotal(Pedido pedido){
        double total = 0;

        for (Plato p : pedido.getPlatos()) {
            total += p.getPrecio();
        }

        total = total * 0.9;

        return total;
    }
}
