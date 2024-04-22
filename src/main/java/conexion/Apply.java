package conexion;

public class Apply extends ActionClass implements Action {
	
	public Apply(Integer actorID) {
		super(actorID);
	}
	

	@Override
	public void doAction(Job job) {
		// TODO Auto-generated method stub
		IDGenerator idGenerator = job.getIdGenerator();
		Person person = (Person)(idGenerator.getPageByID(actorID));
		person.apply(job);
		person.removeRecommendation(job.getPageID());
		
	}

	
	
}
