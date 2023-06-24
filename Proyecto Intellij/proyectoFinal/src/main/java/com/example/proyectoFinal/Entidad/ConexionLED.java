package com.example.proyectoFinal.Entidad;


import jakarta.persistence.*;

import java.util.Set;

@Entity
@Table(name = "ConexionLED")
public class ConexionLED {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer IdConexion;

    @Column(nullable = false) //nullable = Se requiere el atributo
    private String IdLed;

    @Column(nullable = false)
    private Boolean CEstado;

    @OneToMany(mappedBy = "conexiones_rel", fetch = FetchType.LAZY)
    private Set<SesionTerapia> sesion_rel;


    public ConexionLED(Integer idConexion, String idLed, Boolean CEstado) {
        IdConexion = idConexion;
        IdLed = idLed;
        this.CEstado = CEstado;
    }

    public ConexionLED() {
    }

    public Integer getIdConexion() {
        return IdConexion;
    }

    public void setIdConexion(Integer idConexion) {
        IdConexion = idConexion;
    }

    public String getIdLed() {
        return IdLed;
    }

    public void setIdLed(String idLed) {
        IdLed = idLed;
    }

    public Boolean getCEstado() {
        return CEstado;
    }

    public void setCEstado(Boolean CEstado) {
        this.CEstado = CEstado;
    }

    @Override
    public String toString() {
        return "ConexionLED{" +
                "IdConexion=" + IdConexion +
                ", IdLed='" + IdLed + '\'' +
                ", CEstado=" + CEstado +
                '}';
    }
}
