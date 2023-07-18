package com.projetosjavaUFBA.javaProject.resources;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.projetosjavaUFBA.javaProject.entities.Teacher;


@RestController
@RequestMapping(value="/teachers")
public class TeacherResource {

	@GetMapping
	public ResponseEntity<Teacher> findAll(){
		Teacher u = new Teacher(1L, "maria", "maria@gmail.com", "71985458745", "Ciência Da Computação","123");
		return ResponseEntity.ok().body(u);
	}
}
