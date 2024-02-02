package com.studentapp.cucumber.steps;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.studentapp.model.StudentClassInfo;
import com.studentapp.utils.ReusableSpecs;

import io.restassured.http.ContentType;
import io.restassured.response.ValidatableResponse;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.annotations.Steps;

public class StudentSteps {

	
	public ValidatableResponse createStudentRequest( String firstName,String lastName,String email,String programme,List courses)
	{
		StudentClassInfo req = new StudentClassInfo();
		req.setFirstName(firstName);
		req.setLastName(lastName);
		req.setEmail(email);
		req.setProgramme(programme);
		req.setCourses(courses);
		
		
	return	SerenityRest.given()
		.spec(ReusableSpecs.getGenericRequestSpec())
		.when()
		.body(req)
		.log()
		.all()
		.post()
		.then()
		.log()
		.all();
	}
	
@Step("The value of firstName:{0}")
	public   HashMap<String,Object>  getStudentList(String firstName ) {
		
		String p1 ="findAll{it.firstName=='";
		String p2 ="'}.get(0)";
		
		HashMap<String,Object> value = SerenityRest.rest().given()
				.when()
				.log()
				.all()
				.get("/list")
				.then()
				.extract()
				.path(p1+firstName+p2);
		
		return value;
	}


@Step("this is create an update request with values firstName:{0}, lastName:{1}, courses:{5}")
public HashMap<String,Object>  updateStudent(String firstName,String lastName, String email,String programme,int StudentId, List courses ){
	
	String p1 ="findAll{it.firstName=='";
	String p2 ="'}.get(0)";
	
	
	StudentClassInfo req = new StudentClassInfo();
	req.setFirstName(firstName);
	req.setLastName(lastName);
	req.setEmail(email);
	req.setProgramme(programme);
	req.setCourses(courses);
	
	
	
	SerenityRest.given()
	.spec(ReusableSpecs.getGenericRequestSpec())
	.when()
	.body(req)
	.log()
	.all()
	.put("/"+StudentId)
	.then()
	.log()
	.all();
	
	HashMap<String,Object> value = SerenityRest.rest().given()
			.when()
			.log()
			.all()
			.get("/list")
			.then()
			.extract()
			.path(p1+firstName+p2);
	
	return value;
			
			


}

@Step("the student Id with value Student:{0} will be deletd")
public ValidatableResponse deleteStudent(int StudentId){
	
	
	SerenityRest.rest().given()
	.when()
	.log()
	.all()
	.delete("/"+StudentId);
	
	
	return SerenityRest.rest().given()
	.when()
	.get("/"+StudentId)
	.then();
	
	
}

}
