package EstadosPedido;

import PedidosClases.Pedido;

public interface EstadoPedido {
    void cambiar(Pedido pedido);
    String getNombreEstado();
}

//chequeado