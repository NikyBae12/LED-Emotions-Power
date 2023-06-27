$(document).ready(function(){

    let date = new Date().toISOString().slice(0, 10);
    document.querySelector('#fechaN').setAttribute('max', date);

    $('#registrar').on('click', function(){
        
        let documento = $('#documento').val();
        let nombre = $('#nombre').val();
        let email = $('#email').val();
        let contraseña = $('#contraseña').val();
        let confirmacion = $('#confirmacion').val();
        let fechaNa = $('#fechaN').val();

        let usuario = {
            idUsuarios: documento,
            nombres: nombre,
            email: email,
            contraseña: confirmacion,
            fechaN: fechaNa,
            estadoCuenta: 'Invitado'

        }

        if (validarRegistro(documento, email, contraseña, confirmacion) == 5){
            alert('Si se pudo');

        } else {
            alert('Send help')
        }
        

    })

})


/*FUNCIONES ADICIONALES */

function validarEmailDB(email){

    divCorreo.appendChild(validacionCorreo);
    validacionCorreo.style.textAlign = 'center';
    validacionCorreo.style.color = 'red';

    $.ajax({
        url: "http://localhost:8080/buscarxCorreo/" + email,
        type: "GET",
        datatype: "JSON",
        success: function(respuesta){
            return respuesta;

        }

    })

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


function validarRegistro(documento, email, contraseña, confirmacion){
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

    contador = 0;

    if(validarDocumento(documento)){
        contador++;
        validacionDocumento.textContent = '';

    } else {
        validacionDocumento.style.color = 'red';
        validacionDocumento.textContent = "Longitud de Documento Invalida";

    }

    if(validarEmail(email)){
        contador++;
        validacionCorreo.textContent = '';

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

    if (validarConfirmacion(confirmacion)){
        contador++;
        validacionConf.textContent = '';

    } else {
        validacionConf.style.color = 'red';
        validacionConf.textContent = "Las contraseñas no coinciden.";

    }

    return contador;

}