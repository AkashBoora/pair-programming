package com.pairprogramming.demo.mapper;

import com.pairprogramming.demo.dto.PersonDTO;
import com.pairprogramming.demo.entity.Person;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class PersonMapper {
	@Autowired
	ModelMapper modelMapper;

	public PersonDTO convertPersonToPersonDTO(Person person){
		return modelMapper.map(person,PersonDTO.class);
	}
	public Person convertPersonDTOToPerson(PersonDTO personDTO){
		return modelMapper.map(personDTO,Person.class);
	}
}
