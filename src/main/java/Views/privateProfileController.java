package Views;

import conexion.Post;
import conexion.Skill;
import conexion.User;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.text.Text;
import models.ViewTransitionalModel;


public class privateProfileController {
	
	ViewTransitionalModel viewModel;
	
	User user;

    public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@FXML
    private Button editPrivateProfile;

    @FXML
    private Text profileBio;

    @FXML
    private Label profileName;

    @FXML
    private ListView<String> profileRecentPost;

    @FXML
    private ListView<String> profileSkills;
    

    @FXML
    private Button signOut;
    
    public void setViewModel(ViewTransitionalModel viewModel)
    {
    	this.viewModel = viewModel;
    	this.user = viewModel.getLoggedIn();
    	profileName.setText(user.getUserName());
    	profileBio.setText(user.getUserBio());
    	
    }
    
    @FXML
    void onClickEditButton(ActionEvent event) {
    	System.out.println("clicked edit");
//    	viewModel.changetoEditView();
//    	if (viewModel != null) {
//             // Call changetoEditView() on the viewModel instance
//    		break;
//        } else {
//            System.err.println("ViewModel is not initialized.");
//        }
    
    }

    @FXML
    void onClickSignOut(ActionEvent event) {
    	viewModel.setLoggedIn(null);
    	viewModel.changetoLoginView();

    }

}
