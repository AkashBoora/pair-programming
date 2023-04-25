package com.pairprogramming.demo.controller;

import com.pairprogramming.demo.dto.PersonDTO;
import com.pairprogramming.demo.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

@RestController
@RequestMapping("persons")
public class PersonController {
	@Autowired
	PersonService personService;


	@PostMapping("/")
	public ResponseEntity<PersonDTO> savePerson(@RequestBody PersonDTO personDTO){
		try{
			personDTO = personService.savePerson(personDTO);
			return new ResponseEntity<>(personDTO,HttpStatus.CREATED);
		}catch (Exception e){
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST,e.getMessage());
		}
	}

	@GetMapping("/{id}")
	public ResponseEntity<PersonDTO> getPersonById(@PathVariable int id){
		try{
			PersonDTO personDTO = personService.getPersonById(id);
			return new ResponseEntity<>(personDTO,HttpStatus.OK);
		}catch (Exception e){
			throw new ResponseStatusException(HttpStatus.NOT_FOUND,e.getMessage());
		}
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<String> deletePerson(@PathVariable int id){
		try{
			personService.deletePersonById(id);
			return new ResponseEntity<>("Person is deleted successfully with id "+id, HttpStatus.OK);
		}catch (Exception e){
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST,e.getMessage());
		}
	}

	@PutMapping("/")
	public ResponseEntity<PersonDTO> updatePerson(@RequestBody PersonDTO personDTO){
		try{
			personDTO = personService.updatePersonbyId(personDTO);
			return new ResponseEntity<>(personDTO,HttpStatus.CREATED);
		}catch (Exception e){
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST,e.getMessage());
		}
	}
}
