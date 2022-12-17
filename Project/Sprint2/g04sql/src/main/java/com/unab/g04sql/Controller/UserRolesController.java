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

import com.unab.g04sql.Entity.UserRoles;
import com.unab.g04sql.IService.IUserRolesService;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("api/userRoles")
public class UserRolesController {

    @Autowired
    private IUserRolesService service;

    @GetMapping
    public List<UserRoles> all() {
        return service.all();
    }

    @GetMapping("{id}")
    public List<UserRoles> show(@PathVariable Integer id) {
        return service.findById(id);
    }
    
    @GetMapping("all/{id}")
    public List<UserRoles> showAll(@PathVariable Integer id) {
        return service.findById(id);
    }

    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    public UserRoles save(@RequestBody UserRoles person) {
        return service.save(person);
    }

    @PutMapping("{id}")
    @ResponseStatus(code = HttpStatus.CREATED)
    public UserRoles update(@PathVariable Integer id, @RequestBody UserRoles userRoles) {
        List<UserRoles> op = service.findById(id);

        if (!op.isEmpty()) {
            UserRoles userRolesUpdate = op.get(0);
            userRolesUpdate.setUserId(userRoles.getUserId());            
            userRolesUpdate.setRolId(userRoles.getRolId());
            return service.save(userRolesUpdate);
        }

        return userRoles;
    }

    @DeleteMapping("{id}")
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Integer id) {
        service.delete(id);
    }

}
