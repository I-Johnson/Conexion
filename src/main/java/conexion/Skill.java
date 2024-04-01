package conexion;

public class Skill extends Page{
	
	private String skill;

	/**
	 * @param pageID
	 * @param skills
	 * @param posts
	 * @param skill
	 */
	public Skill(IDGenerator idGenerator, String skill) {
		super(idGenerator);

		this.setSkill(skill);
		for (Post relatedPost : this.getPosts()) {
			relatedPost.getSkills().add(this);
		}
	}


	public String getSkill() {
		return skill;
	}

	public void setSkill(String skill) {
		this.skill = skill;
	}
	
	@Override
	public void addSkill(Skill skill) {
		this.getSkills().add(skill);
		skill.getSkills().add(this);
		
	}
	@Override
	public void addPost(Post post) {
		this.getPosts().add(post);
		post.getSkills().add(this);
		
	}

}
