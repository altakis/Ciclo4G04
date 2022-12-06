package com.unab.g04sql.IService;

import java.util.List;
import java.util.Optional;

import com.unab.g04sql.Entity.Departments;

public interface IDepartmentsService {
	
	public List<Departments> all();
    
	public Optional<Departments> findById(Integer id);
	    
	public Departments save(Departments departments);
	    
	public void delete(Integer id);
}
