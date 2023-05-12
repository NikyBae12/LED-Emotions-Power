package com.example.proyecto_jpa.Entidad;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "Comprobante")
public class Comprobante {


    @Id
    @Column(unique = true)
    private int Id_comprob;




    @Column(nullable = false)
    @Temporal(TemporalType.DATE)
    private Date Fecha_Autu;

    @PrePersist
    public void fecha_hoy(){
        this.Fecha_Autu = new Date();
    }



    @Column(nullable = false)
    private int Factura;

    @Column(nullable = false)
    private int Valor;


    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "Id_usuario", referencedColumnName = "Id_usuario", nullable = false)
    @JsonIgnore
    private Usuario usuario_rel;


    public Comprobante(int id_comprob, String id_usuario, Date fecha_Autu, int factura, int valor, Usuario usuario_rel) {
        this.Id_comprob = id_comprob;
        this.Fecha_Autu = fecha_Autu;
        this.Factura = factura;
        this.Valor = valor;
        this.usuario_rel = usuario_rel;
    }

    public Comprobante() {
    }

    public int getId_comprob() {
        return Id_comprob;
    }

    public void setId_comprob(int id_comprob) {
        Id_comprob = id_comprob;
    }

    public Date getFecha_Autu() {
        return Fecha_Autu;
    }

    public void setFecha_Autu(Date fecha_Autu) {
        Fecha_Autu = fecha_Autu;
    }

    public int getFactura() {
        return Factura;
    }

    public void setFactura(int factura) {
        Factura = factura;
    }

    public int getValor() {
        return Valor;
    }

    public void setValor(int valor) {
        Valor = valor;
    }

    public Usuario getUsuario_rel() {
        return usuario_rel;
    }

    public void setUsuario_rel(Usuario usuario_rel) {
        this.usuario_rel = usuario_rel;
    }



    @Override
    public String toString() {
        return "Comprobante{" +
                "Id_comprob=" + Id_comprob +
                ", Fecha_Autu=" + Fecha_Autu +
                ", Factura=" + Factura +
                ", Valor=" + Valor +
                ", usuario_rel=" + usuario_rel +
                '}';
    }
}
