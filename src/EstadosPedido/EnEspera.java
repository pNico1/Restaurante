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

    public String calcularTiempo(Pedido pedido) {
        int tiempo= 0;
        for (Pedido p : pedido.getRestaurante().getPedidos()) {
            tiempo++;
        }
        tiempo = (tiempo % 5) * 20;

        return String.valueOf(tiempo);
    }
    public String cancelarPedido(Pedido pedido){
        pedido.getRestaurante().removerPedido(pedido);
        return "Pedido cancelado, se ha reintegrado un 75% del total";
    }
}

//chequeado
