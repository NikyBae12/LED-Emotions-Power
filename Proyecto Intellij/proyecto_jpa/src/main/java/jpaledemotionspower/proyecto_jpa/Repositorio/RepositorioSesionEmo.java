package jpaledemotionspower.proyecto_jpa.Repositorio;

import jpaledemotionspower.proyecto_jpa.Entidad.SesionEmo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RepositorioSesionEmo extends JpaRepository<SesionEmo, Integer> {
}
