package com.example.proyecto_jpa.Entidad;


import jakarta.persistence.*;

import java.util.Set;

@Entity
@Table(name = "Emociones")
public class Emociones {


    @Id
    @Column(name = "Id_emocion")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer Id_emocion;

    @Column(nullable = false)
    private String E_nombre;

    @Column(nullable = false)
    private String E_color_Basic;

    @Column(nullable = false)
    private boolean E_estadoA;


    @OneToMany(mappedBy = "Id_emocion", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<Sesion_Emo> Sesion_rel;


    @OneToMany(mappedBy = "Ide_emocion", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<Emo_multi> Multi_rel;


    public Emociones(Integer id_emocion, String e_nombre, String e_color_Basic, boolean e_estadoA) {
        Id_emocion = id_emocion;
        E_nombre = e_nombre;
        E_color_Basic = e_color_Basic;
        E_estadoA = e_estadoA;
    }

    public Emociones() {
    }

    public Integer getId_emocion() {
        return Id_emocion;
    }

    public void setId_emocion(Integer id_emocion) {
        Id_emocion = id_emocion;
    }

    public String getE_nombre() {
        return E_nombre;
    }

    public void setE_nombre(String e_nombre) {
        E_nombre = e_nombre;
    }

    public String getE_color_Basic() {
        return E_color_Basic;
    }

    public void setE_color_Basic(String e_color_Basic) {
        E_color_Basic = e_color_Basic;
    }

    public boolean isE_estadoA() {
        return E_estadoA;
    }

    public void setE_estadoA(boolean e_estadoA) {
        E_estadoA = e_estadoA;
    }


    @Override
    public String toString() {
        return "Emociones{" +
                "Id_emocion=" + Id_emocion +
                ", E_nombre='" + E_nombre + '\'' +
                ", E_color_Basic='" + E_color_Basic + '\'' +
                ", E_estadoA=" + E_estadoA +
                ", Sesion_rel=" + Sesion_rel +
                ", Multi_rel=" + Multi_rel +
                '}';
    }
}