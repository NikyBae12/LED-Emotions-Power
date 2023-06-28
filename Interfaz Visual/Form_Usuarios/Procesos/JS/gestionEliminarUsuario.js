let selectUsers = document.querySelector('#id');

$(document).ready(function(){
    consultarUsers();
    selectUsers.addEventListener('change', listarUsuarioForm);

    // METODO ELIMINAR
    $('#eliminarUsu').on('click', function(){
        let eliminarUsuario = $('#idUser').val();

        // Mostrar alerta de confirmación
        if (confirm("¿Estás seguro de eliminar este registro?")) {
            $.ajax({
                url: "http://127.0.0.1:8080/eliminarUsuario/" + eliminarUsuario,
                type: "DELETE",
                datatype: "JSON",
                success: function (respuesta) {
                    alert(respuesta);
                }
            });
        } else {
            alert('No se elimino el usuario.')

        }
    });
});



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
            }
    
        })

    } else {
        document.querySelector('#idUser').setAttribute('value', '');
    }

}
