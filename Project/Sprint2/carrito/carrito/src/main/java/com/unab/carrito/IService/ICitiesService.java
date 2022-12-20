package com.unab.carrito.IService;

import java.util.List;
import java.util.Optional;

import com.unab.carrito.Collection.Cities;

public interface ICitiesService {
	
	public List<Cities> all();
    
	public Optional<Cities> findById(String id);
	    
	public Cities save(Cities cities);
	    
	public void delete(String id);
}
