package conexion;

public class Employer extends User{

	@Override
	public String toString() {
		return "Employer [employerLocation=" + employerLocation + "]";
	}


	private String employerLocation;
	/**
	 * @param pageID
	 * @param skills
	 * @param posts
	 * @param userName
	 * @param userPassword
	 * @param userEmail
	 * @param userBio
	 * @param employerLocation
	 * @param jobOpenings
	 */
	public Employer(IDGenerator idGenerator, String userName, String userPassword,
			String userEmail, String userBio, String employerLocation) {
		super(idGenerator, userName, userPassword, userEmail, userBio);
		this.employerLocation = employerLocation;
	} 
	
	public Employer() {
		super();
		this.employerLocation = null;
	}
	/**
	 * @return the employerLocation
	 */
	public String getEmployerLocation() {
		return employerLocation;
	}


	public Job postJob(Integer requiredExperience, String requiredDegree, String requiredMajor, 
			String postTitle, String postDate, String postBody) {//, recommendation recommendation) {
		Job newJob = new Job(idGenerator, postTitle, postDate, postBody, 
							this.getPageID(), requiredExperience, requiredDegree, requiredMajor);
//		getPosts().add(newJob.getPageID());
		this.addPost(newJob);
		return newJob;
	}
	
	
}
