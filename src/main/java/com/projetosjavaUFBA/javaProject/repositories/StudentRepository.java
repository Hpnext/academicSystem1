package com.projetosjavaUFBA.javaProject.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.projetosjavaUFBA.javaProject.entities.Student;


public interface StudentRepository extends JpaRepository<Student, Long> {
	
	

}
