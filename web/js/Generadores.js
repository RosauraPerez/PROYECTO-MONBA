let generadores = [];

function cargarCatGeneradores() {
    const mostrarInactivos = document.getElementById("checkEstatus").checked;
    const url = mostrarInactivos 
        ? "http://localhost:8080/MONBA-PAGINA/api/generador/getAll?estatus=false"
        : "http://localhost:8080/MONBA-PAGINA/api/generador/getAll?estatus=true";
    
    fetch(url)
        .then(response => response.json())
        .then(response => {
            generadores = response;
            mostrarGeneradores(generadores);
        });
}
function mostrarGeneradores(generadores) {
    let mostrar = "";
    generadores.forEach((generador) => {
        mostrar += `
            <tr>
                <td>${generador.nombre}</td>
                <td>${generador.domicilio}</td>
                <td>${generador.colonia}</td>
                <td>${generador.codigo_postal}</td>
                <td>${generador.ciudad}</td>
                <td>${generador.estado}</td>
                <td>${generador.numero_autorizacion}</td>
                <td>${generador.telefono}</td>
                <td>${generador.correo}</td>
                <td>${generador.rfc}</td>
                <td>${generador.director}</td>
                <td><button class='btn btn-warning btn-md font-weight-bold' type='button' data-toggle='modal' data-target='#modificarGenerador' onclick='seleccionarGenerador(${generador.id_empresa});'><i class='bi bi-pencil-square fa-lg'></i> Seleccionar</button></td>
                <td>${generador.estatus === 0 ? 
                    `<button class='btn btn-success btn-md font-weight-bold' onclick='reactivarGenerador(${generador.id_empresa});'><i class='bi bi-check-square-fill'></i> Activar</button>` :
                    `<button class='btn btn-danger btn-md font-weight-bold' onclick='eliminarGenerador(${generador.id_empresa});'><i class='bi bi-trash3-fill fa-lg'></i> Eliminar</button>`}
                </td>
            </tr>`;
    });
    document.getElementById("tblGeneradores").innerHTML = mostrar;
}
function buscarGenerador() {
    const terminoBusqueda = document.getElementById("buscarGenerador").value.toLowerCase();
    const generadoresFiltrados = generadores.filter(generador => {
        return Object.values(generador).some(value => 
            value.toString().toLowerCase().includes(terminoBusqueda)
        );
    });
    mostrarGeneradores(generadoresFiltrados);
}
function seleccionarGenerador(id_empresa) {
    const generador = generadores.find(generador => generador.id_empresa === id_empresa);
    if (generador) {
        document.getElementById("id_empresa_1").value = generador.id_empresa;
        document.getElementById("nombre_empresa_1").value = generador.nombre;
        document.getElementById("domicilio_1").value = generador.domicilio;
        document.getElementById("colonia_1").value = generador.colonia;
        document.getElementById("codigo_postal_1").value = generador.codigo_postal;
        document.getElementById("ciudad_1").value = generador.ciudad;
        document.getElementById("estado_1").value = generador.estado;
        document.getElementById("permiso_generador_1").value = generador.numero_autorizacion;
        document.getElementById("telefono_1").value = generador.telefono;
        document.getElementById("correo_electronico_1").value = generador.correo;
        document.getElementById("rfc_1").value = generador.rfc;
        document.getElementById("nombre_director_1").value = generador.director;
    }
}

function limpiarFormulario() {
    document.getElementById("nombre_empresa").value = "";
    document.getElementById("domicilio").value = "";
    document.getElementById("colonia").value = "";
    document.getElementById("codigo_postal").value = "";
    document.getElementById("ciudad").value = "";
    document.getElementById("estado").value = "";
    document.getElementById("permiso_generador").value = "";
    document.getElementById("telefono").value = "";
    document.getElementById("correo_electronico").value = "";
    document.getElementById("rfc").value = "";
    document.getElementById("nombre_director").value = "";
}

