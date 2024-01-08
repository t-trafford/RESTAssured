package basic.rest.postcall;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;
import static org.hamcrest.CoreMatchers.equalTo;

import org.testng.annotations.Test;


public class createGitHubRepo {
	@Test
	public void createRepository() {
		RestAssured.baseURI = "https://api.github.com";
		
		String bearerToken = "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";
		
		
		given().
			header("Content-Type", "application/json").
			header("Authorization", "Bearer " + bearerToken).
			body("{\n"
					+ "    \"name\": \"Api-testing-restcall\",\n"
					+ "    \"description\": \"This is your repository from Rest Assured Call.\",\n"
					+ "    \"homepage\": \"https://github.com\",\n"
					+ "    \"private\": false,\n"
					+ "    \"has_issues\": true,\n"
					+ "    \"has_projects\": true,\n"
					+ "    \"has_wiki\": true\n"
					+ "}").
		when().
			post("/user/repos").
		then().
			assertThat().statusCode(201).and().
			contentType(ContentType.JSON).and().
			body("name", equalTo("Api-testing-restcall")).and().
			body("description", equalTo("This is your repository from Rest Assured Call."));

		System.out.println("Completed Create Repo Test Case");
	}

}
