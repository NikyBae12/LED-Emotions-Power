const tablaUsuarios = document.getElementById('tablaUsuarios');
        const formAgregarUsuario = document.getElementById('formAgregarUsuario');

        // Función para cargar los usuarios al cargar la página
        window.onload = function() {
            cargarUsuarios();
        };

        // Función para cargar los usuarios desde el servidor
        function cargarUsuarios() {
            fetch('/listarUsuarios')
                .then(response => response.json())
                .then(usuario => {
                    tablaUsuarios.innerHTML = ''; // Limpiar la tabla antes de cargar los datos

                    for (let usuario of usuario) {
                        let row = tablaUsuarios.insertRow();
                        row.insertCell(0).textContent = usuario.IdUsuario;
                        row.insertCell(1).textContent = usuario.Nombres;
                        row.insertCell(2).textContent = usuario.Email;
                        row.insertCell(3).textContent = usuario.Contraseña;
                        row.insertCell(4).textContent = usuario.FechaN;
                        row.insertCell(5).textContent = usuario.CodVerif;
                        row.insertCell(6).textContent = usuario.imgPerfil;
                        row.insertCell(7).textContent = usuario.EstadoCuenta;

                    }
                });
        }

        // Evento de envío del formulario de agregar usuario
        formAgregarUsuario.addEventListener('submit', function(event) {
            event.preventDefault();

            const formData = new FormData(formAgregarUsuario);
            const usuarios = {
                IdUsuario: formData.get('IdUsuario'),
                Nombres: formData.get('Nombres'),
                Email: formData.get('Email'),
                Contraseña: formData.get('Contraseña'),
                FechaN: formData.get('FechaN'),
                CodVerif: formData.get('CodVerif'),
                imgPerfil: formData.get('imgPerfil'),
                EstadoCuenta: formData.get('EstadoCuenta')


            };

            fetch('/listarUsuarios', {
                method: 'POST',
                headers: {
                    'Content-Type': 'application/json'
                },
                body: JSON.stringify(usuarios)
            })
            .then(response => response.json())
            .then(nuevoEstudiante => {
                // Limpiar el formulario
                formAgregarUsuario.reset();
                // Actualizar la tabla de usuarios
                cargarUsuarios();
            });
        });





         // Eliminar Usuario
         document.getElementById('eliminarUsu').addEventListener('submit', function(usu) {
            usu.preventDefault();
            var IdUsuario = document.getElementById('IdUsuario').value;

            // Realizar solicitud al servidor para eliminar el estudiante
            fetch('/listarUsuarios/' + IdUsuario, {
                method: 'DELETE'
            })
            .then(function(response) {
                if (response.ok) {
                    alert('Usuario eliminado correctamente');
                    // Actualizar la interfaz de usuario, si es necesario
                } else {
                    alert('Error al eliminar el usuario');
                }
            })
            .catch(function(error) {
                alert('Error de conexión');
                console.log(error);
            });
        });

        // Actualizar Usuario
        document.getElementById('actualizarUsu').addEventListener('submit', function(usu) {
            usu.preventDefault();
            var IdUsuario = document.getElementById('IdUsuario').value;
            var Nombres = document.getElementById('Nombres').value;
            var Email = document.getElementById('Email').value;
            var Contraseña = document.getElementById('Contraseña').value;
            var FechaN = document.getElementById('FechaN').value;
            var CodVerif = document.getElementById('CodVerif').value;
            var imgPerfil = document.getElementById('imgPerfil').value;
            var EstadoCuenta = document.getElementById('EstadoCuenta').value;

            
            var data = {
                Nombres: Nombres,
                Email: Email,
                Contraseña: Contraseña,
                FechaN: FechaN,
                CodVerif: CodVerif,
                imgPerfil: imgPerfil,
                EstadoCuenta: EstadoCuenta,

            };

            // Realizar solicitud al servidor para actualizar el usuario
            fetch('/listarUsuarios/' + IdUsuario, {
                method: 'PUT',
                headers: {
                    'Content-Type': 'application/json'
                },
                body: JSON.stringify(data)
            })
            .then(function(response) {
                if (response.ok) {
                    alert('Usuario actualizado correctamente');
                    // Actualizar la interfaz de usuario, si es necesario
                } else {
                    alert('Error al actualizar el usuario');
                }
            })
            .catch(function(error) {
                alert('Error de conexión');
                console.log(error);
            });
        });