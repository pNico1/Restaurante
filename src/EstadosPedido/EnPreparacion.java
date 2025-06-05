package EstadosPedido;

import PedidosClases.Pedido;

public class EnPreparacion implements EstadoPedido {
    @Override
    public void cambiar(Pedido pedido) {
        pedido.setEstado(new ListoParaEntregar());
        pedido.getNotificador().notificar();
    }

    @Override
    public String getNombreEstado() {
        return "En preparación";
    }
}
//chequedado