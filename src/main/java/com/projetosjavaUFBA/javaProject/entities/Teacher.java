package com.projetosjavaUFBA.javaProject.entities;

public class Teacher extends User {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String teachingArea;
	
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
	

}
