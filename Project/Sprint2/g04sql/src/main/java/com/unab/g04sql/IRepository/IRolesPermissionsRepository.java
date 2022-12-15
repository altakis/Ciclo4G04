package com.unab.g04sql.IRepository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.unab.g04sql.Entity.RolesPermissions;
import java.util.List;

public interface IRolesPermissionsRepository extends JpaRepository<RolesPermissions, Integer> {
    List<RolesPermissions> findAllByRolId(Integer rolId);
}
