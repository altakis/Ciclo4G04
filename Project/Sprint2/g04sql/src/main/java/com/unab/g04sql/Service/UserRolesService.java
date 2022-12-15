package com.unab.g04sql.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.unab.g04sql.Entity.UserRoles;
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
    public List<UserRoles> findById(Integer userId) {
        return repository.findAllByUserId(userId);
    }

    @Override
    public UserRoles save(UserRoles userRoles) {
        return repository.save(userRoles);
    }

    @Override
    public void delete(Integer id) {
        repository.deleteById(id);
    }

}
