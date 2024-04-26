package conexion;

import org.springframework.web.client.RestClientException;

public class RecommendSkilled implements Recommendation {

	@Override
	public void sendRecommendation(Job job) {
		Page page;
		RestMain client = RestMain.getInstance();
		IDGenerator idGenerator = IDGenerator.getInstance();
		
		Integer numberOfPages = (Integer) idGenerator.getNumberOfPages();
		for (int i = 1; i <= numberOfPages; i++) { 
			try { 
				boolean acceptable = true; 
				page = client.getPerson("/Person/"+ ((Integer)i).toString()).data();
				for(int j = 1; j < job.getSkills().size(); j+=1) {
					if (!((Person) page).getSkills().contains(job.getSkills().get(j))) {
						acceptable = false;
					}
				}
					if(acceptable == true) {
						((Person) page).addRecommendation(job.getPageID());
						client.updatePage(page);
//					}
			}
			} catch (RestClientException e){
				System.out.print("");
			}
			 
		} 

	}
} 
