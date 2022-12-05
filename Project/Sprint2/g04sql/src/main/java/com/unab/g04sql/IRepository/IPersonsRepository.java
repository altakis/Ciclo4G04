package com.unab.g04sql.IRepository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.unab.g04sql.Entity.Persons;

public interface IPersonsRepository extends JpaRepository<Persons, Integer> {

}
