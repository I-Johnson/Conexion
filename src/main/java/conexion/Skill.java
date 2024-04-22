package conexion;

public class Skill extends Page{
	
	private String skillName;

	/**
	 * @param pageID
	 * @param skills
	 * @param posts
	 * @param skillName
	 */
	public Skill(IDGenerator idGenerator, String skillName) {
		super(idGenerator);

		this.setSkillName(skillName);
		this.addSkill(this);
	}
	
	// Skill Default Constructor: 
	public Skill() {
		super();
		this.setSkillName("");
		this.addSkill(this);
	}


	public String getSkillName() {
		return skillName;
	}

	public void setSkillName(String skillName) { 
		this.skillName = skillName;
	}
	
	@Override
	public void addSkill(Skill skill) {
		this.getSkills().add(skill.getPageID());
		if (skill!=this) {
			skill.getSkills().add(this.getPageID());
		}
		
		
	}
	@Override
	public void addPost(Post post) {
		this.getPosts().add(post.getPageID());
		post.getSkills().add(this.getPageID());
		
	}

}
