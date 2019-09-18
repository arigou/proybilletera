package ar.com.ada.billeteravirtual;

import javax.persistence.*;

/**
 * Usuario
 */
@Entity
@Table(name = "usuario")
public class Usuario {

    @Id
    @Column(name = "usuario_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int usuarioId;
    private String username;
    private String password;
    @Column(name = "email")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String emailUsuario;
    @Column(name = "persona_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int personaId;

    public Usuario(String username, String password, String emailUsuario, int personaId) {
        this.username = username;
        this.password = password;
        this.emailUsuario = emailUsuario;
        this.personaId = personaId;
    }

    public Usuario() {
    }

    public int getUsuarioId() {
        return usuarioId;
    }

    public void setUsuarioId(int usuarioId) {
        this.usuarioId = usuarioId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String userName) {
        this.username = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return emailUsuario;
    }

    public void setEmailUsuario(String emailUsuario) {
        this.emailUsuario = emailUsuario;
    }

    public int getPersonaId() {
        return personaId;
    }

    public void setPersonaId(int personaId) {
        this.personaId = personaId;
    }

    @Override
    public String toString() {
        return "Usuario [email=" + emailUsuario + ", password=" + password + ", personaId=" + personaId + ", username="
                + username + ", usuarioId=" + usuarioId + "]";
    }

}