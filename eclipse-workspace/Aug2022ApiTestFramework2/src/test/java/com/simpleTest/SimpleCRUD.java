package com.simpleTest;

import static org.hamcrest.Matchers.*;

import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

public class SimpleCRUD {
	@Test
	
	public static void FirstTest() {
		
	RequestSpecification req=	RestAssured .given();
	
	//ResponseSpecification resspec = (ResponseSpecification) new ResponseSpecBuilder();
	 // resspec.expect().body(null, isEmptyOrNullString(), null)
			
			
			Response res= req.when().get("https://gorest.co.in/public-api/users/ ");
						
		res.prettyPrint();
	      res.then().statusCode(200);
	      res.then().time(Matchers.lessThan(5000L));
	      res.then().body("code", Matchers.equalTo(200));
	      res.then().body("data [0].id", Matchers.equalTo(3244));
	      
	     int code =  res.jsonPath().getInt("code");
	     System.out.println("response parse data code =" +code);
	     
	     String name = res.jsonPath().getString("data[2].name");
	     System.out.println("name=" +name);
	     System.out.println("num of data= " + res.jsonPath().get("data.size()"));
	      
	      
	  String response=    res.asString();
	  res.prettyPrint();
	  System.out.println("response content type = " +res.contentType());
	  System.out.println("status code = " +res.statusCode());
	  System.out.println(" Header X-Firefox-Spdy = " + res.header("cf-ray"));
	  System.out.println("res time = " +res.time());
	  
	//  System.out.println(response);
	
	}
@Test

public static void FirstTest1() {
	
  RestAssured 
      .given()
	  .log().all()
      .when()
	  .get("https://gorest.co.in/public-api/users/ ")
	  .then()
      
      .statusCode(200)
      .time(lessThan(5000L))
      .body("code",equalTo(200))
      .log().headers();
     // .body("data[0].id",equalTo(3244));	
			

		
	}
}

