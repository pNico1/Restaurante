package EstadosPedido;

public class ListoParaEntregar implements EstadoPedido {
    @Override
    public void cambiar(Pedido pedido) {
        pedido.setEstado(new Entregado());
    }

    @Override
    public String getNombreEstado() {
        return "Listo para entregar";
    }
}

//chequeado