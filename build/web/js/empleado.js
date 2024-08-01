import * as API from "./API/api_functions.js";
import { getInputValues } from "./InputsHandler/inputs.js";
import * as msg from "./SweetComponents/messages.js";

/// Obtenemos el boton "Guardar" y le agrgamos el evento click
const btnAgregar = document.querySelector('#btnGuardar').addEventListener('click', () => agregarEmpleado())


/// Obtiene toda la informacion de los empleados
async function cargarCatEmpleado() {
    const url = "http://localhost:8080/PROYECTO-MONBA/api/empleado/getAll?estatus=true";

    const data = await API.getData(url)

    crearTablaEmpleados(data)   // Crea la tabla a partir de la informacion obtenida de la API
}


/// Agrega el empleado
async function agregarEmpleado() {
    const URL = "http://localhost:8080/PROYECTO-MONBA/api/empleado/insert"
    const datosFormulario = await getInputValues(getAllInputs()) // Obtiene los datos de los inputs

    const newJson = CrearJsonEmpleado(datosFormulario) // Crea el Json para guardar el empelado con la informacion de los inputs

    let response = await API.sendData(URL, "e", newJson) // Enviar los datos a la API
}

/// Crea los elementos de la tabla o tr > th
function crearTablaEmpleados(dataEmpleados) {
    const tableBody = document.querySelector('.id_empleado')

    dataEmpleados.forEach(empleado => {
        let botonModificarContenedor = document.createElement('th')
        let botonModificar = document.createElement('button')
        botonModificar.classList.add('btn', 'btn-warning', 'btn-md', 'font-weigth-bold', 'font-italic')
        botonModificar.innerHTML = "<i class='bi bi-pencil-square fa-lg'></i> Modificar"
        botonModificarContenedor.appendChild(botonModificar)

        let botonEliminarContenedor = document.createElement('th')
        let botonEliminar = document.createElement('button')
        botonEliminar.classList.add('btn', 'btn-danger', 'btn-md', 'font-weight-bold')
        botonEliminar.innerHTML = "<i class='bi bi-trash3-fill fa-lg'></i> Eliminar"
        botonEliminarContenedor.appendChild(botonEliminar)

        let row = document.createElement('tr') // Contenedor de los elementos o fila

        let empleadoNombre = document.createElement('th')
        let empleadoApellidoPaterno = document.createElement('th')
        let empleadoApellidoMaterno = document.createElement('th')
        let empleadoPuesto = document.createElement('th')

        empleadoNombre.textContent = empleado.Persona.nombre

        empleadoApellidoPaterno.textContent = empleado.Persona.apellido_paterno

        empleadoApellidoMaterno.textContent = empleado.Persona.apellido_materno

        empleadoPuesto.textContent = empleado.puesto

        row.appendChild(empleadoNombre)
        row.appendChild(empleadoApellidoPaterno)
        row.appendChild(empleadoApellidoMaterno)
        row.appendChild(empleadoPuesto)
        row.appendChild(botonModificarContenedor)
        row.appendChild(botonEliminarContenedor)

        tableBody.appendChild(row)
    })
}

cargarCatEmpleado()

/// Funcion para devolver un objeto Json con los parametros de los inputs del formulario, compuesto por: ID del input, NOMBRE del atributo del Json, KEY para verificaciones futuras como alertas de
// campos vacios
function getAllInputs() {
    const inputs = [
        {ID: '#nombre', NAME: "nombre", KEY: 'Nombre'},
        {ID: '#a_Paterno', NAME: "apellido_paterno", KEY: 'Apellido Paterno'},
        {ID: '#a_Materno', NAME: "apellido_materno", KEY: 'Apellido Materno'},
        {ID: '#genero', NAME: "genero", KEY: 'Genero'},
        {ID: '#fecha_nacimiento', NAME: "fecha_nacimiento", KEY: 'Fecha de Nacimiento'},
        {ID: '#rfc', NAME: "rfc", KEY: 'RFC'},
        {ID: '#curp', NAME: "curp", KEY: 'CURP'},
        {ID: '#domicilio', NAME: "domicilio", KEY: 'Domicilio'},
        {ID: '#cp', NAME: "codigo_postal", KEY: 'Codigo Postal'},
        {ID: '#ciudad', NAME: "ciudad", KEY: 'Ciudad'},
        {ID: '#estado', NAME: "estado", KEY: 'Estado'},
        {ID: '#telefono', NAME: "telefono", KEY: 'Telefono'},
        {ID: '#numero_licencia', NAME: "numero_licencia", KEY: 'Numero de licencia'},
        {ID: '#tipo_licencia', NAME: "tipo_licencia", KEY: 'Tipo de licencia'},

        {ID: '#inputFoto', NAME: "foto", KEY: 'Foto', TYPE: 'img'},
        {ID: '#usuario', NAME: "nombre_usuario", KEY: 'Usuario'},
        {ID: '#contrasenia', NAME: "contrasenia", KEY: 'Contraseña'},
        {ID: '#rol', NAME: "rol", KEY: 'Rol'},

        {ID: '#codigoEmpleado', NAME: "codigo", KEY: 'Codigo del empleado'},
        {ID: '#fechaIngreso', NAME: "fecha_ingreso", KEY: 'Fecha de Ingreso'},
        {ID: '#puesto', NAME: "puesto", KEY: 'Puesto'},
        {ID: '#correo', NAME: "correo_electronico", KEY: 'Correo'},
        {ID: '#estatus', NAME: "estatus", KEY: 'Estatus'},
        {ID: '#comentario', NAME: "comentario", KEY: 'Comentarios'},
        {ID: '#tipo_vehiculo', NAME: "tipo_vehiculo", KEY: 'Tipo de vehiculo'},
        {ID: '#num_placa', NAME: "num_placa", KEY: 'Numero de placa'},

        {ID: '#nombre_expediente', NAME: "nombre_expediente", KEY: 'Nombre de expediente'},
        {ID: '#expediente', NAME: "expediente", KEY: 'Expediente', TYPE: 'pdf'},
        {ID: '#nombre_archivo_imss', NAME: "nombre_alta", KEY: 'Nombre de archivo IMSS'},
        {ID: '#alta_imss_empleado', NAME: "pdf_alta", KEY: 'Alta del IMSS', TYPE: 'pdf'},
        {ID: '#nombre_archivo_nomina', NAME: "nombre_nomina", KEY: 'Nombre de archivo nomina'},
        {ID: '#nomina', NAME: "pdf_nomina", KEY: 'Nomina', TYPE: 'pdf'},
        {ID: '#nombre_vacaciones', NAME: "nombre_vacaciones", KEY: 'Nombre del archivo vacaciones'},
        {ID: '#formato_vacaciones', NAME: "pdf_vacaciones", KEY: 'Formato vacaciones', TYPE: 'pdf'}
    ]
    return inputs
}


