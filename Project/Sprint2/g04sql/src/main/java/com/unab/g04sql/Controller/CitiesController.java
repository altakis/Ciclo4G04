package com.unab.g04sql.Controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.unab.g04sql.Entity.Cities;
import com.unab.g04sql.IService.ICitiesService;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("api/cities")
public class CitiesController {

	@Autowired
	private ICitiesService service;
	
	@GetMapping
	public List<Cities> all() {
		return service.all();
	}
	
	@GetMapping("{id}")
	public Optional<Cities> show(@PathVariable Integer id) {
		return service.findById(id);
	}
	
	@PostMapping
	@ResponseStatus(code = HttpStatus.CREATED)
	public Cities save(@RequestBody Cities person) {
		return service.save(person);
	}
	
	@PutMapping("{id}")
	@ResponseStatus(code = HttpStatus.CREATED)
	public Cities update(@PathVariable Integer id, @RequestBody Cities cities) {
		Optional<Cities> op = service.findById(id);
		
		if (!op.isEmpty()) {
			Cities citiesUpdate = op.get();
			citiesUpdate.setCodigo(cities.getCodigo());
			citiesUpdate.setNombre(cities.getNombre());
			citiesUpdate.setDepartmentId(cities.getDepartmentId());
			citiesUpdate.setEstado(cities.getEstado());
			return service.save(citiesUpdate);
		}
		
		return cities;
	}
	
	@DeleteMapping("{id}")
	@ResponseStatus(code = HttpStatus.NO_CONTENT)
	public void delete(@PathVariable Integer id) {
		service.delete(id);
	}
	
}
