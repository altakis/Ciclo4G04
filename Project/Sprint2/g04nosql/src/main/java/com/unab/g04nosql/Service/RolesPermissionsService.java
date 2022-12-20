package com.unab.g04nosql.Service;

import com.unab.g04nosql.Collection.Permissions;
import com.unab.g04nosql.Collection.Roles;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.unab.g04nosql.Collection.RolesPermissions;
import com.unab.g04nosql.IRepository.IRolesPermissionsRepository;
import com.unab.g04nosql.IService.IRolesPermissionsService;

@Service
public class RolesPermissionsService implements IRolesPermissionsService {

    @Autowired
    private IRolesPermissionsRepository repository;

    @Override
    public List<RolesPermissions> all() {
        return repository.findAll();
    }

    @Override
    public Optional<RolesPermissions> findById(String rolId) {
        return repository.findById(rolId);
    }
    
    @Override
    public List<RolesPermissions> findAllByRolId(Roles roleId) {
        return repository.findAllByRolId(roleId);
    }

    @Override
    public RolesPermissions save(RolesPermissions rolesPermissions) {
        return repository.save(rolesPermissions);
    }

    @Override
    public void delete(String rolePermissionId) {
        Optional<RolesPermissions> rolePermissionToDelete = repository.findById(rolePermissionId);
        repository.delete(rolePermissionToDelete.get());
    }   

}
