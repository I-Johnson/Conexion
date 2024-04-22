package conexion;
import java.util.ArrayList;

import com.fasterxml.jackson.annotation.JsonIgnore;

public abstract class Page {

	private Integer pageID;
	public ArrayList<Integer> skills;
	public ArrayList<Integer> posts;
	@JsonIgnore
	public IDGenerator idGenerator;
	public ArrayList<Integer> viewers;
	public ArrayList<Integer> editors;
	public boolean isPublicallyVisible;
	
	public Page(IDGenerator idGenerator) {
		this.idGenerator = idGenerator;
//		if (idGenerator.getInstance() == null) {
//			idGenerator = new IDGenerator();
//		}
		this.skills = new ArrayList<Integer>();
		this.posts = new ArrayList<Integer>();
		this.pageID = idGenerator.giveID(this);
		this.viewers = new ArrayList<Integer>();
		this.editors = new ArrayList<Integer> ();
		this.isPublicallyVisible = true;
	}
	
	//defualt constructor so that json stops with all its crap
	public Page() {
		this.idGenerator=null;
		this.posts = new ArrayList<Integer>();
		this.pageID = null;
		this.viewers = new ArrayList<Integer>();
		this.editors = new ArrayList<Integer>();
		this.isPublicallyVisible = true;
		this.skills = new ArrayList<Integer>();
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
	public Integer getPageID() {
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
	public void addEditor(Integer user) {
		this.editors.add(user);
		this.viewers.add(user);
		
	}
	
	
	
}


