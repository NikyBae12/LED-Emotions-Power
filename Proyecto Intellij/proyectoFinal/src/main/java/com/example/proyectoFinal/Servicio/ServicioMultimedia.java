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

    public ArrayList<Multimedia> listarElementosM(){
        return (ArrayList<Multimedia>) repositorioMultimedia.findAll();
    }

    public Multimedia buscarElementoM(Integer id){
        return repositorioMultimedia.findById(id).get();
    }

    public String agregarElementoM(Multimedia multimedia){

        if (repositorioMultimedia.findById(multimedia.getIdElemento()).isPresent()){
            return "Elemento Multimedia ya registrado.";
        }else {
            repositorioMultimedia.save(multimedia);
            return "Elemento Multimedia registrado con exito.";
        }
    }


    public String actualizarElementoM(Multimedia multimedia){
        if (repositorioMultimedia.findById(multimedia.getIdElemento()).isPresent()){
            repositorioMultimedia.save(multimedia);
            return "Elemento Multimedia actualizado con exito.";
        }else {
            return "Este elemento multimedia no se encuentra registrado.";
        }
    }

    public String eliminarElementoM(Integer id){
        if (repositorioMultimedia.findById(id).isPresent()){
            repositorioMultimedia.deleteById(id);
            return "Elemento Multimedia eliminado con exito.";
        }else {
            return "Elemento ya eliminado o inexistente.";
        }
    }
}
