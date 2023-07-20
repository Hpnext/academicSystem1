package com.projetosjavaUFBA.javaProject.resources;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.projetosjavaUFBA.javaProject.entities.Discipline;
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
	@PostMapping
	public ResponseEntity<Discipline> insert(@RequestBody Discipline obj){
		obj=disciplineService.insert(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(obj.getId()).toUri();
				
				return ResponseEntity.created(uri).body(obj);
	}
	@DeleteMapping(value="/{id}")
	public ResponseEntity<Void> delete(@PathVariable Long id){
		disciplineService.delete(id);
		return ResponseEntity.noContent().build();
	}
	
}