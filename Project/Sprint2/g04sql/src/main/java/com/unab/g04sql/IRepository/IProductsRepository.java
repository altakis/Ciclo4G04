package com.unab.g04sql.IRepository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.unab.g04sql.Entity.Products;

public interface IProductsRepository extends JpaRepository<Products, Integer> {

}
