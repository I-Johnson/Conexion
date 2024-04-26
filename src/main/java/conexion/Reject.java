package conexion;

public class Reject extends ActionClass implements Action {
	
	public Reject(String actorID) {
		super(actorID);
	}

	@Override
	public void doAction(Job job) {
		// TODO Auto-generated method stub
		Person person = (server.getPerson(actorID).data());
		person.removeRecommendation(job.getPageID());
		server.updatePage(person);
	}

}
 