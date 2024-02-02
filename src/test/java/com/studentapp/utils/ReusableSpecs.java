package com.studentapp.utils;

import java.util.concurrent.TimeUnit;

import org.hamcrest.Matcher;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import static org.hamcrest.Matchers.*;

public class ReusableSpecs {

	public static RequestSpecBuilder req;
	public static RequestSpecification reqspec;
	
	
	public static ResponseSpecBuilder res;
	public static ResponseSpecification resspec;
	
	
	public static RequestSpecification getGenericRequestSpec(){
		
		req = new RequestSpecBuilder();
		req.setContentType(ContentType.JSON);
		reqspec = req.build();
		
		return reqspec;
	}
	
	public static ResponseSpecification getGenericResponseSpec(){
		
		res = new ResponseSpecBuilder();
		res.expectHeader("Content-type", "application/json;charset=UTF-8");
		res.expectHeader("Transfer-Encoding","chunked");
		res.expectResponseTime(lessThan(5L),TimeUnit.SECONDS);
		resspec = res.build();
		
		return resspec;
	}

	
	
}
