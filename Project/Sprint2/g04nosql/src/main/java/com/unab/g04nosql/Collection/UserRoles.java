package com.unab.g04nosql.Collection;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import lombok.Data;


@Document("user_roles")
@Data
public class UserRoles {

    @Id
    private String id;

    @DBRef
    private Users userId;

    @DBRef
    private Roles rolId;

}
