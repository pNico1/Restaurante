package Usuarios;

import Notificaciones.TipoMedioNotificaciones;
import RestauranteClases.Categoria;
import RestauranteClases.Menu;
import RestauranteClases.Plato;

public class Cliente {
    private String nombre;
    private String telefono;
    private TipoMedioNotificaciones tipoMedioNotificaciones;

    public Cliente(String nombre, TipoMedioNotificaciones tipoMedioNotificaciones, String telefono) {
        this.nombre = nombre;
        this.tipoMedioNotificaciones = tipoMedioNotificaciones;
        this.telefono = telefono;
    }


    public TipoMedioNotificaciones getTipoMedioNotificaCiones() { return tipoMedioNotificaciones; }

    public String getNombre() { return nombre; }
    public String getTelefono() { return telefono; }

}