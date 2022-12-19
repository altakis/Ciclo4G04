package com.unab.g04nosql.IRepository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.unab.g04nosql.Collection.Roles;
import com.unab.g04nosql.Collection.RolesPermissions;
import java.util.List;

public interface IRolesPermissionsRepository extends MongoRepository<RolesPermissions, Integer> {

    List<RolesPermissions> findAllByRolId(Roles rolId);
}
