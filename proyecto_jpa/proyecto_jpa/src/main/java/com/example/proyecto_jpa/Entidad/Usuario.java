package com.example.proyecto_jpa.Entidad;


import jakarta.persistence.*;

import java.util.Set;

@Entity
@Table(name = "Usuario")
public class Usuario {

    @Id
    @Column(unique = true)
    private String Id_usuario;

    @Column(nullable = false)
    private String Nombres;

    @Column(nullable = false)
    private String Email;

    @Column(nullable = false)
    private String Contraseña;

    @Column(nullable = false)
    private String FechaN;

    @Column(name = "Cod_verif")
    private String Cod_verif;

    @Column(name = "img_perfil")
    private String img_perfil;

    @Column(nullable = false)
    private String Estado_Cuenta;


    @OneToMany(mappedBy = "usuario_rel", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<Comprobante> comprobante_rel;


    @OneToMany(mappedBy = "usuario_rel", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<SesionTerapia> sesionTerapias_rel;


    public Usuario(String id_usuario, String nombres, String email, String contraseña, String fechaN, String cod_verif, String img_perfil, String estado_Cu) {
        Id_usuario = id_usuario;
        Nombres = nombres;
        Email = email;
        Contraseña = contraseña;
        FechaN = fechaN;
        Cod_verif = cod_verif;
        this.img_perfil = img_perfil;
        Estado_Cuenta = estado_Cu;
    }

    public Usuario() {
    }

    public String getId_usuario() {
        return Id_usuario;
    }

    public void setId_usuario(String id_usuario) {
        Id_usuario = id_usuario;
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

    public String getFechaN() {
        return FechaN;
    }

    public void setFechaN(String fechaN) {
        FechaN = fechaN;
    }

    public String getCod_verif() {
        return Cod_verif;
    }

    public void setCod_verif(String cod_verif) {
        Cod_verif = cod_verif;
    }

    public String getImg_perfil() {
        return img_perfil;
    }

    public void setImg_perfil(String img_perfil) {
        this.img_perfil = img_perfil;
    }

    public String getEstado_Cu() {
        return Estado_Cuenta;
    }

    public void setEstado_Cu(String estado_Cu) {
        Estado_Cuenta = estado_Cu;
    }



    @Override
    public String toString() {
        return "Usuario{" +
                "Id_usuario='" + Id_usuario + '\'' +
                ", Nombres='" + Nombres + '\'' +
                ", Email='" + Email + '\'' +
                ", Contraseña='" + Contraseña + '\'' +
                ", FechaN='" + FechaN + '\'' +
                ", Cod_verif='" + Cod_verif + '\'' +
                ", img_perfil='" + img_perfil + '\'' +
                ", Estado_Cu='" + Estado_Cuenta + '\'' +
                '}';
    }
}
