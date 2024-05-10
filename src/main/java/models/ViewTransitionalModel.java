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
import Views.ListEmployer;
import Views.ListPerson;
import Views.LoginViewController;
import Views.privateProfileController;
import conexion.Employer;
import conexion.IDGenerator;
import conexion.Job;
import conexion.Page;
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
	RestMain client = RestMain.getInstance();
	BorderPane  mainview;
	Page current;
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
			ListEmployer listEmployer = new ListEmployer();
			RestMain client = RestMain.getInstance();
			ObservableList<Employer> observableJobs = FXCollections.observableList(client.getAllEmployers());
			(listEmployer).setItems(observableJobs);
			Node view = loader.load();
			mainview.setCenter(view);
			AllEmployersViewController cont = loader.getController();
			cont.setEmployerViewModel(this);
			cont.setEmployerModel(listEmployer);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	@Override
	public void showAddEmployers() {
		// TODO Auto-generated method stub

		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(ViewTransitionalModel.class.getResource("/Views/allEmployers.fxml"));
		try {
			ListEmployer listEmployer = new ListEmployer();
			RestMain client = RestMain.getInstance();
			ObservableList<Employer> observableJobs = FXCollections.observableList(client.getAllEmployers());
			(listEmployer).setItems(observableJobs);
			Node view = loader.load();
			mainview.setCenter(view);
			AllEmployersViewController cont = loader.getController();
			cont.setEmployerViewModel(this);
			cont.setParent(current);
			cont.setAddEmployerModel(listEmployer);
//			cont.setEmployerModel(listEmployer); 
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	public void showAllEmployers(Page page) {
		// TODO Auto-generated method stub

		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(ViewTransitionalModel.class.getResource("/Views/allEmployers.fxml"));
		try {
			ArrayList<Employer> pages = new ArrayList<Employer> ();
			
			for (String id: page.getEmployers()) {
				pages.add(client.getEmployer(id).data());
				
			}
			ListEmployer listEmployer = new ListEmployer();
			ObservableList<Employer> observableJobs = FXCollections.observableList(pages);
			(listEmployer).setItems(observableJobs);
			Node view = loader.load();
			mainview.setCenter(view);
			AllEmployersViewController cont = loader.getController();
			cont.setEmployerViewModel(this);
			cont.setEmployerModel(listEmployer);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	public void showAddJobs() {
		// TODO Auto-generated method stub
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(ViewTransitionalModel.class.getResource("/Views/allJobs.fxml"));
		try {
			ListJob listJob = new ListJob();
			ObservableList<Job> observableJobs = FXCollections.observableList(client.getAllJobs());
			(listJob).setItems(observableJobs);
			Node view = loader.load();
			mainview.setCenter(view);
			AllJobsViewController cont = loader.getController();
			cont.setJobViewModel(this);
//			cont.setJobModel(listJob);
			cont.setParent(current);
			cont.setAddJobModel(listJob);
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Override
	public void showAllJobs(Page page) {
		// TODO Auto-generated method stub
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(ViewTransitionalModel.class.getResource("/Views/allJobs.fxml"));
		try {
			
			ArrayList<Job> pages = new ArrayList<Job> ();
			for (String id: page.getJobs()) {
				pages.add(client.getJob(id).data());
				
			}
			ListJob listJob = new ListJob();
			ObservableList<Job> observableJobs = FXCollections.observableList(pages);
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
	public void showAllJobs() {
		// TODO Auto-generated method stub
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(ViewTransitionalModel.class.getResource("/Views/allJobs.fxml"));
		try {
			
//			ArrayList<Job> pages = client.getAllJobs();
			ListJob listJob = new ListJob();
			
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
		current = myJob;
		
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
		current = myPost;
		
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
		current = mySkill;
		
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
	public void showPrivateEmployer(String id) {
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(ViewTransitionalModel.class.getResource("/Views/privateSingleEmployerPage.fxml"));
		RestMain client = RestMain.getInstance();
		Employer myEmployer = client.getEmployer(id).data(); 
		Text text = new Text();
		current = myEmployer;
		try {
			Node view = loader.load();
			mainview.setCenter(view);
			AllEmployersViewController cont = loader.getController();
			
			cont.setEmployer(myEmployer);
			System.out.println(myEmployer);
			cont.setEmployerViewModel(this);
			cont.setInfo(text);
			
			cont.setEmployerName();
			cont.setEmployerDescriptionName();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
	@Override 
	public void showSingleEmployer(String id) {
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(ViewTransitionalModel.class.getResource("/Views/privateSingleEmployerPage.fxml"));
		RestMain client = RestMain.getInstance();
		Employer myEmployer = client.getEmployer(id).data(); 
		Text text = new Text();
		current = myEmployer;
		
		try {
			Node view = loader.load();
			mainview.setCenter(view);
			AllEmployersViewController cont = loader.getController();
			
			cont.setEmployer(myEmployer);
			System.out.println(myEmployer);
			cont.setEmployerViewModel(this);
			cont.setInfo(text);
			
			cont.setEmployerName();
			cont.setEmployerDescriptionName();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
	@Override
	public void showSinglePerson(String id) {
		// TODO Auto-generated method stub
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(ViewTransitionalModel.class.getResource("/Views/privateSinglePersonPage.fxml"));
		RestMain client = RestMain.getInstance();
		Person myPerson = client.getPerson(id).data(); // add edit permissions later!!
		current = myPerson;
		Text text = new Text();
		
		try {
			Node view = loader.load();
			mainview.setCenter(view);
			AllPersonsViewController cont = loader.getController();
			
			cont.setPerson(myPerson);
			cont.setPersonViewModel(this);
			cont.setInfo(text);
			cont.setPersonName();
			cont.setPersonDescriptionName();
			
		} catch (IOException e) { 
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
	@Override
	public void showPrivatePerson(String id) {
		// TODO Auto-generated method stub
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(ViewTransitionalModel.class.getResource("/Views/privateSinglePersonPage.fxml"));
		RestMain client = RestMain.getInstance();
		Person myPerson = client.getPerson(id).data(); // add edit permissions later!!
		current = myPerson;
		Text text = new Text();
		
		try {
			Node view = loader.load();
			mainview.setCenter(view);
			AllPersonsViewController cont = loader.getController();
			
			cont.setPerson(myPerson);
			cont.setPersonViewModel(this);
			cont.setInfo(text);
			cont.setPersonName();
			cont.setPersonDescriptionName();
			
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
		Post myPost = client.getPost(id).data(); 
		Text text = new Text();
		
		try {
			System.out.println("lkajfd");
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
	public void showEditEmployer(String id) {
		// TODO Auto-generated method stub
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(ViewTransitionalModel.class.getResource("/Views/employerEdit.fxml"));
		RestMain client = RestMain.getInstance();
		Employer myEmployer = client.getEmployer(id).data(); // add edit permissions later!!
		Text text = new Text();
		
		try {
			Node view = loader.load();
			mainview.setCenter(view);
			AllEmployersViewController cont = loader.getController();
			cont.setEmployer(myEmployer);
			cont.setEmployerViewModel(this);
			cont.setInfo(text);
			cont.setEditInfo();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
	@Override
	public void showEditPerson(String id) {
		// TODO Auto-generated method stub
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(ViewTransitionalModel.class.getResource("/Views/personEdit.fxml"));
		RestMain client = RestMain.getInstance();
		Person myPerson= client.getPerson(id).data(); // add edit permissions later!!
		Text text = new Text();
		
		try {
			Node view = loader.load();
			mainview.setCenter(view);
			AllPersonsViewController cont = loader.getController();
			cont.setPerson(myPerson);
			cont.setPersonViewModel(this);
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
			ListPerson listPerson = new ListPerson();
			RestMain client = RestMain.getInstance();
			ObservableList<Person> observableSkills = FXCollections.observableList(client.getAllPersons());
			listPerson.setItems(observableSkills);
			Node view = loader.load();
			mainview.setCenter(view);
			AllPersonsViewController cont = loader.getController();
			cont.setPersonViewModel(this);
			cont.setPersonModel(listPerson);
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
	@Override
	public void showAddPerson() {
		// TODO Auto-generated method stub
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(ViewTransitionalModel.class.getResource("/Views/allUsers.fxml"));
		try {
			ListPerson listPerson = new ListPerson();
			RestMain client = RestMain.getInstance();
			ObservableList<Person> observableSkills = FXCollections.observableList(client.getAllPersons());
			listPerson.setItems(observableSkills);
			Node view = loader.load();
			mainview.setCenter(view);
			AllPersonsViewController cont = loader.getController();
			cont.setPersonViewModel(this);
//			cont.setPersonModel(listPerson);
			cont.setParent(current);
			cont.setAddPersonModel(listPerson);
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
	@Override
	public void showAllPersons(Page page) {
		// TODO Auto-generated method stub
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(ViewTransitionalModel.class.getResource("/Views/allUsers.fxml"));
		try {
			
			ArrayList<Person> pages = new ArrayList<Person> ();
			for (String id: page.getPersons()) {
				pages.add(client.getPerson(id).data());
				
			}
			ListPerson listPerson = new ListPerson();
			ObservableList<Person> observableSkills = FXCollections.observableList(pages);
			listPerson.setItems(observableSkills);
			Node view = loader.load();
			mainview.setCenter(view);
			AllPersonsViewController cont = loader.getController();
			cont.setPersonViewModel(this);
			cont.setPersonModel(listPerson);
			
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
	public void showAddSkills() {
		// TODO Auto-generated method stub
		FXMLLoader loader = new FXMLLoader();
		//System.out.println((loader.getController())==null);
		loader.setLocation(ViewTransitionalModel.class.getResource("/Views/allSkills.fxml"));
		try {
			ListSkill listSkill = new ListSkill();
			ObservableList<Skill> observableSkills = FXCollections.observableList(client.getAllSkills());
			listSkill.setItems(observableSkills);
			Node view = loader.load();
			mainview.setCenter(view);
			AllSkillsViewController cont = loader.getController();
			//System.out.println(cont==null);
			cont.setSkillViewModel(this);
			cont.setParent(current);
//			cont.setSkillModel(listSkill);
			cont.setAddSkillModel(listSkill);
			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
	@Override
	public void showAllSkills(Page page) {
		// TODO Auto-generated method stub
		FXMLLoader loader = new FXMLLoader();
		//System.out.println((loader.getController())==null);
		loader.setLocation(ViewTransitionalModel.class.getResource("/Views/allSkills.fxml"));
		try {
			
			ArrayList<Skill> pages = new ArrayList<Skill> ();
			for (String id: page.getSkills()) {
				pages.add(client.getSkill(id).data());
				
			}
			ListSkill listSkill = new ListSkill();
			ObservableList<Skill> observableSkills = FXCollections.observableList(pages);
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
	
	@Override
	public void showAddPosts() {
		// TODO Auto-generated method stub
		FXMLLoader loader = new FXMLLoader();
		//System.out.println((loader.getController())==null);
		loader.setLocation(ViewTransitionalModel.class.getResource("/Views/allPosts.fxml"));
		try {
			ListPost listPost = new ListPost();
			ObservableList<Post> observablePosts = FXCollections.observableList(client.getAllPosts());
			listPost.setItems(observablePosts);
			Node view = loader.load();
			mainview.setCenter(view);
			AllPostsViewController cont = loader.getController();
			//System.out.println(cont==null);
			cont.setPostViewModel(this);
			cont.setParent(current);
//			cont.setPostModel(listPost);
			cont.setAddPostModel(listPost);
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		
		}
	}
	

	
	@Override
	public void showAllPosts(Page page) {
		// TODO Auto-generated method stub
		FXMLLoader loader = new FXMLLoader();
		//System.out.println((loader.getController())==null);
		loader.setLocation(ViewTransitionalModel.class.getResource("/Views/allPosts.fxml"));
		try {
			ArrayList<Post> pages = new ArrayList<Post> ();
			for (String id: page.getPosts()) {
				pages.add(client.getPost(id).data());
				
			}
			ListPost listPost = new ListPost();
			ObservableList<Post> observablePosts = FXCollections.observableList(pages);
			listPost.setItems(observablePosts);
			Node view = loader.load();
			mainview.setCenter(view);
			AllPostsViewController cont = loader.getController();
			cont.setPostViewModel(this);
			cont.setPostModel(listPost);
			
		} catch (IOException e) {
			e.printStackTrace();
		
		}
	}



	@Override
	public void showPrivateProfile() {
		// TODO Auto-generated method stub
		FXMLLoader loader = new FXMLLoader();
		if(loggedIn == null) {
			changetoLoginView();
			return;
		} else if (loggedIn instanceof Person) {
			showPrivatePerson(loggedIn.getPageID());
		} else {
			showPrivateEmployer(loggedIn.getPageID());
		}
		
//		loader.setLocation(ViewTransitionalModel.class.getResource("/Views/privateProfile.fxml"));
//		try {
//			Node view = loader.load();
//			mainview.setCenter(view);
//			privateProfileController cont = loader.getController();
//			cont.setUser(loggedIn);
//			cont.setViewModel(this);
//			
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
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
		IDGenerator idGenerator = IDGenerator.getInstance();
		boolean found = false;
		ArrayList<Person> persons = client.getAllPersons();
		ArrayList<Employer> employers = client.getAllEmployers();
		
		
		for(Person person: persons) {
				if((person.getUserEmail().equals(email)) && (person.getUserPassword().equals(password))) {
					found = true; 
					this.loggedIn = person;
					showPrivatePerson(person.getPageID());
//					showSinglePerson(person.getPageID());
					System.out.println("found a profile");
					break;
				}		
		}
		for(Employer employer: employers) {
			if((employer.getUserEmail().equals(email)) && (employer.getUserPassword().equals(password))) {
				found = true; 
				this.loggedIn = employer;
				showPrivateEmployer(employer.getPageID());
//				showSingleEmployer(employer.getPageID());
//				System.out.println("found a profile");
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
