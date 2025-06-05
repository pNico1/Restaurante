package PedidosClases;

import EstadosPedido.Entregado;
import EstadosPedido.ListoParaEntregar;
import Notificaciones.Notificacion;
import Notificaciones.NotificadorMesero;
import TiposPedido.Delivery;

public class ModificadorPedido {
    private Pedido pedido;


    public ModificadorPedido(Pedido pedido) {
        this.pedido = pedido;
    }

    public void cambiarEstado() {
        pedido.getEstado().cambiar(this.pedido);


        System.out.println("Pedido: " + pedido.getNumeroOrden() + " " + pedido.getEstado().getNombreEstado());

    }
    public Pedido getPedido() {
        return pedido;
    }
}

