package com.simpleTest;

import org.hamcrest.Matchers;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.pojo.LoginRequestPOJO;
import com.pojo.LoginResponsePOJO;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.http.Header;
import io.restassured.module.jsv.JsonSchemaValidator;
import io.restassured.response.Response;

public class TekarchLogin {
	
	//https://qa01-tekarch-accmanager.web.app/dashboard
	
	@BeforeClass
	
	public static void setup() {
		
	
	RestAssured.baseURI = "https://qa01-tekarch-accmanager.web.app/dashboard ";
	}
	
	public static String login() {
		
		Response res=	RestAssured
				.given()
				.body("{\"username\":\"anu.rattehalli@gmail.com\",\"password\":\"anu123\"}")  
				.contentType(ContentType.JSON)
				.when()
				.post("login");
		
		String token=res.jsonPath().get("[0].token");
		return token;
	}
	
	@Test(enabled= false)
	
	public static void logIntoApi()
	{
		
		LoginRequestPOJO loginData = new LoginRequestPOJO();
		loginData.setUsername("anu.rattehalli@gmail.com");
		loginData.setPassword("anu123");
		
	Response res=	RestAssured
		.given()
		.body(loginData)  
		.contentType(ContentType.JSON)
		.when()
		.post("login");
	
	LoginResponsePOJO[] list =	res.as(LoginResponsePOJO[].class);
	String token1 = list[0].getToken();
	System.out.println("token1===============" +token1);
	
	res.then().statusCode(201);
	String token=res.jsonPath().get("[0].token");
	String userid= res.jsonPath().get("[0].userid");
	
	System.out.println("token= " +token);
	System.out.println("userid = " +userid);
	res.prettyPrint();
	
	res.then().body(JsonSchemaValidator.matchesJsonSchemaInClasspath("LoginSchemaa.json"));
	//LoginSchemaa.json file has to created in resources	
		
}
	@Test(dependsOnMethods = "deleteUserInfo",enabled=false)
	public static void getuserDetails() {
		
		String token1= login();
		System.out.println(token1);
		Header header= new Header("token", login());
	Response res=RestAssured
		.given()
		.header( header)
		.when()
		.get("getdata");
		res.then().statusCode(200);
	System.out.println("number of records =" + res.jsonPath().get("size()"));
	String userId= res.jsonPath().get("[0].userid");
	String id= res.jsonPath().get("[0].id");
	String accountnum =res.jsonPath().getString("[0].accountno");
	System.out.println("accountno= " +accountnum);
	
	String departmentno =res.jsonPath().getString("[0].departmentno");
	System.out.println("departmentno= " +departmentno);
	
	String salary =res.jsonPath().getString("[0].salary");
	System.out.println("salary= " +salary);
	
	
	System.out.println("first entry userdata userid and id is =" + userId+" and " +id);
	
	res.then().body("[0].departmentno", Matchers.equalTo(3));
		
	}
	@Test(enabled=false)
	
	public static void createUserDetails() {
		
		String token1= login();
		Header header = new Header(" token",token1);
		Response res= RestAssured.given()
		
		.header(header)
		.contentType(ContentType.JSON)
		.body("{\"accountno\":\"TA-Aug2202\",\"departmentno\":\"1\",\"salary\":\"5000\",\"pincode\":\"123123\"}")
	    .when()
	    .post("addData");
		
		res.then().statusCode(201);
		res.then().body("status", Matchers.equalTo("success"));
	    
	}
	@Test(enabled= false)
public static void updateUserDetails() {
		
		String token1= login();
		Header header = new Header(" token",token1);
		Response res= RestAssured.given()
		
		.header(header)
		.contentType(ContentType.JSON)
		.body("{\"accountno\":\"TA-Aug2202\",\"departmentno\":3,\"salary\":\"6000\",\"pincode\":123123,\"userid\":\"zhFI4oQ1HjP2cn3mW3GP\",\"id\":\"WcDgjVdv0TEb6hS\"}")
	    .when()
	    .put("updateData");
		
		res.then().statusCode(200);
		res.then().body("status", Matchers.equalTo("success"));
	    
		
}
	
	@Test(enabled=false)
	
public static void deleteUserInfo() {
		
		String token1= login();
		Header header = new Header(" token",token1);
		Response res= RestAssured.given()
		
		.header(header)
		.contentType(ContentType.JSON)
		.body("{\"id\":\"WcDgjVdv0TEb6hS\",\"userid\":\"zhFI4oQ1HjP2cn3mW3GP\"}")
	    .when()
	    .delete("deleteData");
		
		res.then().statusCode(200);
		res.then().contentType(ContentType.JSON);
		res.then().body("status", Matchers.equalTo("success"));
	    

}
}
