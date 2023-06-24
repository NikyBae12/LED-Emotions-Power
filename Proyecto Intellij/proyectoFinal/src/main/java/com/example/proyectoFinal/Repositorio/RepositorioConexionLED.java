package com.example.proyectoFinal.Repositorio;


import com.example.proyectoFinal.Entidad.ConexionLED;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RepositorioConexionLED extends JpaRepository<ConexionLED, Integer> {
}
