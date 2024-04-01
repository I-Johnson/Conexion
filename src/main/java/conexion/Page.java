package conexion;
import java.util.ArrayList;

public abstract class Page {

	private int pageID;
	public ArrayList<Skill> skills;
	public ArrayList<Post> posts;
	public IDGenerator idGenerator;
	public ArrayList<User> viewers;
	public ArrayList<User> editors;
	public boolean isPublicallyVisible;
	
	public Page(IDGenerator idGenerator) {
		super();
		this.idGenerator = idGenerator;
		this.skills = new ArrayList<Skill>();
		this.posts = new ArrayList<Post>();
		this.pageID = idGenerator.giveID(this);
		this.viewers = new ArrayList<User>();
		this.editors = new ArrayList<User> ();
		this.isPublicallyVisible = true;
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
	
	public abstract void addSkill(Skill skill);
	public abstract void addPost(Post post);
	
	public void addViewer(User user) {
		this.viewers.add(user);
	}
	
	// editor automatically has viewer access
	public void addEditor(User user) {
		this.editors.add(user);
		this.viewers.add(user);
		
	}
	
	
	
}


