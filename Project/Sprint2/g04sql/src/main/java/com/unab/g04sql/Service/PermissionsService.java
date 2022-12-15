package com.unab.g04sql.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.unab.g04sql.Entity.Permissions;
import com.unab.g04sql.IRepository.IPermissionsRepository;
import com.unab.g04sql.IService.IPermissionsService;

@Service
public class PermissionsService implements IPermissionsService {

    @Autowired
    private IPermissionsRepository repository;

    @Override
    public List<Permissions> all() {
        return repository.findAll();
    }

    @Override
    public Optional<Permissions> findById(Integer id) {
        return repository.findById(id);
    }

    @Override
    public Permissions save(Permissions permissions) {
        return repository.save(permissions);
    }

    @Override
    public void delete(Integer id) {
        repository.deleteById(id);
    }

}
