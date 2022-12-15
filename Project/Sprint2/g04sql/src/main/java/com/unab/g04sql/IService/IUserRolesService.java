package com.unab.g04sql.IService;

import java.util.List;

import com.unab.g04sql.Entity.UserRoles;

public interface IUserRolesService {

    public List<UserRoles> all();

    public List<UserRoles> findById(Integer userId);

    public UserRoles save(UserRoles userRoles);

    public void delete(Integer id);
}
