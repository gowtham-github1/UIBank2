package uibank.chaining;
import java.io.File;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class registerUser extends BaseClass {
	
	//Create data provider
	@DataProvider (name="files", indices = {0})
public String[][] getFiles(){
		String [][] filenames = new String[2][1];
		filenames [0][0] = "./data1.json";
		filenames [1][0] = "./data2.json";
		
		return filenames;
	}	
	
	@Test (dataProvider="files")
public void createIssue(String filenames){
	File jsonFile = new File(filenames);

	Response response = RestAssured
			.given()
			.contentType(ContentType.JSON)
			.body(jsonFile)
			.post("/issue");
			
	
	response.prettyPrint();
	int statusCode = response.getStatusCode(); 
	System.out.println(statusCode);
	
	JsonPath jsonResponse = response.jsonPath();
	issueId = jsonResponse.get("id");
	System.out.println(issueId);

}
}
