package com.unab.g04sql.IService;

import java.util.List;
import java.util.Optional;

import com.unab.g04sql.Entity.Cities;

public interface ICitiesService {
	
	public List<Cities> all();
    
	public Optional<Cities> findById(Integer id);
	    
	public Cities save(Cities cities);
	    
	public void delete(Integer id);
}
