package jpaledemotionspower.proyecto_jpa.Entidad;


import jakarta.persistence.*;

import java.util.Set;

@Entity
@Table(name = "Emociones")
public class Emocion {


    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer IdEmocion;

    @Column(nullable = false)
    private String ENombre;

    @Column(nullable = false)
    private int eColorRed;

    @Column(nullable = false)
    private int eColorGreen;

    @Column(nullable = false)
    private int eColorBlue;

    @Column(nullable = false)
    private Boolean eEstadoA;


    @OneToMany(mappedBy = "Id_emocion_rel", fetch = FetchType.LAZY)
    private Set<SesionEmo> Sesion_rel;


    @OneToMany(mappedBy = "Id_emocion_rel", fetch = FetchType.LAZY)
    private Set<EmoMulti> Multi_rel;


    public Emocion() {
    }

    public Emocion(int id_emocion, String ENombre, int eColorRed, int eColorGreen, int eColorBlue, Boolean eEstadoA) {
        IdEmocion = id_emocion;
        this.ENombre = ENombre;
        this.eColorRed = eColorRed;
        this.eColorGreen = eColorGreen;
        this.eColorBlue = eColorBlue;
        this.eEstadoA = eEstadoA;
    }

    public int getId_emocion() {
        return IdEmocion;
    }

    public void setId_emocion(int id_emocion) {
        IdEmocion = id_emocion;
    }

    public String getENombre() {
        return ENombre;
    }

    public void setENombre(String ENombre) {
        this.ENombre = ENombre;
    }

    public int geteColorRed() {
        return eColorRed;
    }

    public void seteColorRed(int eColorRed) {
        this.eColorRed = eColorRed;
    }

    public int geteColorGreen() {
        return eColorGreen;
    }

    public void seteColorGreen(int eColorGreen) {
        this.eColorGreen = eColorGreen;
    }

    public int geteColorBlue() {
        return eColorBlue;
    }

    public void seteColorBlue(int eColorBlue) {
        this.eColorBlue = eColorBlue;
    }

    public Boolean geteEstadoA() {
        return eEstadoA;
    }

    public void seteEstadoA(Boolean eEstadoA) {
        this.eEstadoA = eEstadoA;
    }

    public Set<SesionEmo> getSesion_rel() {
        return Sesion_rel;
    }

    public void setSesion_rel(Set<SesionEmo> sesion_rel) {
        Sesion_rel = sesion_rel;
    }

    public Set<EmoMulti> getMulti_rel() {
        return Multi_rel;
    }

    public void setMulti_rel(Set<EmoMulti> multi_rel) {
        Multi_rel = multi_rel;
    }

    @Override
    public String toString() {
        return "Emocion{" +
                "Id_emocion=" + IdEmocion +
                ", ENombre='" + ENombre + '\'' +
                ", eColorRed=" + eColorRed +
                ", eColorGreen=" + eColorGreen +
                ", eColorBlue=" + eColorBlue +
                ", eEstadoA=" + eEstadoA +
                '}';
    }
}