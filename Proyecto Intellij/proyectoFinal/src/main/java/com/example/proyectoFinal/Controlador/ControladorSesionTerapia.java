package com.example.proyectoFinal.Controlador;

import com.example.proyectoFinal.Entidad.SesionTerapia;
import com.example.proyectoFinal.Servicio.ServicioSesionTerapia;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
public class ControladorSesionTerapia {

    private ServicioSesionTerapia servicio_sesion_terapia;

    public ControladorSesionTerapia(ServicioSesionTerapia servicio_sesion_terapia) {
        this.servicio_sesion_terapia = servicio_sesion_terapia;
    }


    @GetMapping("/listarSesionTerapia")
    public ArrayList<SesionTerapia> listarSesionTerapia(){
        return servicio_sesion_terapia.listarSesionesTerapia();
    }


    @GetMapping("/buscarSesionTerapia/{ID_sesion}")
    public SesionTerapia buscarSesionTerapia(@PathVariable("ID_sesion") Integer ID_sesion){
        return servicio_sesion_terapia.buscarSesionTerapia(ID_sesion);
    }


    @PostMapping("/agregarSesionTerapia")
    public String agregarSesionTer(@RequestBody SesionTerapia sesionTerapia){
        return servicio_sesion_terapia.agregarSesionTerapia(sesionTerapia);
    }


    @PutMapping("/actualizarSesionTerapia")
    public String actualizarSesionTer(@RequestBody SesionTerapia sesionTerapia){
        return servicio_sesion_terapia.actuzalizarSesionTerapia(sesionTerapia);
    }


    @DeleteMapping("/eliminarSesionTerapia/{ID_sesion}")
    public String aliminarSesionTer(@PathVariable("ID_sesion") Integer ID_sesion){
        return servicio_sesion_terapia.eliminarSesionTerapia(ID_sesion);
    }
}
