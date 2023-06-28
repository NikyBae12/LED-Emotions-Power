let selectUsers = document.querySelector('#id');

$(document).ready(function(){
    consultarUsers();
    selectUsers.addEventListener('change', listarUsuarioForm);

    // METODO ACTUALIZAR
    $('#actualizarUsu').on('click', function(){
    
            let Usuarios = {
                idUsuario: $('#idUser').val(),
                nombres: $('#nombres').val(),
                email: $('#correo').val(),
                contraseña : $('#contraseña').val(),
                fechaN: $('#fechaNa').val(),
                imgPerfil: $('#imgPerfil').val(),
                codVerif: $('#codigoVeri').val(),
                estadoCuenta: $('#EstadoCuenta').val(),
            }

            let actuUsuario = JSON.stringify(Usuarios);

            $.ajax({
                url: "http://127.0.0.1:8080/actualizarUsuario",
                type: "PUT",
                data: actuUsuario,
                contentType: "application/JSON",
                datatype: "JSON",

                success: function(response){
                    alert(response);
                    location.reload();
                }
            })
    })
})


function consultarUsers(){
    selectUsers.innerHTML = "<option value=''>Selecciona un Usuario</option>"

    $.ajax({
        url : "http://localhost:8080/listarUsuarios",
        type : "GET",
        async: false,
        datatype : "JSON",
        success : function (respuesta){

            for (let i = 0; i < respuesta.length; i++) {
                selectUsers.innerHTML += "<option value='" + respuesta[i].idUsuario +"'>" + respuesta[i].idUsuario + " - " + respuesta[i].nombres + "</option>";
                                        
            }

        }
    }); 

}



function listarUsuarioForm(){

    let userSeleccionado = selectUsers.value;

    if (userSeleccionado != ''){
        $.ajax({
            url: "http://localhost:8080/buscarUsuario/" + userSeleccionado,
            type: "GET",
            datatype: "JSON",
            async: false,
            success: function(respuesta){

                document.querySelector('#idUser').setAttribute('value', respuesta.idUsuario);
                document.querySelector('#nombres').setAttribute('value', respuesta.nombres);
                document.querySelector('#correo').setAttribute('value', respuesta.email);
                document.querySelector('#contraseña').setAttribute('value', respuesta.contraseña);
                document.querySelector('#fechaNa').setAttribute('value', respuesta.fechaN);
                document.querySelector('#codigoVeri').setAttribute('value', respuesta.codVerif);
                document.querySelector('#imgPerfil').setAttribute('value', respuesta.imgPerfil);
                document.querySelector('#EstadoCuenta').value = respuesta.estadoCuenta;
    
            }
    
        })

    } else {
        document.querySelector('#idUser').setAttribute('value', '');
        document.querySelector('#nombres').setAttribute('value', '');
        document.querySelector('#correo').setAttribute('value', '');
        document.querySelector('#contraseña').setAttribute('value', '');
        document.querySelector('#fechaNa').setAttribute('value', '');
        document.querySelector('#codigoVeri').setAttribute('value', '');
        document.querySelector('#imgPerfil').setAttribute('value', '');
        document.querySelector('#EstadoCuenta').value = '¿CUAL ES EL ESTADO DE LA CUENTA?';

    }

}