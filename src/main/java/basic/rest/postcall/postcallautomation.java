package basic.rest.postcall;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;
import static org.hamcrest.CoreMatchers.equalTo;

import org.testng.annotations.Test;

public class postcallautomation {
	
	@Test
	public void createBoard() {
		RestAssured.baseURI = "https://api.trello.com";
		String board_name = "My board from API "  + (int)(Math.random()*100);
		System.out.println(board_name);
		
		// anything after ? inURLispart of query params
		given().
			queryParam("key", "0f9ad99ab8ca06ee1dd8d928c39f6c6f").
			queryParam("token", "ATTA7a8c04876c13e6017e2ede7d7982041d6da51cea96bcd5ee419f85708dd8c2f1B8248CFE").
			queryParam("name", board_name).
			header("Content-Type", "application/json").
		when().
			post("/1/boards").
		then().
			assertThat().statusCode(200).and().
			contentType(ContentType.JSON).and().
			body("name", equalTo(board_name));

	}

}
