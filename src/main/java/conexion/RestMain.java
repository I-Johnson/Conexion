package conexion;

import org.springframework.http.MediaType;
import org.springframework.web.client.RestClient;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class RestMain {
	
	// Rest Singleton
	private static RestMain instance = null;
	public static synchronized RestMain getInstance() {
		if(instance == null ) {
			instance = new RestMain();
		}
		return instance;
	}

	public record Desc(String name, String description, String location) {};
	public record GetSkillDesc(String request, boolean successful, String message, Skill data) {};
	public record GetPostDesc(String request, boolean successful, String message, Post data) {};
	public record GetPersonDesc(String request, boolean successful, String message, Person data) {};
	public record GetEmployerDesc(String request, boolean successful, String message, Employer data) {};
	public record GetJobDesc(String request, boolean successful, String message, Job data) {};
	Desc myDesc;
	
	RestClient client;
    String uriBase = "http://localhost:9000/v1/";
    
    
    ObjectMapper objectMapper = new ObjectMapper();  
    
    
	public RestMain() {
		 client = RestClient.create();
		 myDesc = new Desc("Conexion", "pages", "myloc");
	}
	
	

	// Clear existing data when running. 
	public void clearCache() {
		client.delete()
			.uri(uriBase + myDesc.name)
			.retrieve();
	}
	
	
	//Create a Description folder 'Conexion' 
	public String makeDesc() {
		String response = client.post()
                .uri(uriBase + myDesc.name) 
                .contentType(MediaType.APPLICATION_JSON) 
                .body(myDesc) 
                .retrieve()
                .body(String.class);

      return response;
	}
	
	//creates a folder for all the classes
	
	public String makeClass(String className) {
//		className = className;
		
		String response = client.post()
				.uri(uriBase + myDesc.name + "/" + className)
				.contentType(MediaType.APPLICATION_JSON)
				.body(new Desc(className, "My Class is " + className, ""))
				.retrieve()
				.body(String.class);
		
		return response;
	}
	
	// POST method

	public String addPage(Page page) {
		//Serialize the page object using ObjectMapper
		String pageJson; 
		try {
			pageJson = objectMapper.writeValueAsString(page);
		} catch(JsonProcessingException e) {
			e.printStackTrace(); //Handling the exception
			return "Failed to serialize page object";
		}
		
		
		String postUrl = uriBase + myDesc.name + "/" + page.getPageID();
		
		String response = client.post()
				.uri(postUrl)
				.contentType(MediaType.APPLICATION_JSON)
				.body(pageJson)
				.retrieve()
				.body(String.class);
		return response;
	}	

	// DELETE Method
	public void removePage(String id) {
		client.delete()
		.uri(uriBase + myDesc.name + "/" + id)
		.retrieve();
		
	}
	
	
	// UPDATE Method
	
	public String updatePage(Page page) {
		
		String response = client.put()
				.uri(uriBase +  myDesc.name + "/" + page.getPageID())
				.contentType(MediaType.APPLICATION_JSON)
				.body(page)
				.retrieve()
				.body(String.class);
		return response;
	}
	
	
	// Get for all the classes
	
	//GET Skill
	public GetSkillDesc getSkill(String id) {
		GetSkillDesc response = client.get()
				.uri(uriBase + myDesc.name + "/" + id)
				.accept(MediaType.APPLICATION_JSON)
				.retrieve()
				.body(GetSkillDesc.class);
		return response;
	}
	
	//GET Post
	public GetPostDesc getPost(String id) {
		GetPostDesc response = client.get()
				.uri(uriBase + myDesc.name + "/" + id)
				.accept(MediaType.APPLICATION_JSON)
				.retrieve()
				.body(GetPostDesc.class);
		return response;
	}
	
	//GET Person
	public GetPersonDesc getPerson(String id) {
		GetPersonDesc response = client.get()
				.uri(uriBase + myDesc.name + "/" + id)
				.accept(MediaType.APPLICATION_JSON)
				.retrieve()
				.body(GetPersonDesc.class); 
		return response;
	}
	
	//GET Employer
	public GetEmployerDesc getEmployer(String id) {
		GetEmployerDesc response = client.get()
				.uri(uriBase + myDesc.name + "/" + id)
				.accept(MediaType.APPLICATION_JSON)
				.retrieve()
				.body(GetEmployerDesc.class);
		return response; 
	}
	
	//GET Job
	public GetJobDesc getJob(String id) {
		GetJobDesc response = client.get()
				.uri(uriBase + myDesc.name + "/" + id)
				.accept(MediaType.APPLICATION_JSON)
				.retrieve()
				.body(GetJobDesc.class);
		return response;
	}
	
}