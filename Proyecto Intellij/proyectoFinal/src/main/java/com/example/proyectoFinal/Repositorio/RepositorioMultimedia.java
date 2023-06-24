package com.example.proyectoFinal.Repositorio;


import com.example.proyectoFinal.Entidad.Multimedia;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RepositorioMultimedia extends JpaRepository<Multimedia, Integer> {
}
