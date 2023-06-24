package com.example.proyectoFinal.Entidad;


import jakarta.persistence.*;

import java.util.Set;

@Entity
@Table(name = "Emocion")
public class Emocion {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer IdEmocion;

    @Column(nullable = false)
    private String ENombre;

    @Column(nullable = false)
    private int eColorRed;

    @Column(nullable = false)
    private int eColorGreen;

    @Column(nullable = false)
    private int eColorBlue;

    @Column(nullable = false)
    private Boolean eEstadoA;


    @OneToMany(mappedBy = "Id_emocion_rel", fetch = FetchType.LAZY)
    private Set<SesionEmo> Sesion_rel;

    public Emocion(Integer idEmocion, String ENombre, int eColorRed, int eColorGreen, int eColorBlue, Boolean eEstadoA) {
        IdEmocion = idEmocion;
        this.ENombre = ENombre;
        this.eColorRed = eColorRed;
        this.eColorGreen = eColorGreen;
        this.eColorBlue = eColorBlue;
        this.eEstadoA = eEstadoA;
    }

    public Emocion() {
    }

    public Integer getIdEmocion() {
        return IdEmocion;
    }

    public void setIdEmocion(Integer idEmocion) {
        IdEmocion = idEmocion;
    }

    public String getENombre() {
        return ENombre;
    }

    public void setENombre(String ENombre) {
        this.ENombre = ENombre;
    }

    public int geteColorRed() {
        return eColorRed;
    }

    public void seteColorRed(int eColorRed) {
        this.eColorRed = eColorRed;
    }

    public int geteColorGreen() {
        return eColorGreen;
    }

    public void seteColorGreen(int eColorGreen) {
        this.eColorGreen = eColorGreen;
    }

    public int geteColorBlue() {
        return eColorBlue;
    }

    public void seteColorBlue(int eColorBlue) {
        this.eColorBlue = eColorBlue;
    }

    public Boolean geteEstadoA() {
        return eEstadoA;
    }

    public void seteEstadoA(Boolean eEstadoA) {
        this.eEstadoA = eEstadoA;
    }

    @Override
    public String toString() {
        return "Emocion{" +
                "IdEmocion=" + IdEmocion +
                ", ENombre='" + ENombre + '\'' +
                ", eColorRed=" + eColorRed +
                ", eColorGreen=" + eColorGreen +
                ", eColorBlue=" + eColorBlue +
                ", eEstadoA=" + eEstadoA +
                ", Sesion_rel=" + Sesion_rel +
                '}';
    }
}
