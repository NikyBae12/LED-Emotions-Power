package com.example.proyectoFinal.Repositorio;


import com.example.proyectoFinal.Entidad.SesionTerapia;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RepositorioSesionTerapia extends JpaRepository<SesionTerapia, Integer> {
}
