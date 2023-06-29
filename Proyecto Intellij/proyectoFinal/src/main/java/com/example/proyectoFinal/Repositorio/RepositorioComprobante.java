package com.example.proyectoFinal.Repositorio;

import com.example.proyectoFinal.Entidad.Comprobante;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RepositorioComprobante extends JpaRepository<Comprobante, Integer> {

    @Query(value = "select * from comprobante as c inner join usuario as u on c.id_usuario = u.id_usuario", nativeQuery = true)
    List<Object[]> FindComprobantesxUsuario(String idUsuario);

}
