package com.unab.g04sql.Service;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.unab.g04sql.Entity.Users;
import com.unab.g04sql.IRepository.IUsersRepository;
import com.unab.g04sql.IService.IUsersService;


@Service
public class UsersService implements IUsersService{
	
	@Autowired
	private IUsersRepository repository; 
	
	@Override
	public List<Users> all() {
		return repository.findAll();
	}

	@Override
	public Optional<Users> findById(Integer id) {		
		return repository.findById(id);
	}

	@Override
	public Users save(Users users) {		
		return repository.save(users);
	}

	@Override
	public void delete(Integer id) {
		repository.deleteById(id);		
	}

}
