package com.unab.g04sql.Service;

import com.unab.g04sql.Entity.Roles;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.unab.g04sql.Entity.UserRoles;
import com.unab.g04sql.Entity.UserRolesKey;
import com.unab.g04sql.Entity.Users;
import com.unab.g04sql.IRepository.IUserRolesRepository;
import com.unab.g04sql.IService.IUserRolesService;

@Service
public class UserRolesService implements IUserRolesService {

    @Autowired
    private IUserRolesRepository repository;

    @Override
    public List<UserRoles> all() {
        return repository.findAll();
    }    

    @Override
    public Optional<UserRoles> findById(Integer userId) {
        return repository.findById(userId);
    }
    
    @Override
    public List<UserRoles> findAllByUserId(Users userId) {
        return repository.findAllByUserId(userId);
    }

    @Override
    public UserRoles save(UserRoles userRoles) {
        return repository.save(userRoles);
    }

    @Override
    public void delete(Users userId, Roles rolId) {
        UserRolesKey userRoleToDeleteKey = new UserRolesKey();
        userRoleToDeleteKey.setUserId(userId.getId());
        userRoleToDeleteKey.setRolId(rolId.getId());
        
        UserRoles userRoleToDelete = new UserRoles();
        userRoleToDelete.setId(userRoleToDeleteKey);
        userRoleToDelete.setUserId(userId);
        userRoleToDelete.setRolId(rolId);
        repository.delete(userRoleToDelete);
    }
    
}
