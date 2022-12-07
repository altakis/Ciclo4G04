package com.unab.g04nosql.IService;

import java.util.List;
import java.util.Optional;

import com.unab.g04nosql.Collection.Persons;

public interface IPersonsService {
	
	public List<Persons> all();
    
	public Optional<Persons> findById(String id);
	    
	public Persons save(Persons persons);
	    
	public void delete(String id);
}
