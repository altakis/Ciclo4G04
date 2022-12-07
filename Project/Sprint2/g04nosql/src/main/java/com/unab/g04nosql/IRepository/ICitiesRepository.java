package com.unab.g04nosql.IRepository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.unab.g04nosql.Collection.Cities;

public interface ICitiesRepository extends MongoRepository<Cities, String> {

}
