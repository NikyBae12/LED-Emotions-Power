package com.example.proyectoFinal.Controlador;


import com.example.proyectoFinal.Entidad.SesionEmo;
import com.example.proyectoFinal.Servicio.ServicioSesionEmocion;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
public class ControladorSesionEmocion {

    private ServicioSesionEmocion serv_Ses_Emo;

    public ControladorSesionEmocion(ServicioSesionEmocion serv_Ses_Emo) {
        this.serv_Ses_Emo = serv_Ses_Emo;
    }


    @GetMapping("/listarSesionEmociones")
    public ArrayList<SesionEmo> listarSesionEmociones() {
        return serv_Ses_Emo.listarSesionEmociones();
    }



    @GetMapping("/buscarSesionEmociones/{id}")
    public SesionEmo buscarSesionEmociones(@PathVariable("id")Integer id){
        return serv_Ses_Emo.buscarSesionEmociones(id);
    }


    @PostMapping("/agregarSesionEmociones/{id_ses}/{id_emo}")
    public String agregarSesionEmociones(@PathVariable("id_ses") Integer id_ses, @PathVariable("id_emo") Integer id_emo){
        return serv_Ses_Emo.agregarSesionEmociones(id_ses, id_emo);
    }


    @PutMapping("/actualizarSesionEmociones")
    public String actualizarSesionEmociones(@RequestBody SesionEmo sesion_emo){
        return serv_Ses_Emo.actualizarSesionEmociones(sesion_emo);
    }


    @DeleteMapping("/eliminarSesionEmo")
    public String eliminarSesionEmociones(@PathVariable("id") Integer id){
        return serv_Ses_Emo.eliminarSesionEmociones(id);
    }
}
