package com.example.proyectoFinal.Controlador;

import com.example.proyectoFinal.Entidad.EmoMulti;
import com.example.proyectoFinal.Servicio.ServicioEmoMulti;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
public class ControladorEmoMulti {

    private ServicioEmoMulti servi_multi;

    public ControladorEmoMulti(ServicioEmoMulti servi_multi) {
        this.servi_multi = servi_multi;
    }


    @GetMapping("/listarMultimedia")
    public ArrayList<EmoMulti> listarMultimedia(){
        return servi_multi.ListarEmoMulti();
    }


    @GetMapping("/buscarMultiemdia/{id}")
    public EmoMulti buscarMultiemdia(@PathVariable("id") Integer id){
        return servi_multi.buscarMultimedia(id);
    }


    @PostMapping("/agregarMultimedia/{id_emo}/{id_elem}")
    public String agregarMultimedia(@PathVariable("id:emo") Integer id_emo, @PathVariable("id_elem") Integer id_elem){
        return servi_multi.agregarMultimedia(id_emo, id_elem);
    }


    @PutMapping("/actualizarMultimedia")
    public String actualizarMultimedia(@RequestBody EmoMulti emo_multi){
        return servi_multi.actualizarMultimedia(emo_multi);
    }


    @DeleteMapping("/eliminarMultimedia/{id}")
    public String eliminarMultimedia(@PathVariable("id")Integer id){
        return servi_multi.elimianrMultimedia(id);
    }
}
