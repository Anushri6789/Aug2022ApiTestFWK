package TestCases;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class TC003_GET_Request {
	
	@Test
	
void googleMapTest()
	
	{
		
		//Specify base URI
		
		RestAssured.baseURI = "-----";
		
		
		//Request object
		RequestSpecification httpRequest = RestAssured.given();
		
		//Response object
		
		Response response = httpRequest.request(Method.GET,"/----");
		
		//capturing headers from this. Sending the url in postman to get all the headers
		
		//print response in console window
		
	String responseBody =	response.getBody().asString();
	
	System.out.println("Response Body is :"  + responseBody);
	
// Validating headers
	
  String contentType=	response.header("----");//capture details of this header
  
  System.out.println("Content Type is : " + contentType);
  Assert.assertEquals(contentType, "----");
  
  //Repeat the above lines for all the required headers
	
	
	
	

}
}
