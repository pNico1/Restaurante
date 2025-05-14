import EstadosPedido.ListoParaEntregar;
import Notificaciones.NotificadorMesero;

public class ModificadorPedido {
    private Pedido pedido;
    private NotificadorMesero notificador;

    public ModificadorPedido(Pedido pedido, NotificadorMesero notificador) {
        this.pedido = pedido;
        this.notificador = notificador;
    }

    public void cambiarEstado() {
         pedido.getEstado().cambiar(this.pedido);




        System.out.println("Pedido: " + pedido.getNumeroOrden() +  pedido.getEstado().getNombreEstado());

        if (pedido.getEstado() instanceof ListoParaEntregar) {
            notificador.notificar();
        }
    }
}

