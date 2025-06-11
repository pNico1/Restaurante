package EstadosPedido;

import MetodosDePago.PagoEfectivo;
import PedidosClases.Pedido;

public interface EstadoPedido {
    void cambiar(Pedido pedido);
    String getNombreEstado();
    String calcularTiempo(Pedido pedido);
    String cancelarPedido(Pedido pedido);
}

//chequeado