// Consultar todos los registros
function findAll(){
    $.ajax({
        url: 'http://132.145.204.101:8180/api/departments',
        method: "GET",
        headers: {
            "Content-Type": "application/json"
        }
    }).done(function (items) {
        var registros = "";
        items.forEach(function (item, index, array) {     
            registros +=`
                        <tr class="table-active">                        
                            <td>`+item.codigo+`</td>
                            <td>`+item.nombre+`</td>
                            <td>`+(item.estado==true?'Activo':'Inactivo')+`</td>
                            <td><img src="../../asset/library/node_modules/bootstrap-icons/icons/arrow-90deg-up.svg" onclick="findById(`+item.id+`)"></td>
                            <td><img src="../../asset/library/node_modules/bootstrap-icons/icons/x-circle-fill.svg" onclick="findById(`+item.id+`)"></td>
                        </tr>
                            `;
        })
        $("#dataResult").html(registros);               
    })
}