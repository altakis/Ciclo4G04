package com.unab.g04nosql.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.unab.g04nosql.Collection.Categories;
import com.unab.g04nosql.IRepository.ICategoriesRepository;
import com.unab.g04nosql.IService.ICategoriesService;

@Service
public class CategoriesService implements ICategoriesService {

    @Autowired
    private ICategoriesRepository repository;

    @Override
    public List<Categories> all() {
        return repository.findAll();
    }

    @Override
    public Optional<Categories> findById(String id) {
        return repository.findById(id);
    }

    @Override
    public Categories save(Categories categories) {
        return repository.save(categories);
    }

    @Override
    public void delete(String id) {
        repository.deleteById(id);
    }

}
