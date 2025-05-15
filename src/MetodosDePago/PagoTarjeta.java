package MetodosDePago;

public class PagoTarjeta extends MetodoDePago{
    private Tarjeta tarjeta;

    public PagoTarjeta(Tarjeta tarjeta) {
        this.tarjeta = tarjeta;
        this.nombre="Tarjeta";
    }
    public PagoTarjeta(Tarjeta tarjeta,Cupon cupon) {
        this.tarjeta = tarjeta;
        this.nombre="Tarjeta";
        this.cupon=cupon;
    }
}
