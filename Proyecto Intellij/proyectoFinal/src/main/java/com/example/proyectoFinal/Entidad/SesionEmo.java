package com.example.proyectoFinal.Entidad;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

@Entity
@Table(name = "SesionEmo")
public class SesionEmo {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer idSeEmo;


    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "iDSesion", referencedColumnName = "iDSesion", nullable = false)
    @JsonIgnore
    private SesionTerapia idSesionRel;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "idEmocion", referencedColumnName = "idEmocion", nullable = false)
    @JsonIgnore
    private Emocion idEmocionRel;

    public SesionEmo(Integer idSeEmo, SesionTerapia idSesionRel, Emocion idEmocionRel) {
        this.idSeEmo = idSeEmo;
        this.idSesionRel = idSesionRel;
        this.idEmocionRel = idEmocionRel;
    }

    public SesionEmo() {
    }

    public Integer getIdSeEmo() {
        return idSeEmo;
    }

    public void setIdSeEmo(Integer idSeEmo) {
        this.idSeEmo = idSeEmo;
    }

    public SesionTerapia getIdSesionRel() {
        return idSesionRel;
    }

    public void setIdSesionRel(SesionTerapia idSesionRel) {
        this.idSesionRel = idSesionRel;
    }

    public Emocion getIdEmocionRel() {
        return idEmocionRel;
    }

    public void setIdEmocionRel(Emocion idEmocionRel) {
        this.idEmocionRel = idEmocionRel;
    }
}
