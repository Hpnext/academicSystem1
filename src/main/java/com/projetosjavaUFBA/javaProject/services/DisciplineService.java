package com.projetosjavaUFBA.javaProject.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import com.projetosjavaUFBA.javaProject.dto.DisciplineDTO;
import com.projetosjavaUFBA.javaProject.dto.StudentDTO;
import com.projetosjavaUFBA.javaProject.entities.Discipline;
import com.projetosjavaUFBA.javaProject.entities.Student;
import com.projetosjavaUFBA.javaProject.repositories.DisciplineRepository;
import com.projetosjavaUFBA.javaProject.services.exceptions.DatabaseException;
import com.projetosjavaUFBA.javaProject.services.exceptions.ResourceNotFoundException;

import jakarta.persistence.EntityNotFoundException;
@Service
public class DisciplineService {

	@Autowired
	private DisciplineRepository disciplineRepository;
	
	public List<Discipline>findALL(){
		return disciplineRepository.findAll();
	}
	
	public Discipline findById(Long id) {
		Optional<Discipline> obj =disciplineRepository.findById(id);
		return obj.orElseThrow(()-> new ResourceNotFoundException(id));
	}
	public Discipline insert(Discipline obj) {
		return disciplineRepository.save(obj);
	}
	public void delete(Long id) {
	    try {
	        if (disciplineRepository.existsById(id)) {
	        	disciplineRepository.deleteById(id);			
	        } else {				
	            throw new ResourceNotFoundException(id);			
	        }		
	    } catch (DataIntegrityViolationException e) {			
	        throw new DatabaseException(e.getMessage());		
	    }	
	} 
	
	public Discipline update(Long id, Discipline obj) {
		try {
			Discipline entity = disciplineRepository.getReferenceById(id);
		updateData(entity,obj);
		return disciplineRepository.save(entity);
		}catch (EntityNotFoundException e) {
			
			throw new ResourceNotFoundException(id);
		}
	}


	private void updateData(Discipline entity, Discipline obj) {	
		if(obj.getName()!=null) {
		entity.setName(obj.getName());
		}
		if(obj.getWorkLoad()!=null) {
		entity.setWorkLoad(obj.getWorkLoad());
		}
	}
	
	
	public Discipline fromDTO(DisciplineDTO objDto) {
		return new Discipline(objDto.getId() ,objDto.getName(),objDto.getWorkLoad(),objDto.getTeacherAll());
	}

	
	
}
