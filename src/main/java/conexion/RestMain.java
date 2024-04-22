package conexion;

import org.springframework.http.MediaType;
import org.springframework.web.client.RestClient;

public class RestMain {

	public record Desc(String name, String description, String location) {};
	
	Desc myDesc;
	
	RestClient client;
    String uriBase = "http://localhost:9000/v1/";

    
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
	
	public String addPage(Page page) {
		//return the type of the class we are using. 
		Class<? extends Page> pageClass = page.getClass();
		
		String response = client.post()
//				.uri(uriBase + "/page/" + page.getPageID())
				.uri(uriBase +  myDesc.name + "/" + page.getClass().getSimpleName() 
						+ "/" + page.getClass().getSimpleName() +  Integer.toString(page.getPageID()))
				.contentType(MediaType.APPLICATION_JSON)
				.body(page)
				.retrieve()
				.body(String.class);
		
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
//	public String getPage(Page page) {
//		//return the type of the class we are using.
//		Class<? extends Page> pageClass = page.getClass();
//		
//		String response = client.get()
//				.uri(uriBase +  myDesc.name + "/" + page.getClass().getSimpleName() 
//						+ "/" + page.getClass().getSimpleName() +  Integer.toString(page.getPageID()))
//				.accept(MediaType.APPLICATION_JSON)
//				.retrieve()
//				.body(String.class);
//		
//		return response;
//	}
	
	
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