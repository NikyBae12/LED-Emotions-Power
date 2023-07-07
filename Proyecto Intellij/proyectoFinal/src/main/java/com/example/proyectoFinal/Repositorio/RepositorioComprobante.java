package com.example.proyectoFinal.Repositorio;

import com.example.proyectoFinal.Entidad.Comprobante;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RepositorioComprobante extends JpaRepository<Comprobante, Integer> {

    @Query(value = "select * from comprobante as c inner join usuario as u on c.id_usuario = u.id_usuario where c.id_usuario = :id_usuario", nativeQuery = true)
    List<Object[]> FindComprobantesxUsuario(@Param("id_usuario") String idUsuario);

    @Query(value = "select c.id_comprobante, c.id_usuario, u.nombres, u.estado_cuenta, c.fecha_actu, c.valor, c.factura from comprobante as c inner join usuario as u on c.id_usuario = u.id_usuario", nativeQuery = true)
    List<Object[]> FindComprobantes();

}
