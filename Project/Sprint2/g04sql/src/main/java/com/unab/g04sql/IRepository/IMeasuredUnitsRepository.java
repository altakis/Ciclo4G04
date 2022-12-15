package com.unab.g04sql.IRepository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.unab.g04sql.Entity.MeasuredUnits;

public interface IMeasuredUnitsRepository extends JpaRepository<MeasuredUnits, Integer> {

}
