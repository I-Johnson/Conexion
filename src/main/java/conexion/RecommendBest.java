package conexion;

import org.springframework.web.client.RestClientException;

public class RecommendBest implements Recommendation {


	@Override 
	public void sendRecommendation(Job job) {
		// TODO Auto-generated method stub
		Page page;
		RestMain client = RestMain.getInstance(); 
		IDGenerator idGenerator = IDGenerator.getInstance();
		
		Integer numberOfPages = (Integer) idGenerator.getNumberOfPages();
		 
		int mostExperienced = 0;
		Person recommendBest = null;
		for (int i = 1; i <= numberOfPages; i++) {
			try {
				page = client.getPerson("Person/"+ ((Integer)i).toString()).data();
				if(((Person) page).getYearsOfExperience() > mostExperienced) {
					recommendBest = (Person)page;
					mostExperienced = recommendBest.getYearsOfExperience();
					
				}
			} catch (RestClientException e){
				System.out.print("");
			}
		}
		recommendBest.addRecommendation(job.getPageID());
		client.updatePage(recommendBest);
	}
 
}