export async function getInputValues(inputs) {
    const result = {};

    for (const input of inputs) {
        const element = document.querySelector(input.ID);

        if (element) {
            if (element.type === 'file') {
                if (element.files.length > 0) {
                    const fileReaded = element.files[0];

                    result[input.KEY] = await convertToBase64(fileReaded);
                } else {
                    result[input.KEY] = "NADA";
                }
            } else {
                result[input.KEY] = element.value;
            }
        }
    }
    return result;
}

function convertToBase64(file) {
    return new Promise((resolve, reject) => {
        if (file) {
            if (getFileSize(file) <= 5) {
                const reader = new FileReader();

                reader.onload = function (e) {
                    resolve(e.target.result);
                };

                reader.onerror = function (error) {
                    reject(error);
                };

                reader.readAsDataURL(file);
            } else {
                reject('File size exceeds 5MB limit.');
            }
        } else {
            reject('No file provided.');
        }
    });
}

function getFileSize(file) {
    let fileSizeInBytes = file.size
    let fileSizeInKB = (fileSizeInBytes / 1024).toFixed(2)
    let fileSizeInMB = (fileSizeInKB / 1024).toFixed(2)
    return fileSizeInMB
}