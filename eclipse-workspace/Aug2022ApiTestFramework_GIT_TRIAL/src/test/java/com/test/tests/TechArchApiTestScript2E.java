package com.test.tests;


import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.AssertJUnit;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.test.helpers.ReusableMethods;


import com.test.helpers.UserServiceHelper;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class TechArchApiTestScript2E extends UserServiceHelper {
	
	
	public class TC001_GET_Request {
		@Test
		void getEmployeeDetails()
		
		{
			
			//Specify base URI
			
			RestAssured.baseURI = " https://dummy.restapiexample.com/api/v1";
			
			
			//Request object
			RequestSpecification httpRequest = RestAssured.given();
			
			//Response object
			
			Response response = httpRequest.request(Method.GET,"/employees");
			
			//print response in console window
			
		String responseBody =	response.getBody().asString();
		
		System.out.println("Response Body is :"  + responseBody);
		
		//status code validation
		
	    int statusCode=	response.getStatusCode();
	    
	    System.out.println("Status Code is : " + statusCode);
	    
	    Assert.assertEquals(statusCode, 200);
	    
	    //status line verification
	       
	   String statusLine= response.getStatusLine();
	   
	   System.out.println("Status Line :" +statusLine);
	   
	   Assert.assertEquals(statusLine, "success");
		}
		public class TC002_POST_Request {
			
			@Test
		void RegistrationSuccessful()
			
			{
				
				//Specify base URI
				
				RestAssured.baseURI = " https://dummy.restapiexample.com/api/v1";
				
				
				//Request object
				RequestSpecification httpRequest = RestAssured.given();
				
				
				
				//Request payload sending alongwith post request
				
				JSONObject requestParams = new JSONObject();
				
				requestParams.put("name ", "test ");
				requestParams.put("salary ", "123 ");
				requestParams.put("age ", "23");
				
				httpRequest.header("Content-Type","application/json");
				
				httpRequest.body(requestParams.toJSONString( ));//attach data to the request
				
				//Response object
				
				Response response = httpRequest.request(Method.POST,"/create");
				
				
				//print response in console window
				
			String responseBody =	response.getBody().asString();
			
			System.out.println("Response Body is :"  + responseBody);
			
			//status code validation
			
		    int statusCode=	response.getStatusCode();
		    
		    System.out.println("Status Code is : " + statusCode);
		    
		    Assert.assertEquals(statusCode, 200);
		    
		    String successCode =  response.jsonPath().get("SuccessCode");
		    
		    Assert.assertEquals(successCode, "Operation Success");
			}
			
			public class TC003_DELETE_Request {
				
				@Test
			void RegistrationSuccessful()
				
				{
					
					//Specify base URI
					
					RestAssured.baseURI = " https://dummy.restapiexample.com/api/v1";
					
					
					//Request object
					RequestSpecification httpRequest = RestAssured.given();
					
					JSONObject requestParams = new JSONObject();
					
					requestParams.remove("name ", "test ");
					requestParams.remove("salary ", "123 ");
					
					httpRequest.header("Content-Type","application/json");
					
					//Response object
					
					Response response = httpRequest.request(Method.DELETE,"/delete");
					
					String responseBody =	response.getBody().asString();
					
					System.out.println("Response Body is :"  + responseBody);
					
					//status code validation
					
				    int statusCode=	response.getStatusCode();
				    
				    System.out.println("Status Code is : " + statusCode);
				    
				    Assert.assertEquals(statusCode, 200);
				    
				    String successCode =  response.jsonPath().get("SuccessCode");
				    
				    Assert.assertEquals(successCode, "Operation Success");
					}
					
					
					
		    
		

	

}
		}
	}}

