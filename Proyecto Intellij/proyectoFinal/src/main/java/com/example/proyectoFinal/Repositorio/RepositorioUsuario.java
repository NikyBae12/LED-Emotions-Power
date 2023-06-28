package com.example.proyectoFinal.Repositorio;

import com.example.proyectoFinal.Entidad.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository
public interface RepositorioUsuario extends JpaRepository<Usuario, String> {

    Usuario findByEmail(String email);

    Usuario findByIdUsuario(String idUsuario);


}
