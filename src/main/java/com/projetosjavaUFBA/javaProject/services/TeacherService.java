package com.projetosjavaUFBA.javaProject.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import com.projetosjavaUFBA.javaProject.dto.TeacherDTO;
import com.projetosjavaUFBA.javaProject.entities.Teacher;
import com.projetosjavaUFBA.javaProject.repositories.TeacherRepository;
import com.projetosjavaUFBA.javaProject.services.exceptions.DatabaseException;
import com.projetosjavaUFBA.javaProject.services.exceptions.ResourceNotFoundException;

import jakarta.persistence.EntityNotFoundException;
@Service
public class TeacherService {

	@Autowired
	private TeacherRepository teacherRepository;
	
	public List<Teacher>findALL(){
		return teacherRepository.findAll();
	}
	
	public Teacher findById(Long id) {
		Optional<Teacher> obj =teacherRepository.findById(id);
		return obj.orElseThrow(()-> new ResourceNotFoundException(id));
	}
	
	public Teacher insert(Teacher obj) {
		return teacherRepository.save(obj);
	}
	public void delete(Long id) {
	    try {
	        if (teacherRepository.existsById(id)) {
	        	teacherRepository.deleteById(id);			
	        } else {				
	            throw new ResourceNotFoundException(id);			
	        }		
	    } catch (DataIntegrityViolationException e) {			
	        throw new DatabaseException(e.getMessage());		
	    }	
	} 
	public Teacher update(Long id, Teacher obj) {
		try {
		Teacher entity = teacherRepository.getReferenceById(id);
		updateData(entity,obj);
		return teacherRepository.save(entity);
		}catch (EntityNotFoundException e) {
			
			throw new ResourceNotFoundException(id);
		}
	}

	private void updateData(Teacher entity, Teacher obj) {	
		if(obj.getUsername()!=null) {
		entity.setUsername(obj.getUsername());
		}
		if(obj.getName()!=null) {
			entity.setName(obj.getName());
			}
		if(obj.getEmail()!=null) {
			entity.setEmail(obj.getEmail());
			}
		if(obj.getPhone()!=null) {
			entity.setPhone(obj.getPhone());
			}
		
	}
	
	public Teacher fromDTO(TeacherDTO objDto) {
		return new Teacher(objDto.getId(), null ,objDto.getName(),objDto.getEmail(),objDto.getPhone(),objDto.getTeachingArea(),null);
	}
	
}
