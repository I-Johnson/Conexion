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
import org.springframework.http.MediaType;
import org.springframework.web.client.RestClient;
import org.testfx.framework.junit5.ApplicationExtension;
import org.testfx.framework.junit5.Start;
import org.testfx.api.FxRobot;
import org.testfx.assertions.api.Assertions;
import org.testfx.util.WaitForAsyncUtils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

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
	RestMain restmain = RestMain.getInstance();
	IDGenerator idGenerator = IDGenerator.getInstance();
	public Skill cloudComputing;
	public Skill springMVC;
	public Skill mern;
	public Skill someSkill;
	 
	public Person Ken;
	public Person Robin;
	public Person sundar;
	
	public Employer Netflix;
	
	public Job SWEAssociate_Job;
	
	public Post SWESenior_Job_Article;
	
	public Post SWE_Principles_Post;
	
	public Job NetflixJob1;
	public Job NetflixJob2;
	public Job NetflixJob3; 
    public PageCounter contedorDePaginas;
    ViewTransitionalModel vm;

    @Start
    private void start(Stage stage) {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(Main.class.getResource("/Views/navBar.fxml"));
        BorderPane view;
        try {
            view = loader.load();
            MainController cont = loader.getController();
            vm = new ViewTransitionalModel(view);
            vm.changetoLoginView();
            cont.setModel(vm);
            Scene s = new Scene(view);
            stage.setScene(s);
            stage.show(); 
        } catch (IOException e) {
            e.printStackTrace();  
        }
    }
    
    public void prepopulate() {
    	restmain.clearCache();
    	restmain.makeDesc();
    	restmain.makeClass("Page"); // /page
    	restmain.makeClass("Post"); // /posts
    	restmain.makeClass("Skill"); // /skill
    	restmain.makeClass("User"); // /user
    	restmain.makeClass("Person");// /person 
    	restmain.makeClass("Employer"); // /employer
    	restmain.makeClass("Job"); // /job
    	restmain.makeClass("pageCounter");
	     
	     RestClient client = RestClient.create();
	     
	     PageCounter contedorDePaginasTest = new PageCounter();

	     String contedorDePaginasTestJson;
	     ObjectMapper objectMapper = new ObjectMapper();
	     try {
				contedorDePaginasTestJson = objectMapper.writeValueAsString(contedorDePaginasTest);
				@SuppressWarnings("unused")
				String response = client.post()
						.uri("http://localhost:9000/v1/Conexion/pageCounter/1")
						.contentType(MediaType.APPLICATION_JSON)
						.body(contedorDePaginasTestJson)
						.retrieve()
						.body(String.class);
//				System.out.println(response);
				
			} catch (JsonProcessingException e) { 
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	     cloudComputing = new Skill(idGenerator, "Cloud Computing");
			springMVC = new Skill(idGenerator, "Spring MVC");
			mern = new Skill(idGenerator, "MERN");
			someSkill = new Skill(idGenerator, "SomeSkill");
			
			Robin = new Person(idGenerator, "Robin", "Williams", "robin@princeton.edu", "GreatestActor", 4, 
					"Masters", "PrincetonU", "Computer Science");
			
			Robin.addSkill(cloudComputing);
			Robin.addSkill(mern);
			Robin.addSkill(springMVC);			
			
			
			Ken = new Person(idGenerator, "Ken Miles", "FordIsBest", "Miles@ford.com", "Best Driver", 1, 
			"Bachelors", "Centre University", "Computer Science");

			Ken.getSkills().add(springMVC.getPageID());
			Ken.addSkill(cloudComputing);
			
			SWESenior_Job_Article = Ken.post("Have fun in life", "March 31", "BODY");
			
			
			Netflix = new Employer(idGenerator, "Netflix", "No Sharing", "careers@netflix.com", "Finest Software Engineering", "Headquarters");
						
			NetflixJob1 = Netflix.postJob(3, "Masters", "Computer Science", "SWE Senior", "April1", "job Description");
			NetflixJob1.addSkill(cloudComputing);
			NetflixJob1.addSkill(mern);
			NetflixJob1.addSkill(springMVC);
			Netflix.addJob(NetflixJob1);
			
			
			NetflixJob2 = Netflix.postJob(1, "Bachelors", "Computer Science", "SWE Associate", "May 20", "job Description");
			NetflixJob2.addSkill(springMVC);
			Netflix.addJob(NetflixJob2);
			
			NetflixJob3 = Netflix.postJob(4, "Masters", "Computer Science", "SWE Principal", "April 18", "job Description");
			NetflixJob3.addSkill(cloudComputing);
			NetflixJob3.addSkill(mern);
			Netflix.addJob(NetflixJob3);
			cloudComputing.addPost(SWESenior_Job_Article);
			// do it
			sundar = new Person(idGenerator, "Sundar222", "sundar@google.com", "1234", "CEO", 21, "Centre College", "Masters", "Computer Science");

			 //Job
			 SWEAssociate_Job  = Netflix.postJob(2, "Bachelors", "Computer Science", "Software Engineering Associate", "May 11", "Job Desc");
			 SWE_Principles_Post = Netflix.post("SWE Job Article", "March 31", "BODY");
					 
			 restmain.addPage(mern);
			 restmain.addPage(SWESenior_Job_Article);
			 restmain.addPage(sundar); 
			 restmain.addPage(Netflix);
			 restmain.addPage(SWEAssociate_Job);
			 restmain.addPage(SWE_Principles_Post);
			 restmain.addPage(Ken);
			 restmain.addPage(Robin);
			 restmain.addPage(springMVC);
			 restmain.addPage(NetflixJob1);
			 restmain.addPage(NetflixJob2);
			restmain.addPage(NetflixJob3);
			restmain.addPage(SWEAssociate_Job);
			restmain.addPage(cloudComputing);
			restmain.updatePage(Robin);
			restmain.updatePage(NetflixJob1);
			restmain.updatePage(SWEAssociate_Job);
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
    	prepopulate();

		cloudComputing = restmain.getSkill("Skill/1").data();
		springMVC = restmain.getSkill("Skill/2").data();
		mern = restmain.getSkill("Skill/3").data();
		sundar = restmain.getPerson("Person/12").data();
		Robin = restmain.getPerson("Person/5").data();
		Ken = restmain.getPerson("Person/6").data();
		Netflix = restmain.getEmployer("Employer/8").data();
		NetflixJob1 = restmain.getJob("Job/9").data();
		NetflixJob2 = restmain.getJob("Job/10").data();
		NetflixJob3 = restmain.getJob("Job/11").data();
		Job SWE = restmain.getJob("Job/13").data();
		Post post1 = restmain.getPost("Post/7").data(); 
		Post post2 = restmain.getPost("Post/14").data();

        
        
    	//login as user
      enterInfo(robot, "robin@princeton.edu", "#email");
      enterInfo(robot, "Williams", "#password");
      robot.clickOn("#loginButton");
      try {
          Thread.sleep(1000);
      } catch (InterruptedException e) {
          e.printStackTrace();
      }
//        // Test Navbar by clicking and asserting if we go to the place we want. 
        robot.clickOn("#Jobs");
        checkResult(robot, "Job Openings", "#allPagesTitle");
        robot.clickOn("#Employers");
        checkResult(robot, "Employers", "#allEmployersTitle");
        robot.clickOn("Users");
        checkResult(robot, "Users", "#allUsersTitle");
        robot.clickOn("Skills");
        checkResult(robot, "Skills", "#allSkillsTitle");
        robot.clickOn("Posts");
        checkResult(robot, "Posts", "#allPostsTitle");
        robot.clickOn("#Profile");
       
        
        
        //Check if the wanted job exists after we open Jobs
        robot.clickOn("#Jobs");
        checkResult(robot, "Job Openings", "#allPagesTitle");
        robot.clickOn("Job: SWE Senior");
        checkResult(robot, "SWE Senior", "#title");
        checkResult(robot, "job Description", "#description");
        
        robot.clickOn("#Jobs");
        checkResult(robot, "Job Openings", "#allPagesTitle");
        robot.clickOn("Job: SWE Associate");
        checkResult(robot, "SWE Associate", "#title");
        checkResult(robot, "job Description", "#description");
        robot.clickOn("#Jobs");
        checkResult(robot, "Job Openings", "#allPagesTitle");
        robot.clickOn("Job: SWE Principal");
        checkResult(robot, "SWE Principal", "#title");
        checkResult(robot, "job Description", "#description");
        robot.clickOn("#Jobs");
        checkResult(robot, "Job Openings", "#allPagesTitle");
        robot.clickOn("Job: Software Engineering Associate");
        checkResult(robot, "Software Engineering Associate", "#title");
        checkResult(robot, "Job Desc", "#description");
        
        robot.clickOn("#Profile");
        
        //Check if the wanted employer exists after we open Employer
        robot.clickOn("#Employers");
        checkResult(robot, "Employers", "#allEmployersTitle");
        robot.clickOn("Employer Netflix");
        checkResult(robot, "Netflix", "#title");
        checkResult(robot, "Finest Software Engineering", "#description");
//        
        // Check if the wanted Profile exists after we open Users: 
        robot.clickOn("#Users");
        checkResult(robot, "Users", "#allUsersTitle");
        robot.clickOn("Person Robin");
        checkResult(robot, "Robin", "#title");
        checkResult(robot, "GreatestActor", "#description");
        robot.clickOn("#Users");
        checkResult(robot, "Users", "#allUsersTitle");
        robot.clickOn("Person Ken Miles");
        checkResult(robot, "Ken Miles", "#title");
        checkResult(robot, "Best Driver", "#description");
        robot.clickOn("#Users");
        checkResult(robot, "Users", "#allUsersTitle");
        robot.clickOn("Person Sundar222");
        checkResult(robot, "Sundar222", "#title");
        checkResult(robot, "CEO", "#description");
        
        
        // Check if the wanted Skill exists after we open Skill
        robot.clickOn("#Skills");
        checkResult(robot, "Skills", "#allSkillsTitle");
        robot.clickOn("Skill: Cloud Computing");
        checkResult(robot, "Cloud Computing", "#title");
        
        robot.clickOn("#Skills");
        checkResult(robot, "Skills", "#allSkillsTitle");
        robot.clickOn("Skill: Spring MVC");
        checkResult(robot, "Spring MVC", "#title");
        
        robot.clickOn("#Skills");
        checkResult(robot, "Skills", "#allSkillsTitle");
        robot.clickOn("Skill: MERN");
        checkResult(robot, "MERN", "#title");
        
        robot.clickOn("#Posts");
        checkResult(robot, "Posts", "#allPostsTitle");
        robot.clickOn("Post: Have fun in life");
        checkResult(robot, "Have fun in life", "#title");
        checkResult(robot, "BODY", "#description");
//        
        robot.clickOn("#Posts");
        checkResult(robot, "Posts", "#allPostsTitle");
        robot.clickOn("Post: SWE Job Article");
        checkResult(robot, "SWE Job Article", "#title");
        checkResult(robot, "BODY", "#description");

        robot.clickOn("#Profile");
        robot.clickOn("#job"); // Check is empty
        ObservableList <Page> relatedJobs = getListView(robot, "#allPagesList").getItems();
        assertTrue(relatedJobs.isEmpty());
        robot.clickOn("#Profile");
        robot.clickOn("#skill");
        ObservableList <Page> relatedSkills = getListView(robot, "#allPagesList").getItems();
        assertTrue(relatedSkills.contains(cloudComputing));
        assertTrue(relatedSkills.contains(springMVC));
        assertTrue(relatedSkills.contains(mern));
//        
        robot.clickOn("#Profile");
        robot.clickOn("#employer");
        ObservableList <Page> relatedEmployers =  getListView(robot, "#allPagesList").getItems();
        assertTrue(relatedEmployers.isEmpty());
        robot.clickOn("#Profile");
        robot.clickOn("#post");
        ObservableList <Page> relatedPosts =  getListView(robot, "#allPagesList").getItems();
        assertTrue(relatedPosts.isEmpty());
        robot.clickOn("#Profile");
        robot.clickOn("#user");
        ObservableList <Page> relatedUsers =  getListView(robot, "#allPagesList").getItems();
        assertTrue(relatedUsers.isEmpty());
//        
        //Check Related Pages of Jobs
        robot.clickOn("#Jobs");
        robot.clickOn("Job: SWE Associate");
        robot.clickOn("#skill");
        ObservableList <Page> relatedSkills_J = getListView(robot, "#allPagesList").getItems();
        assertTrue(relatedSkills_J.contains(springMVC));
        robot.clickOn("#Jobs");
        robot.clickOn("Job: SWE Associate");
        robot.clickOn("#person");
        ObservableList <Page> relatedUsers_J =  getListView(robot, "#allPagesList").getItems();
        assertTrue(relatedUsers_J.isEmpty());
        robot.clickOn("#Jobs");
        robot.clickOn("Job: SWE Associate");
        robot.clickOn("#employer");
        ObservableList <Page> relatedEmployers_J =  getListView(robot, "#allPagesList").getItems();
        assertTrue(relatedEmployers_J.contains(Netflix));
        robot.clickOn("#Jobs");
        robot.clickOn("Job: SWE Associate");
        robot.clickOn("#post");
        ObservableList <Page> relatedPosts_J =  getListView(robot, "#allPagesList").getItems();
        assertTrue(relatedPosts_J.isEmpty());
//        
        //Check Related Pages of Employers
        robot.clickOn("#Employers");
        robot.clickOn("Employer Netflix"); 
        robot.clickOn("#job");
        ObservableList <Page> relatedJobs_E =  getListView(robot, "#allPagesList").getItems();
        assertTrue(relatedJobs_E.contains(NetflixJob1));
        assertTrue(relatedJobs_E.contains(NetflixJob2));
        assertTrue(relatedJobs_E.contains(NetflixJob3));
        robot.clickOn("#Employers");
        robot.clickOn("Employer Netflix");
        robot.clickOn("#post");
        ObservableList <Page> relatedPosts_E =  getListView(robot, "#allPagesList").getItems();

//        assertTrue(relatedPosts_E.contains(NetflixJob1));
//        assertTrue(relatedPosts_E.contains(NetflixJob2));
//        assertTrue(relatedPosts_E.contains(NetflixJob3));
        robot.clickOn("#Employers");
        robot.clickOn("Employer Netflix");
        robot.clickOn("#skill");
        ObservableList <Page> relatedSkills_E =  getListView(robot, "#allPagesList").getItems();
        assertTrue(relatedSkills_E.isEmpty());
        robot.clickOn("#Employers");
        robot.clickOn("Employer Netflix");
        robot.clickOn("#person");
        ObservableList <Page> relatedPerson_E =  getListView(robot, "#allPagesList").getItems();
        assertTrue(relatedPerson_E.isEmpty());
//        
        
        //Check Related Pages of skills
        robot.clickOn("#Skills"); 
        robot.clickOn("Skill: MERN");
        robot.clickOn("#job");
        ObservableList <Page> relatedJob_S =  getListView(robot, "#allPagesList").getItems();
        assertTrue(relatedJob_S.contains(NetflixJob3));
        assertTrue(relatedJob_S.contains(NetflixJob1));
        robot.clickOn("#Skills");
        robot.clickOn("Skill: MERN");
        robot.clickOn("#employer");
        ObservableList <Page> relatedEmployer_S =  getListView(robot, "#allPagesList").getItems();
        assertTrue(relatedEmployer_S.isEmpty());
        robot.clickOn("#Skills");
        robot.clickOn("Skill: MERN");
        robot.clickOn("#person");
        ObservableList <Page> relatedPerson_S =  getListView(robot, "#allPagesList").getItems();
        assertTrue(relatedPerson_S.contains(Robin));
        robot.clickOn("#Skills");
        robot.clickOn("Skill: MERN");
        robot.clickOn("#post");
        ObservableList <Page> relatedPost_S =  getListView(robot, "#allPagesList").getItems();
        assertTrue(relatedPost_S.isEmpty());
        
        robot.clickOn("#Posts");
        robot.clickOn("Post: SWE Job Article");
        robot.clickOn("#job");
        ObservableList <Page> relatedJob_P =  getListView(robot, "#allPagesList").getItems();
        assertTrue(relatedJob_P.isEmpty());
        robot.clickOn("#Posts");
        robot.clickOn("Post: SWE Job Article");
        robot.clickOn("#skill");
        ObservableList <Page> relatedSkill_P =  getListView(robot, "#allPagesList").getItems();
        assertTrue(relatedSkill_P.isEmpty());
        robot.clickOn("#Posts");
        robot.clickOn("Post: SWE Job Article");
        robot.clickOn("#person");
        ObservableList <Page> relatedPerson_P=  getListView(robot, "#allPagesList").getItems();
        System.out.println(relatedPerson_P);
        assertTrue(relatedPerson_P.isEmpty()); 
        robot.clickOn("#Posts");
        robot.clickOn("Post: SWE Job Article");
        robot.clickOn("#employer");
        ObservableList <Page> relatedEmployer_P =  getListView(robot, "#allPagesList").getItems();
        assertTrue(relatedEmployer_P.contains(Netflix));
        
        
        //Addlinks Test
        //Profile
		robot.clickOn("#Profile");
        robot.clickOn("#edit");
        
        robot.clickOn("#addJob");
        robot.clickOn("Job: SWE Senior");
        robot.clickOn("#Profile");
        robot.clickOn("#job");
        ObservableList <Page> p_relatedJobs = getListView(robot, "#allPagesList").getItems();
        assertTrue(p_relatedJobs.contains(NetflixJob1));
        robot.clickOn("#Profile");
        
        robot.clickOn("#edit");
        robot.clickOn("#addSkill");
        robot.clickOn("Skill: MERN");
        robot.clickOn("#Profile");
        robot.clickOn("#skill");
        ObservableList <Page> p_relatedSkills = getListView(robot, "#allPagesList").getItems();
        assertTrue(p_relatedSkills.contains(mern));
        robot.clickOn("#Profile");
        
        robot.clickOn("#edit");
        robot.clickOn("#addEmployer");
        robot.clickOn("Employer Netflix");
        robot.clickOn("#Profile");
        robot.clickOn("#employer");
        ObservableList <Page> p_relatedEmployers = getListView(robot, "#allPagesList").getItems();
        assertTrue(p_relatedEmployers.contains(Netflix));
        robot.clickOn("#Profile");
        
        robot.clickOn("#edit");
        robot.clickOn("#addPost");
        robot.clickOn("Post: Have fun in life");
        robot.clickOn("#Profile");
        robot.clickOn("#post");
        ObservableList <Page> pa_relatedPosts= getListView(robot, "#allPagesList").getItems();
        assertTrue(pa_relatedPosts.contains(post1));
        robot.clickOn("#Profile");
        
        robot.clickOn("#edit");
        robot.clickOn("#addUser");
        robot.clickOn("Person Ken Miles");
        robot.clickOn("#Profile");
        robot.clickOn("#user");
        ObservableList <Page> p_relatedPersons= getListView(robot, "#allPagesList").getItems();
        assertTrue(p_relatedPersons.contains(Ken));
        robot.clickOn("#Profile");
        
        
        //Add Links Skill
        robot.clickOn("#Skills");
//        
        robot.clickOn("Skill: MERN");
        robot.clickOn("#edit");
        robot.clickOn("#addJob");
        robot.clickOn("Job: SWE Principal");
        robot.clickOn("#Skills");
        robot.clickOn("Skill: MERN");
        robot.clickOn("#job");
        ObservableList <Page> sa_relatedJobs = getListView(robot, "#allPagesList").getItems();
        System.out.println(sa_relatedJobs);
        Job swePrincipal = restmain.getJob("Job/11").data();
        assertTrue(sa_relatedJobs.contains(swePrincipal));
        
        
        robot.clickOn("#Skills");
        
        robot.clickOn("Skill: MERN");
        robot.clickOn("#edit");
        robot.clickOn("#addEmployer");
        robot.clickOn("Employer Netflix");
        robot.clickOn("#Skills");
        robot.clickOn("Skill: MERN");
        robot.clickOn("#employer");
        ObservableList <Page> sa_relatedEmployer = getListView(robot, "#allPagesList").getItems();
        Employer empNetflix = restmain.getEmployer("Employer/8").data();
        assertTrue(sa_relatedEmployer.contains(empNetflix));
        robot.clickOn("#Skills");
        
        robot.clickOn("Skill: MERN");
        robot.clickOn("#edit");
        robot.clickOn("#addPost");
        robot.clickOn("Post: SWE Job Article");
        robot.clickOn("#Skills");
        robot.clickOn("Skill: MERN");
        robot.clickOn("#post");
        ObservableList <Page> sa_relatedPost = getListView(robot, "#allPagesList").getItems();
        Post postArticle = restmain.getPost("Post/14").data();
        assertTrue(sa_relatedPost.contains(postArticle));
        robot.clickOn("#Skills");
        
        robot.clickOn("Skill: MERN");
        robot.clickOn("#edit");
        robot.clickOn("#addUser");
        robot.clickOn("Person Sundar222");
        robot.clickOn("#Skills");
        robot.clickOn("Skill: MERN");
        robot.clickOn("#person");
        ObservableList <Page> sa_relatedPerson = getListView(robot, "#allPagesList").getItems();
        Person sundae = restmain.getPerson("Person/12").data();
        assertTrue(sa_relatedPerson.contains(sundae));
        robot.clickOn("#Skills");
        
        
        robot.clickOn("#Profile");
        robot.clickOn("#signOut");

        enterInfo(robot, "careers@netflix.com", "#email");
        enterInfo(robot, "No Sharing", "#password");
        robot.clickOn("#loginButton");
		

	      
      //Profile
	  robot.clickOn("#Profile");
      robot.clickOn("#edit");
      
      robot.clickOn("#addJob");
      robot.clickOn("Job: SWE Senior");
      robot.clickOn("#Profile");
      robot.clickOn("#job");
      ObservableList <Page> ea_relatedJobs = getListView(robot, "#allPagesList").getItems();
      assertTrue(ea_relatedJobs.contains(NetflixJob1));
      robot.clickOn("#Profile");
      
      robot.clickOn("#edit");
      robot.clickOn("#addSkill");
      robot.clickOn("Skill: MERN");
      robot.clickOn("#Profile");
      robot.clickOn("#skill");
      ObservableList <Page> ea_relatedSkills = getListView(robot, "#allPagesList").getItems();
      Skill wantMern = restmain.getSkill("Skill/3").data();
      assertTrue(ea_relatedSkills.contains(wantMern));
      robot.clickOn("#Profile");
      
      robot.clickOn("#edit");
      robot.clickOn("#addPost");
      robot.clickOn("Post: Have fun in life"); 
      robot.clickOn("#Profile");
      robot.clickOn("#post");
      ObservableList <Page> ea_relatedPosts= getListView(robot, "#allPagesList").getItems();
      assertTrue(ea_relatedPosts.contains(post1));
      robot.clickOn("#Profile");
      
      robot.clickOn("#edit");
      robot.clickOn("#addUser");
      robot.clickOn("Person Ken Miles");
      robot.clickOn("#Profile");
      robot.clickOn("#person");
      ObservableList <Page> ea_relatedPersons= getListView(robot, "#allPagesList").getItems();
      assertTrue(ea_relatedPersons.contains(Ken));
      robot.clickOn("#Profile");
	  
	  	robot.clickOn("#Jobs");
	  	robot.clickOn("Job: SWE Senior");
	  	robot.clickOn("#edit");
	  	robot.clickOn("#addSkill");
	  	robot.clickOn("Skill: MERN");
	  	robot.clickOn("#Jobs");
	  	robot.clickOn("Job: SWE Senior");
	  	robot.clickOn("#skill");
      ObservableList <Page> ja_relatedSkills= getListView(robot, "#allPagesList").getItems();
      Skill mernWant = restmain.getSkill("Skill/3").data();
      assertTrue(ja_relatedSkills.contains(mernWant));
      
	  	robot.clickOn("#Jobs");
	  	robot.clickOn("Job: SWE Senior"); 
	  	robot.clickOn("#edit");
	  	robot.clickOn("#addEmployer");
	  	robot.clickOn("Employer Netflix");
	  	robot.clickOn("#Jobs");
	  	robot.clickOn("Job: SWE Senior");
	  	robot.clickOn("#employer");
	    ObservableList <Page> ja_relatedEmployers= getListView(robot, "#allPagesList").getItems(); 
	    Employer wantNetflix = restmain.getEmployer("Employer/8").data();
	    assertTrue(ja_relatedEmployers.contains(wantNetflix));
	    
	    robot.clickOn("#Jobs");
	  	robot.clickOn("Job: SWE Senior");
	  	robot.clickOn("#edit");
	  	robot.clickOn("#addUser");
	  	robot.clickOn("Person Ken Miles");
	  	robot.clickOn("#Jobs");
	  	robot.clickOn("Job: SWE Senior");
	  	robot.clickOn("#person");
	    ObservableList <Page> ja_relatedPersons= getListView(robot, "#allPagesList").getItems();
	    Person kenWant = restmain.getPerson("Person/6").data();
	    assertTrue(ja_relatedPersons.contains(kenWant));
	    
	    robot.clickOn("#Jobs");
	  	robot.clickOn("Job: SWE Senior");
	  	robot.clickOn("#edit");
	  	robot.clickOn("#addPost");
	  	robot.clickOn("Post: Have fun in life");
	  	robot.clickOn("#Jobs");
	  	robot.clickOn("Job: SWE Senior");
	  	robot.clickOn("#post");
	    ObservableList <Page> ja_relatedPosts= getListView(robot, "#allPagesList").getItems();
	    Post postWant = restmain.getPost("Post/7").data();
	    assertTrue(ja_relatedPosts.contains(postWant));
	  	
        robot.clickOn("#Posts");
        robot.clickOn("Post: SWE Job Article");
        robot.clickOn("#edit");
        robot.clickOn("#addSkill");
        robot.clickOn("Skill: Cloud Computing");
        robot.clickOn("#Posts");
        robot.clickOn("Post: SWE Job Article");
        robot.clickOn("#skill");
        ObservableList <Page> pa_relatedSkills= getListView(robot, "#allPagesList").getItems();
        System.out.println(pa_relatedSkills);
        Skill cloudSkill = restmain.getSkill("Skill/1").data();
	    assertTrue(pa_relatedSkills.contains(cloudSkill));
	    
	    robot.clickOn("#Posts");
	    robot.clickOn("Post: SWE Job Article");
        robot.clickOn("#edit");
        robot.clickOn("#addJob");
        robot.clickOn("Job: SWE Senior");
        robot.clickOn("#Posts");
        robot.clickOn("Post: SWE Job Article");
        robot.clickOn("#job");

        ObservableList <Page> pa_relatedJobs= getListView(robot, "#allPagesList").getItems();
        System.out.print(pa_relatedJobs);
        Job addedJob = restmain.getJob("Job/9").data();
	    assertTrue(pa_relatedJobs.contains(addedJob));
	    robot.clickOn("#Posts");
	    
	    
	    robot.clickOn("Post: SWE Job Article");
        robot.clickOn("#edit");
        robot.clickOn("#addUser");
        robot.clickOn("Person Sundar222");
        robot.clickOn("#Posts");
        robot.clickOn("Post: SWE Job Article");
        robot.clickOn("#person");
        
        ObservableList <Page> pa_relatedPersons= getListView(robot, "#allPagesList").getItems();
        System.out.print(pa_relatedPersons);
        Person sundar222 = restmain.getPerson("Person/12").data();
	    assertTrue(pa_relatedPersons.contains(sundar222));
	    
	    robot.clickOn("#Posts");
	    
	    robot.clickOn("Post: SWE Job Article");
        robot.clickOn("#edit");
        robot.clickOn("#addEmployer");
        robot.clickOn("Employer Netflix");
        robot.clickOn("#Posts");
        robot.clickOn("Post: SWE Job Article");
        robot.clickOn("#employer");
        ObservableList <Page> pa_relatedEmployers= getListView(robot, "#allPagesList").getItems();
        Employer addNetflix = restmain.getEmployer("Employer/8").data();
	    assertTrue(pa_relatedEmployers.contains(addNetflix));
	    robot.clickOn("#Posts");
	    
	    
	    	//Employer edit
		  robot.clickOn("#Profile");
		  robot.clickOn("#edit");
	      enterInfo(robot, "Netflix Streaming", "#titleText");
	      enterInfoTextArea(robot, "Good Movies", "#descriptionText");
	       
	      robot.clickOn("#save");
	      
	      checkResult(robot, "Netflix Streaming", "#title");  
	      checkResult(robot, "Good Movies", "#description"); 
//	      
	      //EditJobs
	      robot.clickOn("#Jobs");
		  robot.clickOn("Job: SWE Senior");
	      robot.clickOn("#edit");
	      enterInfo(robot, "Senior SWE", "#titleText");
	      enterInfoTextArea(robot, "Apply", "#descriptionText");
	       
	      robot.clickOn("#save");
	      
	      checkResult(robot, "Senior SWE", "#title"); 
	      checkResult(robot, "Apply", "#description");
	    
        // Post Edit
          robot.clickOn("#Posts");
	      robot.clickOn("Post: SWE Job Article");
          robot.clickOn("#edit");
	      enterInfo(robot, "Have more fun", "#titleText");
	      enterInfoTextArea(robot, "My post Body", "#descriptionText");
	       
	      robot.clickOn("#save");
	      
	      checkResult(robot, "Have more fun", "#title"); 
	      checkResult(robot, "My post Body", "#description");
	      
	      //Skill Edit
	      robot.clickOn("#Skills");
	      robot.clickOn("Skill: MERN");
	      robot.clickOn("#edit");
	      enterInfo(robot, "Mongo Express React, Node", "#titleText");
	      robot.clickOn("#save");
	      checkResult(robot, "Mongo Express React, Node", "#title"); 
	      
	      
	      robot.clickOn("#Profile");
	      
	      
	      robot.clickOn("#signOut");
	      
		    enterInfo(robot, "robin@princeton.edu", "#email");
		    enterInfo(robot, "Williams", "#password");
		    robot.clickOn("#loginButton");
	      
	      
	      checkResult(robot, "Robin", "#title"); // Check if the title is set to "Robin"
	      checkResult(robot, "GreatestActor", "#description"); // Check if the description is "GreatestActor"
//	      
	      robot.clickOn("#edit");
	      
	      
	      // Check if proper info is loaded
	      String name = robot.lookup("#titleText").queryAs(TextField.class).getText();
	      String description = robot.lookup("#descriptionText").queryAs(TextArea.class).getText();

	      Assertions.assertThat(name).isEqualTo("Robin");
	      Assertions.assertThat(description).isEqualTo("GreatestActor");
	      
	      //Person Edit
	      enterInfo(robot, "Robin Williams", "#titleText");
	      enterInfoTextArea(robot, "The Greatest Actor", "#descriptionText");
	       
	      robot.clickOn("#save");
	      
	      checkResult(robot, "Robin Williams", "#title"); // Check if the title is set to "Robin Williams" after the change
	      checkResult(robot, "The Greatest Actor", "#description"); // Check if the description is "The Greatest Actor"
        
        
        
//        robot.clickOn("#user");
        
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
