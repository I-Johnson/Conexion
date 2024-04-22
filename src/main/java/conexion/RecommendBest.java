package conexion;

public class RecommendBest implements Recommendation {


	@Override
	public void sendRecommendation(Job job) {
		// TODO Auto-generated method stub
		IDGenerator idGenerator = job.idGenerator;
		Page page;
		Person recommendBest = null;
		for (int i = 1; i < idGenerator.getPageIDs().size(); i++) {
			
			page = idGenerator.getPageByID(i);
			int mostExperienced = 0;
			
			if (page instanceof Person) {
				
				if (((Person) page).getYearsOfExperience() > mostExperienced) {
					recommendBest = (Person)page;
					mostExperienced = recommendBest.getYearsOfExperience();
				}
			}
		}
		recommendBest.addRecommendation(job.getPageID());
	}

}
