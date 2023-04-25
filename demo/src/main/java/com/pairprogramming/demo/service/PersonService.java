package com.pairprogramming.demo.service;

import com.pairprogramming.demo.dto.PersonDTO;

public interface PersonService {
	public PersonDTO savePerson(PersonDTO personDTO);

	public PersonDTO getPersonById(int id);

	public void deletePersonById(int id);

	public PersonDTO updatePersonbyId(PersonDTO personDTO);
}
