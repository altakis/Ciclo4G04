package com.unab.carrito.Service;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.unab.carrito.Collection.Departments;
import com.unab.carrito.IRepository.IDepartmentsRepository;
import com.unab.carrito.IService.IDepartmentsService;


@Service
public class DepartmentsService implements IDepartmentsService{
	
	@Autowired
	private IDepartmentsRepository repository; 
	
	@Override
	public List<Departments> all() {
		return repository.findAll();
	}

	@Override
	public Optional<Departments> findById(String id) {		
		return repository.findById(id);
	}

	@Override
	public Departments save(Departments departments) {		
		return repository.save(departments);
	}

	@Override
	public void delete(String id) {
		repository.deleteById(id);		
	}

}
