package com.unab.g04nosql.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.unab.g04nosql.Collection.Products;
import com.unab.g04nosql.IRepository.IProductsRepository;
import com.unab.g04nosql.IService.IProductsService;

@Service
public class ProductsService implements IProductsService {

    @Autowired
    private IProductsRepository repository;

    @Override
    public List<Products> all() {
        return repository.findAll();
    }

    @Override
    public Optional<Products> findById(Integer id) {
        return repository.findById(id);
    }

    @Override
    public Products save(Products products) {
        return repository.save(products);
    }

    @Override
    public void delete(Integer id) {
        repository.deleteById(id);
    }

}
