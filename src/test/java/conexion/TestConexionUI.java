package conexion;

import java.io.IOException;

import org.junit.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.testfx.api.FxRobot;
import org.testfx.framework.junit5.ApplicationExtension;
import org.testfx.framework.junit5.Start;

import Views.MainController;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import models.LoginDataModel;
import models.ViewTransitionModelInterface;

@ExtendWith(ApplicationExtension.class)
public class TestConexionUI {
	@Start
	private void start(Stage stage) {
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(LoginDataModel.class.getResource("/Views/navBar.fxml"));
		try {
			Pane view = loader.load();
			MainController cont = loader.getController();
			cont.setModel((ViewTransitionModelInterface) new LoginDataModel());
			Scene s = new Scene(view);
			stage.setScene(s);
			stage.show();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private void enterInfo(FxRobot robot, String text, String target) {
		robot.clickOn(target);
		robot.write(text);
	}
	private void login(FxRobot robot, String email, String password) {
		enterInfo(robot, email, "#emailBox");
		enterInfo(robot, password, "#passwordBox");
		robot.clickOn("#loginButton");
	}
	
	@Test 
	public void testLogin() {
		try {
			FxRobot robot = new FxRobot();
			login(robot, "robin@princeton.edu", "Williams");
			Thread.sleep(2000);
			
		} catch (InterruptedException e) {
	        e.printStackTrace();
	    }
		
	}
}
