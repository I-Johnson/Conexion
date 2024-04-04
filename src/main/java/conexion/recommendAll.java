package conexion;

public class recommendAll implements recommendation{
	
	Integer targetId;
	public recommendAll(){
		
	}

	@Override
	public void sendRecommendation(Job job) {
		// TODO Auto-generated method stub
		Page page;
		IDGenerator idGenerator = job.idGenerator;
		for (int i = 1; i < idGenerator.getPageIDs().size() + 1; i += 1) {
			page = idGenerator.getPageById(i);
			if(page instanceof Person) {
				((Person) page).addRecommendation(job);
			}
		}
		
	}

}
