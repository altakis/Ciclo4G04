package com.unab.g04sql.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import java.io.Serializable;
import lombok.Data;

@Embeddable
@Data
public class RolesPermissionsKey implements Serializable {

    @Column(name = "rol_id")
    private Integer rolId;

    @Column(name = "permission_id")
    private Integer permissionId;
}
