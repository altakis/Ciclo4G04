package com.unab.carrito.IRepository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.unab.carrito.Collection.Users;

public interface IUsersRepository extends MongoRepository<Users, String> {

}
