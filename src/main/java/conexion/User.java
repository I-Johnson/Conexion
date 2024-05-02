package conexion;

import java.util.ArrayList;
import java.util.Objects;

public abstract class User extends Page{
	private String userName;
	private String userPassword;
	private String userEmail;
	private String userBio;
	
	/**
	 * @param pageID
	 * @param skills
	 * @param posts
	 * @param userName
	 * @param userPassword
	 * @param userEmail
	 * @param userBio
	 */
	public User(IDGenerator idGenerator, String userName, String userPassword,
			String userEmail, String userBio) {
		super(idGenerator);
		this.userName = userName;
		this.userPassword = userPassword;
		this.userEmail = userEmail;
		this.userBio = userBio;
		
		// giving user permission to edit their own page
		this.addEditor(this.getPageID());
	}

	public User() {
		super();
		this.userName = null;
		this.userPassword = null;
		this.userEmail = null;
		this.userBio = null;
		
		// giving user permission to edit their own page
		this.addEditor(this.getPageID());
	}
	/**
	 * @return the userName
	 */
	public String getUserName() {
		return userName;
	}
	/**
	 * @param userName the userName to set
	 */
	public void setUserName(String userName) {
		this.userName = userName;
	}
	/**
	 * @return the userPassword
	 */
	public String getUserPassword() {
		return userPassword;
	}
	/**
	 * @param userPassword the userPassword to set
	 */
	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}
	@Override
	public String toString() {
		return "User [userName=" + userName + ", userPassword=" + userPassword + ", userEmail=" + userEmail
				+ ", userBio=" + userBio + "]";
	}
	/**
	 * @return the userEmail
	 */
	public String getUserEmail() {
		return userEmail;
	}
	/**
	 * @param userEmail the userEmail to set
	 */
	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}
	/**
	 * @return the userBio
	 */
	public String getUserBio() {
		return userBio;
	}
	/**
	 * @param userBio the userBio to set
	 */
	public void setUserBio(String userBio) {
		this.userBio = userBio;
	}

	public Post post(String postTitle, String postDate, String postBody) {
		Post newPost = new Post(this.idGenerator, postTitle, postDate, postBody, this.getPageID());
//		getPosts().add(newPost);
		this.addPost(newPost);
		return newPost;
	}

	@Override
	public void addSkill(Skill skill) {
		this.getSkills().add(skill.getPageID());
		skill.addViewer(this);
		
	}
	@Override
	public void addPost(Post post) {
		this.getPosts().add(post.getPageID());
		post.addViewer(this);
		 
	}
	
	public boolean viewAttempt(Page page) {
		if (page.viewers.contains(this.getPageID())) {
			return true;
		}
		else {
			return isPublicallyVisible;
		}
	}
	
	public boolean editAttempt(Page page) {
		if (page.editors.contains(this.getPageID())) {
			return true;
		}
		else {
			return false;
		}
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + Objects.hash(userBio, userEmail, userName, userPassword);
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		return Objects.equals(userBio, other.userBio) && Objects.equals(userEmail, other.userEmail)
				&& Objects.equals(userName, other.userName) && Objects.equals(userPassword, other.userPassword);
	}
	
	
}