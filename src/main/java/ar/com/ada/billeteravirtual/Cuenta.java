package ar.com.ada.billeteravirtual;

import java.util.ArrayList;

import javax.persistence.*;

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

    @ManyToOne // estas dos  anotaciones van siempre q este la tabla de FK, o @onetomany
    @JoinColumn(name = "billetera_id", referencedColumnName = "billetera_id")
    private Billetera billetera;

    /*@OneToMany (mappedBy = "cuentaOrigen_id", cascade = CascadeType.ALL)
    private Movimiento movimiento;*/
    /*@OneToMany (mappedBy = "cuentaDestino_id", cascade = CascadeType.ALL)
    private Movimiento movimiento;*/
    

    private String moneda;
    private double saldo;
    private double saldoDisponible;
    private List <Movimiento> movimientos = new ArrayList <Movimiento>(); 

}