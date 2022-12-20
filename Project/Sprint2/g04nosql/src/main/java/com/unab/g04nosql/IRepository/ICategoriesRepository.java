package com.unab.g04nosql.IRepository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.unab.g04nosql.Collection.Categories;

public interface ICategoriesRepository extends MongoRepository<Categories, String> {

}
