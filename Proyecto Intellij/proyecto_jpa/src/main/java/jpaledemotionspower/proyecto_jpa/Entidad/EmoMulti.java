package jpaledemotionspower.proyecto_jpa.Entidad;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

@Entity
@Table(name = "EmoMulti")
public class EmoMulti {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer IdEmoMulti;
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "IdEmocion", referencedColumnName = "IdEmocion", nullable = false)
    @JsonIgnore
    private Emocion Id_emocion_rel;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "IdElemento", referencedColumnName = "IdElemento", nullable = false)
    @JsonIgnore
    private Multimedia multimedia_rel;


    public EmoMulti() {
    }

    public EmoMulti(int idEmoMulti, Emocion id_emocion_rel, Multimedia multimedia_rel) {
        IdEmoMulti = idEmoMulti;
        Id_emocion_rel = id_emocion_rel;
        this.multimedia_rel = multimedia_rel;
    }

    public int getIdEmoMulti() {
        return IdEmoMulti;
    }

    public void setIdEmoMulti(int idEmoMulti) {
        IdEmoMulti = idEmoMulti;
    }

    public Emocion getId_emocion_rel() {
        return Id_emocion_rel;
    }

    public void setId_emocion_rel(Emocion id_emocion_rel) {
        Id_emocion_rel = id_emocion_rel;
    }

    public Multimedia getMultimedia_rel() {
        return multimedia_rel;
    }

    public void setMultimedia_rel(Multimedia multimedia_rel) {
        this.multimedia_rel = multimedia_rel;
    }

    @Override
    public String toString() {
        return "EmoMulti{" +
                "IdEmoMulti=" + IdEmoMulti +
                ", Id_emocion_rel=" + Id_emocion_rel +
                ", multimedia_rel=" + multimedia_rel +
                '}';
    }
}
