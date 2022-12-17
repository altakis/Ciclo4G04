package com.unab.g04sql.IService;

import com.unab.g04sql.Entity.Permissions;
import com.unab.g04sql.Entity.Roles;
import java.util.List;

import com.unab.g04sql.Entity.RolesPermissions;
import java.util.Optional;

public interface IRolesPermissionsService {

    public List<RolesPermissions> all();

    public Optional<RolesPermissions> findById(Integer roleId);

    public List<RolesPermissions> findAllByRolId(Roles roleId);

    public RolesPermissions save(RolesPermissions rolesPermissions);

    public void delete(Roles rolId, Permissions permissionId);
}
