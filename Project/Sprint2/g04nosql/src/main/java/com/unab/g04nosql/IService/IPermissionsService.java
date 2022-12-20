package com.unab.g04nosql.IService;

import java.util.List;
import java.util.Optional;

import com.unab.g04nosql.Collection.Permissions;

public interface IPermissionsService {

    public List<Permissions> all();

    public Optional<Permissions> findById(String id);

    public Permissions save(Permissions permissions);

    public void delete(String id);
}
