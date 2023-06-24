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
public class ServicioSesionEmocion {
    private RepositorioSesionEmo repo_Ses_Emo;
    private RepositorioSesionTerapia repo_Sesio_Tera;
    private RepositorioEmocion repo_Emo;

    public ServicioSesionEmocion(RepositorioSesionEmo repo_Ses_Emo, RepositorioSesionTerapia repo_Sesio_Tera, RepositorioEmocion repo_Emo) {
        this.repo_Ses_Emo = repo_Ses_Emo;
        this.repo_Sesio_Tera = repo_Sesio_Tera;
        this.repo_Emo = repo_Emo;
    }

    public ArrayList<SesionEmo> listarSesionEmociones(){
        return (ArrayList<SesionEmo>) repo_Ses_Emo.findAll();
    }

    public SesionEmo buscarSesionEmociones(Integer id){
        return repo_Ses_Emo.findById(id).get();
    }

    public String agregarSesionEmociones(Integer Id_Sesion, Integer iD_Emocion){

        SesionEmo sesEmo = new SesionEmo();

        if (repo_Sesio_Tera.findById(Id_Sesion).isPresent() && repo_Emo.findById(iD_Emocion).isPresent()){

            SesionTerapia sesiTera = repo_Sesio_Tera.findById(Id_Sesion).get();
            Emocion emo = repo_Emo.findById(iD_Emocion).get();

            sesEmo.setIdSesionRel(sesiTera);
            sesEmo.setIdEmocionRel(emo);

            repo_Ses_Emo.save(sesEmo);

            return "Emociones registradas a Sesion de Terapia.";
        }else {
            return "Emociones ya regstradas";
        }
    }


    public String actualizarSesionEmociones(SesionEmo sesion_emo){

        if (repo_Ses_Emo.findById(sesion_emo.getIdSeEmo()).isPresent()){
            repo_Ses_Emo.save(sesion_emo);
            return "Emociones actualizadas en Sesion de Terapia con exito.";
        }else {
            return "Sesion no encontrada.";
        }

    }

    public String eliminarSesionEmociones(Integer id){
        if (repo_Ses_Emo.findById(id).isPresent()){
            repo_Ses_Emo.deleteById(id);
            return "Sesion y emociones eliminadas con exito";
        }else {
            return "Sesion y emociones no existente";
        }
    }
}
