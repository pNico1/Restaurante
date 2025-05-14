package Usuarios;

public class Administrativo extends Usuario {
    public Administrativo(String nombre) {
        super(nombre);
    }

    @Override
    public void modificarPedido(ModificadorPedido modificador) {
        modificador.cambiarEstado();


    }
}
