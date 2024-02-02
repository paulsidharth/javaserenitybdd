package com.studentapp.junit.StudentInfo;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;

import com.studentapp.cucumber.steps.StudentSteps;
import com.studentapp.testbase.TestBase;

import io.restassured.response.ValidatableResponse;
import net.serenitybdd.junit.runners.SerenityParameterizedRunner;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.annotations.Title;
import net.thucydides.junit.annotations.Concurrent;
import net.thucydides.junit.annotations.UseTestDataFrom;

@Concurrent //can run two threads per CPU core to run (threads="4x") can run 4 runs per CPU core
@RunWith(SerenityParameterizedRunner.class)
@UseTestDataFrom("testdata/studentinfo.csv")
public class CreateMultipleStudents extends TestBase {
	
	@Steps
	StudentSteps steps;
	
	String firstName;
	public StudentSteps getSteps() {
		return steps;
	}

	public void setSteps(StudentSteps steps) {
		this.steps = steps;
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

	public String getCourses() {
		return course;
	}

	public void setCourses(String courses) {
		this.course = course;
	}

	String lastName;
	String email;
	String programme; 
	String course;
	
	@Title("This is to create multiple students from csv")
	@Test
	public  void  createMutlipleStudents(){
		List<String> courses = new ArrayList<String>();
		courses.add(course);
		steps.createStudentRequest(firstName, lastName, email, programme, courses).statusCode(201);
		

		
	}
}
