package com.projetosjavaUFBA.javaProject.resources;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.projetosjavaUFBA.javaProject.dto.StudentDTO;
import com.projetosjavaUFBA.javaProject.dto.TeacherDTO;
import com.projetosjavaUFBA.javaProject.entities.Student;
import com.projetosjavaUFBA.javaProject.services.StudentService;



@RestController
@RequestMapping(value="/students")
public class StudentResource {
	
	@Autowired
	private StudentService studentService;
	
	
	@GetMapping
	public ResponseEntity<List<StudentDTO>> findAll(){
		List<Student> list = studentService.findALL();
		List<StudentDTO> listDto= list.stream().map(x -> new StudentDTO(x)).collect(Collectors.toList());
		return ResponseEntity.ok().body(listDto);
	}
	@GetMapping(value="/{id}")
	public ResponseEntity<StudentDTO> findById(@PathVariable Long id){
		Student obj = studentService.findById(id);
		return ResponseEntity.ok().body(new StudentDTO(obj));
	}
	
	@PostMapping(value="/create")
	public ResponseEntity<StudentDTO> insert(@RequestBody Student obj){
		obj=studentService.insert(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(obj.getId()).toUri();
				
				return ResponseEntity.created(uri).body(new StudentDTO(obj));
		
	}
	@DeleteMapping(value="/{id}")
	public ResponseEntity<Void> delete(@PathVariable Long id){
		studentService.delete(id);
		return ResponseEntity.noContent().build();
	}
	
	@PutMapping(value="/{id}")
	public ResponseEntity<Void> update(@PathVariable Long id,@RequestBody StudentDTO objDto){
		
		Student obj=studentService.fromDTO(objDto);
		obj=studentService.update(id, obj);
		return ResponseEntity.noContent().build();
		
	}
	
	
	
	
}
