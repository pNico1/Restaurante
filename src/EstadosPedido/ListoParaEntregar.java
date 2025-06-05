package EstadosPedido;

import PedidosClases.Pedido;

public class ListoParaEntregar implements EstadoPedido {
    @Override
    public void cambiar(Pedido pedido) {
        pedido.setEstado(new Entregado());
        pedido.getNotificacion().notificarCliente();
    }

    @Override
    public String getNombreEstado() {
        return "Listo para entregar";
    }
}

//chequeado