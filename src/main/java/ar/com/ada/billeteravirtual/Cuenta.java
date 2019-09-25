package ar.com.ada.billeteravirtual;

import java.util.ArrayList;

import javax.persistence.*;

import javassist.expr.NewArray;

import java.util.*;

/**
 * Cuenta
 */

@Entity
@Table(name = "cuenta")
public class Cuenta {

    @Id
    @Column(name = "cuenta_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int nroCuentaId;

    @ManyToOne // estas dos anotaciones van siempre q este la tabla de FK, o @onetomany
    @JoinColumn(name = "billetera_id", referencedColumnName = "billetera_id")
    private Billetera billetera;

    @OneToMany(mappedBy = "cuenta", cascade = CascadeType.ALL)
    private List<Movimiento> movimientos = new ArrayList<Movimiento>();
    // @OneToMany (mappedBy = "cuentaDestino_id", cascade = CascadeType.ALL)
    // private Movimiento movimiento;

    private String moneda;
    private double saldo;
    private double saldoDisponible;

    public int getNroCuentaId() {
        return nroCuentaId;
    }

    public void setNroCuentaId(int nroCuentaId) {
        this.nroCuentaId = nroCuentaId;
    }

    public Billetera getBilletera() {
        return billetera;
    }

    public void setBilletera(Billetera billetera) {
        this.billetera = billetera;
    }

    public String getMoneda() {
        return moneda;
    }

    public void setMoneda(String moneda) {
        this.moneda = moneda;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public double getSaldoDisponible() {
        return saldoDisponible;
    }

    public void setSaldoDisponible(double saldoDisponible) {
        this.saldoDisponible = saldoDisponible;
    }

    /*public void depositoDinero(Movimiento movimiento) {
        movimiento.setSaldo(this);
        this.movimiento.add(movimiento);

    }*/

    public List<Movimiento> getMovimientos() {
        return movimientos;
    }

    public void setMovimientos(List<Movimiento> movimientos) {
        this.movimientos = movimientos;
    }

}