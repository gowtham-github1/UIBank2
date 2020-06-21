package uibank.chaining;
import org.testng.annotations.BeforeSuite;

import io.restassured.RestAssured;

public class BaseClass {
	
public static String user_name = "gowthn2";
public static String user_password = "955135149s";
public static String accessToken;

	@BeforeSuite
public void init(){

	//end pint
	RestAssured.baseURI = "https://uibank-api.azurewebsites.net";	
	
	//base auth
		/*
		 * RestAssured.authentication = RestAssured .preemptive().basic(user_name,
		 * user_password);
		 */
	
		RestAssured.authentication = RestAssured.oauth2(accessToken); 
		 System.out.println("Authenticated");
}
}
