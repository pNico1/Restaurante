package TiposPedido;

import java.util.*;

public class Rappi{
    private int tiempo;

    public Rappi() {
        Random rand = new Random();
        tiempo = rand.nextInt(1, 20);
    }

    public int getTiempo() {
        return tiempo;
    }
}
