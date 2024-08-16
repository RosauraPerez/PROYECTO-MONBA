let destinos = [];

function cargarCatDestinos() {
    const mostrarInactivos = document.getElementById("checkEstatus").checked;
    const url = mostrarInactivos 
        ? "http://localhost:8080/MONBA-PAGINA/api/destino/getAll?estatus=false"
        : "http://localhost:8080/MONBA-PAGINA/api/destino/getAll?estatus=true";
    
    fetch(url)
        .then(response => response.json())
        .then(response => {
            destinos = response;
            mostrarDestinos(destinos);
        });
}

function mostrarDestinos(destinos) {
    let mostrar = "";
    destinos.forEach((destino) => {
        mostrar += `
            <tr>
                <td>${destino.nombre}</td>
                <td>${destino.domicilio}</td>
                <td>${destino.colonia}</td>
                <td>${destino.codigo_postal}</td>
                <td>${destino.ciudad}</td>
                <td>${destino.estado}</td>
                <td>${destino.numero_autorizacion}</td>
                <td>${destino.telefono}</td>
                <td>${destino.correo}</td>
                <td>${destino.rfc}</td>
                <td>${destino.director}</td>
                <td><button class='btn btn-warning btn-md font-weight-bold' type='button' data-toggle='modal' data-target='#modoficarDestinoFinal' onclick='seleccionarDestino(${destino.id_empresa});'><i class='bi bi-pencil-square fa-lg'></i> Seleccionar</button></td>
                <td>${destino.estatus === 0 ? 
                    `<button class='btn btn-success btn-md font-weight-bold' onclick='reactivarDestino(${destino.id_empresa});'><i class='bi bi-check-square-fill'></i> Activar</button>` :
                    `<button class='btn btn-danger btn-md font-weight-bold' onclick='eliminarDestino(${destino.id_empresa});'><i class='bi bi-trash3-fill fa-lg'></i> Eliminar</button>`}
                </td>
            </tr>`;
    });
    document.getElementById("tblDestinos").innerHTML = mostrar;
}

function buscarDestino() {
    const terminoBusqueda = document.getElementById("buscarDestino").value.toLowerCase();
    const destinosFiltrados = destinos.filter(destino => {
        return Object.values(destino).some(value => 
            value.toString().toLowerCase().includes(terminoBusqueda)
        );
    });
    mostrarDestinos(destinosFiltrados);
}

function seleccionarDestino(id_empresa) {
    const destino = destinos.find(destino => destino.id_empresa === id_empresa);
    if (destino) {
        document.getElementById("id_empresa_1").value = destino.id_empresa;
        document.getElementById("nombre_empresa_1").value = destino.nombre;
        document.getElementById("domicilio_1").value = destino.domicilio;
        document.getElementById("colonia_1").value = destino.colonia;
        document.getElementById("codigo_postal_1").value = destino.codigo_postal;
        document.getElementById("ciudad_1").value = destino.ciudad;
        document.getElementById("estado_1").value = destino.estado;
        document.getElementById("permiso_destino_1").value = destino.numero_autorizacion;
        document.getElementById("telefono_1").value = destino.telefono;
        document.getElementById("correo_electronico_1").value = destino.correo;
        document.getElementById("rfc_1").value = destino.rfc;
        document.getElementById("nombre_director_1").value = destino.director;
    }
}

function limpiarFormulario() {
    document.getElementById("nombre_empresa").value = "";
    document.getElementById("domicilio").value = "";
    document.getElementById("colonia").value = "";
    document.getElementById("codigo_postal").value = "";
    document.getElementById("ciudad").value = "";
    document.getElementById("estado").value = "";
    document.getElementById("permiso_destino").value = "";
    document.getElementById("telefono").value = "";
    document.getElementById("correo_electronico").value = "";
    document.getElementById("rfc").value = "";
    document.getElementById("nombre_director").value = "";
}

function eliminarDestino(id_empresa) {
    Swal.fire({
        title: '¿Estás seguro?',
        text: "¡Eliminar Destino!",
        icon: 'warning',
        showCancelButton: true,
        confirmButtonColor: '#3085d6',
        cancelButtonColor: '#d33',
        confirmButtonText: 'Sí, eliminar',
        cancelButtonText: 'Cancelar'
    }).then(result => {
        if (result.isConfirmed) {
            fetch(`http://localhost:8080/MONBA-PAGINA/api/destino/eliminar?id_destino=${id_empresa}`)
                .then(response => response.json())
                .then(response => {
                    Swal.fire('Eliminado!', '¡Destino Eliminado Exitosamente!', 'success');
                    cargarCatDestinos();
                })
                .catch(() => Swal.fire('Error', 'Ocurrió un error al eliminar el Destino', 'error'));
        }
    });
}

