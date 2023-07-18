package com.projetosjavaUFBA.javaProject.resources;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.projetosjavaUFBA.javaProject.entities.Discipline;
import com.projetosjavaUFBA.javaProject.entities.Teacher;



@RestController
@RequestMapping(value="/disciplines")
public class DisciplineResource {
	@GetMapping
	public ResponseEntity<Discipline> findAll(){
		Teacher t = new Teacher(1L, "maria", "maria@gmail.com", "71985458745", "CComputação","123");
		Discipline u = new Discipline(2L, "Introdução à Lógica de Programação", 60, t );
		return ResponseEntity.ok().body(u);
	}
}
