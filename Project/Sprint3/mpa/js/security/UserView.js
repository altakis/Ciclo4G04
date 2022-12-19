// Consultar todos los registros

function findAll() {
    $.ajax({
        url: 'http://132.145.204.101:8080/api/users',
        method: "GET",
        headers: {
            "Content-Type": "application/json"
        }
    }).done(function (items) {
        var registros = "";
        items.forEach(function (item, index, array) {
            registros += `
                        <tr class="table-active">                        
                            <td>`+ item.usuario + `</td>
                            <td>****</td>
                            <td>`+ (item.estado == true ? 'Activo' : 'Inactivo') + `</td>
                            <td><img src="../../asset/library/node_modules/bootstrap-icons/icons/arrow-90deg-up.svg" onclick="findById('`+ item.id + `')"></td>
                            <td><img src="../../asset/library/node_modules/bootstrap-icons/icons/x-circle-fill.svg" onclick="deleteById('`+ item.id + `')"></td>
                        </tr>
                            `;
        })
        $("#dataResult").html(registros);
    })
}

// Consultar registro por ID
function findById(id) {
    $.ajax({
        url: 'http://132.145.204.101:8080/api/users/' + id,
        method: "GET",
        headers: {
            "Content-Type": "application/json"
        }
    }).done(function (item) {
        Swal.fire({
            icon: 'success',
            title: 'Datos disponibles para edición',
            showConfirmButton: false,
            timer: 1500
        })
        $('#id').val(item.id),
            $('#usuario').val(item.usuario),
            // $('#contrasenia').val(item.contrasenia),
            $('#estado').val(item.estado == true ? 1 : 0)
    })
}

// Consultar registro por ID
function deleteById(id) {
    bandera = true;
    $.ajax({
        url: 'http://132.145.204.101:8080/api/persons',
        method: "GET",
        headers: {
            "Content-Type": "application/json"
        }
    }).done(function (items) {
        items.forEach(function (item, index, array) {
            if (item.usuarioId.id == id) {
                bandera = false;
            }
        })
        if (bandera == false) {
            mensajeEliminar('http://132.145.204.101:8080/api/users/' + id, false);
            return true;
        } else {
            mensajeEliminar('http://132.145.204.101:8080/api/users/' + id, true);
            return true;
        }        
    })

}

//Accion de adicionar un registro
function addData() {
    $.ajax({
        url: 'http://132.145.204.101:8080/api/users',
        data: JSON.stringify({
            usuario: $("#usuario").val(),
            contrasenia: $("#contrasenia").val(),
            estado: parseInt($("#estado").val())
        }),
        method: "POST",
        headers: {
            "Content-Type": "application/json"
        }
    }).done(function (result) {
        mensajeExito('Registro agreado con éxito');
        findAll();
        clearData();
    })
}

//Accion de actualizar un registro
function updateData() {
    rutaApi = 'http://132.145.204.101:8080/api/users/' + $('#id').val();
    dataJson = {
        usuario: $("#usuario").val(),
        contrasenia: $("#contrasenia").val(),
        estado: parseInt($("#estado").val())
    };
    mensajeUpdate(rutaApi, dataJson);
}
function clearData() {
    $('#id').val(''),
        $('#usuario').val(''),
        $('#contrasenia').val(''),
        $('#estado').val('')
}