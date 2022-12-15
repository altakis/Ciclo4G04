package com.unab.g04sql.IService;

import java.util.List;
import java.util.Optional;

import com.unab.g04sql.Entity.Categories;

public interface ICategoriesService {
	
	public List<Categories> all();
    
	public Optional<Categories> findById(Integer id);
	    
	public Categories save(Categories categories);
	    
	public void delete(Integer id);
}
