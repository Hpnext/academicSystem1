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
	
	
}
