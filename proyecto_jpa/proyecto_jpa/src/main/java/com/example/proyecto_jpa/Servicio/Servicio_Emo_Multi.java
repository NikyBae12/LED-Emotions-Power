package com.example.proyecto_jpa.Servicio;
import com.example.proyecto_jpa.Entidad.Emo_multi;
import com.example.proyecto_jpa.Repositorio.Repositorio_Multi;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class Servicio_Emo_Multi {


    private Repositorio_Multi repositorio_multi;

    public Servicio_Emo_Multi(Repositorio_Multi repositorio_multi) {
        this.repositorio_multi = repositorio_multi;
    }

    public ArrayList<Emo_multi> listarMultimedia(){
        return (ArrayList<Emo_multi>) repositorio_multi.findAll();
    }


    public Emo_multi buscarMultimedia(String id){
        return repositorio_multi.findById(id).get();
    }

    public String agregarMultimedia(Emo_multi emo_multi){
        if (repositorio_multi.findById(String.valueOf(emo_multi.getIde_emocion())).isPresent()){
            return "El elemento multimedia ya se encuentra registrado";
        }else {
            repositorio_multi.save(emo_multi);
            return "Elemento multimedia registrado con exito";
        }
    }

    public String actualizarMultimedia(Emo_multi emo_multi){
        if (repositorio_multi.findById(String.valueOf(emo_multi.getIde_emocion())).isPresent()){
            repositorio_multi.save(emo_multi);
            return "Elemento multimedia actuazliado con exito";
        }else {
            return  "Este elemento ya no se encuentra registrado";
        }
    }

    public String elimianrMultimedia(String id){
        if (repositorio_multi.findById(id).isPresent()){
            repositorio_multi.deleteById(id);
            return "Elemento multimedia eliminado con exito";
        }else {
            return "Elemento multimedia ya eliminado o no existente";
        }
    }
}
