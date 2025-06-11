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
    private LocalDateTime horaProgramada;

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

    public Pedido(Cliente cliente, TipoPedido tipoPedido, Restaurante restaurante, MetodoDePago metodoDePago, NotificadorMesero notificador, Notificacion notificacion, LocalDateTime
                  horaProgramada) {
        this.numeroOrden = contador++;
        this.tipoPedido = tipoPedido;
        this.estado = new EnCreacion();
        this.cliente = cliente;
        this.medioNoti = cliente.getTipoMedioNotificaCiones();
        this.restaurante = restaurante;
        this.metodoDePago = metodoDePago;
        this.notificacion = notificacion;
        this.notificador = notificador;
        this.horaProgramada = horaProgramada;
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
        System.out.println(estado.cancelarPedido(this));
    }

//    public int calculartiempoRestante(){
//        if (estado instanceof EnEspera){
//            return calcularTiempoRestanteEnEspera();
//        }
//        else if (estado instanceof EnPreparacion){
//            return calculartiempoRestanteEnPreparacion();
//        }
//        else if (estado instanceof ListoParaEntregar){
//            return 0;
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

    public Restaurante getRestaurante() {return restaurante;}

    public void setRestaurante(Restaurante restaurante) {this.restaurante = restaurante;}

    public LocalDateTime getHoraProgramada() {return horaProgramada;}

    public void setHoraProgramada(LocalDateTime horaProgramada) {this.horaProgramada = horaProgramada;}
}
