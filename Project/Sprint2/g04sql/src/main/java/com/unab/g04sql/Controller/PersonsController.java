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

import com.unab.g04sql.Entity.Persons;
import com.unab.g04sql.IService.IPersonsService;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("api/persons")
public class PersonsController {

	@Autowired
	private IPersonsService service;
	
	@GetMapping
	public List<Persons> all() {
		return service.all();
	}
	
	@GetMapping("{id}")
	public Optional<Persons> show(@PathVariable Integer id) {
		return service.findById(id);
	}
	
	@PostMapping
	@ResponseStatus(code = HttpStatus.CREATED)
	public Persons save(@RequestBody Persons person) {
		return service.save(person);
	}
	
	@PutMapping("{id}")
	@ResponseStatus(code = HttpStatus.CREATED)
	public Persons update(@PathVariable Integer id, @RequestBody Persons persons) {
		Optional<Persons> op = service.findById(id);
		
		if (!op.isEmpty()) {
			Persons personsUpdate = op.get();
			personsUpdate.setTipoDocumento(persons.getTipoDocumento());
			personsUpdate.setDocumento(persons.getDocumento());
			personsUpdate.setPrimerNombre(persons.getPrimerNombre());
			personsUpdate.setSegundoNombre(persons.getSegundoNombre());
			personsUpdate.setPrimerApellido(persons.getPrimerApellido());
			personsUpdate.setSegundoApellido(persons.getSegundoApellido());
			personsUpdate.setCorreo(persons.getCorreo());
			personsUpdate.setTelefono(persons.getTelefono());
			personsUpdate.setFechaNacimiento(persons.getFechaNacimiento());
			personsUpdate.setDireccion(persons.getDireccion());
			personsUpdate.setUsuarioId(persons.getUsuarioId());
			personsUpdate.setCiudadId(persons.getCiudadId());
			personsUpdate.setEstado(persons.getEstado());
			return service.save(personsUpdate);
		}
		
		return persons;
	}
	
	@DeleteMapping("{id}")
	@ResponseStatus(code = HttpStatus.NO_CONTENT)
	public void delete(@PathVariable Integer id) {
		service.delete(id);
	}
	
}
