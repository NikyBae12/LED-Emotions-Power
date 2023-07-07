package com.example.proyectoFinal.Controlador;


import com.example.proyectoFinal.Entidad.Comprobante;
import com.example.proyectoFinal.Servicio.ServicioComprobante;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@CrossOrigin (origins = "*", maxAge = 3600)
@RestController
public class ControladorComprobante {

    private ServicioComprobante servi_compro;

    public ControladorComprobante(ServicioComprobante servi_compro) {
        this.servi_compro = servi_compro;
    }


    @GetMapping("/listarComprobantes")
    public ResponseEntity<List<Map<String, Object>>> listarComprobante(){
        List<Object[]> lista = servi_compro.listarComprobantes();

        List<Map<String, Object>> registrosMap = new ArrayList<>();

        for(Object[] objects: lista){

            Map<String, Object> registroMap = new LinkedHashMap<>();

            registroMap.put("idComprobante", objects[0]);
            registroMap.put("idUsuario", objects[1]);
            registroMap.put("nombres", objects[2]);
            registroMap.put("estadoCuenta", objects[3]);
            registroMap.put("fechaActu", objects[4]);
            registroMap.put("valor", objects[5]);
            registroMap.put("factura", objects[6]);

            registrosMap.add(registroMap);

        }

        return ResponseEntity.ok(registrosMap);
    }


    @GetMapping("/buscarComprobante/{Id_comprob}")
    public Comprobante buscarComprobante(@PathVariable("Id_comprob") Integer Id_comprob){
        return servi_compro.buscarComprobante(Id_comprob);
    }


    @PostMapping("/agregarComprobante/{idUsuario}")
    public String agregarComprobante(@RequestBody Comprobante comprobante, @PathVariable("idUsuario") String idUsuario){
        return servi_compro.agregarComprobante(comprobante, idUsuario);
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
