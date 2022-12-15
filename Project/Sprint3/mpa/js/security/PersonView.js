// Consultar todos los registros

function findAll() {
    $.ajax({
        url: 'http://132.145.204.101:8180/api/persons',
        method: "GET",
        headers: {
            "Content-Type": "application/json"
        }
    }).done(function (items) {
        var registros = "";
        items.forEach(function (item, index, array) {
            registros += `
                        <tr class="table-active">                        
                            <td>`+item.tipoDocumento+`</td>
                            <td>`+item.documento+`</td>
                            <td>`+item.primerNombre+`</td>
                            <td>`+item.segundoNombre+`</td>
                            <td>`+item.primerApellido+`</td>
                            <td>`+item.segundoApellido+`</td>
                            <td>`+item.correo+`</td>
                            <td>`+item.telefono+`</td>
                            <td>`+item.fechaNacimiento+`</td>
                            <td>`+item.direccion+`</td> 
                            <td>`+item.usuarioId.usuario+`</td> 
                            <td>`+item.ciudadId.nombre+`</td>                        
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
        url: 'http://132.145.204.101:8180/api/persons/' + id,
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
        $('#tipoDocumento').val(item.tipoDocumento),
        $('#documento').val(item.documento),
        $('#primerNombre').val(item.primerNombre),
        $('#segundoNombre').val(item.segundoNombre),
        $('#primerApellido').val(item.primerApellido),
        $('#segundoApellido').val(item.segundoApellido),
        $('#correo').val(item.correo),
        $('#telefono').val(item.telefono),
        $('#fechaNacimiento').val(item.fechaNacimiento),
        $('#direccion').val(item.direccion),
        $('#usuarioId').val(item.usuarioId.id),
        $('#ciudadId').val(item.ciudadId.id),
        $('#estado').val(item.estado == true ? 1 : 0)
    })
}

// Consultar registro por ID
function deleteById(id) {
    mensajeEliminar('http://132.145.204.101:8180/api/persons/' + id,true);
}

//Accion de adicionar un registro
function addData() {
    $.ajax({
        url: 'http://132.145.204.101:8180/api/persons',
        data: JSON.stringify({
            tipoDocumento: $('#tipoDocumento').val(),
            documento: $('#documento').val(),
            primerNombre: $('#primerNombre').val(),
            segundoNombre: $('#segundoNombre').val(),
            primerApellido: $('#primerApellido').val(),
            segundoApellido: $('#segundoApellido').val(),
            correo: $('#correo').val(),
            telefono: $('#telefono').val(),
            fechaNacimiento: $('#fechaNacimiento').val(),
            direccion: $('#direccion').val(),                 
            usuarioId: {
                id: $("#usuarioId").val()
            },
            ciudadId: {
                id: $("#ciudadId").val()
            },
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
    rutaApi = 'http://132.145.204.101:8180/api/persons/' + $('#id').val();
    dataJson = {
        tipoDocumento: $('#tipoDocumento').val(),
        documento: $('#documento').val(),
        primerNombre: $('#primerNombre').val(),
        segundoNombre: $('#segundoNombre').val(),
        primerApellido: $('#primerApellido').val(),
        segundoApellido: $('#segundoApellido').val(),
        correo: $('#correo').val(),
        telefono: $('#telefono').val(),
        fechaNacimiento: $('#fechaNacimiento').val(),
        direccion: $('#direccion').val(),                 
        usuarioId: {
            id: $("#usuarioId").val()
        },
        ciudadId: {
            id: $("#ciudadId").val()
        },
        estado: parseInt($("#estado").val())
    };
    mensajeUpdate(rutaApi, dataJson);
}
function clearData() {
    $('#id').val(''),
    $('#tipoDocumento').val(''),
    $('#documento').val(''),
    $('#primerNombre').val(''),
    $('#segundoNombre').val(''),
    $('#primerApellido').val(''),
    $('#segundoApellido').val(''),
    $('#correo').val(''),
    $('#telefono').val(''),
    $('#fechaNacimiento').val(''),
    $('#direccion').val('')  
}