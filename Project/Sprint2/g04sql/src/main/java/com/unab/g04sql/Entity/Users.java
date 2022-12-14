package com.unab.g04sql.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "users")
@Data
public class Users {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "usuario", nullable = false, unique = true, length = 30)
    private String usuario;

    @Column(name = "contrasenia", nullable = false, unique = true, length = 100)
    private String contrasenia;

    @Column(name = "estado", nullable = false)
    private Boolean estado;
}
