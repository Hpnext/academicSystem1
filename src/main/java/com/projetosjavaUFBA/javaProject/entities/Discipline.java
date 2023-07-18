package com.projetosjavaUFBA.javaProject.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;


@Entity
@Table(name="tb_discipline")
public class Discipline implements Serializable  {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String name;
	private Integer workLoad;
	private Teacher teacher;
	//private List<Student> student =new ArrayList<>();
	
	
	public Discipline() {
		super();
	}
	
	
	
	public Discipline(Long id, String name, Integer workLoad, Teacher teacher) {
		super();
		this.id = id;
		this.name = name;
		this.workLoad = workLoad;
		this.teacher = teacher;
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
	public Integer getWorkLoad() {
		return workLoad;
	}
	public void setWorkLoad(Integer workLoad) {
		this.workLoad = workLoad;
	}
	public Teacher getTeacher() {
		return teacher;
	}
	public void setTeacher(Teacher teacher) {
		this.teacher = teacher;
	}
	/*public List<Student> getStudent() {
		return student;
	}
	
	public void addStundet(Student s){
	student.add(s);
	}*/
	
	@Override
	public int hashCode() {
		return Objects.hash(id);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Discipline other = (Discipline) obj;
		return Objects.equals(id, other.id);
	}
	
	
	
	
}
