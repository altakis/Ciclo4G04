package com.unab.g04nosql.IService;

import java.util.List;

import com.unab.g04nosql.Collection.UserRoles;
import com.unab.g04nosql.Collection.Users;
import java.util.Optional;

public interface IUserRolesService {

    public List<UserRoles> all();
    
    public Optional<UserRoles> findById(String roleId);

    public List<UserRoles> findAllByUserId(Users userId);

    public UserRoles save(UserRoles userRoles);

    public void delete(String userRolesId);
}
