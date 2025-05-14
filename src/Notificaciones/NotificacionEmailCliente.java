package Notificaciones;

import EstadosPedido.Entregado;

public class NotificacionEmailCliente extends NotificadorCliente {



    public NotificacionEmailCliente(Pedido pedido) {
        super(pedido);
    }

    @Override
    public void notificarCliente() {
        String mensaje = "";
        if(pedido.getEstado() instanceof Entregado){
            if(pedido.tipoPedido() instanceof TakeAway){
                mensaje="Listo para recoger" + pedido.getCliente().getNombre();
            }
            else{
                mensaje="TiposPedido.Delivery en camino"+" " + pedido.getCliente().getNombre();
            }
        }
        System.out.println(mensaje);
    }
}
