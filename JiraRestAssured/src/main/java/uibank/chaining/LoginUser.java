package uibank.chaining;
import java.io.File;
import java.util.HashMap;
import java.util.Map;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class LoginUser extends BaseClass {
	
	public static String user_id;
	public static String token_id;
	
	File tokenFile = new File("./loginCredentials.json");
	@Test
	public void loginUser(){
		Map<String,String> requestBody = new HashMap<String,String>();
		requestBody.put("username",BaseClass.user_name);
		requestBody.put("password", BaseClass.user_password);

	Response response = RestAssured
			.given()
			.contentType(ContentType.JSON)
			.body(requestBody)
			.post("/api/users/login");
			
	
	//response.prettyPrint();
	
	int statusCode = response.getStatusCode(); 
	System.out.println("statusCode:" + statusCode);
	
	JsonPath jsonResponse = response.jsonPath();
	user_id = jsonResponse.get("userId");
	System.out.println("user_id:" + user_id);
	
	BaseClass.accessToken = jsonResponse.get("id");
	System.out.println("token_id:" + accessToken);
	
	
	}

}