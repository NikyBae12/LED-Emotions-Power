package com.example.proyecto_jpa.Servicio;
import com.example.proyecto_jpa.Entidad.conexiones;
import com.example.proyecto_jpa.Repositorio.Repositorio;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class Servicio {
    private Repositorio repositorioCone;


    public Servicio(Repositorio repositorioCone){

        this.repositorioCone = repositorioCone;
    }

    public ArrayList<conexiones> listarConexiones(){

        return (ArrayList<conexiones>) repositorioCone.findAll();
    }

    public conexiones buscarConexion(String id){
        return repositorioCone.findById(id).get();
    }

    public String agregarConexion(conexiones Conexion){
        if (repositorioCone.findById(Conexion.getId_conexion()).isPresent()){
            return "La conexion ya se encuentra registrado";

        }else {
            repositorioCone.save(Conexion);
            return "Conexion registrada con exito";
        }
    }

    public String actualizarConexion(conexiones Conexion){
        if (repositorioCone.findById(Conexion.getId_conexion()).isPresent()){
            repositorioCone.save(Conexion);
            return "Conexion actualizada con exito";
        }else {
            return "Esta conexion no se encuentra registrada";
        }
    }


    public String eliminarConexion(String id){
        if (repositorioCone.findById(id).isPresent()){
            repositorioCone.deleteById(id);
            return "Conexion eliminada con exito";
        }else {
            return "Conexión ya eliminada o no existente";
        }
    }
}
