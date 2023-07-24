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

import com.projetosjavaUFBA.javaProject.dto.TeacherDTO;
import com.projetosjavaUFBA.javaProject.entities.Teacher;
import com.projetosjavaUFBA.javaProject.services.TeacherService;


@RestController
@RequestMapping(value="/teachers")
public class TeacherResource {
	@Autowired
	private TeacherService teacherService;
	
	@GetMapping
	public ResponseEntity<List<TeacherDTO>> findAll(){
		List<Teacher> list = teacherService.findALL();
		List<TeacherDTO> listDto= list.stream().map(x -> new TeacherDTO(x)).collect(Collectors.toList());
		return ResponseEntity.ok().body(listDto);
	}
	
	@GetMapping(value="/{id}")
	public ResponseEntity<TeacherDTO> findById(@PathVariable Long id){
		Teacher obj = teacherService.findById(id);
		return ResponseEntity.ok().body(new TeacherDTO(obj));
	}
	
	@PostMapping(value="/create")
	public ResponseEntity<TeacherDTO> insert(@RequestBody Teacher obj){
		obj=teacherService.insert(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
		.buildAndExpand(obj.getId()).toUri();
		
		return ResponseEntity.created(uri).body(new TeacherDTO(obj));
		
	}
	@DeleteMapping(value="/{id}")
	public ResponseEntity<Void> delete(@PathVariable Long id){
		teacherService.delete(id);
		return ResponseEntity.noContent().build();
	}
	
	@PutMapping(value="/{id}")
	public ResponseEntity<Void> update(@PathVariable Long id,@RequestBody TeacherDTO objDto){
		Teacher obj= teacherService.fromDTO(objDto);
		obj=teacherService.update(id, obj);
		return ResponseEntity.noContent().build();
		
	}
	
	
}