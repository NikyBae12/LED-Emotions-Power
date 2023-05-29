package jpaledemotionspower.proyecto_jpa.Entidad;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.Date;
import java.util.Set;

@Entity
@Table(name = "SesionTerapia")
public class SesionTerapia {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer IDSesion;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "IdConexion", referencedColumnName = "IdConexion", nullable = false)
    @JsonIgnore
    private ConexionLED conexiones_rel;


    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "IdUsuario", referencedColumnName = "IdUsuario", nullable = false)
    @JsonIgnore
    private Usuario usuario_rel;


    @Column(nullable = false)
    @Temporal(TemporalType.DATE)
    private Date FechaSesion;

    public SesionTerapia(Date fecha_Sesi) {
        FechaSesion = fecha_Sesi;
    }


    @Column(name = "NivelSatis")
    private int NivelSatis;

    @OneToMany(mappedBy = "Id_Sesion_rel", fetch = FetchType.LAZY)
    private Set<SesionEmo> sesion_emos;


    public SesionTerapia() {
    }

    public SesionTerapia(int IDSesion, ConexionLED conxeiones_rel, Usuario usuario_rel, Date fechaSesion, int nivelSatis) {
        this.IDSesion = IDSesion;
        this.conexiones_rel = conxeiones_rel;
        this.usuario_rel = usuario_rel;
        FechaSesion = fechaSesion;
        NivelSatis = nivelSatis;
    }

    public int getIDSesion() {
        return IDSesion;
    }

    public void setIDSesion(int IDSesion) {
        this.IDSesion = IDSesion;
    }

    public ConexionLED getConexiones_rel() {
        return conexiones_rel;
    }

    public void setConexiones_rel(ConexionLED conexiones_rel) {
        this.conexiones_rel = conexiones_rel;
    }

    public Usuario getUsuario_rel() {
        return usuario_rel;
    }

    public void setUsuario_rel(Usuario usuario_rel) {
        this.usuario_rel = usuario_rel;
    }

    public Date getFechaSesion() {
        return FechaSesion;
    }

    public void setFechaSesion(Date fechaSesion) {
        FechaSesion = fechaSesion;
    }

    public int getNivelSatis() {
        return NivelSatis;
    }

    public void setNivelSatis(int nivelSatis) {
        NivelSatis = nivelSatis;
    }

    public Set<SesionEmo> getSesion_emos() {
        return sesion_emos;
    }

    public void setSesion_emos(Set<SesionEmo> sesion_emos) {
        this.sesion_emos = sesion_emos;
    }

    @Override
    public String toString() {
        return "SesionTerapia{" +
                "IDSesion=" + IDSesion +
                ", conexiones_rel=" + conexiones_rel +
                ", usuario_rel=" + usuario_rel +
                ", FechaSesion=" + FechaSesion +
                ", NivelSatis=" + NivelSatis +
                '}';
    }
}
