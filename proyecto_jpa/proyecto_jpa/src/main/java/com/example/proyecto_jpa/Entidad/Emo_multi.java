package com.example.proyecto_jpa.Entidad;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

@Entity
@Table(name = "Emo_multi")
public class Emo_multi {

    @Id
    private int ID_MULTIMEDIA;
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "Id_emocion", referencedColumnName = "Id_emocion", nullable = false)
    @JsonIgnore
    private Emociones Ide_emocion;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "ID_Elemento", referencedColumnName = "ID_Elemento", nullable = false)
    @JsonIgnore
    private Multimedia multimedia_rel;

    public Emo_multi(int ID_MULTIMEDIA, Emociones ide_emocion, Multimedia multimedia_rel) {
        this.ID_MULTIMEDIA = ID_MULTIMEDIA;
        Ide_emocion = ide_emocion;
        this.multimedia_rel = multimedia_rel;
    }

    public Emo_multi() {
    }

    public int getID_MULTIMEDIA() {
        return ID_MULTIMEDIA;
    }

    public void setID_MULTIMEDIA(int ID_MULTIMEDIA) {
        this.ID_MULTIMEDIA = ID_MULTIMEDIA;
    }

    public Emociones getIde_emocion() {
        return Ide_emocion;
    }

    public void setIde_emocion(Emociones ide_emocion) {
        Ide_emocion = ide_emocion;
    }

    public Multimedia getMultimedia_rel() {
        return multimedia_rel;
    }

    public void setMultimedia_rel(Multimedia multimedia_rel) {
        this.multimedia_rel = multimedia_rel;
    }

    @Override
    public String toString() {
        return "Emo_multi{" +
                "ID_MULTIMEDIA=" + ID_MULTIMEDIA +
                ", Ide_emocion=" + Ide_emocion +
                ", multimedia_rel=" + multimedia_rel +
                '}';
    }
}
