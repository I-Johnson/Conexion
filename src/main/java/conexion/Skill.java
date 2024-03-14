package conexion;
 import java.util.ArrayList;

public class Skill extends Page{
	
	private String skill;

	/**
	 * @param pageID
	 * @param skills
	 * @param posts
	 * @param skill
	 */
	public Skill(IDGenerator idGenerator, ArrayList<Skill> skills, ArrayList<Post> posts, String skill) {
		super(idGenerator, skills, posts);
		this.skill = skill;
		for (Post relatedPost : this.getPosts()) {
			relatedPost.getSkills().add(this);
		}
	}
	
	

}
