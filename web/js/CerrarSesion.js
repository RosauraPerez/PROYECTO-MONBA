function cerrarSesion() {
    var usuario = localStorage.getItem('usuario');
    var token = localStorage.getItem('token');

    fetch('http://localhost:8080/MONBA-PAGINA/api/acceso/logout', {
        method: 'POST',
        headers: {
            'Content-Type': 'application/x-www-form-urlencoded'
        },
        body: 'u=' + encodeURIComponent(usuario) + '&token=' + encodeURIComponent(token)
    })
            .then(response => response.json())
            .then(data => {
                if (data.exito) {
                    localStorage.removeItem('id_empleado');
                    localStorage.removeItem('nombre');
                    localStorage.removeItem('a_paterno');
                    localStorage.removeItem('a_materno');
                    localStorage.removeItem('usuario');
                    localStorage.removeItem('contrasenia');
                    localStorage.removeItem('token');
                    localStorage.removeItem('rol');

                    Swal.fire("EXITO", "SE CERRÓ LA SESION CON ÉXITO", "warning")
                            .then(() => {
                                window.location.href = 'http://localhost:8080/MONBA-PAGINA/';
                            });
                }
            })
            .catch(error => {
                console.error('ERROR:', error);
            });
}

document.addEventListener('DOMContentLoaded', function () {
    document.getElementById('cerrar_sesion').addEventListener('click', function (event) {
        event.preventDefault();

        Swal.fire({
            title: '¿Está seguro?',
            text: "¡Está a punto de cerrar la sesión!",
            icon: 'warning',
            showCancelButton: true,
            confirmButtonColor: '#3085d6',
            cancelButtonColor: '#d33',
            confirmButtonText: 'Sí, cerrar sesión'
        }).then((result) => {
            if (result.isConfirmed) {
                cerrarSesion();
            }
        });
    });
});
