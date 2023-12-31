package com.projetosjavaUFBA.javaProject.entities;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name="tb_teacher")
public class Teacher implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private  Long id;
	private String username;
	private String name;
	private String email;
	private String phone;
	private String teachingArea;
	private String password;
	
	@OneToMany(mappedBy="teacher")
	private Set<Discipline> disciplines =new HashSet<>();
	
	public Teacher() {
		
	}
	
	
	
	
	public Teacher(Long id,String username, String name, String email, String phone,String teachingArea, String password ) {
		super();
		this.id = id;
		this.username=username;
		this.name = name;
		this.email = email;
		this.phone = phone;
		this.teachingArea = teachingArea;
		this.password = password;
		
		
	}




	public Long getId() {
		return id;
	}




	public void setId(Long id) {
		this.id = id;
	}

	



	public String getUsername() {
		return username;
	}




	public void setUsername(String username) {
		this.username = username;
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




	public String getPassword() {
		return password;
	}




	public void setPassword(String password) {
		this.password = password;
	}




	public String getTeachingArea() {
		return teachingArea;
	}




	public void setTeachingArea(String teachingArea) {
		this.teachingArea = teachingArea;
	}




	public Set<Discipline> getDisciplines() {
		return disciplines;
	}
	public void addDisciplines(Discipline d){
		disciplines.add(d);
		}




	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + Objects.hash(id);
		return result;
	}




	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Teacher other = (Teacher) obj;
		return id == other.id;
	}

}