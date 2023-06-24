package com.example.proyectoFinal.Servicio;

import com.example.proyectoFinal.Entidad.SesionTerapia;
import com.example.proyectoFinal.Repositorio.RepositorioSesionTerapia;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class ServicioSesionTerapia {
    private RepositorioSesionTerapia respo_Sesion_ter;

    public ServicioSesionTerapia(RepositorioSesionTerapia respo_Sesion_ter) {
        this.respo_Sesion_ter = respo_Sesion_ter;
    }

    public ArrayList<SesionTerapia> listarSesionesTerapia(){
        return (ArrayList<SesionTerapia>) respo_Sesion_ter.findAll();
    }


    public SesionTerapia buscarSesionTerapia(Integer ID_sesion){
        return respo_Sesion_ter.findById(ID_sesion).get();
    }


    public String agregarSesionTerapia(SesionTerapia sesionTerapia){
        if (respo_Sesion_ter.findById(sesionTerapia.getIdSesion()).isPresent()){
            return "La Sesión de terapia ya se encuentra registrada.";
        }else {
            respo_Sesion_ter.save(sesionTerapia);
            return "Sesion de terapia registrada exitosamente.";
        }
    }


    public String actuzalizarSesionTerapia(SesionTerapia sesionTerapia){
        if (respo_Sesion_ter.findById(sesionTerapia.getIdSesion()).isPresent()){
            respo_Sesion_ter.save(sesionTerapia);
            return "Sesion de terapia actualizada con exito.";
        }else {
            return "Esta Sesion de terapia no se encuentra registrada.";
        }
    }

    public String eliminarSesionTerapia(Integer ID_sesion){
        if (respo_Sesion_ter.findById(ID_sesion).isPresent()){
            respo_Sesion_ter.deleteById(ID_sesion);
            return "Sesion de terapia elimanada correctamente.";
        }else {
            return "Sesion de terapia no existente.";
        }
    }
}
