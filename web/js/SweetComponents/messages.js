export function questionMessage(title, text) {
    Swal.fire({
        title: title,
        text: text,
        icon: "question"
    })
}

export function errorMessage(title, text, footer = '') {
    Swal.fire({
        icon: "error",
        title: title,
        text: text,
        footer: footer
    })
}

export function successMessage(icon, title) {
    Swal.fire({
        position: "top-end",
        icon: icon,
        title: title,
        showConfirmButton: false,
        timer: 1500
    })
}