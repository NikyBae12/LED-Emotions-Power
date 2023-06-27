$(document).ready(function(){


    // METODO LISTAR    
        let tablaUsuarios = document.querySelector('#tablaBody')
        tablaUsuarios.innerHTML = ''

        $.ajax({
            url : "http://localhost:8080/listarUsuarios",
            type : "GET",
            datatype : "JSON",
            success : function (respuesta){
                console.log(respuesta)
                
                
                for (i = 0; i <= respuesta.length; i++){
                    tablaUsuarios.innerHTML += '<tr><td>' + respuesta[i].idUsuario +
                    '</td><td>' + respuesta[i].nombres +
                    '</td><td>' + respuesta[i].email + 
                    '</td><td>' + respuesta[i].contraseña + 
                    '</td><td>' + respuesta[i].fechaN + 
                    '</td><td>' + respuesta[i].imgPerfil + 
                    '</td><td>' + respuesta[i].estadoCuenta + 
                    '</td></tr>';
                }

            }
        });    


        // BUSCAR POR CODIGO
        $('#buscar').on('click', function() {
            let id = $('#codigo').val();
            $.ajax({
                url : "http://localhost:8080/buscarUsuario/" + idUsuarios,
                type: "GET",
                datatype: "JSON",
    
                success:function(respuesta){
                    if(respuesta){
                        console.log(respuesta);
                        document.querySelector("#txtId").setAttribute('value',respuesta['idUsuarios']);
                        document.querySelector("#txtId").disabled = true;
                        document.querySelector("#txtNombres").setAttribute('value',respuesta['nombres']);
                        document.querySelector("#txtEmail").setAttribute('value',respuesta['email']);
                        document.querySelector("#txtContraseña").setAttribute('value',respuesta['contraseña']);
                        document.querySelector("#txtFechaN").setAttribute('value',respuesta['fechaN']);
                        document.querySelector("#imgPerfil").setAttribute('value',respuesta['imgPerfil']);
                        document.querySelector("#estadoCuenta").setAttribute('value',respuesta['estadoCuenta']);

                    } else{
                        alert("El usuario que busca no se encuentra en la Base de Datos, vuelva a intentarlo");
                    }
                }
    
            })
    
        });


    // METODO AGREGAR
    $('#agregar').on('click', function(){
        
        let datos = {
            idUsuarios: ($('#IdUsuario').val()),
            nombres : $ ('#Nombres').val(),
            email : $ ('#Email').val(),
            contraseña : $ ('#Contraseña').val(),
            fechaN : $ ('#FechaN').val(),
            imgPerfil : $ ('#imgPerfil').val(), 
            estadoCuenta : $ ('#EstadoCuenta').val(),   
        }

        let datosEnvio = JSON.stringify(datos);
        $.ajax({
            url: "http://localhost:8080/agregarUsuario",
            type :"POST",
            data: datosEnvio,
            contentType: "application/JSON",
            datatype: JSON,
            success: function(respuesta) {
                console.log(respuesta);
            }
        })
    });




    //METODO ELIMINAR
    $('#eliminar').on('click', function(){


        let eliminarUsuario = $('#codigo').val();

        $.ajax({
            url: "http://localhost:8080/eliminarUsuario/" + eliminarUsuario,
            type: "DELETE",
            datatype: "JSON",
            
            success: function (respuesta) {
                alert(respuesta)
              }

    });

    });


    // METODO ACTUALIZAR

    $('#actualizar').on('click', function(){

        if ($('#txtNombres').val() != "" && $('#txtEmail').val()!= "" && $('#txtContraseña').val()!= "" && $('#txtFechaN').val() != "" && $('#txtImgPerfil').val()!= "" && $('#txtEstadoCuenta').val() != "" ){


            let Usuarios = {

                idUsuarios: $('#txtId').val(),
                nombres : $ ('#txtNombres').val(),
                email : $ ('#txtEmail').val(),
                contraseña : $ ('#txtContraseña').val(),
                fechaN : $ ('#txtFechaN').val(),
                imgPerfil : $ ('#txtImgPerfil').val(),
                estadoCuenta : $ ('#txtEstadoCuenta').val(),

            }

            let actuUsuario = JSON.stringify(Usuarios);
            console.log(Usuarios)
            console.log(actuUsuario)
            $.ajax({

                url: "http://localhost:8080/actuUsuario",
                type: "PUT",
                data: actuUsuario,
                contentType: "application/JSON",
                datatype: "JSON",

                success: function(response){
                    alert(response);
                }

            })

        } else {
            alert("Hay uno o varios campo/s faltante/s, por favor, llene todos los campos.")
        }

    })






})