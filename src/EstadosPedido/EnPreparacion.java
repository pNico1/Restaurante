package EstadosPedido;

public class EnPreparacion implements EstadoPedido {
    @Override
    public void cambiar(Pedido pedido) {
        pedido.setEstado(new ListoParaEntregar());
    }

    @Override
    public String getNombreEstado() {
        return "En preparación";
    }
}
//chequedado