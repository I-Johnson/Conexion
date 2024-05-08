package models;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;

import Views.AllPagesViewController;
import Views.EditPageViewController;
import Views.EmployerViewController;
import Views.JobViewController;
import Views.LoginViewController;
import Views.PageViewController;
import Views.PostViewController;
import Views.SkillViewController;
import Views.UserViewController;
import conexion.Employer;
import conexion.Job;
import conexion.Page;
import conexion.Person;
import conexion.Post;
import conexion.RestMain;
import conexion.Skill;
import conexion.User;
import javafx.collections.FXCollections;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.layout.BorderPane;

public class ViewTransitionalModel implements ViewTransitionModelInterface {
	
	User loggedIn;
	RestMain client = RestMain.getInstance();
	BorderPane  mainview;
	Page current;
	public ViewTransitionalModel(BorderPane view) {
		mainview = view;
		loggedIn = null;
		
	}
 
	@Override
	public void showHome() {
		// TODO Auto-generated method stub

	}
	
	public void showPages(ArrayList<Page> pages, FXMLLoader loader) {
		try {
			ListPage listPage = new ListPage();
			listPage.setItems(FXCollections.observableList(pages));
			Node view = loader.load();
			mainview.setCenter(view);
			AllPagesViewController cont = loader.getController();
			cont.setModel(this);
			cont.setListPage(listPage);
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void showAddPages(ArrayList<Page> pages, FXMLLoader loader) {
		try {
			ListPage listPage = new ListPage();
			listPage.setItems(FXCollections.observableList(pages));
			Node view = loader.load();
			mainview.setCenter(view);
			AllPagesViewController cont = loader.getController();
			cont.setParent(this.current);
			cont.setModel(this);
			cont.setAddListModel(listPage);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void showAllEmployers() {
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(ViewTransitionalModel.class.getResource("/Views/allEmployers.fxml"));
		ArrayList<Page> pages = client.getAllEmployers();
		showPages(pages, loader);
	}
	
	@Override
	public void showAllPosts() {
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(ViewTransitionalModel.class.getResource("/views/allPosts.fxml"));
		ArrayList<Page> pages = client.getAllPosts();
		showPages(pages, loader);
		
	}
	
	@Override
	public void showAllJobs() {
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(ViewTransitionalModel.class.getResource("/views/allJobs.fxml"));
		ArrayList<Page> pages = client.getAllJobs();
		showPages(pages, loader);
	}
	@Override
	public void showAllPersons() { 
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(ViewTransitionalModel.class.getResource("/views/allUsers.fxml"));
		ArrayList<Page> pages = client.getAllPersons();
		showPages(pages, loader);

	}
	
	@Override
	public void showAllSkills() { 
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(ViewTransitionalModel.class.getResource("/views/allSkills.fxml"));
		ArrayList<Page> pages = client.getAllSkills();
		showPages(pages, loader);

	}
	
	@Override
	public void showAllSkills(Page parent) {
		FXMLLoader loader = new FXMLLoader();
		ArrayList<Page> pages = new ArrayList<Page>();
		for(String id: parent.getSkills()) {
			pages.add(client.getSkill(id).data());
		}
		loader.setLocation(ViewTransitionalModel.class.getResource("/views/allSkills.fxml"));
		
		showPages(pages, loader);
	}
	@Override
	public void showAllPosts(Page parent) {
		FXMLLoader loader = new FXMLLoader();
		ArrayList<Page> pages = new ArrayList<Page>();
		for(String id: parent.getPosts()) {
			pages.add(client.getPost(id).data());
		}
		loader.setLocation(ViewTransitionalModel.class.getResource("/views/allPosts.fxml"));
		showPages(pages, loader);
	}
	@Override
	public void showAllEmployers(Page parent) {
		FXMLLoader loader = new FXMLLoader();
		ArrayList<Page> pages = new ArrayList<Page>();
		for(String id: parent.getEmployers()) {
			pages.add(client.getEmployer(id).data());
		}
		loader.setLocation(ViewTransitionalModel.class.getResource("/views/allEmployers.fxml"));
		showPages(pages, loader);
		
	}
	@Override
	public void showAllJobs(Page parent) {
		FXMLLoader loader = new FXMLLoader();
		ArrayList<Page> pages = new ArrayList<Page>();
		for(String id: parent.getJobs()) {
			pages.add(client.getJob(id).data());
		}
		loader.setLocation(ViewTransitionalModel.class.getResource("/views/allJobs.fxml"));
		showPages(pages, loader);
	}
	@Override
	public void showAllPersons(Page parent) {
		FXMLLoader loader = new FXMLLoader();
		ArrayList<Page> pages = new ArrayList<Page>();
		for(String id: parent.getPersons()) {
			pages.add(client.getPerson(id).data());
		}
		loader.setLocation(ViewTransitionalModel.class.getResource("/views/allUsers.fxml"));
		showPages(pages, loader);
		
	}


	@Override
	public void showSingleJob(String id) {
		// TODO Auto-generated method stub
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(ViewTransitionalModel.class.getResource("/Views/singleJobPage.fxml"));
		RestMain client = RestMain.getInstance();
		Job myJob = client.getJob(id).data(); // add edit permissions later!!
		Text text = new Text();
		current = myJob;
		
		try {
			Node view = loader.load();
			mainview.setCenter(view);
			JobViewController cont = loader.getController();
			cont.setPage(myJob);
			cont.setVm(this);
			cont.getPageName().setText(myJob.getPageTitle());
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
	@Override
	public void showSinglePost(String id) {
		// TODO Auto-generated method stub
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(ViewTransitionalModel.class.getResource("/Views/singlePostPage.fxml"));
		RestMain client = RestMain.getInstance();
		Post myPost = client.getPost(id).data(); // add edit permissions later!!
		Text text = new Text();
		current = myPost;
		
		try {
			Node view = loader.load();
			mainview.setCenter(view);
			PostViewController cont = loader.getController();
			
			cont.setPage(myPost);
			cont.setVm(this);
			cont.getPageName().setText(myPost.getPageTitle());
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
	@Override
	public void showSingleSkill(String id) {
		// TODO Auto-generated method stub
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(ViewTransitionalModel.class.getResource("/Views/singleSkillPage.fxml"));
		RestMain client = RestMain.getInstance();
		Skill mySkill = client.getSkill(id).data(); // add edit permissions later!!
		Text text = new Text();
		current = mySkill;
		
		try {
			Node view = loader.load();
			mainview.setCenter(view);
			SkillViewController cont = loader.getController();
			
			cont.setPage(mySkill);
			cont.setVm(this);
			cont.getPageName().setText(mySkill.getPageTitle());
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
	@Override
	public void showPrivateProfile() {
		// TODO Auto-generated method stub
		FXMLLoader loader = new FXMLLoader();
		if(loggedIn==null) {
			changetoLoginView();
			return;
		}
		if(this.getLoggedIn() instanceof Person) {
		loader.setLocation(ViewTransitionalModel.class.getResource("/views/singlePersonPage.fxml"));
		}
		else {
			loader.setLocation(ViewTransitionalModel.class.getResource("/views/singleEmployerPage.fxml"));

		}
		try {
			Node view = loader.load();
			mainview.setCenter(view);
			UserViewController cont = loader.getController();
			System.out.println((cont==null));
			cont.setPage(getLoggedIn());
			cont.setVm(this);
			cont.getPageName().setText(getLoggedIn().getPageTitle());
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Override
	public void showSingleEmployer(String id) {
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(ViewTransitionalModel.class.getResource("/Views/singleEmployerPage.fxml"));
		RestMain client = RestMain.getInstance();
		Employer myEmployer = client.getEmployer(id).data(); 
		Text text = new Text();
		current = myEmployer;
		
		try {
			Node view = loader.load();
			mainview.setCenter(view);
			PageViewController cont = loader.getController();
			
			cont.setPage(myEmployer);
			cont.setVm(this);
			cont.getPageName().setText(myEmployer.getPageTitle());
			((EmployerViewController) cont).getPageDescriptionLabel().setText(myEmployer.getPageDescription());
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
	@Override
	public void showSinglePerson(String id) {
		// TODO Auto-generated method stub
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(ViewTransitionalModel.class.getResource("/Views/singlePersonPage.fxml"));
		RestMain client = RestMain.getInstance();
		Person myPerson = client.getPerson(id).data(); // add edit permissions later!!
		current = myPerson;
		Text text = new Text();
		
		try {
			Node view = loader.load();
			mainview.setCenter(view);
			UserViewController cont = loader.getController();
			
			cont.setPage(myPerson);
			cont.setVm(this);
			cont.getPageName().setText(myPerson.getPageTitle());
			cont.getPageDescriptionLabel().setText(myPerson.getPageDescription());
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	

	
	public void showEditJob(String id) {
		// TODO Auto-generated method stub
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(ViewTransitionalModel.class.getResource("/Views/jobEdit.fxml"));
		RestMain client = RestMain.getInstance();
		Job myJob = client.getJob(id).data(); // add edit permissions later!!
		Text text = new Text();
		
		try {
			Node view = loader.load();
			mainview.setCenter(view);
			EditPageViewController cont = loader.getController();
			cont.setPage(myJob);
			cont.setVm(this);
			cont.getChangeDescriptionArea().setText(myJob.getPageDescription());
			cont.getChangeNameField().setText(myJob.getPageTitle());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
	
	public void showEditPost(String id) {
		// TODO Auto-generated method stub
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(ViewTransitionalModel.class.getResource("/Views/postEdit.fxml"));
		RestMain client = RestMain.getInstance();
		Post myPost = client.getPost(id).data(); // add edit permissions later!!
		Text text = new Text();
		
		try {
			Node view = loader.load();
			mainview.setCenter(view);
			EditPageViewController cont = loader.getController();
			cont.setPage(myPost);
			cont.setVm(this);
			cont.getChangeDescriptionArea().setText(myPost.getPageDescription());
			cont.getChangeNameField().setText(myPost.getPageTitle());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
	public void showEditEmployer(String id) {
		// TODO Auto-generated method stub
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(ViewTransitionalModel.class.getResource("/Views/employerEdit.fxml"));
		RestMain client = RestMain.getInstance();
		Employer myEmployer = client.getEmployer(id).data(); 
		Text text = new Text();
		
		try {
			Node view = loader.load();
			mainview.setCenter(view);
			EditPageViewController cont = loader.getController();
			cont.setPage(myEmployer);
			cont.setVm(this);
			cont.getChangeDescriptionArea().setText(myEmployer.getPageDescription());
			cont.getChangeNameField().setText(myEmployer.getPageTitle());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
	public void showEditPerson(String id) {
		// TODO Auto-generated method stub
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(ViewTransitionalModel.class.getResource("/Views/personEdit.fxml"));
		RestMain client = RestMain.getInstance();
		Person myPerson= client.getPerson(id).data(); 
		Text text = new Text();
		
		try {
			Node view = loader.load();
			mainview.setCenter(view);
			EditPageViewController cont = loader.getController();
			cont.setPage(myPerson);
			cont.setVm(this);
			cont.getChangeDescriptionArea().setText(myPerson.getPageDescription());
			cont.getChangeNameField().setText(myPerson.getPageTitle());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
	public void showEditSkill(String id) {
		// TODO Auto-generated method stub
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(ViewTransitionalModel.class.getResource("/Views/skillEdit.fxml"));
		RestMain client = RestMain.getInstance();
		Skill mySkill = client.getSkill(id).data(); 
		Text text = new Text();
		
		try {
			Node view = loader.load();
			mainview.setCenter(view);
			EditPageViewController cont = loader.getController();
			cont.setPage(mySkill);
			cont.setVm(this);
			cont.getChangeDescriptionArea().setText(mySkill.getPageDescription());
			cont.getChangeNameField().setText(mySkill.getPageTitle());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
	

	@Override
	public void changetoLoginView() {
		// TODO Auto-generated method stub
		FXMLLoader loader = new FXMLLoader();
		//loader.setLocation(ViewTransitionalModel.class.getResource("../View/editProfile.fxml"));
		loader.setLocation(ViewTransitionalModel.class.getResource("/Views/login.fxml"));
		URL url = loader.getLocation();
		//System.out.println(url);
		try {
			Node view = loader.load();
			//System.out.println("reached1");
			mainview.setCenter(view);
			
			LoginViewController cont = loader.getController();
			//System.out.println("reached");
			cont.setViewModel(this);
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		}
	
	@Override
	public void login(String email, String password) {
		boolean found = false;
		ArrayList<Page> persons = client.getAllPersons();
		ArrayList<Page> employers = client.getAllEmployers();
		for(Page page: persons) {
				User person = (User) page;
				if(person.getUserEmail().equals(email) && person.getUserPassword().equals(password)) {
					found = true;
					//showPrivateProfile(current);
					this.loggedIn = person;
					System.out.println("Logging in as " + person.getUserName()); 
					showSinglePerson(loggedIn.getPageID());
					
				}
		}
		for(Page page: employers) {
			User employer = (User) page;
			if(employer.getUserEmail().equals(email) && employer.getUserPassword().equals(password)) {
				found = true;
				this.loggedIn = employer;
				System.out.println("Logging in as " + employer.getUserName()); 
				showSingleEmployer(loggedIn.getPageID());
				
			}
	}
		
		if(found==false) {
			System.out.println("Profile Not found");
		}
	}
	
	public void showAddSkill() {
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(ViewTransitionalModel.class.getResource("/views/allSkills.fxml"));
		ArrayList<Page> pages = client.getAllSkills();
		showAddPages(pages, loader);
	}
	public void showAddPost() {
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(ViewTransitionalModel.class.getResource("/views/allPosts.fxml"));
		ArrayList<Page> pages = client.getAllSkills();
		showAddPages(pages, loader);
	}
	public void showAddJobseeker() {
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(ViewTransitionalModel.class.getResource("/views/allUsers.fxml"));
		ArrayList<Page> pages = client.getAllSkills();
		showAddPages(pages, loader);
	}
	public void showAddEmployer() {
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(ViewTransitionalModel.class.getResource("/views/allEmployer.fxml"));
		ArrayList<Page> pages = client.getAllSkills();
		showAddPages(pages, loader);
	}
	public void showAddJob() {
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(ViewTransitionalModel.class.getResource("/views/allJob.fxml"));
		ArrayList<Page> pages = client.getAllSkills();
		showAddPages(pages, loader);
	}


	public User getLoggedIn() {
		return loggedIn;
	}


	public void setLoggedIn(User loggedIn) {
		this.loggedIn = loggedIn;
	}


	public BorderPane getMainview() {
		return mainview;
	}


	public void setMainview(BorderPane mainview) {
		this.mainview = mainview;
	}




	


}
