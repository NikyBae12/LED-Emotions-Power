package com.example.proyectoFinal.Servicio;


import com.example.proyectoFinal.Entidad.Usuario;
import com.example.proyectoFinal.Repositorio.RepositorioComprobante;
import com.example.proyectoFinal.Repositorio.RepositorioSesionTerapia;
import com.example.proyectoFinal.Repositorio.RepositorioUsuario;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class ServicioUsuario {

    private RepositorioUsuario repoUsuario;

    private RepositorioComprobante repoComprobante;

    private RepositorioSesionTerapia repoSesionTerapia;

    public ServicioUsuario(RepositorioUsuario repoUsuario, RepositorioComprobante repoComprobante, RepositorioSesionTerapia repoSesionTerapia) {
        this.repoUsuario = repoUsuario;
        this.repoComprobante = repoComprobante;
        this.repoSesionTerapia = repoSesionTerapia;
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
            repoUsuario.save(usuario);
            return "Tipo de Usuario actualizado con exito.";

        } else {

            return "Usuario no encontrado.";
        }

    }

    public String eliminarUsuario(String Id_usuario){

        if (repoComprobante.FindComprobantesxUsuario(Id_usuario).isEmpty() && repoSesionTerapia.FindSesionesxUsuario(Id_usuario).isEmpty()){
            if (repoUsuario.findById(Id_usuario).isPresent()){
                repoUsuario.deleteById(Id_usuario);
                return "Usuario eliminado con exito.";

            }else {
                return "Usuario no encontrado.";
            }

        }else {
            return "Este usuario esta vinculado con otras entidades y solo se puede desactivar.";

        }


    }
}
