package com.unab.g04sql.Entity;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MapsId;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "roles_permissions")
@Data
public class RolesPermissions {

    @EmbeddedId
    private RolesPermissionsKey id;    

    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @MapsId("rolId")
    @JoinColumn(name = "rol_id", nullable = false)
    private Roles rolId;
    
    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @MapsId("permissionId")
    @JoinColumn(name = "permiso_id", nullable = false)
    private Permissions permissionId;

}
