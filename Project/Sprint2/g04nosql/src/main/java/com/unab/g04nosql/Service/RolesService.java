package com.unab.g04nosql.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.unab.g04nosql.Collection.Roles;
import com.unab.g04nosql.IRepository.IRolesRepository;
import com.unab.g04nosql.IService.IRolesService;

@Service
public class RolesService implements IRolesService {

    @Autowired
    private IRolesRepository repository;

    @Override
    public List<Roles> all() {
        return repository.findAll();
    }

    @Override
    public Optional<Roles> findById(Integer id) {
        return repository.findById(id);
    }

    @Override
    public Roles save(Roles roles) {
        return repository.save(roles);
    }

    @Override
    public void delete(Integer id) {
        repository.deleteById(id);
    }

}
