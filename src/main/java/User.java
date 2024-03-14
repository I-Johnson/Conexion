import java.util.ArrayList;

public class User extends Page{
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
	public User(IDGenerator idGenerator, ArrayList<Skill> skills, ArrayList<Post> posts, String userName, String userPassword,
			String userEmail, String userBio) {
		super(idGenerator, skills, posts);
		this.userName = userName;
		this.userPassword = userPassword;
		this.userEmail = userEmail;
		this.userBio = userBio;
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

	public void post(String postTitle, String postDate, ArrayList<String> postAttachments, String postBody, ArrayList<Skill> skills ) {
		Post newPost = new Post(this.idGenerator, skills, null, postTitle, postDate, postAttachments, postBody, this);
		getPosts().add(newPost);
	}
}



