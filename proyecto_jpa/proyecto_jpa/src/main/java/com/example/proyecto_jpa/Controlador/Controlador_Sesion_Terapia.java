package com.example.proyecto_jpa.Controlador;


import com.example.proyecto_jpa.Entidad.SesionTerapia;
import com.example.proyecto_jpa.Servicio.Servicio_Sesion_Terapia;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
public class Controlador_Sesion_Terapia {

    private Servicio_Sesion_Terapia servicio_sesion_terapia;

    public Controlador_Sesion_Terapia(Servicio_Sesion_Terapia servicio_sesion_terapia) {
        this.servicio_sesion_terapia = servicio_sesion_terapia;
    }


    @GetMapping("/listarSesionTerapia")
    public ArrayList<SesionTerapia> listarSesionTerapia(){
        return servicio_sesion_terapia.listarSesionesTerapia();
    }


    @GetMapping("/buiscarSesionTer/{ID_sesion}")
    public SesionTerapia buscarSesionTerapia(@PathVariable("ID_sesion") String ID_sesion){
        return servicio_sesion_terapia.buscarComprobante(ID_sesion);
    }


    @PostMapping("/agregarSesionTer")
    public String agregarSesionTer(@RequestBody SesionTerapia sesionTerapia){
        return servicio_sesion_terapia.agregarSesionTerapia(sesionTerapia);
    }


    @PutMapping("/actualizarSesionTer")
    public String actualizarSesionTer(@RequestBody SesionTerapia sesionTerapia){
        return servicio_sesion_terapia.actuzalizarComprobante(sesionTerapia);
    }


    @DeleteMapping("/eliminarSesionTer/{ID_sesion}")
    public String aliminarSesionTer(@PathVariable("ID_sesion") String ID_sesion){
        return servicio_sesion_terapia.eliminarSesionTerapia(ID_sesion);
    }
}
