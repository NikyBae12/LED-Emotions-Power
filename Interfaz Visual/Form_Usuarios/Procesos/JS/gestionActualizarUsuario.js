$(document).ready(function(){

    // METODO ACTUALIZAR
    $('#actualizarUsu').on('click', function(){
    
            let Usuarios = {
                idUsuario: $('#id').val(),
                nombres: $('#nombres').val(),
                email: $('#correo').val(),
                contraseña : $('#contraseña').val(),
                fechaN: $('#fechaNa').val(),
                imgPerfil: $('#imgPerfil').val(),
                estadoCuenta: $('#EstadoCuenta').val(),
            }

            let actuUsuario = JSON.stringify(Usuarios);
            console.log(Usuarios);
            console.log(actuUsuario);
            $.ajax({
                url: "http://127.0.0.1:8080/actualizarUsuario",
                type: "PUT",
                data: actuUsuario,
                contentType: "application/JSON",
                datatype: "JSON",

                success: function(response){
                    alert(response);
                }
            })
    })
})