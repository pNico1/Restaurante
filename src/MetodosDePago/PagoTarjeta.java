package MetodosDePago;

public class PagoTarjeta extends MetodoDePago{
    private Tarjeta tarjeta;

    public PagoTarjeta(double total, Tarjeta tarjeta) {
        this.total = total;
        this.tarjeta = tarjeta;
        this.nombre="Tarjeta";
    }
}
