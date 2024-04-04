package conexion;

public abstract class ActionClass implements action {
	
	public Integer actorID;
	public ActionClass(Integer actorID) {
		this.actorID = actorID;
	}

	@Override
	public abstract void doAction(Job job);
	
	public void removeRecommendation(Job job) {
			IDGenerator idGenerator = job.getIdGenerator();
			
			Person person = (Person)(idGenerator.getPageById(actorID));
			for (Integer jobId: person.getRecommendations()) {
				if(jobId == job.getPageID()) {
					person.getRecommendations().remove(jobId);
					break;
				}
			}
		}
		
	

}
