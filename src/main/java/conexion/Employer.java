package conexion;

import java.util.ArrayList;

public class Employer extends User{

	private String employerLocation;
	private ArrayList<Job> jobOpenings;
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
	public Employer(IDGenerator idGenerator, ArrayList<Skill> skills, ArrayList<Post> posts, String userName, String userPassword,
			String userEmail, String userBio, String employerLocation, ArrayList<Job> jobOpenings) {
		super(idGenerator, skills, posts, userName, userPassword, userEmail, userBio);
		this.employerLocation = employerLocation;
		this.jobOpenings = jobOpenings;
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
	public ArrayList<Job> getJobOpenings() {
		return jobOpenings;
	}
	/**
	 * @param jobOpenings the jobOpenings to set
	 */
	public void setJobOpenings(ArrayList<Job> jobOpenings) {
		this.jobOpenings = jobOpenings;
	}
	
	public void postJob(int requiredExperience, String requiredDegree, String requiredMajor, ArrayList<Skill> skills, 
			String postTitle, String postDate, ArrayList<String> postAttachments, String postBody) {
		Job newJob = new Job(idGenerator, skills, null, postTitle, postDate, postAttachments, postBody, 
							this, requiredExperience, requiredDegree, requiredMajor);
		getPosts().add(newJob);
	}
	
}
