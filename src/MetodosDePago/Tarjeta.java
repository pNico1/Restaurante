package MetodosDePago;

import java.math.BigInteger;
import java.util.Date;

public class Tarjeta {
    private String banco;
    private BigInteger numero;
    private String tipo;    //debito credito
    private String nombre;
    private String apellido;
    private Date fechaVencimiento;

    public Tarjeta(String banco, BigInteger numero, String tipo, String nombre, String apellido, Date fechaVencimiento) {
        this.banco = banco;
        this.numero = numero;
        this.tipo = tipo;
        this.nombre = nombre;
        this.apellido = apellido;
        this.fechaVencimiento = fechaVencimiento;
    }
}
