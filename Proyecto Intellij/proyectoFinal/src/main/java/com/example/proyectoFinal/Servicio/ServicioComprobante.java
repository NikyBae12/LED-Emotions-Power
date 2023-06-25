package com.example.proyectoFinal.Servicio;


import com.example.proyectoFinal.Entidad.Comprobante;
import com.example.proyectoFinal.Repositorio.RepositorioComprobante;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class ServicioComprobante {
    private RepositorioComprobante respo_comp;

    public ServicioComprobante(RepositorioComprobante respo_comp) {
        this.respo_comp = respo_comp;
    }

    public ArrayList<Comprobante> listarComprobantes(){

        return (ArrayList<Comprobante>) respo_comp.findAll();
    }


    public Comprobante buscarComprobante(Integer Id_comprob){

        return respo_comp.findById(Id_comprob).get();
    }


    public String agregarComprobante(Comprobante comprobante){
        if (respo_comp.findById(comprobante.getIdComprobante()).isPresent()){
            return "El comprobante ya se encuentra registrado.";
        }else {
            respo_comp.save(comprobante);
            return "Coprobante registrado exitosamente.";
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
