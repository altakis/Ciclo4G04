package com.unab.g04sql.IRepository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.unab.g04sql.Entity.Categories;

public interface ICategoriesRepository extends JpaRepository<Categories, Integer> {

}
