package com.projetosjavaUFBA.javaProject.dto;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import com.projetosjavaUFBA.javaProject.entities.Discipline;
import com.projetosjavaUFBA.javaProject.entities.Student;

public class StudentDTO implements Serializable {
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private  Long id;
	private String name;
	private String email;
	private String phone;
	private String course;
	private Set<Discipline> disciplines =new HashSet<>();
	public StudentDTO() {
		
	}
	public StudentDTO(Student obj) {
		id=obj.getId();
		name=obj.getName();
		email=obj.getEmail();
		phone=obj.getPhone();
		course=obj.getCourse();
		disciplines=obj.getDisciplines();
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getCourse() {
		return course;
	}
	public void setCourse(String course) {
		this.course = course;
	}
	public Set<Discipline> getDisciplines() {
		return disciplines;
	}
	
	

}
