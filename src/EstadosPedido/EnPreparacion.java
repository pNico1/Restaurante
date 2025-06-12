package EstadosPedido;

import PedidosClases.Pedido;
import PedidosClases.PedidoMobile;
import RestauranteClases.Plato;
import RestauranteClases.Restaurante;

public class EnPreparacion implements EstadoPedido {
    @Override
    public void cambiar(Pedido pedido) {
        pedido.setEstado(new ListoParaEntregar());
        pedido.getNotificacion().notificarCliente("en preparacion");
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