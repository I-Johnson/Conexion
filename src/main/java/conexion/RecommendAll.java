package conexion;

public class RecommendAll implements Recommendation {

	@Override
	public void sendRecommendation(Job job) {
		// TODO Auto-generated method stub
		IDGenerator idGenerator = job.idGenerator;
		Page page;
		
		for (int i = 1; i < idGenerator.getPageIDs().size(); i ++) {
			page = idGenerator.getPageByID(i);
			if (page instanceof Person) {
				((Person) page).addRecommendation(job.getPageID());
			}
		}
		
	}
	
	


}
