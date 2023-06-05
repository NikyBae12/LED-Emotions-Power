package com.example.proyecto_jpa.Controlador;


import com.example.proyecto_jpa.Entidad.conexiones;
import com.example.proyecto_jpa.Servicio.Servicio;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
public class Controlador {

    private Servicio servicio;

    public Controlador(Servicio servicio) {
        this.servicio = servicio;
    }


    @GetMapping("/listarConexiones")
    public ArrayList<conexiones> listarCone(){ return servicio.listarConexiones(); }

    @GetMapping("/buscarConexion/{id}")
    public conexiones buscarConexion(@PathVariable("id") String id){
        return servicio.buscarConexion(id);
    }

    @PostMapping("/agregarConexion")
    public String agregarConexion(@RequestBody conexiones Conexion){
        return servicio.agregarConexion(Conexion);
    }

    @PutMapping("/actualizarConexion")
    public String actualizarConexion(@RequestBody conexiones Conexion){
        return servicio.actualizarConexion(Conexion);
    }

    @DeleteMapping("/eliminarConexion/{id}")
    public String eliminarConexion(@PathVariable("id") String id){
        return servicio.eliminarConexion(id);
    }

}
