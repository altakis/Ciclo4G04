package com.unab.g04sql.Service;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.unab.g04sql.Entity.RolesPermissions;
import com.unab.g04sql.IRepository.IRolesPermissionsRepository;
import com.unab.g04sql.IService.IRolesPermissionsService;


@Service
public class RolesPermissionsService implements IRolesPermissionsService{
	
	@Autowired
	private IRolesPermissionsRepository repository; 
	
	@Override
	public List<RolesPermissions> all() {
		return repository.findAll();
	}

	@Override
	public List<RolesPermissions> findById(Integer rolId) {		
		return repository.findAllByRolId(rolId);
	}

	@Override
	public RolesPermissions save(RolesPermissions rolesPermissions) {		
		return repository.save(rolesPermissions);
	}

	@Override
	public void delete(Integer id) {
		repository.deleteById(id);		
	}

}
