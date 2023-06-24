package com.example.proyectoFinal.Repositorio;

import com.example.proyectoFinal.Entidad.Comprobante;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RepositorioComprobante extends JpaRepository<Comprobante, Integer> {
}
