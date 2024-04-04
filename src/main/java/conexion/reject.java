package conexion;

public class reject extends ActionClass implements action{
	
	public reject(Integer actorID) {
		super(actorID);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void doAction(Job job) {
		removeRecommendation(job);
	}

}
