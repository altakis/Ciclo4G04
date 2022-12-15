package com.unab.g04sql.IService;

import java.util.List;
import java.util.Optional;

import com.unab.g04sql.Entity.RolesPermissions;

public interface IRolesPermissionsService {
	
	public List<RolesPermissions> all();
    
	public Optional<RolesPermissions> findById(Integer id);
	    
	public RolesPermissions save(RolesPermissions rolesPermissions);
	    
	public void delete(Integer id);
}
