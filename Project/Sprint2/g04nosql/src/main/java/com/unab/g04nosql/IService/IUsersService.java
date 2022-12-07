package com.unab.g04nosql.IService;

import java.util.List;
import java.util.Optional;

import com.unab.g04nosql.Collection.Users;

public interface IUsersService {
	
	public List<Users> all();
    
	public Optional<Users> findById(String id);
	    
	public Users save(Users users);
	    
	public void delete(String id);
}
