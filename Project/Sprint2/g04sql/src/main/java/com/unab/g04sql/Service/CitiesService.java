package com.unab.g04sql.Service;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.unab.g04sql.Entity.Cities;
import com.unab.g04sql.IRepository.ICitiesRepository;
import com.unab.g04sql.IService.ICitiesService;


@Service
public class CitiesService implements ICitiesService{
	
	@Autowired
	private ICitiesRepository repository; 
	
	@Override
	public List<Cities> all() {
		return repository.findAll();
	}

	@Override
	public Optional<Cities> findById(Integer id) {		
		return repository.findById(id);
	}

	@Override
	public Cities save(Cities cities) {		
		return repository.save(cities);
	}

	@Override
	public void delete(Integer id) {
		repository.deleteById(id);		
	}

}
