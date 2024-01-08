package JSONResponseValidation;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;
import static org.hamcrest.CoreMatchers.equalTo;

import org.testng.annotations.Test;

public class handleJSONArray {

	@Test
	public void verifyResponseBody() {
		RestAssured.baseURI = "https://api.trello.com";
		
		Response response = given().
			param("key", "0f9ad99ab8ca06ee1dd8d928c39f6c6f").
			param("token", "ATTA7a8c04876c13e6017e2ede7d7982041d6da51cea96bcd5ee419f85708dd8c2f1B8248CFE").log().all().
		when().
			get("/1/boards/oocbzxrW").
		then().
			assertThat().statusCode(200).and().
			contentType(ContentType.JSON).and().extract().response();
		
		String jsonResponse = response.asString();
		JsonPath responseBody = new JsonPath(jsonResponse);
		
		System.out.println( "" + responseBody.get("name"));
		System.out.println( "Background ID: " + responseBody.get("prefs.background"));
		System.out.println( "Background Image: " + responseBody.get("prefs.backgroundImage"));
		System.out.println( "switcherViews ID: " + responseBody.get("prefs.switcherViews[4]._id"));

		int arraySize = responseBody.getInt("prefs.switcherViews.size()");
		System.out.println(arraySize);
		
		for ( int i=0; i<arraySize; i++) {
			
			// here type string int based on output type
			String viewtype = responseBody.get("prefs.switcherViews["+i+"].viewType");
			System.out.println(viewtype);
		}
		
	}
	
}
