package com.example.proyecto_jpa.Repositorio;


import com.example.proyecto_jpa.Entidad.Emociones;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Repositorio_Emociones extends JpaRepository<Emociones, String> {
}