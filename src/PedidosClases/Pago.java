package PedidosClases;

public class Pago {
    private String metodo; // "Tarjeta de crédito" o "Tarjeta de débito"
    private String estado; // "Pendiente", "Aprobado", "Rechazado"
    private int monto;

    public Pago(String metodo, int monto) {
        this.metodo = metodo;
        this.monto = monto;
        this.estado = "Pendiente";
    }

    //public boolean procesarPago() {} TODO

    public int aplicarCupon(Cupon cupon) {
        return cupon.aplicarDescuento(monto);
    }

    public String getMetodo() {
        return metodo;
    }

    public void setMetodo(String metodo) {
        this.metodo = metodo;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public int getMonto() {
        return monto;
    }

    public void setMonto(int monto) {
        this.monto = monto;
    }
}