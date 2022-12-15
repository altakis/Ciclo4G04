package com.unab.g04sql.IService;

import java.util.List;
import java.util.Optional;

import com.unab.g04sql.Entity.MeasuredUnits;

public interface IMeasuredUnitsService {
	
	public List<MeasuredUnits> all();
    
	public Optional<MeasuredUnits> findById(Integer id);
	    
	public MeasuredUnits save(MeasuredUnits measuredUnits);
	    
	public void delete(Integer id);
}
