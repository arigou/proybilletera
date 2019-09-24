package ar.com.ada.billeteravirtual;

import java.util.*;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.*;

/**
 * Billetera
 */
@Entity
@Table(name = "billetera")
public class Billetera {

    @Id
    @Column(name = "billetera_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int billeteraId;

    @OneToOne // estas dos  anotaciones van siempre q este la tabla de FK, o @onetomany
    @JoinColumn(name = "persona_id", referencedColumnName = "persona_id")
    private Persona persona;

    @OneToMany( mappedBy = "cuenta", cascade = CascadeType.ALL)
    private Cuenta cuenta;

    
    private List <Cuenta> cuentas =  new ArrayList<Cuenta>();

    public Billetera(int billeteraId) {
        this.billeteraId = billeteraId;
    }

    public Billetera() {
    }

    public int getBilleteraId() {
        return billeteraId;
    }

    public void setBilleteraId(int billeteraId) {
        this.billeteraId = billeteraId;
    }

    public List<Cuenta> getCuentas() {
        return cuentas;
    }

    public void setCuentas(List<Cuenta> cuentas) {
        this.cuentas = cuentas;
    }




}