package Notificaciones;

import EstadosPedido.Entregado;
import PedidosClases.Pedido;
import TiposPedido.TakeAway;

public class Notificacion {
    protected Pedido pedido;
    public Notificacion(Pedido pedido){
        this.pedido=pedido;
    }

    public void notificarCliente() {
        String mensaje = "";
            if(pedido.tipoPedido() instanceof TakeAway){
                if (pedido.getMedioNoti() instanceof UserApp){
                    System.out.println("Enviando notificacion a la aplicacion");
                }
                else{
                    System.out.println("Enviando notificacion al mail");
                }
                mensaje="Listo para recoger " + pedido.getCliente().getNombre();
            }
            else{
                if (pedido.getMedioNoti() instanceof UserApp){
                    System.out.println("Enviando notificacion a la aplicacion");
                }
                else {
                    System.out.println("Enviando notificacion al mail");
                }
                mensaje="Delivery en camino"+" " + pedido.getCliente().getNombre();
            }
        System.out.println(mensaje);
    }


    public TipoMedioNotificaciones getTipoMedio() {
        return pedido.getCliente().getTipoMedioNotificaCiones();
    }


    public Pedido getPedido() {
        return pedido;
    }
    }



