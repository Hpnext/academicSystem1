package com.projetosjavaUFBA.javaProject.entities;

import java.util.ArrayList;
import java.util.List;

public class Student extends User{

	
	private static final long serialVersionUID = 1L;
	
	private String course;
	private List<Discipline> disciplines =new ArrayList<>();
	public Student() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Student(long id, String name, String email, String phone,String course, String password) {
		super(id, name, email, phone, password);
		this.course=course;
		// TODO Auto-generated constructor stub
	}

	public String getCourse() {
		return course;
	}

	public void setCourse(String course) {
		this.course = course;
	}

	public List<Discipline> getDisciplines() {
		return disciplines;
	}
	public void addDisciplines(Discipline d){
		disciplines.add(d);
		}
	

}
