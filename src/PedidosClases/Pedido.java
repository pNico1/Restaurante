package PedidosClases;

import EstadosPedido.*;
import MetodosDePago.MetodoDePago;
import MetodosDePago.PagoEfectivo;
import Notificaciones.Notificacion;
import Notificaciones.NotificadorMesero;
import Notificaciones.TipoMedioNotificaciones;
import RestauranteClases.Plato;
import RestauranteClases.Restaurante;
import TiposPedido.TipoPedido;
import Usuarios.Cliente;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public abstract class Pedido {
    private static int contador = 1;
    private int numeroOrden;
    private EstadoPedido estado;
    private Cliente cliente;
    private TipoPedido tipoPedido;
    private ArrayList<Plato> platos = new ArrayList<Plato>();
    private TipoMedioNotificaciones medioNoti;
    private Restaurante restaurante;
    private MetodoDePago metodoDePago;
    private LocalDateTime horaProgramada;
    private Notificacion notificacion;

    public Pedido(Cliente cliente, TipoPedido tipoPedido, TipoMedioNotificaciones medioNoti,Restaurante restaurante, MetodoDePago metodoDePago) {
        this.numeroOrden = contador++;
        this.tipoPedido = tipoPedido;
        this.estado = new EnEspera();
        this.cliente = cliente;
        this.medioNoti = cliente.getTipoMedioNotificaCiones();
        this.restaurante = restaurante;
        this.metodoDePago = metodoDePago;
        this.medioNoti = medioNoti;
        this.notificacion = new Notificacion(this);
        restaurante.agregarPedido(this);
    }

    public Pedido(Cliente cliente, TipoPedido tipoPedido, TipoMedioNotificaciones medioNoti,Restaurante restaurante, MetodoDePago metodoDePago,LocalDateTime horaProgramada) {
        this.numeroOrden = contador++;
        this.tipoPedido = tipoPedido;
        this.estado = new EnCreacion();
        this.cliente = cliente;
        this.medioNoti = cliente.getTipoMedioNotificaCiones();
        this.restaurante = restaurante;
        this.medioNoti = medioNoti;
        this.metodoDePago = metodoDePago;
        this.horaProgramada = horaProgramada;
        this.notificacion = new Notificacion(this);
    }

    public void agregarPlato(Plato plato) {
        if (estado instanceof EnCreacion || estado instanceof EnEspera) {
            platos.add(plato);
        }
        else {
            System.out.println("No se pueden agregar platos");
        }
    }

    public void removerPlato(Plato plato) {
        if (estado instanceof EnCreacion || estado instanceof EnEspera) {
            platos.remove(plato);
        }
        else {
            System.out.println("No se pueden agregar platos");
        }
    }

    public double calcularTotal() {
        return metodoDePago.calcularTotal(this);
    }

    public void cancelarPedido() {
        System.out.println(estado.cancelarPedido(this));
    }


    public void calcularTiempo(){
        estado.calcularTiempo(this);
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

    public Notificacion getNotificacion() {return notificacion;}

    public void setNotificacion(Notificacion notificacion) {this.notificacion = notificacion;}

    public Restaurante getRestaurante() {return restaurante;}

    public void setRestaurante(Restaurante restaurante) {this.restaurante = restaurante;}

    public LocalDateTime getHoraProgramada() {return horaProgramada;}

    public void setHoraProgramada(LocalDateTime horaProgramada) {this.horaProgramada = horaProgramada;}


}
