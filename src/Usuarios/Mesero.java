package Usuarios;

import EstadosPedido.EnEspera;
import PedidosClases.ModificadorPedido;

public class Mesero extends Usuario {
    public Mesero(String nombre) {
        super(nombre);
    }

    @Override
    public void modificarPedido(ModificadorPedido modificador) {
        if (modificador.getPedido().getEstado() instanceof EnEspera) {
            modificador.cambiarEstado();
        }
    }
}