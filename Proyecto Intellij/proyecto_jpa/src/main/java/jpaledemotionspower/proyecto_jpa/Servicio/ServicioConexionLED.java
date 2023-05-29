package jpaledemotionspower.proyecto_jpa.Servicio;

import jpaledemotionspower.proyecto_jpa.Entidad.ConexionLED;
import jpaledemotionspower.proyecto_jpa.Repositorio.RepositorioConexionLED;

import java.util.ArrayList;

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



    public String actualizarConexion(ConexionLED Conexion){
        if (repoConexionLED.findById(Conexion.getIdConexion()).isPresent()){
            repoConexionLED.save(Conexion);
            return "Conexion actualizada con exito";
        }else {
            return "Esta conexion no se encuentra registrada";
        }
    }

    public String desactivarConexion(ConexionLED conexionLED){
        if (repoConexionLED.findById(conexionLED.getIdConexion()).isPresent() && conexionLED.getCEstado()){
            if (conexionLED.getCEstado()){

                conexionLED.setCEstado(false);
                return "Conexion desactivada con exito";

            } else {

                return "La Conexión ya esta desactivada.";

            }
        }else {
            return "Conexión no encontrada.";
        }
    }

    public String activarConexion(ConexionLED conexionLED){
        if (repoConexionLED.findById(conexionLED.getIdConexion()).isPresent() && conexionLED.getCEstado() == false){

            if (conexionLED.getCEstado()){

                conexionLED.setCEstado(true);
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
            return "Conexión ya eliminada o no existente";
        }
    }
}
