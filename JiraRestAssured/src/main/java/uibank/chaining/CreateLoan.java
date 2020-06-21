package uibank.chaining;
import java.io.File;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class CreateLoan extends BaseClass {
	
	public static String loan_id;
	
	File jsonFile = new File("./loanCredentials.json");
	
	@Test ()
public void createAccount(){
	
	Response response = RestAssured
			.given()
			.contentType(ContentType.JSON)
			.body(jsonFile)
			.post("/api/quotes/newquote");
	
	int statusCode = response.getStatusCode(); 
	System.out.println(statusCode);
	//how to assert here?
	
	JsonPath jsonResponse = response.jsonPath();
	loan_id = jsonResponse.get("quoteid");
	System.out.println("loan_id:" + loan_id);
}
}
