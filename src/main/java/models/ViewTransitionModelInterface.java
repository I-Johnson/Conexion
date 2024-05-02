 package models;

import conexion.User;

public interface ViewTransitionModelInterface {
	
	// View Pages
	public User getLoggedIn();
	public void showHome();
	public void showAllEmployers();
	public void showAllJobs();
	public void showAllSkills();
//	public void showAllPosts();
	public void showPrivateProfile();
	public void login(String username, String password);
	//Edit Pages 
	
//	public void changetoEditView();
	public void changetoLoginView();
	void showAllPersons();

}
