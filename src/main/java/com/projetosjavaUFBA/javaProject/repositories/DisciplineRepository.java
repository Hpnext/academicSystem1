package com.projetosjavaUFBA.javaProject.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.projetosjavaUFBA.javaProject.entities.Discipline;



public interface DisciplineRepository extends JpaRepository<Discipline, Long> {
	
	

}
