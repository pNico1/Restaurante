package PedidosClases;

import MetodosDePago.MetodoDePago;
import Notificaciones.Notificacion;
import Notificaciones.NotificadorMesero;
import Notificaciones.TipoMedioNotificaciones;
import RestauranteClases.Restaurante;
import TiposPedido.TipoPedido;
import Usuarios.Cliente;

import java.time.LocalDateTime;

public class PedidoFactory {

    public PedidoFactory() {};

    public Pedido createPedido(Cliente cliente, TipoPedido tipoPedido, TipoMedioNotificaciones medioNoti, Restaurante restaurante, MetodoDePago metodoDePago, LocalDateTime horaProgramada, NotificadorMesero notificador) {
        return new PedidoMobile(cliente, tipoPedido, medioNoti, restaurante, metodoDePago, horaProgramada, notificador);
    }

    public Pedido createPedido(Cliente cliente, TipoPedido tipoPedido, TipoMedioNotificaciones medioNoti, Restaurante restaurante, MetodoDePago metodoDePago, NotificadorMesero notificador){
        return new PedidoMobile(cliente, tipoPedido, medioNoti, restaurante, metodoDePago, notificador);
    }

    public Pedido createPedido(Cliente cliente, TipoPedido tipoPedido, TipoMedioNotificaciones medioNoti, Restaurante restaurante, MetodoDePago metodoDePago){
        return new PedidoTotem(cliente, tipoPedido, medioNoti, restaurante, metodoDePago);
    }

    public Pedido createPedido(Cliente cliente, TipoPedido tipoPedido, TipoMedioNotificaciones medioNoti, Restaurante restaurante, MetodoDePago metodoDePago, LocalDateTime horaProgramada){
        return new PedidoTotem(cliente, tipoPedido, medioNoti, restaurante, metodoDePago, horaProgramada);
    }
}
