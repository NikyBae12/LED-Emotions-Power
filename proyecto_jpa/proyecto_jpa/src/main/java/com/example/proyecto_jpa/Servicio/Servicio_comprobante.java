package com.example.proyecto_jpa.Servicio;


import com.example.proyecto_jpa.Entidad.Comprobante;
import com.example.proyecto_jpa.Repositorio.Repositorio_comprobante;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class Servicio_comprobante {


    private Repositorio_comprobante respo_comp;

    public Servicio_comprobante(Repositorio_comprobante respo_comp) {
        this.respo_comp = respo_comp;
    }

    public ArrayList<Comprobante> listarComprobantes(){

        return (ArrayList<Comprobante>) respo_comp.findAll();
    }


    public Comprobante buscarComprobante(String Id_comprob){

        return respo_comp.findById(Id_comprob).get();
    }


    public String agregarComprobante(Comprobante comprobante){
        if (respo_comp.findById(String.valueOf(comprobante.getId_comprob())).isPresent()){
            return "El comprobante ya se encuentra registrada";
        }else {
            respo_comp.save(comprobante);
            return "Coprobante registrado exitosamente";
        }
    }


    public String actuzalizarComprobante(Comprobante comprobante){
        if (respo_comp.findById(String.valueOf(comprobante.getId_comprob())).isPresent()){
            respo_comp.save(comprobante);
            return "Comprobante actualizado con exito";
        }else {
            return "Este coprobante no se encuentra registrado";
        }
    }

    public String eliminarConexion(String Id_comprob){
        if (respo_comp.findById(String.valueOf(Id_comprob)).isPresent()){
            respo_comp.deleteById(Id_comprob);
            return "Comprobante elimando correctamente";
        }else {
            return "Comprobante ya eliminado";
        }
    }
}
