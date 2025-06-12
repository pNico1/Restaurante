package EstadosPedido;

import PedidosClases.Pedido;
import PedidosClases.PedidoMobile;
import RestauranteClases.Restaurante;
import TiposPedido.Delivery;
import TiposPedido.Rappi;

public class ListoParaEntregar implements EstadoPedido {
    @Override
    public void cambiar(Pedido pedido) {
        pedido.setEstado(new Entregado());
        pedido.getNotificacion().notificarCliente("listo para retirar");
        if (pedido instanceof PedidoMobile){
            ((PedidoMobile) pedido).getNotificador().notificar();
        }
        Restaurante restaurante = (Restaurante) pedido.getRestaurante();
        restaurante.removerPedido(pedido);
        restaurante.generarReporteVentas(pedido);
    }

    @Override
    public String getNombreEstado() {
        return "Listo para entregar";
    }

    @Override
    public String calcularTiempo(Pedido pedido) {

        Integer tiempo=0;

        if (pedido.getTipoPedido() instanceof Delivery) {
            tiempo=((Delivery) pedido.getTipoPedido()).getTiempo();
        }

        return String.valueOf(tiempo);
    }

    public String cancelarPedido(Pedido pedido){
        return "No se  puede cancelar el pedido";
    }
}

//chequeado