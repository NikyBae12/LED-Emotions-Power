$(document).ready(function(){
    // METODO AGREGAR
    $('#agregar').on('click', function(){
        
        let datos = {
            idUsuario: $('#IdUsuario').val(),
            nombres : $ ('#Nombres').val(),
            email : $ ('#Email').val(),
            contraseña : $ ('#Contraseña').val(),
            fechaN : $ ('#FechaN').val(),
            codVerif: $('CodVerif').val(),
            imgPerfil : $ ('#imgPerfil').val(), 
            estadoCuenta : $ ('#EstadoCuenta').val(),   
        }

        let datosEnvio = JSON.stringify(datos);
        $.ajax({
            url: "http://127.0.0.1:8080/agregarUsuario",
            type :"POST",
            data: datosEnvio,
            contentType: "application/JSON",
            datatype: JSON,
            success: function(respuesta) {
                alert(respuesta);
            }
        })
    });
})