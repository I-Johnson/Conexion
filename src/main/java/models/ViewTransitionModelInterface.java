 package models;

import conexion.Page;
import conexion.User;

public interface ViewTransitionModelInterface {
	
	public void showHome();
	public void showAllEmployers();
	public void showAllJobs();
	public void showAllSkills();
	void showAllPersons();
	public void showAllPosts();
	public void showPrivateProfile();
	public void showAllPosts(Page parent);
	public void showAllSkills(Page parent);
	public void showAllEmployers(Page parent);
	public void showAllJobs(Page parent);
	public void showAllPersons(Page parent);
	public void login(String username, String password);
	//Edit Pages 
	
	public void changetoLoginView();
	public User getLoggedIn();
	public void showSingleSkill(String id);
	public void showSinglePost(String id);
	public void showSinglePerson(String id);
	public void showSingleEmployer(String id);
//	public void showEmployer(String id);
	public void showSingleJob(String id);
	

}
