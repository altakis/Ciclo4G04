package com.unab.g04nosql.Controller;

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

import com.unab.g04nosql.Collection.Roles;
import com.unab.g04nosql.Collection.Permissions;
import com.unab.g04nosql.Collection.RolesPermissions;
import com.unab.g04nosql.IService.IRolesService;
import com.unab.g04nosql.IService.IPermissionsService;
import com.unab.g04nosql.IService.IRolesPermissionsService;
import java.util.List;
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
    public List<RolesPermissions> show(@PathVariable String rolId) {
        Optional<Roles> rolIdToFind = roleService.findById(rolId);
        if (rolIdToFind.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        } else {
            return service.findAllByRolId(rolIdToFind.get());
        }
    }

    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    public RolesPermissions save(@RequestBody RolesPermissions newRolPermissionId) {        
        Optional<Roles> rolTest = roleService.findById(newRolPermissionId.getRolId().getId());
        Optional<Permissions> permissionTest = permissionService.findById(newRolPermissionId.getPermissionId().getId());
        if (rolTest.isEmpty() || permissionTest.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        } else {
            return service.save(newRolPermissionId);
        }
    }

    @DeleteMapping("{id}")
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    public void delete(@PathVariable("id") String rolPermissionId) {        
        Optional<RolesPermissions> rolPermissionToDelete = service.findById(rolPermissionId);        
        if (rolPermissionToDelete.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        } else {
            service.delete(rolPermissionId);
        }
    }
}
