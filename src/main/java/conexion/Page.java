package conexion;
import java.util.ArrayList;

import org.springframework.web.client.RestClient;


public abstract class Page {

	private Integer pageID;
	public ArrayList<Integer> skills;
	public ArrayList<Integer> posts;
	public IDGenerator idGenerator;
	public ArrayList<Integer> viewers;
	public ArrayList<Integer> editors;
	public boolean isPublicallyVisible;
	
	public Page(IDGenerator idGenerator) {
		super();
		this.idGenerator = idGenerator;
		this.skills = new ArrayList<Integer>();
		this.posts = new ArrayList<Integer>();
		this.pageID = idGenerator.giveID(this);
		this.viewers = new ArrayList<Integer>();
		this.editors = new ArrayList<Integer> ();
		this.isPublicallyVisible = true;
	}
	
public record Desc(Integer PageID, ArrayList<Integer> skills, ArrayList<Integer> posts, IDGenerator idGenerator, ArrayList<Integer> viewers, ArrayList<Integer> editors, boolean isPubliclyVisible) {};
	
	public record Response(String request, 
			boolean successful, 
			String message, 
			ArrayList<Desc> data) {};
	
	public IDGenerator getIdGenerator() {
		return idGenerator;
	}
	public void setIdGenerator(IDGenerator idGenerator) {
		this.idGenerator = idGenerator;
	}
	/**
	 * @return the pageID
	 */
	public Integer getPageID() {
		return pageID;
	}
	/**
	 * @param pageID the pageID to set
	 */
	public void setPageID(Integer pageID) {
		this.pageID = pageID;
	}
	/**
	 * @return the skills
	 */
	public ArrayList<Integer> getSkills() {
		return skills;
	}
	/**
	 * @param skills the skills to set
	 */
	public void setSkills(ArrayList<Integer> skills) {
		this.skills = skills;
	}
	/**
	 * @return the posts
	 */
	public ArrayList<Integer> getPosts() {
		return posts;
	}
	/**
	 * @param posts the posts to set
	 */
	public void setPosts(ArrayList<Integer> posts) {
		this.posts = posts;
	}
	
	public abstract void addSkill(Skill skill);
	public abstract void addPost(Post post);
	
	public void addViewer(User user) {
		this.viewers.add(user.getPageID());
	}
	
	// editor automatically has viewer access
	public void addEditor(User user) {
		this.editors.add(user.getPageID());
		this.viewers.add(user.getPageID());
		
	}
	

	
	
}


