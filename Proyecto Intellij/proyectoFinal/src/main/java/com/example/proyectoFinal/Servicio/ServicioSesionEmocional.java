package com.example.proyectoFinal.Servicio;


import com.example.proyectoFinal.Entidad.Emocion;
import com.example.proyectoFinal.Entidad.SesionEmo;
import com.example.proyectoFinal.Entidad.SesionTerapia;
import com.example.proyectoFinal.Repositorio.RepositorioEmocion;
import com.example.proyectoFinal.Repositorio.RepositorioSesionEmo;
import com.example.proyectoFinal.Repositorio.RepositorioSesionTerapia;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class ServicioSesionEmocional {
    private RepositorioSesionEmo repo_Ses_Emo;
    private RepositorioSesionTerapia repo_Sesio_Tera;
    private RepositorioEmocion repo_Emo;

    public ServicioSesionEmocional(RepositorioSesionEmo repo_Ses_Emo, RepositorioSesionTerapia repo_Sesio_Tera, RepositorioEmocion repo_Emo) {
        this.repo_Ses_Emo = repo_Ses_Emo;
        this.repo_Sesio_Tera = repo_Sesio_Tera;
        this.repo_Emo = repo_Emo;
    }

    public ArrayList<SesionEmo> listarSesionesEmocionales(){
        return (ArrayList<SesionEmo>) repo_Ses_Emo.findAll();
    }

    public SesionEmo buscarSesionEmocional(Integer id){
        return repo_Ses_Emo.findById(id).get();
    }

    public String agregarSesionEmocional(Integer Id_Sesion, Integer iD_Emocion){

        SesionEmo sesEmo = new SesionEmo();

        if (repo_Sesio_Tera.findById(Id_Sesion).isPresent() && repo_Emo.findById(iD_Emocion).isPresent()){

            SesionTerapia sesiTera = repo_Sesio_Tera.findById(Id_Sesion).get();
            Emocion emo = repo_Emo.findById(iD_Emocion).get();

            sesEmo.setId_Sesion_rel(sesiTera);
            sesEmo.setId_emocion_rel(emo);

            repo_Ses_Emo.save(sesEmo);

            return "Sesion emocional registrada";
        }else {
            return "Sesion ya regstrada";
        }
    }


    public String actualizarSesionEmocioanl(SesionEmo sesion_emo){

        if (repo_Ses_Emo.findById(sesion_emo.getIdSeEmo()).isPresent()){
            repo_Ses_Emo.save(sesion_emo);
            return "Sesion emocional guardada con exito";
        }else {
            return "Esta sesion emocional ya se encuentra registrada";
        }

    }

    public String eliminarSesionEmocional(Integer id){
        if (repo_Ses_Emo.findById(id).isPresent()){
            repo_Ses_Emo.deleteById(id);
            return "Sesion emocioanl eliminada con exito";
        }else {
            return "Sesion emocional ya eliminada o no existente";
        }
    }
}
