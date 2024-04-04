package conexion;

public class recommendQualified implements recommendation{
	
	
	public recommendQualified(){
		
	}

	@Override
	public void sendRecommendation(Job job) {
		// TODO Auto-generated method stub
		Page page;
		IDGenerator idGenerator = job.idGenerator;
		for (int i = 1; i < idGenerator.getPageIDs().size() + 1; i += 1) {
			page = idGenerator.getPageById(i);
			if(page instanceof Person) {
				if(((Person) page).isQualified(job))
				((Person) page).addRecommendation(job);
			}
		}
		
	}

}
