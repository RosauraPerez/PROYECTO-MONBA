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