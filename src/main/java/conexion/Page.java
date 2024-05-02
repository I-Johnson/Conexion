package conexion;
import java.util.ArrayList;
import java.util.Objects;

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
	private ArrayList<String> jobs;
	private ArrayList<String> employers;
	private ArrayList<String> persons;
	
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
		this.jobs = new ArrayList<String> ();
		this.employers = new ArrayList<String> ();
		this.persons = new ArrayList<String> ();
		
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
		this.jobs = new ArrayList<String> ();
		this.employers = new ArrayList<String> ();
		this.persons = new ArrayList<String> ();
	}
	
	
	
	public ArrayList<String> getPersons() {
		return persons;
	}

	public void setPersons(ArrayList<String> persons) {
		this.persons = persons;
	}

	public ArrayList<String> getViewers() {
		return viewers;
	}

	public void setViewers(ArrayList<String> viewers) {
		this.viewers = viewers;
	}

	public ArrayList<String> getEditors() {
		return editors;
	}

	public void setEditors(ArrayList<String> editors) {
		this.editors = editors;
	}

	public boolean isPublicallyVisible() {
		return isPublicallyVisible;
	}

	public void setPublicallyVisible(boolean isPublicallyVisible) {
		this.isPublicallyVisible = isPublicallyVisible;
	}

	public ArrayList<String> getJobs() {
		return jobs;
	}

	public void setJobs(ArrayList<String> jobs) {
		this.jobs = jobs;
	}

	public ArrayList<String> getEmployers() {
		return employers;
	}

	public void setEmployers(ArrayList<String> employers) {
		this.employers = employers;
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

	@Override
	public int hashCode() {
		return Objects.hash(editors, isPublicallyVisible, pageID, posts, skills, viewers);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Page other = (Page) obj;
		return Objects.equals(editors, other.editors) && isPublicallyVisible == other.isPublicallyVisible
				&& Objects.equals(pageID, other.pageID) && Objects.equals(posts, other.posts)
				&& Objects.equals(skills, other.skills) && Objects.equals(viewers, other.viewers);
	}
	
	
	
}