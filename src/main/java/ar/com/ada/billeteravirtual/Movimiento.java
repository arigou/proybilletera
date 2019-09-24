package ar.com.ada.billeteravirtual;

import java.util.*;

import javax.persistence.*;

/**
 * Movimiento
 */

@Entity
@Table(name = "movimiento")

public class Movimiento {

    @Id
    @Column(name = "movimiento_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int movimientoId;

    /*@ManyToOne // estas dos  anotaciones van siempre q este la tabla de FK, o @onetomany
    @JoinColumn(name = "deUsuario_id", referencedColumnName = "deUsuario_id")
    private Usuario deusuario;

    @ManyToOne // estas dos  anotaciones van siempre q este la tabla de FK, o @onetomany
    @JoinColumn(name = "aUsuario_id", referencedColumnName = "aUsuario_id")
    private Usuario aUsuario;

    @ManyToOne // estas dos  anotaciones van siempre q este la tabla de FK, o @onetomany
    @JoinColumn(name = "cuentaOrigen_id", referencedColumnName = "cuentaOrigen_id")
    private Cuenta cuentaOrigen; 

    @ManyToOne // estas dos  anotaciones van siempre q este la tabla de FK, o @onetomany
    @JoinColumn(name = "cuentaDestino_id", referencedColumnName = "cuentaDestino_id")
    private Cuenta cuentaDestino; */


    private Date fechaMovimiento;
    private Coordenada ubicacion;
    private double importe;
    private String tipoOperacion;
    private String conceptoOperacion;
    private String detalle;
    private int estado; 
    @Column(name = "deUsuario_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int deUsuarioId;
    @Column(name = "aUsuario_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int aUsuarioId; 
    @Column(name = "cuentaOrigen_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int cuentaOrigenId;
    @Column(name = "cuentaDestino_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int cuentaDestinoId; 




    
}