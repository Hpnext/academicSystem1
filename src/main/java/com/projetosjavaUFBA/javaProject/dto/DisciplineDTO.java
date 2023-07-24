package com.projetosjavaUFBA.javaProject.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.projetosjavaUFBA.javaProject.entities.Discipline;
import com.projetosjavaUFBA.javaProject.entities.Student;
import com.projetosjavaUFBA.javaProject.entities.Teacher;

public class DisciplineDTO implements Serializable{
	
	
	
	private static final long serialVersionUID = 1L;
	private Long id;
	private String name;
	private String workLoad;
	private String teacher;
	private Teacher teacherAll;
	private List<Student> student =new ArrayList<>();
	private Set<String> studentName =new HashSet<>();
	
	public DisciplineDTO() {
		
	}
	public DisciplineDTO(Discipline obj) {
		id=obj.getId();
		name =obj.getName();
		workLoad=obj.getWorkLoad();
		teacherAll=obj.getTeacherAll();
		teacher=obj.getTeacher();
		student=obj.getStudent();
		studentName=obj.getStudentName();
		
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
	public String getWorkLoad() {
		return workLoad;
	}
	public void setWorkLoad(String workLoad) {
		this.workLoad = workLoad;
	}
	public String getTeacher() {
		return teacher;
	}
	public void setTeacher(String teacher) {
		this.teacher = teacher;
	}
	
	public Set<String> getStudentName() {
		return studentName;
	}
	@JsonIgnore
	public Teacher getTeacherAll() {
		return teacherAll;
	}
	@JsonIgnore
	public void setTeacherAll(Teacher teacherAll) {
		this.teacherAll = teacherAll;
	}
	
	

}
