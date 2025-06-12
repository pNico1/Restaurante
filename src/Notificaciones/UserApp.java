package Notificaciones;

import EstadosPedido.Entregado;
import PedidosClases.Pedido;

public class UserApp extends TipoMedioNotificaciones{

    public UserApp(String nombreU) {
        super(nombreU);
    }

    @Override
    public void notificar(Pedido pedido) {
        if (pedido.getEstado() instanceof Entregado) {
            System.out.println("Envio a usuario: " + nombreU);
            new Notificacion(pedido).notificarCliente(pedido.getEstado().getNombreEstado());
        }
    }
    public String getUser(){
        return nombreU;
    }
}
