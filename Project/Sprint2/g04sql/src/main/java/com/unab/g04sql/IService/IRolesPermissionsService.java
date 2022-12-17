package com.unab.g04sql.IService;

import java.util.List;

import com.unab.g04sql.Entity.RolesPermissions;
import java.util.Optional;

public interface IRolesPermissionsService {

    public List<RolesPermissions> all();

    public Optional<RolesPermissions> findById(Integer roleId);

    public List<RolesPermissions> findAllByRolId(Integer roleId);

    public RolesPermissions save(RolesPermissions rolesPermissions);

    public void delete(Integer id);
}
