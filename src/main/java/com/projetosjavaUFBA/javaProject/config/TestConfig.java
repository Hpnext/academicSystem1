package com.projetosjavaUFBA.javaProject.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.projetosjavaUFBA.javaProject.entities.Discipline;
import com.projetosjavaUFBA.javaProject.entities.Student;
import com.projetosjavaUFBA.javaProject.entities.Teacher;
import com.projetosjavaUFBA.javaProject.repositories.DisciplineRepository;
import com.projetosjavaUFBA.javaProject.repositories.StudentRepository;
import com.projetosjavaUFBA.javaProject.repositories.TeacherRepository;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {

	@Autowired
	private TeacherRepository teacherRepository;
	@Autowired
	private StudentRepository studentRepository;
	@Autowired
	private DisciplineRepository disciplineRepository;
	

	@Override
	public void run(String... args) throws Exception {
		Teacher t1 = new Teacher(null, "maria", "maria@gmail.com", "71985458745", "Computação","123");
		Teacher t2 = new Teacher(null, "pedro", "pedro@gmail.com", "719854228745", "Computação","12313123");
		teacherRepository.saveAll(Arrays.asList(t1,t2));
		
		Student s1 = new Student(null, "Paulo", "paulo@gmail.com", "71985458745", "Ciência Da Computação","123");
		Student s2 = new Student(null, "Henrique", "Henrique@gmail.com", "71923285458745", "Ciência Da Computação","213124");
		studentRepository.saveAll(Arrays.asList(s1,s2));
		
		Discipline d1 = new Discipline(2L, "Introdução à Lógica de Programação", 60, null );
		disciplineRepository.saveAll(Arrays.asList(d1));
	}
}
