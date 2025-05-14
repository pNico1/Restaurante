package Notificaciones;

public class Mail extends TipoMedioNotificaciones{

    String nombreU;

    public Mail(String nombreU) {
        super(nombreU);
    }

    public String getEmail(){
        return nombreU;
    }
}
