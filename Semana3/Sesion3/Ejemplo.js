// Crear o seleccionar una base de datos 
use g04nosql

//crear collecciones
db.createCollection("Continentes")
db.createCollection("Paises")
db.createCollection("Departamentos")
db.createCollection("Ciudades")


//Agregar datos al continente
db.Continentes.insert(
    {
        "codigo": "01",
        "nombre": "America del Sur",
        "estado": true
    }
)

db.Continentes.insert(
    [
        {
            "codigo": "03",
            "nombre": "Asia",
            "estado": 1
        },
        {
            "codigo": "04",
            "nombre": "Oseania",
            "estado": 1
        },
        {
            "nombre": "Europa",
            "estado": 1
        },
        {
            "nombre": "Africa"
        }
    ]
)

// Consultar normal 
db.Continentes.find()

// Consultar estructural 
db.Continentes.find().pretty()


// Insertar Paises
// 1-Consultar la llave dbref.
db.Paises.insert(
    {
        "codigo": "02",
        "nombre": "España",
        "estado": true,
        "continenteId": {
            "$ref": "Continentes",
            "$id": {
                "$oid": "63876a9ad79cbe5bea052633"
            }
        }
    }
)