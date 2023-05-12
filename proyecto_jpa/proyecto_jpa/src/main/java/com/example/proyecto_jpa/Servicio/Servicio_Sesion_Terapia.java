package com.example.proyecto_jpa.Servicio;


import com.example.proyecto_jpa.Entidad.Comprobante;
import com.example.proyecto_jpa.Entidad.SesionTerapia;
import com.example.proyecto_jpa.Repositorio.Repositorio_Sesion_terapia;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class Servicio_Sesion_Terapia {

    private Repositorio_Sesion_terapia respo_Sesion_ter;

    public Servicio_Sesion_Terapia(Repositorio_Sesion_terapia respo_Sesion_ter) {
        this.respo_Sesion_ter = respo_Sesion_ter;
    }

    public ArrayList<SesionTerapia> listarSesionesTerapia(){
        return (ArrayList<SesionTerapia>) respo_Sesion_ter.findAll();
    }


    public SesionTerapia buscarComprobante(String ID_sesion){
        return respo_Sesion_ter.findById(ID_sesion).get();
    }


    public String agregarSesionTerapia(SesionTerapia sesionTerapia){
        if (respo_Sesion_ter.findById(String.valueOf(sesionTerapia.getID_sesion())).isPresent()){
            return "La sesio nde teraía ya se encuentra registrada";
        }else {
            respo_Sesion_ter.save(sesionTerapia);
            return "Sesion de terapia registrada exitosamente";
        }
    }


    public String actuzalizarComprobante(SesionTerapia sesionTerapia){
        if (respo_Sesion_ter.findById(String.valueOf(sesionTerapia.getID_sesion())).isPresent()){
            respo_Sesion_ter.save(sesionTerapia);
            return "Sesion terapia actualizada con exito";
        }else {
            return "Esta Sesion terapia no se encuentra registrada";
        }
    }

    public String eliminarSesionTerapia(String ID_sesion){
        if (respo_Sesion_ter.findById(String.valueOf(ID_sesion)).isPresent()){
            respo_Sesion_ter.deleteById(ID_sesion);
            return "Sesion de terapia elimanada correctamente";
        }else {
            return "Sesion de terapia ya eliminada";
        }
    }
}
