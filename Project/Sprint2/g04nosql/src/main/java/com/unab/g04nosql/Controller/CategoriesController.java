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

import com.unab.g04nosql.Collection.Categories;
import com.unab.g04nosql.IService.ICategoriesService;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("api/categories")
public class CategoriesController {

    @Autowired
    private ICategoriesService service;

    @GetMapping
    public List<Categories> all() {
        return service.all();
    }

    @GetMapping("{id}")
    public Optional<Categories> show(@PathVariable String id) {
        return service.findById(id);
    }

    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    public Categories save(@RequestBody Categories person) {
        return service.save(person);
    }

    @PutMapping("{id}")
    @ResponseStatus(code = HttpStatus.CREATED)
    public Categories update(@PathVariable String id, @RequestBody Categories categories) {
        Optional<Categories> op = service.findById(id);

        if (!op.isEmpty()) {
            Categories categoriesUpdate = op.get();
            categoriesUpdate.setCodigo(categories.getCodigo());
            categoriesUpdate.setNombre(categories.getNombre());
            categoriesUpdate.setEstado(categories.getEstado());
            return service.save(categoriesUpdate);
        }

        return categories;
    }

    @DeleteMapping("{id}")
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    public void delete(@PathVariable String id) {
        service.delete(id);
    }

}
