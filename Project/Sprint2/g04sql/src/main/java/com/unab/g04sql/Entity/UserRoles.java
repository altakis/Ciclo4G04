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
@Table(name = "user_roles")
@Data
public class UserRoles {

    @EmbeddedId
    private UserRolesKey id;    

    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @MapsId("userId")
    @JoinColumn(name = "usuario_id", nullable = false)
    private Users userId;

    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @MapsId("rolId")
    @JoinColumn(name = "rol_id", nullable = false)
    private Roles rolId;

}
