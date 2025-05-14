package Usuarios;

public class Mesero extends Usuario {
    public Mesero(String nombre) {
        super(nombre);
    }

    @Override
    public void modificarPedido(ModificadorPedido modificador) {
        modificador.cambiarEstado();
    }


}