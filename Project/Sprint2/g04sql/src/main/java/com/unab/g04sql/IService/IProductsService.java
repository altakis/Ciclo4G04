package com.unab.g04sql.IService;

import java.util.List;
import java.util.Optional;

import com.unab.g04sql.Entity.Products;

public interface IProductsService {

    public List<Products> all();

    public Optional<Products> findById(Integer id);

    public Products save(Products products);

    public void delete(Integer id);
}
