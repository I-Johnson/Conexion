package conexion;
import java.util.ArrayList;

public class Post extends Page{
	
	private String postTitle;
	private String postDate;
	private ArrayList<String> postAttachments;
	private String postBody;
	private Integer postAuthor;
	/**
	 * @param pageID
	 * @param skills
	 * @param posts
	 * @param postTitle
	 * @param postDate
	 * @param postAttachments
	 * @param postBody
	 * @param postAuthor
	 */
	public Post(IDGenerator idGenerator, String postTitle, String postDate,
			 String postBody, Integer postAuthor) {
		super(idGenerator);
		this.postTitle = postTitle;
		this.postDate = postDate;
		this.postAttachments = new ArrayList<String>();
		this.postBody = postBody;
		this.postAuthor = postAuthor;
//		for (Skill relatedSkill : this.getSkills()) {
//			relatedSkill.getPosts().add(this);
//		}
		// giving author editor access to their own posts
		this.addEditor(postAuthor);
	}
	
	public Post() {
		super(); 
		this.postTitle = null;
		this.postDate = null;
		this.postAttachments = new ArrayList<String>();
		this.postBody = null;
		this.postAuthor = null;
	}
	
	/**
	 * @return the postTitle
	 */
	public String getPostTitle() {
		return postTitle;
	}
	/**
	 * @param postTitle the postTitle to set
	 */
	public void setPostTitle(String postTitle) {
		this.postTitle = postTitle;
	}
	/**
	 * @return the postDate
	 */
	public String getPostDate() {
		return postDate;
	}
	/**
	 * @param postDate the postDate to set
	 */
	public void setPostDate(String postDate) {
		this.postDate = postDate;
	}
	/**
	 * @return the postAttachments
	 */
	public ArrayList<String> getPostAttachments() {
		return postAttachments;
	}
	/**
	 * @param postAttachments the postAttachments to set
	 */
	public void setPostAttachments(ArrayList<String> postAttachments) {
		this.postAttachments = postAttachments;
	}
	/**
	 * @return the postBody
	 */
	public String getPostBody() {
		return postBody;
	}
	/**
	 * @param postBody the postBody to set
	 */
	public void setPostBody(String postBody) {
		this.postBody = postBody;
	}
	/**
	 * @return the postAuthor
	 */
	public Integer getPostAuthor() {
		return postAuthor;
	}
	/**
	 * @param postAuthor the postAuthor to set
	 */
	public void setPostAuthor(Integer postAuthor) {
		this.postAuthor = postAuthor;
	}
	
	@Override
	public void addSkill(Skill skill) {
		this.getSkills().add(skill.getPageID());
		skill.getPosts().add(this.getPageID());
		
	}
	@Override
	public void addPost(Post post) {
		if(this != post) {
			this.getPosts().add(post.getPageID());
		}
		post.getPosts().add(this.getPageID());
		
	}
	
	public String addPostAttachment(String string ) {
		this.postAttachments.add(string);
		return string;
	}
	

}