/// Creamos el Json con los datos de los inputs
function CrearJsonEmpleado(data) {
    const empleado = {
        "codigo": data.codigo || "",
        "fecha_ingreso": data.fecha_ingreso || "",
        "puesto": data.puesto || "",
        "correo_electronico": data.correo_electronico || "",
        "estatus": data.estatus || "",
        "comentario": data.comentario || "",
        "nombre_expediente": data.nombre_expediente || "",
        "expediente": data.expediente || [],
        "nombre_nomina": data.nombre_nomina || "",
        "pdf_nomina": data.pdf_nomina || [],
        "nombre_alta": data.nombre_alta || "",
        "pdf_alta": data.pdf_alta || [],
        "nombre_vacaciones": data.nombre_vacaciones || "",
        "pdf_vacaciones": data.pdf_vacaciones || [],
        "tipo_vehiculo": data.tipo_vehiculo || "",
        "num_placa": data.num_placa || "",
        "Persona": {
            "nombre": data.nombre || "",
            "apellido_paterno": data.apellido_paterno || "",
            "apellido_materno": data.apellido_materno || "",
            "genero": data.genero || "",
            "fecha_nacimiento": data.fecha_nacimiento || "",
            "rfc": data.rfc || "",
            "curp": data.curp || "",
            "domicilio": data.domicilio || "",
            "codigo_postal": data.codigo_postal || "",
            "ciudad": data.ciudad || "",
            "estado": data.estado || "",
            "telefono": data.telefono || "",
            "foto": data.foto || "",
            "numero_licencia": data.numero_licencia || "",
            "tipo_licencia": data.tipo_licencia || ""
        },
        "Usuario": {
            "nombre_usuario": data.nombre_usuario || "",
            "contrasenia": data.contrasenia || "",
            "rol": data.rol || ""
        }
    }
    return empleado;
}

/// TERMINAR LAS DEMAS FUNCIONES

// function obtenerDatosEmpleado() {
//     // Datos de Persona
//     let id_persona = document.getElementById("idPersona").value;
//     let nombres = document.getElementById("nombre").value;
//     let apellidoPaterno = document.getElementById("a_Paterno").value;
//     let apellidoMaterno = document.getElementById("a_Materno").value;
//     let genero = document.getElementById("genero").value;
//     let fechaNacimientoInput = document.getElementById("fecha_nacimiento");

//     // Convertir la fecha de nacimiento en un formato ISO adecuado
//     let fechaNacimiento = new Date(fechaNacimientoInput.value);
//     let fechaNacimientoComoString = fechaNacimiento.toISOString().split('T')[0];

//     let rfc = document.getElementById("rfc").value;
//     let curp = document.getElementById("curp").value;
//     let domicilio = document.getElementById("domicilio").value;
//     let codigoPostal = document.getElementById("cp").value;
//     let ciudad = document.getElementById("ciudad").value;
//     let estado = document.getElementById("estado").value;
//     let telefono = document.getElementById("telefono").value;
//     let numLicencia = document.getElementById("numero_licencia").value;
//     let tipoLicencia = document.getElementById("tipo_licencia").value;
//     let foto = document.getElementById("textoFoto").value;

