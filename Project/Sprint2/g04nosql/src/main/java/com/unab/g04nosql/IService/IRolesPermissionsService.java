package com.unab.g04nosql.IService;

import com.unab.g04nosql.Collection.Roles;
import java.util.List;

import com.unab.g04nosql.Collection.RolesPermissions;
import java.util.Optional;

public interface IRolesPermissionsService {

    public List<RolesPermissions> all();

    public Optional<RolesPermissions> findById(Integer roleId);

    public List<RolesPermissions> findAllByRolId(Roles roleId);

    public RolesPermissions save(RolesPermissions rolesPermissions);

    public void delete(Integer rolePermissionId);
}
