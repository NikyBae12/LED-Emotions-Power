package jpaledemotionspower.proyecto_jpa.Entidad;


import jakarta.persistence.*;

import java.util.Set;

@Entity
@Table(name = "ConexionesLED")
public class ConexionLED {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer IdConexion;

    @Column(nullable = false) //nullable = Se requiere el atributo
    private String IdLed;

    @Column(nullable = false)
    private Boolean CEstado;

    @OneToMany(mappedBy = "conexiones_rel", fetch = FetchType.LAZY)
    private Set<SesionTerapia> sesion_rel;


    public ConexionLED() {
    }

    public ConexionLED(int idConexion, String idLed, Boolean CEstado) {
        IdConexion = idConexion;
        IdLed = idLed;
        this.CEstado = CEstado;
    }

    public int getIdConexion() {
        return IdConexion;
    }

    public void setIdConexion(int idConexion) {
        IdConexion = idConexion;
    }

    public String getIdLed() {
        return IdLed;
    }

    public void setIdLed(String idLed) {
        IdLed = idLed;
    }

    public Boolean getCEstado() {
        return CEstado;
    }

    public void setCEstado(Boolean CEstado) {
        this.CEstado = CEstado;
    }

    public Set<SesionTerapia> getSesion_rel() {
        return sesion_rel;
    }

    public void setSesion_rel(Set<SesionTerapia> sesion_rel) {
        this.sesion_rel = sesion_rel;
    }

    @Override
    public String toString() {
        return "ConexionLED{" +
                "IdConexion='" + IdConexion + '\'' +
                ", IdLed='" + IdLed + '\'' +
                ", CEstado=" + CEstado +
                ", sesion_rel=" + sesion_rel +
                '}';
    }
}
