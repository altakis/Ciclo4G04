package com.unab.g04nosql.IService;

import java.util.List;
import java.util.Optional;

import com.unab.g04nosql.Collection.Categories;

public interface ICategoriesService {

    public List<Categories> all();

    public Optional<Categories> findById(String id);

    public Categories save(Categories categories);

    public void delete(String id);
}
