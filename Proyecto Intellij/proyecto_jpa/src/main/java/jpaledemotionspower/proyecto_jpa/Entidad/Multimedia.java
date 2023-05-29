package jpaledemotionspower.proyecto_jpa.Entidad;

import jakarta.persistence.*;

import java.util.Set;

@Entity
@Table(name = "Multimedia")
public class Multimedia {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer IDElemento;

    @Column(nullable = false)
    private String TipoElemento;

    @Column(nullable = false)
    private String ElementoM;


    @Column(name = "Autor")
    private String Autor;

    @Column(nullable = false)
    private Boolean MEstado;


    @OneToMany(mappedBy = "multimedia_rel", fetch = FetchType.LAZY)
    private Set<EmoMulti> Emo_Multi_rel;


    public Multimedia() {
    }

    public Multimedia(int IDElemento, String tipoElemento, String elementoM, String autor, Boolean MEstado) {
        this.IDElemento = IDElemento;
        TipoElemento = tipoElemento;
        ElementoM = elementoM;
        Autor = autor;
        this.MEstado = MEstado;
    }

    public int getIDElemento() {
        return IDElemento;
    }

    public void setIDElemento(int IDElemento) {
        this.IDElemento = IDElemento;
    }

    public String getTipoElemento() {
        return TipoElemento;
    }

    public void setTipoElemento(String tipoElemento) {
        TipoElemento = tipoElemento;
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

    public Boolean getMEstado() {
        return MEstado;
    }

    public void setMEstado(Boolean MEstado) {
        this.MEstado = MEstado;
    }

    @Override
    public String toString() {
        return "Multimedia{" +
                "IDElemento=" + IDElemento +
                ", TipoElemento='" + TipoElemento + '\'' +
                ", ElementoM='" + ElementoM + '\'' +
                ", Autor='" + Autor + '\'' +
                ", MEstado=" + MEstado +
                '}';
    }
}
