$(document). ready(function(){

    $('#listarConexion').on('click', function(){
        let tabla = document.querySelector('#ConexionTabla')
        tabla.innerHTML= ''
        $.ajax({
            url: "http://localhost:8080/mostrarDatos",
            type: 'GET',
            dattype: "JSON",
            success: function(respuesta){
                for (i = 0; i <= ConexionList.length; i++){
                    tabla.innerHTML += '<tr><td>' + ConexionList [i].idConexion +
                    '<tr><td>' + ConexionList [i].idLed +
                    '<tr><td>' + ConexionList [i].estado +
                    '<tr><td>';
                }
            }
        })
    });


    $('#agregarConexion').on('click', function(){
        let datos = {
            idConexion: parseInt($('#idconexion').val()),
            idLed: $('#idled').val(),
            estado: $('#estado').val(),
            
        }

        let datosEnvio = JSON.stringify(datos);

        $.ajax({
            url: 'http://localhost:8080/agregarConexion',
            type: 'POST',
            data: datosEnvio,
            contentType: "application/JSON",
            datatype: JSON,
            success: function(respuesta){
                alert(respuesta);
            }
        })
    });



});


