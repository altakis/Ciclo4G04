// Consultar todos los registros

function findAll() {
    $.ajax({
        url: 'http://132.145.204.101:8180/api/departments',
        method: "GET",
        headers: {
            "Content-Type": "application/json"
        }
    }).done(function (items) {
        var registros = "";
        items.forEach(function (item, index, array) {
            registros += `
                        <tr class="table-active">                        
                            <td>`+ item.codigo + `</td>
                            <td>`+ item.nombre + `</td>
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
        url: 'http://132.145.204.101:8180/api/departments/' + id,
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
            $('#codigo').val(item.codigo),
            $('#nombre').val(item.nombre),
            $('#estado').val(item.estado == true ? 1 : 0)
    })
}

// Consultar registro por ID
function deleteById(id) {
    bandera = true;
    $.ajax({
        url: 'http://132.145.204.101:8180/api/cities',
        method: "GET",
        headers: {
            "Content-Type": "application/json"
        }
    }).done(function (items) {
        items.forEach(function (item, index, array) {
            if (item.departmentId.id == id) {
                bandera = false;
            }
        })
        if (bandera == false) {
            mensajeEliminar('http://132.145.204.101:8180/api/departments/' + id, false);
            return true;
        } else {
            mensajeEliminar('http://132.145.204.101:8180/api/departments/' + id, true);
            return true;
        }
    })

}

//Accion de adicionar un registro
function addData() {
    $.ajax({
        url: 'http://132.145.204.101:8180/api/departments',
        data: JSON.stringify({
            codigo: $("#codigo").val(),
            nombre: $("#nombre").val(),
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
    rutaApi = 'http://132.145.204.101:8180/api/departments/' + $('#id').val();
    dataJson = {
        codigo: $("#codigo").val(),
        nombre: $("#nombre").val(),
        estado: parseInt($("#estado").val())
    };
    mensajeUpdate(rutaApi, dataJson);
}
function clearData() {
    $('#id').val(''),
        $('#codigo').val(''),
        $('#nombre').val(''),
        $('#estado').val('')
}