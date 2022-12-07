package com.unab.g04nosql.IRepository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.unab.g04nosql.Collection.Users;

public interface IUsersRepository extends MongoRepository<Users, String> {

}
