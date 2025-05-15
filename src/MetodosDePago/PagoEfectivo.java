package MetodosDePago;

public class PagoEfectivo extends MetodoDePago{
    private int pagaCon;

    public PagoEfectivo(int pagaCon) {
        this.pagaCon = pagaCon;
        this.nombre = "Efectivo";
    }

    public PagoEfectivo(int pagaCon,Cupon cupon) {
        this.pagaCon = pagaCon;
        this.nombre = "Efectivo";
        this.cupon = cupon;
    }
}
