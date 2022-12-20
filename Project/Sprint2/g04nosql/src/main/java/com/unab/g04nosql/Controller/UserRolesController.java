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

import com.unab.g04nosql.Collection.Users;
import com.unab.g04nosql.Collection.Roles;
import com.unab.g04nosql.Collection.UserRoles;
import java.util.List;
import java.util.Optional;
import com.unab.g04nosql.IService.IRolesService;
import com.unab.g04nosql.IService.IUserRolesService;
import com.unab.g04nosql.IService.IUsersService;
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
    public List<UserRoles> show(@PathVariable("userId") String userId) {
        Optional<Users> userRolIdToFind = userService.findById(userId);
        if (userRolIdToFind.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        } else {
            return service.findAllByUserId(userRolIdToFind.get());
        }
    }

    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    public UserRoles save(@RequestBody UserRoles newUserRolId) {
        Optional<Users> userTest = userService.findById(newUserRolId.getUserId().getId());
        Optional<Roles> rolTest = roleService.findById(newUserRolId.getRolId().getId());
        if (rolTest.isEmpty() || userTest.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        } else {
            return service.save(newUserRolId);
        }
    }

    @DeleteMapping("{id}")
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    public void delete(@PathVariable("id") String userRoleId) {
        Optional<UserRoles> userRoleToDelete = service.findById(userRoleId);
        if (userRoleToDelete.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        } else {
            service.delete(userRoleId);
        }
    }

}
