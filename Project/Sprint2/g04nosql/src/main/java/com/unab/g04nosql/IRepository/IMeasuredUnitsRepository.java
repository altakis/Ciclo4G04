package com.unab.g04nosql.IRepository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.unab.g04nosql.Collection.MeasuredUnits;

public interface IMeasuredUnitsRepository extends MongoRepository<MeasuredUnits, String> {

}
