function findAllDepartamentos() {
    $.ajax({
        url: 'http://132.145.204.101:8180/api/departments',
        method: "GET",
        headers: {
            "Content-Type": "application/json"
        }
    }).done(function (items) {
        var listData = "<option disabled selected='true' >-- Seleccione --</option>";
        items.forEach(function (item, index, array) {
            listData += `<option value='`+item.id+`'>`+item.nombre+`</option>`;
        })
        $("#departmentId").html(listData);
    })
}

function findAllCiudades() {
    $.ajax({
        url: 'http://132.145.204.101:8180/api/cities',
        method: "GET",
        headers: {
            "Content-Type": "application/json"
        }
    }).done(function (items) {
        var listData = "<option disabled selected='true' >-- Seleccione --</option>";
        items.forEach(function (item, index, array) {
            listData += `<option value='`+item.id+`'>`+item.nombre+`</option>`;
        })
        $("#ciudadId").html(listData);
    })
}

function findAllUsuarios() {
    $.ajax({
        url: 'http://132.145.204.101:8180/api/users',
        method: "GET",
        headers: {
            "Content-Type": "application/json"
        }
    }).done(function (items) {
        var listData = "<option disabled selected='true' >-- Seleccione --</option>";
        items.forEach(function (item, index, array) {
            listData += `<option value='`+item.id+`'>`+item.usuario+`</option>`;
        })
        $("#usuarioId").html(listData);
    })
}