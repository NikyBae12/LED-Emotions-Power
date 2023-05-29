package jpaledemotionspower.proyecto_jpa.Repositorio;


import jpaledemotionspower.proyecto_jpa.Entidad.Multimedia;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RepositorioMultimedia extends JpaRepository<Multimedia, Integer> {
}
