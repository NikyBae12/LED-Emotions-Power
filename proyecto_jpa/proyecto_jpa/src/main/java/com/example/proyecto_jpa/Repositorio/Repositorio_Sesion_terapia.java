package com.example.proyecto_jpa.Repositorio;


import com.example.proyecto_jpa.Entidad.SesionTerapia;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Repositorio_Sesion_terapia extends JpaRepository<SesionTerapia, String> {
}
