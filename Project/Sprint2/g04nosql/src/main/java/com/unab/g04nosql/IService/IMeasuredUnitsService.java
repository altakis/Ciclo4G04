package com.unab.g04nosql.IService;

import java.util.List;
import java.util.Optional;

import com.unab.g04nosql.Collection.MeasuredUnits;

public interface IMeasuredUnitsService {

    public List<MeasuredUnits> all();

    public Optional<MeasuredUnits> findById(String id);

    public MeasuredUnits save(MeasuredUnits measuredUnits);

    public void delete(String id);
}
