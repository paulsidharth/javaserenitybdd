package com.studentapp.junit.StudentInfo;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;

import io.restassured.RestAssured;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Manual;
import net.thucydides.core.annotations.Pending;

@RunWith(SerenityRunner.class) //annotation to use serenity
public class StudentInfo {
	
	@BeforeClass //junit annotation to initialize
	public static void init(){
		RestAssured.baseURI ="http://localhost:8080/student";
	}
	
	@Test //to mark as test this is a junit annotation
	public void getAllStudents(){
		SerenityRest.given()
		.when()
		.get("/list")
		.then()
		.log()
		.all()
		.statusCode(200);
		
	}
	
	@Ignore
	@Test
	public void thisIsSkip(){
		
		
	}
	
	@Test
	public void thisIsFailure(){
		SerenityRest.given()
		.when()
		.get("/list")
		.then()
		.log()
		.all()
		.statusCode(500);
		
	}

	@Pending
	@Test
	public void thisIsPending(){
		
		
	}
	
	@Test
	public void thisIsTestwithError(){
		
		System.out.println("failure test"+(5/0));
	}

	@Test
	public void fileDoesNotExist() throws FileNotFoundException{
		
		File file = new File("E://File.txt");
		FileReader fr = new FileReader(file);
	}
	@Manual
	@Test
	public void mannualTest(){
		
	}
}
