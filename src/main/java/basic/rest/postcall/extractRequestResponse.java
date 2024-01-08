package basic.rest.postcall;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;
import static org.hamcrest.CoreMatchers.equalTo;

import org.testng.annotations.Test;

public class extractRequestResponse {
	@Test
	public void extractResponse() {
		RestAssured.baseURI = "https://api.github.com";
		
		String bearerToken = "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";
		String requestBody = "{\n"
				+ "    \"name\": \"Api-testing-restcall-new\",\n"
				+ "    \"description\": \"This is your repository from Rest Assured Call.\",\n"
				+ "    \"homepage\": \"https://github.com\",\n"
				+ "    \"private\": false,\n"
				+ "    \"has_issues\": true,\n"
				+ "    \"has_projects\": true,\n"
				+ "    \"has_wiki\": true\n"
				+ "}";
		
		
		Response response  = given().
			header("Content-Type", "application/json").
			header("Authorization", "Bearer " + bearerToken).
			body(requestBody).
		when().
			post("/user/repos").
		then().
			assertThat().statusCode(201).and().
			contentType(ContentType.JSON).
		extract().response();
		
		String jasonResponse = response.asString();
		
		JsonPath responseBody = new JsonPath(jasonResponse);
		
		System.out.println("Node ID : " + responseBody.get("node_id"));
		System.out.println("Name : " + responseBody.get("name"));
		System.out.println("Full Name : " + responseBody.get("full_name"));
		
	}
}
