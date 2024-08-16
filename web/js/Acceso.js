function loginManifiestos() {
    let usu = document.getElementById("txtUsuario2").value;
    let con = document.getElementById("txtContrasenia2").value;
    let ruta = "http://localhost:8080/MONBA-PAGINA/api/acceso/login";
    fetch(ruta, {
        method: "POST",
        headers: {
            'Content-Type': 'application/x-www-form-urlencoded;charset=UTF-8'
        },
        body: 'u=' + encodeURIComponent(usu) + '&c=' + encodeURIComponent(con)
    })
            .then(response => {
                if (!response.ok) {
                    throw new Error('Error de red o servidor.');
                }
                return response.json();
            })
            .then(data => {
                if (data.token) {
                    localStorage.setItem('id_empleado', data.id_empleado);
                    localStorage.setItem('nombre', data.nombre);
                    localStorage.setItem('a_paterno', data.a_paterno);
                    localStorage.setItem('a_materno', data.a_materno);
                    localStorage.setItem('usuario', usu);
                    localStorage.setItem('contrasenia', con);
                    localStorage.setItem('rol', data.rol);
                    localStorage.setItem('token', data.token);

                    let rol = "";
                    if (data.rol === "ADMM") {
                        rol = "ADMINISTRADOR MANIFIESTOS";
                        Swal.fire({
                            title: "¡BIENVENIDO " + rol + "!",
                            text: "SU TOKEN ES: " + data.token,
                            icon: "success",
                            showConfirmButton: true
                        }).then(() => {
                            location.href = "http://localhost:8080/MONBA-PAGINA/Principal_Manifiestos_Administrador.html";
                        });
                    } else if(data.rol === "OPER") {
                        rol = "OPERADOR";
                        Swal.fire({
                            title: "¡BIENVENIDO " + rol + "!",
                            text: "SU TOKEN ES: " + data.token,
                            icon: "success",
                            showConfirmButton: true
                        }).then(() => {
                            location.href = "http://localhost:8080/MONBA-PAGINA/Principal_Manifiestos_Operador.html";
                        });
                    }
                } else {
                    Swal.fire("ERROR", "¡CREDENCIALES INCORRECTAS!", "error");
                    return false;
                }
            })
            .catch(error => {
                console.error('Error:', error);
                Swal.fire("Error", "Error de red o servidor.", "error");
            });
}