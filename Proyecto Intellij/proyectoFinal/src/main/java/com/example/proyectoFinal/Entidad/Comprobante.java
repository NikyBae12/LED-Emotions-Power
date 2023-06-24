package com.example.proyectoFinal.Entidad;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "Comprobante")
public class Comprobante {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer idComprobante;

    @Column(nullable = false)
    @Temporal(TemporalType.DATE)
    private Date fechaActu;

    @PrePersist
    public void fecha_hoy(){
        this.fechaActu = new Date();
    }

    @Column(nullable = false)
    private int factura;

    @Column(nullable = false)
    private int valor;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "idUsuario", referencedColumnName = "idUsuario", nullable = false)
    @JsonIgnore
    private Usuario usuario;

    public Comprobante(Integer idComprobante, Date fechaActu, int factura, int valor, Usuario usuario) {
        this.idComprobante = idComprobante;
        this.fechaActu = fechaActu;
        this.factura = factura;
        this.valor = valor;
        this.usuario = usuario;
    }

    public Comprobante() {
    }

    public Integer getIdComprobante() {
        return idComprobante;
    }

    public void setIdComprobante(Integer idComprobante) {
        this.idComprobante = idComprobante;
    }

    public Date getFechaActu() {
        return fechaActu;
    }

    public void setFechaActu(Date fechaActu) {
        this.fechaActu = fechaActu;
    }

    public int getFactura() {
        return factura;
    }

    public void setFactura(int factura) {
        this.factura = factura;
    }

    public int getValor() {
        return valor;
    }

    public void setValor(int valor) {
        this.valor = valor;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
}
