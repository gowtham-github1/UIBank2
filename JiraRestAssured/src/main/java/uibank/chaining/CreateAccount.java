package uibank.chaining;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class CreateAccount extends BaseClass {
	Random rand = new Random(); 
	
	@Test (dependsOnMethods = { "uibank.chaining.LoginUser.loginUser" })
public void createAccount(){
		
		//RestAssured.authentication = RestAssured.oauth2(BaseClass.accessToken); 
		
		/*
		 * RestAssured.authentication = RestAssured .preemptive().basic(user_name,
		 * user_password);
		 */
		 
	
		
		String randomAccountNumber = Integer.toString(rand.nextInt(10000000)); 
		String balance = Integer.toString(rand.nextInt(100)); 
		
		Map<String,String> requestBody = new HashMap<String,String>();
		requestBody.put("friendlyName","gowthn_Sunday");
		requestBody.put("type", "checking");
		requestBody.put("userId", LoginUser.user_id);
		requestBody.put("balance", "1000");
		requestBody.put("accountNumber", "27710346");
	//how to make a json library for update elements 
		
	Response response = RestAssured
			.given()
			.contentType(ContentType.JSON)
			.body(requestBody)
			.post("api/accounts");
			
	  
	//print the response
	response.prettyPrint();
	
	int statusCode = response.getStatusCode(); 
	System.out.println(statusCode);
	System.out.println(LoginUser.user_id);
	
	//how to assert here?
	
}
}
