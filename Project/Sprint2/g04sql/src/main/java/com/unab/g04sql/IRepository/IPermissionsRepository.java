package com.unab.g04sql.IRepository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.unab.g04sql.Entity.Permissions;

public interface IPermissionsRepository extends JpaRepository<Permissions, Integer> {

}
