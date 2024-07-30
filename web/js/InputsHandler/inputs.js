/// Funcion para obtner los valores de los inputs a partir del Json y devolverlos en otro Json
export async function getInputValues(inputs) {
    const result = {};

    for (const input of inputs) {
        const element = document.querySelector(input.ID);

        if (element) {
            if (element.type === 'file') {
                if (element.files.length > 0) {
                    const fileReaded = element.files[0];

                    result[input.NAME] = await convertToBase64(fileReaded);
                } else {
                    result[input.NAME] = ""; // En caso de input vacio
                }
            } else {
                result[input.NAME] = element.value;
            }
        }
    }
    return result;
}

/// Convertir archivos a base64
function convertToBase64(file) {
    const MAX_FILE_SIZE = 5 // 5MB de peso maximo por archivo

    return new Promise((resolve, reject) => {
        if (file) {
            if (getFileSize(file) <= MAX_FILE_SIZE) {
                const reader = new FileReader();

                reader.onload = function (e) {
                    resolve(e.target.result);
                };

                reader.onerror = function (error) {
                    reject(error);
                };

                reader.readAsDataURL(file);
            } else {
                reject('Tamaño de archivo mayor a 5MB.');
            }
        } else {
            reject('Ningun archivo agregado.');
        }
    });
}

/// Obtener el peso del archivo
function getFileSize(file) {
    let fileSizeInBytes = file.size
    let fileSizeInKB = (fileSizeInBytes / 1024).toFixed(2)
    let fileSizeInMB = (fileSizeInKB / 1024).toFixed(2)
    return fileSizeInMB
}