package uibank.chaining;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class GetAccountDetails extends BaseClass {

@Test(dependsOnMethods = { "uibank.chaining.LoginUser.loginUser" })
public void getAccountDetails() {
	
	
		  Response response = RestAssured 
				  .given() 
				  .param("filter[where][userId]="+LoginUser.user_id)
				  .accept(ContentType.JSON)
				  .log() 
				  .all() 
				  .get("/api/accounts");
		  
	//print the response
	//response.prettyPrint();
	
	//print and verify the status code
	int statusCode = response.getStatusCode(); 
	System.out.println(statusCode);
	//Assert.assertEquals(statusCode, 200);	
	
	//print and verify the response time
		
		/*
		 * long responseTime = response.time(); System.out.println(responseTime);
		 * Assert.assertTrue(responseTime<5000, "Response time is greater than 2000ms");
		 */
		 
	//print the no. of. issues	
		/*
		 * JsonPath jsonResponse = response.jsonPath(); List<String> list =
		 * jsonResponse.get("issues.id"); int issueCount = list.size();
		 * System.out.println(issueCount); for (String string : list) {
		 * System.out.println(string); }
		 */
		 
}
}
