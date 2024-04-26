package conexion;
import java.util.Hashtable;

import org.springframework.http.MediaType;
import org.springframework.web.client.RestClient;

public class IDGenerator {
	public record pageCounterRequestDescription(String request, 
			boolean successful, String message, PageCounter data) {};
	private static IDGenerator instance = null;
	private Hashtable<Integer, Page> pageIDs; //attributes
	
	
	//constructor
	public IDGenerator() {
	}
	 
	public static synchronized IDGenerator getInstance() {
		if (instance == null) {
			instance = new IDGenerator();
		}
		return instance;
	}
	
	public Integer makeID()
	{
		return pageIDs.size() + 1;
	}
	
	public Integer postID() {
		RestClient client;
		client = RestClient.create();
		String uriBase = "http://localhost:9000/v1/Conexion/pageCounter/1";
		
		pageCounterRequestDescription getResponse = client.get()
							.uri(uriBase)
							.accept(MediaType.APPLICATION_JSON)
							.retrieve()
							.body(pageCounterRequestDescription.class);
		
		getResponse.data.increment(); 
		
		@SuppressWarnings("unused")
		String postResponse = client.put().uri(uriBase)
				.contentType(MediaType.APPLICATION_JSON)
				.body(getResponse.data())
				.retrieve().body(String.class);
		return getResponse.data.getPageCount();
		
		
	}
	
	public int getNumberOfPages() {
		RestClient client;
		client = RestClient.create();
		String uriBase = "http://localhost:9000/v1/Conexion/pageCounter/1";
		pageCounterRequestDescription getResponse = client.get().uri(uriBase)
				.accept(MediaType.APPLICATION_JSON)
				.retrieve()
				.body(pageCounterRequestDescription.class);
		int numberOfPages = getResponse.data().getPageCount();
		return numberOfPages;
	}
	
	public static void main (String[] args) {
		
	}

	/**
	 * @param instance the instance to set
	 */
	public static void setInstance(IDGenerator instance) {
		IDGenerator.instance = instance;
	}
}


