package com.example.proyecto_jpa.Controlador;


import com.example.proyecto_jpa.Entidad.Emociones;
import com.example.proyecto_jpa.Entidad.conexiones;
import com.example.proyecto_jpa.Servicio.Servicio_Emociones;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
public class Controlador_Emociones {

    private Servicio_Emociones servicio_emociones;

    public Controlador_Emociones(Servicio_Emociones servicio_emociones) {
        this.servicio_emociones = servicio_emociones;
    }

    @GetMapping("/listarEmociones")
    public ArrayList<Emociones> listarEmociones(){
        return servicio_emociones.listarEmociones();
    }

    @GetMapping("/buscarEmociones/{Id_emocion}")
    public Emociones buscarEmociones(@PathVariable("Id_emocion") String Id_emocion){

        return servicio_emociones.buscarEmociones(Id_emocion);
    }

    @PostMapping("/agregarEmocion")
    public String agregarEmocion(@RequestBody Emociones emociones){
        return servicio_emociones.agregarEmociones(emociones);
    }

    @PutMapping("/actualizarEmociones")
    public String actualizarEmociones(@RequestBody Emociones emociones){
        return servicio_emociones.actuzalizarEmociones(emociones);
    }

    @DeleteMapping("/eliminarEmociones/{Id_emocion}")
    public String eliminarEmociones(@PathVariable("Id_emocion") String Id_emocion){
        return servicio_emociones.eliminarEmocion(Id_emocion);
    }

}