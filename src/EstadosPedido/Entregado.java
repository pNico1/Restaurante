package EstadosPedido;

public class Entregado implements EstadoPedido {
    @Override
    public void cambiar(Pedido pedido) {
        System.out.println("El pedido ya fue entregado.");
    }

    @Override
    public String getNombreEstado() {
        return "EstadosPedido.Entregado";
    }
}
//chequeado