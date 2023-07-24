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

import com.projetosjavaUFBA.javaProject.dto.DisciplineDTO;
import com.projetosjavaUFBA.javaProject.dto.StudentDTO;
import com.projetosjavaUFBA.javaProject.entities.Discipline;
import com.projetosjavaUFBA.javaProject.entities.Student;
import com.projetosjavaUFBA.javaProject.services.DisciplineService;



@RestController
@RequestMapping(value="/disciplines")
public class DisciplineResource {
	
	@Autowired
	private DisciplineService disciplineService;
	
	
	@GetMapping
	public ResponseEntity<List<DisciplineDTO>> findAll(){
		List<Discipline> list = disciplineService.findALL();
		List<DisciplineDTO> listDto= list.stream().map(x -> new DisciplineDTO(x)).collect(Collectors.toList());
		return ResponseEntity.ok().body(listDto);
	}
	@GetMapping(value="/{id}")
	public ResponseEntity<DisciplineDTO> findById(@PathVariable Long id){
		Discipline obj = disciplineService.findById(id);
		return ResponseEntity.ok().body(new DisciplineDTO(obj));
	}
	
	@PostMapping(value="/create")
	public ResponseEntity<DisciplineDTO> insert(@RequestBody Discipline obj){
		obj=disciplineService.insert(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(obj.getId()).toUri();
				
				return ResponseEntity.created(uri).body(new DisciplineDTO (obj));
	}
	
	@DeleteMapping(value="/{id}")
	public ResponseEntity<Void> delete(@PathVariable Long id){
		disciplineService.delete(id);
		return ResponseEntity.noContent().build();
	}
	@PutMapping(value="/{id}")
	public ResponseEntity<Void> update(@PathVariable Long id,@RequestBody DisciplineDTO objDto){
		
		Discipline obj=disciplineService.fromDTO(objDto);
		
		obj=disciplineService.update(id, obj);
		return ResponseEntity.noContent().build();
		
	}
	
	
}