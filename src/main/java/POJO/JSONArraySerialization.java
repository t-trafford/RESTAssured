package POJO;

import java.util.ArrayList;
import java.util.List;

import org.testng.annotations.Test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JSONArraySerialization {
	
	public String CompleteJson;
	
	@Test
	public void createJSONArrayFromPOJO() throws JsonProcessingException {
		
		JSONArrayPOJO repofromRA1 = new JSONArrayPOJO();
		repofromRA1.setName("repofromRA1fromRA1");
		repofromRA1.setDescription("This is repofromRA1 from RA POJO.");
		repofromRA1.setHomepage("https://github.com");
		repofromRA1.setHas_issues(true);
		repofromRA1.setHas_projects(true);
		repofromRA1.setHas_wiki(true);
		
		JSONArrayPOJO repofromRA2 = new JSONArrayPOJO();
		repofromRA2.setName("repofromRA1fromRA2");
		repofromRA2.setDescription("This is repofromRA1 from RA POJO.");
		repofromRA2.setHomepage("https://github.com");
		repofromRA2.setHas_issues(true);
		repofromRA2.setHas_projects(true);
		repofromRA2.setHas_wiki(true);
		
		ArrayList<JSONArrayPOJO> alldirectory = new ArrayList<JSONArrayPOJO>();
		alldirectory.add(repofromRA1);
		alldirectory.add(repofromRA2);
		
		ObjectMapper objectmapper = new ObjectMapper();
		CompleteJson =  objectmapper.writerWithDefaultPrettyPrinter().writeValueAsString(alldirectory);
		System.out.println(CompleteJson);
		
	}
	
	@Test
		public void getPOJOFromObject() throws JsonMappingException, JsonProcessingException {
			ObjectMapper objectmapper = new ObjectMapper();
			List<JSONArrayPOJO> alldirectory = objectmapper.readValue(CompleteJson, new TypeReference<List<JSONArrayPOJO>>() { });
			
			for (JSONArrayPOJO directory : alldirectory) {
				System.out.println("==================================");
				System.out.println(directory.getName());
				System.out.println("==================================");
				
			}
	}
}
			

