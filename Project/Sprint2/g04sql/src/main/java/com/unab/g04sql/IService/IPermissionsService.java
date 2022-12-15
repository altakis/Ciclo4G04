package com.unab.g04sql.IService;

import java.util.List;
import java.util.Optional;

import com.unab.g04sql.Entity.Permissions;

public interface IPermissionsService {
	
	public List<Permissions> all();
    
	public Optional<Permissions> findById(Integer id);
	    
	public Permissions save(Permissions permissions);
	    
	public void delete(Integer id);
}
