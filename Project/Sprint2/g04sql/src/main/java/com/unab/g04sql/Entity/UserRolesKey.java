package com.unab.g04sql.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import java.io.Serializable;
import lombok.Data;

@Embeddable
@Data
public class UserRolesKey implements Serializable {

    @Column(name = "usuario_id")
    private Integer userId;

    @Column(name = "rol_id")
    private Integer rolId;
}
