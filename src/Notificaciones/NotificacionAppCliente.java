package Notificaciones;

import EstadosPedido.Entregado;

public abstract class NotificacionAppCliente extends NotificadorCliente {


    public NotificacionAppCliente(Pedido pedido) {
        super(pedido);
    }
    public void notificarCliente() {
        String mensaje = "";
        if(pedido.getEstado() instanceof Entregado){
            if(pedido.tipoPedido() instanceof TakeAway){
                mensaje="Listo para recoger el pedido: "+pedido.getNumeroOrden()+", " + pedido.getCliente().getNombre();
            }
            else{
                mensaje="TiposPedido.Delivery en camino, "+" " + pedido.getCliente().getNombre();
            }
        }
        System.out.println(mensaje);
    }
}
