package com.projetosjavaUFBA.javaProject.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projetosjavaUFBA.javaProject.entities.Teacher;
import com.projetosjavaUFBA.javaProject.repositories.TeacherRepository;
@Service
public class TeacherService {

	@Autowired
	private TeacherRepository teacherRepository;
	
	public List<Teacher>findALL(){
		return teacherRepository.findAll();
	}
	
	public Teacher findById(Long id) {
		Optional<Teacher> obj =teacherRepository.findById(id);
		return obj.get();
	}
	
	public Teacher insert(Teacher obj) {
		return teacherRepository.save(obj);
	}
	public void delete(Long id) {
		teacherRepository.deleteById(id);
	}
	public Teacher update(Long id, Teacher obj) {
		Teacher entity = teacherRepository.getReferenceById(id);
		updateData(entity,obj);
		return teacherRepository.save(entity);
	}

	private void updateData(Teacher entity, Teacher obj) {	
		entity.setName(obj.getName());
		entity.setEmail(obj.getEmail());
		entity.setPhone(obj.getPhone());
	}
	
}
