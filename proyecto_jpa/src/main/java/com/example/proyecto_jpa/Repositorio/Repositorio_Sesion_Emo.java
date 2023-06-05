package com.example.proyecto_jpa.Repositorio;


import com.example.proyecto_jpa.Entidad.Sesion_Emo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Repositorio_Sesion_Emo extends JpaRepository<Sesion_Emo, String> {
}
