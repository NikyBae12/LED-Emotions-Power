package jpaledemotionspower.proyecto_jpa.Repositorio;

import jpaledemotionspower.proyecto_jpa.Entidad.SesionTerapia;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RepositorioSesionTerapia extends JpaRepository<SesionTerapia, Integer> {
}
