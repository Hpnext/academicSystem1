package com.projetosjavaUFBA.javaProject.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.projetosjavaUFBA.javaProject.entities.Teacher;
import com.projetosjavaUFBA.javaProject.services.TeacherService;


@RestController
@RequestMapping(value="/teachers")
public class TeacherResource {
	@Autowired
	private TeacherService teacherService;
	
	@GetMapping
	public ResponseEntity<List<Teacher>> findAll(){
		List<Teacher> list = teacherService.findALL();
		return ResponseEntity.ok().body(list);
	}
	@GetMapping(value="/{id}")
	public ResponseEntity<Teacher> findById(@PathVariable Long id){
		Teacher obj = teacherService.findById(id);
		return ResponseEntity.ok().body(obj);
		
	}
}