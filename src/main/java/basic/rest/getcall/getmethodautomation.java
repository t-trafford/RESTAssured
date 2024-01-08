package basic.rest.getcall;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;
import static org.hamcrest.CoreMatchers.equalTo;

public class getmethodautomation {
	
public static String baseUri = "https://api.trello.com";
	
	
	public static void main(String agrs[]) {
		RestAssured.baseURI = baseUri;
		
		given().
			param("key", "0f9ad99ab8ca06ee1dd8d928c39f6c6f").
			param("token", "ATTA7a8c04876c13e6017e2ede7d7982041d6da51cea96bcd5ee419f85708dd8c2f1B8248CFE").
		when().
			get("/1/boards/oocbzxrW").
		then().
			assertThat().statusCode(200).and().
			contentType(ContentType.JSON).and().
			body("name", equalTo("PostMan Testing 1")).and().
			body("desc", equalTo(""));
		
		System.out.println("This First Get Automation Call.");
		System.out.println("Get Call, Executed Successfully");
	}
}
