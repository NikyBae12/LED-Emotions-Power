package jpaledemotionspower.proyecto_jpa.Entidad;
import jakarta.persistence.*;

import java.util.Set;

@Entity
@Table(name = "Usuarios")
public class Usuario {

    @Id
    @Column(unique = true)
    private String IdUsuario;

    @Column(nullable = false)
    private String Nombres;

    @Column(nullable = false, unique = true)
    private String Email;

    @Column(nullable = false)
    private String Contraseña;

    @Column(nullable = false)
    private String FechaN;

    @Column(name = "CodVerif")
    private String CodVerif;

    @Column(name = "imgPerfil")
    private String imgPerfil;

    @Column(nullable = false)
    private String EstadoCuenta;


    @OneToMany(mappedBy = "usuario_rel", fetch = FetchType.LAZY)
    private Set<Comprobante> comprobante_rel;


    @OneToMany(mappedBy = "usuario_rel", fetch = FetchType.LAZY)
    private Set<SesionTerapia> sesionTerapias_rel;


    public Usuario(String id_usuario, String nombres, String email, String contraseña, String fechaN, String cod_verif, String img_perfil, String estado_Cu) {
        IdUsuario = id_usuario;
        Nombres = nombres;
        Email = email;
        Contraseña = contraseña;
        FechaN = fechaN;
        CodVerif = cod_verif;
        imgPerfil = img_perfil;
        EstadoCuenta = estado_Cu;
    }

    public Usuario() {
    }

    public String getIdUsuario() {
        return IdUsuario;
    }

    public void setIdUsuario(String idUsuario) {
        IdUsuario = idUsuario;
    }

    public String getNombres() {
        return Nombres;
    }

    public void setNombres(String nombres) {
        Nombres = nombres;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public String getContraseña() {
        return Contraseña;
    }

    public void setContraseña(String contraseña) {
        Contraseña = contraseña;
    }

    public String getFechaN() {
        return FechaN;
    }

    public void setFechaN(String fechaN) {
        FechaN = fechaN;
    }

    public String getCodVerif() {
        return CodVerif;
    }

    public void setCodVerif(String codVerif) {
        CodVerif = codVerif;
    }

    public String getImgPerfil() {
        return imgPerfil;
    }

    public void setImgPerfil(String imgPerfil) {
        this.imgPerfil = imgPerfil;
    }

    public String getEstadoCuenta() {
        return EstadoCuenta;
    }

    public void setEstadoCuenta(String estadoCuenta) {
        EstadoCuenta = estadoCuenta;
    }

    public Set<Comprobante> getComprobante_rel() {
        return comprobante_rel;
    }

    public void setComprobante_rel(Set<Comprobante> comprobante_rel) {
        this.comprobante_rel = comprobante_rel;
    }

    public Set<SesionTerapia> getSesionTerapias_rel() {
        return sesionTerapias_rel;
    }

    public void setSesionTerapias_rel(Set<SesionTerapia> sesionTerapias_rel) {
        this.sesionTerapias_rel = sesionTerapias_rel;
    }

    @Override
    public String toString() {
        return "Usuario{" +
                "IdUsuario='" + IdUsuario + '\'' +
                ", Nombres='" + Nombres + '\'' +
                ", Email='" + Email + '\'' +
                ", Contraseña='" + Contraseña + '\'' +
                ", FechaN='" + FechaN + '\'' +
                ", CodVerif='" + CodVerif + '\'' +
                ", imgPerfil='" + imgPerfil + '\'' +
                ", EstadoCuenta='" + EstadoCuenta + '\'' +
                '}';
    }
}
