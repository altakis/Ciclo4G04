package com.unab.g04sql.IService;

import java.util.List;
import java.util.Optional;

import com.unab.g04sql.Entity.UserRoles;

public interface IUserRolesService {
	
	public List<UserRoles> all();
    
	public Optional<UserRoles> findById(Integer id);
	    
	public UserRoles save(UserRoles userRoles);
	    
	public void delete(Integer id);
}
