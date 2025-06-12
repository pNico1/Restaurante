package TiposPedido;

public class Delivery extends TipoPedido{
    int tiempo;
    Rappi rappi;
    public Delivery() {
        this.rappi = new Rappi();
        this.tiempo = rappi.getTiempo();
    }

    public int getTiempo() {
        return tiempo;
    }
}
