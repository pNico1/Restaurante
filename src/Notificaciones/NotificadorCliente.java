package Notificaciones;

public abstract class NotificadorCliente {
    protected Pedido pedido;
    public NotificadorCliente(Pedido pedido){
        this.pedido=pedido;
    }

    public abstract void notificarCliente();


}
