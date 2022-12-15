package com.unab.g04nosql.Collection;

import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;
import lombok.Data;

@Document("Persons")
@Data
public class Persons {

    @Id
    private String id;

    @Field("tipoDocumento")
    private String tipoDocumento;

    @Field("documento")
    private String documento;

    @Field("primerNombre")
    private String primerNombre;

    @Field("segundoNombre")
    private String segundoNombre;

    @Field("primerApellido")
    private String primerApellido;

    @Field("segundoApellido")
    private String segundoApellido;

    @Field("correo")
    private String correo;

    @Field("telefono")
    private String telefono;

    @Field("fechaNacimiento")
    private Date fechaNacimiento;

    @Field("direccion")
    private String direccion;

    @Field("estado")
    private Boolean estado;

    @DBRef
    private Users usuarioId;

    @DBRef
    private Cities ciudadId;

}
