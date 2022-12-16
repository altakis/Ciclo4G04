function Auth(){

    $.ajax({
        url: 'http://132.145.204.101:8180/api/users',
        method: "GET",
        headers: {
            "Content-Type": "application/json"
        }
    }).done(function (items) {        
        let usuario = $("#usuario").val()
        let contrasenia = $("#contrasenia").val()
        let bandera = false;
        items.forEach(function (item, index, array) {
            if(item.usuario == usuario && item.contrasenia == contrasenia ){
                bandera = true;
                window.location.assign("view/dashboard.html");
                localStorage.setItem('auth', 'true');
            }
        })

        if(bandera=='true'){
            alert("¡Bienvenido!");
        }else{
            alert("Sin autorizacion");
            $("#usuario").val('')
            $("#contrasenia").val('')
        }
    })
}
function CerrarSesion(){
    window.location.assign("../index.html");
    localStorage.setItem('auth', 'false');
}


function LoadData(){
    
    if(localStorage.getItem("auth") !='true'){        
        CerrarSesion();
    }
}
