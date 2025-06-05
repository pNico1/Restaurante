package PedidosClases;

import EstadosPedido.EnEspera;
import EstadosPedido.EnPreparacion;
import EstadosPedido.EstadoPedido;
import EstadosPedido.ListoParaEntregar;
import MetodosDePago.MetodoDePago;
import MetodosDePago.PagoEfectivo;
import Notificaciones.Notificacion;
import Notificaciones.NotificadorMesero;
import Notificaciones.TipoMedioNotificaciones;
import RestauranteClases.Plato;
import RestauranteClases.Restaurante;
import TiposPedido.TipoPedido;
import Usuarios.Cliente;

import java.util.ArrayList;
import java.util.List;

public class Pedido {
    private static int contador = 1;
    private int numeroOrden;
    private EstadoPedido estado;
    private Cliente cliente;
    private TipoPedido tipoPedido;
    private ArrayList<Plato> platos = new ArrayList<Plato>();
    private TipoMedioNotificaciones medioNoti;
    private Restaurante restaurante;
    private MetodoDePago metodoDePago;
    private NotificadorMesero notificador;
    private Notificacion notificacion;

    public Pedido(Cliente cliente, TipoPedido tipoPedido, Restaurante restaurante, MetodoDePago metodoDePago, NotificadorMesero notificador, Notificacion notificacion) {
        this.numeroOrden = contador++;
        this.tipoPedido = tipoPedido;
        this.estado = new EnEspera();
        this.cliente = cliente;
        this.medioNoti = cliente.getTipoMedioNotificaCiones();
        this.restaurante = restaurante;
        this.metodoDePago = metodoDePago;
        restaurante.agregarPedido(this);
        this.notificacion = notificacion;
        this.notificador = notificador;
    }

    public void agregarPlato(Plato plato) {platos.add(plato);}

    public void removerPlato(Plato plato) {platos.remove(plato);}

    public double calcularTotal() {
        double total=0;
        for (Plato p : platos) {
            total += p.getPrecio();
        }
        total=metodoDePago.aplicarCupon(total);
        if (metodoDePago instanceof PagoEfectivo){
            total = total * 0.9;
        }
        return total;
    }

    public void cancelarPedido() {
        if (estado instanceof EnEspera || estado instanceof EnPreparacion){
            restaurante.getPedidos().remove(this);
        }
        else {
            System.out.println("El pedido no se puede cancelar");
        }
    }

//    public int calcularTiempoRestante() {
//        int tiempoRestante = 0;
//        if (!(estado instanceof ListoParaEntregar)){
//            List<Pedido> pedidos = restaurante.getPedidos();
//            int cont = 0;
//            for (Pedido p : pedidos){
//                cont++;
//            }
//            tiempoRestante = (cont % 5) *20
//        }
//    }

    public MetodoDePago getMetodoDePago() {return metodoDePago;}

    public void setMetodoDePago(MetodoDePago metodoDePago) {this.metodoDePago = metodoDePago;}

    public ArrayList<Plato> getPlatos() {return platos;}

    public int getNumeroOrden() {
        return numeroOrden;
    }

    public EstadoPedido getEstado() {
        return estado;
    }

    public void setEstado(EstadoPedido estado) {
        this.estado = estado;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public TipoPedido tipoPedido(){
        return tipoPedido;
    }

    public TipoPedido getTipoPedido() {return tipoPedido;}

    public void setTipoPedido(TipoPedido tipoPedido) {this.tipoPedido = tipoPedido;}

    public void resetContador() {contador = 1;}

    public TipoMedioNotificaciones getMedioNoti() {
        return medioNoti;
    }

    public void setMedioNoti(TipoMedioNotificaciones medioNoti) {
        this.medioNoti = medioNoti;
    }

    public Notificacion getNotificacion() {return notificacion;}

    public void setNotificacion(Notificacion notificacion) {this.notificacion = notificacion;}

    public NotificadorMesero getNotificador() {return notificador;}

    public void setNotificador(NotificadorMesero notificador) {this.notificador = notificador;}
}
