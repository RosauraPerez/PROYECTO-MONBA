/// Mensaje de pregunta
export function questionMessage(title, text) {
    Swal.fire({
        title: title,
        text: text,
        icon: "question"
    })
}

/// Mensaje de error
export function errorMessage(title, text, footer = '') {
    Swal.fire({
        icon: "error",
        title: title,
        text: text,
        footer: footer
    })
}

/// Mensaje de exito o error
export function successMessage(icon = 'success', title) {
    Swal.fire({
        position: "center",
        icon: icon,
        title: title,
        showConfirmButton: false,
        timer: 1500
    })
}



