let remisiones = [];

function cargarCatRemisiones() {
    const mostrarInactivas = document.getElementById("checkEstatus").checked;
    const id_empleado = localStorage.getItem('id_empleado');
    const url = mostrarInactivas
            ? "http://localhost:8080/MONBA-PAGINA/api/remision/getAll?estatus=false&id_empleado="+id_empleado
            : "http://localhost:8080/MONBA-PAGINA/api/remision/getAll?estatus=true&id_empleado="+id_empleado;

    fetch(url)
            .then(response => response.json())
            .then(response => {
                remisiones = response;
                mostrarRemisiones(remisiones);
            });
}
function mostrarRemisiones(remisones) {
    let mostrar = "";
    remisones.forEach((remision) => {
        mostrar += `
            <tr>
                <td>${remision.id_remision}</td>
                <td>${remision.residuo}</td>
                <td>${remision.cantidad}</td>
                <td>${remision.unidad}</td>
                <td>${remision.tipo_contenedor}</td>
                <td>${remision.volumen}</td>
                <td>${remision.empresa_cliente}</td>
                <td>${remision.empresa_destino}</td>
                <td>${remision.fecha}</td>
                <td>
                    <button class='btn btn-warning btn-md font-weight-bold' 
                            type='button' 
                            data-toggle='modal' 
                            data-target='#modificarRemision' 
                            onclick='seleccionarRemision(${remision.id_remision});'
                            ${remision.estatus === 0 ? 'disabled' : ''}>
                        <i class='bi bi-pencil-square fa-lg'></i> Seleccionar
                    </button>
                </td>
                <td>
                    ${remision.estatus === 0
                ? `<button class='btn btn-danger btn-md font-weight-bold'>CANCELADA</button>`
                : `<button class='btn btn-danger btn-md font-weight-bold' onclick='cancelarRemison(${remision.id_remision});'><i class='bi bi-trash3-fill fa-lg'></i> Cancelar</button>`}
                </td>
            </tr>`;
    });
    document.getElementById("tblRemisiones").innerHTML = mostrar;
}
function buscarRemision() {
    const terminoBusqueda = document.getElementById("buscarRemision").value.toLowerCase();
    const remisionesFiltradas = remisiones.filter(generador => {
        return Object.values(generador).some(value =>
            value.toString().toLowerCase().includes(terminoBusqueda)
        );
    });
    mostrarRemisiones(remisionesFiltradas);
}
function seleccionarRemision(id_remision) {
    const remision = remisiones.find(remision => remision.id_remision === id_remision);
    if (remision) {
        document.getElementById("id_remision_1").value = remision.id_remision;
        document.getElementById("residuo_1").value = remision.residuo;
        document.getElementById("cantidad_1").value = remision.cantidad;
        document.getElementById("unidad_1").value = remision.unidad;
        document.getElementById("tipo_contenedor_1").value = remision.tipo_contenedor;
        document.getElementById("volumen_1").value = remision.volumen;
        document.getElementById("empresa_generadora_1").value = remision.Empresa_gen.id_empresa;
        document.getElementById("destino_final_1").value = remision.Empresa_des.id_empresa;
        document.getElementById("fecha_1").value = remision.fecha;
    }
}

function limpiarFormulario() {
    document.getElementById("residuo").value = "";
    document.getElementById("cantidad").value = "";
    document.getElementById("unidad").value = "";
    document.getElementById("tipo_contenedor").value = "";
    document.getElementById("volumen").value = "";
    document.getElementById("empresa_generadora").value = "0";
    document.getElementById("destino_final").value = "0";
    document.getElementById("fecha").value = "";
}

function cancelarRemison(id_remision) {
    Swal.fire({
        title: '¿Estás seguro?',
        text: "¡No podrás deshacer esta acción!",
        icon: 'warning',
        showCancelButton: true,
        confirmButtonColor: '#3085d6',
        cancelButtonColor: '#d33',
        confirmButtonText: 'Sí, Cancelar',
        cancelButtonText: 'Regresar'
    }).then(result => {
        if (result.isConfirmed) {
            fetch(`http://localhost:8080/MONBA-PAGINA/api/remision/cancelar?id_remision=${id_remision}`)
                    .then(response => response.json())
                    .then(response => {
                        Swal.fire('¡Cencelada!', '¡Remisión Cancelada Exitosamente!', 'success');
                        cargarCatRemisiones();
                    })
                    .catch(() => Swal.fire('Error', 'Ocurrió un error al cancelar la Remisión', 'error'));
        }
    });
}

