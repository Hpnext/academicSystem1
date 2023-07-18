package com.projetosjavaUFBA.javaProject.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.projetosjavaUFBA.javaProject.entities.Student;
import com.projetosjavaUFBA.javaProject.entities.Teacher;
import com.projetosjavaUFBA.javaProject.services.StudentService;



@RestController
@RequestMapping(value="/students")
public class StudentResource {
	
	@Autowired
	private StudentService studentService;
	
	
	@GetMapping
	public ResponseEntity<List<Student>> findAll(){
		List<Student> list = studentService.findALL();
		return ResponseEntity.ok().body(list);
	}
	@GetMapping(value="/{id}")
	public ResponseEntity<Student> findById(@PathVariable Long id){
		Student obj = studentService.findById(id);
		return ResponseEntity.ok().body(obj);
		
	}
	
	
}
