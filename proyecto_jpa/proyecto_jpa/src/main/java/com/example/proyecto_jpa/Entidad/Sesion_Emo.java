package com.example.proyecto_jpa.Entidad;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

@Entity
@Table(name = "Sesion Emocional")
public class Sesion_Emo {


    @Id
    @Column(name = "Id_Sesion_Emocional")
    private int Id_Sesion_Emocional;


    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "ID_sesion", referencedColumnName = "ID_sesion", nullable = false)
    @JsonIgnore
    private SesionTerapia Id_Sesion_rel;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "Id_emocion", referencedColumnName = "Id_emocion", nullable = false)
    @JsonIgnore
    private Emociones Id_emocion;

    public Sesion_Emo(int id_Sesion_Emocional, SesionTerapia id_Sesion_rel, Emociones id_Emocion) {
        Id_Sesion_Emocional = id_Sesion_Emocional;
        Id_Sesion_rel = id_Sesion_rel;
        Id_emocion = id_Emocion;
    }

    public Sesion_Emo() {
    }

    public int getId_Sesion_Emocional() {
        return Id_Sesion_Emocional;
    }

    public void setId_Sesion_Emocional(int id_Sesion_Emocional) {
        Id_Sesion_Emocional = id_Sesion_Emocional;
    }

    public SesionTerapia getId_Sesion_rel() {
        return Id_Sesion_rel;
    }

    public void setId_Sesion_rel(SesionTerapia id_Sesion_rel) {
        Id_Sesion_rel = id_Sesion_rel;
    }

    public Emociones getId_Emocion() {
        return Id_emocion;
    }

    public void setId_Emocion(Emociones id_Emocion) {
        Id_emocion = id_Emocion;
    }

    @Override
    public String toString() {
        return "Sesion_Emo{" +
                "Id_Sesion_Emocional=" + Id_Sesion_Emocional +
                ", Id_Sesion_rel=" + Id_Sesion_rel +
                ", Id_Emocion=" + Id_emocion +
                '}';
    }
}
