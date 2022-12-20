package com.unab.g04nosql.IRepository;

import org.springframework.data.mongodb.repository.MongoRepository;
import com.unab.g04nosql.Collection.Brands;

public interface IBrandsRepository extends MongoRepository<Brands, String> {

}
