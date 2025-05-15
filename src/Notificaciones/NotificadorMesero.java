package Notificaciones;

import Usuarios.Mesero;

public class NotificadorMesero{
    private Mesero mesero;

    public NotificadorMesero(Mesero mesero) {
        this.mesero = mesero;
    }

    public void notificar() {
        System.out.println("Pedido listo para recoger en cocina: "+mesero.getNombre());
    }
}