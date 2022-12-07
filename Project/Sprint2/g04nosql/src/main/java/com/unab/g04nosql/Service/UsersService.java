package com.unab.g04nosql.Service;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.unab.g04nosql.Collection.Users;
import com.unab.g04nosql.IRepository.IUsersRepository;
import com.unab.g04nosql.IService.IUsersService;


@Service
public class UsersService implements IUsersService{
	
	@Autowired
	private IUsersRepository repository; 
	
	@Override
	public List<Users> all() {
		return repository.findAll();
	}

	@Override
	public Optional<Users> findById(String id) {		
		return repository.findById(id);
	}

	@Override
	public Users save(Users users) {		
		return repository.save(users);
	}

	@Override
	public void delete(String id) {
		repository.deleteById(id);		
	}

}
