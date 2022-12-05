package com.unab.g04sql.IService;

import java.util.List;
import java.util.Optional;

import com.unab.g04sql.Entity.Persons;

public interface IPersonsService {
	
	public List<Persons> all();
    
	public Optional<Persons> findById(Integer id);
	    
	public Persons save(Persons persons);
	    
	public void delete(Integer id);
}
