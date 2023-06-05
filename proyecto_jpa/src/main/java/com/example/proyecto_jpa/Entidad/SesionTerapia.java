package com.example.proyecto_jpa.Entidad;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.Date;
import java.util.Set;

@Entity
@Table(name = "Sesion_terapia")
public class SesionTerapia {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer ID_sesion;



    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "Id_usuario", referencedColumnName = "Id_usuario", nullable = false)
    @JsonIgnore
    private Usuario usuario_rel;



    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "Id_conexion", referencedColumnName = "Id_conexion", nullable = false)
    @JsonIgnore
    private conexiones conxeiones_rel;


    @OneToMany(mappedBy = "Id_Sesion_rel", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<Sesion_Emo> sesion_emos;


    @Column(nullable = false)
    @Temporal(TemporalType.DATE)
    private Date Fecha_Sesi;

    @PrePersist
    public void fecha_hoy(){
        this.Fecha_Sesi = new Date();
    }



    public SesionTerapia(Date fecha_Sesi) {
        Fecha_Sesi = fecha_Sesi;
    }


    @Column(name = "Nivel_Satis")
    private int Nivel_Satis;


    public SesionTerapia(Integer ID_sesion, Usuario usuario_rel, conexiones conxeiones_rel, Set<Sesion_Emo> sesion_emos, Date fecha_Sesi, int nivel_Satis) {
        this.ID_sesion = ID_sesion;
        this.usuario_rel = usuario_rel;
        this.conxeiones_rel = conxeiones_rel;
        this.sesion_emos = sesion_emos;
        Fecha_Sesi = fecha_Sesi;
        Nivel_Satis = nivel_Satis;
    }

    public SesionTerapia() {
    }

    public Integer getID_sesion() {
        return ID_sesion;
    }

    public void setID_sesion(Integer ID_sesion) {
        this.ID_sesion = ID_sesion;
    }

    public Usuario getUsuario_rel() {
        return usuario_rel;
    }

    public void setUsuario_rel(Usuario usuario_rel) {
        this.usuario_rel = usuario_rel;
    }

    public conexiones getConxeiones_rel() {
        return conxeiones_rel;
    }

    public void setConxeiones_rel(conexiones conxeiones_rel) {
        this.conxeiones_rel = conxeiones_rel;
    }

    public Set<Sesion_Emo> getSesion_emos() {
        return sesion_emos;
    }

    public void setSesion_emos(Set<Sesion_Emo> sesion_emos) {
        this.sesion_emos = sesion_emos;
    }

    public Date getFecha_Sesi() {
        return Fecha_Sesi;
    }

    public void setFecha_Sesi(Date fecha_Sesi) {
        Fecha_Sesi = fecha_Sesi;
    }

    public int getNivel_Satis() {
        return Nivel_Satis;
    }

    public void setNivel_Satis(int nivel_Satis) {
        Nivel_Satis = nivel_Satis;
    }

    @Override
    public String toString() {
        return "SesionTerapia{" +
                "ID_sesion=" + ID_sesion +
                ", usuario_rel=" + usuario_rel +
                ", conxeiones_rel=" + conxeiones_rel +
                ", sesion_emos=" + sesion_emos +
                ", Fecha_Sesi=" + Fecha_Sesi +
                ", Nivel_Satis=" + Nivel_Satis +
                '}';
    }
}
