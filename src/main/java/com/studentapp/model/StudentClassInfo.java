package com.studentapp.model;


import java.util.List;

public class StudentClassInfo {
	
	
// 3 RULES OF POJO CLASS
	/*Cannot extends and being a child class
	 * Cannot have implements 
	 * No fancy annotations ex :@Entity(Hibernate)
	 * */
	
	
// For POJO to be a java bean
	/*No args constructor
	 * private variables
	 * get and setter methods
	 * serializable
	 * 
	 * */

	private int id;
	private String firstName;
	private String lastName;
	private String email;
	private String programme;
	private List<String> courses;
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
		}
	
	
	public List<String> getCourses() {
		return courses;
	}
	public void setCourses(List<String> courses) {
		this.courses = courses;
	}
	
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getProgramme() {
		return programme;
	}
	public void setProgramme(String programme) {
		this.programme = programme;
	}
	
	
}
