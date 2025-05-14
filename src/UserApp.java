import Notificaciones.TipoMedioNotificaciones;

public class UserApp extends TipoMedioNotificaciones {
    private String nombreU;
    public UserApp(String nombreU) {
        super(nombreU);
    }
    public String getUser(){
        return nombreU;
    }
}
