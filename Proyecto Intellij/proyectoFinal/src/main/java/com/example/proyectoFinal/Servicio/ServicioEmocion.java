package com.example.proyectoFinal.Servicio;

import com.example.proyectoFinal.Entidad.Emocion;
import com.example.proyectoFinal.Repositorio.RepositorioEmocion;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class ServicioEmocion {

    private RepositorioEmocion repositorioEmocion;

    public ServicioEmocion(RepositorioEmocion RepositorioEmocion) {
        this.repositorioEmocion = RepositorioEmocion;
    }

    public ArrayList<Emocion> listarEmociones(){

        return (ArrayList<Emocion>) repositorioEmocion.findAll();
    }


    public Emocion buscarEmocion(Integer Id_emocion){

        return repositorioEmocion.findById(Id_emocion).get();
    }


    public String agregarEmocion(Emocion Emocion){
        if (repositorioEmocion.findById(Emocion.getIdEmocion()).isPresent()){
            return "La Emocion ya se encuentra registrada.";
        }else {
            repositorioEmocion.save(Emocion);
            return "Emocion registrada exitosamente.";
        }
    }


    public String actualizarEmocion(Emocion Emocion){
        if (repositorioEmocion.findById(Emocion.getIdEmocion()).isPresent()){
            repositorioEmocion.save(Emocion);
            return "Emocion actualizada con exito.";
        }else {
            return "Esta emoción no se encuentra registrada.";
        }
    }

    public String eliminarEmocion(Integer Id_emocion){
        if (repositorioEmocion.findById(Id_emocion).isPresent()){
            repositorioEmocion.deleteById(Id_emocion);
            return "Emocion eliminada correctamente.";
        }else {
            return "Emocion ya eliminada o no existente.";
        }
    }
}
