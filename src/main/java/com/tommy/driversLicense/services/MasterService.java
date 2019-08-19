package com.tommy.driversLicense.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tommy.driversLicense.models.DLModel;
import com.tommy.driversLicense.models.PersonModel;
import com.tommy.driversLicense.repositories.DLRepository;
import com.tommy.driversLicense.repositories.PersonRepository;

@Service
public class MasterService {
	@Autowired
	private DLRepository dlRepository;
	@Autowired
	private PersonRepository personRepository;
	
	//adds a person
	public PersonModel addPerson(PersonModel p) {
		return personRepository.save(p);
	}

	//returns all the persons
	public List<PersonModel> allPersons() {
		return personRepository.findAll();
	}
	
	//adds a license
	public DLModel addLicense(String number, DLModel d) {
		d.setNumber(number);
		return dlRepository.save(d);
	}
	
	//retrieves a person by id (singular)
	public PersonModel findPerson(Long id) {
		Optional<PersonModel> optionalPerson = personRepository.findById(id);
		if(optionalPerson.isPresent()) {
			return optionalPerson.get();
		}
		return null;
	}

	
//	//retrieves an item by id (singular)
//	public TestModel findItem(Long id) {
//		Optional<TestModel> optionalItem = dlRepository.findById(id);
//		if(optionalItem.isPresent()) {
//			return optionalItem.get();
//		}
//		return null;
//	}
//
//	//retrieves all items pertaining to attribute (multiple)
//	public TestModel findItems(String attribute) {
//		List<TestModel> listItem = dlRepository.findByATTRIBUTEContaining(attribute);
//		if(listItem.size() > 0) {
//			return listItem;
//		return null;
//		}
//	}
//
//	//deletes an item by id
//	public void deleteItem(Long id) {
//		DLRepository.deleteById(id);
//	}

}


