package models;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Text {
	
	StringProperty jobName = new SimpleStringProperty();
	StringProperty jobDescription = new SimpleStringProperty();
	
	StringProperty postName = new SimpleStringProperty();
	StringProperty postDescription = new SimpleStringProperty();
	
	StringProperty skillName = new SimpleStringProperty();
	
	StringProperty EmployerName = new SimpleStringProperty();
	StringProperty EmployerDescription = new SimpleStringProperty();
	
	StringProperty PersonName = new SimpleStringProperty();
	StringProperty PersonDescription = new SimpleStringProperty();
	
	
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
	public StringProperty getEmployerName() {
		return EmployerName;
	}
	public void setEmployerName(StringProperty employerName) {
		EmployerName = employerName;
	}
	public StringProperty getEmployerDescription() {
		return EmployerDescription;
	}
	public void setEmployerDescription(StringProperty employerDescription) {
		EmployerDescription = employerDescription;
	}
	public StringProperty getPersonName() {
		return PersonName;
	}
	public void setPersonName(StringProperty personName) {
		PersonName = personName;
	}
	public StringProperty getPersonDescription() {
		return PersonDescription;
	}
	public void setPersonDescription(StringProperty personDescription) {
		PersonDescription = personDescription;
	}
	

}
