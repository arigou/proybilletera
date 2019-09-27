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
    /*@Column(name = "cuenta_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int cuentaId;*/

    @ManyToOne // estas dos  anotaciones van siempre q este la tabla de FK, o @onetomany
    @JoinColumn(name = "cuenta_id", referencedColumnName = "cuenta_id")
    private Cuenta cuenta;

    /*@ManyToOne // estas dos  anotaciones van siempre q este la tabla de FK, o @onetomany
    @JoinColumn(name = "aUsuario_id", referencedColumnName = "aUsuario_id")
    private Usuario aUsuario;

    @ManyToOne // estas dos  anotaciones van siempre q este la tabla de FK, o @onetomany
    @JoinColumn(name = "cuentaOrigen_id", referencedColumnName = "cuentaOrigen_id")
    private Cuenta cuentaOrigen; 

    @ManyToOne // estas dos  anotaciones van siempre q este la tabla de FK, o @onetomany
    @JoinColumn(name = "cuentaDestino_id", referencedColumnName = "cuentaDestino_id")
    private Cuenta cuentaDestino; */


    private Date fechaMovimiento;
    private double importe;
    private String tipoOperacion;
    private String conceptoOperacion;
    private String detalle;
    private int estado;   
    
    

    public int getMovimientoId() {
        return movimientoId;
    }

    public void setMovimientoId(int movimientoId) {
        this.movimientoId = movimientoId;
    }

    public Date getFechaMovimiento() {
        return fechaMovimiento;
    }

    public void setFechaMovimiento(Date fechaMovimiento) {
        this.fechaMovimiento = fechaMovimiento;
    }

    public double getImporte() {
        return importe;
    }

    public void setImporte(double importe) {
        this.importe = importe;
    }

    public String getTipoOperacion() {
        return tipoOperacion;
    }

    public void setTipoOperacion(String tipoOperacion) {
        this.tipoOperacion = tipoOperacion;
    }

    public String getConceptoOperacion() {
        return conceptoOperacion;
    }

    public void setConceptoOperacion(String conceptoOperacion) {
        this.conceptoOperacion = conceptoOperacion;
    }

    public String getDetalle() {
        return detalle;
    }

    public void setDetalle(String detalle) {
        this.detalle = detalle;
    }

    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }

    public int getDeUsuarioId() {
        return deUsuarioId;
    }

    public void setDeUsuarioId(int deUsuarioId) {
        this.deUsuarioId = deUsuarioId;
    }

    public int getaUsuarioId() {
        return aUsuarioId;
    }

    public void setaUsuarioId(int aUsuarioId) {
        this.aUsuarioId = aUsuarioId;
    }

    public int getCuentaOrigenId() {
        return cuentaOrigenId;
    }

    public void setCuentaOrigenId(int cuentaOrigenId) {
        this.cuentaOrigenId = cuentaOrigenId;
    }

    public int getCuentaDestinoId() {
        return cuentaDestinoId;
    }

    public void setCuentaDestinoId(int cuentaDestinoId) {
        this.cuentaDestinoId = cuentaDestinoId;
    }

    public Cuenta getCuenta() {
        return cuenta;
    }

    public void setCuenta(Cuenta cuenta) {
        this.cuenta = cuenta;
    }

    

    public Movimiento(int movimientoId, int deUsuarioId, int aUsuarioId, int cuentaOrigenId, int cuentaDestinoId,
            /*int cuentaId,*/ Cuenta cuenta, Date fechaMovimiento, double importe, String tipoOperacion,
            String conceptoOperacion, String detalle, int estado) {
        this.movimientoId = movimientoId;
        this.deUsuarioId = deUsuarioId;
        this.aUsuarioId = aUsuarioId;
        this.cuentaOrigenId = cuentaOrigenId;
        this.cuentaDestinoId = cuentaDestinoId;
        //this.cuentaId = cuentaId;
        this.cuenta = cuenta;
        this.fechaMovimiento = fechaMovimiento;
        this.importe = importe;
        this.tipoOperacion = tipoOperacion;
        this.conceptoOperacion = conceptoOperacion;
        this.detalle = detalle;
        this.estado = estado;
    }

    public Movimiento () {

    }

    /*public int getCuentaId() {
        return cuentaId;
    }

    public void setCuentaId(int cuentaId) {
        this.cuentaId = cuentaId;
    }*/





    
}