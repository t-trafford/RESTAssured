package JSONResponseValidation;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;
import static org.hamcrest.CoreMatchers.equalTo;

import org.testng.annotations.Test;

public class handleGITArray {

	@Test
	public void gitResponseRepos() {
		RestAssured.baseURI = "https://api.github.com";
		
		String bearerToken = "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";
		
		
		Response response  = given().
			header("Content-Type", "application/json").
			header("Authorization", "Bearer " + bearerToken).
		when().
			get("/user/repos").
		then().
			assertThat().statusCode(200).and().
			contentType(ContentType.JSON).
		extract().response();
		
		String jasonResponse = response.asString();
		
		JsonPath responseBody = new JsonPath(jasonResponse);
		
		System.out.println("0'th Index : " + responseBody.get("[0]"));
		System.out.println("1'st Index : " + responseBody.get("[1]"));
	}
}
