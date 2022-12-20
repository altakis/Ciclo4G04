package com.unab.g04nosql.Controller;

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

import com.unab.g04nosql.Collection.Permissions;
import com.unab.g04nosql.IService.IPermissionsService;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("api/permissions")
public class PermissionsController {

    @Autowired
    private IPermissionsService service;

    @GetMapping
    public List<Permissions> all() {
        return service.all();
    }

    @GetMapping("{id}")
    public Optional<Permissions> show(@PathVariable String id) {
        return service.findById(id);
    }

    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    public Permissions save(@RequestBody Permissions person) {
        return service.save(person);
    }

    @PutMapping("{id}")
    @ResponseStatus(code = HttpStatus.CREATED)
    public Permissions update(@PathVariable String id, @RequestBody Permissions permissions) {
        Optional<Permissions> op = service.findById(id);

        if (!op.isEmpty()) {
            Permissions permissionsUpdate = op.get();
            permissionsUpdate.setCodigo(permissions.getCodigo());
            permissionsUpdate.setNombre(permissions.getNombre());
            permissionsUpdate.setRuta(permissions.getRuta());
            permissionsUpdate.setEstado(permissions.getEstado());
            return service.save(permissionsUpdate);
        }

        return permissions;
    }

    @DeleteMapping("{id}")
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    public void delete(@PathVariable String id) {
        service.delete(id);
    }

}
