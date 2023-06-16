package com.example.proyectoFinal.Servicio;

import com.example.proyectoFinal.Entidad.EmoMulti;
import com.example.proyectoFinal.Entidad.Emocion;
import com.example.proyectoFinal.Entidad.Multimedia;
import com.example.proyectoFinal.Repositorio.RepositorioEmoMulti;
import com.example.proyectoFinal.Repositorio.RepositorioEmocion;
import com.example.proyectoFinal.Repositorio.RepositorioMultimedia;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class ServicioEmoMulti {

    private RepositorioEmoMulti repositorio_multi;
    private RepositorioEmocion repositorio_emociones;
    private RepositorioMultimedia repositorio_multimedia;

    public ServicioEmoMulti(RepositorioEmoMulti repositorio_multi, RepositorioEmocion repositorio_emociones, RepositorioMultimedia repositorio_multimedia) {
        this.repositorio_multi = repositorio_multi;
        this.repositorio_emociones = repositorio_emociones;
        this.repositorio_multimedia = repositorio_multimedia;
    }

    public ArrayList<EmoMulti> ListarEmoMulti(){
        return (ArrayList<EmoMulti>) repositorio_multi.findAll();
    }


    public EmoMulti buscarMultimedia(Integer id){
        return repositorio_multi.findById(id).get();
    }

    public String agregarMultimedia(Integer id_emo, Integer id_elem){

        EmoMulti emo_multi = new EmoMulti();

        if (repositorio_emociones.findById(id_emo).isPresent() && repositorio_multimedia.findById(id_elem).isPresent()){

            Emocion emocion = repositorio_emociones.findById(id_emo).get();
            Multimedia multimedia = repositorio_multimedia.findById(id_elem).get();

            emo_multi.setId_emocion_rel(emocion);
            emo_multi.setMultimedia_rel(multimedia);

            return "El elemento multimedia ya se encuentra registrado";
        }else {
            repositorio_multi.save(emo_multi);
            return "Elemento multimedia registrado con exito";
        }
    }

    public String actualizarMultimedia(EmoMulti emo_multi){
        if (repositorio_multi.findById(emo_multi.getIdEmoMulti()).isPresent()){
            repositorio_multi.save(emo_multi);
            return "Elemento multimedia actuazliado con exito";
        }else {
            return  "Este elemento ya no se encuentra registrado";
        }
    }

    public String elimianrMultimedia(Integer id){
        if (repositorio_multi.findById(id).isPresent()){
            repositorio_multi.deleteById(id);
            return "Elemento multimedia eliminado con exito";
        }else {
            return "Elemento multimedia ya eliminado o no existente";
        }
    }
}
