package conexion;
import java.util.ArrayList;

public class Job extends Post{

	private ArrayList<String> applicants;
	private int requiredExperience;
	private String requiredDegree;
	private String requiredMajor;
	private ArrayList<String> postAttachments;



	/**
	 * @param idGenerator
	 * @param skills
	 * @param posts
	 * @param postTitle
	 * @param postDate
	 * @param postAttachments
	 * @param postBody
	 * @param postAuthor
	 * @param applicants
	 * @param requiredExperience
	 * @param requiredDegree
	 * @param requiredMajor
	 * @param skillRequirements
	 */
	public Job(IDGenerator idGenerator, String postTitle,
			String postDate, String postBody, String postAuthor, int requiredExperience, 
			String requiredDegree, String requiredMajor) {
		
		super(idGenerator, postTitle, postDate, postBody, postAuthor);
		
//		this.applicants = new ArrayList<Person> ();
		this.applicants = new ArrayList<String>();
		this.postAttachments = new ArrayList<String>();
		this.requiredExperience = requiredExperience;
		this.requiredDegree = requiredDegree;
		this.requiredMajor = requiredMajor;
//		this.skillRequirements = skillRequirements;
	}

	@Override
	public String toString() {
		return "Job [applicants=" + applicants + ", requiredExperience=" + requiredExperience + ", requiredDegree="
				+ requiredDegree + ", requiredMajor=" + requiredMajor + ", postAttachments=" + postAttachments + "]";
	}

	public Job() {
		
		super();
		
		this.applicants = new ArrayList<String> ();
		this.postAttachments = new ArrayList<String>();
		this.requiredExperience = 0;
		this.requiredDegree = null;
		this.requiredMajor = null;
//		this.skillRequirements = skillRequirements;
	}
	
	/**
	 * @return the applicants
	 */
	public ArrayList<String> getApplicants() {
		return applicants;
	}

//	public String getApplicants_s() {
//		return 
//	}
	/**
	 * @param applicants the applicants to set
	 */
//	public void setApplicants(ArrayList<Person> applicants) {
//		this.applicants = applicants;
//	}

	/**
	 * @return the requiredExperience
	 */
	public int getRequiredExperience() {
		return requiredExperience;
	}

	/**
	 * @param requiredExperience the requiredExperience to set
	 */
//	public void setRequiredExperience(int requiredExperience) {
//		this.requiredExperience = requiredExperience;
//	}

	/**
	 * @return the requiredDegree
	 */
	public String getRequiredDegree() {
		return requiredDegree;
	}

	/**
	 * @param requiredDegree the requiredDegree to set
	 */
//	public void setRequiredDegree(String requiredDegree) {
//		this.requiredDegree = requiredDegree;
//	}

	/**
	 * @return the requiredMajor
	 */
	public String getRequiredMajor() {
		return requiredMajor;
	}

	/**
	 * @param requiredMajor the requiredMajor to set
	 */
//	public void setRequiredMajor(String requiredMajor) {
//		this.requiredMajor = requiredMajor;
//	}

	public ArrayList<String> getPostAttachments() {
		return postAttachments;
	}
	
//	public void addPostAttachment(String string) {
//		this.postAttachments.add(string);
//	}
	

}
