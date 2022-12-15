package com.unab.g04sql.Service;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.unab.g04sql.Entity.Brands;
import com.unab.g04sql.IRepository.IBrandsRepository;
import com.unab.g04sql.IService.IBrandsService;


@Service
public class BrandsService implements IBrandsService{
	
	@Autowired
	private IBrandsRepository repository; 
	
	@Override
	public List<Brands> all() {
		return repository.findAll();
	}

	@Override
	public Optional<Brands> findById(Integer id) {		
		return repository.findById(id);
	}

	@Override
	public Brands save(Brands brands) {		
		return repository.save(brands);
	}

	@Override
	public void delete(Integer id) {
		repository.deleteById(id);		
	}

}
