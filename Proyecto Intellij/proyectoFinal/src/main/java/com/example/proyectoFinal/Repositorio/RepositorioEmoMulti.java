package com.example.proyectoFinal.Repositorio;


import com.example.proyectoFinal.Entidad.EmoMulti;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RepositorioEmoMulti extends JpaRepository<EmoMulti, Integer> {
}
