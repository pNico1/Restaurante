package EstadosPedido;

import PedidosClases.Pedido;

public class Entregado implements EstadoPedido {
    @Override
    public void cambiar(Pedido pedido) {
        System.out.println("El pedido ya fue entregado.");
    }

    @Override
    public String getNombreEstado() {
        return "Entregado";
    }

    public String calcularTiempo(Pedido pedido) {
        return "El pedido ya fue entregado.";
    }

    public String cancelarPedido(Pedido pedido){
        pedido.getRestaurante().removerPedido(pedido);
        return "No se puede cancelar el pedido";
    }
}
//chequeado