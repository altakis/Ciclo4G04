package com.unab.g04sql.IRepository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.unab.g04sql.Entity.UserRoles;

public interface IUserRolesRepository extends JpaRepository<UserRoles, Integer> {

}
