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

import com.unab.g04nosql.Collection.Brands;
import com.unab.g04nosql.IService.IBrandsService;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("api/brands")
public class BrandsController {

    @Autowired
    private IBrandsService service;

    @GetMapping
    public List<Brands> all() {
        return service.all();
    }

    @GetMapping("{id}")
    public Optional<Brands> show(@PathVariable String id) {
        return service.findById(id);
    }

    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    public Brands save(@RequestBody Brands person) {
        return service.save(person);
    }

    @PutMapping("{id}")
    @ResponseStatus(code = HttpStatus.CREATED)
    public Brands update(@PathVariable String id, @RequestBody Brands brands) {
        Optional<Brands> op = service.findById(id);

        if (!op.isEmpty()) {
            Brands brandsUpdate = op.get();
            brandsUpdate.setCodigo(brands.getCodigo());
            brandsUpdate.setNombre(brands.getNombre());
            brandsUpdate.setEstado(brands.getEstado());
            return service.save(brandsUpdate);
        }

        return brands;
    }

    @DeleteMapping("{id}")
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    public void delete(@PathVariable String id) {
        service.delete(id);
    }

}
