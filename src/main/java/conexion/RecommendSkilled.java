package conexion;

public class RecommendSkilled implements Recommendation {

	@Override
	public void sendRecommendation(Job job) {
		// TODO Auto-generated method stub
		Page page;
		IDGenerator idGenerator = job.idGenerator;
		
		for (int i = 1; i <idGenerator.getPageIDs().size(); i ++) {
			page = idGenerator.getPageByID(i);
			
			if (page instanceof Person) {
				for(int j = 1; j < idGenerator.getPageIDs().size(); i++) {
					if (page.getSkills().contains(job.getSkills().get(j))) {
						((Person) page).addRecommendation(job.getPageID());
					}
				}
			}
		}

	}

}
