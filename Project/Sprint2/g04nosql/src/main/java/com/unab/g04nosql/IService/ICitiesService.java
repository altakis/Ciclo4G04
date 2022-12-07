package com.unab.g04nosql.IService;

import java.util.List;
import java.util.Optional;

import com.unab.g04nosql.Collection.Cities;

public interface ICitiesService {
	
	public List<Cities> all();
    
	public Optional<Cities> findById(String id);
	    
	public Cities save(Cities cities);
	    
	public void delete(String id);
}
