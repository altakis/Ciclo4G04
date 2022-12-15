package com.unab.g04sql.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "products")
@Data
public class Products {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "codigo", nullable = false, unique = true, length = 20)
    private String codigo;

    @Column(name = "nombre", nullable = false, length = 50)
    private String nombre;

    @Column(name = "descripcion", nullable = false, length = 200)
    private String descripcion;

    @Column(name = "imagen", nullable = false, length = 50)
    private String imagen;

    @Column(name = "cantidad_maxima")
    private Integer cantidadMaxima;

    @Column(name = "cantidad_minima")
    private Integer cantidadMinima;

    @Column(name = "stock")
    private Integer stock;

    @Column(name = "precio_unitario_compra", nullable = false)
    private Double precioUnitarioCompra;

    @Column(name = "precio_unitario_venta", nullable = false)
    private Double precioUnitarioVenta;

    @Column(name = "iva", nullable = false)
    private Double iva;

    @Column(name = "descuento", nullable = false)
    private Double descuento;

    @Column(name = "estado", nullable = false)
    private Boolean estado;

    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "category_id", nullable = false)
    private Categories categoria_id;

    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "brand_id", nullable = false)
    private Brands marca_id;

    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "measured_units_id", nullable = false)
    private MeasuredUnits unidad_medida_id;

}
