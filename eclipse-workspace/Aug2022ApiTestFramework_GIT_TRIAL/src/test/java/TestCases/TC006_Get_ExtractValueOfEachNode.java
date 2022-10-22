package TestCases;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class TC006_Get_ExtractValueOfEachNode {
	
@Test
	
	public void GetWeatherDetails() {
		
		//Specify base URI
			
			RestAssured.baseURI = "-----";
			
			
			//Request object
			RequestSpecification httpRequest = RestAssured.given();
			
			//Response object
			
			Response response = httpRequest.request(Method.GET,"/----");
			
			JsonPath jsonpath = response.jsonPath();//can extract all the values from reponse
			
			
		System.out.println	(jsonpath.get("----"));
		
		Assert.assertEquals(jsonpath.get("----"), "expected   ");
			
			
			
			
		

}
}
