package com.unab.carrito.Service;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.unab.carrito.Collection.Cities;
import com.unab.carrito.IRepository.ICitiesRepository;
import com.unab.carrito.IService.ICitiesService;


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
