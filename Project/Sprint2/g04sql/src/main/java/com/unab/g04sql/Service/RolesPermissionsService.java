package com.unab.g04sql.Service;

import com.unab.g04sql.Entity.Permissions;
import com.unab.g04sql.Entity.Roles;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.unab.g04sql.Entity.RolesPermissions;
import com.unab.g04sql.Entity.RolesPermissionsKey;
import com.unab.g04sql.IRepository.IRolesPermissionsRepository;
import com.unab.g04sql.IService.IRolesPermissionsService;

@Service
public class RolesPermissionsService implements IRolesPermissionsService {

    @Autowired
    private IRolesPermissionsRepository repository;

    @Override
    public List<RolesPermissions> all() {
        return repository.findAll();
    }

    @Override
    public Optional<RolesPermissions> findById(Integer rolId) {
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
    public void delete(Roles rolId, Permissions permissionId) {
        RolesPermissionsKey rolPermissionToDeleteKey = new RolesPermissionsKey();
        rolPermissionToDeleteKey.setRolId(rolId.getId());
        rolPermissionToDeleteKey.setPermissionId(permissionId.getId());
        
        RolesPermissions rolPermissionToDelete = new RolesPermissions();
        rolPermissionToDelete.setId(rolPermissionToDeleteKey);
        rolPermissionToDelete.setRolId(rolId);
        rolPermissionToDelete.setPermissionId(permissionId);
        repository.delete(rolPermissionToDelete);
    }   

}
