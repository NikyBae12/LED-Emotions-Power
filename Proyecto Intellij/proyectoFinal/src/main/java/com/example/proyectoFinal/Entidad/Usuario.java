package com.example.proyectoFinal.Entidad;


import jakarta.persistence.*;

import java.util.Date;
import java.util.Set;

@Entity
@Table(name = "Usuario")
public class Usuario {
    @Id
    @Column(unique = true)
    private String IdUsuario;

    @Column(nullable = false)
    private String Nombres;

    @Column(nullable = false, unique = true)
    private String Email;

    @Column(nullable = false)
    private String Contraseña;

    @Column(nullable = false)
    private java.sql.Date FechaN;

    @Column(name = "CodVerif")
    private String CodVerif;

    @Column(name = "imgPerfil")
    private String imgPerfil;

    @Column(nullable = false)
    private String EstadoCuenta;

    @OneToMany(mappedBy = "usuario", fetch = FetchType.LAZY)
    private Set<Comprobante> comprobante;


    public Usuario(String idUsuario, String nombres, String email, String contraseña, java.sql.Date fechaN, String codVerif, String imgPerfil, String estadoCuenta) {
        IdUsuario = idUsuario;
        Nombres = nombres;
        Email = email;
        Contraseña = contraseña;
        FechaN = fechaN;
        CodVerif = codVerif;
        this.imgPerfil = imgPerfil;
        EstadoCuenta = estadoCuenta;
    }

    public Usuario() {
    }

    public String getIdUsuario() {
        return IdUsuario;
    }

    public void setIdUsuario(String idUsuario) {
        IdUsuario = idUsuario;
    }

    public String getNombres() {
        return Nombres;
    }

    public void setNombres(String nombres) {
        Nombres = nombres;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public String getContraseña() {
        return Contraseña;
    }

    public void setContraseña(String contraseña) {
        Contraseña = contraseña;
    }

    public java.sql.Date getFechaN() {
        return FechaN;
    }

    public void setFechaN(java.sql.Date fechaN) {
        FechaN = fechaN;
    }

    public String getCodVerif() {
        return CodVerif;
    }

    public void setCodVerif(String codVerif) {
        CodVerif = codVerif;
    }

    public String getImgPerfil() {
        return imgPerfil;
    }

    public void setImgPerfil(String imgPerfil) {
        this.imgPerfil = imgPerfil;
    }

    public String getEstadoCuenta() {
        return EstadoCuenta;
    }

    public void setEstadoCuenta(String estadoCuenta) {
        EstadoCuenta = estadoCuenta;
    }


    @Override
    public String toString() {
        return "Usuario{" +
                "IdUsuario='" + IdUsuario + '\'' +
                ", Nombres='" + Nombres + '\'' +
                ", Email='" + Email + '\'' +
                ", Contraseña='" + Contraseña + '\'' +
                ", FechaN='" + FechaN + '\'' +
                ", CodVerif='" + CodVerif + '\'' +
                ", imgPerfil='" + imgPerfil + '\'' +
                ", EstadoCuenta='" + EstadoCuenta + '\'' +
                '}';
    }
}
