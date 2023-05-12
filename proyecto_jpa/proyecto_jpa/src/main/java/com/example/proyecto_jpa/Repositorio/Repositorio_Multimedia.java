package com.example.proyecto_jpa.Repositorio;


import com.example.proyecto_jpa.Entidad.Multimedia;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Repositorio_Multimedia extends JpaRepository<Multimedia, String> {
}
