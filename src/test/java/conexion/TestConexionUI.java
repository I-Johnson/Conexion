package conexion;

import java.io.IOException;

//import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.web.client.RestClient;
import org.testfx.api.FxRobot;
import org.testfx.assertions.api.Assertions;
import org.testfx.framework.junit5.ApplicationExtension;
import org.testfx.framework.junit5.Start;
import org.testfx.util.WaitForAsyncUtils;

import Views.MainController;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import models.ViewTransitionalModel;

@ExtendWith(ApplicationExtension.class)
public class TestConexionUI {
	RestClient client;
	public Skill mern;
	public IDGenerator idGenerator;
	public PageCounter contedorDePaginas;
	@Start
	private void start(Stage stage) {
//		prepopulate();
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(Main.class.getResource("/Views/navBar.fxml"));
		BorderPane view;
		try {
			view = loader.load();
			MainController cont = loader.getController();
			ViewTransitionalModel vm = new ViewTransitionalModel(view);
			vm.changetoLoginView();
			cont.setModel(vm);
			Scene s = new Scene(view);
			stage.setScene(s);
			stage.show(); 
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private void clearTextField(FxRobot robot,String selector)
	  {
		TextField tf = robot.lookup(selector)
				.queryAs(TextField.class); 
		Platform.runLater(()->{tf.clear();});
		WaitForAsyncUtils.waitForFxEvents(); 
	  }
	
	private void enterInfo(FxRobot robot, String text, String target) {
		clearTextField(robot, target);
		robot.clickOn(target);
		robot.write(text);
	}
	
	private void checkResult(FxRobot robot, String text, String target) {
		Assertions.assertThat(robot.lookup(target)
				.queryAs(Label.class)).hasText(text);
	}
	
	@Test
	public void testLogin(FxRobot robot) {
		enterInfo(robot, "robin@princeton.edu", "email");
		enterInfo(robot, "Williams", "password");
		robot.clickOn("#loginButton");
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
