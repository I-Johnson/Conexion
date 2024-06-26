package conexion;

import java.util.Objects;

public class Employer extends User{

	@Override
	public String toString() {
		return "Employer " + this.getUserName();
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
	
	@Override
	public void addPerson(Person person) {
		this.getPersons().add(person.getPageID());
		person.getEmployers().add(this.getPageID());
		RestMain client = RestMain.getInstance();
		client.updatePage(this);
		client.updatePage(person);
	} 
	
	@Override
	public void addSkill(Skill skill) {
		this.getSkills().add(skill.getPageID());
		skill.getEmployers().add(this.getPageID());
		RestMain client = RestMain.getInstance();
		client.updatePage(this);
		client.updatePage(skill);
	}
	
	@Override
	public void addPost(Post post) {
		this.getPosts().add(post.getPageID());
		post.getEmployers().add(this.getPageID());
		RestMain client = RestMain.getInstance();
		client.updatePage(this);
		client.updatePage(post);
	} 
	
	@Override
	public void addJob(Job job) {
		this.getJobs().add(job.getPageID());
		job.getEmployers().add(this.getPageID());
		RestMain client = RestMain.getInstance();
		client.updatePage(this);
		client.updatePage(job);
	}
	
	@Override
	public void addEmployer(Employer employer) {
		if(this != employer) {
			this.getEmployers().add(employer.getPageID());
		}
		employer.getEmployers().add(this.getPageID());
		RestMain client = RestMain.getInstance();
		client.updatePage(this);
		client.updatePage(employer);
	} 

	public Job postJob(Integer requiredExperience, String requiredDegree, String requiredMajor, 
			String postTitle, String postDate, String postBody) {//, recommendation recommendation) {
		Job newJob = new Job(idGenerator, postTitle, postDate, postBody, 
							this.getPageID(), requiredExperience, requiredDegree, requiredMajor);
//		getPosts().add(newJob.getPageID());
		this.addPost(newJob);
		return newJob;
	}

	@Override 
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + Objects.hash(employerLocation);
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Employer other = (Employer) obj;
		return Objects.equals(employerLocation, other.employerLocation);
	}
	
	
	
}