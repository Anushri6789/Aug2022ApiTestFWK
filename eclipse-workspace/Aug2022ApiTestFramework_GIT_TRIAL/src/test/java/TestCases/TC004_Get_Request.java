package TestCases;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class TC004_Get_Request {
	
	@Test
	
	public void GetWeatherDetails() {
		
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
	
	Headers allheaders=response.headers();//capture all the headers from response
	
	for (Header header: allheaders)
	{
		System.out.println(header.getName()+ "   "+ header.getValue());
		
	}
		

	
	

}
}
