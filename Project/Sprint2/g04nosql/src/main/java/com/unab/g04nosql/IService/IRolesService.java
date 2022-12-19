package com.unab.g04nosql.IService;

import java.util.List;
import java.util.Optional;

import com.unab.g04nosql.Collection.Roles;

public interface IRolesService {

    public List<Roles> all();

    public Optional<Roles> findById(Integer id);

    public Roles save(Roles roles);

    public void delete(Integer id);
}
