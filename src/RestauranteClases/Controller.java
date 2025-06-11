package RestauranteClases;

import java.time.LocalDateTime;

public class Controller implements Observer {

    @Override
    public void actualizarHora(LocalDateTime hora) {
        System.out.println("Cambio de hora");
        System.out.println(hora.toString());
    }
}