package com.example.proyecto_jpa.Servicio;


import com.example.proyecto_jpa.Entidad.Comprobante;
import com.example.proyecto_jpa.Entidad.Emociones;
import com.example.proyecto_jpa.Repositorio.Repositorio_Emociones;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class Servicio_Emociones {

    private Repositorio_Emociones repositorio_emociones;

    public Servicio_Emociones(Repositorio_Emociones repositorio_emociones) {
        this.repositorio_emociones = repositorio_emociones;
    }

    public ArrayList<Emociones> listarEmociones(){

        return (ArrayList<Emociones>) repositorio_emociones.findAll();
    }


    public Emociones buscarEmociones(String Id_emocion){

        return repositorio_emociones.findById(Id_emocion).get();
    }


    public String agregarEmociones(Emociones emociones){
        if (repositorio_emociones.findById(String.valueOf(emociones.getId_emocion())).isPresent()){
            return "El Emociones ya se encuentra registrada";
        }else {
            repositorio_emociones.save(emociones);
            return "Coprobante registrado exitosamente";
        }
    }


    public String actuzalizarEmociones(Emociones emociones){
        if (repositorio_emociones.findById(String.valueOf(emociones.getId_emocion())).isPresent()){
            repositorio_emociones.save(emociones);
            return "Emocion actualizada con exito";
        }else {
            return "Esta emoción no se encuentra registrada";
        }
    }

    public String eliminarEmocion(String Id_emocion){
        if (repositorio_emociones.findById(String.valueOf(Id_emocion)).isPresent()){
            repositorio_emociones.deleteById(Id_emocion);
            return "Emocion elimanda correctamente";
        }else {
            return "Emocion ya eliminada";
        }
    }
}