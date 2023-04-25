package com.pairprogramming.demo.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name="person")
public class Person {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer id;
	private String firstName;
	private String lastName;
}
