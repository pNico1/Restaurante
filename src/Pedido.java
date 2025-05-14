import EstadosPedido.EnEspera;
import EstadosPedido.EstadoPedido;
import TiposPedido.TipoPedido;
import Usuarios.Cliente;

public class Pedido {
    private static int contador = 1;
    private int numeroOrden;
    private EstadoPedido estado;
    private Cliente cliente;
    private TipoPedido tipoPedido;

    public Pedido(Cliente cliente, TipoPedido tipoPedido) {
        this.numeroOrden = contador++;
        this.estado = new EnEspera();
        this.cliente = cliente;
    }

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
}
