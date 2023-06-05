package com.example.proyecto_jpa.Entidad;

import jakarta.persistence.*;

import java.util.Set;

@Entity
@Table(name = "Multimedia")
public class Multimedia {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer ID_Elemento;

    @Column(nullable = false)
    private String Tipo_elemento;

    @Column(nullable = false)
    private String ElementoM;


    @Column(name = "Autor")
    private String Autor;

    @Column(nullable = false)
    private Boolean N_Estado;


    @OneToMany(mappedBy = "multimedia_rel", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<Emo_multi> Emo_rel_dos;


    public Multimedia(Integer ID_Elemento, String tipo_elemento, String elementoM, String autor, Boolean n_Estado) {
        this.ID_Elemento = ID_Elemento;
        Tipo_elemento = tipo_elemento;
        ElementoM = elementoM;
        Autor = autor;
        N_Estado = n_Estado;
    }

    public Multimedia() {
    }

    public Integer getID_Elemento() {
        return ID_Elemento;
    }

    public void setID_Elemento(Integer ID_Elemento) {
        this.ID_Elemento = ID_Elemento;
    }

    public String getTipo_elemento() {
        return Tipo_elemento;
    }

    public void setTipo_elemento(String tipo_elemento) {
        Tipo_elemento = tipo_elemento;
    }

    public String getElementoM() {
        return ElementoM;
    }

    public void setElementoM(String elementoM) {
        ElementoM = elementoM;
    }

    public String getAutor() {
        return Autor;
    }

    public void setAutor(String autor) {
        Autor = autor;
    }

    public Boolean getN_Estado() {
        return N_Estado;
    }

    public void setN_Estado(Boolean n_Estado) {
        N_Estado = n_Estado;
    }

    @Override
    public String toString() {
        return "Multimedia{" +
                "ID_Elemento=" + ID_Elemento +
                ", Tipo_elemento='" + Tipo_elemento + '\'' +
                ", ElementoM='" + ElementoM + '\'' +
                ", Autor='" + Autor + '\'' +
                ", N_Estado=" + N_Estado +
                '}';
    }
}
