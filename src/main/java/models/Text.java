package models;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Text {
	
	StringProperty jobName = new SimpleStringProperty();
	StringProperty jobDescription = new SimpleStringProperty();
	
	StringProperty postName = new SimpleStringProperty();
	StringProperty postDescription = new SimpleStringProperty();
	
	StringProperty skillName = new SimpleStringProperty();
	public StringProperty getSkillName() {
		return skillName;
	}
	public void setSkillName(StringProperty skillName) {
		this.skillName = skillName;
	}
	public StringProperty getSkillDescription() {
		return skillDescription;
	}
	public void setSkillDescription(StringProperty skillDescription) {
		this.skillDescription = skillDescription;
	}
	StringProperty skillDescription = new SimpleStringProperty();
	
	public StringProperty getPostName() {
		return postName;
	}
	public void setPostName(StringProperty postName) {
		this.postName = postName;
	}
	public StringProperty getPostDescription() {
		return postDescription;
	}
	public void setPostDescription(StringProperty postDescription) {
		this.postDescription = postDescription;
	}
	public StringProperty getJobName() {
		return jobName;
	}
	public void setJobName(StringProperty jobName) {
		this.jobName = jobName;
	}
	public StringProperty getJobDescription() {
		return jobDescription;
	}
	public void setJobDescription(StringProperty jobDescription) {
		this.jobDescription = jobDescription;
	}

}
