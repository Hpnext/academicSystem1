package com.projetosjavaUFBA.javaProject.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projetosjavaUFBA.javaProject.entities.Student;
import com.projetosjavaUFBA.javaProject.repositories.StudentRepository;
@Service
public class StudentService {

	@Autowired
	private StudentRepository studentRepository;
	
	public List<Student>findALL(){
		return studentRepository.findAll();
	}
	public Student findById(Long id) {
		Optional<Student> obj =studentRepository.findById(id);
		return obj.get();
	}
	public Student insert(Student obj) {
		return studentRepository.save(obj);
	}
	public void delete(Long id) {
		studentRepository.deleteById(id);
	}
	
}
