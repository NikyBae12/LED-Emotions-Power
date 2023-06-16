package com.example.proyectoFinal.Controlador;

import com.example.proyectoFinal.Entidad.Emocion;
import com.example.proyectoFinal.Servicio.ServicioEmocion;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
public class ControladorEmocion {

    private ServicioEmocion servicio_emociones;

    public ControladorEmocion(ServicioEmocion servicio_emociones) {
        this.servicio_emociones = servicio_emociones;
    }

    @GetMapping("/listarEmociones")
    public ArrayList<Emocion> listarEmociones(){
        return servicio_emociones.listarEmocion();
    }

    @GetMapping("/buscarEmociones/{Id_emocion}")
    public Emocion buscarEmociones(@PathVariable("Id_emocion") Integer Id_emocion){

        return servicio_emociones.buscarEmocion(Id_emocion);
    }

    @PostMapping("/agregarEmocion")
    public String agregarEmocion(@RequestBody Emocion emociones){
        return servicio_emociones.agregarEmocion(emociones);
    }

    @PutMapping("/actualizarEmociones")
    public String actualizarEmociones(@RequestBody Emocion emociones){
        return servicio_emociones.actuzalizarEmocion(emociones);
    }

    @DeleteMapping("/eliminarEmociones/{Id_emocion}")
    public String eliminarEmociones(@PathVariable("Id_emocion") Integer Id_emocion){
        return servicio_emociones.eliminarEmocion(Id_emocion);
    }
}
