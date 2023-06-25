package com.example.proyectoFinal.Entidad;


import jakarta.persistence.*;

import java.sql.Date;
import java.util.Set;

@Entity
@Table(name = "usuario")
public class Usuario {
    @Id
    @Column(unique = true)
    private String idUsuario;

    @Column(nullable = false)
    private String nombres;

    @Column(nullable = false, unique = true)
    private String email;

    @Column(nullable = false)
    private String contraseña;

    @Column(nullable = false)
    private java.sql.Date fechaN;

    @Column(name = "codVerif")
    private String codVerif;

    @Column(name = "imgPerfil")
    private String imgPerfil;

    @Column(nullable = false)
    private String estadoCuenta;

    @OneToMany(mappedBy = "usuario", fetch = FetchType.LAZY)
    private Set<Comprobante> comprobante;


    public Usuario(String idUsuario, String nombres, String email, String contraseña, Date fechaN, String codVerif, String imgPerfil, String estadoCuenta) {
        this.idUsuario = idUsuario;
        this.nombres = nombres;
        this.email = email;
        this.contraseña = contraseña;
        this.fechaN = fechaN;
        this.codVerif = codVerif;
        this.imgPerfil = imgPerfil;
        this.estadoCuenta = estadoCuenta;
    }

    public Usuario() {
    }

    public String getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(String idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

    public Date getFechaN() {
        return fechaN;
    }

    public void setFechaN(Date fechaN) {
        this.fechaN = fechaN;
    }

    public String getCodVerif() {
        return codVerif;
    }

    public void setCodVerif(String codVerif) {
        this.codVerif = codVerif;
    }

    public String getImgPerfil() {
        return imgPerfil;
    }

    public void setImgPerfil(String imgPerfil) {
        this.imgPerfil = imgPerfil;
    }

    public String getEstadoCuenta() {
        return estadoCuenta;
    }

    public void setEstadoCuenta(String estadoCuenta) {
        this.estadoCuenta = estadoCuenta;
    }

    public Set<Comprobante> getComprobante() {
        return comprobante;
    }

    public void setComprobante(Set<Comprobante> comprobante) {
        this.comprobante = comprobante;
    }
}
