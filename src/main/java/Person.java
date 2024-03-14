import java.util.ArrayList;

public class Person extends User{
	private int yearsOfExperience;
	private String personDegree;
	private String personInstitution;
	private String personMajor;
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
	public Person(IDGenerator idGenerator, ArrayList<Skill> skills, ArrayList<Post> posts, String userName, String userPassword,
			String userEmail, String userBio, int yearsOfExperience, String personDegree, String personInstitution,
			String personMajor) {
		super(idGenerator, skills, posts, userName, userPassword, userEmail, userBio);
		this.yearsOfExperience = yearsOfExperience;
		this.personDegree = personDegree;
		this.personInstitution = personInstitution;
		this.personMajor = personMajor;
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
		
//		if(this.yearsOfExperience < job.getRequiredExperience() || this.personDegree != job.getRequiredDegree() 
//				|| this.personMajor != job.getRequiredDegree()) 
//		{
//			return fail;
//		}
	    if (this.yearsOfExperience < job.getRequiredExperience() || 
	            !this.personDegree.equals(job.getRequiredDegree()) || 
	            !this.personMajor.equals(job.getRequiredMajor())) {
	            return fail;
	        }
		
		for(Skill requiredSkill : job.getSkills()) {
			if (!this.getSkills().contains(requiredSkill)) {
				return fail;
			}
		}
		
		job.getApplicants().add(this);
		return success;
	}

}
