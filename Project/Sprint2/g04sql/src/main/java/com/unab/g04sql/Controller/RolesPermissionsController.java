package com.unab.g04sql.Controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.unab.g04sql.Entity.RolesPermissions;
import com.unab.g04sql.IService.IRolesPermissionsService;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("api/rolesPermissions")
public class RolesPermissionsController {

    @Autowired
    private IRolesPermissionsService service;

    @GetMapping
    public List<RolesPermissions> all() {
        return service.all();
    }

    @GetMapping("{id}")
    public Optional<RolesPermissions> show(@PathVariable Integer rolId) {
        return service.findById(rolId);
    }
    
    @GetMapping("all/{id}")
    public List<RolesPermissions> showAll(@PathVariable Integer rolId) {
        return service.findAllByRolId(rolId);
    }

    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    public RolesPermissions save(@RequestBody RolesPermissions person) {
        return service.save(person);
    }

    @PutMapping("{id}")
    @ResponseStatus(code = HttpStatus.CREATED)
    public RolesPermissions update(@PathVariable Integer id, @RequestBody RolesPermissions rolesPermissions) {
        Optional<RolesPermissions> op = service.findById(id);

        if (!op.isEmpty()) {
            RolesPermissions rolesPermissionsUpdate = op.get();            
            rolesPermissionsUpdate.setRolId(rolesPermissions.getRolId());
            rolesPermissionsUpdate.setPermissionId(rolesPermissions.getPermissionId());
            return service.save(rolesPermissionsUpdate);
        }

        return rolesPermissions;
    }

    @DeleteMapping("{id}")
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Integer id) {
        service.delete(id);
    }

}
