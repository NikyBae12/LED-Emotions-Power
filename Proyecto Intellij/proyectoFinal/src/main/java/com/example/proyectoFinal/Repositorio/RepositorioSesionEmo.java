package com.example.proyectoFinal.Repositorio;


import com.example.proyectoFinal.Entidad.SesionEmo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RepositorioSesionEmo extends JpaRepository<SesionEmo, Integer> {
}
