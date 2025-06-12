package EstadosPedido;

import PedidosClases.Pedido;
import RestauranteClases.Plato;

public class EnEspera implements EstadoPedido {
    @Override
    public void cambiar(Pedido pedido) {
        pedido.setEstado(new EnPreparacion());
        pedido.getNotificacion().notificarCliente("en espera");
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

        for (Plato p : pedido.getPlatos()) {
            tiempo = tiempo + p.getTiempoEstimado();
        }

        return String.valueOf(tiempo);
    }
    public String cancelarPedido(Pedido pedido){
        pedido.getRestaurante().removerPedido(pedido);
        return "Pedido cancelado, se ha reintegrado un 75% del total";
    }
}

//chequeado