function eliminarGenerador(id_empresa) {
    Swal.fire({
        title: '¿Estás seguro?',
        text: "¡Eliminar Generador!",
        icon: 'warning',
        showCancelButton: true,
        confirmButtonColor: '#3085d6',
        cancelButtonColor: '#d33',
        confirmButtonText: 'Sí, eliminar',
        cancelButtonText: 'Cancelar'
    }).then(result => {
        if (result.isConfirmed) {
            fetch(`http://localhost:8080/MONBA-PAGINA/api/generador/eliminar?id_generador=${id_empresa}`)
                .then(response => response.json())
                .then(response => {
                    Swal.fire('Eliminado!', '¡Generador Eliminado Exitosamente!', 'success');
                    cargarCatGeneradores();
                })
                .catch(() => Swal.fire('Error', 'Ocurrió un error al eliminar el Generador', 'error'));
        }
    });
}

function reactivarGenerador(id_empresa) {
    Swal.fire({
        title: '¿Estás seguro?',
        text: "¡Vas a volver a activar este generador!",
        icon: 'warning',
        showCancelButton: true,
        confirmButtonColor: '#3085d6',
        cancelButtonColor: '#d33',
        confirmButtonText: 'Sí, activar',
        cancelButtonText: 'Cancelar'
    }).then(result => {
        if (result.isConfirmed) {
            fetch(`http://localhost:8080/MONBA-PAGINA/api/generador/activar?id_generador=${id_empresa}`)
                .then(response => response.json())
                .then(response => {
                    Swal.fire('Activado!', '¡Generador Activado Exitosamente!', 'success');
                    cargarCatGeneradores();
                })
                .catch(() => Swal.fire('Error', 'Ocurrió un error al reactivar el generador', 'error'));
        }
    });
}

function insertarGenerador() {
    let nombre = document.getElementById("nombre_empresa").value;
    let domicilio = document.getElementById("domicilio").value;
    let colonia = document.getElementById("colonia").value;
    let codigo_postal = document.getElementById("codigo_postal").value;
    let ciudad = document.getElementById("ciudad").value;
    let estado = document.getElementById("estado").value;
    let num_autorizacion = document.getElementById("permiso_generador").value;
    let telefono = document.getElementById("telefono").value;
    let correo = document.getElementById("correo_electronico").value;
    let rfc = document.getElementById("rfc").value;
    let director = document.getElementById("nombre_director").value;
    let rol = "GENERADOR";

    let generador = {
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

    let params = {g: JSON.stringify(generador)};

    let ruta = "http://localhost:8080/MONBA-PAGINA/api/generador/insertar";
    
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
                cargarCatGeneradores(); // Llama a la función para recargar los generadores
                limpiarFormulario();
            });
        }
    });
}
function modificarGenerador() {
    let id_generador = document.getElementById("id_empresa_1").value;
    let nombre = document.getElementById("nombre_empresa_1").value;
    let domicilio = document.getElementById("domicilio_1").value;
    let colonia = document.getElementById("colonia_1").value;
    let codigo_postal = document.getElementById("codigo_postal_1").value;
    let ciudad = document.getElementById("ciudad_1").value;
    let estado = document.getElementById("estado_1").value;
    let num_autorizacion = document.getElementById("permiso_generador_1").value;
    let telefono = document.getElementById("telefono_1").value;
    let correo = document.getElementById("correo_electronico_1").value;
    let rfc = document.getElementById("rfc_1").value;
    let director = document.getElementById("nombre_director_1").value;
    let rol = "GENERADOR";

    let generador = {
        id_empresa: id_generador,
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

    let params = {g: JSON.stringify(generador)};

    let ruta = "http://localhost:8080/MONBA-PAGINA/api/generador/modificar";
    
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
                cargarCatGeneradores(); // Llama a la función para recargar los generadores
            });
        }
    });
}