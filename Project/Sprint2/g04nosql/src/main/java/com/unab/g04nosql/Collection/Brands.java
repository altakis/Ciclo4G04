package com.unab.g04nosql.Collection;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;
import lombok.Data;

@Document("Brands")
@Data
public class Brands {

    @Id
    private String id;

    @Field("codigo")
    private String codigo;

    @Field("nombre")
    private String nombre;

    @Field("estado")
    private Boolean estado;
}
