package com.studentapp.junit.StudentInfo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.hamcrest.Matcher;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.internal.MethodSorter;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;

import com.studentapp.cucumber.steps.StudentSteps;
import com.studentapp.model.StudentClassInfo;
import com.studentapp.testbase.TestBase;
import com.studentapp.utils.ReusableSpecs;
import com.studentapp.utils.TestUtilEmailClass;

import io.restassured.http.ContentType;
import net.serenitybdd.core.Serenity;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.annotations.Title;
import static org.hamcrest.Matchers.*;
import static org.junit.Assert.*;


@RunWith(SerenityRunner.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class StudentCRUD extends TestBase {

	public static String firstName;
	public static String lastName;
	public static String email;
	public static String programme;
	public static int StudentId;
	
	
@Steps
StudentSteps studentSteps;


@Title("this scenario will create a new student to list")
@Test
public  void test001()
{
	ArrayList<String> courses = new ArrayList<String>();
	courses.add("java");
	courses.add("Javascript");
	
	firstName="Paul"+TestUtilEmailClass.getRandomValue();
	 lastName= "Bonagiri"+TestUtilEmailClass.getRandomValue();
	 email= TestUtilEmailClass.getRandomValue()+"paul.bonagiri@cvshealth.com";
	 programme="Quality Engineering";
	
	 //Reusable method usage 1
	 
	 StudentSteps create = new StudentSteps();
	 create.createStudentRequest(firstName, lastName, email, programme, courses).statusCode(201).spec(ReusableSpecs.getGenericResponseSpec());
	
	
	
/*	StudentClassInfo req = new StudentClassInfo();
	req.setFirstName(firstName);
	req.setLastName(lastName);
	req.setEmail(email);
	req.setProgramme(programme);
	req.setCourses(courses);
	
	
	SerenityRest.given()
	.contentType(ContentType.JSON)
	.when()
	.body(req)
	.log()
	.all()
	.post()
	.then()
	.log()
	.all()
	.statusCode(201);*/
	
	
}
@Title("this scenario will get the list and check if the new student has been added to the list")
@Test
	public void test002()
	{
//	String p1 ="findAll{it.firstName=='";
//	String p2 ="'}.get(0)";
//	
//	HashMap<String,Object> value = SerenityRest.rest().given()
//	.when()
//	.log()
//	.all()
//	.get("/list")
//	.then()
//	.extract()
//	.path(p1+firstName+p2);
	
	HashMap<String,Object> value = studentSteps.getStudentList(firstName);
	
	System.out.println("the value is:" + value);
	
	assertThat(value,hasValue(firstName));
	
	StudentId = (int) value.get("id");
	
		
	}


@Title("this scenario will update firstname and lastname the list using an put method")
@Test
public void test003(){

	ArrayList<String> courses = new ArrayList<String>();
	courses.add("java");
	courses.add("Javascript");
	
	
	
	firstName = firstName+"_Updated";
	lastName +="_Updated";

	 HashMap<String, Object> updatedvalue = studentSteps.updateStudent(firstName, lastName, email, programme, StudentId, courses);
			System.out.println("the value is:" +updatedvalue);
			
			assertThat(updatedvalue,hasValue(firstName));
			//assertThat(value,hasValue("illegal"));
		
			
	
}

@Title("This scenario will delete the user and verify through get Request")
@Test
public void test004(){
	
//	SerenityRest.rest().given()
//	.when()
//	.log()
//	.all()
//	.delete("/"+StudentId);
//	
//	
//	SerenityRest.rest().given()
//	.when()
//	.get("/"+StudentId)
//	.then()
//	.statusCode(404);
	
	studentSteps.deleteStudent(StudentId).statusCode(404);
}
}
