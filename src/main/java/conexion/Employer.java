package conexion;

public class Employer extends User{

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
//		this.jobOpenings = jobOpenings;
	}
	/**
	 * @return the employerLocation
	 */
	public String getEmployerLocation() {
		return employerLocation;
	}
	/**
	 * @param employerLocation the employerLocation to set
	 */
	public void setEmployerLocation(String employerLocation) {
		this.employerLocation = employerLocation;
	}
	/**
	 * @return the jobOpenings
	 */
	
	public void postJob(int requiredExperience, String requiredDegree, String requiredMajor, 
			String postTitle, String postDate, String postBody) {
		Job newJob = new Job(idGenerator, postTitle, postDate, postBody, 
							this, requiredExperience, requiredDegree, requiredMajor);
		getPosts().add(newJob);
	}
	
}
