package EstadosPedido;

import PedidosClases.Pedido;
import RestauranteClases.Plato;

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

    public String calcularTiempo(Pedido pedido) {
        int tiempo=0;
        for (Plato p : pedido.getPlatos()) {
            tiempo=tiempo+p.getTiempoEstimado();
        }
        return String.valueOf(tiempo);
    }
    public String cancelarPedido(Pedido pedido){
        pedido.getRestaurante().removerPedido(pedido);
        return "Pedido cancelado, no se va reintegrar el dinero";
    }
}
//chequedado