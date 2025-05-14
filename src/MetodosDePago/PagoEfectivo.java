package MetodosDePago;

public class PagoEfectivo extends MetodoDePago{
    private int pagaCon;

    public PagoEfectivo(int pagaCon, int total) {
        this.total=total;
        this.pagaCon = pagaCon;
        this.nombre = "Efectivo";
    }
}
