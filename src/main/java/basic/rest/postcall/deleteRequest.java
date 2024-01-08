package basic.rest.postcall;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;
import static org.hamcrest.CoreMatchers.equalTo;

import org.testng.annotations.Test;

public class deleteRequest {
	
	public String baseUri = "https://api.github.com";
	public String bearerToken = "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";
	public String repoName;
	
	@Test
	public void createRepo() {
		RestAssured.baseURI = baseUri;
		
		String requestBody = "{\n"
				+ "    \"name\": \"Api-testing-restcall-1\",\n"
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
		
		repoName = responseBody.get("full_name");
	}
	
	@Test
	public void deleteRepo() {
		RestAssured.baseURI = baseUri;

		given().
		header("Content-Type", "application/json").
		header("Authorization", "Bearer " + bearerToken).
		when().
		delete("/repos/" + repoName).
		then().
		assertThat().statusCode(204);
		
		System.out.println("Repo deleted is " + repoName);
		}

}
