package com.unab.carrito.IRepository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.unab.carrito.Collection.Persons;

public interface IPersonsRepository extends MongoRepository<Persons, String> {

}
