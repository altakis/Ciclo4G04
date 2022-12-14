package com.unab.g04sql.Entity;

import java.sql.Date;

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
@Table(name = "persons")
@Data
public class Persons {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "tipo_documento", nullable = false, length = 5)
    private String tipoDocumento;

    @Column(name = "documento", nullable = false, unique = true, length = 12)
    private String documento;

    @Column(name = "primer_nombre", nullable = false, length = 20)
    private String primerNombre;

    @Column(name = "segundo_nombre", length = 20)
    private String segundoNombre;

    @Column(name = "primer_apellido", nullable = false, length = 20)
    private String primerApellido;

    @Column(name = "segundo_apellido", length = 20)
    private String segundoApellido;

    @Column(name = "correo", nullable = false, unique = true, length = 40)
    private String correo;

    @Column(name = "telefono", nullable = false, unique = true, length = 20)
    private String telefono;

    @Column(name = "fecha_nacimiento", nullable = false)
    private Date fechaNacimiento;

    @Column(name = "direccion", nullable = false, length = 100)
    private String direccion;

    @Column(name = "estado", nullable = false)
    private Boolean estado;

    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "usuario_id", nullable = false)
    private Users usuarioId;

    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "ciudad_id", nullable = false)
    private Cities ciudadId;
}
