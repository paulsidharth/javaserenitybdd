package com.studentapp.junit.StudentInfo;

import org.junit.Test;
import org.junit.runner.RunWith;

import com.studentapp.testbase.TestBase;
import com.studentapp.utils.ReusableSpecs;

import net.serenitybdd.core.Serenity;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Title;
import net.thucydides.core.annotations.WithTag;
import net.thucydides.core.annotations.WithTags;

@RunWith(SerenityRunner.class)


public class TagsClass extends TestBase {
	
	
@WithTag("studentfeature:FAIL")
@Title("This scenario will in will throw error when we give a invalid Resource ")
@Test
public void getInvalidRequest(){
	SerenityRest.given()
	.log()
	.all()
	.when()
	.get("/listed")
	.then()
	.log()
	.all()
	.statusCode(400);

}
@WithTags({
@WithTag("studentfeature:SMOKE"),
@WithTag("studentfeature:PASS")
})
@Title("This scenario makes a valid request ")
@Test

public void validRequest(){
	
	SerenityRest.given()
	.spec(ReusableSpecs.getGenericRequestSpec())
	.when()
	.get("/list")
	.then()
	.statusCode(200);
}

@WithTags({
	@WithTag("studentfeature:FAIL"),
	@WithTag("studentfeature:SMOKE")
	
}
)
@Title("this scenario will fail because of the http method used")
@Test
public void errorRequest(){
	
	SerenityRest.given()
	.spec(ReusableSpecs.getGenericRequestSpec())
	.when()
	.post("/list")
	.then()
	.statusCode(405);
	
	
}













}
