document.querySelector('#agregarConexion').addEventListener('click', agregarConexion);

function agregarConexion(){
    var SIdConexicion = document.querySelector('#idconexion').value,
        SIdLed = document.querySelector('#idled').value,
        SEstado = document.querySelector('#estado').value;

    addConexionToSystem(SIdConexicion,SIdLed, SEstado);



}