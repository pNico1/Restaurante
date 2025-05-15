package EstadosPedido;

import PedidosClases.Pedido;

public class EnEspera implements EstadoPedido {
    @Override
    public void cambiar(Pedido pedido) {
        pedido.setEstado(new EnPreparacion());
    }

    @Override
    public String getNombreEstado() {
        return "En espera";
    }
}

//chequeado
