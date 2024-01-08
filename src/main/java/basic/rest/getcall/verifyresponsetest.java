package basic.rest.getcall;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;
import static org.hamcrest.CoreMatchers.equalTo;

import org.testng.annotations.Test;

public class verifyresponsetest {
		
		@Test
		public void verifyResponseBody() {
			RestAssured.baseURI = "https://api.trello.com";
			
			given().
				param("key", "0f9ad99ab8ca06ee1dd8d928c39f6c6f").
				param("token", "ATTA7a8c04876c13e6017e2ede7d7982041d6da51cea96bcd5ee419f85708dd8c2f1B8248CFE").log().all().
			when().
				get("/1/boards/oocbzxrW").
			then().
				assertThat().statusCode(200).and().log().body().
				contentType(ContentType.JSON).and().
				body("name", equalTo("PostMan Testing 1")).and().
				body("desc", equalTo(""));

		}
		
		@Test
		public void verifyResponseHeader() {
			RestAssured.baseURI = "https://api.trello.com";
			
			given().
				param("key", "0f9ad99ab8ca06ee1dd8d928c39f6c6f").
				param("token", "ATTA7a8c04876c13e6017e2ede7d7982041d6da51cea96bcd5ee419f85708dd8c2f1B8248CFE").
			when().
				get("/1/boards/oocbzxrW").
			then().
				assertThat().statusCode(200).and().
				contentType(ContentType.JSON).and().
				header("Referrer-Policy", "strict-origin-when-cross-origin").and().
				header("X-Trello-Environment", "Production");
		}
}
