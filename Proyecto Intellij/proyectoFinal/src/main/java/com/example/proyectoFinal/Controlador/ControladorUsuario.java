package com.example.proyectoFinal.Controlador;

import com.example.proyectoFinal.Entidad.Usuario;
import com.example.proyectoFinal.Servicio.ServicioUsuario;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
public class ControladorUsuario {

    private ServicioUsuario servi_usu;

    public ControladorUsuario(ServicioUsuario servi_usu) {
        this.servi_usu = servi_usu;
    }


    @GetMapping("/listarUsuarios")
    public ArrayList<Usuario> listarUsu(){
        return servi_usu.listarUsuarios();
    }


    @GetMapping("/buscarUsuario/{Id_usuario}")
    public Usuario buscarUsuario(@PathVariable("Id_usuario") String Id_usuario){
        return servi_usu.buscarUsuario(Id_usuario);
    }


    @PostMapping("/agregarUsuario")
    public String agregarUsuario(@RequestBody Usuario usuario){
        return servi_usu.agregarUsuario(usuario);
    }


    @PutMapping("/actuUsuario")
    public String ActualizarUsuario(@RequestBody Usuario usuario){
        return servi_usu.actualizarUsuario(usuario);
    }


    @DeleteMapping("/eliminarUsuario/{Id_usuario}")
    public String eliminarUsuario(@PathVariable("Id_usuario") String Id_usuario){
        return servi_usu.eliminarUsuario(Id_usuario);
    }
}
