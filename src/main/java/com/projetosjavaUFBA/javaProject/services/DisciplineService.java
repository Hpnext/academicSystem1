package com.projetosjavaUFBA.javaProject.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projetosjavaUFBA.javaProject.entities.Discipline;
import com.projetosjavaUFBA.javaProject.entities.Teacher;
import com.projetosjavaUFBA.javaProject.repositories.DisciplineRepository;
@Service
public class DisciplineService {

	@Autowired
	private DisciplineRepository disciplineRepository;
	
	public List<Discipline>findALL(){
		return disciplineRepository.findAll();
	}
	
	public Discipline findById(Long id) {
		Optional<Discipline> obj =disciplineRepository.findById(id);
		return obj.get();
	}
	public Discipline insert(Discipline obj) {
		return disciplineRepository.save(obj);
	}
	public void delete(Long id) {
		disciplineRepository.deleteById(id);
	}
	
	public Discipline update(Long id, Discipline obj) {
		Discipline entity = disciplineRepository.getReferenceById(id);
		updateData(entity,obj);
		return disciplineRepository.save(entity);
	}

	private void updateData(Discipline entity, Discipline obj) {	
		entity.setName(obj.getName());
		entity.setWorkLoad(obj.getWorkLoad());
	}

	
	
}
