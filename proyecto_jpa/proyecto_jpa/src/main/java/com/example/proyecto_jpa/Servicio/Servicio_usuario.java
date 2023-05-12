package com.example.proyecto_jpa.Servicio;


import com.example.proyecto_jpa.Entidad.Usuario;
import com.example.proyecto_jpa.Repositorio.Repositorio_Usuario;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class Servicio_usuario {

    private Repositorio_Usuario repo_usu;

    public Servicio_usuario(Repositorio_Usuario repo_usu) {
        this.repo_usu = repo_usu;
    }


    public ArrayList<Usuario> listarUsuarios(){

        return (ArrayList<Usuario>) repo_usu.findAll();
    }


    public Usuario BuscarUsuario(String Id_usuario){
        return repo_usu.findById(Id_usuario).get();
    }

    public String agregarUsuario(Usuario usuario){

        if (repo_usu.findById(usuario.getId_usuario()).isPresent()){
            return "El usuario ya se encuentra registrado";
        }else {
            repo_usu.save(usuario);
            return "Usuario registrado exitosamente";
        }
    }


    public String actualizarUsuario(Usuario usuario){

        if (repo_usu.findById(usuario.getId_usuario()).isPresent()){
            repo_usu.save(usuario);
            return "Usuario actualizado con exito";
        }else {
            return "Este usuario no se encuentra";
        }
    }

    public String eliminarUsuario(String Id_usuario){

        if (repo_usu.findById(Id_usuario).isPresent()){
            repo_usu.deleteById(Id_usuario);
            return "Usuario eliminado con exito";

        }else {
            return "Usario ya elimanado o se encuentra registrado en otra tabla";
        }
    }
}
