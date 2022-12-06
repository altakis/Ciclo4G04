package com.unab.g04sql.Service;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.unab.g04sql.Entity.Departments;
import com.unab.g04sql.IRepository.IDepartmentsRepository;
import com.unab.g04sql.IService.IDepartmentsService;


@Service
public class DepartmentsService implements IDepartmentsService{
	
	@Autowired
	private IDepartmentsRepository repository; 
	
	@Override
	public List<Departments> all() {
		return repository.findAll();
	}

	@Override
	public Optional<Departments> findById(Integer id) {		
		return repository.findById(id);
	}

	@Override
	public Departments save(Departments departments) {		
		return repository.save(departments);
	}

	@Override
	public void delete(Integer id) {
		repository.deleteById(id);		
	}

}
