let empleados;

function cargarCatEmpleado() {
    const url = "http://localhost:8080/MONBA-PAGINA/api/empleado/getAll?";

    fetch(url)
            .then(response => response.json())
            .then(response => {
                let mostrar = "";
                empleados = response;
                for (let i = 0; i < empleadosActivos.length; i++) {
                    let empleado = empleadosActivos[i];
                    mostrar += "<tr>";
                    mostrar += "<td>" + empleado.persona.nombre + "</td>";
                    mostrar += "<td>" + empleado.persona.apellidoPaterno + "</td>";
                    mostrar += "<td>" + empleado.persona.apellidoMaterno + "</td>";
                    mostrar += "<td>" + empleado.puesto + "</td>";
                    mostrar += "<td class='acciones'>";
                    mostrar += "<button class='btn btn-warning btn-md font-weight-bold font-italic' data-toggle='modal' data-target='#myModalEx' onclick='modificarEmpleado(" + i + ");'> <i class='bi bi-pencil-square fa-lg'></i> Modificar </button>";
                    mostrar += "<button class='btn btn-danger btn-md font-weight-bold font-italic' onclick='eliminarEmpleado(" + i + ");'> <i class='bi bi-trash3-fill fa-lg'></i> Eliminar </button>";
                    mostrar += "</td>";
                    mostrar += "</tr>";
                }
                document.getElementById("tblEmpleados").innerHTML = mostrar;
            })
            .catch(error => console.error('Error al obtener los datos:', error));
}


function obtenerDatosEmpleado() {
    // Datos de Persona
    let id_persona = document.getElementById("idPersona").value;
    let nombres = document.getElementById("nombre").value;
    let apellidoPaterno = document.getElementById("a_Paterno").value;
    let apellidoMaterno = document.getElementById("a_Materno").value;
    let genero = document.getElementById("genero").value;
    let fechaNacimientoInput = document.getElementById("fecha_nacimiento");

    // Convertir la fecha de nacimiento en un formato ISO adecuado
    let fechaNacimiento = new Date(fechaNacimientoInput.value);
    let fechaNacimientoComoString = fechaNacimiento.toISOString().split('T')[0];

    let rfc = document.getElementById("rfc").value;
    let curp = document.getElementById("curp").value;
    let domicilio = document.getElementById("domicilio").value;
    let codigoPostal = document.getElementById("cp").value;
    let ciudad = document.getElementById("ciudad").value;
    let estado = document.getElementById("estado").value;
    let telefono = document.getElementById("telefono").value;
    let numLicencia = document.getElementById("numero_licencia").value;
    let tipoLicencia = document.getElementById("tipo_licencia").value;
    let foto = document.getElementById("textoFoto").value;

    // Crear objeto Persona
    let persona = {
        id_persona: parseInt(id_persona), nombre: nombres, a_paterno: apellidoPaterno, a_materno: apellidoMaterno, genero: genero, fecha_nacimiento: fechaNacimientoComoString,
        rfc: rfc, curp: curp, domicilio: domicilio, codigo_postal: codigoPostal, ciudad: ciudad, estado: estado, telefono: telefono, foto: foto, numero_licencia: numLicencia,
        tipo_licencia: tipoLicencia
    };

    // Datos de Usuario
    let idUsuario = document.getElementById("idUsuario").value;
    let nombreU = document.getElementById("usuario").value;
    let contrasenia = document.getElementById("contrasenia").value;
    let rol = document.getElementById("rol").value;

    // Crear objeto Usuario
    let usuario = {
        id_usuario: parseInt(idUsuario), nombre_usuario: nombreU,
        contrasenia: contrasenia, rol: rol
    };

    // Datos de Empleado
    let idEmpleado = document.getElementById("idEmpleado").value;
    let codigo = document.getElementById("codigoEmpleado").value;
    let fechaIngreso = document.getElementById("fecha_ingreso").value;
    let puesto = document.getElementById("puesto").value;
    let correo = document.getElementById("correo").value;
    let estatus = document.getElementById("estatus").value;
    let comentario = document.getElementById("comentario").value;
    let nomExpediente = document.getElementById("nombre_expediente").value;
    let expediente = document.getElementById("expediente").value;
    let tipoVehiculo = document.getElementById("tipo_vehiculo").value;
    let numPlaca = document.getElementById("num_placa").value;

    // Crear objeto Empleado
    let empleado = {
        id_empleado: parseInt(idEmpleado), codigo: codigo, fecha_ingreso: fechaIngreso, puesto: puesto,
        correo_electronico: correo, estatus: parseInt(estatus), comentario: comentario, nombre_expediente: nomExpediente,
        expediente: expediente, tipo_vehiculo: tipoVehiculo, num_placa: numPlaca, id_persona: parseInt(id_persona), id_usuario: parseInt(idUsuario)
    };

    // Parámetros para enviar al servidor
    let params = {
        e: JSON.stringify(empleado),
        p: JSON.stringify(persona),
        u: JSON.stringify(usuario)
    };

    let ruta = "http://localhost:8080/MONBA-PAGINA/api/empleado/insert?";

    // Fetch para enviar la solicitud al servidor
    fetch(ruta, {
        method: "POST",
        headers: {
            'Content-Type': 'application/x-www-form-urlencoded;charset=UTF-8'
        },
        body: new URLSearchParams(params)
    })
            .then(response => response.json())
            .then(response => {
                if (response.result) {
                    Swal.fire(response.result, "¡Inserción Correcta!", "success");
                } else if (response.error) {
                    Swal.fire(response.result, "Problemas al Insertar", "error");
                }
                cargarCatEmpleado();
            });
}











