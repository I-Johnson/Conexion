package conexion;

public class Apply extends ActionClass implements Action {
	
	public Apply(String actorID) {
		super(actorID);
	}
	

	@Override
	public void doAction(Job job) {
		// TODO Auto-generated method stub
		Person person = (Person)(server.getPerson(actorID).data());
		person.apply(job);
		person.removeRecommendation(job.getPageID());
		
		server.updatePage(person);
		server.updatePage(job);
		 
	}

	
	 
}
