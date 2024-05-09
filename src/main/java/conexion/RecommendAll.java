package conexion;

import org.springframework.web.client.RestClientException;

public class RecommendAll implements Recommendation {

	@Override
	public void sendRecommendation(Job job) {
		// TODO Auto-generated method stub
//		IDGenerator idGenerator = job.idGenerator;
		IDGenerator idGenerator = IDGenerator.getInstance();
		RestMain client = RestMain.getInstance();
		
		Page page;
		
		int numberOfPages = idGenerator.getNumberOfPages();
		
		for (int i = 1; i <= numberOfPages; i++) {
			try {
				page = client.getPerson("/Person/"+ ((Integer)i).toString()).data();
				((Person) page).addRecommendation(job.getPageID());
				client.updatePage(page);
			} catch (RestClientException e){
				System.out.print("");
			} 
		}
	}  

} 
 