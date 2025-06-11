package EstadosPedido;

import PedidosClases.Pedido;
import TiposPedido.Rappi;

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

    @Override
    public String calcularTiempo(Pedido pedido) {

        Integer tiempo=0;

        if (pedido.getTipoPedido() instanceof Rappi) {
            tiempo=((Rappi) pedido.getTipoPedido()).getTiempo();
        }

        return String.valueOf(tiempo);
    }

    public String cancelarPedido(Pedido pedido){
        return "No se  puede cancelar el pedido";
    }
}

//chequeado