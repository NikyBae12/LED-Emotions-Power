package com.example.proyectoFinal.Servicio;

import com.example.proyectoFinal.Entidad.ConexionLED;
import com.example.proyectoFinal.Repositorio.RepositorioConexionLED;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class ServicioConexionLED {

    private RepositorioConexionLED repoConexionLED;

    public ServicioConexionLED(RepositorioConexionLED repoConexionLED) {
        this.repoConexionLED = repoConexionLED;
    }

    public ArrayList<ConexionLED> listarConexiones(){

        return (ArrayList<ConexionLED>) repoConexionLED.findAll();
    }

    public ConexionLED buscarConexion(Integer id){
        return repoConexionLED.findById(id).get();
    }


    public String agregarConexion(ConexionLED Conexion){
        if (repoConexionLED.findById(Conexion.getIdConexion()).isPresent()){
            return "La conexion ya se encuentra registrada.";

        }else {
            repoConexionLED.save(Conexion);
            return "Conexion registrada con exito.";
        }
    }

    public String actualizarConexion(ConexionLED Conexion){
        if (repoConexionLED.findById(Conexion.getIdConexion()).isPresent()){
            repoConexionLED.save(Conexion);
            return "Conexion actualizada con exito.";
        }else {
            return "Esta conexion no se encuentra registrada.";
        }
    }

    public String desactivarConexion(ConexionLED conexionLED){
        if (repoConexionLED.findById(conexionLED.getIdConexion()).isPresent() && conexionLED.getcEstado()){
            if (conexionLED.getcEstado()){

                conexionLED.setcEstado(false);
                return "Conexion desactivada con exito.";

            } else {

                return "La Conexión ya esta desactivada.";

            }
        }else {
            return "Conexión no encontrada.";
        }
    }

    public String activarConexion(ConexionLED conexionLED){
        if (repoConexionLED.findById(conexionLED.getIdConexion()).isPresent() && conexionLED.getcEstado() == false){

            if (conexionLED.getcEstado()){

                conexionLED.setcEstado(true);
                return "Conexion activada con exito.";

            } else {

                return "La Conexión ya esta activada.";

            }

        }else {
            return "Conexión no encontrada.";
        }
    }

    public String eliminarConexion(Integer id){
        if (repoConexionLED.findById(id).isPresent()){
            repoConexionLED.deleteById(id);
            return "Conexion eliminada con exito";
        }else {
            return "Conexión ya eliminada o no existente.";
        }
    }
}
