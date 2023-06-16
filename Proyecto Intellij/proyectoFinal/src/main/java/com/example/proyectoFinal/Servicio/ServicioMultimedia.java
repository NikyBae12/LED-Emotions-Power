package com.example.proyectoFinal.Servicio;

import com.example.proyectoFinal.Entidad.Multimedia;
import com.example.proyectoFinal.Repositorio.RepositorioMultimedia;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class ServicioMultimedia {
    private RepositorioMultimedia repositorioMultimedia;

    public ServicioMultimedia(RepositorioMultimedia repositorioMultimedia) {
        this.repositorioMultimedia = repositorioMultimedia;
    }

    public ArrayList<Multimedia> listarElemento(){
        return (ArrayList<Multimedia>) repositorioMultimedia.findAll();
    }

    public Multimedia encontrarElemento(Integer id){
        return repositorioMultimedia.findById(id).get();
    }

    public String agregarElemento(Multimedia multimedia){

        if (repositorioMultimedia.findById(multimedia.getIDElemento()).isPresent()){
            return "Elemento ya registrado";
        }else {
            repositorioMultimedia.save(multimedia);
            return "Elemento registrado con exito";
        }
    }


    public String actualizarElemento(Multimedia multimedia){
        if (repositorioMultimedia.findById(multimedia.getIDElemento()).isPresent()){
            repositorioMultimedia.save(multimedia);
            return "Elemento actuazizado";
        }else {
            return "Este elemento no se encuentra registrado";
        }
    }

    public String eliminarElemento(Integer id){
        if (repositorioMultimedia.findById(id).isPresent()){
            repositorioMultimedia.deleteById(id);
            return "Elemento eliminado con exito";
        }else {
            return "Elemento ya borrado o inexistente";
        }
    }
}
