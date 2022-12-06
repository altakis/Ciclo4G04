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

import com.unab.g04sql.Entity.Departments;
import com.unab.g04sql.IService.IDepartmentsService;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("api/departments")
public class DepartmentsController {

	@Autowired
	private IDepartmentsService service;
	
	@GetMapping
	public List<Departments> all() {
		return service.all();
	}
	
	@GetMapping("{id}")
	public Optional<Departments> show(@PathVariable Integer id) {
		return service.findById(id);
	}
	
	@PostMapping
	@ResponseStatus(code = HttpStatus.CREATED)
	public Departments save(@RequestBody Departments person) {
		return service.save(person);
	}
	
	@PutMapping("{id}")
	@ResponseStatus(code = HttpStatus.CREATED)
	public Departments update(@PathVariable Integer id, @RequestBody Departments departments) {
		Optional<Departments> op = service.findById(id);
		
		if (!op.isEmpty()) {
			Departments departmentsUpdate = op.get();
			departmentsUpdate.setCodigo(departments.getCodigo());
			departmentsUpdate.setNombre(departments.getNombre());
			departmentsUpdate.setEstado(departments.getEstado());
			return service.save(departmentsUpdate);
		}
		
		return departments;
	}
	
	@DeleteMapping("{id}")
	@ResponseStatus(code = HttpStatus.NO_CONTENT)
	public void delete(@PathVariable Integer id) {
		service.delete(id);
	}
	
}
