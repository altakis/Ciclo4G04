package com.unab.g04nosql.Collection;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;
import lombok.Data;

@Document("Products")
@Data
public class Products {

    @Id
    private String id;

    @Field("codigo")
    private String codigo;

    @Field("nombre")
    private String nombre;

    @Field("descripcion")
    private String descripcion;

    @Field("imagen")
    private String imagen;

    @Field("cantidad_maxima")
    private Integer cantidadMaxima;

    @Field("cantidad_minima")
    private Integer cantidadMinima;

    @Field("stock")
    private Integer stock;

    @Field("precio_unitario_compra")
    private Double precioUnitarioCompra;

    @Field("precio_unitario_venta")
    private Double precioUnitarioVenta;

    @Field("iva")
    private Double iva;

    @Field("descuento")
    private Double descuento;

    @Field("estado")
    private Boolean estado;

    @DBRef
    private Categories categoria_id;

    @DBRef
    private Brands marca_id;

    @DBRef
    private MeasuredUnits unidad_medida_id;

}
