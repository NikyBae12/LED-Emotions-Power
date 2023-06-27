$(document).ready(function(){
    // METODO ELIMINAR
    $('#eliminarUsu').on('click', function(){
        let eliminarUsuario = $('#id').val();

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
        }
    });
});
