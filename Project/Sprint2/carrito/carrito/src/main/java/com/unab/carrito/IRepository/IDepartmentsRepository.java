package com.unab.carrito.IRepository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.unab.carrito.Collection.Departments;

public interface IDepartmentsRepository extends MongoRepository<Departments, String> {

}
