package com.example.proyecto_jpa.Controlador;


import com.example.proyecto_jpa.Entidad.Emo_multi;
import com.example.proyecto_jpa.Servicio.Servicio_Emo_Multi;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
public class Controlador_Emo_Multi {

    private Servicio_Emo_Multi servi_multi;

    public Controlador_Emo_Multi(Servicio_Emo_Multi servi_multi) {
        this.servi_multi = servi_multi;
    }


    @GetMapping("/listarMultimedia")
    public ArrayList<Emo_multi> listarMultimedia(){
        return servi_multi.listarMultimedia();
    }


    @GetMapping("/buscarMultiemdia/{id}")
    public Emo_multi buscarMultiemdia(@PathVariable("id") String id){
        return servi_multi.buscarMultimedia(id);
    }


    @PostMapping("/agregarMultimedia")
    public String agregarMultimedia(@RequestBody Emo_multi emo_multi){
        return servi_multi.agregarMultimedia(emo_multi);
    }


    @PutMapping("/actualizarMultimedia")
    public String actualizarMultimedia(@RequestBody Emo_multi emo_multi){
        return servi_multi.actualizarMultimedia(emo_multi);
    }


    @DeleteMapping("/eliminarMultimedia/{id}")
    public String eliminarMultimedia(@PathVariable("id")String id){
        return servi_multi.elimianrMultimedia(id);
    }
}
