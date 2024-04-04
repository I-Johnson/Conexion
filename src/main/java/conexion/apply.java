package conexion;

public class apply extends ActionClass implements action {
	
	public apply(Integer actorID) {
		super(actorID);
		// TODO Auto-generated constructor stub
	}
	

	@Override
	public void doAction(Job job) {
		// TODO Auto-generated method stub
		IDGenerator idGenerator = job.getIdGenerator();
		Person person = (Person)(idGenerator.getPageById(actorID));
		person.apply(job);
		removeRecommendation(job);
	}

}
