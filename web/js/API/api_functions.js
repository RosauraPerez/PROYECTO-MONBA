import * as msg from "../SweetComponents/messages.js"

export async function getData(url) {
    try {
        const response = await fetch(url)
        const json = await response.json()
        return json
    } catch (error) {
        msg.successMessage('error', 'Error al obtener los datos del servidor')
    }
}

export async function sendData(url, param, object) {
    const formData = new URLSearchParams()
    formData.append(param, JSON.stringify(object))

    const requestOptions = {
        method: 'POST',
        headers: {
            'Content-Type': 'application/x-www-form-urlencoded'
        },
        body: formData
    }

    try {
        const response = await fetch(url, requestOptions)
        
        const jsonResponse = await response.json()
        
        return jsonResponse
    } catch (error) {
        alert("Error al guardar los datos, intentelo nuevamente")
    }
}