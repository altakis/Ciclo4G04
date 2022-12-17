package com.unab.g04sql.IService;

import com.unab.g04sql.Entity.Roles;
import java.util.List;

import com.unab.g04sql.Entity.UserRoles;
import com.unab.g04sql.Entity.Users;
import java.util.Optional;

public interface IUserRolesService {

    public List<UserRoles> all();
    
    public Optional<UserRoles> findById(Integer roleId);

    public List<UserRoles> findAllByUserId(Users userId);

    public UserRoles save(UserRoles userRoles);

    public void delete(Users userId, Roles rolId);
}
