package MetodosDePago;

public class PagoMercPago {
    int cbu;
    int idTransferencia;
    int monto;

    public PagoMercPago(int cbu, int idTransferencia, int monto) {
        this.cbu = cbu;
        this.idTransferencia = idTransferencia;
        this.monto = monto;
    }

    public int getCbu() {
        return cbu;
    }

    public void setCbu(int cbu) {
        this.cbu = cbu;
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
