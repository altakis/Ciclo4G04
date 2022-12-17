package com.unab.g04sql.IRepository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.unab.g04sql.Entity.UserRoles;
import com.unab.g04sql.Entity.Users;
import java.util.List;

public interface IUserRolesRepository extends JpaRepository<UserRoles, Integer> {
    List<UserRoles> findAllByUserId(Users userId);
}