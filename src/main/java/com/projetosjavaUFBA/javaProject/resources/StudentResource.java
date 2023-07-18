package com.projetosjavaUFBA.javaProject.resources;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.projetosjavaUFBA.javaProject.entities.Student;



@RestController
@RequestMapping(value="/students")
public class StudentResource {
	@GetMapping
	public ResponseEntity<Student> findAll(){
		Student u = new Student(3L, "Paulo", "paulo@gmail.com", "71985458745", "Ciência Da Computação","123");
		return ResponseEntity.ok().body(u);
	}
	
	
}
