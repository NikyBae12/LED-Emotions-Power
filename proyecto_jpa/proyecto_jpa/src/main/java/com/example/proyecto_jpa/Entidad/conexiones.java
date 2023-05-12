package com.example.proyecto_jpa.Entidad;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.Set;

@Entity
@Table(name = "Conexion_LED")
public class conexiones {

    @Id//Llave primaria
    @Column(unique = true, length = 20)
    private String Id_conexion;

    @Column(nullable = false) //nullable = Se requiere el atributo
    private String Id_led;

    @Column(nullable = false)
    private Boolean C_estado;

    @OneToMany(mappedBy = "conxeiones_rel", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<SesionTerapia> sesion_rel;


    public conexiones(String id_conexion, String id_led, Boolean c_estado, Set<SesionTerapia> sesion_rel) {
        Id_conexion = id_conexion;
        Id_led = id_led;
        C_estado = c_estado;
        this.sesion_rel = sesion_rel;
    }

    public conexiones() {
    }

    public String getId_conexion() {
        return Id_conexion;
    }

    public void setId_conexion(String id_conexion) {
        Id_conexion = id_conexion;
    }

    public String getId_led() {
        return Id_led;
    }

    public void setId_led(String id_led) {
        Id_led = id_led;
    }

    public Boolean getC_estado() {
        return C_estado;
    }

    public void setC_estado(Boolean c_estado) {
        C_estado = c_estado;
    }

    @Override
    public String toString() {
        return "conexiones{" +
                "Id_conexion='" + Id_conexion + '\'' +
                ", Id_led='" + Id_led + '\'' +
                ", C_estado=" + C_estado +
                '}';
    }
}