function cargarGeneradores() {
    fetch("http://localhost:8080/MONBA-PAGINA/api/generador/getAll?estatus=true").
            then(response => response.json()).
            then(response => {
                let generadores = response;
                let datos_gen = "";
                datos_gen += "<option value='0' disabled selected>";
                datos_gen += "Selecciona el Generador";
                datos_gen += "</option>";
                for (let i = 0; i < generadores.length; i++) {
                    datos_gen += "<option value='" + generadores[i].id_empresa + "'>";
                    datos_gen += generadores[i].nombre;
                    datos_gen += "</option>";
                }
                document.getElementById("empresa_generadora").innerHTML = datos_gen;
                document.getElementById("empresa_generadora_1").innerHTML = datos_gen;
            });
}

function cargarDestinos() {
    fetch("http://localhost:8080/MONBA-PAGINA/api/destino/getAll?estatus=true").
            then(response => response.json()).
            then(response => {
                let destinos = response;
                let datos_des = "";
                datos_des += "<option value='0' disabled selected>";
                datos_des += "Selecciona el Destino";
                datos_des += "</option>";
                for (let i = 0; i < destinos.length; i++) {
                    datos_des += "<option value='" + destinos[i].id_empresa + "'>";
                    datos_des += destinos[i].nombre;
                    datos_des += "</option>";
                }
                document.getElementById("destino_final").innerHTML = datos_des;
                document.getElementById("destino_final_1").innerHTML = datos_des;
            });
}

function registrarRemision() {
    let residuo = document.getElementById("residuo").value;
    let cantidad = document.getElementById("cantidad").value;
    let unidad = document.getElementById("unidad").value;
    let tipo_contenedor = document.getElementById("tipo_contenedor").value;
    let volumen = document.getElementById("volumen").value;

    let generadorSelect = document.getElementById("empresa_generadora");
    let id_generador = generadorSelect.value;
    let generador = generadorSelect.options[generadorSelect.selectedIndex].text;

    let destinoSelect = document.getElementById("destino_final");
    let id_destino = destinoSelect.value;
    let destino = destinoSelect.options[destinoSelect.selectedIndex].text;

    let fecha = document.getElementById("fecha").value;
    let id_empleado = 1;

    let remision = {
        residuo: residuo,
        cantidad: parseFloat(cantidad),
        unidad: unidad,
        tipo_contenedor: tipo_contenedor,
        volumen: volumen,
        empresa_cliente: generador,
        empresa_destino: destino,
        fecha: fecha,
        Empleado: {
            id_empleado: id_empleado
        },
        Empresa_gen: {
            id_empresa: id_generador
        },
        Empresa_des: {
            id_empresa: id_destino
        }
    };

    let params = {r: JSON.stringify(remision)};
    let ruta = "http://localhost:8080/MONBA-PAGINA/api/remision/registrar";

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
                        cargarCatRemisiones();
                        limpiarFormulario();
                    });
        }
    });
}

function modificarRemision() {
    let id_remision = document.getElementById("id_remision_1").value;
    let residuo = document.getElementById("residuo_1").value;
    let cantidad = document.getElementById("cantidad_1").value;
    let unidad = document.getElementById("unidad_1").value;
    let tipo_contenedor = document.getElementById("tipo_contenedor_1").value;
    let volumen = document.getElementById("volumen_1").value;

    let generadorSelect = document.getElementById("empresa_generadora_1");
    let id_generador = generadorSelect.value;
    let generador = generadorSelect.options[generadorSelect.selectedIndex].text;

    let destinoSelect = document.getElementById("destino_final_1");
    let id_destino = destinoSelect.value;
    let destino = destinoSelect.options[destinoSelect.selectedIndex].text;

    let fecha = document.getElementById("fecha_1").value;
    let id_empleado = 1;

    let remision = {
        id_remision: id_remision,
        residuo: residuo,
        cantidad: parseFloat(cantidad),
        unidad: unidad,
        tipo_contenedor: tipo_contenedor,
        volumen: volumen,
        empresa_cliente: generador,
        empresa_destino: destino,
        fecha: fecha,
        Empleado: {
            id_empleado: id_empleado
        },
        Empresa_gen: {
            id_empresa: id_generador
        },
        Empresa_des: {
            id_empresa: id_destino
        }
    };

    let params = {r: JSON.stringify(remision)};
    let ruta = "http://localhost:8080/MONBA-PAGINA/api/remision/modificar";

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
                        cargarCatRemisiones();
                    });
        }
    });
}