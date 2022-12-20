package com.unab.g04nosql.IService;

import java.util.List;
import java.util.Optional;

import com.unab.g04nosql.Collection.Brands;

public interface IBrandsService {

    public List<Brands> all();

    public Optional<Brands> findById(String id);

    public Brands save(Brands brands);

    public void delete(String id);
}
