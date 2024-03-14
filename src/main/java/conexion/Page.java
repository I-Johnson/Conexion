package conexion;
import java.util.ArrayList;

public abstract class Page {

	private int pageID;
	private ArrayList<Skill> skills;
	private ArrayList<Post> posts;
	public IDGenerator idGenerator;
	/**
	 * @param pageID
	 * @param skills
	 * @param posts
	 */
	public Page(IDGenerator idGenerator, ArrayList<Skill> skills, ArrayList<Post> posts) {
		super();
		this.skills = skills;
		this.posts = posts;
		this.idGenerator = idGenerator;
		this.pageID = idGenerator.giveID(this);
	}
	public IDGenerator getIdGenerator() {
		return idGenerator;
	}
	public void setIdGenerator(IDGenerator idGenerator) {
		this.idGenerator = idGenerator;
	}
	/**
	 * @return the pageID
	 */
	public int getPageID() {
		return pageID;
	}
	/**
	 * @param pageID the pageID to set
	 */
	public void setPageID(int pageID) {
		this.pageID = pageID;
	}
	/**
	 * @return the skills
	 */
	public ArrayList<Skill> getSkills() {
		return skills;
	}
	/**
	 * @param skills the skills to set
	 */
	public void setSkills(ArrayList<Skill> skills) {
		this.skills = skills;
	}
	/**
	 * @return the posts
	 */
	public ArrayList<Post> getPosts() {
		return posts;
	}
	/**
	 * @param posts the posts to set
	 */
	public void setPosts(ArrayList<Post> posts) {
		this.posts = posts;
	}
	
	
}


