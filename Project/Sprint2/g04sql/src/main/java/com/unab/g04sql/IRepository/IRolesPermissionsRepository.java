package com.unab.g04sql.IRepository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.unab.g04sql.Entity.RolesPermissions;

public interface IRolesPermissionsRepository extends JpaRepository<RolesPermissions, Integer> {

}
