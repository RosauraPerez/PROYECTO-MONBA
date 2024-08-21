import * as API from './API/api_functions.js'
import * as MSG from './SweetComponents/messages.js'

const DATA = Array.from(await getAllData())

startModule()

function startModule() {
    loadEmployeesOnTable()
}

function loadEmployeesOnTable() {
    const table = document.querySelector('#tableBody')

    DATA.forEach(employee => {
        let cell = document.createElement('tr')
        let nameContainer = document.createElement('th')
        nameContainer.textContent = employee.Persona.nombre

        let firstNameContainer = document.createElement('th')
        firstNameContainer.textContent = employee.Persona.apellido_paterno

        let secondNameContainer = document.createElement('th')
        secondNameContainer.textContent = employee.Persona.apellido_materno

        let jobContainer = document.createElement('th')
        jobContainer.textContent = employee.puesto

        let buttonContainer = document.createElement('th')
        let buttonActivate = document.createElement('button')
        buttonActivate.classList.add('btn', 'btn-success', 'btn-md', 'font-weight-bold')
        buttonActivate.textContent = 'Activar'

        buttonActivate.onclick = () => activateEmployee(employee.id_empleado)

        buttonContainer.appendChild(buttonActivate)

        cell.appendChild(nameContainer)
        cell.appendChild(firstNameContainer)
        cell.appendChild(secondNameContainer)
        cell.appendChild(jobContainer)
        cell.appendChild(buttonContainer)
        table.appendChild(cell)
    })
}

async function activateEmployee(idEmployee) {
    const URL = 'http://localhost:8080/PROYECTO-MONBA/api/empleado/activar'

    const object = {
        id_empleado: idEmployee
    }

    const apiResponse = await API.sendData(URL, 'id_empleado', object)

    if (apiResponse.response == 'OK') {
        const indexToDelete = DATA.findIndex(employee => employee.id_empleado === idEmployee)
        removeEmployeeFromList(indexToDelete)
        MSG.successMessage('success', 'El empleado se activo con exito')
        loadEmployeesOnTable()
    } else {
        MSG.successMessage('error', 'No se pudo activar el empleado')
    }

}

function removeEmployeeFromList(index) {
    DATA.splice(index, 1)
}

async function getAllData() {
    const URL = 'http://localhost:8080/PROYECTO-MONBA/api/empleado/getAll?estatus=false'

    return await API.getData(URL)
}