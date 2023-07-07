package com.example.proyectoFinal.Controlador;

import com.example.proyectoFinal.Entidad.ConexionLED;
import com.example.proyectoFinal.Servicio.ServicioConexionLED;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@CrossOrigin (origins = "*", maxAge = 3600)
@RestController
public class ControladorConexionLED {
    private ServicioConexionLED servicioConexionLED;

    public ControladorConexionLED(ServicioConexionLED servicioConexionLED) {
        this.servicioConexionLED = servicioConexionLED;
    }

    @GetMapping("/listarConexionesLED")
    public ArrayList<ConexionLED> listarConexion(){ return servicioConexionLED.listarConexiones(); }

    @GetMapping("/buscarConexionLED/{id}")
    public ConexionLED buscarConexion(@PathVariable("id") Integer id){
        return servicioConexionLED.buscarConexion(id);
    }

    @PostMapping("/agregarConexionLED")
    public String agregarConexion(@RequestBody ConexionLED Conexion){
        return servicioConexionLED.agregarConexion(Conexion);
    }

    @PutMapping("/actualizarConexionLED")
    public String actualizarConexion(@RequestBody ConexionLED Conexion){
        return servicioConexionLED.actualizarConexion(Conexion);
    }

    @DeleteMapping("/eliminarConexionLED/{id}")
    public String eliminarConexion(@PathVariable("id") Integer id){
        return servicioConexionLED.eliminarConexion(id);
    }

}
