package MetodosDePago;

public class PagoGoogle {
    int idGoogle;
    int idTransferencia;
    int monto;

    public PagoGoogle(int monto, int idTransferencia, int idGoogle) {
        this.monto = monto;
        this.idTransferencia = idTransferencia;
        this.idGoogle = idGoogle;
    }

    public int getIdGoogle() {
        return idGoogle;
    }

    public void setIdGoogle(int idGoogle) {
        this.idGoogle = idGoogle;
    }

    public int getIdTransferencia() {
        return idTransferencia;
    }

    public void setIdTransferencia(int idTransferencia) {
        this.idTransferencia = idTransferencia;
    }

    public int getMonto() {
        return monto;
    }

    public void setMonto(int monto) {
        this.monto = monto;
    }
}
