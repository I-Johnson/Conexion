package conexion;
import java.util.ArrayList;

import com.fasterxml.jackson.annotation.JsonIgnore;

public abstract class Page {

	private String pageID;
	public ArrayList<String> skills;
	public ArrayList<String> posts;
	@JsonIgnore
	public IDGenerator idGenerator;
	public ArrayList<String> viewers;
	public ArrayList<String> editors;
	public boolean isPublicallyVisible;
	
	public Page(IDGenerator idGenerator) {
		this.idGenerator = idGenerator;
//		if (idGenerator.getInstance() == null) {
//			idGenerator = new IDGenerator();
//		}
		this.skills = new ArrayList<String>();
		this.posts = new ArrayList<String>();
		this.pageID = this.getClass().getSimpleName() + "/" + idGenerator.postID().toString();
		this.viewers = new ArrayList<String>();
		this.editors = new ArrayList<String> ();
		this.isPublicallyVisible = true;
	}
	
	//defualt constructor so that json stops with all its crap
	public Page() {
		this.idGenerator=null;
		this.posts = new ArrayList<String>();
		this.pageID = null;
		this.viewers = new ArrayList<String>();
		this.editors = new ArrayList<String>();
		this.isPublicallyVisible = true;
		this.skills = new ArrayList<String>();
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
	public String getPageID() {
		return pageID;
	}
	/**
	 * @param pageID the pageID to set
	 */
	public void setPageID(String pageID) {
		this.pageID = pageID;
	}
	/**
	 * @return the skills
	 */
	public ArrayList<String> getSkills() {
		return skills;
	}
	/**
	 * @param skills the skills to set
	 */
	public void setSkills(ArrayList<String> skills) {
		this.skills = skills;
	}
	/**
	 * @return the posts
	 */
	public ArrayList<String> getPosts() {
		return posts;
	}
	/**
	 * @param posts the posts to set
	 */
	public void setPosts(ArrayList<String> posts) {
		this.posts = posts;
	}
	
	public abstract void addSkill(Skill skill);
	public abstract void addPost(Post post);
	
	public void addViewer(User user) {
		this.viewers.add(user.getPageID());
	}
	
	@Override
	public String toString() {
		return "Page [pageID=" + pageID + ", skills=" + skills + ", posts=" + posts + ", idGenerator=" + idGenerator
				+ ", viewers=" + viewers + ", editors=" + editors + ", isPublicallyVisible=" + isPublicallyVisible
				+ "]";
	}

	// editor automatically has viewer access
	public void addEditor(String user) {
		this.editors.add(user);
		this.viewers.add(user);
		
	}
	
	
	
}


