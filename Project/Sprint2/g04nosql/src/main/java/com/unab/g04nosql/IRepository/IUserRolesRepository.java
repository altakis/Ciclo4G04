package com.unab.g04nosql.IRepository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.unab.g04nosql.Collection.UserRoles;
import com.unab.g04nosql.Collection.Users;
import java.util.List;

public interface IUserRolesRepository extends MongoRepository<UserRoles, String> {

    List<UserRoles> findAllByUserId(Users userId);
}
