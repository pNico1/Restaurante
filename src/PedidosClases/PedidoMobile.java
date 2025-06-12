package PedidosClases;

import MetodosDePago.Cupon;
import MetodosDePago.MetodoDePago;
import Notificaciones.Notificacion;
import Notificaciones.NotificadorMesero;
import Notificaciones.TipoMedioNotificaciones;
import RestauranteClases.Restaurante;
import TiposPedido.TipoPedido;
import Usuarios.Cliente;

import java.time.LocalDateTime;

public class PedidoMobile extends Pedido {
    private NotificadorMesero notificador;


    public PedidoMobile(Cliente cliente, TipoPedido tipoPedido, TipoMedioNotificaciones medioNoti, Restaurante restaurante, MetodoDePago metodoDePago, NotificadorMesero notificador) {
        super(cliente, tipoPedido, medioNoti, restaurante, metodoDePago);
        this.notificador = notificador;
    }

    public PedidoMobile(Cliente cliente, TipoPedido tipoPedido, TipoMedioNotificaciones medioNoti, Restaurante restaurante, MetodoDePago metodoDePago, LocalDateTime horaProgramada, NotificadorMesero notificador){
        super(cliente, tipoPedido, medioNoti, restaurante, metodoDePago, horaProgramada);
        this.notificador = notificador;
    }

    @Override
    public double calcularTotal() {
        double totalOriginal = super.calcularTotal();
        Cupon cupon = super.getMetodoDePago().getCupon();
        if (cupon != null && cupon.isValido()){
            totalOriginal=super.getMetodoDePago().aplicarCupon(totalOriginal);
        }
        return totalOriginal;
    }

    public NotificadorMesero getNotificador() {
        return notificador;
    }

    public void setNotificador(NotificadorMesero notificador) {
        this.notificador = notificador;
    }
}