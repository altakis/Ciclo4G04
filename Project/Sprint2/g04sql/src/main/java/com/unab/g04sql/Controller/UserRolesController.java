package com.unab.g04sql.Controller;

import com.unab.g04sql.Entity.Roles;
import java.util.List;
import java.util.Optional;

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

import com.unab.g04sql.Entity.UserRoles;
import com.unab.g04sql.Entity.UserRolesKey;
import com.unab.g04sql.Entity.Users;
import com.unab.g04sql.IService.IRolesService;
import com.unab.g04sql.IService.IUserRolesService;
import com.unab.g04sql.IService.IUsersService;
import org.springframework.web.server.ResponseStatusException;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("api/userRoles")
public class UserRolesController {

    @Autowired
    private IUserRolesService service;
    
    @Autowired
    private IUsersService userService;
    
    @Autowired
    private IRolesService roleService;

    @GetMapping
    public List<UserRoles> all() {
        return service.all();
    }

    @GetMapping("{userId}")
    public List<UserRoles> show(@PathVariable("userId") Integer userId) {
        Optional<Users> userRolIdToFind = userService.findById(userId);
        if (userRolIdToFind.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        } else {
            return service.findAllByUserId(userRolIdToFind.get());
        }
    }

    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    public UserRoles save(@RequestBody UserRolesKey userRolekeKey) {
        Optional<Users> userToAdd = userService.findById(userRolekeKey.getUserId());
        Optional<Roles> rolToAdd = roleService.findById(userRolekeKey.getRolId());
        if (rolToAdd.isEmpty() || userToAdd.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        } else {
            UserRoles newUserRole = new UserRoles();
            newUserRole.setId(userRolekeKey);
            newUserRole.setUserId(userToAdd.get());
            newUserRole.setRolId(rolToAdd.get());
            return service.save(newUserRole);
        }
    }    

   @DeleteMapping("{userId}/{rolId}")
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    public void delete(@PathVariable("userId") Integer userId, @PathVariable("rolId") Integer rolId) {
        Optional<Users> userToDelete = userService.findById(userId);
        Optional<Roles> rolToDelete = roleService.findById(rolId);
        if (userToDelete.isEmpty() || rolToDelete.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }else{
            service.delete(userToDelete.get(), rolToDelete.get());
        }
    }

}
