// Datos de continentes

{ "_id" : ObjectId("63876a0fd79cbe5bea052630"), "codigo" : "01", "nombre" : "America del Sur", "estado" : 1 }
{ "_id" : ObjectId("63876a9ad79cbe5bea052631"), "codigo" : "03", "nombre" : "Asia", "estado" : 1 }
{ "_id" : ObjectId("63876a9ad79cbe5bea052632"), "codigo" : "04", "nombre" : "Oseania", "estado" : 1 }
{ "_id" : ObjectId("63876a9ad79cbe5bea052633"), "nombre" : "Europa", "estado" : 1 }
{ "_id" : ObjectId("63876bd8d79cbe5bea052635"), "codigo" : "01", "nombre" : "America del Sur", "estado" : true }


// Comando para eliminar 
db.Continentes.remove(ObjectId("63876a9ad79cbe5bea052634"))
db.Paises.remove({"codigo" : "02"})

// Insertar Paises individual
db.Paises.insert(
    {
        "codigo": "01",
        "nombre": "Colombia",
        "estado": true,
        "continenteId": {
            "$ref": "Continentes",
            "$id": {
                "$oid":"63876a0fd79cbe5bea052630"
            }
        }
    }
)


// Insertar Paises multiple
db.Paiss.insert(
    {
        "codigo": "01",
        "nombre": "Colombia",
        "estado": true,
        "continenteId": {
            "$ref": "Continentes",
            "$id": {
                "$oid":"63876a0fd79cbe5bea052630"
            }
        }
    }
)


// Agregar datos anidados
db.Paises.insert(
    [
        {
            "codigo": "01",
            "nombre": "Colombia",
            "estado": true,
            "continenteId": {
                "$ref": "Continentes",
                "$id": {
                    "$oid":"63876a0fd79cbe5bea052630"
                }
            },
            "departamentos":{
                "01":"Huila",
                "02":"Nariño",
                "03":"Antioquia"
            }
        },
        {
            "codigo": "02",
            "nombre": "Ecuador",
            "estado": true,
            "continenteId": {
                "$ref": "Continentes",
                "$id": {
                    "$oid":"63876a0fd79cbe5bea052630"
                }
            }
        },
        {
            "codigo": "03",
            "nombre": "Perú",
            "estado": true,
            "continenteId": {
                "$ref": "Continentes",
                "$id": {
                    "$oid":"63876a0fd79cbe5bea052630"
                }
            }
        },
        {
            "codigo": "04",
            "nombre": "Chile",
            "estado": true,
            "continenteId": {
                "$ref": "Continentes",
                "$id": {
                    "$oid":"63876a0fd79cbe5bea052630"
                }
            }
        }

    ]
)