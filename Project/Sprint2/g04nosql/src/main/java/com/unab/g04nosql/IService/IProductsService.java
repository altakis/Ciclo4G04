package com.unab.g04nosql.IService;

import java.util.List;
import java.util.Optional;

import com.unab.g04nosql.Collection.Products;

public interface IProductsService {

    public List<Products> all();

    public Optional<Products> findById(String id);

    public Products save(Products products);

    public void delete(String id);
}
