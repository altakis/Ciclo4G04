package com.unab.g04nosql.Collection;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;
import lombok.Data;

@Document("measured_units")
@Data
public class MeasuredUnits {

    @Id
    private Integer id;

    @Field("codigo")
    private String codigo;

    @Field("nombre")
    private String nombre;

    @Field("descripcion")
    private String descripcion;

    @Field("estado")
    private Boolean estado;
}
