package com.unab.g04nosql.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.unab.g04nosql.Collection.UserRoles;
import com.unab.g04nosql.Collection.Users;
import com.unab.g04nosql.IRepository.IUserRolesRepository;
import com.unab.g04nosql.IService.IUserRolesService;

@Service
public class UserRolesService implements IUserRolesService {

    @Autowired
    private IUserRolesRepository repository;

    @Override
    public List<UserRoles> all() {
        return repository.findAll();
    }    

    @Override
    public Optional<UserRoles> findById(String userId) {
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
    public void delete(String userRoleId) {
        Optional<UserRoles> userRoleToDelete = repository.findById(userRoleId);
        repository.delete(userRoleToDelete.get());
    }
    
}
