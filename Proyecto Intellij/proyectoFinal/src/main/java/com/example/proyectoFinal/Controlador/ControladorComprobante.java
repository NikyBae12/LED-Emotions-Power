package com.example.proyectoFinal.Controlador;


import com.example.proyectoFinal.Entidad.Comprobante;
import com.example.proyectoFinal.Servicio.ServicioComprobante;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
public class ControladorComprobante {

    private ServicioComprobante servi_compro;

    public ControladorComprobante(ServicioComprobante servi_compro) {
        this.servi_compro = servi_compro;
    }


    @GetMapping("/listarComprobantes")
    public ArrayList<Comprobante> listarComprobante(){
        return servi_compro.listarComprobantes();
    }


    @GetMapping("/buscarComprobante/{Id_comprob}")
    public Comprobante buscarComprobante(@PathVariable("Id_comprob") Integer Id_comprob){
        return servi_compro.buscarComprobante(Id_comprob);
    }


    @PostMapping("/agregarComprobante")
    public String agregarComprobante(@RequestBody Comprobante comprobante){
        return servi_compro.agregarComprobante(comprobante);
    }


    @PutMapping("/actualizarComprobante")
    public String actualizarComprobante(@RequestBody Comprobante comprobante){
        return servi_compro.actualizarComprobante(comprobante);
    }


    @DeleteMapping("/eliminarComprobante/{Id_comprob}")
    public String eliminarComprobante(@PathVariable("Id_comprob") Integer Id_comprob){
        return servi_compro.eliminarComprobante(Id_comprob);
    }
}
