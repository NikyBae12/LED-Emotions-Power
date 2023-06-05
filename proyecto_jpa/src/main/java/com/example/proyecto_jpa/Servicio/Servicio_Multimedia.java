package com.example.proyecto_jpa.Servicio;

import com.example.proyecto_jpa.Entidad.Multimedia;
import com.example.proyecto_jpa.Repositorio.Repositorio_Multimedia;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class Servicio_Multimedia {

    private Repositorio_Multimedia repositorio_multimedia;

    public Servicio_Multimedia(Repositorio_Multimedia repositorio_multimedia) {
        this.repositorio_multimedia = repositorio_multimedia;
    }

    public ArrayList<Multimedia> listarElemento(){
        return (ArrayList<Multimedia>) repositorio_multimedia.findAll();
    }

    public Multimedia encontrarElemento(String id){
        return repositorio_multimedia.findById(id).get();
    }

    public String agregarElemento(Multimedia multimedia){

        if (repositorio_multimedia.findById(String.valueOf(multimedia.getID_Elemento())).isPresent()){
            return "Elemento ya registrado";
        }else {
            repositorio_multimedia.save(multimedia);
            return "Elemento registrado con exito";
        }
    }


    public String actualizarElemento(Multimedia multimedia){
        if (repositorio_multimedia.findById(String.valueOf(multimedia.getID_Elemento())).isPresent()){
            repositorio_multimedia.save(multimedia);
            return "Elemento actuazizado";
        }else {
            return "Este elemento no se encuentra registrado";
        }
    }

    public String eliminarElemento(String id){
        if (repositorio_multimedia.findById(id).isPresent()){
            repositorio_multimedia.deleteById(id);
            return "Elemento eliminado con exito";
        }else {
            return "Elemento ya borrado o inexistente";
        }
    }
}
