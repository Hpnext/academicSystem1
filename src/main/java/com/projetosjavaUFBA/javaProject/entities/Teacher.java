package com.projetosjavaUFBA.javaProject.entities;

import java.util.ArrayList;
import java.util.List;

public class Teacher extends User {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String teachingArea;
	private List<Discipline> disciplines =new ArrayList<>();
	
	public Teacher() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Teacher(long id, String name, String email, String phone, String teachingArea, String password) {
		super(id, name, email, phone, password);
		this.teachingArea=teachingArea;
	}
	public String getTeachingArea() {
		return teachingArea;
	}
	public void setTeachingArea(String teachingArea) {
		this.teachingArea = teachingArea;
	}
	public List<Discipline> getDisciplines() {
		return disciplines;
	}
	public void addDisciplines(Discipline d){
		disciplines.add(d);
		}

}
