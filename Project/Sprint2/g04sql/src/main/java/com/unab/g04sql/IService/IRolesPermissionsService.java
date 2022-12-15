package com.unab.g04sql.IService;

import java.util.List;

import com.unab.g04sql.Entity.RolesPermissions;

public interface IRolesPermissionsService {

    public List<RolesPermissions> all();

    public List<RolesPermissions> findById(Integer roleId);

    public RolesPermissions save(RolesPermissions rolesPermissions);

    public void delete(Integer id);
}
