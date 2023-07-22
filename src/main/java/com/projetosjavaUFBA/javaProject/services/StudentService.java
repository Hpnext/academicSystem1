package com.projetosjavaUFBA.javaProject.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import com.projetosjavaUFBA.javaProject.entities.Student;
import com.projetosjavaUFBA.javaProject.entities.Teacher;
import com.projetosjavaUFBA.javaProject.repositories.StudentRepository;
import com.projetosjavaUFBA.javaProject.services.exceptions.DatabaseException;
import com.projetosjavaUFBA.javaProject.services.exceptions.ResourceNotFoundException;

import jakarta.persistence.EntityNotFoundException;
@Service
public class StudentService {

	@Autowired
	private StudentRepository studentRepository;
	
	public List<Student>findALL(){
		return studentRepository.findAll();
	}
	
	public Student findById(Long id) {
		Optional<Student> obj =studentRepository.findById(id);
		return obj.orElseThrow(()-> new ResourceNotFoundException(id));
	}
	public Student insert(Student obj) {
		return studentRepository.save(obj);
	}
	public void delete(Long id) {
	    try {
	        if (studentRepository.existsById(id)) {
	        	studentRepository.deleteById(id);			
	        } else {				
	            throw new ResourceNotFoundException(id);			
	        }		
	    } catch (DataIntegrityViolationException e) {			
	        throw new DatabaseException(e.getMessage());		
	    }	
	} 
	public Student update(Long id, Student obj) {
		try {
			Student entity = studentRepository.getReferenceById(id);
		updateData(entity,obj);
		return studentRepository.save(entity);
		}catch (EntityNotFoundException e) {
			
			throw new ResourceNotFoundException(id);
		}
	}


	private void updateData(Student entity, Student obj) {	
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

	
}
