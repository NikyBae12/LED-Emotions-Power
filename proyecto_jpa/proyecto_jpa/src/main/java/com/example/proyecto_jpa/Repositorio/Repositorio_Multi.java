package com.example.proyecto_jpa.Repositorio;


import com.example.proyecto_jpa.Entidad.Emo_multi;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Repositorio_Multi extends JpaRepository<Emo_multi, String> {
}
