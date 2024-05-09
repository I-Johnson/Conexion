package conexion;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.web.client.RestClient;
import org.testfx.framework.junit5.ApplicationExtension;
import org.testfx.framework.junit5.Start;
import org.testfx.api.FxRobot;
import org.testfx.assertions.api.Assertions;
import org.testfx.util.WaitForAsyncUtils;

import Views.MainController;
import javafx.application.Platform;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
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
            e.printStackTrace();
        }
    }
    
    private void clearTextField(FxRobot robot, String selector) {
        TextField tf = robot.lookup(selector).queryAs(TextField.class); 
        Platform.runLater(tf::clear);
        WaitForAsyncUtils.waitForFxEvents(); 
    }
    
    private void clearTextArea(FxRobot robot, String selector) {
    	TextArea ta = robot.lookup(selector).queryAs(TextArea.class); 
        Platform.runLater(ta::clear);
        WaitForAsyncUtils.waitForFxEvents(); 
    }
    
    private void enterInfo(FxRobot robot, String text, String target) {
        clearTextField(robot, target);
        robot.clickOn(target);
        robot.write(text);
    }
    
    private void enterInfoTextArea(FxRobot robot, String text, String target) {
        clearTextArea(robot, target);
        robot.clickOn(target);
        robot.write(text);
    }
    
    private void checkResult(FxRobot robot, String text, String target) {
        Assertions.assertThat(robot.lookup(target).queryAs(Label.class)).hasText(text);
    }
    
    @Test
    public void test(FxRobot robot) {
    	
    	//login as user
        enterInfo(robot, "robin@princeton.edu", "#email");
        enterInfo(robot, "Williams", "#password");
        robot.clickOn("#loginButton");
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        
        // Test Navbar by clicking and asserting if we go to the place we want. 
        robot.clickOn("#Jobs");
        checkResult(robot, "Job Openings", "#allJobsTitle");
        robot.clickOn("#Employers");
        checkResult(robot, "Employers", "#allEmployersTitle");
        robot.clickOn("Users");
        checkResult(robot, "Users", "#allUsersTitle");
        robot.clickOn("Skills");
        checkResult(robot, "Skills", "#allSkillsTitle");
        robot.clickOn("Posts");
        checkResult(robot, "Posts", "#allPostsTitle");
        robot.clickOn("#Profile");
        

        checkResult(robot, "Robin", "#title"); // Check if the title is set to "Robin"
        checkResult(robot, "GreatestActor", "#description"); // Check if the description is "GreatestActor"
        
        robot.clickOn("#edit");
        
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        
        // Check if proper info is loaded
        String name = robot.lookup("#titleText").queryAs(TextField.class).getText();
        String description = robot.lookup("#descriptionText").queryAs(TextArea.class).getText();

        Assertions.assertThat(name).isEqualTo("Robin");
        Assertions.assertThat(description).isEqualTo("GreatestActor");

        // edit and save
        enterInfo(robot, "Robin Williams", "#titleText");
        enterInfoTextArea(robot, "The Greatest Actor", "#descriptionText");
         
        robot.clickOn("#save");
        
        checkResult(robot, "Robin Williams", "#title"); // Check if the title is set to "Robin Williams" after the change
        checkResult(robot, "The Greatest Actor", "#description"); // Check if the description is "The Greatest Actor"
        
        //Check related pages buttons work
        robot.clickOn("#Jobs");
        checkResult(robot, "Job Openings", "#allJobsTitle");
        ListView<String> jobListView = robot.lookup("#allJobsList").queryAs(ListView.class);
        ObservableList<String> jobItems = jobListView.getItems();
//        jobItems.forEach(System.out::println);
        // Define expected job titles
        List<String> expectedJobs = Arrays.asList("Job: SWE Senior", "Job: SWE Associate", "Job: SWE Principal", "Job: Software Engineering Associate");
        Assertions.assertThat(jobItems).containsExactlyElementsOf(expectedJobs);
        
        robot.clickOn("#Profile");
        robot.clickOn("#employer");
        checkResult(robot, "Employers", "#allEmployersTitle");
//        robot.clickOn("Users");
//        checkResult(robot, "Users", "#allUsersTitle");
        robot.clickOn("#Profile");
        robot.clickOn("#skill");
        checkResult(robot, "Skills", "#allSkillsTitle");
        robot.clickOn("#Profile");
        robot.clickOn("#post");
        checkResult(robot, "Posts", "#allPostsTitle");
        robot.clickOn("#Profile");
        

        
        //Check if signout Button works. 
        robot.clickOn("#signOut"); // Assert signout works and there are no permissions. 
        
        enterInfo(robot, "careers@netflix.com", "#email");
        enterInfo(robot, "No Sharing", "#password");
        robot.clickOn("#loginButton");
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
//        System.out.print(loggedIn);
//        assertThat(loggedIn.g)
    }
}
