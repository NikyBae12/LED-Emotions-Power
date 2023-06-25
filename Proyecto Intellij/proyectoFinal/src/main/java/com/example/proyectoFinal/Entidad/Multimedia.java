package com.example.proyectoFinal.Entidad;


import jakarta.persistence.*;

import java.util.Set;

@Entity
@Table(name = "Multimedia")
public class Multimedia {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer idElemento;

    @Column(nullable = false)
    private String tipoElemento;

    @Column(nullable = false)
    private String elementoM;


    @Column(name = "Autor")
    private String autor;

    @Column(nullable = false)
    private Boolean mEstado;


    @OneToMany(mappedBy = "multimediaRel", fetch = FetchType.LAZY)
    private Set<EmoMulti> EmoMultiRel;

    public Multimedia(Integer idElemento, String tipoElemento, String elementoM, String autor, Boolean mEstado) {
        this.idElemento = idElemento;
        this.tipoElemento = tipoElemento;
        this.elementoM = elementoM;
        this.autor = autor;
        this.mEstado = mEstado;
    }

    public Multimedia() {
    }

    public Integer getIdElemento() {
        return idElemento;
    }

    public void setIdElemento(Integer idElemento) {
        this.idElemento = idElemento;
    }

    public String getTipoElemento() {
        return tipoElemento;
    }

    public void setTipoElemento(String tipoElemento) {
        this.tipoElemento = tipoElemento;
    }

    public String getElementoM() {
        return elementoM;
    }

    public void setElementoM(String elementoM) {
        this.elementoM = elementoM;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public Boolean getmEstado() {
        return mEstado;
    }

    public void setmEstado(Boolean mEstado) {
        this.mEstado = mEstado;
    }

    public Set<EmoMulti> getEmo_Multi_rel() {
        return EmoMultiRel;
    }

    public void setEmo_Multi_rel(Set<EmoMulti> emo_Multi_rel) {
        EmoMultiRel = emo_Multi_rel;
    }
}
