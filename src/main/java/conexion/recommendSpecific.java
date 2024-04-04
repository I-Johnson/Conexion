package conexion;

public class recommendSpecific implements recommendation{
	
	Integer targetId;
	public recommendSpecific(Integer targetId){
		this.targetId = targetId;
	}

	@Override
	public void sendRecommendation(Job job) {
		// TODO Auto-generated method stub
		Person person; 
		IDGenerator idGenerator = job.idGenerator;
		person = (Person)idGenerator.getPageById(targetId);
		person.addRecommendation(job);
	}

}
