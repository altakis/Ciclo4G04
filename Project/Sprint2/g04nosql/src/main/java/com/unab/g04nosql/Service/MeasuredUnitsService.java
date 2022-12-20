package com.unab.g04nosql.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.unab.g04nosql.Collection.MeasuredUnits;
import com.unab.g04nosql.IRepository.IMeasuredUnitsRepository;
import com.unab.g04nosql.IService.IMeasuredUnitsService;

@Service
public class MeasuredUnitsService implements IMeasuredUnitsService {

    @Autowired
    private IMeasuredUnitsRepository repository;

    @Override
    public List<MeasuredUnits> all() {
        return repository.findAll();
    }

    @Override
    public Optional<MeasuredUnits> findById(String id) {
        return repository.findById(id);
    }

    @Override
    public MeasuredUnits save(MeasuredUnits measuredUnits) {
        return repository.save(measuredUnits);
    }

    @Override
    public void delete(String id) {
        repository.deleteById(id);
    }

}
