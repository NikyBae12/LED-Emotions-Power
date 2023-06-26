package com.example.proyectoFinal.Entidad;


import jakarta.persistence.*;

import java.util.Set;

@Entity
@Table(name = "Emocion")
public class Emocion {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer idEmocion;

    @Column(nullable = false)
    private String eNombre;

    @Column(nullable = false)
    private int eColorRed;

    @Column(nullable = false)
    private int eColorGreen;

    @Column(nullable = false)
    private int eColorBlue;

    @Column(nullable = false)
    private Boolean eEstadoA;


    @OneToMany(mappedBy = "idEmocionRel", fetch = FetchType.LAZY)
    private Set<SesionEmo> sesionRel;

    public Emocion(Integer idEmocion, String eNombre, int eColorRed, int eColorGreen, int eColorBlue, Boolean eEstadoA) {
        this.idEmocion = idEmocion;
        this.eNombre = eNombre;
        this.eColorRed = eColorRed;
        this.eColorGreen = eColorGreen;
        this.eColorBlue = eColorBlue;
        this.eEstadoA = eEstadoA;
    }

    public Emocion() {
    }

    public Integer getIdEmocion() {
        return idEmocion;
    }

    public void setIdEmocion(Integer idEmocion) {
        this.idEmocion = idEmocion;
    }

    public String geteNombre() {
        return eNombre;
    }

    public void seteNombre(String eNombre) {
        this.eNombre = eNombre;
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

    public Set<SesionEmo> getSesionRel() {
        return sesionRel;
    }

    public void setSesionRel(Set<SesionEmo> sesionRel) {
        this.sesionRel = sesionRel;
    }
}
