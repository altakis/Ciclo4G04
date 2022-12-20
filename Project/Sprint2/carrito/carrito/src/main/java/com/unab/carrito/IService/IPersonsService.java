package com.unab.carrito.IService;

import java.util.List;
import java.util.Optional;

import com.unab.carrito.Collection.Persons;

public interface IPersonsService {
	
	public List<Persons> all();
    
	public Optional<Persons> findById(String id);
	    
	public Persons save(Persons persons);
	    
	public void delete(String id);
}
