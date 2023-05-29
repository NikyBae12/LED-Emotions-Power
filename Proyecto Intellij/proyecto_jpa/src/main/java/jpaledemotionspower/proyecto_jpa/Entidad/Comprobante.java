package jpaledemotionspower.proyecto_jpa.Entidad;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "Comprobantes")
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
    private Usuario usuario_rel;


    public Comprobante(int id_comprob, String id_usuario, Date fecha_Autu, int factura, int valor, Usuario usuario_rel) {
        this.IdComprobante = id_comprob;
        this.FechaActu = fecha_Autu;
        this.Factura = factura;
        this.Valor = valor;
        this.usuario_rel = usuario_rel;
    }

    public Comprobante() {
    }

    public int getIdComprobante() {
        return IdComprobante;
    }

    public void setIdComprobante(int idComprobante) {
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
        return usuario_rel;
    }

    public void setUsuario_rel(Usuario usuario_rel) {
        this.usuario_rel = usuario_rel;
    }



    @Override
    public String toString() {
        return "Comprobante{" +
                "IdComprobante=" + IdComprobante +
                ", FechaActu=" + FechaActu +
                ", Factura=" + Factura +
                ", Valor=" + Valor +
                '}';
    }
}
