package PedidosClases;

import EstadosPedido.Entregado;
import EstadosPedido.ListoParaEntregar;
import Notificaciones.Notificacion;
import Notificaciones.NotificadorMesero;
import TiposPedido.Delivery;

public class ModificadorPedido {
    private Pedido pedido;
    private NotificadorMesero notificador;
    private Notificacion notificacion;

    public ModificadorPedido(Pedido pedido, NotificadorMesero notificador) {
        this.pedido = pedido;
        this.notificador = notificador;
        notificacion = new Notificacion(pedido);
    }

    public void cambiarEstado() {
        pedido.getEstado().cambiar(this.pedido);


        System.out.println("Pedido: " + pedido.getNumeroOrden() + " " + pedido.getEstado().getNombreEstado());

        if (pedido.getEstado() instanceof ListoParaEntregar) {
            notificador.notificar();
        }

        if (pedido.getEstado() instanceof Entregado) {
            notificacion.notificarCliente();
        }
    }
    public Pedido getPedido() {
        return pedido;
    }
}

