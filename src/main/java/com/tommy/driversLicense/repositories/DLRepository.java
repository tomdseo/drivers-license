package com.tommy.driversLicense.repositories;

import org.springframework.data.repository.CrudRepository;


import com.tommy.driversLicense.models.DLModel;


public interface DLRepository extends CrudRepository<DLModel, Long> {
//	List<TestModel> findAll(); //finds all items
//	List<TestModel> findById(String id); //finds multiple items by id
//	List<DLModel> findByATTRIBUTEContaining(String ATTRIBUTE) //finds multiple items by ATTRIBUTE
//	List<TestModel> deleteById(String id); //deletes multiple items by id
//	List<TestModel> findByOrderByATTRIBUTEDesc(); //finds multiple items by ATTRIBUTE and (reverse)ranks them based on number/alphabet
//	List<TestModel> findByOrderByATTRIBUTE(); //finds multiple items by ATTRIBUTE and ranks them based on number/alphabet

}


