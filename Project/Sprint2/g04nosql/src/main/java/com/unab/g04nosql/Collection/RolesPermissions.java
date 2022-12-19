package com.unab.g04nosql.Collection;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import lombok.Data;

@Document("roles_permissions")
@Data
public class RolesPermissions {

    @Id
    private Integer id;

    @DBRef
    private Roles rolId;

    @DBRef
    private Permissions permissionId;

}
