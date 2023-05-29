package jpaledemotionspower.proyecto_jpa.Entidad;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

@Entity
@Table(name = "SesionEmo")
public class SesionEmo {


    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer IdSeEmo;


    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "IDSesion", referencedColumnName = "IDSesion", nullable = false)
    @JsonIgnore
    private SesionTerapia Id_Sesion_rel;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "IdEmocion", referencedColumnName = "IdEmocion", nullable = false)
    @JsonIgnore
    private Emocion Id_emocion_rel;

    public SesionEmo() {
    }

    public SesionEmo(int idSeEmo, SesionTerapia id_Sesion_rel, Emocion id_emocion_rel) {
        IdSeEmo = idSeEmo;
        Id_Sesion_rel = id_Sesion_rel;
        Id_emocion_rel = id_emocion_rel;
    }

    public int getIdSeEmo() {
        return IdSeEmo;
    }

    public void setIdSeEmo(int idSeEmo) {
        IdSeEmo = idSeEmo;
    }

    public SesionTerapia getId_Sesion_rel() {
        return Id_Sesion_rel;
    }

    public void setId_Sesion_rel(SesionTerapia id_Sesion_rel) {
        Id_Sesion_rel = id_Sesion_rel;
    }

    public Emocion getId_emocion_rel() {
        return Id_emocion_rel;
    }

    public void setId_emocion_rel(Emocion id_emocion_rel) {
        Id_emocion_rel = id_emocion_rel;
    }

    @Override
    public String toString() {
        return "SesionEmo{" +
                "IdSeEmo=" + IdSeEmo +
                ", Id_Sesion_rel=" + Id_Sesion_rel +
                ", Id_emocion_rel=" + Id_emocion_rel +
                '}';
    }
}
