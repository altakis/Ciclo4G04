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