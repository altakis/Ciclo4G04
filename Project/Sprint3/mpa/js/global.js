function mensajeEliminar(rutaApi, bandera) {
    if (bandera == true) {
        Swal.fire({
            title: '¿Esta seguro de eliminar el registro?',
            text: "¡Eliminar registro!",
            icon: 'warning',
            showCancelButton: true,
            confirmButtonColor: '#3085d6',
            cancelButtonColor: '#d33',
            confirmButtonText: 'Si, eliminar registro!'
        }).then((result) => {
            if (result.isConfirmed) {
                // Aquí autoriza eliminar registro
                $.ajax({
                    url: rutaApi,
                    method: "DELETE",
                    headers: {
                        "Content-Type": "application/json"
                    }
                }).done(function (item) { })

                Swal.fire(
                    'Eliminado!',
                    'Registro eliminado con éxito.',
                    'success'
                )
                findAll();
                clearData();
            }
        })
    } else {
        Swal.fire({
            icon: 'error',
            title: 'Oops...',
            text: 'El registro pertenece a una referencia!'            
        })
    }
}

function mensajeExito(mensaje) {
    Swal.fire({
        icon: 'success',
        title: mensaje,
        showConfirmButton: false,
        timer: 1500
    })
}


function mensajeUpdate(rutaApi) {
    Swal.fire({
        title: '¿Desea guardar los cambios?',
        showDenyButton: true,
        showCancelButton: true,
        confirmButtonText: 'Save',
        denyButtonText: `Don't save`,
    }).then((result) => {
        /* Read more about isConfirmed, isDenied below */
        if (result.isConfirmed) {
            $.ajax({
                url: rutaApi,
                data: JSON.stringify(dataJson),
                method: "PUT",
                headers: {
                    "Content-Type": "application/json"
                }
            }).done(function (result) {
                findAll();
            })
            Swal.fire('Datos actualizados', '', 'success')
        } else if (result.isDenied) {
            Swal.fire('Cancelar, no guardar cambios', '', 'info')
        }
        clearData();
    })
}