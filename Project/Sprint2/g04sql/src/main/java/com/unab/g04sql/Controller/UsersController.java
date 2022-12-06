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

import com.unab.g04sql.Entity.Users;
import com.unab.g04sql.IService.IUsersService;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("api/users")
public class UsersController {

	@Autowired
	private IUsersService service;
	
	@GetMapping
	public List<Users> all() {
		return service.all();
	}
	
	@GetMapping("{id}")
	public Optional<Users> show(@PathVariable Integer id) {
		return service.findById(id);
	}
	
	@PostMapping
	@ResponseStatus(code = HttpStatus.CREATED)
	public Users save(@RequestBody Users person) {
		return service.save(person);
	}
	
	@PutMapping("{id}")
	@ResponseStatus(code = HttpStatus.CREATED)
	public Users update(@PathVariable Integer id, @RequestBody Users users) {
		Optional<Users> op = service.findById(id);
		
		if (!op.isEmpty()) {
			Users usersUpdate = op.get();
			usersUpdate.setUsuario(users.getUsuario());
			usersUpdate.setContrasenia(users.getContrasenia());
			usersUpdate.setEstado(users.getEstado());
			return service.save(usersUpdate);
		}
		
		return users;
	}
	
	@DeleteMapping("{id}")
	@ResponseStatus(code = HttpStatus.NO_CONTENT)
	public void delete(@PathVariable Integer id) {
		service.delete(id);
	}
	
}
