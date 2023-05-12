package com.example.proyecto_jpa.Controlador;


import com.example.proyecto_jpa.Entidad.Usuario;
import com.example.proyecto_jpa.Servicio.Servicio_usuario;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
public class Controlador_usuario {

    private Servicio_usuario servi_usu;

    public Controlador_usuario(Servicio_usuario servi_usu) {
        this.servi_usu = servi_usu;
    }


    @GetMapping("/listarUsuarios")
    public ArrayList<Usuario> listarUsu(){
        return servi_usu.listarUsuarios();
    }


    @GetMapping("/buscarUsuario/{Id_usuario}")
    public Usuario buscarUsuario(@PathVariable("Id_usuario") String Id_usuario){
        return servi_usu.BuscarUsuario(Id_usuario);
    }


    @PostMapping("/agregarUsuario")
    public String agregarUsuario(@RequestBody Usuario usuario){
        return servi_usu.agregarUsuario(usuario);
    }


    @PutMapping("/actuUsuario")
    public String ActualizarUsuario(@RequestBody Usuario usuario){
        return servi_usu.actualizarUsuario(usuario);
    }


    @DeleteMapping("/eliminarUsuario")
    public String eliminarUsuario(@PathVariable("Id_usuario") String Id_usuario){
        return servi_usu.eliminarUsuario(Id_usuario);
    }
}
