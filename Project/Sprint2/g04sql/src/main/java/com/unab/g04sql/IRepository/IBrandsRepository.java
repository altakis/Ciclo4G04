package com.unab.g04sql.IRepository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.unab.g04sql.Entity.Brands;

public interface IBrandsRepository extends JpaRepository<Brands, Integer> {

}
