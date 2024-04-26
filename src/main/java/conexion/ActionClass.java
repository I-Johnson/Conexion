package conexion;

public abstract class ActionClass implements Action {
	public String actorID;
	public IDGenerator idGenerator; 
	public RestMain server;
	
	public ActionClass(String actorID) {
		this.actorID = actorID;
		this.server = RestMain.getInstance(); 
	}
	
	

	@Override
	public abstract void doAction(Job job);

}
