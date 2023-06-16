package com.example.proyectoFinal.Controlador;

import com.example.proyectoFinal.Entidad.Multimedia;
import com.example.proyectoFinal.Servicio.ServicioMultimedia;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
public class ControladorMultimedia {

    private ServicioMultimedia servicio_multimedia;

    public ControladorMultimedia(ServicioMultimedia servicio_multimedia) {
        this.servicio_multimedia = servicio_multimedia;
    }


    @GetMapping("/listarElementos")
    public ArrayList<Multimedia> listarElementos(){
        return servicio_multimedia.listarElemento();
    }


    @GetMapping("/buscarElemento/{id}")
    public Multimedia buscarElemento(@PathVariable("id")Integer id){
        return servicio_multimedia.encontrarElemento(id);
    }


    @PostMapping("/agregarElemento")
    public String agregarElemento(@RequestBody Multimedia multimedia){
        return servicio_multimedia.agregarElemento(multimedia);
    }


    @PutMapping("/actualiazarElemento")
    public String actualiazarElemento(@RequestBody Multimedia multimedia){
        return servicio_multimedia.actualizarElemento(multimedia);
    }


    @DeleteMapping("/eliminarElemento/{id}")
    public String eliminarElemento(@PathVariable("id")Integer id){
        return servicio_multimedia.eliminarElemento(id);
    }
}
