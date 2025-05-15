package PedidosClases;

import EstadosPedido.EnEspera;
import EstadosPedido.EstadoPedido;
import MetodosDePago.MetodoDePago;
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
    private double total;
    private TipoMedioNotificaciones medioNoti;
    private Restaurante restaurante;
    private MetodoDePago metodoDePago;

    public Pedido(Cliente cliente, TipoPedido tipoPedido, Restaurante restaurante, MetodoDePago metodoDePago) {
        this.numeroOrden = contador++;
        this.tipoPedido = tipoPedido;
        this.estado = new EnEspera();
        this.cliente = cliente;
        this.medioNoti = cliente.getTipoMedioNotificaCiones();
        this.restaurante = restaurante;
        this.metodoDePago = metodoDePago;
        restaurante.agregarPedido(this);
    }

    public void agregarPlato(Plato plato) {platos.add(plato);}

    public void removerPlato(Plato plato) {platos.remove(plato);}

    public double calcularTotal() {
        total=0;
        for (Plato p : platos) {
            total += p.getPrecio();
        }
        total=metodoDePago.aplicarCupon(total);
        return total;
    }

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
}
