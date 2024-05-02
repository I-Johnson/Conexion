package models;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;

import org.springframework.web.client.RestClient;
import org.springframework.web.client.RestClientException;

import Views.AllEmployersViewController;
import Views.AllJobsViewController;
import Views.AllPersonsViewController;
import Views.AllSkillsViewController;
import Views.LoginViewController;
import Views.privateProfileController;
import conexion.Employer;
import conexion.IDGenerator;
import conexion.Page;
import conexion.Person;
import conexion.RestMain;
import conexion.User;
//import View.AllEmployersViewController;
//import View.AllJobsViewController;
//import View.AllSkillsViewController;
//import View.AllUsersViewController;
//import View.LoginViewController;
//import View.privateProfileController;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;

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
			Node view = loader.load();
			mainview.setCenter(view);
			AllJobsViewController cont = loader.getController();
			cont.setModel(this);
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
			Node view = loader.load();
			mainview.setCenter(view);
			AllSkillsViewController cont = loader.getController();
			//System.out.println(cont==null);
			cont.setModel(this);
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
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
//	public void showAllPosts() {
//		// TODO Auto-generated method stub
//		
//	}
//

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
