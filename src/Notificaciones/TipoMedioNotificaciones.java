package Notificaciones;

import PedidosClases.Pedido;

public abstract class TipoMedioNotificaciones {
    protected String nombreU;
    public TipoMedioNotificaciones(String nombreU){
        this.nombreU=nombreU;
    }
    public abstract void notificar(Pedido pedido);

}