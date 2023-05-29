package jpaledemotionspower.proyecto_jpa.Repositorio;


import jpaledemotionspower.proyecto_jpa.Entidad.EmoMulti;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RepositorioEmoMulti extends JpaRepository<EmoMulti, Integer> {
}
