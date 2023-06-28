$(document).ready(function(){

    let date = new Date().toISOString().slice(0, 10);
    document.querySelector('#fechaN').setAttribute('max', date);
    let divRegistrar = document.querySelector('#divRegistrar');
    let validacionNull = document.createElement('p');
    divRegistrar.appendChild(validacionNull);

    $('#registrar').on('click', function(){
        
        let documento = $('#documento').val();
        let nombre = $('#nombre').val();
        let email = $('#email').val();
        let contraseña = $('#contraseña').val();
        let confirmacion = $('#confirmacion').val();
        let fechaNa = $('#fechaN').val();


        if (documento != '' && nombre != '' && email != '' && contraseña != '' && confirmacion != '' && fechaNa != ''){
            validacionNull.textContent = "";
    
            if (validarRegistro(documento, email, contraseña, confirmacion) >= 6){
                
                let usuario = {
                    idUsuario: documento,
                    nombres: nombre,
                    email: email,
                    contraseña: confirmacion,
                    fechaN: fechaNa,
                    estadoCuenta: 'Invitado'
        
                }

                let datosUsuario = JSON.stringify(usuario);
                $.ajax({
                    url: "http://localhost:8080/agregarUsuario",
                    type :"POST",
                    data: datosUsuario,
                    contentType: "application/JSON",
                    datatype: JSON,
                    success: function(respuesta) {
                        validarRegistroResponse(respuesta);
                    }
                })
    
            }

        } else {
            validacionNull.style.color = 'red';
            validacionNull.textContent = "Campos Vacios. Por favor, llena todos los campos.";

        }
        

    })

})


/*FUNCIONES ADICIONALES */
function validarDocumentoDB(documento){
    var valDoc = false;

    $.ajax({
        url: "http://localhost:8080/buscarUsuario/" + documento,
        type: "GET",
        datatype: "JSON",
        async: false,
        success: function(respuesta){
            valDoc = respuesta == '';
        }

    })

    return valDoc;

}


function validarEmailDB(email){
    var usuario = false;

    $.ajax({
        url: "http://localhost:8080/buscarxCorreo/" + email,
        type: "GET",
        datatype: "JSON",
        async: false,
        success: function(respuesta){
 
            usuario = respuesta == '';

        }

    })

    return usuario;

}

function validarEmail(email){

    var emailRegex = /^[-\w.%+]{1,64}@(?:[A-Z0-9-]{1,63}\.){1,125}[A-Z]{2,63}$/i;

    return emailRegex.test(email);

}

function validarContraseña(contraseña){

    return contraseña.length > 8;
 
}

function validarConfirmacion(contraseña, confirmacion){
    return confirmacion == contraseña;

}

function validarDocumento(documento){
    return documento.length <= 10;

}

let divDocumento = document.querySelector('#divDocumento');
    let validacionDocumento = document.createElement("p");
    divDocumento.appendChild(validacionDocumento);

    let divCorreo = document.querySelector('#divCorreo');
    let validacionCorreo = document.createElement("p");
    divCorreo.appendChild(validacionCorreo);

    let divContraseña = document.querySelector('#divContraseña');
    let validacionPass = document.createElement("p");
    divContraseña.appendChild(validacionPass);

    let divConfirmacion = document.querySelector('#divConfirmacion');
    let validacionConf = document.createElement("p");
    divConfirmacion.appendChild(validacionConf);


function validarRegistro(documento, email, contraseña, confirmacion){
 
    contador = 0;

    if(validarDocumento(documento)){
        contador++;

        if(validarDocumentoDB(documento)){
            contador++;
            validacionDocumento.textContent = '';

        } else {
            validacionDocumento.style.color = 'red';
            validacionDocumento.textContent = "Documento ya registrado.";

        }

    } else {
        validacionDocumento.style.color = 'red';
        validacionDocumento.textContent = "Longitud de Documento Invalida";

    }

    if(validarEmail(email)){
        contador++;

        if(validarEmailDB(email)){
            contador++;
            validacionCorreo.textContent = '';
            
    
        } else {
            
            validacionCorreo.style.color = 'red';
            validacionCorreo.textContent = "Correo ya registrado.";
            
    
        }

    } else {
        validacionCorreo.style.color = 'red';
        validacionCorreo.textContent = "Correo no Valido.";

    }

    if (validarContraseña(contraseña)){
        contador++;
        validacionPass.textContent = '';

    } else {
        validacionPass.style.color = 'red';
        validacionPass.textContent = "Contraseña Invalida";

    }

    if (validarConfirmacion(contraseña, confirmacion)){
        contador++;
        validacionConf.textContent = '';

    } else {
        validacionConf.style.color = 'red';
        validacionConf.textContent = "Las contraseñas no coinciden.";

    }

    return contador;

}


function validarRegistroResponse(response){

    alert(response);
    if (response == 'Usuario registrado exitosamente.'){
        
        window.location.replace('http://127.0.0.1:5500/login.html');
    } 

}