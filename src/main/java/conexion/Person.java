package conexion;

import java.util.ArrayList;

public class Person extends User{
	private int yearsOfExperience;
	private String personDegree;
	private String personInstitution;
	private String personMajor;
	private ArrayList<String> recommendedJobs;
	/**
	 * @param pageID
	 * @param skills
	 * @param posts
	 * @param userName
	 * @param userPassword
	 * @param userEmail
	 * @param yearsOfExperience
	 * @param personDegree
	 * @param personInstitution
	 * @param personMajor
	 */
	public Person(IDGenerator idGenerator, String userName, String userPassword,
			String userEmail, String userBio, int yearsOfExperience, String personDegree, String personInstitution,
			String personMajor) {
		super(idGenerator, userName, userPassword, userEmail, userBio);
		this.yearsOfExperience = yearsOfExperience;
		this.personDegree = personDegree;
		this.personInstitution = personInstitution;
		this.personMajor = personMajor;
		this.recommendedJobs = new ArrayList<String>();
	}
	
	public Person() {
		super();
		this.yearsOfExperience = 0;
		this.personDegree = null;
		this.personInstitution = null;
		this.personMajor = null;
		this.recommendedJobs = new ArrayList<String>();
	}
	/**
	 * @return the yearsOfExperience
	 */
	public int getYearsOfExperience() {
		return yearsOfExperience;
	}
	/**
	 * @param yearsOfExperience the yearsOfExperience to set
	 */
//	public void setYearsOfExperience(int yearsOfExperience) {
//		this.yearsOfExperience = yearsOfExperience;
//	}
	/**
	 * @return the personDegree
	 */
	public String getPersonDegree() {
		return personDegree;
	}
	/**
	 * @param personDegree the personDegree to set
	 */
	public void setPersonDegree(String personDegree) {
		this.personDegree = personDegree;
	}
	/**
	 * @return the personInstitution
	 */
	public String getPersonInstitution() {
		return personInstitution;
	}
	/**
	 * @param personInstitution the personInstitution to set
	 */
//	public void setPersonInstitution(String personInstitution) {
//		this.personInstitution = personInstitution;
//	}
	/**
	 * @return the personMajor
	 */
	public String getPersonMajor() {
		return personMajor;
	}
	 
	public String apply(Job job) {
		String success = "Your application has been submitted.";
		String fail = "Unable to submit! You don't meet the requirements";
		RestMain server = RestMain.getInstance();
		
	    if (this.yearsOfExperience < job.getRequiredExperience() || 
	            !this.personDegree.equals(job.getRequiredDegree())) {
	    		server.updatePage(job);
	            return fail;
	        }
		
		for(String requiredSkill : job.getSkills()) {
			if (!this.getSkills().contains(requiredSkill)) {
				return fail;
			} 
		}
		
		job.getApplicants().add(this.getPageID());
		return success;
	}
	

	public void addRecommendation(String job) {
		// TODO Auto-generated method stub
		this.getRecommendedJobs().add(job);
		
	}
//	public void addRecommendation(Job job) {
//	// TODO Auto-generated method stub
//	this.getRecommendedJobs().add(job.getPageID());
//	
//}
	public ArrayList<String> getRecommendedJobs() {
		return recommendedJobs;
	} 
	
	public void setRecommendedJobs(ArrayList<String> recommendedJobs) {
		this.recommendedJobs = recommendedJobs;
	}

	public void removeRecommendation(String job) {
		// TODO Auto-generated method stub
		this.getRecommendedJobs().remove(job);
		
	}

	@Override
	public String toString() {
		return "Person [yearsOfExperience=" + yearsOfExperience + ", personDegree=" + personDegree
				+ ", personInstitution=" + personInstitution + ", personMajor=" + personMajor + "]";
	}
	

}