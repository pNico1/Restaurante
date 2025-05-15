package MetodosDePago;

public class Cupon {
    private String codigo;
    private double descuento; // porcentaje entre 0 y 1
    private boolean valido;

    public Cupon(String codigo, double descuento, boolean valido) {
        this.codigo = codigo;
        this.descuento = descuento;  // 0 > descuento > 1
        this.valido = valido;
    }

    public double aplicarDescuento(double total) {
        if (isValido()) {
            return (int)(total * (1 - descuento));
        }
        return total;
    }

    //getters y setters
    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public double getDescuento() {
        return descuento;
    }

    public void setDescuento(double descuento) {
        this.descuento = descuento;
    }

    public boolean isValido() {
        return valido ;
    }

    public void setValido(boolean valido) {
        this.valido = valido;
    }
}