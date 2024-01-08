package POJO;

import org.testng.annotations.Test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class DataSerializeAndDeserialize {
	
	@Test
	public void createDatafromPOJO() throws JsonProcessingException {
		
		// Just declare an object of pojo class (serialization)
		SamplePOJO repo = new SamplePOJO();
		repo.setName("repofromRA1");
		repo.setDescription("This is repo from RA POJO.");
		repo.setHomepage("https://github.com");
		repo.setHas_issues(true);
		repo.setHas_projects(true);
		repo.setHas_wiki(true);
	
		
		// Converting Java Class object into JSON payload as a string (deserialization)
		ObjectMapper objectmapper = new ObjectMapper();
		String repoJSON =  objectmapper.writerWithDefaultPrettyPrinter().writeValueAsString(repo);
		
		System.out.println(repoJSON);
	
	}
	
	@Test
	public void getPojoFromObject() throws JsonProcessingException {
		// Just declare an object of pojo class (serialization)
		SamplePOJO repo = new SamplePOJO();
		repo.setName("repofromRA2");
		repo.setDescription("This is repo from RA POJO.");
		repo.setHomepage("https://github.com");
		repo.setHas_issues(true);
		repo.setHas_projects(true);
		repo.setHas_wiki(true);
		
		// Converting Java Class object into JSON payload as a string (deserialization)
		ObjectMapper objectmapper = new ObjectMapper();
		String repoJSON =  objectmapper.writerWithDefaultPrettyPrinter().writeValueAsString(repo);
		
		//Converting json payload to class object
		
		SamplePOJO repoobj = objectmapper.readValue(repoJSON, SamplePOJO.class);
		System.out.println("Name: - " + repoobj.getName());
	}

}
