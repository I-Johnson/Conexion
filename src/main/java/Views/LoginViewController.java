package Views;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import models.ViewTransitionalModel;

public class LoginViewController {
	
	ViewTransitionalModel viewModel;
	
    @FXML
    private TextField emailBox;

    @FXML
    private Button loginButton;

    @FXML
    private TextField passwordBox;

    @FXML
    void onClickLogin(ActionEvent event) {
    	String email = emailBox.textProperty().get();
    	String password = passwordBox.textProperty().get();
    	viewModel.login(email, password);
    	
    	//System.out.println(username);
    } 


	public ViewTransitionalModel getViewModel() {
		return viewModel;
	}

	public void setViewModel(ViewTransitionalModel viewModel) {
		this.viewModel = viewModel;
	}

}
