package com.example.proyectoFinal.Entidad;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "SesionTerapia")
public class SesionTerapia {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer idSesion;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "idConexion", referencedColumnName = "idConexion", nullable = false)
    @JsonIgnore
    private ConexionLED conexionesRel;


    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "idUsuario", referencedColumnName = "idUsuario", nullable = false)
    @JsonIgnore
    private Usuario usuarioRel;


    @Column(nullable = false)
    @Temporal(TemporalType.DATE)
    private Date fechaSesion;

    @PrePersist
    public void fechaHoy() {
        this.fechaSesion = new Date();
    }


    @Column(name = "nivelSatis")
    private int nivelSatis;

    public SesionTerapia(Integer idSesion, ConexionLED conexionesRel, Usuario usuarioRel, Date fechaSesion, int nivelSatis) {
        this.idSesion = idSesion;
        this.conexionesRel = conexionesRel;
        this.usuarioRel = usuarioRel;
        this.fechaSesion = fechaSesion;
        this.nivelSatis = nivelSatis;
    }

    public SesionTerapia() {
    }

    public Integer getIdSesion() {
        return idSesion;
    }

    public void setIdSesion(Integer idSesion) {
        this.idSesion = idSesion;
    }

    public ConexionLED getConexionesRel() {
        return conexionesRel;
    }

    public void setConexionesRel(ConexionLED conexionesRel) {
        this.conexionesRel = conexionesRel;
    }

    public Usuario getUsuarioRel() {
        return usuarioRel;
    }

    public void setUsuarioRel(Usuario usuarioRel) {
        this.usuarioRel = usuarioRel;
    }

    public Date getFechaSesion() {
        return fechaSesion;
    }

    public void setFechaSesion(Date fechaSesion) {
        this.fechaSesion = fechaSesion;
    }

    public int getNivelSatis() {
        return nivelSatis;
    }

    public void setNivelSatis(int nivelSatis) {
        this.nivelSatis = nivelSatis;
    }
}
