package com.example.proyectoFinal.Servicio;


import com.example.proyectoFinal.Entidad.Comprobante;
import com.example.proyectoFinal.Entidad.Usuario;
import com.example.proyectoFinal.Repositorio.RepositorioComprobante;
import com.example.proyectoFinal.Repositorio.RepositorioUsuario;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ServicioComprobante {
    private RepositorioComprobante respo_comp;
    private RepositorioUsuario repoUsuario;

    public ServicioComprobante(RepositorioComprobante respo_comp, RepositorioUsuario repoUsuario) {
        this.respo_comp = respo_comp;
        this.repoUsuario = repoUsuario;
    }

    public List<Object[]> listarComprobantes(){

        return respo_comp.FindComprobantes();
    }


    public Comprobante buscarComprobante(Integer Id_comprob){

        return respo_comp.findById(Id_comprob).get();
    }


    public String agregarComprobante(Comprobante comprobante, String idUsuario){

        if (repoUsuario.findById(idUsuario).isPresent()){

            Usuario user = repoUsuario.findByIdUsuario(idUsuario);
            comprobante.setUsuario(user);

            respo_comp.save(comprobante);

            return "Comprobante registrado con éxito.";

        } else {
            return "El Comprobante no se registro.";

        }

    }


    public String actualizarComprobante(Comprobante comprobante){
        if (respo_comp.findById(comprobante.getIdComprobante()).isPresent()){
            respo_comp.save(comprobante);
            return "Comprobante actualizado con exito.";
        }else {
            return "Este comprobante no se encuentra registrado.";
        }
    }

    public String eliminarComprobante(Integer Id_comprob){
        if (respo_comp.findById(Id_comprob).isPresent()){
            respo_comp.deleteById(Id_comprob);
            return "Comprobante elimando correctamente.";
        }else {
            return "Comprobante ya eliminado o no existente.";
        }
    }
}
