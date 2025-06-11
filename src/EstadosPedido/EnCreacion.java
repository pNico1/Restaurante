package EstadosPedido;

import PedidosClases.Pedido;

import java.time.LocalDateTime;

public class EnCreacion implements EstadoPedido {
    @Override
    public void cambiar(Pedido pedido) {
        LocalDateTime ahora = LocalDateTime.now();
        if (!ahora.isBefore(pedido.getHoraProgramada())) {
            pedido.setEstado(new EnEspera());
            System.out.println("El pedido pasó a estado En Espera");
            pedido.getRestaurante().agregarPedido(pedido);
        }
        else {
            System.out.println("Todavia no es la hora programada");
        }
    }
    @Override
    public String getNombreEstado() {
        return "";
    }

    @Override
    public String calcularTiempo(Pedido pedido) {
        return "El pedido se empezara a preparar a las: " + pedido.getHoraProgramada();
    }
    public String cancelarPedido(Pedido pedido){
        pedido.getRestaurante().removerPedido(pedido);
        return "El pedido se ha cancelado con exito";
    }
}