package conexion;

public class Reject extends ActionClass implements Action {
	
	public Reject(Integer actorID) {
		super(actorID);
	}

	@Override
	public void doAction(Job job) {
		// TODO Auto-generated method stub
		IDGenerator idGenerator = job.getIdGenerator();
		Person person = (Person)(idGenerator.getPageByID(actorID));
		person.removeRecommendation(job.getPageID());
		
	}

}
