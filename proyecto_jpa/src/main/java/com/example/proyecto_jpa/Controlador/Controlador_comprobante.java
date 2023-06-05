package com.example.proyecto_jpa.Controlador;


import com.example.proyecto_jpa.Entidad.Comprobante;
import com.example.proyecto_jpa.Servicio.Servicio_comprobante;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
public class Controlador_comprobante {

    private Servicio_comprobante servi_compro;

    public Controlador_comprobante(Servicio_comprobante servi_compro) {
        this.servi_compro = servi_compro;
    }


    @GetMapping("/listarComprobantes")
    public ArrayList<Comprobante> listarCompro(){
        return servi_compro.listarComprobantes();
    }


    @GetMapping("/buscarComprobante/{Id_comprob}")
    public Comprobante buscarComprobante(@PathVariable("Id_comprob") String Id_comprob){
        return servi_compro.buscarComprobante(Id_comprob);
    }


    @PostMapping("/agregarComprobante")
    public String agregarComprobante(@RequestBody Comprobante comprobante){
        return servi_compro.agregarComprobante(comprobante);
    }


    @PutMapping("/actualizarComprobante")
    public String actualizarComprobante(@RequestBody Comprobante comprobante){
        return servi_compro.actuzalizarComprobante(comprobante);
    }


    @DeleteMapping("/eliminarComprobante/{Id_comprob}")
    public String eliminarComprobante(@PathVariable("Id_comprob") String Id_comprob){
        return servi_compro.eliminarConexion(Id_comprob);
    }
}
