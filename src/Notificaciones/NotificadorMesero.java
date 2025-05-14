package Notificaciones;

import Usuarios.Mesero;

public class NotificadorMesero implements Notificador {
    private Mesero mesero;

    public NotificadorMesero(Mesero mesero) {
        this.mesero = mesero;
    }

    @Override
    public void notificar() {
        System.out.println("Pedido listo para recoger en cocina: "+mesero.getNombre());
    }
}