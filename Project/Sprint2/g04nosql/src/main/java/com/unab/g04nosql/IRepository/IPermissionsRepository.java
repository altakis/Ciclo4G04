package com.unab.g04nosql.IRepository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.unab.g04nosql.Collection.Permissions;

public interface IPermissionsRepository extends MongoRepository<Permissions, Integer> {

}
