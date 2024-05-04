package models;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;


import Views.AllEmployersViewController;
import Views.AllJobsViewController;
import Views.AllPersonsViewController;
import Views.AllPostsViewController;
import Views.AllSkillsViewController;
import Views.ListJob;
import Views.ListPost;
import Views.ListSkill;
import Views.LoginViewController;
import Views.privateProfileController;
import conexion.Employer;
import conexion.IDGenerator;
import conexion.Job;
import conexion.Person;
import conexion.Post;
import conexion.RestMain;
import conexion.Skill;
import conexion.User;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.layout.BorderPane;

public class ViewTransitionalModel implements ViewTransitionModelInterface {
	
	User loggedIn;
	
	BorderPane  mainview;
	public ViewTransitionalModel(BorderPane view) {
		mainview = view;
		loggedIn = null;
		
	}

	
	// Not required for design implementation 3
	@Override
	public void showHome() {
		// TODO Auto-generated method stub

	}

	@Override
	public void showAllEmployers() {
		// TODO Auto-generated method stub

		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(ViewTransitionalModel.class.getResource("/Views/allEmployers.fxml"));
		try {
			Node view = loader.load();
			mainview.setCenter(view);
			AllEmployersViewController cont = loader.getController();
			cont.setModel(this);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	public void showAllJobs() {
		// TODO Auto-generated method stub
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(ViewTransitionalModel.class.getResource("/Views/allJobs.fxml"));
		try {
			ListJob listJob = new ListJob();
			RestMain client = RestMain.getInstance();
			ObservableList<Job> observableJobs = FXCollections.observableList(client.getAllJobs());
			(listJob).setItems(observableJobs);
			Node view = loader.load();
			mainview.setCenter(view);
			AllJobsViewController cont = loader.getController();
			cont.setJobViewModel(this);
			cont.setJobModel(listJob);
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	@Override
	public void showSingleJob(String id) {
		// TODO Auto-generated method stub
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(ViewTransitionalModel.class.getResource("/Views/singleJobPage.fxml"));
		RestMain client = RestMain.getInstance();
		Job myJob = client.getJob(id).data(); // add edit permissions later!!
		Text text = new Text();
		
		try {
			Node view = loader.load();
			mainview.setCenter(view);
			AllJobsViewController cont = loader.getController();
			cont.setJob(myJob);
			cont.setJobViewModel(this);
			cont.setInfo(text);
			cont.setJobName();
			cont.setJobDescriptionName();
			
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
		
		try {
			Node view = loader.load();
			mainview.setCenter(view);
			AllPostsViewController cont = loader.getController();
			
			cont.setPost(myPost);
			cont.setPostViewModel(this);
			cont.setInfo(text);
			cont.setPostName();
			cont.setPostDescriptionName();
			
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
		
		try {
			Node view = loader.load();
			mainview.setCenter(view);
			AllSkillsViewController cont = loader.getController();
			
			cont.setSkill(mySkill);
			cont.setSkillViewModel(this);
			cont.setInfo(text);
			cont.setSkillName();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
	@Override
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
			AllJobsViewController cont = loader.getController();
			cont.setJob(myJob);
			cont.setJobViewModel(this);
			cont.setInfo(text);
			cont.setEditInfo();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
	@Override
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
			AllPostsViewController cont = loader.getController();
			cont.setPost(myPost);
			cont.setPostViewModel(this);
			cont.setInfo(text);
			cont.setEditInfo();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
	@Override
	public void showEditSkill(String id) {
		// TODO Auto-generated method stub
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(ViewTransitionalModel.class.getResource("/Views/skillEdit.fxml"));
		RestMain client = RestMain.getInstance();
		Skill mySkill = client.getSkill(id).data(); // add edit permissions later!!
		Text text = new Text();
		
		try {
			Node view = loader.load();
			mainview.setCenter(view);
			AllSkillsViewController cont = loader.getController();
			cont.setSkill(mySkill);
			cont.setSkillViewModel(this);
			cont.setInfo(text);
			cont.setEditInfo();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
	

	@Override
	public void showAllPersons() {
		// TODO Auto-generated method stub
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(ViewTransitionalModel.class.getResource("/Views/allUsers.fxml"));
		try {
			Node view = loader.load();
			mainview.setCenter(view);
			AllPersonsViewController cont = loader.getController();
			cont.setModel(this);
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Override
	public void showAllSkills() {
		// TODO Auto-generated method stub
		FXMLLoader loader = new FXMLLoader();
		//System.out.println((loader.getController())==null);
		loader.setLocation(ViewTransitionalModel.class.getResource("/Views/allSkills.fxml"));
		try {
			ListSkill listSkill = new ListSkill();
			RestMain client = RestMain.getInstance();
			ObservableList<Skill> observableSkills = FXCollections.observableList(client.getAllSkills());
			listSkill.setItems(observableSkills);
			Node view = loader.load();
			mainview.setCenter(view);
			AllSkillsViewController cont = loader.getController();
			//System.out.println(cont==null);
			cont.setSkillViewModel(this);
			cont.setSkillModel(listSkill);
			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
	@Override
	public void showAllPosts() {
		// TODO Auto-generated method stub
		FXMLLoader loader = new FXMLLoader();
		//System.out.println((loader.getController())==null);
		loader.setLocation(ViewTransitionalModel.class.getResource("/Views/allPosts.fxml"));
		try {
			ListPost listPost = new ListPost();
			RestMain client = RestMain.getInstance();
			ObservableList<Post> observablePosts = FXCollections.observableList(client.getAllPosts());
			listPost.setItems(observablePosts);
			Node view = loader.load();
			mainview.setCenter(view);
			AllPostsViewController cont = loader.getController();
			//System.out.println(cont==null);
			cont.setPostViewModel(this);
			cont.setPostModel(listPost);
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		
		}
	}
	
//	@Override
//	public void showAllJobs() {
//		// TODO Auto-generated method stub
//		FXMLLoader loader = new FXMLLoader();
//		loader.setLocation(ViewTransitionalModel.class.getResource("/Views/allJobs.fxml"));
//		try {
//			ListJob listJob = new ListJob();
//			RestMain client = RestMain.getInstance();
//			ObservableList<Job> observableJobs = FXCollections.observableList(client.getAllJobs());
//			(listJob).setItems(observableJobs);
//			Node view = loader.load();
//			mainview.setCenter(view);
//			AllJobsViewController cont = loader.getController();
//			cont.setViewModel(this);
//			cont.setModel(listJob);
//			
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//
//	}


	@Override
	public void showPrivateProfile() {
		// TODO Auto-generated method stub
		FXMLLoader loader = new FXMLLoader();
		if(loggedIn == null) {
			changetoLoginView();
			return;
		}
		
		loader.setLocation(ViewTransitionalModel.class.getResource("/Views/privateProfile.fxml"));
		try {
			Node view = loader.load();
			mainview.setCenter(view);
			privateProfileController cont = loader.getController();
			cont.setUser(loggedIn);
			cont.setViewModel(this);
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


//	@Override
//	public void changetoEditView() {
//		// TODO Auto-generated method stub
//		//System.out.println("reached");
//		FXMLLoader loader = new FXMLLoader();
//		//System.out.println((loader.getController())==null);
//		//System.out.println(loader.getController())
//		loader.setLocation(ViewTransitionalModel.class.getResource("../View/editProfile.fxml"));
//		URL url = loader.getLocation();
//		//System.out.println(url);
//		//loader.setLocation(ViewTransitionalModel.class.getResource("../View/Login.fxml"));
//		try {
//			Node view = loader.load();
//			mainview.setCenter(view);
//			//privateProfileController cont = loader.getController();
//			//cont.setViewModel(this);
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		
//	}


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
		IDGenerator idGenerator = IDGenerator.getInstance();
		RestMain client = RestMain.getInstance();
		boolean found = false;
		
//		Person person;
//		Employer employer;
		
		ArrayList<Person> persons = client.getAllPersons();
		ArrayList<Employer> employers = client.getAllEmployers();
		
		
		for(Person person: persons) {
				if((person.getUserEmail().equals(email)) && (person.getUserPassword().equals(password))) {
					found = true; 
					this.loggedIn = person;
					showPrivateProfile();
					System.out.println("found a profile");
					break;
				}		
		}
		for(Employer employer: employers) {
			if((employer.getUserEmail().equals(email)) && (employer.getUserPassword().equals(password))) {
				found = true; 
				this.loggedIn = employer;
				showPrivateProfile();
				System.out.println("found a profile");
				break;
			}		
		}
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
