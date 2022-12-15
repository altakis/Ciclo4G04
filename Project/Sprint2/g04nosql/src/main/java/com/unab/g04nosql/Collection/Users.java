package com.unab.g04nosql.Collection;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;
import lombok.Data;

@Document("Users")
@Data
public class Users {

    @Id
    private String id;

    @Field("usuario")
    private String usuario;

    @Field("contrasenia")
    private String contrasenia;

    @Field("estado")
    private Boolean estado;

}
