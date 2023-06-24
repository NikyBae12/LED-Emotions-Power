package com.example.proyectoFinal.Entidad;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

@Entity
@Table(name = "EmoMulti")
public class EmoMulti {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer idEmoMulti;
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "idEmocion", referencedColumnName = "idEmocion", nullable = false)
    @JsonIgnore
    private Emocion idEmocionRel;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "idElemento", referencedColumnName = "idElemento", nullable = false)
    @JsonIgnore
    private Multimedia multimediaRel;

    public EmoMulti(Integer idEmoMulti, Emocion idEmocionRel, Multimedia multimediaRel) {
        this.idEmoMulti = idEmoMulti;
        this.idEmocionRel = idEmocionRel;
        this.multimediaRel = multimediaRel;
    }

    public EmoMulti() {
    }

    public Integer getIdEmoMulti() {
        return idEmoMulti;
    }

    public void setIdEmoMulti(Integer idEmoMulti) {
        this.idEmoMulti = idEmoMulti;
    }

    public Emocion getIdEmocionRel() {
        return idEmocionRel;
    }

    public void setIdEmocionRel(Emocion idEmocionRel) {
        this.idEmocionRel = idEmocionRel;
    }

    public Multimedia getMultimediaRel() {
        return multimediaRel;
    }

    public void setMultimediaRel(Multimedia multimediaRel) {
        this.multimediaRel = multimediaRel;
    }
}
