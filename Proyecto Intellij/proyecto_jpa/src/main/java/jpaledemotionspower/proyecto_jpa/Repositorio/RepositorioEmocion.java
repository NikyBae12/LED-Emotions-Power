package jpaledemotionspower.proyecto_jpa.Repositorio;


import jpaledemotionspower.proyecto_jpa.Entidad.Emocion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RepositorioEmocion extends JpaRepository<Emocion, Integer> {
}