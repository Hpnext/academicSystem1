package com.projetosjavaUFBA.javaProject.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.projetosjavaUFBA.javaProject.entities.Teacher;
import com.projetosjavaUFBA.javaProject.repositories.TeacherRepository;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {

	@Autowired
	private TeacherRepository teacherRepository;

	@Override
	public void run(String... args) throws Exception {
		Teacher u1 = new Teacher(null, "maria", "maria@gmail.com", "71985458745", "Computação","123");
		Teacher u2 = new Teacher(null, "pedro", "pedro@gmail.com", "719854228745", "Computação","12313123");
		
		teacherRepository.saveAll(Arrays.asList(u1,u2));
	}
}