function eliminarEmpleado(i) {
    let id_empleado = empleados[i].id_empleado;

    fetch("http://localhost:8080/monba/api/empleado/delete?id_empleado=" + id_empleado)
            .then(response => response.json())
            .then(response => {
                Swal.fire(response.result, "Empleado eliminado con éxito", "success");
                cargarCatEmpleado();
            });
}
function activarEmpleado(i) {
    let id_empleado = empleados[i].id_empleado;

    fetch("http://localhost:8080/sicefasucursal/api/empleado/activar?idE=" + id_empleado)
            .then(response => response.json())
            .then(response => {
                Swal.fire(response.result, "Empleado activado con éxito", "success");
                cargarCatEmpleado();
            });
}
function buscarEmpleados() {
    // Obtén el valor de búsqueda desde el campo de entrada
    let input = document.getElementById("inputBusqueda").value.toLowerCase();

    // Filtra los empleados en base al valor de búsqueda
    let empleadosFiltrados = empleados.filter(empleado => {

        let datosEmpleado = `${empleado.codigo} ${empleado.fecha_ingreso} ${empleado.puesto} ${empleado.correo_electronico} ${empleado.num_placa} ${empleado.tipo_vehiculo} ${empleado.persona.nombre} ${empleado.persona.a_paterno} ${empleado.persona.a_materno} ${empleado.persona.fecha_nacimiento} ${empleado.persona.rfc} ${empleado.persona.curp} ${empleado.persona.domicilio} ${empleado.persona.codigo_postal} ${empleado.persona.ciudad} ${empleado.persona.estado} ${empleado.persona.telefono} ${empleado.usuario.nombre_usuario} ${empleado.usuario.rol}`.toLowerCase();

        // Devuelve true si alguna parte de los datos coincide con la búsqueda
        return datosEmpleado.includes(input);
    });

    mostrarEmpleados(empleadosFiltrados);
}



// Funcion para el pdf
let input = document.querySelector('#pdfInput').addEventListener('change', function (event) {
    const file = event.target.files[0]
    if (file && file.type === 'application/pdf') {
        if (getFileSize(file) <= 5) {
            const reader = new FileReader()
            reader.onload = function (e) {
                visualizePdf(e.target.result)
            }
            reader.readAsDataURL(file)
        } else {
            alert("Archivo muy pesado")
            event.value = ''
        }
    } else {
        alert('Este archivo no es un PDF')
    }
})

function getFileSize(file) {
    let fileSizeInBytes = file.size
    let fileSizeInKB = (fileSizeInBytes / 1024).toFixed(2)
    let fileSizeInMB = (fileSizeInKB / 1024).toFixed(2)
    return fileSizeInMB
}

function visualizePdf(pdfData) {
    let pdf = pdfData
    if (pdf.startsWith("data:application/pdf;base64,")) {
        pdf = pdf.replace('data:application/pdf;base64,', "")
    }

    let binaryString = window.atob(pdf)
    let len = binaryString.length
    let bytes = new Uint8Array(len)
    for (let i = 0; i < len; i++) {
        bytes[i] = binaryString.charCodeAt(i)
    }

    let blob = new Blob([bytes], { type: 'application/pdf' })

    var url = URL.createObjectURL(blob)

    const frame = document.querySelector('#pdfViwer')
    frame.src = url
}