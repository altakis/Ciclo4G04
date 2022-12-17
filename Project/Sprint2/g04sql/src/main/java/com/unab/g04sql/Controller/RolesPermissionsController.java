package com.unab.g04sql.Controller;

import com.unab.g04sql.Entity.Permissions;
import com.unab.g04sql.Entity.Roles;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.unab.g04sql.Entity.RolesPermissions;
import com.unab.g04sql.Entity.RolesPermissionsKey;
import com.unab.g04sql.IService.IPermissionsService;
import com.unab.g04sql.IService.IRolesPermissionsService;
import com.unab.g04sql.IService.IRolesService;
import java.util.Optional;
import org.springframework.web.server.ResponseStatusException;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("api/rolesPermissions")
public class RolesPermissionsController {

    @Autowired
    private IRolesPermissionsService service;

    @Autowired
    private IRolesService roleService;

    @Autowired
    private IPermissionsService permissionService;

    @GetMapping
    public List<RolesPermissions> all() {
        return service.all();
    }

    @GetMapping("{rolId}")
    public List<RolesPermissions> show(@PathVariable("rolId") Integer rolId) {
        Optional<Roles> rolIdToFind = roleService.findById(rolId);
        if (rolIdToFind.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        } else {
            return service.findAllByRolId(rolIdToFind.get());
        }
    }

    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    public RolesPermissions save(@RequestBody RolesPermissionsKey newRolPermissionKey) {
        Optional<Roles> rolToAdd = roleService.findById(newRolPermissionKey.getRolId());
        Optional<Permissions> permissionToAdd = permissionService.findById(newRolPermissionKey.getPermissionId());
        if (rolToAdd.isEmpty() || permissionToAdd.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        } else {
            RolesPermissions newRolPermission = new RolesPermissions();
            newRolPermission.setId(newRolPermissionKey);
            newRolPermission.setRolId(rolToAdd.get());
            newRolPermission.setPermissionId(permissionToAdd.get());
            return service.save(newRolPermission);
        }
    }

    @DeleteMapping("{rolId}/{permissionId}")
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    public void delete(@PathVariable("rolId") Integer rolId, @PathVariable("permissionId") Integer permissionId) {
        Optional<Roles> rolToDelete = roleService.findById(rolId);
        Optional<Permissions> permissionToDelete = permissionService.findById(permissionId);
        if (rolToDelete.isEmpty() || permissionToDelete.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        } else {
            service.delete(rolToDelete.get(), permissionToDelete.get());
        }
    }
}
