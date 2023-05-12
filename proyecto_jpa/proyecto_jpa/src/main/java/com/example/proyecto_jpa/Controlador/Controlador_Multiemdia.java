package com.example.proyecto_jpa.Controlador;

import com.example.proyecto_jpa.Entidad.Multimedia;
import com.example.proyecto_jpa.Servicio.Servicio_Multimedia;
import org.springframework.web.bind.annotation.*;

import javax.swing.plaf.PanelUI;
import java.util.ArrayList;

@RestController
public class Controlador_Multiemdia {


    private Servicio_Multimedia servicio_multimedia;

    public Controlador_Multiemdia(Servicio_Multimedia servicio_multimedia) {
        this.servicio_multimedia = servicio_multimedia;
    }


    @GetMapping("/listarElementos")
    public ArrayList<Multimedia> listarElementos(){
        return servicio_multimedia.listarElemento();
    }


    @GetMapping("/buscarElemento/{id}")
    public Multimedia buscarElemento(@PathVariable("id")String id){
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
    public String eliminarElemento(@PathVariable("id")String id){
        return servicio_multimedia.eliminarElemento(id);
    }
}
