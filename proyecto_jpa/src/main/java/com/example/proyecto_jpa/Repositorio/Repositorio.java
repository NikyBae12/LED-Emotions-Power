package com.example.proyecto_jpa.Repositorio;

import com.example.proyecto_jpa.Entidad.conexiones;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Repositorio extends JpaRepository<conexiones, Integer> {
}
