package jpaledemotionspower.proyecto_jpa.Repositorio;


import jpaledemotionspower.proyecto_jpa.Entidad.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RepositorioUsuario extends JpaRepository<Usuario, String> {
}
