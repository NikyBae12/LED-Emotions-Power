package com.example.proyectoFinal.Entidad;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "Comprobante")
public class Comprobante {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer IdComprobante;

    @Column(nullable = false)
    @Temporal(TemporalType.DATE)
    private Date FechaActu;

    @PrePersist
    public void fecha_hoy(){
        this.FechaActu = new Date();
    }

    @Column(nullable = false)
    private int Factura;

    @Column(nullable = false)
    private int Valor;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "IdUsuario", referencedColumnName = "IdUsuario", nullable = false)
    @JsonIgnore
    private Usuario usuario;

    public Comprobante(Integer idComprobante, Date fechaActu, int factura, int valor, Usuario usuario_rel) {
        IdComprobante = idComprobante;
        FechaActu = fechaActu;
        Factura = factura;
        Valor = valor;
        this.usuario = usuario_rel;
    }



    public Comprobante() {
    }

    public Integer getIdComprobante() {
        return IdComprobante;
    }

    public void setIdComprobante(Integer idComprobante) {
        IdComprobante = idComprobante;
    }

    public Date getFechaActu() {
        return FechaActu;
    }

    public void setFechaActu(Date fechaActu) {
        FechaActu = fechaActu;
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
        return usuario;
    }

    public void setUsuario_rel(Usuario usuario_rel) {
        this.usuario = usuario_rel;
    }

    @Override
    public String toString() {
        return "Comprobante{" +
                "IdComprobante=" + IdComprobante +
                ", FechaActu=" + FechaActu +
                ", Factura=" + Factura +
                ", Valor=" + Valor +
                ", usuario_rel=" + usuario +
                '}';
    }
}
