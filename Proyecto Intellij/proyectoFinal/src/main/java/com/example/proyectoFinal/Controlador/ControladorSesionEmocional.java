package com.example.proyectoFinal.Controlador;


import com.example.proyectoFinal.Entidad.SesionEmo;
import com.example.proyectoFinal.Servicio.ServicioSesionEmocional;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
public class ControladorSesionEmocional {

    private ServicioSesionEmocional serv_Ses_Emo;

    public ControladorSesionEmocional(ServicioSesionEmocional serv_Ses_Emo) {
        this.serv_Ses_Emo = serv_Ses_Emo;
    }


    @GetMapping("/listarSesEmocionales")
    public ArrayList<SesionEmo> listarSesionesEmocionales() {
        return serv_Ses_Emo.listarSesionesEmocionales();
    }



    @GetMapping("/buscarSesionEmocional/{id}")
    public SesionEmo buscarSesEmocional(@PathVariable("id")Integer id){
        return serv_Ses_Emo.buscarSesionEmocional(id);
    }


    @PostMapping("/agregarSesionEmocional/{id_ses}/{id_emo}")
    public String agregarSesionEmocional(@PathVariable("id_ses") Integer id_ses, @PathVariable("id_emo") Integer id_emo){
        return serv_Ses_Emo.agregarSesionEmocional(id_ses, id_emo);
    }


    @PutMapping("/actualizarSesionEmocional")
    public String actuazliarSesionEmocional(@RequestBody SesionEmo sesion_emo){
        return serv_Ses_Emo.actualizarSesionEmocioanl(sesion_emo);
    }


    @DeleteMapping("/eliminarSesEmo")
    public String eliminarSesionEmocioanl(@PathVariable("id") Integer id){
        return serv_Ses_Emo.eliminarSesionEmocional(id);
    }
}
