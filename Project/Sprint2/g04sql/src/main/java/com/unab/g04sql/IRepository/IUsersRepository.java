package com.unab.g04sql.IRepository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.unab.g04sql.Entity.Users;

public interface IUsersRepository extends JpaRepository<Users, Integer> {

}
