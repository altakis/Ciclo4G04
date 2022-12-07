package com.unab.g04nosql.IRepository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.unab.g04nosql.Collection.Departments;

public interface IDepartmentsRepository extends MongoRepository<Departments, String> {

}
