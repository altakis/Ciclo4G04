package com.unab.g04nosql.Service;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.unab.g04nosql.Collection.Cities;
import com.unab.g04nosql.IRepository.ICitiesRepository;
import com.unab.g04nosql.IService.ICitiesService;


@Service
public class CitiesService implements ICitiesService{
	
	@Autowired
	private ICitiesRepository repository; 
	
	@Override
	public List<Cities> all() {
		return repository.findAll();
	}

	@Override
	public Optional<Cities> findById(String id) {		
		return repository.findById(id);
	}

	@Override
	public Cities save(Cities cities) {		
		return repository.save(cities);
	}

	@Override
	public void delete(String id) {
		repository.deleteById(id);		
	}

}