function reactivarDestino(id_empresa) {
    Swal.fire({
        title: '¿Estás seguro?',
        text: "¡Vas a volver a activar este destino!",
        icon: 'warning',
        showCancelButton: true,
        confirmButtonColor: '#3085d6',
        cancelButtonColor: '#d33',
        confirmButtonText: 'Sí, activar',
        cancelButtonText: 'Cancelar'
    }).then(result => {
        if (result.isConfirmed) {
            fetch(`http://localhost:8080/MONBA-PAGINA/api/destino/activar?id_destino=${id_empresa}`)
                .then(response => response.json())
                .then(response => {
                    Swal.fire('Activado!', '¡Destino Activado Exitosamente!', 'success');
                    cargarCatDestinos();
                })
                .catch(() => Swal.fire('Error', 'Ocurrió un error al reactivar el destino', 'error'));
        }
    });
}
function insertarDestino() {
    let nombre = document.getElementById("nombre_empresa").value;
    let domicilio = document.getElementById("domicilio").value;
    let colonia = document.getElementById("colonia").value;
    let codigo_postal = document.getElementById("codigo_postal").value;
    let ciudad = document.getElementById("ciudad").value;
    let estado = document.getElementById("estado").value;
    let num_autorizacion = document.getElementById("permiso_destino").value;
    let telefono = document.getElementById("telefono").value;
    let correo = document.getElementById("correo_electronico").value;
    let rfc = document.getElementById("rfc").value;
    let director = document.getElementById("nombre_director").value;
    let rol = "DESTINO";

    let destino = {
        nombre: nombre,
        domicilio: domicilio,
        colonia: colonia,
        codigo_postal: codigo_postal,
        ciudad: ciudad,
        estado: estado,
        numero_autorizacion: num_autorizacion,
        telefono: telefono,
        correo: correo,
        rfc: rfc,
        director: director,
        rol: rol
    };

    let params = {d: JSON.stringify(destino)};

    let ruta = "http://localhost:8080/MONBA-PAGINA/api/destino/insertar";

    Swal.fire({
        title: '¿Estás seguro?',
        text: "¿Quieres proceder con la inserción?",
        icon: 'warning',
        showCancelButton: true,
        confirmButtonColor: '#3085d6',
        cancelButtonColor: '#d33',
        confirmButtonText: 'Sí, insertar',
        cancelButtonText: 'Cancelar'
    }).then((result) => {
        if (result.isConfirmed) {
            // Si el usuario confirma, procede a insertar
            fetch(ruta, {
                method: "POST",
                headers: {'Content-Type': 'application/x-www-form-urlencoded;charset=UTF-8'},
                body: new URLSearchParams(params)
            })
                    .then(response => response.json())
                    .then(response => {
                        if (response.result === "EXITO") {
                            Swal.fire('Éxito', '¡Inserción Correcta!', 'success');
                        } else if (response.result === "ERROR") {
                            Swal.fire('Error', '¡Problemas al Insertar Verifique Datos!', 'error');
                        } else if (response.error) {
                            Swal.fire('Error', '¡Problemas al Insertar Verifique Datos!', 'error');
                        }
                        cargarCatDestinos();
                        limpiarFormulario();
                    });
        }
    });
}
function modificarDestino() {
    let id_destino = document.getElementById("id_empresa_1").value;
    let nombre = document.getElementById("nombre_empresa_1").value;
    let domicilio = document.getElementById("domicilio_1").value;
    let colonia = document.getElementById("colonia_1").value;
    let codigo_postal = document.getElementById("codigo_postal_1").value;
    let ciudad = document.getElementById("ciudad_1").value;
    let estado = document.getElementById("estado_1").value;
    let num_autorizacion = document.getElementById("permiso_destino_1").value;
    let telefono = document.getElementById("telefono_1").value;
    let correo = document.getElementById("correo_electronico_1").value;
    let rfc = document.getElementById("rfc_1").value;
    let director = document.getElementById("nombre_director_1").value;
    let rol = "DESTINO";

    let destino = {
        id_empresa: id_destino,
        nombre: nombre,
        domicilio: domicilio,
        colonia: colonia,
        codigo_postal: codigo_postal,
        ciudad: ciudad,
        estado: estado,
        numero_autorizacion: num_autorizacion,
        telefono: telefono,
        correo: correo,
        rfc: rfc,
        director: director,
        rol: rol
    };

    let params = {d: JSON.stringify(destino)};

    let ruta = "http://localhost:8080/MONBA-PAGINA/api/destino/modificar";

    Swal.fire({
        title: '¿Estás seguro?',
        text: "¿Quieres proceder con la modificación?",
        icon: 'warning',
        showCancelButton: true,
        confirmButtonColor: '#3085d6',
        cancelButtonColor: '#d33',
        confirmButtonText: 'Sí, modificar',
        cancelButtonText: 'Cancelar'
    }).then((result) => {
        if (result.isConfirmed) {
            // Si el usuario confirma, procede a insertar
            fetch(ruta, {
                method: "POST",
                headers: {'Content-Type': 'application/x-www-form-urlencoded;charset=UTF-8'},
                body: new URLSearchParams(params)
            })
                    .then(response => response.json())
                    .then(response => {
                        if (response.result === "EXITO") {
                            Swal.fire('Éxito', '¡Modificación Exitosa!', 'success');
                        } else if (response.result === "ERROR") {
                            Swal.fire('Error', '¡Problemas al Modificar Verifique Datos!', 'error');
                        } else if (response.error) {
                            Swal.fire('Error', '¡Problemas al Modificar Verifique Datos!', 'error');
                        }
                        cargarCatDestinos();
                    });
        }
    });
}
