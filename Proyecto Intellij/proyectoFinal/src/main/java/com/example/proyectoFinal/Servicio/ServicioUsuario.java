package com.example.proyectoFinal.Servicio;


import com.example.proyectoFinal.Entidad.Usuario;
import com.example.proyectoFinal.Repositorio.RepositorioUsuario;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class ServicioUsuario {

    private RepositorioUsuario repoUsuario;

    public ServicioUsuario(RepositorioUsuario repoUsuario) {
        this.repoUsuario = repoUsuario;
    }

    public ArrayList<Usuario> listarUsuarios(){

        return (ArrayList<Usuario>) repoUsuario.findAll();
    }


    public Usuario buscarUsuario(String Id_usuario){
        return repoUsuario.findByIdUsuario(Id_usuario);
    }

    public Usuario buscarUsuarioxCorreo(String correo) {
        return repoUsuario.findByEmail(correo);
    }

    public String agregarUsuario(Usuario usuario){

        if (repoUsuario.findById(usuario.getEmail()).isPresent()){
            return "El usuario ya se encuentra registrado.";
        }else {
            repoUsuario.save(usuario);
            return "Usuario registrado exitosamente.";
        }
    }


    public String actualizarUsuario(Usuario usuario){

        if (repoUsuario.findById(usuario.getIdUsuario()).isPresent()){
            repoUsuario.save(usuario);
            return "Usuario actualizado con exito.";
        }else {
            return "Usuario no encontrado.";
        }
    }

    public String actualizarTipoUsuario(String tipoUser, String documento){

        Usuario usuario = repoUsuario.findById(documento).get();

        if (repoUsuario.findById(usuario.getIdUsuario()).isPresent()){

            usuario.setEstadoCuenta(tipoUser);
            return "Tipo de Usuario actualizado con exito.";

        } else {

            return "Usuario no encontrado.";
        }

    }

    public String eliminarUsuario(String Id_usuario){

        if (repoUsuario.findById(Id_usuario).isPresent()){
            repoUsuario.deleteById(Id_usuario);
            return "Usuario eliminado con exito.";

        }else {
            return "Usuario no encontrado.";
        }
    }
}
