package jpaledemotionspower.proyecto_jpa.Repositorio;


import jpaledemotionspower.proyecto_jpa.Entidad.Comprobante;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RepositorioComprobante extends JpaRepository<Comprobante, Integer> {
}
