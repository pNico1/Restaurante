package Notificaciones;

import EstadosPedido.Entregado;
import PedidosClases.Pedido;

public class Mail extends TipoMedioNotificaciones{


    public Mail(String nombreU) {
        super(nombreU);
    }

    public String getEmail(){
        return nombreU;
    }
    public void notificar(Pedido pedido) {
        if (pedido.getEstado() instanceof Entregado) {
            System.out.println("Envio a mail: " + nombreU);
            new Notificacion(pedido).notificarCliente(pedido.getEstado().getNombreEstado());
        }
    }
}