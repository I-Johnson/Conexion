package conexion;

public abstract class ActionClass implements Action {
	public Integer actorID;
	public IDGenerator idGenerator; 
	
	public ActionClass(Integer actorID) {
		this.actorID = actorID;
	}
	
	

	@Override
	public abstract void doAction(Job job);

}
