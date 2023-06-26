package com.example.proyectoFinal.Repositorio;


import com.example.proyectoFinal.Entidad.Emocion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RepositorioEmocion extends JpaRepository<Emocion, Integer> {
}
