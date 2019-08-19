package com.tommy.driversLicense.repositories;
import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.tommy.driversLicense.models.PersonModel;

@Repository
public interface PersonRepository extends CrudRepository<PersonModel, Long> {
	List<PersonModel> findAll(); //finds all items
	List<PersonModel> findById(String id); //finds multiple persons by id
}
	


