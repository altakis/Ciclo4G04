package com.unab.g04sql.IRepository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.unab.g04sql.Entity.Cities;

public interface ICitiesRepository extends JpaRepository<Cities, Integer> {

}
