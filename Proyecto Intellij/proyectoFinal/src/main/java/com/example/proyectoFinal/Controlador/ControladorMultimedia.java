package com.example.proyectoFinal.Controlador;

import com.example.proyectoFinal.Entidad.Multimedia;
import com.example.proyectoFinal.Servicio.ServicioMultimedia;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@CrossOrigin (origins = "*", maxAge = 3600)
@RestController
public class ControladorMultimedia {

    private ServicioMultimedia servicio_multimedia;

    public ControladorMultimedia(ServicioMultimedia servicio_multimedia) {
        this.servicio_multimedia = servicio_multimedia;
    }


    @GetMapping("/listarElementosM")
    public ArrayList<Multimedia> listarElementos(){
        return servicio_multimedia.listarElementosM();
    }


    @GetMapping("/buscarElementoM/{id}")
    public Multimedia buscarElemento(@PathVariable("id")Integer id){
        return servicio_multimedia.buscarElementoM(id);
    }


    @PostMapping("/agregarElementoM")
    public String agregarElemento(@RequestBody Multimedia multimedia){
        return servicio_multimedia.agregarElementoM(multimedia);
    }


    @PutMapping("/actualizarElementoM")
    public String actualiazarElemento(@RequestBody Multimedia multimedia){
        return servicio_multimedia.actualizarElementoM(multimedia);
    }


    @DeleteMapping("/eliminarElementoM/{id}")
    public String eliminarElemento(@PathVariable("id")Integer id){
        return servicio_multimedia.eliminarElementoM(id);
    }
}
