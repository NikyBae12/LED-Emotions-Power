package com.example.proyectoFinal.Controlador;

import com.example.proyectoFinal.Entidad.ConexionLED;
import com.example.proyectoFinal.Servicio.ServicioConexionLED;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
public class ControladorConexionLED {
    private ServicioConexionLED servicioConexionLED;

    public ControladorConexionLED(ServicioConexionLED servicioConexionLED) {
        this.servicioConexionLED = servicioConexionLED;
    }

    @GetMapping("/listarConexiones")
    public ArrayList<ConexionLED> listarCone(){ return servicioConexionLED.listarConexiones(); }

    @GetMapping("/buscarConexion/{id}")
    public ConexionLED buscarConexion(@PathVariable("id") Integer id){
        return servicioConexionLED.buscarConexion(id);
    }

    @PostMapping("/agregarConexion")
    public String agregarConexion(@RequestBody ConexionLED Conexion){
        return servicioConexionLED.agregarConexion(Conexion);
    }

    @PutMapping("/actualizarConexion")
    public String actualizarConexion(@RequestBody ConexionLED Conexion){
        return servicioConexionLED.actualizarConexion(Conexion);
    }

    @DeleteMapping("/eliminarConexion/{id}")
    public String eliminarConexion(@PathVariable("id") Integer id){
        return servicioConexionLED.eliminarConexion(id);
    }

}
