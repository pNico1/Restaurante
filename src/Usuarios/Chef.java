package Usuarios;

import PedidosClases.ModificadorPedido;

public class Chef extends Usuario {
    public Chef(String nombre) {
        super(nombre);
    }

    @Override
    public void modificarPedido(ModificadorPedido modificador) {
        modificador.cambiarEstado();
    }
}
