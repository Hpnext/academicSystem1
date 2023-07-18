package com.projetosjavaUFBA.javaProject.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.projetosjavaUFBA.javaProject.entities.Teacher;

public interface TeacherRepository extends JpaRepository<Teacher, Long> {
	
	

}