//     // Crear objeto Persona
//     let persona = {
//         id_persona: parseInt(id_persona), nombre: nombres, a_paterno: apellidoPaterno, a_materno: apellidoMaterno, genero: genero, fecha_nacimiento: fechaNacimientoComoString,
//         rfc: rfc, curp: curp, domicilio: domicilio, codigo_postal: codigoPostal, ciudad: ciudad, estado: estado, telefono: telefono, foto: foto, numero_licencia: numLicencia,
//         tipo_licencia: tipoLicencia
//     };

//     // Datos de Usuario
//     let idUsuario = document.getElementById("idUsuario").value;
//     let nombreU = document.getElementById("usuario").value;
//     let contrasenia = document.getElementById("contrasenia").value;
//     let rol = document.getElementById("rol").value;

//     // Crear objeto Usuario
//     let usuario = {
//         id_usuario: parseInt(idUsuario), nombre_usuario: nombreU,
//         contrasenia: contrasenia, rol: rol
//     };

//     // Datos de Empleado
//     let idEmpleado = document.getElementById("idEmpleado").value;
//     let codigo = document.getElementById("codigoEmpleado").value;
//     let fechaIngreso = document.getElementById("fecha_ingreso").value;
//     let puesto = document.getElementById("puesto").value;
//     let correo = document.getElementById("correo").value;
//     let estatus = document.getElementById("estatus").value;
//     let comentario = document.getElementById("comentario").value;
//     let nomExpediente = document.getElementById("nombre_expediente").value;
//     let expediente = document.getElementById("expediente").value;
//     let tipoVehiculo = document.getElementById("tipo_vehiculo").value;
//     let numPlaca = document.getElementById("num_placa").value;

//     // Crear objeto Empleado
//     let empleado = {
//         id_empleado: parseInt(idEmpleado), codigo: codigo, fecha_ingreso: fechaIngreso, puesto: puesto,
//         correo_electronico: correo, estatus: parseInt(estatus), comentario: comentario, nombre_expediente: nomExpediente,
//         expediente: expediente, tipo_vehiculo: tipoVehiculo, num_placa: numPlaca, id_persona: parseInt(id_persona), id_usuario: parseInt(idUsuario)
//     };

//     // Parámetros para enviar al servidor
//     let params = {
//         e: JSON.stringify(empleado),
//         p: JSON.stringify(persona),
//         u: JSON.stringify(usuario)
//     };

//     let ruta = "http://localhost:8080/MONBA-PAGINA/api/empleado/insert?";

//     // Fetch para enviar la solicitud al servidor
//     fetch(ruta, {
//         method: "POST",
//         headers: {
//             'Content-Type': 'application/x-www-form-urlencoded;charset=UTF-8'
//         },
//         body: new URLSearchParams(params)
//     })
//         .then(response => response.json())
//         .then(response => {
//             if (response.result) {
//                 Swal.fire(response.result, "¡Inserción Correcta!", "success");
//             } else if (response.error) {
//                 Swal.fire(response.result, "Problemas al Insertar", "error");
//             }
//             cargarCatEmpleado();
//         });
// }

// function eliminarEmpleado(i) {
//     let id_empleado = empleados[i].id_empleado;

//     fetch("http://localhost:8080/monba/api/empleado/delete?id_empleado=" + id_empleado)
//         .then(response => response.json())
//         .then(response => {
//             Swal.fire(response.result, "Empleado eliminado con éxito", "success");
//             cargarCatEmpleado();
//         });
// }
// function activarEmpleado(i) {
//     let id_empleado = empleados[i].id_empleado;

//     fetch("http://localhost:8080/sicefasucursal/api/empleado/activar?idE=" + id_empleado)
//         .then(response => response.json())
//         .then(response => {
//             Swal.fire(response.result, "Empleado activado con éxito", "success");
//             cargarCatEmpleado();
//         });
// }
// function buscarEmpleados() {
//     // Obtén el valor de búsqueda desde el campo de entrada
//     let input = document.getElementById("inputBusqueda").value.toLowerCase();

//     // Filtra los empleados en base al valor de búsqueda
//     let empleadosFiltrados = empleados.filter(empleado => {

//         let datosEmpleado = `${empleado.codigo} ${empleado.fecha_ingreso} ${empleado.puesto} ${empleado.correo_electronico} ${empleado.num_placa} ${empleado.tipo_vehiculo} ${empleado.persona.nombre} ${empleado.persona.a_paterno} ${empleado.persona.a_materno} ${empleado.persona.fecha_nacimiento} ${empleado.persona.rfc} ${empleado.persona.curp} ${empleado.persona.domicilio} ${empleado.persona.codigo_postal} ${empleado.persona.ciudad} ${empleado.persona.estado} ${empleado.persona.telefono} ${empleado.usuario.nombre_usuario} ${empleado.usuario.rol}`.toLowerCase();

//         // Devuelve true si alguna parte de los datos coincide con la búsqueda
//         return datosEmpleado.includes(input);
//     });

//     mostrarEmpleados(empleadosFiltrados);
// }