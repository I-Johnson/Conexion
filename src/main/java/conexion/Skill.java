package conexion;

import java.util.Objects;

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

	@Override
	public String toString() {
		return "Skill [skillName=" + skillName + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + Objects.hash(skillName);
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
		Skill other = (Skill) obj;
		return Objects.equals(skillName, other.skillName);
	}
	
	
	
	
	
}
