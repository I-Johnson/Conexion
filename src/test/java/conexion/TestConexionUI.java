package conexion;

import static org.junit.Assert.assertTrue;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

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
import javafx.collections.FXCollections;
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
	RestMain client = RestMain.getInstance();
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
    
    @SuppressWarnings("unchecked")
	private ListView<Page> getListView(FxRobot robot, String target){
    	return (ListView<Page>) robot.lookup(target).queryAs(ListView.class);
    }  
    @SuppressWarnings("unchecked")
	ListView<Job> getListJobs(FxRobot robot){
    	return(ListView<Job>) robot.lookup("#allJobsList").queryAll().iterator().next();
    }
    private void selectItem(FxRobot robot, int index) {
    	Platform.runLater(() -> {
    		ListView<Page> pages = getListView(robot, "#allPagesView");
    		pages.scrollTo(index);
//    		robot.doubleClickOn(index);
    		pages.getSelectionModel().clearAndSelect(index);
    	});
    	WaitForAsyncUtils.waitForFxEvents();
    }
    
    

    
    @Test
    public void test(FxRobot robot) {
    	
    	//login as user
//        enterInfo(robot, "robin@princeton.edu", "#email");
//        enterInfo(robot, "Williams", "#password");
//        robot.clickOn("#loginButton");
//        try {
//            Thread.sleep(1000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
        

        
        
        
//        // Test Navbar by clicking and asserting if we go to the place we want. 
//        robot.clickOn("#Jobs");
//        checkResult(robot, "Job Openings", "#allPagesTitle");
//        robot.clickOn("#Employers");
//        checkResult(robot, "Employers", "#allEmployersTitle");
//        robot.clickOn("Users");
//        checkResult(robot, "Users", "#allUsersTitle");
//        robot.clickOn("Skills");
//        checkResult(robot, "Skills", "#allSkillsTitle");
//        robot.clickOn("Posts");
//        checkResult(robot, "Posts", "#allPostsTitle");
//        robot.clickOn("#Profile");
        

//        checkResult(robot, "Robin", "#title"); // Check if the title is set to "Robin"
//        checkResult(robot, "GreatestActor", "#description"); // Check if the description is "GreatestActor"
        
//        robot.clickOn("#edit");
        
        
        // Check if proper info is loaded
//        String name = robot.lookup("#titleText").queryAs(TextField.class).getText();
//        String description = robot.lookup("#descriptionText").queryAs(TextArea.class).getText();
//
//        Assertions.assertThat(name).isEqualTo("Robin");
//        Assertions.assertThat(description).isEqualTo("GreatestActor");

        // edit and save
//        enterInfo(robot, "Robin Williams", "#titleText");
//        enterInfoTextArea(robot, "The Greatest Actor", "#descriptionText");
//         
//        robot.clickOn("#save");
//        
//        checkResult(robot, "Robin Williams", "#title"); // Check if the title is set to "Robin Williams" after the change
//        checkResult(robot, "The Greatest Actor", "#description"); // Check if the description is "The Greatest Actor"
        
        //Check related pages buttons work

        
//        @SuppressWarnings("unchecked")
//		ListView<String> jobListView = robot.lookup("#allJobsList").queryAs(ListView.class);
//        ObservableList<String> jobItems = jobListView.getItems();
//        List<String> expectedJobs = Arrays.asList( 
//        	    "Job: SWE Senior",
//        	    "Job: SWE Associate",
//        	    "Job: SWE Principal",
//        	    "Job: Software Engineering Associate"
//        	);
//        System.out.print(expectedJobs);
//
//        Assertions.assertThat(jobItems).containsExactlyElementsOf(expectedJobs);
        
        
//        //Check if the wanted job exists after we open Jobs
//        robot.clickOn("#Jobs");
//        checkResult(robot, "Job Openings", "#allPagesTitle");
//        robot.clickOn("Job: SWE Senior");
//        checkResult(robot, "SWE Senior", "#title");
//        checkResult(robot, "job Description", "#description");
//        
//        robot.clickOn("#Jobs");
//        checkResult(robot, "Job Openings", "#allPagesTitle");
//        robot.clickOn("Job: SWE Associate");
//        checkResult(robot, "SWE Associate", "#title");
//        checkResult(robot, "job Description", "#description");
//        robot.clickOn("#Jobs");
//        checkResult(robot, "Job Openings", "#allPagesTitle");
//        robot.clickOn("Job: SWE Principal");
//        checkResult(robot, "SWE Principal", "#title");
//        checkResult(robot, "job Description", "#description");
//        robot.clickOn("#Jobs");
//        checkResult(robot, "Job Openings", "#allPagesTitle");
//        robot.clickOn("Job: Software Engineering Associate");
//        checkResult(robot, "Software Engineering Associate", "#title");
//        checkResult(robot, "Job Desc", "#description");
//        
//        robot.clickOn("#Profile");
//        
//        //Check if the wanted employer exists after we open Employer
//        robot.clickOn("#Employers");
//        checkResult(robot, "Employers", "#allEmployersTitle");
//        robot.clickOn("Employer Netflix");
//        checkResult(robot, "Netflix", "#title");
//        checkResult(robot, "Finest Software Engineering", "#description");
////        
//        // Check if the wanted Profile exists after we open Users: 
//        robot.clickOn("#Users");
//        checkResult(robot, "Users", "#allUsersTitle");
//        robot.clickOn("Person Robin");
//        checkResult(robot, "Robin", "#title");
//        checkResult(robot, "GreatestActor", "#description");
//        robot.clickOn("#Users");
//        checkResult(robot, "Users", "#allUsersTitle");
//        robot.clickOn("Person Ken Miles");
//        checkResult(robot, "Ken Miles", "#title");
//        checkResult(robot, "Best Driver", "#description");
//        robot.clickOn("#Users");
//        checkResult(robot, "Users", "#allUsersTitle");
//        robot.clickOn("Person Sundar222");
//        checkResult(robot, "Sundar222", "#title");
//        checkResult(robot, "CEO", "#description");
//        
//        
//        // Check if the wanted Skill exists after we open Skill
//        robot.clickOn("#Skills");
//        checkResult(robot, "Skills", "#allSkillsTitle");
//        robot.clickOn("Skill: Cloud Computing");
//        checkResult(robot, "Cloud Computing", "#title");
//        
//        robot.clickOn("#Skills");
//        checkResult(robot, "Skills", "#allSkillsTitle");
//        robot.clickOn("Skill: Spring MVC");
//        checkResult(robot, "Spring MVC", "#title");
//        
//        robot.clickOn("#Skills");
//        checkResult(robot, "Skills", "#allSkillsTitle");
//        robot.clickOn("Skill: MERN");
//        checkResult(robot, "MERN", "#title");
//        
//        robot.clickOn("#Posts");
//        checkResult(robot, "Posts", "#allPostsTitle");
//        robot.clickOn("Post: Have fun in life");
//        checkResult(robot, "Have fun in life", "#title");
//        checkResult(robot, "BODY", "#description");
////        
//        robot.clickOn("#Posts");
//        checkResult(robot, "Posts", "#allPostsTitle");
//        robot.clickOn("Post: SWE Job Article");
//        checkResult(robot, "SWE Job Article", "#title");
//        checkResult(robot, "BODY", "#description");
////        
//        
		Skill cloudComputing = client.getSkill("Skill/1").data();
		Skill springMVC = client.getSkill("Skill/2").data();
		Skill mern = client.getSkill("Skill/3").data();
		Person sundar = client.getPerson("Person/12").data();
		Person Robin = client.getPerson("Person/5").data();
		Person Ken = client.getPerson("Person/6").data();
		Employer Netflix = client.getEmployer("Employer/8").data();
		Job NetflixJob1 = client.getJob("Job/9").data();
		Job NetflixJob2 = client.getJob("Job/10").data();
		Job NetflixJob3 = client.getJob("Job/11").data();
		Job SWE = client.getJob("Job/13").data();
		Post post1 = client.getPost("Post/7").data();
		Post post2 = client.getPost("Post/14").data();
//        
//        robot.clickOn("#Profile");
//        robot.clickOn("#job"); // Check is empty
//        ObservableList <Page> relatedJobs = getListView(robot, "#allPagesList").getItems();
//        assertTrue(relatedJobs.isEmpty());
//        robot.clickOn("#Profile");
//        robot.clickOn("#skill");
//        ObservableList <Page> relatedSkills = getListView(robot, "#allPagesList").getItems();
//        assertTrue(relatedSkills.contains(cloudComputing));
//        assertTrue(relatedSkills.contains(springMVC));
//        assertTrue(relatedSkills.contains(mern));
////        
//        robot.clickOn("#Profile");
//        robot.clickOn("#employer");
//        ObservableList <Page> relatedEmployers =  getListView(robot, "#allPagesList").getItems();
//        assertTrue(relatedEmployers.isEmpty());
//        robot.clickOn("#Profile");
//        robot.clickOn("#post");
//        ObservableList <Page> relatedPosts =  getListView(robot, "#allPagesList").getItems();
//        assertTrue(relatedPosts.isEmpty());
//        robot.clickOn("#Profile");
//        robot.clickOn("#user");
//        ObservableList <Page> relatedUsers =  getListView(robot, "#allPagesList").getItems();
//        assertTrue(relatedUsers.isEmpty());
//        
//        //Check Related Pages of Jobs
//        robot.clickOn("#Jobs");
//        robot.clickOn("Job: SWE Associate");
//        robot.clickOn("#skill");
//        ObservableList <Page> relatedSkills_J = getListView(robot, "#allPagesList").getItems();
//        assertTrue(relatedSkills_J.contains(springMVC));
//        robot.clickOn("#Jobs");
//        robot.clickOn("Job: SWE Associate");
//        robot.clickOn("#person");
//        ObservableList <Page> relatedUsers_J =  getListView(robot, "#allPagesList").getItems();
//        assertTrue(relatedUsers_J.isEmpty());
//        robot.clickOn("#Jobs");
//        robot.clickOn("Job: SWE Associate");
//        robot.clickOn("#employer");
//        ObservableList <Page> relatedEmployers_J =  getListView(robot, "#allPagesList").getItems();
//        assertTrue(relatedEmployers_J.contains(Netflix));
//        robot.clickOn("#Jobs");
//        robot.clickOn("Job: SWE Associate");
//        robot.clickOn("#post");
//        ObservableList <Page> relatedPosts_J =  getListView(robot, "#allPagesList").getItems();
//        assertTrue(relatedPosts_J.isEmpty());
//        
        //Check Related Pages of Employers
//        robot.clickOn("#Employers");
//        robot.clickOn("Employer Netflix"); 
//        robot.clickOn("#job");
//        ObservableList <Page> relatedJobs_E =  getListView(robot, "#allPagesList").getItems();
//        assertTrue(relatedJobs_E.contains(NetflixJob1));
//        assertTrue(relatedJobs_E.contains(NetflixJob2));
//        assertTrue(relatedJobs_E.contains(NetflixJob3));
//        robot.clickOn("#Employers");
//        robot.clickOn("Employer Netflix");
//        robot.clickOn("#post");
//        ObservableList <Page> relatedPosts_E =  getListView(robot, "#allPagesList").getItems();
//
////        assertTrue(relatedPosts_E.contains(NetflixJob1));
////        assertTrue(relatedPosts_E.contains(NetflixJob2));
////        assertTrue(relatedPosts_E.contains(NetflixJob3));
//        robot.clickOn("#Employers");
//        robot.clickOn("Employer Netflix");
//        robot.clickOn("#skill");
//        ObservableList <Page> relatedSkills_E =  getListView(robot, "#allPagesList").getItems();
//        assertTrue(relatedSkills_E.isEmpty());
//        robot.clickOn("#Employers");
//        robot.clickOn("Employer Netflix");
//        robot.clickOn("#person");
//        ObservableList <Page> relatedPerson_E =  getListView(robot, "#allPagesList").getItems();
//        assertTrue(relatedPerson_E.isEmpty());
////        
//        
//        //Check Related Pages of skills
//        robot.clickOn("#Skills"); 
//        robot.clickOn("Skill: MERN");
//        robot.clickOn("#job");
//        ObservableList <Page> relatedJob_S =  getListView(robot, "#allPagesList").getItems();
//        assertTrue(relatedJob_S.contains(NetflixJob3));
//        assertTrue(relatedJob_S.contains(NetflixJob1));
//        robot.clickOn("#Skills");
//        robot.clickOn("Skill: MERN");
//        robot.clickOn("#employer");
//        ObservableList <Page> relatedEmployer_S =  getListView(robot, "#allPagesList").getItems();
//        assertTrue(relatedEmployer_S.isEmpty());
//        robot.clickOn("#Skills");
//        robot.clickOn("Skill: MERN");
//        robot.clickOn("#person");
//        ObservableList <Page> relatedPerson_S =  getListView(robot, "#allPagesList").getItems();
//        assertTrue(relatedPerson_S.contains(Robin));
//        robot.clickOn("#Skills");
//        robot.clickOn("Skill: MERN");
//        robot.clickOn("#post");
//        ObservableList <Page> relatedPost_S =  getListView(robot, "#allPagesList").getItems();
//        assertTrue(relatedPost_S.isEmpty());
//        
//        robot.clickOn("#Posts");
//        robot.clickOn("Post: SWE Job Article");
//        robot.clickOn("#job");
//        ObservableList <Page> relatedJob_P =  getListView(robot, "#allPagesList").getItems();
//        assertTrue(relatedJob_P.isEmpty());
//        robot.clickOn("#Posts");
//        robot.clickOn("Post: SWE Job Article");
//        robot.clickOn("#skill");
//        ObservableList <Page> relatedSkill_P =  getListView(robot, "#allPagesList").getItems();
//        assertTrue(relatedSkill_P.isEmpty());
//        robot.clickOn("#Posts");
//        robot.clickOn("Post: SWE Job Article");
//        robot.clickOn("#person");
//        ObservableList <Page> relatedPerson_P=  getListView(robot, "#allPagesList").getItems();
//        System.out.println(relatedPerson_P);
//        assertTrue(relatedPerson_P.contains(sundar)); 
//        robot.clickOn("#Posts");
//        robot.clickOn("Post: SWE Job Article");
//        robot.clickOn("#employer");
//        ObservableList <Page> relatedEmployer_P =  getListView(robot, "#allPagesList").getItems();
//        assertTrue(relatedEmployer_P.isEmpty());
//        
//        
//        //Addlinks Test
//        //Profile
//		robot.clickOn("#Profile");
//        robot.clickOn("#edit");
//        
//        robot.clickOn("#addJob");
//        robot.clickOn("Job: SWE Senior");
//        robot.clickOn("#Profile");
//        robot.clickOn("#job");
//        ObservableList <Page> pa_relatedJobs = getListView(robot, "#allPagesList").getItems();
//        assertTrue(pa_relatedJobs.contains(NetflixJob1));
//        robot.clickOn("#Profile");
//        
//        robot.clickOn("#edit");
//        robot.clickOn("#addSkill");
//        robot.clickOn("Skill: MERN");
//        robot.clickOn("#Profile");
//        robot.clickOn("#skill");
//        ObservableList <Page> pa_relatedSkills = getListView(robot, "#allPagesList").getItems();
//        assertTrue(pa_relatedSkills.contains(mern));
//        robot.clickOn("#Profile");
//        
//        robot.clickOn("#edit");
//        robot.clickOn("#addEmployer");
//        robot.clickOn("Employer Netflix");
//        robot.clickOn("#Profile");
//        robot.clickOn("#employer");
//        ObservableList <Page> pa_relatedEmployers = getListView(robot, "#allPagesList").getItems();
//        assertTrue(pa_relatedEmployers.contains(Netflix));
//        robot.clickOn("#Profile");
//        
//        robot.clickOn("#edit");
//        robot.clickOn("#addPost");
//        robot.clickOn("Post: Have fun in life");
//        robot.clickOn("#Profile");
//        robot.clickOn("#post");
//        ObservableList <Page> pa_relatedPosts= getListView(robot, "#allPagesList").getItems();
//        assertTrue(pa_relatedPosts.contains(post1));
//        robot.clickOn("#Profile");
//        
//        robot.clickOn("#edit");
//        robot.clickOn("#addUser");
//        robot.clickOn("Person Ken Miles");
//        robot.clickOn("#Profile");
//        robot.clickOn("#user");
//        ObservableList <Page> pa_relatedPersons= getListView(robot, "#allPagesList").getItems();
//        assertTrue(pa_relatedPersons.contains(Ken));
//        robot.clickOn("#Profile");
//        
//        
//        //Add Links Skill
//        robot.clickOn("#Skills");
//        
//        robot.clickOn("Skill: MERN");
//        robot.clickOn("#edit");
//        robot.clickOn("#addJob");
//        robot.clickOn("Job: SWE Principal");
//        robot.clickOn("#Skills");
//        robot.clickOn("Skill: MERN");
//        robot.clickOn("#job");
//        ObservableList <Page> sa_relatedJobs = getListView(robot, "#allPagesList").getItems();
//        System.out.println(sa_relatedJobs);
//        assertTrue(sa_relatedJobs.contains(NetflixJob3));
//        robot.clickOn("#Skills");
//        
//        robot.clickOn("Skill: MERN");
//        robot.clickOn("#edit");
//        robot.clickOn("#addEmployer");
//        robot.clickOn("Employer Netflix");
//        robot.clickOn("#Skills");
//        robot.clickOn("Skill: MERN");
//        robot.clickOn("#employer");
//        ObservableList <Page> sa_relatedEmployer = getListView(robot, "#allPagesList").getItems();
//        assertTrue(sa_relatedEmployer.contains(Netflix));
//        robot.clickOn("#Skills");
//        
//        robot.clickOn("Skill: MERN");
//        robot.clickOn("#edit");
//        robot.clickOn("#addPost");
//        robot.clickOn("Post: SWE Job Article");
//        robot.clickOn("#Skills");
//        robot.clickOn("Skill: MERN");
//        robot.clickOn("#post");
//        ObservableList <Page> sa_relatedPost = getListView(robot, "#allPagesList").getItems();
//        assertTrue(sa_relatedPost.contains(post2));
//        robot.clickOn("#Skills");
//        
//        robot.clickOn("Skill: MERN");
//        robot.clickOn("#edit");
//        robot.clickOn("#addUser");
//        robot.clickOn("Person Sundar222");
//        robot.clickOn("#Skills");
//        robot.clickOn("Skill: MERN");
//        robot.clickOn("#person");
//        ObservableList <Page> sa_relatedPerson = getListView(robot, "#allPagesList").getItems();
//        assertTrue(sa_relatedPerson.contains(sundar));
//        robot.clickOn("#Skills");
//        
//        
//        robot.clickOn("#Profile");
//        robot.clickOn("#signOut");
//        
        enterInfo(robot, "careers@netflix.com", "#email");
        enterInfo(robot, "No Sharing", "#password");
        robot.clickOn("#loginButton");
		
//		  robot.clickOn("#Profile");
//		  robot.clickOn("#edit");
//	      enterInfo(robot, "Netflix Streaming", "#titleText");
//	      enterInfoTextArea(robot, "Good Movies", "#descriptionText");
//	       
//	      robot.clickOn("#save");
//	      
//	      checkResult(robot, "Netflix Streaming", "#title"); // Check if the title is set to "Robin Williams" after the change
//	      checkResult(robot, "Good Movies", "#description"); // Check if the description is "The Greatest Actor"
//	      
	      //EditJobs
	      robot.clickOn("#Jobs");
		  robot.clickOn("Job: SWE Senior");
	      robot.clickOn("#edit");
	      enterInfo(robot, "Senior SWE", "#titleText");
	      enterInfoTextArea(robot, "Apply", "#descriptionText");
	       
	      robot.clickOn("#save");
	      
	      checkResult(robot, "Senior SWE", "#title"); // Check if the title is set to "Robin Williams" after the change
	      checkResult(robot, "Apply", "#description"); // Check if the description is "The Greatest Actor"
	      
      //Profile
//	  robot.clickOn("#Profile");
//      robot.clickOn("#edit");
//      
//      robot.clickOn("#addJob");
//      robot.clickOn("Job: SWE Senior");
//      robot.clickOn("#Profile");
//      robot.clickOn("#job");
//      ObservableList <Page> ea_relatedJobs = getListView(robot, "#allPagesList").getItems();
//      assertTrue(ea_relatedJobs.contains(NetflixJob1));
//      robot.clickOn("#Profile");
//      
//      robot.clickOn("#edit");
//      robot.clickOn("#addSkill");
//      robot.clickOn("Skill: MERN");
//      robot.clickOn("#Profile");
//      robot.clickOn("#skill");
//      ObservableList <Page> ea_relatedSkills = getListView(robot, "#allPagesList").getItems();
//      assertTrue(ea_relatedSkills.contains(mern));
//      robot.clickOn("#Profile");
//      
//      robot.clickOn("#edit");
//      robot.clickOn("#addPost");
//      robot.clickOn("Post: Have fun in life");
//      robot.clickOn("#Profile");
//      robot.clickOn("#post");
//      ObservableList <Page> ea_relatedPosts= getListView(robot, "#allPagesList").getItems();
//      assertTrue(ea_relatedPosts.contains(post1));
//      robot.clickOn("#Profile");
//      
//      robot.clickOn("#edit");
//      robot.clickOn("#addUser");
//      robot.clickOn("Person Ken Miles");
//      robot.clickOn("#Profile");
//      robot.clickOn("#person");
//      ObservableList <Page> ea_relatedPersons= getListView(robot, "#allPagesList").getItems();
//      assertTrue(ea_relatedPersons.contains(Ken));
//      robot.clickOn("#Profile");
	  
//	  	robot.clickOn("#Jobs");
//	  	robot.clickOn("Job: SWE Senior");
//	  	robot.clickOn("#edit");
//	  	robot.clickOn("#addSkill");
//	  	robot.clickOn("Skill: MERN");
//	  	robot.clickOn("#Jobs");
//	  	robot.clickOn("Job: SWE Senior");
//	  	robot.clickOn("#skill");
//      ObservableList <Page> ja_relatedSkills= getListView(robot, "#allPagesList").getItems();
//      assertTrue(ja_relatedSkills.contains(mern));
//      
//	  	robot.clickOn("#Jobs");
//	  	robot.clickOn("Job: SWE Senior");
//	  	robot.clickOn("#edit");
//	  	robot.clickOn("#addEmployer");
//	  	robot.clickOn("Employer Netflix");
//	  	robot.clickOn("#Jobs");
//	  	robot.clickOn("Job: SWE Senior");
//	  	robot.clickOn("#employer");
//	    ObservableList <Page> ja_relatedEmployers= getListView(robot, "#allPagesList").getItems();
//	    assertTrue(ja_relatedEmployers.contains(Netflix));
//	    
//	    robot.clickOn("#Jobs");
//	  	robot.clickOn("Job: SWE Senior");
//	  	robot.clickOn("#edit");
//	  	robot.clickOn("#addUser");
//	  	robot.clickOn("Person Ken Miles");
//	  	robot.clickOn("#Jobs");
//	  	robot.clickOn("Job: SWE Senior");
//	  	robot.clickOn("#person");
//	    ObservableList <Page> ja_relatedPersons= getListView(robot, "#allPagesList").getItems();
//	    assertTrue(ja_relatedPersons.contains(Ken));
//	    
//	    robot.clickOn("#Jobs");
//	  	robot.clickOn("Job: SWE Senior");
//	  	robot.clickOn("#edit");
//	  	robot.clickOn("#addPost");
//	  	robot.clickOn("Post: Have fun in life");
//	  	robot.clickOn("#Jobs");
//	  	robot.clickOn("Job: SWE Senior");
//	  	robot.clickOn("#post");
//	    ObservableList <Page> ja_relatedPosts= getListView(robot, "#allPagesList").getItems();
//	    assertTrue(ja_relatedPosts.contains(post1));
	  	
	  	robot.clickOn("#Profile");
	  	robot.clickOn("#signOut");
		enterInfo(robot, "Miles@Ford.com", "#email");
        enterInfo(robot, "FordIsBest", "#password");
        robot.clickOn("#loginButton");
        
//        robot.clickOn("#addUser");
//        robot.clickOn("Person Sundar222");
//        robot.clickOn("#Profile");
//        robot.clickOn("#Posts");
//        robot.clickOn("Post: Have fun in life");
//        robot.clickOn("#edit");
//        robot.clickOn("#addSkill");
//        robot.clickOn("Skill: MERN");
//        robot.clickOn("#Posts");
//        robot.clickOn("Post: Have fun in life");
//        robot.clickOn("#skill");
//        ObservableList <Page> pa_relatedSkills= getListView(robot, "#allPagesList").getItems();
//	    assertTrue(pa_relatedSkills.contains(mern));
//	    
//	    robot.clickOn("#Posts");
//        robot.clickOn("Post: Have fun in life");
//        robot.clickOn("#edit");
//        robot.clickOn("#addJob");
//        robot.clickOn("Job: SWE Senior");
//        robot.clickOn("#Posts");
//        robot.clickOn("Post: Have fun in life");
//        robot.clickOn("#job");
//        ObservableList <Page> pa_relatedJobs= getListView(robot, "#allPagesList").getItems();
//	    assertTrue(pa_relatedJobs.contains(NetflixJob1));
//	    robot.clickOn("#Post");
//	    
//	    
//        robot.clickOn("Post: Have fun in life");
//        robot.clickOn("#edit");
//        robot.clickOn("#addPerson");
//        robot.clickOn("Person Sundar222");
//        robot.clickOn("#Posts");
//        robot.clickOn("Post: Have fun in life");
//        robot.clickOn("#job");
//        ObservableList <Page> pa_relatedPersons= getListView(robot, "#allPagesList").getItems();
//	    assertTrue(pa_relatedPersons.contains(sundar));
//	    robot.clickOn("#Posts");
//	    
//        robot.clickOn("Post: Have fun in life");
//        robot.clickOn("#edit");
//        robot.clickOn("#addEmployer");
//        robot.clickOn("Employer Netflix");
//        robot.clickOn("#Post");
//        robot.clickOn("Post: Have fun in life");
//        robot.clickOn("#job");
//        ObservableList <Page> pa_relatedEmployers= getListView(robot, "#allPagesList").getItems();
//	    assertTrue(pa_relatedEmployers.contains(Netflix));
//	    robot.clickOn("#Posts");
	    
        // Post Edit
        robot.clickOn("#Posts");
	    robot.clickOn("Post: Have fun in life");
        robot.clickOn("#edit");
	      enterInfo(robot, "Have more fun", "#titleText");
	      enterInfoTextArea(robot, "My post Body", "#descriptionText");
	       
	      robot.clickOn("#save");
	      
	      checkResult(robot, "Have more fun", "#title"); // Check if the title is set to "Robin Williams" after the change
	      checkResult(robot, "My post Body", "#description"); // Check if the description is "The Greatest Actor"
      
        
        
        
        
        robot.clickOn("#user");
        
//        ObservableList <Page> relatedUsers =  getListView(robot, "#allPagesList").getItems();
//        assertTrue(relatedUsers.contains(sundar));
        
        
        //Check if signout Button works. 
//        robot.clickOn("#signOut"); // Assert signout works and there are no permissions. 
        
        
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
//        System.out.print(loggedIn);
//        assertThat(loggedIn.g)
    }
}
