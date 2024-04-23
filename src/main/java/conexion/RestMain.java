package conexion;

import org.springframework.http.MediaType;
import org.springframework.web.client.RestClient;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class RestMain {

	public record Desc(String name, String description, String location) {};
	
	Desc myDesc;
	
	RestClient client;
    String uriBase = "http://localhost:9000/v1/";
    
    
    ObjectMapper objectMapper = new ObjectMapper(); 
    
//    public void updatePageCounter() {
//		String response = client.get()
//				.uri(uriBase + "/Conexion/pageCounter")
//				.accept(MediaType.APPLICATION_JSON)
//				.retrieve()
//				.body(String.class);
//		if (response.contains("\"successful\" : false")) {
//			System.out.print("request Failed \n");
//			PageCounter pageCounter = new PageCounter();
//			String pageJson; 
//			try {
//				pageJson = objectMapper.writeValueAsString(pageCounter);
//				String postResponse = client.post()
//						.uri(uriBase + "/Conexion/pageCounter" )
//						.contentType(MediaType.APPLICATION_JSON)
//						.body(pageJson)
//						.retrieve()
//						.body(String.class);
//						System.out.println(postResponse);
//			} catch(JsonProcessingException e) {
//				e.printStackTrace(); //Handling the exception
//				System.out.println("Failed to serialize pageCounter object");
//			}
//			
//		} else {
////			System.out.println(response);
////			try {
////				PageCounter pageCounterBack = objectMapper.readValue(response, PageCounter.class);
////				pageCounterBack.setPageCount(pageCounterBack.getPageCount() + 1);
////				String pageJsonBack = objectMapper.writeValueAsString(pageCounterBack);
////				client.post()
////				.uri(uriBase + "/Conexion/pageCounter" )
////				.contentType(MediaType.APPLICATION_JSON)
////				.body(pageJsonBack)
////				.retrieve()
////				.body(String.class);
////				System.out.println(pageJsonBack);
////			} catch (JsonProcessingException e) {
////				e.printStackTrace();
////			}
////			
////			
//		}
////		System.out.println(response);
//		
////		return response;
//	}
    
//	public String getPage(Page page) {
//	//return the type of the class we are using.
//	Class<? extends Page> pageClass = page.getClass();
//	
//	String response = client.get()
//			.uri(uriBase +  myDesc.name + "/" + page.getClass().getSimpleName() 
//					+ "/" + page.getClass().getSimpleName() +  Integer.toString(page.getPageID()))
//			.accept(MediaType.APPLICATION_JSON)
//			.retrieve()
//			.body(String.class);
//	
//	return response;
//}
    
    
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
		className = className.substring(0, 1).toUpperCase() + className.substring(1).toLowerCase();
		
		String response = client.post()
				.uri(uriBase + myDesc.name + "/" + className)
				.contentType(MediaType.APPLICATION_JSON)
				.body(new Desc(className, "My Class is " + className, ""))
				.retrieve()
				.body(String.class);
		
		return response;
	}
	
	// POST method
//	
//	public String addPage(Page page) {
//		//return the type of the class we are using. 
//		Class<? extends Page> pageClass = page.getClass();
//		
//		String response = client.post()
////				.uri(uriBase + "/page/" + page.getPageID())
//				.uri(uriBase +  myDesc.name + "/" + page.getClass().getSimpleName() 
//						+ "/" + page.getClass().getSimpleName() +  Integer.toString(page.getPageID()))
//				.contentType(MediaType.APPLICATION_JSON)
//				.body(page)
//				.retrieve()
//				.body(String.class);
//		
//		return response;
//	}	

	public String addPage(Page page) {
		//Serialize the page object using ObjectMapper
		String pageJson; 
		try {
			pageJson = objectMapper.writeValueAsString(page);
		} catch(JsonProcessingException e) {
			e.printStackTrace(); //Handling the exception
			return "Failed to serialize page object";
		}
		
		//return the type of the class we are using. 
		Class<? extends Page> pageClass = page.getClass();
		
		String response = client.post()
//				.uri(uriBase + "/page/" + page.getPageID())
				.uri(uriBase +  myDesc.name + "/" + page.getClass().getSimpleName() 
						+ "/" + page.getClass().getSimpleName() +  Integer.toString(page.getPageID()))
				.contentType(MediaType.APPLICATION_JSON)
				.body(pageJson)
				.retrieve()
				.body(String.class);
				System.out.println(pageJson);
		return response;
	}	
	
//	public String addPage(Page page) {
//		//return the type of the class we are using. 
//		Class<? extends Page> pageClass = page.getClass();
//		
//		String response = client.post()
////				.uri(uriBase + "/page/" + page.getPageID())
//				.uri(uriBase +  myDesc.name + "/" + page.getClass().getSimpleName() 
//						+ "/" + page.getClass().getSimpleName() +  Integer.toString(page.getPageID()))
//				.contentType(MediaType.APPLICATION_JSON)
//				.body(page)
//				.retrieve()
//				.body(String.class);
//		
//		return response;
//	}	
	
	
    // GET method
	
	public Page getPage(Page page) {
		//return the type of the class we are using.
		Class<? extends Page> pageClass = page.getClass();
		
		Page response = client.get()
				.uri(uriBase +  myDesc.name + "/" + page.getClass().getSimpleName() 
						+ "/" + page.getClass().getSimpleName() +  Integer.toString(page.getPageID()))
				.accept(MediaType.APPLICATION_JSON)
				.retrieve()
				.body(pageClass);
		
		return response;
	}

	
	
	// DELETE Method
	public void removePage(Page page) {
		Class<? extends Page> pageClass = page.getClass();
		client.delete()
	 
		.uri(uriBase +  myDesc.name + "/" + page.getClass().getSimpleName() 
				+ "/" + page.getClass().getSimpleName() +  Integer.toString(page.getPageID()))
		 .retrieve();
		
	}
	
	
	// UPDATE Method
	
	public String updatePage(Page page) {
		Class<? extends Page> pageClass = page.getClass();
		
		String response = client.put()
				.uri(uriBase +  myDesc.name + "/" + page.getClass().getSimpleName() 
						+ "/" + page.getClass().getSimpleName() +  Integer.toString(page.getPageID()))
				.contentType(MediaType.APPLICATION_JSON)
				.body(page)
				.retrieve()
				.body(String.class);
		return response;
	}
	
}