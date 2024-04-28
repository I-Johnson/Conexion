 package models;

public interface ViewTransitionModelInterface {
	
	// View Pages
	public void showHome();
//	public void showAllEmployers();
//	public void showAllJobs();
//	public void showAllUsers();
//	public void showAllSkills();
//	public void showAllPosts();
	public void showPrivateProfile();
	public void login(String username, String password);
	//Edit Pages 
	
//	public void changetoEditView();
	public void changetoLoginView();

}
