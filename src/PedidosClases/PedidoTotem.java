package PedidosClases;

import MetodosDePago.MetodoDePago;
import Notificaciones.Notificacion;
import Notificaciones.NotificadorMesero;
import Notificaciones.TipoMedioNotificaciones;
import RestauranteClases.Restaurante;
import TiposPedido.TipoPedido;
import Usuarios.Cliente;

import java.time.LocalDateTime;

public class PedidoTotem extends Pedido {
    public PedidoTotem(Cliente cliente, TipoPedido tipoPedido, TipoMedioNotificaciones medioNoti, Restaurante restaurante, MetodoDePago metodoDePago) {
        super(cliente, tipoPedido, medioNoti, restaurante, metodoDePago);
    }

    public PedidoTotem(Cliente cliente, TipoPedido tipoPedido, TipoMedioNotificaciones medioNoti, Restaurante restaurante, MetodoDePago metodoDePago, LocalDateTime horaProgramada){
        super(cliente, tipoPedido, medioNoti, restaurante, metodoDePago, horaProgramada);
    }


    @Override
    public double calcularTotal() {
        double totalOriginal = super.calcularTotal();
        totalOriginal= super.getMetodoDePago().aplicarCupon(totalOriginal);
        return totalOriginal;
    }
}