package com.unab.carrito.IRepository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.unab.carrito.Collection.Cities;

public interface ICitiesRepository extends MongoRepository<Cities, String> {

}
