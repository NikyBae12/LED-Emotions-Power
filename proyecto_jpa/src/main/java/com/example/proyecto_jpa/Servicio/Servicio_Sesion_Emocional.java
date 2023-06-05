package com.example.proyecto_jpa.Servicio;


import com.example.proyecto_jpa.Entidad.Sesion_Emo;
import com.example.proyecto_jpa.Repositorio.Repositorio_Sesion_Emo;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class Servicio_Sesion_Emocional {

    private Repositorio_Sesion_Emo repo_Ses_Emo;

    public Servicio_Sesion_Emocional(Repositorio_Sesion_Emo repo_Ses_Emo) {
        this.repo_Ses_Emo = repo_Ses_Emo;
    }

    public ArrayList<Sesion_Emo> listarSesionesEmocionales(){

        return (ArrayList<Sesion_Emo>) repo_Ses_Emo.findAll();
    }

    public Sesion_Emo buscarSesionEmocional(String id){
        return repo_Ses_Emo.findById(id).get();
    }

    public String agregarSesionEmocional(Sesion_Emo sesion_emo){

        if (repo_Ses_Emo.findById(String.valueOf(sesion_emo.getId_Sesion_Emocional())).isPresent()){
            return "La sesio emocional ya se encuentra registrada";
        }else {
            repo_Ses_Emo.save(sesion_emo);
            return "Sesion emocial registrada co exito";
        }
    }


    public String actualizarSesionEmocioanl(Sesion_Emo sesion_emo){

        if (repo_Ses_Emo.findById(String.valueOf(sesion_emo.getId_Sesion_Emocional())).isPresent()){
            repo_Ses_Emo.save(sesion_emo);
            return "Sesion emocional guardada con exito";
        }else {
            return "Esta sesion emocional ya se encuentra registrada";
        }

    }

    public String eliminarSesionEmocional(String id){
        if (repo_Ses_Emo.findById(id).isPresent()){
            repo_Ses_Emo.deleteById(id);
            return "Sesion emocioanl eliminada con exito";
        }else {
            return "Sesion emocional ya eliminada o no existente";
        }
    }
}
