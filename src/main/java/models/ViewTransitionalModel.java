package models;

import java.io.IOException;
import java.net.URL;

import org.springframework.web.client.RestClient;
import org.springframework.web.client.RestClientException;

import Views.LoginViewController;
import conexion.IDGenerator;
import conexion.Page;
import conexion.Person;
import conexion.RestMain;
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
	
	
	BorderPane  mainview;
	public ViewTransitionalModel(BorderPane view) {
		mainview = view;
		
	}

	
	// Not required for design implementation 3
	@Override
	public void showHome() {
		// TODO Auto-generated method stub

	}

//	@Override
//	public void showAllEmployers() {
//		// TODO Auto-generated method stub
//
//		FXMLLoader loader = new FXMLLoader();
//		loader.setLocation(ViewTransitionalModel.class.getResource("../View/allEmployers.fxml"));
//		try {
//			Node view = loader.load();
//			mainview.setCenter(view);
//			AllEmployersViewController cont = loader.getController();
//			cont.setModel(model);
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		
//	}

//	@Override
//	public void showAllJobs() {
//		// TODO Auto-generated method stub
//		FXMLLoader loader = new FXMLLoader();
//		loader.setLocation(ViewTransitionalModel.class.getResource("../View/allJobs.fxml"));
//		try {
//			Node view = loader.load();
//			mainview.setCenter(view);
//			AllJobsViewController cont = loader.getController();
//			cont.setModel(model);
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//
//	}

//	@Override
//	public void showAllUsers() {
//		// TODO Auto-generated method stub
//		FXMLLoader loader = new FXMLLoader();
//		loader.setLocation(ViewTransitionalModel.class.getResource("../View/allUsers.fxml"));
//		try {
//			Node view = loader.load();
//			mainview.setCenter(view);
//			AllUsersViewController cont = loader.getController();
//			cont.setModel(model);
//			
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//
//	}

//	@Override
//	public void showAllSkills() {
//		// TODO Auto-generated method stub
//		FXMLLoader loader = new FXMLLoader();
//		//System.out.println((loader.getController())==null);
//		loader.setLocation(ViewTransitionalModel.class.getResource("../View/allSkills.fxml"));
//		try {
//			Node view = loader.load();
//			mainview.setCenter(view);
//			AllSkillsViewController cont = loader.getController();
//			//System.out.println(cont==null);
//			cont.setModel(model);
//			
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//
//	}


//	@Override
//	public void showPrivateProfile() {
//		// TODO Auto-generated method stub
//		FXMLLoader loader = new FXMLLoader();
//		
//		loader.setLocation(ViewTransitionalModel.class.getResource("../View/privateProfile.fxml"));
//		try {
//			Node view = loader.load();
//			mainview.setCenter(view);
//			privateProfileController cont = loader.getController();
//			System.out.println((cont==null));
//			cont.setModel(model);
//			cont.setViewModel(this);
//			
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//	}


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
		Person page;
		for(int i = 0; i< idGenerator.getNumberOfPages(); i++) {
			try {
				page = client.getPerson("/Person/"+ ((Integer)i).toString()).data();
				if((page.getUserEmail().equals(email)) && (page.getUserPassword().equals(password))) {
					found = true; 
					
					System.out.println("found a profile");
					break;
				}
//				client.updatePage(page);
			} catch (RestClientException e){
				System.out.print("");
			} 
		}
		System.out.println(found);
	}
}
