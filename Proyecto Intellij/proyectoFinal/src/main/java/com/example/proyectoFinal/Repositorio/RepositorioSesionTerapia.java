package com.example.proyectoFinal.Repositorio;


import com.example.proyectoFinal.Entidad.SesionTerapia;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RepositorioSesionTerapia extends JpaRepository<SesionTerapia, Integer> {

    @Query(value = "select * from sesion_terapia as s inner join usuario as u on s.id_usuario = u.id_usuario", nativeQuery = true)
    List<Object[]> FindSesionesxUsuario(String idUsuario);

}
