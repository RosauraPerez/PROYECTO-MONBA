function getQueryParameter(name) {
    const urlParams = new URLSearchParams(window.location.search);
    return urlParams.get(name);
}

function verificar() {
    var token = localStorage.getItem('token');
    if (!token) {
        window.location.href = 'http://localhost:8080/MONBA-PAGINA/';
    }
}
document.addEventListener('DOMContentLoaded', function () {
    verificar();
});
