package com.example.proyecto_jpa.Repositorio;


import com.example.proyecto_jpa.Entidad.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Repositorio_Usuario extends JpaRepository<Usuario, Integer> {
}
