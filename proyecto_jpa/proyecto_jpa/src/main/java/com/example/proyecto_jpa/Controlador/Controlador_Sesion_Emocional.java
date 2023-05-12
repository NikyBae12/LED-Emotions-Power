package com.example.proyecto_jpa.Controlador;


import com.example.proyecto_jpa.Entidad.Sesion_Emo;
import com.example.proyecto_jpa.Servicio.Servicio_Sesion_Emocional;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
public class Controlador_Sesion_Emocional {

    private Servicio_Sesion_Emocional serv_Ses_Emo;

    public Controlador_Sesion_Emocional(Servicio_Sesion_Emocional serv_Ses_Emo) {
        this.serv_Ses_Emo = serv_Ses_Emo;
    }


    @GetMapping("/listarSesEmocionales")
    public ArrayList<Sesion_Emo> listarSesionesEmocionales() {
        return serv_Ses_Emo.listarSesionesEmocionales();
    }



    @GetMapping("/buscarSesionEmocional/{id}")
    public Sesion_Emo buscarSesEmocional(@PathVariable("id")String id){
        return serv_Ses_Emo.buscarSesionEmocional(id);
    }


    @PostMapping("/agregarSesionEmocional")
    public String agregarSesionEmocional(@RequestBody Sesion_Emo sesion_emo){
        return serv_Ses_Emo.agregarSesionEmocional(sesion_emo);
    }


    @PutMapping("/actualizarSesionEmocional")
    public String actuazliarSesionEmocional(@RequestBody Sesion_Emo sesion_emo){
        return serv_Ses_Emo.actualizarSesionEmocioanl(sesion_emo);
    }


    @DeleteMapping("/eliminarSesEmo")
    public String eliminarSesionEmocioanl(@PathVariable("id") String id){
        return serv_Ses_Emo.eliminarSesionEmocional(id);
    }
}
