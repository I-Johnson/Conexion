package conexion;

import java.util.ArrayList;

public class Person extends User{
	private int yearsOfExperience;
	private String personDegree;
	private String personInstitution;
	private String personMajor;
	
	public ArrayList<Integer> recommendations;
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
		this.recommendations = new ArrayList<Integer>();
		
		
	}
	
	public ArrayList<Integer> getRecommendations() {
		return recommendations;
	}

	public void setRecommendations(ArrayList<Integer> recommendations) {
		this.recommendations = recommendations;
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
	public void setYearsOfExperience(int yearsOfExperience) {
		this.yearsOfExperience = yearsOfExperience;
	}
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
	public void setPersonInstitution(String personInstitution) {
		this.personInstitution = personInstitution;
	}
	/**
	 * @return the personMajor
	 */
	public String getPersonMajor() {
		return personMajor;
	}
	/**
	 * @param personMajor the personMajor to set
	 */
	public void setPersonMajor(String personMajor) {
		this.personMajor = personMajor;
	}
	
	public String apply(Job job) {
		String success = "Your application has been submitted.";
		String fail = "Unable to submit! You don't meet the requirements";
		
//	    if (this.yearsOfExperience < job.getRequiredExperience() || 
//	            !this.personDegree.equals(job.getRequiredDegree()) || 
//	            !this.personMajor.equals(job.getRequiredMajor())) {
//	            return fail;
//	        }
		boolean result = this.isQualified(job);
		if (result == true) {
			job.addApplicant((Person)this);
			return success;
		} else {
			return fail;
		}
		
	}
	
	public void addRecommendation(Job job) {
		this.getRecommendations()
		.add(job.getPageID());
	}
	
	public boolean isQualified(Job job) {
		if (this.yearsOfExperience < job.getRequiredExperience()) {
	            return false;
	        }
		for(Integer requiredSkillId : job.getSkills()) {
			if (!this.getSkills().contains(requiredSkillId)) {
				return false;
			}
		}
		return true;
	}

}
