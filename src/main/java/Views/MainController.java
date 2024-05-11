package Views;

import javafx.fxml.FXML;
import models.LoginDataModel;
import models.ViewTransitionModelInterface;
import models.ViewTransitionalModel;
import javafx.event.ActionEvent;
public class MainController {
	
	private CommandButton backButton = new CommandButton();
	ViewTransitionModelInterface model;
	
	public void setModel(ViewTransitionModelInterface newModel) {
		model = newModel;
		
	}
	
	public void initialize() {
		backButton.setCommand(new GoBackCommand((ViewTransitionalModel) model));
	}

    @FXML
    void onClickEmployers(ActionEvent event) {
    	model.showAllEmployers();
    	System.out.println("clicked employers");

    }
 
    @FXML
    void onClickHome(ActionEvent event) {
//    	model.showHome();
    	System.out.println("clicked home");
    }

    @FXML
    void onClickJobs(ActionEvent event) {
    	model.showAllJobs();
    	System.out.println("clicked jobs");
    }

    @FXML
    void onClickMyProfile(ActionEvent event) {
    	model.showPrivateProfile();
    	System.out.println("clicked my profile");
    }

    @FXML
    void onClickPosts(ActionEvent event) {
    	model.showAllPosts();
    	System.out.println("clicked posts");
    }

    @FXML
    void onClickSkills(ActionEvent event) {
    	model.showAllSkills();
    	System.out.println("clicked skills");
    }

    @FXML
    void onClickUsers(ActionEvent event) {
    	model.showAllPersons();
    	System.out.println("clicked users");
    }
    
    @FXML
    void onClickBack(ActionEvent event) {
//    	model.showBackPage();
    	backButton.click();
    	System.out.println("clicked Back");
    }

//	public void setModel(LoginDataModel loginDataModel) {
//		// TODO Auto-generated method stub
//		
//	}

}
