package com.projetosjavaUFBA.javaProject.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;


@Entity
@Table(name="tb_discipline")
public class Discipline implements Serializable  {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String name;
	private String workLoad;
	//@JsonIgnore
	@ManyToOne
	@JoinColumn(name="teacher_id")
	private Teacher teacher;
	//@JsonIgnore
	@ManyToMany
	@JoinTable(name="tb_discipline_student",
	joinColumns=@JoinColumn(name="discipline_id"),
	inverseJoinColumns=@JoinColumn(name="student_id"))
	private List<Student> student =new ArrayList<>();
	private List<String> studentName =new ArrayList<>();
	
	
	public Discipline() {
		super();
	}
	
	
	
	public Discipline(Long id, String name, String workLoad, Teacher teacher) {
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
	public String getWorkLoad() {
		return workLoad;
	}
	public void setWorkLoad(String workLoad) {
		this.workLoad = workLoad;
	}
	//@JsonIgnore
	
	public String getTeacher() {
		if(teacher!=null) {
			return teacher.getName();
		}
		else {
			return null;
		}
	}
	
	//@JsonIgnore
	public void setTeacher(Teacher teacher) {
		this.teacher = teacher;
	}
    @JsonIgnore
	public List<Student> getStudent() {
		return student;
	}
    
    public List<String> getStudentName() {
    	for (int i=0; i<student.size(); i++) {
    		studentName.add(student.get(i).getName());
    	}
    	
		return studentName;
	}
    
    
    	
	
	//@JsonIgnore
	public void addStundet(Student s){
	student.add(s);
	}
	
	



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