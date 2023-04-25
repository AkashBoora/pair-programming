package com.pairprogramming.demo.service.impl;

import com.pairprogramming.demo.dao.PersonRepository;
import com.pairprogramming.demo.dto.PersonDTO;
import com.pairprogramming.demo.entity.Person;
import com.pairprogramming.demo.exception.PersonNotFoundException;
import com.pairprogramming.demo.mapper.PersonMapper;
import com.pairprogramming.demo.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PersonServiceImpl implements PersonService {
	@Autowired
	PersonRepository personRepository;

	@Autowired
	PersonMapper personMapper;

	@Override
	public PersonDTO savePerson(PersonDTO personDTO) {
		Person person= personMapper.convertPersonDTOToPerson(personDTO);
		person = personRepository.save(person);
		return  personMapper.convertPersonToPersonDTO(person);
	}

	@Override
	public PersonDTO getPersonById(int id) {
		Optional<Person> result = personRepository.findById(id);
		if(result.isEmpty()){
			throw new PersonNotFoundException("Person Not Found with id "+id);
		}
		return personMapper.convertPersonToPersonDTO(result.get());
	}

	@Override
	public void deletePersonById(int id) {
		personRepository.deleteById(id);
	}

	@Override
	public PersonDTO updatePersonbyId(PersonDTO personDTO) {
		Person person= personMapper.convertPersonDTOToPerson(personDTO);
		Optional<Person> result = personRepository.findById(person.getId());
		if(result.isEmpty()){
			throw new PersonNotFoundException("Person Not Found with id "+person.getId());
		}
		person = personRepository.save(person);
		return  personMapper.convertPersonToPersonDTO(person);
	}
}
