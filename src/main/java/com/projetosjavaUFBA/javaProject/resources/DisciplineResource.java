package com.projetosjavaUFBA.javaProject.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.projetosjavaUFBA.javaProject.entities.Discipline;
import com.projetosjavaUFBA.javaProject.entities.Teacher;
import com.projetosjavaUFBA.javaProject.services.DisciplineService;



@RestController
@RequestMapping(value="/disciplines")
public class DisciplineResource {
	
	@Autowired
	private DisciplineService disciplineService;
	
	
	@GetMapping
	public ResponseEntity<List<Discipline>> findAll(){
		List<Discipline> list = disciplineService.findALL();
		return ResponseEntity.ok().body(list);
	}
	@GetMapping(value="/{id}")
	public ResponseEntity<Discipline> findById(@PathVariable Long id){
		Discipline obj = disciplineService.findById(id);
		return ResponseEntity.ok().body(obj);
		
	}
}
