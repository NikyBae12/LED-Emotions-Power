package com.example.proyectoFinal.Entidad;


import jakarta.persistence.*;

import java.util.Set;

@Entity
@Table(name = "ConexionLED")
public class ConexionLED {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer idConexion;

    @Column(nullable = false)
    private String idLed;

    @Column(nullable = false)
    private Boolean cEstado;

    @OneToMany(mappedBy = "conexionesRel", fetch = FetchType.LAZY)
    private Set<SesionTerapia> sesionRel;


    public ConexionLED(Integer idConexion, String idLed, Boolean cEstado) {
        this.idConexion = idConexion;
        this.idLed = idLed;
        this.cEstado = cEstado;
    }

    public ConexionLED() {
    }

    public Integer getIdConexion() {
        return idConexion;
    }

    public void setIdConexion(Integer idConexion) {
        this.idConexion = idConexion;
    }

    public String getIdLed() {
        return idLed;
    }

    public void setIdLed(String idLed) {
        this.idLed = idLed;
    }

    public Boolean getcEstado() {
        return cEstado;
    }

    public void setcEstado(Boolean cEstado) {
        this.cEstado = cEstado;
    }

    public Set<SesionTerapia> getSesionRel() {
        return sesionRel;
    }

    public void setSesionRel(Set<SesionTerapia> sesionRel) {
        this.sesionRel = sesionRel;
    }
}
