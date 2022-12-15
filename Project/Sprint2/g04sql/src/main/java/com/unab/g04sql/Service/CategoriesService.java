package com.unab.g04sql.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.unab.g04sql.Entity.Categories;
import com.unab.g04sql.IRepository.ICategoriesRepository;
import com.unab.g04sql.IService.ICategoriesService;

@Service
public class CategoriesService implements ICategoriesService {

    @Autowired
    private ICategoriesRepository repository;

    @Override
    public List<Categories> all() {
        return repository.findAll();
    }

    @Override
    public Optional<Categories> findById(Integer id) {
        return repository.findById(id);
    }

    @Override
    public Categories save(Categories categories) {
        return repository.save(categories);
    }

    @Override
    public void delete(Integer id) {
        repository.deleteById(id);
    }

}
