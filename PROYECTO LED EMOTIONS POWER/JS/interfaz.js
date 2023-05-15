var ConexionList = []

function addConexionToSystem(SIdConexicion,SIdLed, SEstado){
    var ConexionNueva = {
        idConexion : SIdConexicion,
        idLed : SIdLed,
        estado : SEstado
    };

    console.log(ConexionNueva)
    ConexionList.push(ConexionNueva)

}
